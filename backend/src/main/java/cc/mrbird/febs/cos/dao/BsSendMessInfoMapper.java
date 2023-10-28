package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.BsSendMessInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface BsSendMessInfoMapper extends BaseMapper<BsSendMessInfo> {

    /**
     * 分页获取消息发送记录信息
     *
     * @param page         分页对象
     * @param bsSendMessInfo 消息发送记录信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectMessPage(Page<BsSendMessInfo> page, @Param("bsSendMessInfo") BsSendMessInfo bsSendMessInfo);
}
