package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.BsTypeInfo;
import cc.mrbird.febs.cos.service.IBsTypeInfoService;
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
@RequestMapping("/cos/bs-type-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BsTypeInfoController {

    private final IBsTypeInfoService bsTypeInfoService;

    /**
     * 分页获取项目类型信息
     *
     * @param page         分页对象
     * @param bsTypeInfo 项目类型信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<BsTypeInfo> page, BsTypeInfo bsTypeInfo) {
        return R.ok(bsTypeInfoService.selectTypePage(page, bsTypeInfo));
    }

    /**
     * 获取项目类型信息
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(bsTypeInfoService.list());
    }

    /**
     * 获取项目类型详细信息
     *
     * @param id ID
     * @return 结果
     */
    @GetMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(bsTypeInfoService.getById(id));
    }

    /**
     * 新增项目类型信息
     *
     * @param bsTypeInfo 项目类型信息
     * @return 结果
     */
    @PostMapping
    public R save(BsTypeInfo bsTypeInfo) {
        bsTypeInfo.setCode("TY-" +System.currentTimeMillis());
        bsTypeInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(bsTypeInfoService.save(bsTypeInfo));
    }

    /**
     * 修改项目类型信息
     *
     * @param bsTypeInfo 项目类型信息
     * @return 结果
     */
    @PutMapping
    public R edit(BsTypeInfo bsTypeInfo) {
        return R.ok(bsTypeInfoService.updateById(bsTypeInfo));
    }

    /**
     * 删除项目类型信息
     *
     * @param ids 主键IDS
     * @return 结果
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(bsTypeInfoService.removeByIds(ids));
    }

}
