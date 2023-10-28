package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.BsOrderInfo;
import cc.mrbird.febs.cos.dao.BsOrderInfoMapper;
import cc.mrbird.febs.cos.service.IBsOrderInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class BsOrderInfoServiceImpl extends ServiceImpl<BsOrderInfoMapper, BsOrderInfo> implements IBsOrderInfoService {

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
}
