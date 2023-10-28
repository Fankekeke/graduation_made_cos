package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.BsContactInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface IBsContactInfoService extends IService<BsContactInfo> {

    /**
     * 分页获取系统联系信息
     *
     * @param page          分页对象
     * @param bsContactInfo 系统联系信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectContactPage(Page<BsContactInfo> page, BsContactInfo bsContactInfo);
}
