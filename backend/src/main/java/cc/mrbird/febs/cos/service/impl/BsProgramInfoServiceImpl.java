package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.BsProgramInfo;
import cc.mrbird.febs.cos.dao.BsProgramInfoMapper;
import cc.mrbird.febs.cos.service.IBsProgramInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class BsProgramInfoServiceImpl extends ServiceImpl<BsProgramInfoMapper, BsProgramInfo> implements IBsProgramInfoService {

    /**
     * 分页获取项目信息
     *
     * @param page          分页对象
     * @param bsProgramInfo 项目信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectProgramPage(Page<BsProgramInfo> page, BsProgramInfo bsProgramInfo) {
        return baseMapper.selectProgramPage(page, bsProgramInfo);
    }
}
