package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.BsSendMessInfo;
import cc.mrbird.febs.cos.dao.BsSendMessInfoMapper;
import cc.mrbird.febs.cos.service.IBsSendMessInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class BsSendMessInfoServiceImpl extends ServiceImpl<BsSendMessInfoMapper, BsSendMessInfo> implements IBsSendMessInfoService {

    /**
     * 分页获取消息发送记录信息
     *
     * @param page         分页对象
     * @param bsSendMessInfo 消息发送记录信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectMessPage(Page<BsSendMessInfo> page, BsSendMessInfo bsSendMessInfo) {
        return baseMapper.selectMessPage(page, bsSendMessInfo);
    }
}
