package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.BsBulletinInfo;
import cc.mrbird.febs.cos.dao.BsBulletinInfoMapper;
import cc.mrbird.febs.cos.service.IBsBulletinInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class BsBulletinInfoServiceImpl extends ServiceImpl<BsBulletinInfoMapper, BsBulletinInfo> implements IBsBulletinInfoService {

    /**
     * 分页获取系统公告信息
     *
     * @param page           分页对象
     * @param bsBulletinInfo 系统公告信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectBulletinPage(Page<BsBulletinInfo> page, BsBulletinInfo bsBulletinInfo) {
        return baseMapper.selectBulletinPage(page, bsBulletinInfo);
    }
}
