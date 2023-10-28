package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.BsAttachmentInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface IBsAttachmentInfoService extends IService<BsAttachmentInfo> {

    /**
     * 分页获取附件信息
     *
     * @param page             分页对象
     * @param bsAttachmentInfo 附件信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectAttachmentPage(Page<BsAttachmentInfo> page, BsAttachmentInfo bsAttachmentInfo);
}
