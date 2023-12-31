package cc.mrbird.febs.cos.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 全国城市数据
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("bs_city_info")
public class SysCity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 城市
     */
    private String name;

    /**
     * 父级
     */
    private Integer parentId;

    private String initial;

    private String initials;

    private String pinyin;

    private String extra;

    private String suffix;

    private String code;

    private String areaCode;

    private Integer orderBy;


}
