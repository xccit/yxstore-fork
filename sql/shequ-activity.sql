/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : shequ-activity

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 07/09/2023 11:04:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity_info
-- ----------------------------
DROP TABLE IF EXISTS `activity_info`;
CREATE TABLE `activity_info`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '活动id',
  `activity_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动名称',
  `activity_type` tinyint(0) NOT NULL DEFAULT 1 COMMENT '活动类型（1：满减，2：折扣）',
  `activity_desc` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动描述',
  `start_time` date NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` date NULL DEFAULT NULL COMMENT '结束时间',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '活动表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity_info
-- ----------------------------
INSERT INTO `activity_info` VALUES (1, '端午部分蔬菜活动', 1, '端午部分蔬菜活动的', '2023-06-18', '2023-06-24', '2021-06-06 00:00:00', '2021-06-28 10:29:07', 0);
INSERT INTO `activity_info` VALUES (2, '元旦满减券', 1, '2022年元旦满减券', '2023-01-01', '2023-01-03', '2021-11-11 12:47:26', '2021-11-11 04:47:25', 0);
INSERT INTO `activity_info` VALUES (3, '端午及618双满减', 2, '迎接端午佳节,赶上618', '2023-06-18', '2023-06-25', '2023-06-18 10:58:59', '2023-06-18 10:58:59', 0);
INSERT INTO `activity_info` VALUES (4, '618手机大促', 1, '手机大促销,进店有礼品', '2023-06-18', '2023-06-18', '2023-06-18 17:25:32', '2023-06-18 18:07:39', 1);

-- ----------------------------
-- Table structure for activity_rule
-- ----------------------------
DROP TABLE IF EXISTS `activity_rule`;
CREATE TABLE `activity_rule`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `activity_id` int(0) NULL DEFAULT NULL COMMENT '类型',
  `activity_type` tinyint(0) NOT NULL DEFAULT 1 COMMENT '活动类型（1：满减，2：折扣）',
  `condition_amount` decimal(16, 2) NULL DEFAULT NULL COMMENT '满减金额',
  `condition_num` bigint(0) NULL DEFAULT NULL COMMENT '满减件数',
  `benefit_amount` decimal(16, 2) NULL DEFAULT NULL COMMENT '优惠金额',
  `benefit_discount` decimal(10, 2) NULL DEFAULT NULL COMMENT '优惠折扣',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '优惠规则' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity_rule
-- ----------------------------
INSERT INTO `activity_rule` VALUES (1, 1, 1, 10.00, NULL, 2.00, NULL, '2021-06-06 18:28:25', '2023-06-18 17:01:27', 1);
INSERT INTO `activity_rule` VALUES (2, 1, 1, 29.00, NULL, 6.00, NULL, '2021-06-06 18:28:25', '2023-06-18 17:01:27', 1);
INSERT INTO `activity_rule` VALUES (3, 2, 1, 20.00, NULL, 5.00, NULL, '2021-11-11 04:47:51', '2023-06-18 17:22:33', 1);
INSERT INTO `activity_rule` VALUES (4, 1, 1, 10.00, NULL, 2.00, NULL, '2021-06-06 18:28:25', '2023-06-18 17:01:59', 1);
INSERT INTO `activity_rule` VALUES (5, 1, 1, 29.00, NULL, 6.00, NULL, '2021-06-06 18:28:25', '2023-06-18 17:01:59', 1);
INSERT INTO `activity_rule` VALUES (6, 1, 1, 10.00, NULL, 2.00, NULL, '2021-06-06 18:28:25', '2023-06-18 17:07:22', 1);
INSERT INTO `activity_rule` VALUES (7, 1, 1, 29.00, NULL, 6.00, NULL, '2021-06-06 18:28:25', '2023-06-18 17:07:22', 1);
INSERT INTO `activity_rule` VALUES (8, 1, 1, 5000.00, NULL, 300.00, NULL, '2023-06-18 17:07:53', '2023-06-18 17:07:53', 0);
INSERT INTO `activity_rule` VALUES (9, 2, 1, 80.00, NULL, 2.00, NULL, '2023-06-18 17:22:33', '2023-06-18 17:22:33', 0);
INSERT INTO `activity_rule` VALUES (10, 3, 2, 80.00, 3, 2.00, 8.00, '2023-06-18 17:22:55', '2023-06-18 17:22:55', 0);
INSERT INTO `activity_rule` VALUES (11, 4, 1, 3600.00, NULL, 500.00, NULL, '2023-06-18 17:27:19', '2023-06-18 18:01:47', 1);
INSERT INTO `activity_rule` VALUES (12, 4, 1, 3600.00, NULL, 500.00, NULL, '2023-06-18 17:27:19', '2023-06-18 18:05:50', 1);
INSERT INTO `activity_rule` VALUES (13, 4, 1, 3600.00, NULL, 500.00, NULL, '2023-06-18 17:27:19', '2023-06-18 17:27:19', 0);

-- ----------------------------
-- Table structure for activity_sku
-- ----------------------------
DROP TABLE IF EXISTS `activity_sku`;
CREATE TABLE `activity_sku`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `activity_id` bigint(0) NULL DEFAULT NULL COMMENT '活动id ',
  `sku_id` bigint(0) NULL DEFAULT NULL COMMENT 'sku_id',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '活动参与商品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity_sku
-- ----------------------------
INSERT INTO `activity_sku` VALUES (1, 1, 1, '2023-06-18 17:07:22', '2023-06-18 17:07:53', 1);
INSERT INTO `activity_sku` VALUES (2, 1, 1, '2023-06-18 17:07:53', '2023-06-18 17:07:53', 0);
INSERT INTO `activity_sku` VALUES (3, 2, 2, '2023-06-18 17:22:33', '2023-06-18 17:22:33', 0);
INSERT INTO `activity_sku` VALUES (4, 3, 2, '2023-06-18 17:22:55', '2023-06-18 17:22:55', 0);
INSERT INTO `activity_sku` VALUES (5, 4, 5, '2023-06-18 17:27:19', '2023-06-18 18:01:47', 1);
INSERT INTO `activity_sku` VALUES (6, 4, 5, '2023-06-18 18:01:47', '2023-06-18 18:05:50', 1);

-- ----------------------------
-- Table structure for coupon_info
-- ----------------------------
DROP TABLE IF EXISTS `coupon_info`;
CREATE TABLE `coupon_info`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `coupon_type` tinyint(0) NOT NULL DEFAULT 1 COMMENT '购物券类型 1 现金券 2 满减券',
  `coupon_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '优惠卷名字',
  `amount` decimal(10, 2) NOT NULL COMMENT '金额',
  `condition_amount` decimal(10, 2) NOT NULL COMMENT '使用门槛 0->没门槛',
  `start_time` date NULL DEFAULT NULL COMMENT '可以领取的开始日期',
  `end_time` date NULL DEFAULT NULL COMMENT '可以领取的结束日期',
  `range_type` tinyint(0) NOT NULL DEFAULT 1 COMMENT '使用范围[1->全场通用；2->指定分类；3->指定商品]',
  `range_desc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '使用范围描述',
  `publish_count` int(0) NOT NULL DEFAULT 1 COMMENT '发行数量',
  `per_limit` int(0) NOT NULL DEFAULT 1 COMMENT '每人限领张数',
  `use_count` int(0) NOT NULL DEFAULT 0 COMMENT '已使用数量',
  `receive_count` int(0) NOT NULL DEFAULT 0 COMMENT '领取数量',
  `expire_time` datetime(0) NULL DEFAULT NULL COMMENT '过期时间',
  `publish_status` tinyint(1) NULL DEFAULT NULL COMMENT '发布状态[0-未发布，1-已发布]',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '优惠券信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coupon_info
-- ----------------------------
INSERT INTO `coupon_info` VALUES (1, 1, '端午满9元减2元', 2.00, 9.00, '2023-06-18', '2023-06-18', 2, '可购买：OPPO Reno10Pro', 100, 1, 0, 5, '2023-06-18 20:00:00', NULL, '2023-06-17 20:00:00', '2023-06-19 20:00:05', 0);
INSERT INTO `coupon_info` VALUES (2, 1, '端午优惠券15减3元', 3.00, 15.00, '2023-06-18', '2023-06-18', 2, '可购买：西红柿', 100, 1, 0, 5, '2023-06-18 20:00:00', NULL, '2023-06-17 20:00:00', '2023-06-19 20:00:05', 0);
INSERT INTO `coupon_info` VALUES (3, 2, '国庆通用现金券', 1.50, 0.00, '2023-06-18', '2023-06-18', 1, '可购买全场通用', 100, 1, 0, 5, '2023-06-18 20:00:00', NULL, '2023-06-17 20:00:00', '2023-06-18 21:39:24', 0);
INSERT INTO `coupon_info` VALUES (4, 2, '元旦通用卷', 1.00, 0.00, '2023-06-18', '2023-06-18', 1, '可购买全场通用', 100, 1, 0, 5, '2023-06-18 20:00:00', NULL, '2023-06-17 20:00:00', '2023-06-18 21:39:24', 0);
INSERT INTO `coupon_info` VALUES (5, 2, '双11现金券', 0.00, 0.00, '2023-06-18', '2023-06-18', 1, '可购买全场通用', 100, 1, 0, 2, '2023-06-18 20:00:00', NULL, '2023-06-17 20:00:00', '2023-06-18 21:39:24', 0);
INSERT INTO `coupon_info` VALUES (6, 2, '元旦现金券', 2.00, 0.00, '2023-06-18', '2023-06-18', 1, '可购买全场通用', 100, 1, 0, 1, '2023-06-18 20:00:00', NULL, '2023-06-17 20:00:00', '2023-06-18 21:37:27', 0);

-- ----------------------------
-- Table structure for coupon_info_1
-- ----------------------------
DROP TABLE IF EXISTS `coupon_info_1`;
CREATE TABLE `coupon_info_1`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `coupon_type` tinyint(1) NULL DEFAULT NULL COMMENT '优惠卷类型[0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券]',
  `coupon_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '优惠卷名字',
  `num` int(0) NULL DEFAULT NULL COMMENT '数量',
  `amount` decimal(18, 4) NULL DEFAULT NULL COMMENT '金额',
  `per_limit` int(0) NULL DEFAULT NULL COMMENT '每人限领张数',
  `condition_amount` decimal(18, 4) NULL DEFAULT NULL COMMENT '使用门槛 0->没门槛',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '使用开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '使用结束时间',
  `range_type` tinyint(1) NULL DEFAULT NULL COMMENT '使用范围[0->全场通用；1->指定分类；2->指定商品]',
  `range_desc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '使用范围描述',
  `publish_count` int(0) NULL DEFAULT NULL COMMENT '发行数量',
  `use_count` int(0) NULL DEFAULT NULL COMMENT '已使用数量',
  `receive_count` int(0) NULL DEFAULT NULL COMMENT '领取数量',
  `enable_start_time` datetime(0) NULL DEFAULT NULL COMMENT '可以领取的开始日期',
  `enable_end_time` datetime(0) NULL DEFAULT NULL COMMENT '可以领取的结束日期',
  `publish_status` tinyint(1) NULL DEFAULT NULL COMMENT '发布状态[0-未发布，1-已发布]',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 1 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '优惠券信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coupon_info_1
-- ----------------------------

-- ----------------------------
-- Table structure for coupon_range
-- ----------------------------
DROP TABLE IF EXISTS `coupon_range`;
CREATE TABLE `coupon_range`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '购物券编号',
  `coupon_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '优惠券id',
  `range_type` tinyint(0) NOT NULL DEFAULT 1 COMMENT '范围类型； 1->商品(sku) ；2->分类',
  `range_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '根据range_type决定,range_type为sku,则range_id为sku_id',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '优惠券范围表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coupon_range
-- ----------------------------
INSERT INTO `coupon_range` VALUES (1, 1, 2, 3, '2023-06-06 18:30:06', '2023-06-19 20:18:26', 1);
INSERT INTO `coupon_range` VALUES (2, 1, 2, 4, '2023-06-06 18:30:06', '2023-06-19 20:18:26', 1);
INSERT INTO `coupon_range` VALUES (3, 1, 2, 1, '2023-06-06 18:30:28', '2023-06-19 20:18:26', 1);
INSERT INTO `coupon_range` VALUES (4, 2, 2, 6, '2023-06-17 11:37:24', '2023-06-19 20:18:42', 1);
INSERT INTO `coupon_range` VALUES (5, 2, 2, 2, '2023-06-17 11:37:31', '2023-06-19 20:18:42', 1);
INSERT INTO `coupon_range` VALUES (6, 2, 2, 5, '2023-06-14 09:20:31', '2023-06-19 20:18:51', 1);
INSERT INTO `coupon_range` VALUES (7, 1, 2, 1, '2023-06-19 19:57:44', '2023-06-19 20:00:38', 1);
INSERT INTO `coupon_range` VALUES (8, 1, 2, 3, '2023-06-19 19:57:44', '2023-06-19 20:00:38', 1);
INSERT INTO `coupon_range` VALUES (9, 2, 2, 2, '2023-06-19 19:58:20', '2023-06-19 19:58:20', 0);
INSERT INTO `coupon_range` VALUES (10, 1, 2, 5, '2023-06-19 20:03:54', '2023-06-19 20:06:38', 1);
INSERT INTO `coupon_range` VALUES (11, 1, 2, 5, '2023-06-19 20:08:17', '2023-06-19 20:08:17', 0);

-- ----------------------------
-- Table structure for coupon_use
-- ----------------------------
DROP TABLE IF EXISTS `coupon_use`;
CREATE TABLE `coupon_use`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `coupon_id` bigint(0) NULL DEFAULT NULL COMMENT '购物券ID',
  `user_id` bigint(0) NULL DEFAULT NULL COMMENT '用户ID',
  `order_id` bigint(0) NULL DEFAULT NULL COMMENT '订单ID',
  `coupon_status` tinyint(0) NULL DEFAULT NULL COMMENT '购物券状态（1：未使用 2：已使用）',
  `get_type` tinyint(0) NOT NULL DEFAULT 2 COMMENT '获取类型（1：后台赠送；2：主动获取）',
  `get_time` datetime(0) NULL DEFAULT NULL COMMENT '获取时间',
  `using_time` datetime(0) NULL DEFAULT NULL COMMENT '使用时间',
  `used_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `expire_time` datetime(0) NULL DEFAULT NULL COMMENT '过期时间',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '优惠券领用表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coupon_use
-- ----------------------------
INSERT INTO `coupon_use` VALUES (1, 3, 1, 3, 2, 2, '2021-09-29 10:10:36', '2021-11-23 16:40:51', NULL, '2021-10-07 00:00:00', '2021-09-29 02:10:35', '2021-11-23 08:40:50', 0);
INSERT INTO `coupon_use` VALUES (2, 4, 1, NULL, 1, 2, '2021-09-29 10:10:37', NULL, NULL, '2022-09-30 00:00:00', '2021-09-29 02:10:37', '2021-09-29 02:10:37', 0);
INSERT INTO `coupon_use` VALUES (3, 2, 23, 43, 2, 2, '2021-09-29 13:26:32', '2021-09-29 13:33:05', NULL, '2022-08-26 00:00:00', '2021-09-29 05:26:32', '2021-09-29 05:33:05', 0);
INSERT INTO `coupon_use` VALUES (4, 3, 23, 46, 2, 2, '2021-09-29 13:27:04', '2021-09-30 07:41:22', NULL, '2021-10-07 00:00:00', '2021-09-29 05:27:03', '2021-09-29 23:41:22', 0);
INSERT INTO `coupon_use` VALUES (5, 3, 26, 44, 2, 2, '2021-09-29 17:24:35', '2021-09-29 17:31:28', NULL, '2021-10-07 00:00:00', '2021-09-29 09:24:34', '2021-09-29 09:31:27', 0);
INSERT INTO `coupon_use` VALUES (6, 4, 26, NULL, 1, 2, '2021-09-29 17:24:36', NULL, NULL, '2022-09-30 00:00:00', '2021-09-29 09:24:36', '2021-09-29 09:24:36', 0);
INSERT INTO `coupon_use` VALUES (7, 4, 23, 49, 2, 2, '2021-10-12 15:17:17', '2021-10-13 09:51:17', NULL, '2022-09-30 00:00:00', '2021-10-12 07:17:16', '2021-10-13 01:51:16', 0);
INSERT INTO `coupon_use` VALUES (8, 5, 23, NULL, 1, 2, '2021-10-19 08:14:29', NULL, NULL, '2021-11-30 00:00:00', '2021-10-19 00:14:29', '2021-10-19 00:14:29', 0);
INSERT INTO `coupon_use` VALUES (9, 2, 28, 116, 2, 2, '2021-10-24 10:20:24', '2021-11-23 15:18:29', NULL, '2022-08-26 00:00:00', '2021-10-24 02:20:24', '2021-11-23 07:18:28', 0);
INSERT INTO `coupon_use` VALUES (10, 4, 28, 157, 2, 2, '2021-11-12 16:22:50', '2021-11-25 10:51:24', NULL, '2022-09-30 00:00:00', '2021-11-12 08:22:50', '2021-11-25 02:51:23', 0);
INSERT INTO `coupon_use` VALUES (11, 3, 28, NULL, 1, 2, '2021-11-12 16:22:56', NULL, NULL, '2021-10-07 00:00:00', '2021-11-12 08:22:56', '2021-11-12 08:22:56', 0);
INSERT INTO `coupon_use` VALUES (12, 6, 28, 161, 2, 2, '2021-11-12 16:22:59', '2021-11-26 09:25:32', NULL, '2022-01-12 00:00:00', '2021-11-12 08:22:58', '2021-11-26 01:25:31', 0);
INSERT INTO `coupon_use` VALUES (13, 5, 28, NULL, 1, 2, '2021-11-16 15:17:17', NULL, NULL, '2021-11-30 00:00:00', '2021-11-16 07:17:16', '2021-11-16 07:17:16', 0);
INSERT INTO `coupon_use` VALUES (14, 1, 28, 88, 2, 2, '2021-11-18 09:51:44', '2021-11-22 19:07:36', NULL, '2022-07-02 00:00:00', '2021-11-18 01:51:44', '2021-11-22 11:07:35', 0);
INSERT INTO `coupon_use` VALUES (15, 1, 1, NULL, 1, 2, '2021-11-24 10:00:33', NULL, '2021-11-24 10:38:27', '2022-07-02 00:00:00', '2021-11-24 02:00:33', '2021-11-24 02:38:27', 0);
INSERT INTO `coupon_use` VALUES (16, 2, 1, NULL, 1, 2, '2021-11-25 15:15:35', NULL, NULL, '2022-08-26 00:00:00', '2021-11-25 07:15:35', '2021-11-25 07:15:35', 0);

-- ----------------------------
-- Table structure for home_subject
-- ----------------------------
DROP TABLE IF EXISTS `home_subject`;
CREATE TABLE `home_subject`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专题名字',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专题标题',
  `sub_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专题副标题',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '显示状态',
  `url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详情连接',
  `sort` int(0) NULL DEFAULT NULL COMMENT '排序',
  `img` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专题图片地址',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 1 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of home_subject
-- ----------------------------

-- ----------------------------
-- Table structure for home_subject_sku
-- ----------------------------
DROP TABLE IF EXISTS `home_subject_sku`;
CREATE TABLE `home_subject_sku`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专题名字',
  `subject_id` bigint(0) NULL DEFAULT NULL COMMENT '专题id',
  `sku_id` bigint(0) NULL DEFAULT NULL COMMENT 'sku_id',
  `sort` int(0) NULL DEFAULT NULL COMMENT '排序',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 1 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '专题商品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of home_subject_sku
-- ----------------------------

-- ----------------------------
-- Table structure for seckill
-- ----------------------------
DROP TABLE IF EXISTS `seckill`;
CREATE TABLE `seckill`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动标题',
  `start_time` date NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` date NULL DEFAULT NULL COMMENT '结束时间',
  `status` tinyint(0) NULL DEFAULT NULL COMMENT '上下线状态',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '秒杀活动' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of seckill
-- ----------------------------
INSERT INTO `seckill` VALUES (1, '端午秒杀活动', '2021-06-15', '2022-07-10', 1, '2021-06-06 20:16:15', '2023-02-26 00:19:09', 0);
INSERT INTO `seckill` VALUES (2, '', NULL, NULL, 0, '2021-11-17 12:25:37', '2021-12-15 16:27:46', 1);
INSERT INTO `seckill` VALUES (3, '', NULL, NULL, 0, '2021-11-17 12:26:13', '2021-12-15 16:27:43', 1);

-- ----------------------------
-- Table structure for seckill_sku
-- ----------------------------
DROP TABLE IF EXISTS `seckill_sku`;
CREATE TABLE `seckill_sku`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `seckill_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '秒杀活动id',
  `seckill_time_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '活动场次id',
  `sku_id` bigint(0) NOT NULL DEFAULT 0 COMMENT 'skuId',
  `sku_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'sku名称',
  `img_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `seckill_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '秒杀价格',
  `seckill_stock` decimal(10, 0) NULL DEFAULT NULL COMMENT '秒杀库存',
  `seckill_limit` decimal(10, 0) NULL DEFAULT NULL COMMENT '每人限购数量',
  `seckill_sale` int(0) NOT NULL DEFAULT 0 COMMENT '秒杀销量',
  `seckill_sort` int(0) NULL DEFAULT NULL COMMENT '排序',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '秒杀活动商品关联' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of seckill_sku
-- ----------------------------
INSERT INTO `seckill_sku` VALUES (6, 1, 2, 8, '茄子', 'http://47.93.148.192:9000/gmall/20210817/微信图片_202108171124077.jpg', 3.00, 9, 1, 19, 1, '2021-09-27 11:14:00', '2021-12-17 11:26:48', 0);
INSERT INTO `seckill_sku` VALUES (7, 1, 3, 9, '玉米', 'http://47.93.148.192:9000/gmall/20210817/微信图片_202108171124072.jpg', 1.50, 9, 1, 1, 1, '2021-09-27 11:15:01', '2021-11-22 06:37:03', 0);
INSERT INTO `seckill_sku` VALUES (8, 1, 5, 7, '辣椒', 'http://47.93.148.192:9000/gmall/20210817/微信图片_202108171124074.jpg', 3.00, 2, 1, 8, 1, '2021-09-27 11:20:39', '2021-11-23 08:47:22', 0);

-- ----------------------------
-- Table structure for seckill_sku_notice
-- ----------------------------
DROP TABLE IF EXISTS `seckill_sku_notice`;
CREATE TABLE `seckill_sku_notice`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(0) NULL DEFAULT NULL COMMENT 'user_id',
  `sku_id` bigint(0) NULL DEFAULT NULL COMMENT 'sku_id',
  `session_id` bigint(0) NULL DEFAULT NULL COMMENT '活动场次id',
  `subcribe_time` datetime(0) NULL DEFAULT NULL COMMENT '订阅时间',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发送时间',
  `notice_type` tinyint(1) NULL DEFAULT NULL COMMENT '通知方式[0-短信，1-邮件]',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '秒杀商品通知订阅' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of seckill_sku_notice
-- ----------------------------

-- ----------------------------
-- Table structure for seckill_time
-- ----------------------------
DROP TABLE IF EXISTS `seckill_time`;
CREATE TABLE `seckill_time`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '场次名称',
  `start_time` time(0) NULL DEFAULT NULL COMMENT '每日开始时间',
  `end_time` time(0) NULL DEFAULT NULL COMMENT '每日结束时间',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '启用状态',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '秒杀活动场次' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of seckill_time
-- ----------------------------
INSERT INTO `seckill_time` VALUES (1, '08:00', '08:00:00', '23:00:00', 1, '2021-06-06 20:18:53', '2022-06-29 19:44:43', 0);
INSERT INTO `seckill_time` VALUES (2, '12:00', '12:00:00', '23:00:00', 1, '2021-06-06 20:19:07', '2021-06-07 09:02:38', 0);
INSERT INTO `seckill_time` VALUES (3, '14:00', '14:00:00', '23:00:00', 2, '2021-06-06 20:19:33', '2021-11-24 10:17:52', 0);
INSERT INTO `seckill_time` VALUES (4, '16:00', '16:00:00', '23:00:00', 1, '2021-06-06 20:19:50', '2021-09-11 21:14:19', 0);
INSERT INTO `seckill_time` VALUES (5, '18:00', '18:00:00', '23:00:00', 1, '2021-06-06 20:20:04', '2021-09-11 21:14:22', 0);
INSERT INTO `seckill_time` VALUES (6, '', NULL, NULL, 1, '2021-11-17 12:13:56', '2022-04-28 10:37:11', 0);
INSERT INTO `seckill_time` VALUES (7, '', NULL, NULL, 0, '2021-11-17 12:20:32', '2021-11-17 12:20:32', 0);
INSERT INTO `seckill_time` VALUES (8, '', NULL, NULL, 0, '2021-11-17 12:24:06', '2021-11-17 12:24:06', 0);
INSERT INTO `seckill_time` VALUES (9, '', NULL, NULL, 0, '2021-11-17 12:24:06', '2021-11-17 12:24:06', 0);
INSERT INTO `seckill_time` VALUES (10, '', NULL, NULL, 0, '2021-11-17 12:24:06', '2021-11-17 12:24:06', 0);
INSERT INTO `seckill_time` VALUES (11, '', NULL, NULL, 0, '2021-11-17 12:24:07', '2021-11-17 12:24:07', 0);
INSERT INTO `seckill_time` VALUES (12, '', NULL, NULL, 0, '2021-11-17 12:24:07', '2021-11-17 12:24:07', 0);
INSERT INTO `seckill_time` VALUES (13, '', NULL, NULL, 0, '2021-11-17 12:32:13', '2021-11-17 12:32:13', 0);
INSERT INTO `seckill_time` VALUES (14, '', NULL, NULL, 0, '2021-11-18 01:40:06', '2021-11-18 01:40:06', 0);
INSERT INTO `seckill_time` VALUES (15, '', NULL, NULL, 0, '2021-11-24 10:08:05', '2021-11-24 10:08:05', 0);

SET FOREIGN_KEY_CHECKS = 1;
