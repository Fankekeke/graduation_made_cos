package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.BsAttachmentInfo;
import cc.mrbird.febs.cos.dao.BsAttachmentInfoMapper;
import cc.mrbird.febs.cos.service.IBsAttachmentInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class BsAttachmentInfoServiceImpl extends ServiceImpl<BsAttachmentInfoMapper, BsAttachmentInfo> implements IBsAttachmentInfoService {

    /**
     * 分页获取附件信息
     *
     * @param page             分页对象
     * @param bsAttachmentInfo 附件信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectAttachmentPage(Page<BsAttachmentInfo> page, BsAttachmentInfo bsAttachmentInfo) {
        return baseMapper.selectAttachmentPage(page, bsAttachmentInfo);
    }
}
