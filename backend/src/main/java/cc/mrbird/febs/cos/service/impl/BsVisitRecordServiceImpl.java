package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.common.utils.AddressUtil;
import cc.mrbird.febs.common.utils.HttpContextUtil;
import cc.mrbird.febs.common.utils.IPUtil;
import cc.mrbird.febs.cos.dao.BsProgramInfoMapper;
import cc.mrbird.febs.cos.entity.BsProgramInfo;
import cc.mrbird.febs.cos.entity.BsVisitRecord;
import cc.mrbird.febs.cos.dao.BsVisitRecordMapper;
import cc.mrbird.febs.cos.service.IBsVisitRecordService;
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

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author FanK
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BsVisitRecordServiceImpl extends ServiceImpl<BsVisitRecordMapper, BsVisitRecord> implements IBsVisitRecordService {

    private final BsProgramInfoMapper programInfoMapper;

    /**
     * 分页获取系统访问记录信息
     *
     * @param page          分页对象
     * @param bsVisitRecord 系统访问记录信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectRecordPage(Page<BsVisitRecord> page, BsVisitRecord bsVisitRecord) {
        return baseMapper.selectRecordPage(page, bsVisitRecord);
    }

    /**
     * 新增系统访问记录信息
     *
     * @param visitRecord 系统访问记录信息
     * @return 结果
     */
    @Override
    public boolean addVisitRecord(BsVisitRecord visitRecord) {
        // 访问时间
        visitRecord.setVisitDate(DateUtil.formatDateTime(new Date()));
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        String ip = IPUtil.getIpAddr(request);
        // 访问地址
        visitRecord.setLocalhost(AddressUtil.getCityInfo(ip));
        // 访问IP
        visitRecord.setIpAddress(ip);
        visitRecord.setYear(StrUtil.toString(DateUtil.year(new Date())));
        visitRecord.setMonth(StrUtil.toString(DateUtil.month(new Date()) + 1));
        return this.save(visitRecord);
    }

    /**
     * 根据时间统计访问记录
     *
     * @param date 日期
     * @param type 类型
     * @return 结果
     */
    @Override
    public List<LinkedHashMap<String, Object>> queryVisitRecordByDate(String date, String type) {
        // 获取统计的数据
        List<BsProgramInfo> programList = programInfoMapper.selectList(Wrappers.<BsProgramInfo>lambdaQuery()
                .eq(BsProgramInfo::getDelFlag, "0").eq(BsProgramInfo::getStatus, "0"));
        if (CollectionUtil.isEmpty(programList)) {
            return Collections.emptyList();
        }

        // 返回数据
        List<LinkedHashMap<String, Object>> result = new ArrayList<>();

        // 根据时间获取访问记录
        List<BsVisitRecord> visitRecordList = new ArrayList<>();

        if (CollectionUtil.isEmpty(visitRecordList)) {
            for (BsProgramInfo programInfo : programList) {
                result.add(new LinkedHashMap<String, Object>() {
                    {
                        put("name", programInfo.getTitle());
                        put("code", programInfo.getCode());
                        put("visit", 0);
                    }
                });
            }
            return result;
        }

        // 根据访问编号转MAP
        Map<String, List<BsVisitRecord>> visitMap = visitRecordList.stream().collect(Collectors.groupingBy(BsVisitRecord::getVisitCode));
        for (BsProgramInfo programInfo : programList) {
            // 待添加的小项信息
            LinkedHashMap<String, Object> addItem = new LinkedHashMap<String, Object>() {
                {
                    put("name", programInfo.getTitle());
                    put("code", programInfo.getCode());
                }
            };
            if (CollectionUtil.isEmpty(visitMap.get(programInfo.getCode()))) {
                addItem.put("visit", 0);
                result.add(addItem);
                continue;
            }
            addItem.put("visit", visitMap.get(programInfo.getCode()).size());
            result.add(addItem);
        }
        return result;
    }

    /**
     * 获取近10天项目访问记录
     *
     * @return 结果
     */
    @Override
    public List<LinkedHashMap<String, Object>> queryVisitRecordDateRange() {
        return null;
    }
}
