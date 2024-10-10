package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.BsVisitRecord;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author FanK
 */
public interface IBsVisitRecordService extends IService<BsVisitRecord> {

    /**
     * 分页获取系统访问记录信息
     *
     * @param page          分页对象
     * @param bsVisitRecord 系统访问记录信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectRecordPage(Page<BsVisitRecord> page, BsVisitRecord bsVisitRecord);

    /**
     * 新增系统访问记录信息
     *
     * @param visitRecord 系统访问记录信息
     * @return 结果
     */
    boolean addVisitRecord(BsVisitRecord visitRecord);

    /**
     * 根据时间统计访问记录
     *
     * @param date 日期
     * @param type 类型
     * @return 结果
     */
    List<LinkedHashMap<String, Object>> queryVisitRecordByDate(String date, String type);

    /**
     * 获取近10天项目访问记录
     *
     * @return 结果
     */
    List<LinkedHashMap<String, Object>> queryVisitRecordDateRange();
}
