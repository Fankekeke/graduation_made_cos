package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.BsAttachmentInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface BsAttachmentInfoMapper extends BaseMapper<BsAttachmentInfo> {

    /**
     * 分页获取附件信息
     *
     * @param page             分页对象
     * @param bsAttachmentInfo 附件信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectAttachmentPage(Page<BsAttachmentInfo> page, @Param("bsAttachmentInfo") BsAttachmentInfo bsAttachmentInfo);
}
