package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.BsSendMessInfo;
import cc.mrbird.febs.cos.service.IBsSendMessInfoService;
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
@RequestMapping("/cos/bs-send-mess-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BsSendMessInfoController {

    private final IBsSendMessInfoService bsSendMessInfoService;

    /**
     * 分页获取消息发送记录信息
     *
     * @param page         分页对象
     * @param bsSendMessInfo 消息发送记录信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<BsSendMessInfo> page, BsSendMessInfo bsSendMessInfo) {
        return R.ok(bsSendMessInfoService.selectMessPage(page, bsSendMessInfo));
    }

    /**
     * 获取消息发送记录信息
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(bsSendMessInfoService.list());
    }

    /**
     * 获取消息发送记录详细信息
     *
     * @param id ID
     * @return 结果
     */
    @GetMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(bsSendMessInfoService.getById(id));
    }

    /**
     * 新增消息发送记录信息
     *
     * @param bsSendMessInfo 消息发送记录信息
     * @return 结果
     */
    @PostMapping
    public R save(BsSendMessInfo bsSendMessInfo) {
        bsSendMessInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(bsSendMessInfoService.save(bsSendMessInfo));
    }

    /**
     * 修改消息发送记录信息
     *
     * @param bsSendMessInfo 消息发送记录信息
     * @return 结果
     */
    @PutMapping
    public R edit(BsSendMessInfo bsSendMessInfo) {
        return R.ok(bsSendMessInfoService.updateById(bsSendMessInfo));
    }

    /**
     * 删除消息发送记录信息
     *
     * @param ids 主键IDS
     * @return 结果
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(bsSendMessInfoService.removeByIds(ids));
    }
    
}
