package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.dao.BsOrderTailorInfoMapper;
import cc.mrbird.febs.cos.dao.BsProgramInfoMapper;
import cc.mrbird.febs.cos.entity.BsOrderInfo;
import cc.mrbird.febs.cos.dao.BsOrderInfoMapper;
import cc.mrbird.febs.cos.service.IBsOrderInfoService;
import cc.mrbird.febs.cos.service.IBsProgramInfoService;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author FanK
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BsOrderInfoServiceImpl extends ServiceImpl<BsOrderInfoMapper, BsOrderInfo> implements IBsOrderInfoService {

    private final BsProgramInfoMapper programInfoMapper;

    private final BsOrderInfoMapper orderInfoMapper;

    private final BsOrderTailorInfoMapper orderTailorInfoMapper;

    /**
     * 分页获取设计订单信息
     *
     * @param page         分页对象
     * @param bsOrderInfo 设计订单信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectOrderPage(Page<BsOrderInfo> page, BsOrderInfo bsOrderInfo) {
        return baseMapper.selectOrderPage(page, bsOrderInfo);
    }

    /**
     * 查询主页展示信息
     *
     * @return 结果
     */
    @Override
    public LinkedHashMap<String, Object> selectHomeData() {
        LinkedHashMap<String, Object> result = new LinkedHashMap<String, Object>() {
            {
                put("monthOrderNum", 0);
                put("monthOrderTotal", 0);
                put("yearOrderNum", 0);
                put("yearOrderTotal", 0);

                put("programNum", 0);
                put("orderNum", 0);
                put("totalPrice", 0);
                put("totalNum", 0);
            }
        };

        // 项目数量
        int programNum = programInfoMapper.selectCount(Wrappers.lambdaQuery());
        result.put("programNum", programNum);

        // 成品订单数量
        int orderNum = orderInfoMapper.selectCount(Wrappers.lambdaQuery());
        result.put("orderNum", orderNum);

        // 总成品订单金额
        List<BsOrderInfo> orderAllList = this.list(Wrappers.<BsOrderInfo>lambdaQuery().eq(BsOrderInfo::getStatus, "1"));
        BigDecimal totalPrice = orderAllList.stream().map(BsOrderInfo::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        result.put("totalPrice", totalPrice);

        // 总成品订单数量
        int totalNum = orderAllList.size();
        result.put("totalNum", totalNum);

        // 获取当前月份及当前月份
        String year = StrUtil.toString(DateUtil.year(new Date()));
        String month = StrUtil.toString(DateUtil.month(new Date()));

//        List<OrderInfo> orderList = baseMapper.selectOrderByDate(year, null);
//        if (CollectionUtil.isNotEmpty(orderList)) {
//            Map<String, List<OrderInfo>> orderMonthMap = orderList.stream().collect(Collectors.groupingBy(OrderInfo::getMonth));
//            Map<String, List<OrderInfo>> orderYearMap = orderList.stream().collect(Collectors.groupingBy(OrderInfo::getYear));
//
//            List<OrderInfo> currentMonthList = orderMonthMap.get(month);
//            List<OrderInfo> currentYearList = orderYearMap.get(year);
//            // 本月订单量
//            result.put("monthOrderNum", CollectionUtil.isNotEmpty(currentMonthList) ? currentMonthList.size() : 0);
//            // 本月收益
//            result.put("monthOrderTotal", CollectionUtil.isNotEmpty(currentMonthList) ? currentMonthList.stream().map(OrderInfo::getTotal).reduce(BigDecimal.ZERO, BigDecimal::add) : BigDecimal.ZERO);
//            // 本年订单量
//            result.put("yearOrderNum", CollectionUtil.isNotEmpty(currentYearList) ? currentYearList.size() : 0);
//            // 本年收益
//            result.put("yearOrderTotal", CollectionUtil.isNotEmpty(currentYearList) ? currentYearList.stream().map(OrderInfo::getTotal).reduce(BigDecimal.ZERO, BigDecimal::add) : BigDecimal.ZERO);
//        }

//        // 近十天收益统计
//        List<LinkedHashMap<String, Object>> priceDayList = baseMapper.selectPriceByDay(null);
//        result.put("priceDayList", priceDayList);
//        // 近十天工单统计
//        List<LinkedHashMap<String, Object>> orderNumDayList = baseMapper.selectOrderNumByDay(null);
//        result.put("orderNumDayList", orderNumDayList);
//        // 本月维修统计
//        List<LinkedHashMap<String, Object>> repairRate = baseMapper.selectRepairMonth(year, month);
//        result.put("repairRate", repairRate);
//
//        List<VehicleInfo> vehicleList = vehicleMapper.selectList(Wrappers.<VehicleInfo>lambdaQuery().ne(VehicleInfo::getStatus, "3"));
//
//        List<VehicleTypeInfo> typeList = vehicleTypeMapper.selectList(Wrappers.lambdaQuery());
//        Map<Integer, String> typeMap = typeList.stream().collect(Collectors.toMap(VehicleTypeInfo::getId, VehicleTypeInfo::getName));
//        // 车辆类型统计
//        Map<String, Object> vehicleTypeRate = new HashMap<>(16);
//        Map<Integer, List<VehicleInfo>> vehicleTypeMap = vehicleList.stream().collect(Collectors.groupingBy(VehicleInfo::getUseType));
//        typeMap.forEach((key, value) -> {
//            List<VehicleInfo> tempList = vehicleTypeMap.get(key);
//            vehicleTypeRate.put(value, CollectionUtil.isNotEmpty(tempList) ? tempList.size() : 0);
//        });
//        result.put("vehicleTypeRate", vehicleTypeRate);
//
//        List<BrandInfo> brandList = brandMapper.selectList(Wrappers.lambdaQuery());
//        Map<Integer, String> brandMap = brandList.stream().collect(Collectors.toMap(BrandInfo::getId, BrandInfo::getName));
//        // 车辆品牌统计
//        Map<String, Object> vehicleBrandRate = new HashMap<>(16);
//        Map<Integer, List<VehicleInfo>> vehicleBrandMap = vehicleList.stream().collect(Collectors.groupingBy(VehicleInfo::getBrand));
//        brandMap.forEach((key, value) -> {
//            List<VehicleInfo> tempList = vehicleBrandMap.get(key);
//            vehicleBrandRate.put(value, CollectionUtil.isNotEmpty(tempList) ? tempList.size() : 0);
//        });
//        result.put("vehicleBrandRate", vehicleBrandRate);
//
//        // 燃油类型统计 1.燃油 2.柴油 3.油电混动 4.电能
//        Map<String, Object> vehicleFuelRate = new HashMap<>(16);
//        Map<String, List<VehicleInfo>> vehicleFuelMap = vehicleList.stream().collect(Collectors.groupingBy(VehicleInfo::getFuelType));
//        Map<String, String> fuelMap = new HashMap<String, String>() {
//            {
//                put("1", "燃油");
//                put("2", "柴油");
//                put("3", "油电混动");
//                put("4", "电能");
//            }
//        };
//        fuelMap.forEach((key, value) -> {
//            List<VehicleInfo> tempList = vehicleFuelMap.get(key);
//            vehicleFuelRate.put(value, CollectionUtil.isNotEmpty(tempList) ? tempList.size() : 0);
//        });
//        result.put("vehicleFuelRate", vehicleFuelRate);

        return null;
    }
}
