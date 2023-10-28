package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.BsTagInfo;
import cc.mrbird.febs.cos.dao.BsTagInfoMapper;
import cc.mrbird.febs.cos.service.IBsTagInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class BsTagInfoServiceImpl extends ServiceImpl<BsTagInfoMapper, BsTagInfo> implements IBsTagInfoService {

    /**
     * 分页获取项目标签信息
     *
     * @param page         分页对象
     * @param bsTagInfo 项目标签信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectTagPage(Page<BsTagInfo> page, BsTagInfo bsTagInfo) {
        return baseMapper.selectTagPage(page, bsTagInfo);
    }
}
