package cc.mrbird.febs.cos.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 系统公告信息
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BsBulletinInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公告标题
     */
    private String title;

    /**
     * 简介介绍
     */
    private String synopsis;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 修改时间
     */
    private LocalDateTime updateDate;

    /**
     * 删除标识
     */
    private String delFlag;

    /**
     * 状态（0.待发布 1.已发布 2.下架）
     */
    private String status;

    /**
     * 图片
     */
    private String images;

    /**
     * 是否置顶（0.否 1.是）
     */
    private String pinTop;

    /**
     * 排序
     */
    private Integer sortNo;

    /**
     * 访问量
     */
    private Integer accessNum;

    /**
     * 公告类型（0.普通 1.答辩技巧 2.购买须知）
     */
    private String bulletinType;


}
