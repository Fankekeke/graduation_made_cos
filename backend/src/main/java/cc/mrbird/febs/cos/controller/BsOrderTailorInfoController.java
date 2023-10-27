package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.BsOrderTailorInfo;
import cc.mrbird.febs.cos.service.IBsOrderTailorInfoService;
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
@RequestMapping("/cos/bs-order-tailor-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BsOrderTailorInfoController {

    private final IBsOrderTailorInfoService bsOrderTailorInfoService;

    /**
     * 分页获取定制订单信息
     *
     * @param page         分页对象
     * @param bsOrderTailorInfo 定制订单信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<BsOrderTailorInfo> page, BsOrderTailorInfo bsOrderTailorInfo) {
        return R.ok();
    }

    /**
     * 获取定制订单信息
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(bsOrderTailorInfoService.list());
    }

    /**
     * 获取定制订单详细信息
     *
     * @param id ID
     * @return 结果
     */
    @GetMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(bsOrderTailorInfoService.getById(id));
    }

    /**
     * 新增定制订单信息
     *
     * @param bsOrderTailorInfo 定制订单信息
     * @return 结果
     */
    @PostMapping
    public R save(BsOrderTailorInfo bsOrderTailorInfo) {
        bsOrderTailorInfo.setCode("ODT-" +System.currentTimeMillis());
        bsOrderTailorInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(bsOrderTailorInfoService.save(bsOrderTailorInfo));
    }

    /**
     * 修改定制订单信息
     *
     * @param bsOrderTailorInfo 定制订单信息
     * @return 结果
     */
    @PutMapping
    public R edit(BsOrderTailorInfo bsOrderTailorInfo) {
        return R.ok(bsOrderTailorInfoService.updateById(bsOrderTailorInfo));
    }

    /**
     * 删除定制订单信息
     *
     * @param ids 主键IDS
     * @return 结果
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(bsOrderTailorInfoService.removeByIds(ids));
    }
    
}
