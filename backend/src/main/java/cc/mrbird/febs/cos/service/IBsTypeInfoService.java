package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.BsTypeInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface IBsTypeInfoService extends IService<BsTypeInfo> {

    /**
     * 分页获取项目类型信息
     *
     * @param page         分页对象
     * @param bsTypeInfo 项目类型信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectTypePage(Page<BsTypeInfo> page, BsTypeInfo bsTypeInfo);
}
