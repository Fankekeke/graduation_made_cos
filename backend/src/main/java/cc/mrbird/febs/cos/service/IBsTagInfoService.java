package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.BsTagInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface IBsTagInfoService extends IService<BsTagInfo> {

    /**
     * 分页获取项目标签信息
     *
     * @param page         分页对象
     * @param bsTagInfo 项目标签信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectTagPage(Page<BsTagInfo> page, BsTagInfo bsTagInfo);
}
