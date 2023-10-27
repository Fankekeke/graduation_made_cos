package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.BsOrderInfo;
import cc.mrbird.febs.cos.service.IBsOrderInfoService;
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
@RequestMapping("/cos/bs-order-info")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BsOrderInfoController {

    private final IBsOrderInfoService bsOrderInfoService;

    /**
     * 分页获取设计订单信息
     *
     * @param page         分页对象
     * @param bsOrderInfo 设计订单信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<BsOrderInfo> page, BsOrderInfo bsOrderInfo) {
        return R.ok();
    }

    /**
     * 获取设计订单信息
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(bsOrderInfoService.list());
    }

    /**
     * 获取设计订单详细信息
     *
     * @param id ID
     * @return 结果
     */
    @GetMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(bsOrderInfoService.getById(id));
    }

    /**
     * 新增设计订单信息
     *
     * @param bsOrderInfo 设计订单信息
     * @return 结果
     */
    @PostMapping
    public R save(BsOrderInfo bsOrderInfo) {
        bsOrderInfo.setCode("OD-" +System.currentTimeMillis());
        bsOrderInfo.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(bsOrderInfoService.save(bsOrderInfo));
    }

    /**
     * 修改设计订单信息
     *
     * @param bsOrderInfo 设计订单信息
     * @return 结果
     */
    @PutMapping
    public R edit(BsOrderInfo bsOrderInfo) {
        return R.ok(bsOrderInfoService.updateById(bsOrderInfo));
    }

    /**
     * 删除设计订单信息
     *
     * @param ids 主键IDS
     * @return 结果
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(bsOrderInfoService.removeByIds(ids));
    }

}
