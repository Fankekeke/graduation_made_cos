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
 * 设计订单管理
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BsOrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单编号
     */
    private String code;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 联系方式
     */
    private String contact;

    /**
     * 项目编号
     */
    private String programCode;

    /**
     * 总价格
     */
    private BigDecimal totalPrice;

    /**
     * 备注
     */
    private String content;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 状态（0.未支付 1.已支付）
     */
    private String status;

    /**
     * 支付时间
     */
    private String payDate;

    /**
     * 修改时间
     */
    private String updateDate;

    /**
     * 删除标识
     */
    private String delFlag;


}
