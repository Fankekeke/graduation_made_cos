package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.BsOrderTailorInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface BsOrderTailorInfoMapper extends BaseMapper<BsOrderTailorInfo> {

    /**
     * 分页获取定制订单信息
     *
     * @param page              分页对象
     * @param bsOrderTailorInfo 定制订单信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectOrderPage(Page<BsOrderTailorInfo> page, @Param("bsOrderTailorInfo") BsOrderTailorInfo bsOrderTailorInfo);
}
