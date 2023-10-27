package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.BsReplyInfo;
import cc.mrbird.febs.cos.service.IBsReplyInfoService;
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
@RequestMapping("/cos/bs-reply-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BsReplyInfoController {

    private final IBsReplyInfoService bsReplyInfoService;

    /**
     * 分页获取项目评论信息
     *
     * @param page         分页对象
     * @param bsReplyInfo 项目评论信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<BsReplyInfo> page, BsReplyInfo bsReplyInfo) {
        return R.ok();
    }

    /**
     * 获取项目评论信息
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(bsReplyInfoService.list());
    }

    /**
     * 获取项目评论详细信息
     *
     * @param id ID
     * @return 结果
     */
    @GetMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(bsReplyInfoService.getById(id));
    }

    /**
     * 新增项目评论信息
     *
     * @param bsReplyInfo 项目评论信息
     * @return 结果
     */
    @PostMapping
    public R save(BsReplyInfo bsReplyInfo) {
        bsReplyInfo.setCode("PR-" +System.currentTimeMillis());
        bsReplyInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(bsReplyInfoService.save(bsReplyInfo));
    }

    /**
     * 修改项目评论信息
     *
     * @param bsReplyInfo 项目评论信息
     * @return 结果
     */
    @PutMapping
    public R edit(BsReplyInfo bsReplyInfo) {
        return R.ok(bsReplyInfoService.updateById(bsReplyInfo));
    }

    /**
     * 删除项目评论信息
     *
     * @param ids 主键IDS
     * @return 结果
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(bsReplyInfoService.removeByIds(ids));
    }
    
}
