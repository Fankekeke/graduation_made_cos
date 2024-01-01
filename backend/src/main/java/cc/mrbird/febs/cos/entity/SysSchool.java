package cc.mrbird.febs.cos.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 全国学校数据
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("bs_school_info")
public class SysSchool implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 学校名称
     */
    private String name;

    /**
     * 学校地址
     */
    private String address;

    /**
     * 学校地区
     */
    private String area;

    /**
     * 人数
     */
    private Integer number;

    /**
     * 备注
     */
    private String desc;

    /**
     * 网址
     */
    private String http;

    /**
     * 主管部门
     */
    private String manage;

    /**
     * 层次
     */
    private String level;

    /**
     * 类型
     */
    private String type;

    /**
     * 所在城市
     */
    private Integer cityId;


    @TableField(exist = false)
    private String city;

}
