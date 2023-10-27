package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.BsProgramInfo;
import cc.mrbird.febs.cos.service.IBsProgramInfoService;
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
@RequestMapping("/cos/bs-program-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BsProgramInfoController {

    private final IBsProgramInfoService bsProgramInfoService;

    /**
     * 分页获取项目信息
     *
     * @param page         分页对象
     * @param bsProgramInfo 项目信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<BsProgramInfo> page, BsProgramInfo bsProgramInfo) {
        return R.ok();
    }

    /**
     * 获取项目信息
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(bsProgramInfoService.list());
    }

    /**
     * 获取项目详细信息
     *
     * @param id ID
     * @return 结果
     */
    @GetMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(bsProgramInfoService.getById(id));
    }

    /**
     * 新增项目信息
     *
     * @param bsProgramInfo 项目信息
     * @return 结果
     */
    @PostMapping
    public R save(BsProgramInfo bsProgramInfo) {
        bsProgramInfo.setCode("PR-" +System.currentTimeMillis());
        bsProgramInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(bsProgramInfoService.save(bsProgramInfo));
    }

    /**
     * 修改项目信息
     *
     * @param bsProgramInfo 项目信息
     * @return 结果
     */
    @PutMapping
    public R edit(BsProgramInfo bsProgramInfo) {
        return R.ok(bsProgramInfoService.updateById(bsProgramInfo));
    }

    /**
     * 删除项目信息
     *
     * @param ids 主键IDS
     * @return 结果
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(bsProgramInfoService.removeByIds(ids));
    }
    
}
