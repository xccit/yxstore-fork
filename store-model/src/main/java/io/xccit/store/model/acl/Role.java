//
//
package io.xccit.store.model.acl;

import io.xccit.store.model.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xccit-dev
 * @date 2023-06-09
 * @description 角色
 */
@Data
@ApiModel(description = "角色")
@TableName("role")
public class Role extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "角色名称")
	@TableField("role_name")
	private String roleName;

	@ApiModelProperty(value = "备注")
	@TableField("remark")
	private String remark;

}

