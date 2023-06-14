package io.xccit.store.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品海报表
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SkuPoster implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品id
     */
    private Long skuId;

    /**
     * 文件名称
     */
    private String imgName;

    /**
     * 文件路径
     */
    private String imgUrl;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer isDeleted;


}
