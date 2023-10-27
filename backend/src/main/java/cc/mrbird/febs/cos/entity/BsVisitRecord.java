package cc.mrbird.febs.cos.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 系统访问记录
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BsVisitRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 访问时间
     */
    private String visitDate;

    /**
     * 访问地点
     */
    private String localhost;

    /**
     * IP地址
     */
    private String ipAddress;

    /**
     * 访问类型（0.主页 1.项目 2.附件）
     */
    private String visitType;

    /**
     * 访问编号
     */
    private String visitCode;

    /**
     * 年份
     */
    private String year;

    /**
     * 月份
     */
    private String month;

    /**
     * 是否为本地（0.否 1.是）
     */
    private String isLocal;


}
