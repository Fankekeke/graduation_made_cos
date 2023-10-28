package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.BsReplyInfo;
import cc.mrbird.febs.cos.dao.BsReplyInfoMapper;
import cc.mrbird.febs.cos.service.IBsReplyInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class BsReplyInfoServiceImpl extends ServiceImpl<BsReplyInfoMapper, BsReplyInfo> implements IBsReplyInfoService {

    /**
     * 分页获取项目评论信息
     *
     * @param page        分页对象
     * @param bsReplyInfo 项目评论信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectReplyPage(Page<BsReplyInfo> page, BsReplyInfo bsReplyInfo) {
        return baseMapper.selectReplyPage(page, bsReplyInfo);
    }
}
