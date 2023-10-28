package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.BsOrderInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface IBsOrderInfoService extends IService<BsOrderInfo> {

    /**
     * 分页获取设计订单信息
     *
     * @param page         分页对象
     * @param bsOrderInfo 设计订单信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectOrderPage(Page<BsOrderInfo> page, BsOrderInfo bsOrderInfo);
}
