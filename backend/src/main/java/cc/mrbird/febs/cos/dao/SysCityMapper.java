package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.SysCity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface SysCityMapper extends BaseMapper<SysCity> {

    /**
     * 分页查询城市信息
     * @param page 分页信息
     * @param sysCity 城市信息
     * @return 城市信息列表
     */
    IPage<LinkedHashMap<String, Object>> getCityByPage(Page page, @Param("sysCity") SysCity sysCity);
}
