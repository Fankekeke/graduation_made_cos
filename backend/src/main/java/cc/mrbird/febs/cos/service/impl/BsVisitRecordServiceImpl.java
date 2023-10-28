package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.BsVisitRecord;
import cc.mrbird.febs.cos.dao.BsVisitRecordMapper;
import cc.mrbird.febs.cos.service.IBsVisitRecordService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class BsVisitRecordServiceImpl extends ServiceImpl<BsVisitRecordMapper, BsVisitRecord> implements IBsVisitRecordService {

    /**
     * 分页获取系统访问记录信息
     *
     * @param page          分页对象
     * @param bsVisitRecord 系统访问记录信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> selectRecordPage(Page<BsVisitRecord> page, BsVisitRecord bsVisitRecord) {
        return baseMapper.selectRecordPage(page, bsVisitRecord);
    }
}
