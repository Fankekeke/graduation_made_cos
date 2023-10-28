package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.BsAttachmentInfo;
import cc.mrbird.febs.cos.service.IBsAttachmentInfoService;
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
@RequestMapping("/cos/bs-attachment-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BsAttachmentInfoController {

    private final IBsAttachmentInfoService bsAttachmentInfoService;

    /**
     * 分页获取附件信息
     *
     * @param page         分页对象
     * @param bsAttachmentInfo 附件信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<BsAttachmentInfo> page, BsAttachmentInfo bsAttachmentInfo) {
        return R.ok(bsAttachmentInfoService.selectAttachmentPage(page, bsAttachmentInfo));
    }

    /**
     * 获取附件信息
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(bsAttachmentInfoService.list());
    }

    /**
     * 获取附件详细信息
     *
     * @param id ID
     * @return 结果
     */
    @GetMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(bsAttachmentInfoService.getById(id));
    }

    /**
     * 新增附件信息
     *
     * @param bsAttachmentInfo 附件信息
     * @return 结果
     */
    @PostMapping
    public R save(BsAttachmentInfo bsAttachmentInfo) {
        bsAttachmentInfo.setCode("AT-" +System.currentTimeMillis());
        bsAttachmentInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(bsAttachmentInfoService.save(bsAttachmentInfo));
    }

    /**
     * 修改附件信息
     *
     * @param bsAttachmentInfo 附件信息
     * @return 结果
     */
    @PutMapping
    public R edit(BsAttachmentInfo bsAttachmentInfo) {
        return R.ok(bsAttachmentInfoService.updateById(bsAttachmentInfo));
    }

    /**
     * 删除附件信息
     *
     * @param ids 主键IDS
     * @return 结果
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(bsAttachmentInfoService.removeByIds(ids));
    }

}
