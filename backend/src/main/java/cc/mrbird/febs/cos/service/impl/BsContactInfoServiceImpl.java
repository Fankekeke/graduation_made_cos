package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.BsContactInfo;
import cc.mrbird.febs.cos.dao.BsContactInfoMapper;
import cc.mrbird.febs.cos.service.IBsContactInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class BsContactInfoServiceImpl extends ServiceImpl<BsContactInfoMapper, BsContactInfo> implements IBsContactInfoService {

    /**
     * 分页获取系统联系信息
     *
     * @param page          分页对象
     * @param bsContactInfo 系统联系信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectContactPage(Page<BsContactInfo> page, BsContactInfo bsContactInfo) {
        return baseMapper.selectContactPage(page, bsContactInfo);
    }
}
