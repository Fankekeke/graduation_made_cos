package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.BsOrderTailorInfo;
import cc.mrbird.febs.cos.dao.BsOrderTailorInfoMapper;
import cc.mrbird.febs.cos.service.IBsOrderTailorInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class BsOrderTailorInfoServiceImpl extends ServiceImpl<BsOrderTailorInfoMapper, BsOrderTailorInfo> implements IBsOrderTailorInfoService {

    /**
     * 分页获取定制订单信息
     *
     * @param page              分页对象
     * @param bsOrderTailorInfo 定制订单信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectOrderPage(Page<BsOrderTailorInfo> page, BsOrderTailorInfo bsOrderTailorInfo) {
        return baseMapper.selectOrderPage(page, bsOrderTailorInfo);
    }
}
