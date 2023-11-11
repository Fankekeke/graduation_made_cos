package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.common.utils.AddressUtil;
import cc.mrbird.febs.common.utils.HttpContextUtil;
import cc.mrbird.febs.common.utils.IPUtil;
import cc.mrbird.febs.cos.entity.BsVisitRecord;
import cc.mrbird.febs.cos.dao.BsVisitRecordMapper;
import cc.mrbird.febs.cos.service.IBsVisitRecordService;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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

    /**
     * 新增系统访问记录信息
     *
     * @param visitRecord 系统访问记录信息
     * @return 结果
     */
    @Override
    public boolean addVisitRecord(BsVisitRecord visitRecord) {
        // 访问时间
        visitRecord.setVisitDate(DateUtil.formatDateTime(new Date()));
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        String ip = IPUtil.getIpAddr(request);
        // 访问地址
        visitRecord.setLocalhost(AddressUtil.getCityInfo(ip));
        // 访问IP
        visitRecord.setIpAddress(ip);
        visitRecord.setYear(StrUtil.toString(DateUtil.year(new Date())));
        visitRecord.setMonth(StrUtil.toString(DateUtil.month(new Date()) + 1));
        return this.save(visitRecord);
    }
}
