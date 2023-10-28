package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.BsBulletinInfo;
import cc.mrbird.febs.cos.service.IBsBulletinInfoService;
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
@RequestMapping("/cos/bs-bulletin-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BsBulletinInfoController {

    private final IBsBulletinInfoService bsBulletinInfoService;

    /**
     * 分页获取系统公告信息
     *
     * @param page         分页对象
     * @param bsBulletinInfo 系统公告信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<BsBulletinInfo> page, BsBulletinInfo bsBulletinInfo) {
        return R.ok(bsBulletinInfoService.selectBulletinPage(page, bsBulletinInfo));
    }

    /**
     * 获取系统公告信息
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(bsBulletinInfoService.list());
    }

    /**
     * 获取系统公告详细信息
     *
     * @param id ID
     * @return 结果
     */
    @GetMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(bsBulletinInfoService.getById(id));
    }

    /**
     * 新增系统公告信息
     *
     * @param bsBulletinInfo 系统公告信息
     * @return 结果
     */
    @PostMapping
    public R save(BsBulletinInfo bsBulletinInfo) {
        bsBulletinInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(bsBulletinInfoService.save(bsBulletinInfo));
    }

    /**
     * 修改系统公告信息
     *
     * @param bsBulletinInfo 系统公告信息
     * @return 结果
     */
    @PutMapping
    public R edit(BsBulletinInfo bsBulletinInfo) {
        return R.ok(bsBulletinInfoService.updateById(bsBulletinInfo));
    }

    /**
     * 删除系统公告信息
     *
     * @param ids 主键IDS
     * @return 结果
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(bsBulletinInfoService.removeByIds(ids));
    }

}
