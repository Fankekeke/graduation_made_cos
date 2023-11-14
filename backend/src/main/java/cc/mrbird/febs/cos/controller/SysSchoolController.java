package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.annotation.Log;
import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.SysSchool;
import cc.mrbird.febs.cos.service.ISysSchoolService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author FanK
 */
@RestController
@RequestMapping("/cos/sys-school")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SysSchoolController {

    private final ISysSchoolService sysSchoolService;

    /**
     * 查询学校信息
     *
     * @param page 分页对象
     * @param sysSchool 学校信息
     * @return 学校列表
     */
    @GetMapping("/page")
    public R page(Page page, SysSchool sysSchool) {
        return R.ok(sysSchoolService.getSchoolByPage(page, sysSchool));
    }

    /**
     * 根据ID获取学校
     *
     * @param id 学校Id
     * @return 学校信息
     */
    @GetMapping("/{id}")
    public R schoolById(@PathVariable Integer id) {
        return R.ok(sysSchoolService.getSchoolById(id));
    }

    /**
     * 学校信息联想
     *
     * @param key 关键字
     * @return 学校列表
     */
    @GetMapping("/united/{key}")
    public R schoolUnited(@PathVariable("key") String key) {
        return R.ok(sysSchoolService.schoolUnited(key));
    }

    /**
     * 新增学校信息
     *
     * @param sysSchool 学校信息
     * @return 返回结果
     */
    @Log("新增学校信息")
    @PostMapping
    public R save(SysSchool sysSchool) {
        return R.ok(sysSchoolService.save(sysSchool));
    }

    /**
     * 修改学校信息
     *
     * @param sysSchool 学校信息
     * @return 返回结果
     */
    @Log("修改学校信息")
    @PutMapping
    public R edit(SysSchool sysSchool) {
        return R.ok(sysSchoolService.updateById(sysSchool));
    }

    /**
     * 删除学校信息
     *
     * @param ids 学校Id
     * @return 返回结果
     */
    @Log("删除学校信息")
    @DeleteMapping("/{ids}")
    public R delete(@PathVariable("ids") List<Integer> ids) {
        return R.ok(sysSchoolService.removeByIds(ids));
    }

}
