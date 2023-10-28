package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.BsBulletinInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface BsBulletinInfoMapper extends BaseMapper<BsBulletinInfo> {

    /**
     * 分页获取系统公告信息
     *
     * @param page           分页对象
     * @param bsBulletinInfo 系统公告信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectBulletinPage(Page<BsBulletinInfo> page, @Param("bsBulletinInfo") BsBulletinInfo bsBulletinInfo);
}
