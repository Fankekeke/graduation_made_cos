package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.BsTypeInfo;
import cc.mrbird.febs.cos.dao.BsTypeInfoMapper;
import cc.mrbird.febs.cos.service.IBsTypeInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class BsTypeInfoServiceImpl extends ServiceImpl<BsTypeInfoMapper, BsTypeInfo> implements IBsTypeInfoService {

    /**
     * 分页获取项目类型信息
     *
     * @param page         分页对象
     * @param bsTypeInfo 项目类型信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectTypePage(Page<BsTypeInfo> page, BsTypeInfo bsTypeInfo) {
        return baseMapper.selectTypePage(page, bsTypeInfo);
    }
}
