package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.BsTagInfo;
import cc.mrbird.febs.cos.service.IBsTagInfoService;
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
@RequestMapping("/cos/bs-tag-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BsTagInfoController {

    private final IBsTagInfoService bsTagInfoService;

    /**
     * 分页获取项目标签信息
     *
     * @param page         分页对象
     * @param bsTagInfo 项目标签信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<BsTagInfo> page, BsTagInfo bsTagInfo) {
        return R.ok();
    }

    /**
     * 获取项目标签信息
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(bsTagInfoService.list());
    }

    /**
     * 获取项目标签详细信息
     *
     * @param id ID
     * @return 结果
     */
    @GetMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(bsTagInfoService.getById(id));
    }

    /**
     * 新增项目标签信息
     *
     * @param bsTagInfo 项目标签信息
     * @return 结果
     */
    @PostMapping
    public R save(BsTagInfo bsTagInfo) {
        bsTagInfo.setCode("TAG-" +System.currentTimeMillis());
        bsTagInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(bsTagInfoService.save(bsTagInfo));
    }

    /**
     * 修改项目标签信息
     *
     * @param bsTagInfo 项目标签信息
     * @return 结果
     */
    @PutMapping
    public R edit(BsTagInfo bsTagInfo) {
        return R.ok(bsTagInfoService.updateById(bsTagInfo));
    }

    /**
     * 删除项目标签信息
     *
     * @param ids 主键IDS
     * @return 结果
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(bsTagInfoService.removeByIds(ids));
    }
    
}
