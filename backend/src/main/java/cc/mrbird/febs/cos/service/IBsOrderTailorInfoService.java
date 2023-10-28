package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.BsOrderTailorInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface IBsOrderTailorInfoService extends IService<BsOrderTailorInfo> {

    /**
     * 分页获取定制订单信息
     *
     * @param page              分页对象
     * @param bsOrderTailorInfo 定制订单信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectOrderPage(Page<BsOrderTailorInfo> page, BsOrderTailorInfo bsOrderTailorInfo);
}
