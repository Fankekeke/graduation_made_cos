package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.BsBulletinInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface IBsBulletinInfoService extends IService<BsBulletinInfo> {

    /**
     * 分页获取系统公告信息
     *
     * @param page           分页对象
     * @param bsBulletinInfo 系统公告信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectBulletinPage(Page<BsBulletinInfo> page, BsBulletinInfo bsBulletinInfo);

}
