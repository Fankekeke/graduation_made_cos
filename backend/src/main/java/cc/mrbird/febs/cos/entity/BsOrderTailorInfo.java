package cc.mrbird.febs.cos.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 定制订单管理
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BsOrderTailorInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单编号
     */
    private String code;

    /**
     * 题目
     */
    private String title;

    /**
     * 功能模块
     */
    private String module;

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
     * 用户头像
     */
    private String images;

    /**
     * 价格
     */
    private BigDecimal totalPrice;

    /**
     * 预付款
     */
    private BigDecimal subsist;

    /**
     * 预付款比率
     */
    private BigDecimal subsistRate;

    /**
     * 交付期限
     */
    private String deliverDate;

    /**
     * 状态（-1.作废 0.未支付 1.预付款已支付 2.全款已支付）
     */
    private String status;

    /**
     * 备注
     */
    private String content;

    /**
     * 尾款
     */
    private BigDecimal balancePayment;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 修改时间
     */
    private String updateDate;

    /**
     * 删除标识
     */
    private String delFlag;


}
