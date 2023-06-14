package io.xccit.store.product.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * sku的库存历史记录
 * </p>
 *
 * @author xccit-dev
 * @since 2023-06-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SkuStockHistory implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long skuId;

    /**
     * 销售价格
     */
    private BigDecimal price;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 销量
     */
    private Integer sale;

    /**
     * 销售日期
     */
    private LocalDate saleDate;

    /**
     * 仓库
     */
    private Long wareId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 删除标记（0:不可用 1:可用）
     */
    private Integer isDeleted;


}
