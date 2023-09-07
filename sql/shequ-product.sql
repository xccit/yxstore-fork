/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : shequ-product

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 07/09/2023 11:04:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attr
-- ----------------------------
DROP TABLE IF EXISTS `attr`;
CREATE TABLE `attr`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '属性id',
  `name` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性名',
  `input_type` int(0) NULL DEFAULT NULL COMMENT '属性录入方式：0->手工录入；1->从列表中选取',
  `select_list` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '可选值列表[用逗号分隔]',
  `attr_group_id` bigint(0) NULL DEFAULT NULL COMMENT '属性分组id',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品属性' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of attr
-- ----------------------------
INSERT INTO `attr` VALUES (1, '颜色', 1, '深空灰,暗夜紫,极地银', 1, '2023-06-17 17:45:14', '2023-06-17 17:45:14', 0);
INSERT INTO `attr` VALUES (2, '价格', 0, '', 1, '2023-06-17 17:45:22', '2023-06-17 17:45:22', 0);
INSERT INTO `attr` VALUES (3, '品牌', 0, '', 1, '2023-06-17 17:45:39', '2023-06-17 17:45:39', 0);
INSERT INTO `attr` VALUES (4, '储存方式', 1, '冷藏,常温', 2, '2023-06-17 17:58:15', '2023-06-17 17:58:15', 0);
INSERT INTO `attr` VALUES (5, '产地', 0, '', 2, '2023-06-17 17:58:51', '2023-06-17 17:58:51', 0);
INSERT INTO `attr` VALUES (6, '净重', 0, '', 2, '2023-06-17 17:59:14', '2023-06-17 17:59:14', 0);

-- ----------------------------
-- Table structure for attr_group
-- ----------------------------
DROP TABLE IF EXISTS `attr_group`;
CREATE TABLE `attr_group`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '分组id',
  `name` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组名',
  `sort` int(0) NULL DEFAULT NULL COMMENT '排序',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '属性分组' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of attr_group
-- ----------------------------
INSERT INTO `attr_group` VALUES (1, '数码潮流', 1, '数码潮流', '2023-06-17 17:44:49', '2023-06-17 17:44:49', 0);
INSERT INTO `attr_group` VALUES (2, '蔬菜生鲜', 2, '蔬菜生鲜', '2023-06-17 17:57:43', '2023-06-17 17:57:43', 0);

-- ----------------------------
-- Table structure for base_category_trademark
-- ----------------------------
DROP TABLE IF EXISTS `base_category_trademark`;
CREATE TABLE `base_category_trademark`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `category3_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '三级级分类id',
  `trademark_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '品牌id',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '三级分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_category_trademark
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `name` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '分类名称',
  `img_url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `parent_id` bigint(0) NULL DEFAULT NULL COMMENT '父分类id',
  `status` tinyint(0) NULL DEFAULT NULL COMMENT '是否显示[0-不显示，1显示]',
  `sort` int(0) NULL DEFAULT NULL COMMENT '排序',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品三级分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '母婴用品', NULL, NULL, NULL, 1, '2023-06-17 17:40:01', '2023-06-17 17:40:01', 0);
INSERT INTO `category` VALUES (2, '日用百货', NULL, NULL, NULL, 2, '2023-06-17 17:40:20', '2023-06-17 17:40:20', 0);
INSERT INTO `category` VALUES (3, '蔬菜生鲜', NULL, NULL, NULL, 3, '2023-06-17 17:40:37', '2023-06-17 17:40:37', 0);
INSERT INTO `category` VALUES (4, '水果零食', NULL, NULL, NULL, 4, '2023-06-17 17:41:11', '2023-06-17 17:41:11', 0);
INSERT INTO `category` VALUES (5, '潮流单品', NULL, NULL, NULL, 5, '2023-06-17 17:41:19', '2023-06-17 17:41:19', 0);
INSERT INTO `category` VALUES (6, '数码家电', NULL, NULL, NULL, 6, '2023-06-17 17:41:30', '2023-06-17 17:41:30', 0);
INSERT INTO `category` VALUES (7, '数码家电', NULL, NULL, NULL, 1, '2023-06-17 17:44:29', '2023-06-17 17:44:36', 1);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sku_id` bigint(0) NULL DEFAULT NULL COMMENT 'sku_id',
  `sku_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名字',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员昵称',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `star` tinyint(1) NULL DEFAULT NULL COMMENT '星级',
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员ip',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '显示状态[0-不显示，1-显示]',
  `follow_count` int(0) NULL DEFAULT NULL COMMENT '点赞数',
  `reply_count` int(0) NULL DEFAULT NULL COMMENT '回复数',
  `resources` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `type` tinyint(0) NULL DEFAULT NULL COMMENT '评论类型[0 - 对商品的直接评论，1 - 对评论的回复]',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品评价' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for comment_replay
-- ----------------------------
DROP TABLE IF EXISTS `comment_replay`;
CREATE TABLE `comment_replay`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `comment_id` bigint(0) NULL DEFAULT NULL,
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 1 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品评价回复表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment_replay
-- ----------------------------

-- ----------------------------
-- Table structure for mq_repeat_record
-- ----------------------------
DROP TABLE IF EXISTS `mq_repeat_record`;
CREATE TABLE `mq_repeat_record`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `business_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务编号',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'mq去重表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mq_repeat_record
-- ----------------------------

-- ----------------------------
-- Table structure for region_ware
-- ----------------------------
DROP TABLE IF EXISTS `region_ware`;
CREATE TABLE `region_ware`  (
  `id` bigint(0) NOT NULL DEFAULT 0 COMMENT 'id',
  `region` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '开通区域',
  `region_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '区域名称',
  `ware_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '仓库',
  `ware_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '仓库名称',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 1 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '城市仓库关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of region_ware
-- ----------------------------

-- ----------------------------
-- Table structure for sku_attr_value
-- ----------------------------
DROP TABLE IF EXISTS `sku_attr_value`;
CREATE TABLE `sku_attr_value`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sku_id` bigint(0) NULL DEFAULT NULL COMMENT '商品id',
  `attr_id` bigint(0) NULL DEFAULT NULL COMMENT '属性id',
  `attr_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性名',
  `attr_value` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性值',
  `sort` int(0) NULL DEFAULT NULL COMMENT '顺序',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 269 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'spu属性值' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sku_attr_value
-- ----------------------------
INSERT INTO `sku_attr_value` VALUES (249, 1, 1, '颜色', '极地银', NULL, '2023-06-17 17:56:13', '2023-06-17 17:56:13', 0);
INSERT INTO `sku_attr_value` VALUES (250, 1, 2, '价格', '5999', NULL, '2023-06-17 17:56:13', '2023-06-17 17:56:13', 0);
INSERT INTO `sku_attr_value` VALUES (251, 1, 3, '品牌', '苹果', NULL, '2023-06-17 17:56:13', '2023-06-17 17:56:13', 0);
INSERT INTO `sku_attr_value` VALUES (252, 2, 4, '储存方式', '冷藏', NULL, '2023-06-17 18:00:18', '2023-06-17 18:00:41', 1);
INSERT INTO `sku_attr_value` VALUES (253, 2, 5, '产地', '甘肃天水', NULL, '2023-06-17 18:00:18', '2023-06-17 18:00:41', 1);
INSERT INTO `sku_attr_value` VALUES (254, 2, 6, '净重', '1.5+0.3kg', NULL, '2023-06-17 18:00:18', '2023-06-17 18:00:41', 1);
INSERT INTO `sku_attr_value` VALUES (255, 2, 4, '储存方式', '冷藏', NULL, '2023-06-17 18:00:41', '2023-06-17 18:00:41', 0);
INSERT INTO `sku_attr_value` VALUES (256, 2, 5, '产地', '甘肃天水', NULL, '2023-06-17 18:00:41', '2023-06-17 18:00:41', 0);
INSERT INTO `sku_attr_value` VALUES (257, 2, 6, '净重', '1.5+0.3kg', NULL, '2023-06-17 18:00:41', '2023-06-17 18:00:41', 0);
INSERT INTO `sku_attr_value` VALUES (258, 3, 4, '储存方式', '常温', NULL, '2023-06-17 18:01:47', '2023-06-17 18:04:00', 1);
INSERT INTO `sku_attr_value` VALUES (259, 3, 5, '产地', '甘肃天水', NULL, '2023-06-17 18:01:47', '2023-06-17 18:04:00', 1);
INSERT INTO `sku_attr_value` VALUES (260, 3, 6, '净重', '1.5+0.3kg', NULL, '2023-06-17 18:01:47', '2023-06-17 18:04:00', 1);
INSERT INTO `sku_attr_value` VALUES (261, 3, 4, '储存方式', '常温', NULL, '2023-06-17 18:04:00', '2023-06-17 18:04:00', 0);
INSERT INTO `sku_attr_value` VALUES (262, 3, 5, '产地', '甘肃天水', NULL, '2023-06-17 18:04:00', '2023-06-17 18:04:00', 0);
INSERT INTO `sku_attr_value` VALUES (263, 3, 6, '净重', '1.5+0.3kg', NULL, '2023-06-17 18:04:00', '2023-06-17 18:04:00', 0);
INSERT INTO `sku_attr_value` VALUES (264, 4, 4, '储存方式', '常温', NULL, '2023-06-17 18:06:53', '2023-06-17 18:06:53', 0);
INSERT INTO `sku_attr_value` VALUES (265, 4, 5, '产地', '甘肃定西', NULL, '2023-06-17 18:06:53', '2023-06-17 18:06:53', 0);
INSERT INTO `sku_attr_value` VALUES (266, 4, 6, '净重', '3.0+0.5kg', NULL, '2023-06-17 18:06:53', '2023-06-17 18:06:53', 0);
INSERT INTO `sku_attr_value` VALUES (267, 5, 1, '颜色', '极地银', NULL, '2023-06-18 17:26:51', '2023-06-18 17:26:51', 0);
INSERT INTO `sku_attr_value` VALUES (268, 5, 2, '价格', '3999', NULL, '2023-06-18 17:26:51', '2023-06-18 17:26:51', 0);
INSERT INTO `sku_attr_value` VALUES (269, 5, 3, '品牌', 'OPPO', NULL, '2023-06-18 17:26:51', '2023-06-18 17:26:51', 0);

-- ----------------------------
-- Table structure for sku_detail
-- ----------------------------
DROP TABLE IF EXISTS `sku_detail`;
CREATE TABLE `sku_detail`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sku_id` bigint(0) NULL DEFAULT NULL COMMENT '商品id',
  `detail_html` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '详情内容',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'spu属性值' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sku_detail
-- ----------------------------

-- ----------------------------
-- Table structure for sku_image
-- ----------------------------
DROP TABLE IF EXISTS `sku_image`;
CREATE TABLE `sku_image`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sku_id` bigint(0) NULL DEFAULT NULL COMMENT 'sku_id',
  `img_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片名称',
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  `sort` int(0) NULL DEFAULT NULL COMMENT '排序',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品图片' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sku_image
-- ----------------------------
INSERT INTO `sku_image` VALUES (1, 1, 'IMG_0389.JPG', 'http://yxstore-xccit.oss-cn-beijing.aliyuncs.com/2023/06/17/00e27dfd547f4498b7571555ed0cb9c5IMG_0389.JPG', NULL, '2023-06-17 17:56:13', '2023-06-17 17:56:13', 0);
INSERT INTO `sku_image` VALUES (2, 2, 'IMG_0389.JPG', 'http://yxstore-xccit.oss-cn-beijing.aliyuncs.com/2023/06/17/00e27dfd547f4498b7571555ed0cb9c5IMG_0389.JPG', NULL, '2023-06-17 18:00:18', '2023-06-17 18:00:41', 1);
INSERT INTO `sku_image` VALUES (3, 2, 'xhs.jpg', 'http://yxstore-xccit.oss-cn-beijing.aliyuncs.com/2023/06/17/0f7c1d97263c47d1a28fe58f396a45e1xhs.jpg', NULL, '2023-06-17 18:00:18', '2023-06-17 18:00:41', 1);
INSERT INTO `sku_image` VALUES (4, 2, 'xhs.jpg', 'http://yxstore-xccit.oss-cn-beijing.aliyuncs.com/2023/06/17/0f7c1d97263c47d1a28fe58f396a45e1xhs.jpg', NULL, '2023-06-17 18:00:18', '2023-06-17 18:00:18', 0);
INSERT INTO `sku_image` VALUES (5, 3, 'IMG_0389.JPG', 'http://yxstore-xccit.oss-cn-beijing.aliyuncs.com/2023/06/17/00e27dfd547f4498b7571555ed0cb9c5IMG_0389.JPG', NULL, '2023-06-17 18:01:47', '2023-06-17 18:04:00', 1);
INSERT INTO `sku_image` VALUES (6, 3, 'xhs.jpg', 'http://yxstore-xccit.oss-cn-beijing.aliyuncs.com/2023/06/17/0f7c1d97263c47d1a28fe58f396a45e1xhs.jpg', NULL, '2023-06-17 18:01:47', '2023-06-17 18:04:00', 1);
INSERT INTO `sku_image` VALUES (7, 3, 'qz.jpg', 'http://yxstore-xccit.oss-cn-beijing.aliyuncs.com/2023/06/17/fd3c696e8a0d43689d3f6e481e7adad5qz.jpg', NULL, '2023-06-17 18:01:47', '2023-06-17 18:04:00', 1);
INSERT INTO `sku_image` VALUES (8, 3, 'qz.jpg', 'http://yxstore-xccit.oss-cn-beijing.aliyuncs.com/2023/06/17/fd3c696e8a0d43689d3f6e481e7adad5qz.jpg', NULL, '2023-06-17 18:01:47', '2023-06-17 18:01:47', 0);
INSERT INTO `sku_image` VALUES (9, 4, 'hs.jpg', 'http://yxstore-xccit.oss-cn-beijing.aliyuncs.com/2023/06/17/80b091bfcfdb4929a14ff8d7920312b5hs.jpg', NULL, '2023-06-17 18:06:53', '2023-06-17 18:06:53', 0);

-- ----------------------------
-- Table structure for sku_info
-- ----------------------------
DROP TABLE IF EXISTS `sku_info`;
CREATE TABLE `sku_info`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '分类id',
  `attr_group_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '平台属性分组id',
  `sku_type` tinyint(1) NOT NULL DEFAULT 0 COMMENT '商品类型：0->普通商品 1->秒杀商品',
  `sku_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT 'sku名称',
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '展示图片',
  `per_limit` int(0) NOT NULL DEFAULT 1 COMMENT '限购个数/每天（0：不限购）',
  `publish_status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '上架状态：0->下架；1->上架',
  `check_status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '审核状态：0->未审核；1->审核通过',
  `is_new_person` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否新人专享：0->否；1->是',
  `sort` int(0) NOT NULL DEFAULT 0 COMMENT '排序',
  `sku_code` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'sku编码',
  `price` decimal(10, 2) NOT NULL COMMENT '价格',
  `market_price` decimal(10, 2) NOT NULL COMMENT '市场价',
  `stock` int(0) NOT NULL DEFAULT 0 COMMENT '库存',
  `lock_stock` int(0) NOT NULL DEFAULT 0 COMMENT '锁定库存',
  `low_stock` int(0) NOT NULL DEFAULT 0 COMMENT '预警库存',
  `sale` int(0) NOT NULL DEFAULT 0 COMMENT '销量',
  `ware_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '仓库',
  `version` bigint(0) NOT NULL DEFAULT 0,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'sku信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sku_info
-- ----------------------------
INSERT INTO `sku_info` VALUES (1, 6, 1, 0, 'iPhone13礼盒', 'http://yxstore-xccit.oss-cn-beijing.aliyuncs.com/2023/06/17/00e27dfd547f4498b7571555ed0cb9c5IMG_0389.JPG', 1, 1, 1, 1, 1, '20230617001', 5999.00, 6999.00, 100, 0, 5, 0, 0, 0, '2023-06-17 17:56:13', '2023-06-17 17:56:13', 0);
INSERT INTO `sku_info` VALUES (2, 3, 2, 0, '西红柿', 'http://yxstore-xccit.oss-cn-beijing.aliyuncs.com/2023/06/17/0f7c1d97263c47d1a28fe58f396a45e1xhs.jpg', 1, 1, 1, 0, 2, '20230617002', 2.30, 3.00, 100, 0, 5, 0, 0, 0, '2023-06-17 18:00:18', '2023-06-17 18:00:18', 0);
INSERT INTO `sku_info` VALUES (3, 3, 2, 0, '茄子', 'http://yxstore-xccit.oss-cn-beijing.aliyuncs.com/2023/06/17/fd3c696e8a0d43689d3f6e481e7adad5qz.jpg', 1, 0, 0, 0, 3, '20230617003', 2.50, 3.80, 200, 0, 20, 0, 0, 0, '2023-06-17 18:01:47', '2023-06-17 18:01:47', 0);
INSERT INTO `sku_info` VALUES (4, 3, 2, 0, '红薯', 'http://yxstore-xccit.oss-cn-beijing.aliyuncs.com/2023/06/17/80b091bfcfdb4929a14ff8d7920312b5hs.jpg', 1, 0, 0, 0, 4, '20230617004', 6.50, 10.00, 100, 0, 10, 0, 0, 0, '2023-06-17 18:06:53', '2023-06-17 18:06:53', 0);
INSERT INTO `sku_info` VALUES (5, 6, 1, 0, 'OPPO Reno10Pro', '', 1, 0, 0, 1, 17, '20230618001', 3999.00, 4699.00, 100, 0, 0, 0, 0, 0, '2023-06-18 17:26:51', '2023-06-18 17:26:51', 0);

-- ----------------------------
-- Table structure for sku_poster
-- ----------------------------
DROP TABLE IF EXISTS `sku_poster`;
CREATE TABLE `sku_poster`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `sku_id` bigint(0) NULL DEFAULT NULL COMMENT '商品id',
  `img_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名称',
  `img_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件路径',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品海报表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sku_poster
-- ----------------------------
INSERT INTO `sku_poster` VALUES (1, 1, 'IMG_0389.JPG', 'http://yxstore-xccit.oss-cn-beijing.aliyuncs.com/2023/06/17/d4d01b3164394192b65183977215d741IMG_0389.JPG', '2023-06-17 17:56:13', '2023-06-17 17:56:13', 0);
INSERT INTO `sku_poster` VALUES (2, 1, 'IMG_0388.JPG', 'http://yxstore-xccit.oss-cn-beijing.aliyuncs.com/2023/06/17/b81b6d8e011541f39cae26ccbc157b10IMG_0388.JPG', '2023-06-17 17:56:13', '2023-06-17 17:56:13', 0);
INSERT INTO `sku_poster` VALUES (3, 2, 'IMG_0389.JPG', 'http://yxstore-xccit.oss-cn-beijing.aliyuncs.com/2023/06/17/d4d01b3164394192b65183977215d741IMG_0389.JPG', '2023-06-17 18:00:18', '2023-06-17 18:00:41', 1);
INSERT INTO `sku_poster` VALUES (4, 2, 'IMG_0388.JPG', 'http://yxstore-xccit.oss-cn-beijing.aliyuncs.com/2023/06/17/b81b6d8e011541f39cae26ccbc157b10IMG_0388.JPG', '2023-06-17 18:00:18', '2023-06-17 18:00:41', 1);
INSERT INTO `sku_poster` VALUES (5, 2, 'xhs.jpg', 'http://yxstore-xccit.oss-cn-beijing.aliyuncs.com/2023/06/17/db0b1a6da67d46b6b31eb55c4dbfdfebxhs.jpg', '2023-06-17 18:00:18', '2023-06-17 18:00:41', 1);
INSERT INTO `sku_poster` VALUES (6, 2, 'xhs.jpg', 'http://yxstore-xccit.oss-cn-beijing.aliyuncs.com/2023/06/17/db0b1a6da67d46b6b31eb55c4dbfdfebxhs.jpg', '2023-06-17 18:00:18', '2023-06-17 18:00:18', 0);
INSERT INTO `sku_poster` VALUES (7, 3, 'IMG_0389.JPG', 'http://yxstore-xccit.oss-cn-beijing.aliyuncs.com/2023/06/17/d4d01b3164394192b65183977215d741IMG_0389.JPG', '2023-06-17 18:01:47', '2023-06-17 18:04:00', 1);
INSERT INTO `sku_poster` VALUES (8, 3, 'IMG_0388.JPG', 'http://yxstore-xccit.oss-cn-beijing.aliyuncs.com/2023/06/17/b81b6d8e011541f39cae26ccbc157b10IMG_0388.JPG', '2023-06-17 18:01:47', '2023-06-17 18:04:00', 1);
INSERT INTO `sku_poster` VALUES (9, 3, 'xhs.jpg', 'http://yxstore-xccit.oss-cn-beijing.aliyuncs.com/2023/06/17/db0b1a6da67d46b6b31eb55c4dbfdfebxhs.jpg', '2023-06-17 18:01:47', '2023-06-17 18:04:00', 1);
INSERT INTO `sku_poster` VALUES (10, 3, 'qz.jpg', 'http://yxstore-xccit.oss-cn-beijing.aliyuncs.com/2023/06/17/d944ab07b150409a9a0dd59db2c48f1bqz.jpg', '2023-06-17 18:01:47', '2023-06-17 18:04:00', 1);
INSERT INTO `sku_poster` VALUES (11, 3, 'qz.jpg', 'http://yxstore-xccit.oss-cn-beijing.aliyuncs.com/2023/06/17/d944ab07b150409a9a0dd59db2c48f1bqz.jpg', '2023-06-17 18:01:47', '2023-06-17 18:01:47', 0);
INSERT INTO `sku_poster` VALUES (12, 4, 'hs.jpg', 'http://yxstore-xccit.oss-cn-beijing.aliyuncs.com/2023/06/17/6e182047bb8b4babb51e1f782b2bc474hs.jpg', '2023-06-17 18:06:53', '2023-06-17 18:06:53', 0);

-- ----------------------------
-- Table structure for sku_stock_history
-- ----------------------------
DROP TABLE IF EXISTS `sku_stock_history`;
CREATE TABLE `sku_stock_history`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `sku_id` bigint(0) NOT NULL DEFAULT 0,
  `price` decimal(10, 2) NOT NULL COMMENT '销售价格',
  `stock` int(0) NOT NULL DEFAULT 0 COMMENT '库存',
  `sale` int(0) NOT NULL DEFAULT 0 COMMENT '销量',
  `sale_date` date NULL DEFAULT NULL COMMENT '销售日期',
  `ware_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '仓库',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 1 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'sku的库存历史记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sku_stock_history
-- ----------------------------

-- ----------------------------
-- Table structure for ware
-- ----------------------------
DROP TABLE IF EXISTS `ware`;
CREATE TABLE `ware`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `province` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省code',
  `city` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '城市code',
  `district` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区域code',
  `detail_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `longitude` decimal(10, 7) NULL DEFAULT NULL COMMENT '经度',
  `latitude` decimal(10, 7) NULL DEFAULT NULL COMMENT '纬度',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '仓库表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ware
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
