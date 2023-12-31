package cc.mrbird.febs.cos.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 消息发送记录
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BsSendMessInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 发送内容
     */
    private String content;

    /**
     * 发送时间
     */
    private String createDate;

    /**
     * 发送状态（0.成功 1.异常）
     */
    private String status;

    /**
     * 重发时间
     */
    private String retryDate;


}
