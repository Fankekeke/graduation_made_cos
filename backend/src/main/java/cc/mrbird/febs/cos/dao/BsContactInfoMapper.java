package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.BsContactInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface BsContactInfoMapper extends BaseMapper<BsContactInfo> {

    /**
     * 分页获取系统联系信息
     *
     * @param page          分页对象
     * @param bsContactInfo 系统联系信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectContactPage(Page<BsContactInfo> page, @Param("bsContactInfo") BsContactInfo bsContactInfo);
}
