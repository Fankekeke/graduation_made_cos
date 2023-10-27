package cc.mrbird.febs.cos.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 项目信息关联
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BsProgramInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 项目编号
     */
    private String code;

    /**
     * 标签
     */
    private String tagCode;

    /**
     * 项目备注
     */
    private String content;

    /**
     * 项目图片
     */
    private String images;

    /**
     * 标题
     */
    private String title;

    /**
     * 简介介绍
     */
    private String synopsis;

    /**
     * 项目类型
     */
    private String typeCode;

    /**
     * 视频地址
     */
    private String videoUrl;

    /**
     * 运行环境
     */
    private String condition;

    /**
     * 附带内容
     */
    private String attachment;

    /**
     * 价格
     */
    private BigDecimal unitPrice;

    /**
     * 采用技术
     */
    private String technology;

    /**
     * 创作人
     */
    private String author;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 修改时间
     */
    private String updateDate;

    /**
     * 删除标识
     */
    private String delFlag;

    /**
     * 状态（0.待发布 1.已发布 2.下架）
     */
    private String status;


}
