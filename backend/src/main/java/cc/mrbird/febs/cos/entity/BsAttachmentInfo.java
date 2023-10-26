package cc.mrbird.febs.cos.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 附件管理
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BsAttachmentInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目编号
     */
    private String code;

    /**
     * 附件标题
     */
    private String title;

    /**
     * 标签
     */
    private String tagCode;

    /**
     * 附件ID
     */
    private String fileId;

    /**
     * 价格
     */
    private BigDecimal unitPrice;

    /**
     * 发布人
     */
    private String author;

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
     * 下载次数
     */
    private Integer downloadNum;


}
