package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.BsVisitRecord;
import cc.mrbird.febs.cos.service.IBsVisitRecordService;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author FanK
 */
@RestController
@RequestMapping("/cos/bs-visit-record")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BsVisitRecordController {

    private final IBsVisitRecordService bsVisitRecordService;

    /**
     * 分页获取系统访问记录信息
     *
     * @param page         分页对象
     * @param bsVisitRecord 系统访问记录信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<BsVisitRecord> page, BsVisitRecord bsVisitRecord) {
        return R.ok();
    }

    /**
     * 获取系统访问记录信息
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(bsVisitRecordService.list());
    }

    /**
     * 获取系统访问记录详细信息
     *
     * @param id ID
     * @return 结果
     */
    @GetMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(bsVisitRecordService.getById(id));
    }

    /**
     * 新增系统访问记录信息
     *
     * @param bsVisitRecord 系统访问记录信息
     * @return 结果
     */
    @PostMapping
    public R save(BsVisitRecord bsVisitRecord) {
        return R.ok(bsVisitRecordService.save(bsVisitRecord));
    }

    /**
     * 修改系统访问记录信息
     *
     * @param bsVisitRecord 系统访问记录信息
     * @return 结果
     */
    @PutMapping
    public R edit(BsVisitRecord bsVisitRecord) {
        return R.ok(bsVisitRecordService.updateById(bsVisitRecord));
    }

    /**
     * 删除系统访问记录信息
     *
     * @param ids 主键IDS
     * @return 结果
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(bsVisitRecordService.removeByIds(ids));
    }
    
}
