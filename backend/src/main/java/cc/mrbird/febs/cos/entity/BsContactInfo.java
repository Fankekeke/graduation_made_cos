package cc.mrbird.febs.cos.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 系统联系管理
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BsContactInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 工单编号
     */
    private String code;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 处理人
     */
    private String updateBy;

    /**
     * 处理时间
     */
    private String updateDate;

    /**
     * 删除标识
     */
    private String delFlag;

    /**
     * 状态（0.未处理 1.已处理）
     */
    private String status;


}
