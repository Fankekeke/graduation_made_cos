package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.BsContactInfo;
import cc.mrbird.febs.cos.service.IBsContactInfoService;
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
@RequestMapping("/cos/bs-contact-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BsContactInfoController {

    private final IBsContactInfoService bsContactInfoService;

    /**
     * 分页获取系统联系信息
     *
     * @param page         分页对象
     * @param bsContactInfo 系统联系信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<BsContactInfo> page, BsContactInfo bsContactInfo) {
        return R.ok();
    }

    /**
     * 获取系统联系信息
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(bsContactInfoService.list());
    }

    /**
     * 获取系统联系详细信息
     *
     * @param id ID
     * @return 结果
     */
    @GetMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(bsContactInfoService.getById(id));
    }

    /**
     * 新增系统联系信息
     *
     * @param bsContactInfo 系统联系信息
     * @return 结果
     */
    @PostMapping
    public R save(BsContactInfo bsContactInfo) {
        bsContactInfo.setCode("CON-" +System.currentTimeMillis());
        bsContactInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(bsContactInfoService.save(bsContactInfo));
    }

    /**
     * 修改系统联系信息
     *
     * @param bsContactInfo 系统联系信息
     * @return 结果
     */
    @PutMapping
    public R edit(BsContactInfo bsContactInfo) {
        return R.ok(bsContactInfoService.updateById(bsContactInfo));
    }

    /**
     * 删除系统联系信息
     *
     * @param ids 主键IDS
     * @return 结果
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(bsContactInfoService.removeByIds(ids));
    }

}
