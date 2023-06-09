package io.xccit.store.vo.product;

import io.xccit.store.model.product.*;
import io.xccit.store.model.product.SkuAttrValue;
import io.xccit.store.model.product.SkuImage;
import io.xccit.store.model.product.SkuInfo;
import io.xccit.store.model.product.SkuPoster;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SkuInfoVo extends SkuInfo {

	@ApiModelProperty(value = "海报列表")
	private List<SkuPoster> skuPosterList;

	@ApiModelProperty(value = "属性值")
	private List<SkuAttrValue> skuAttrValueList;

	@ApiModelProperty(value = "图片")
	private List<SkuImage> skuImagesList;

}

