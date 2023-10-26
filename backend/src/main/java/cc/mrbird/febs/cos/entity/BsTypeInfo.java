package cc.mrbird.febs.cos.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 项目类型管理
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BsTypeInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类型编号
     */
    private String code;

    /**
     * 项目类型名称
     */
    private String typeName;

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


}
