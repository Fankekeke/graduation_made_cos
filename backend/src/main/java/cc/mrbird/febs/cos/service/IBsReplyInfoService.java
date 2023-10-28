package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.BsReplyInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface IBsReplyInfoService extends IService<BsReplyInfo> {

    /**
     * 分页获取项目评论信息
     *
     * @param page        分页对象
     * @param bsReplyInfo 项目评论信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectReplyPage(Page<BsReplyInfo> page, BsReplyInfo bsReplyInfo);
}
