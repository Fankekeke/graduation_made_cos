package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.BsReplyInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface BsReplyInfoMapper extends BaseMapper<BsReplyInfo> {

    /**
     * 分页获取项目评论信息
     *
     * @param page        分页对象
     * @param bsReplyInfo 项目评论信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectReplyPage(Page<BsReplyInfo> page, @Param("bsReplyInfo") BsReplyInfo bsReplyInfo);
}
