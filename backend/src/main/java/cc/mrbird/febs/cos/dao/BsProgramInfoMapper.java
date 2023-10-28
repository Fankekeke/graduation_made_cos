package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.BsProgramInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface BsProgramInfoMapper extends BaseMapper<BsProgramInfo> {

    /**
     * 分页获取项目信息
     *
     * @param page          分页对象
     * @param bsProgramInfo 项目信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectProgramPage(Page<BsProgramInfo> page, @Param("bsProgramInfo") BsProgramInfo bsProgramInfo);
}
