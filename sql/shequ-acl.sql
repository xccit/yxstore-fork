/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : shequ-acl

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 07/09/2023 11:04:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '会员id',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '密码',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机',
  `ware_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '仓库id（默认为：0为平台用户）',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uname`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '0192023a7bbd73250516f069df18b500', '管理员', NULL, 0, '2023-06-11 21:27:35', '2023-06-11 21:27:35', 0);
INSERT INTO `admin` VALUES (2, 'xccit', '3ca5ae21f3ba089e6df7fb37f809f0e8', '姚小昕', NULL, 0, '2023-06-11 21:27:55', '2023-06-11 21:27:55', 0);
INSERT INTO `admin` VALUES (3, 'hppadmin', 'e4c7951dffef5a2ec78bea320f351135', '胡佩佩', NULL, 0, '2023-06-11 21:28:36', '2023-06-11 21:28:36', 0);
INSERT INTO `admin` VALUES (4, 'wmmadmin', 'b14476af42139c3d50c9474b13798be6', '王苗苗', NULL, 0, '2023-06-11 21:28:56', '2023-06-11 21:28:56', 0);
INSERT INTO `admin` VALUES (5, 'lpadmin', '7ac588d90fb21ba052091b429b585b0f', '吕鹏', NULL, 0, '2023-06-11 21:29:17', '2023-06-11 21:29:17', 0);

-- ----------------------------
-- Table structure for admin_login_log
-- ----------------------------
DROP TABLE IF EXISTS `admin_login_log`;
CREATE TABLE `admin_login_log`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(0) NULL DEFAULT NULL,
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_agent` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '浏览器登录类型',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户登录日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for admin_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '角色id',
  `admin_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '用户id',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_role_id`(`role_id`) USING BTREE,
  INDEX `idx_user_id`(`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_role
-- ----------------------------
INSERT INTO `admin_role` VALUES (1, 1, 1, '2023-06-12 21:37:33', '2023-06-12 21:55:11', 1);
INSERT INTO `admin_role` VALUES (2, 2, 1, '2023-06-12 21:37:33', '2023-06-12 21:55:11', 1);
INSERT INTO `admin_role` VALUES (3, 3, 1, '2023-06-12 21:37:33', '2023-06-12 21:55:11', 1);
INSERT INTO `admin_role` VALUES (4, 4, 1, '2023-06-12 21:37:33', '2023-06-12 21:55:11', 1);
INSERT INTO `admin_role` VALUES (5, 5, 1, '2023-06-12 21:37:33', '2023-06-12 21:55:11', 1);
INSERT INTO `admin_role` VALUES (6, 6, 1, '2023-06-12 21:37:33', '2023-06-12 21:55:11', 1);
INSERT INTO `admin_role` VALUES (7, 7, 1, '2023-06-12 21:37:33', '2023-06-12 21:55:11', 1);
INSERT INTO `admin_role` VALUES (8, 8, 1, '2023-06-12 21:37:33', '2023-06-12 21:55:11', 1);
INSERT INTO `admin_role` VALUES (9, 1, 2, '2023-06-12 21:37:57', '2023-06-12 21:37:57', 0);
INSERT INTO `admin_role` VALUES (10, 2, 2, '2023-06-12 21:37:57', '2023-06-12 21:37:57', 0);
INSERT INTO `admin_role` VALUES (11, 3, 2, '2023-06-12 21:37:57', '2023-06-12 21:37:57', 0);
INSERT INTO `admin_role` VALUES (12, 1, 3, '2023-06-12 21:38:04', '2023-06-12 21:38:04', 0);
INSERT INTO `admin_role` VALUES (13, 6, 5, '2023-06-12 21:38:10', '2023-06-12 21:38:10', 0);
INSERT INTO `admin_role` VALUES (14, 6, 4, '2023-06-12 21:38:13', '2023-06-12 21:38:13', 0);
INSERT INTO `admin_role` VALUES (15, 5, 4, '2023-06-12 21:38:13', '2023-06-12 21:38:13', 0);
INSERT INTO `admin_role` VALUES (16, 1, 1, '2023-06-12 21:55:11', '2023-06-12 21:55:11', 0);
INSERT INTO `admin_role` VALUES (17, 2, 1, '2023-06-12 21:55:11', '2023-06-12 21:55:11', 0);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `pid` bigint(0) NOT NULL DEFAULT 0 COMMENT '所属上级',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '名称',
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称code',
  `to_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '跳转页面code',
  `type` tinyint(0) NOT NULL DEFAULT 0 COMMENT '类型(1:菜单,2:按钮)',
  `status` tinyint(0) NULL DEFAULT NULL COMMENT '状态(0:禁止,1:正常)',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_pid`(`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 104 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '权限' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, 0, '全部菜单', NULL, NULL, 1, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (2, 1, '权限管理', 'Acl', NULL, 1, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (3, 2, '用户管理', 'User', NULL, 1, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (4, 2, '角色管理', 'Role', NULL, 1, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (5, 2, '菜单管理', 'Permission', NULL, 1, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (6, 3, '分配角色', 'btn.User.assgin', NULL, 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (7, 3, '添加', 'btn.User.add', NULL, 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (8, 3, '修改', 'btn.User.update', NULL, 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (9, 3, '删除', 'btn.User.remove', NULL, 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (10, 4, '修改', 'btn.Role.update', NULL, 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (11, 4, '分配权限', 'btn.Role.assgin', 'RoleAuth', 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (12, 4, '添加', 'btn.Role.add', NULL, 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (13, 4, '删除', 'btn.Role.remove', NULL, 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (14, 4, '角色权限', 'role.acl', NULL, 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 1);
INSERT INTO `permission` VALUES (15, 5, '查看', 'btn.permission.list', NULL, 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (16, 5, '添加', 'btn.Permission.add', NULL, 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (17, 5, '修改', 'btn.Permission.update', NULL, 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (18, 5, '删除', 'btn.Permission.remove', NULL, 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (19, 1, '订单管理', 'Order', NULL, 1, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (20, 19, '订单列表', 'OrderInfo', '', 1, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (21, 19, '发货列表', 'DetailList', NULL, 1, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (22, 19, '订单详情', 'btn.OrderInfo.show', 'OrderInfoShow', 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (23, 1, '商品管理', 'Product', NULL, 1, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (24, 23, '商品分类', 'Category', NULL, 1, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (25, 24, '添加分类', 'btn.Category.add', 'CategoryAdd', 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (26, 24, '修改分类', 'btn.Category.edit', 'CategoryEdit', 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (27, 23, '平台属性分组', 'AttrGroup', '', 1, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (28, 27, '添加', 'btn.AttrGroup.add', 'AttrGroupAdd', 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (29, 27, '修改', 'btn.AttrGroup.edit', 'AttrGroupEdit', 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (30, 27, '平台属性列表', 'btn.AttrGroup.list', 'AttrList', 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (31, 27, '属性添加', NULL, 'AttrAdd', 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (32, 27, '属性修改', NULL, 'AttrEdit', 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (33, 23, 'SKU列表', 'SkuInfo', NULL, 1, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (34, 33, '添加', NULL, 'SkuInfoAdd', 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (35, 33, '修改', NULL, 'SkuInfoEdit', 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (36, 1, '营销活动管理', 'Activity', NULL, 1, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (37, 36, '活动列表', 'ActivityInfo', NULL, 1, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (38, 37, '添加', '', 'ActivityInfoAdd', 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (39, 37, '修改', NULL, 'ActivityInfoEdit', 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (40, 36, '优惠券列表', 'CouponInfo', NULL, 1, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (41, 40, '添加', NULL, 'CouponInfoAdd', 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (42, 40, '修改', NULL, 'CouponInfoEdit', 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (43, 40, '规则', NULL, 'CouponInfoRule', 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (44, 37, '规则', NULL, 'ActivityInfoRule', 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (45, 36, '秒杀活动列表', 'Seckill', NULL, 1, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (46, 45, '秒杀时间段', NULL, 'SeckillTime', 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (47, 45, '秒杀时间段选择', NULL, 'SelectSeckillTime', 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (48, 45, '秒杀商品列表', NULL, 'SeckillSku', 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (49, 1, '团长管理', 'Leader', NULL, 1, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (50, 49, '团长待审核', 'LeaderCheck', '', 1, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (51, 49, '团长已审核', 'leader', NULL, 1, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (52, 1, '系统管理', 'Sys', NULL, 1, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (53, 52, '开通区域', 'RegionWare', NULL, 1, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (54, 3, '查看', 'btn.User.list', NULL, 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (55, 4, '查看', ' btn.Role.list', '', 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 0);
INSERT INTO `permission` VALUES (100, 1, '全部', 'btn.all', NULL, 2, NULL, '2023-06-13 20:52:05', '2023-06-13 20:52:05', 1);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '角色名称',
  `role_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色编码',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '系统管理员', NULL, NULL, '2023-06-11 21:26:14', '2023-06-11 21:26:14', 0);
INSERT INTO `role` VALUES (2, '平台管理员', NULL, NULL, '2023-06-11 21:26:21', '2023-06-11 21:26:21', 0);
INSERT INTO `role` VALUES (3, '区域仓库管理员', NULL, NULL, '2023-06-11 21:26:33', '2023-06-11 21:26:33', 0);
INSERT INTO `role` VALUES (4, '产品管理员', NULL, NULL, '2023-06-11 21:26:48', '2023-06-11 21:26:48', 0);
INSERT INTO `role` VALUES (5, '区域运营', NULL, NULL, '2023-06-11 21:26:54', '2023-06-11 21:26:54', 0);
INSERT INTO `role` VALUES (6, '产品录入', NULL, NULL, '2023-06-11 21:46:05', '2023-06-11 21:46:05', 0);
INSERT INTO `role` VALUES (7, '产品审核人员', NULL, NULL, '2023-06-11 21:46:56', '2023-06-11 21:46:56', 0);
INSERT INTO `role` VALUES (8, '团长管理员', NULL, NULL, '2023-06-11 21:47:02', '2023-06-11 21:47:02', 0);

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(0) NOT NULL DEFAULT 0,
  `permission_id` bigint(0) NOT NULL DEFAULT 0,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_role_id`(`role_id`) USING BTREE,
  INDEX `idx_permission_id`(`permission_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 298 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (1, 1, 1, '2021-05-31 18:09:40', '2023-06-13 22:01:08', 1);
INSERT INTO `role_permission` VALUES (2, 1, 2, '2021-05-31 18:09:44', '2023-06-13 22:01:08', 1);
INSERT INTO `role_permission` VALUES (3, 1, 3, '2021-05-31 18:09:51', '2023-06-13 22:01:08', 1);
INSERT INTO `role_permission` VALUES (4, 1, 4, '2021-05-31 18:09:55', '2023-06-13 22:01:08', 1);
INSERT INTO `role_permission` VALUES (5, 1, 5, '2021-05-31 18:09:59', '2023-06-13 22:01:08', 1);
INSERT INTO `role_permission` VALUES (6, 1, 6, '2021-05-31 18:10:04', '2023-06-13 22:01:08', 1);
INSERT INTO `role_permission` VALUES (7, 1, 7, '2021-05-31 18:10:11', '2023-06-13 22:01:08', 1);
INSERT INTO `role_permission` VALUES (8, 1, 8, '2021-05-31 18:10:16', '2023-06-13 22:01:08', 1);
INSERT INTO `role_permission` VALUES (9, 1, 9, '2021-05-31 18:10:20', '2023-06-13 22:01:08', 1);
INSERT INTO `role_permission` VALUES (10, 1, 10, '2021-05-31 18:10:26', '2023-06-13 22:01:08', 1);
INSERT INTO `role_permission` VALUES (11, 1, 11, '2021-05-31 18:10:30', '2023-06-13 22:01:08', 1);
INSERT INTO `role_permission` VALUES (12, 2, 1, '2021-06-01 08:46:02', '2021-06-18 17:14:17', 1);
INSERT INTO `role_permission` VALUES (13, 2, 2, '2021-06-01 08:46:02', '2021-06-18 17:14:17', 1);
INSERT INTO `role_permission` VALUES (14, 2, 3, '2021-06-01 08:46:02', '2021-06-18 17:14:17', 1);
INSERT INTO `role_permission` VALUES (15, 2, 6, '2021-06-01 08:46:02', '2021-06-18 17:14:17', 1);
INSERT INTO `role_permission` VALUES (16, 2, 7, '2021-06-01 08:46:02', '2021-06-18 17:14:17', 1);
INSERT INTO `role_permission` VALUES (17, 2, 8, '2021-06-01 08:46:02', '2021-06-18 17:14:17', 1);
INSERT INTO `role_permission` VALUES (18, 2, 9, '2021-06-01 08:46:02', '2021-06-18 17:14:17', 1);
INSERT INTO `role_permission` VALUES (19, 2, 4, '2021-06-01 08:46:02', '2021-06-18 17:14:17', 1);
INSERT INTO `role_permission` VALUES (20, 2, 10, '2021-06-01 08:46:02', '2021-06-18 17:14:17', 1);
INSERT INTO `role_permission` VALUES (21, 2, 11, '2021-06-01 08:46:02', '2021-06-18 17:14:17', 1);
INSERT INTO `role_permission` VALUES (22, 2, 12, '2021-06-01 08:46:02', '2021-06-18 17:14:17', 1);
INSERT INTO `role_permission` VALUES (23, 2, 13, '2021-06-01 08:46:02', '2021-06-18 17:14:17', 1);
INSERT INTO `role_permission` VALUES (24, 3, 1, '2021-06-18 17:12:49', '2021-06-18 17:14:31', 1);
INSERT INTO `role_permission` VALUES (25, 3, 23, '2021-06-18 17:12:49', '2021-06-18 17:14:31', 1);
INSERT INTO `role_permission` VALUES (26, 3, 33, '2021-06-18 17:12:49', '2021-06-18 17:14:31', 1);
INSERT INTO `role_permission` VALUES (27, 3, 34, '2021-06-18 17:12:49', '2021-06-18 17:14:31', 1);
INSERT INTO `role_permission` VALUES (28, 3, 35, '2021-06-18 17:12:49', '2021-06-18 17:14:31', 1);
INSERT INTO `role_permission` VALUES (29, 3, 36, '2021-06-18 17:12:49', '2021-06-18 17:14:31', 1);
INSERT INTO `role_permission` VALUES (30, 3, 37, '2021-06-18 17:12:49', '2021-06-18 17:14:31', 1);
INSERT INTO `role_permission` VALUES (31, 3, 38, '2021-06-18 17:12:49', '2021-06-18 17:14:31', 1);
INSERT INTO `role_permission` VALUES (32, 3, 39, '2021-06-18 17:12:49', '2021-06-18 17:14:31', 1);
INSERT INTO `role_permission` VALUES (33, 3, 44, '2021-06-18 17:12:49', '2021-06-18 17:14:31', 1);
INSERT INTO `role_permission` VALUES (34, 3, 40, '2021-06-18 17:12:49', '2021-06-18 17:14:31', 1);
INSERT INTO `role_permission` VALUES (35, 3, 41, '2021-06-18 17:12:49', '2021-06-18 17:14:31', 1);
INSERT INTO `role_permission` VALUES (36, 3, 42, '2021-06-18 17:12:50', '2021-06-18 17:14:31', 1);
INSERT INTO `role_permission` VALUES (37, 3, 43, '2021-06-18 17:12:50', '2021-06-18 17:14:31', 1);
INSERT INTO `role_permission` VALUES (38, 3, 45, '2021-06-18 17:12:50', '2021-06-18 17:14:31', 1);
INSERT INTO `role_permission` VALUES (39, 3, 46, '2021-06-18 17:12:50', '2021-06-18 17:14:31', 1);
INSERT INTO `role_permission` VALUES (40, 3, 47, '2021-06-18 17:12:50', '2021-06-18 17:14:31', 1);
INSERT INTO `role_permission` VALUES (41, 3, 48, '2021-06-18 17:12:50', '2021-06-18 17:14:31', 1);
INSERT INTO `role_permission` VALUES (42, 2, 1, '2021-06-18 17:14:17', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (43, 2, 2, '2021-06-18 17:14:17', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (44, 2, 3, '2021-06-18 17:14:17', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (45, 2, 6, '2021-06-18 17:14:17', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (46, 2, 7, '2021-06-18 17:14:17', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (47, 2, 8, '2021-06-18 17:14:17', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (48, 2, 9, '2021-06-18 17:14:17', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (49, 2, 4, '2021-06-18 17:14:18', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (50, 2, 10, '2021-06-18 17:14:18', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (51, 2, 11, '2021-06-18 17:14:18', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (52, 2, 12, '2021-06-18 17:14:18', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (53, 2, 13, '2021-06-18 17:14:18', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (54, 2, 5, '2021-06-18 17:14:18', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (55, 2, 15, '2021-06-18 17:14:18', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (56, 2, 16, '2021-06-18 17:14:18', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (57, 2, 17, '2021-06-18 17:14:18', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (58, 2, 18, '2021-06-18 17:14:18', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (59, 2, 19, '2021-06-18 17:14:18', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (60, 2, 20, '2021-06-18 17:14:18', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (61, 2, 22, '2021-06-18 17:14:18', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (62, 2, 23, '2021-06-18 17:14:18', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (63, 2, 24, '2021-06-18 17:14:18', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (64, 2, 25, '2021-06-18 17:14:18', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (65, 2, 26, '2021-06-18 17:14:18', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (66, 2, 27, '2021-06-18 17:14:18', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (67, 2, 28, '2021-06-18 17:14:18', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (68, 2, 29, '2021-06-18 17:14:19', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (69, 2, 30, '2021-06-18 17:14:19', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (70, 2, 31, '2021-06-18 17:14:19', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (71, 2, 32, '2021-06-18 17:14:19', '2021-06-18 17:17:38', 1);
INSERT INTO `role_permission` VALUES (72, 3, 1, '2021-06-18 17:14:31', '2021-11-12 00:56:06', 1);
INSERT INTO `role_permission` VALUES (73, 3, 19, '2021-06-18 17:14:31', '2021-11-12 00:56:06', 1);
INSERT INTO `role_permission` VALUES (74, 3, 20, '2021-06-18 17:14:31', '2021-11-12 00:56:06', 1);
INSERT INTO `role_permission` VALUES (75, 3, 21, '2021-06-18 17:14:31', '2021-11-12 00:56:06', 1);
INSERT INTO `role_permission` VALUES (76, 3, 22, '2021-06-18 17:14:31', '2021-11-12 00:56:06', 1);
INSERT INTO `role_permission` VALUES (77, 3, 23, '2021-06-18 17:14:31', '2021-11-12 00:56:06', 1);
INSERT INTO `role_permission` VALUES (78, 3, 33, '2021-06-18 17:14:32', '2021-11-12 00:56:06', 1);
INSERT INTO `role_permission` VALUES (79, 3, 34, '2021-06-18 17:14:32', '2021-11-12 00:56:06', 1);
INSERT INTO `role_permission` VALUES (80, 3, 35, '2021-06-18 17:14:32', '2021-11-12 00:56:06', 1);
INSERT INTO `role_permission` VALUES (81, 3, 36, '2021-06-18 17:14:32', '2021-11-12 00:56:06', 1);
INSERT INTO `role_permission` VALUES (82, 3, 37, '2021-06-18 17:14:32', '2021-11-12 00:56:06', 1);
INSERT INTO `role_permission` VALUES (83, 3, 38, '2021-06-18 17:14:32', '2021-11-12 00:56:06', 1);
INSERT INTO `role_permission` VALUES (84, 3, 39, '2021-06-18 17:14:32', '2021-11-12 00:56:06', 1);
INSERT INTO `role_permission` VALUES (85, 3, 44, '2021-06-18 17:14:32', '2021-11-12 00:56:06', 1);
INSERT INTO `role_permission` VALUES (86, 3, 40, '2021-06-18 17:14:32', '2021-11-12 00:56:06', 1);
INSERT INTO `role_permission` VALUES (87, 3, 41, '2021-06-18 17:14:32', '2021-11-12 00:56:06', 1);
INSERT INTO `role_permission` VALUES (88, 3, 42, '2021-06-18 17:14:32', '2021-11-12 00:56:06', 1);
INSERT INTO `role_permission` VALUES (89, 3, 43, '2021-06-18 17:14:32', '2021-11-12 00:56:06', 1);
INSERT INTO `role_permission` VALUES (90, 3, 45, '2021-06-18 17:14:32', '2021-11-12 00:56:06', 1);
INSERT INTO `role_permission` VALUES (91, 3, 46, '2021-06-18 17:14:32', '2021-11-12 00:56:06', 1);
INSERT INTO `role_permission` VALUES (92, 3, 47, '2021-06-18 17:14:32', '2021-11-12 00:56:06', 1);
INSERT INTO `role_permission` VALUES (93, 3, 48, '2021-06-18 17:14:32', '2021-11-12 00:56:06', 1);
INSERT INTO `role_permission` VALUES (94, 2, 1, '2021-06-18 17:17:39', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (95, 2, 2, '2021-06-18 17:17:39', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (96, 2, 3, '2021-06-18 17:17:39', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (97, 2, 6, '2021-06-18 17:17:39', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (98, 2, 7, '2021-06-18 17:17:39', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (99, 2, 8, '2021-06-18 17:17:39', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (100, 2, 9, '2021-06-18 17:17:39', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (101, 2, 4, '2021-06-18 17:17:39', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (102, 2, 10, '2021-06-18 17:17:39', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (103, 2, 11, '2021-06-18 17:17:39', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (104, 2, 12, '2021-06-18 17:17:39', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (105, 2, 13, '2021-06-18 17:17:40', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (106, 2, 5, '2021-06-18 17:17:40', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (107, 2, 15, '2021-06-18 17:17:40', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (108, 2, 16, '2021-06-18 17:17:40', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (109, 2, 17, '2021-06-18 17:17:40', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (110, 2, 18, '2021-06-18 17:17:40', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (111, 2, 23, '2021-06-18 17:17:40', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (112, 2, 24, '2021-06-18 17:17:40', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (113, 2, 25, '2021-06-18 17:17:40', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (114, 2, 26, '2021-06-18 17:17:40', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (115, 2, 27, '2021-06-18 17:17:40', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (116, 2, 28, '2021-06-18 17:17:40', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (117, 2, 29, '2021-06-18 17:17:40', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (118, 2, 30, '2021-06-18 17:17:40', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (119, 2, 31, '2021-06-18 17:17:40', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (120, 2, 32, '2021-06-18 17:17:40', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (121, 2, 49, '2021-06-18 17:17:40', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (122, 2, 50, '2021-06-18 17:17:40', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (123, 2, 51, '2021-06-18 17:17:40', '2021-06-18 17:22:00', 1);
INSERT INTO `role_permission` VALUES (124, 2, 1, '2021-06-18 17:22:00', '2021-09-27 13:40:48', 1);
INSERT INTO `role_permission` VALUES (125, 2, 19, '2021-06-18 17:22:00', '2021-09-27 13:40:48', 1);
INSERT INTO `role_permission` VALUES (126, 2, 20, '2021-06-18 17:22:00', '2021-09-27 13:40:48', 1);
INSERT INTO `role_permission` VALUES (127, 2, 23, '2021-06-18 17:22:00', '2021-09-27 13:40:48', 1);
INSERT INTO `role_permission` VALUES (128, 2, 24, '2021-06-18 17:22:00', '2021-09-27 13:40:48', 1);
INSERT INTO `role_permission` VALUES (129, 2, 25, '2021-06-18 17:22:00', '2021-09-27 13:40:48', 1);
INSERT INTO `role_permission` VALUES (130, 2, 26, '2021-06-18 17:22:00', '2021-09-27 13:40:48', 1);
INSERT INTO `role_permission` VALUES (131, 2, 27, '2021-06-18 17:22:00', '2021-09-27 13:40:48', 1);
INSERT INTO `role_permission` VALUES (132, 2, 28, '2021-06-18 17:22:00', '2021-09-27 13:40:48', 1);
INSERT INTO `role_permission` VALUES (133, 2, 29, '2021-06-18 17:22:00', '2021-09-27 13:40:48', 1);
INSERT INTO `role_permission` VALUES (134, 2, 30, '2021-06-18 17:22:00', '2021-09-27 13:40:48', 1);
INSERT INTO `role_permission` VALUES (135, 2, 31, '2021-06-18 17:22:00', '2021-09-27 13:40:48', 1);
INSERT INTO `role_permission` VALUES (136, 2, 32, '2021-06-18 17:22:00', '2021-09-27 13:40:48', 1);
INSERT INTO `role_permission` VALUES (137, 2, 49, '2021-06-18 17:22:00', '2021-09-27 13:40:48', 1);
INSERT INTO `role_permission` VALUES (138, 2, 50, '2021-06-18 17:22:00', '2021-09-27 13:40:48', 1);
INSERT INTO `role_permission` VALUES (139, 2, 51, '2021-06-18 17:22:00', '2021-09-27 13:40:48', 1);
INSERT INTO `role_permission` VALUES (140, 4, 1, '2021-09-27 09:39:47', '2021-09-27 09:44:27', 1);
INSERT INTO `role_permission` VALUES (141, 4, 2, '2021-09-27 09:39:47', '2021-09-27 09:44:27', 1);
INSERT INTO `role_permission` VALUES (142, 4, 3, '2021-09-27 09:39:47', '2021-09-27 09:44:27', 1);
INSERT INTO `role_permission` VALUES (143, 4, 6, '2021-09-27 09:39:47', '2021-09-27 09:44:27', 1);
INSERT INTO `role_permission` VALUES (144, 4, 9, '2021-09-27 09:39:47', '2021-09-27 09:44:27', 1);
INSERT INTO `role_permission` VALUES (145, 4, 1, '2021-09-27 09:44:27', '2021-09-27 13:45:22', 1);
INSERT INTO `role_permission` VALUES (146, 4, 2, '2021-09-27 09:44:27', '2021-09-27 13:45:22', 1);
INSERT INTO `role_permission` VALUES (147, 4, 3, '2021-09-27 09:44:27', '2021-09-27 13:45:22', 1);
INSERT INTO `role_permission` VALUES (148, 4, 54, '2021-09-27 09:44:27', '2021-09-27 13:45:22', 1);
INSERT INTO `role_permission` VALUES (149, 4, 4, '2021-09-27 09:44:27', '2021-09-27 13:45:22', 1);
INSERT INTO `role_permission` VALUES (150, 4, 55, '2021-09-27 09:44:27', '2021-09-27 13:45:22', 1);
INSERT INTO `role_permission` VALUES (151, 4, 5, '2021-09-27 09:44:27', '2021-09-27 13:45:22', 1);
INSERT INTO `role_permission` VALUES (152, 4, 15, '2021-09-27 09:44:27', '2021-09-27 13:45:22', 1);
INSERT INTO `role_permission` VALUES (153, 2, 1, '2021-09-27 13:40:48', '2022-01-18 14:46:25', 1);
INSERT INTO `role_permission` VALUES (154, 2, 23, '2021-09-27 13:40:48', '2022-01-18 14:46:25', 1);
INSERT INTO `role_permission` VALUES (155, 2, 24, '2021-09-27 13:40:48', '2022-01-18 14:46:25', 1);
INSERT INTO `role_permission` VALUES (156, 2, 25, '2021-09-27 13:40:48', '2022-01-18 14:46:25', 1);
INSERT INTO `role_permission` VALUES (157, 2, 26, '2021-09-27 13:40:48', '2022-01-18 14:46:25', 1);
INSERT INTO `role_permission` VALUES (158, 2, 27, '2021-09-27 13:40:48', '2022-01-18 14:46:25', 1);
INSERT INTO `role_permission` VALUES (159, 2, 28, '2021-09-27 13:40:48', '2022-01-18 14:46:25', 1);
INSERT INTO `role_permission` VALUES (160, 2, 29, '2021-09-27 13:40:48', '2022-01-18 14:46:25', 1);
INSERT INTO `role_permission` VALUES (161, 2, 30, '2021-09-27 13:40:48', '2022-01-18 14:46:25', 1);
INSERT INTO `role_permission` VALUES (162, 2, 31, '2021-09-27 13:40:48', '2022-01-18 14:46:25', 1);
INSERT INTO `role_permission` VALUES (163, 2, 32, '2021-09-27 13:40:48', '2022-01-18 14:46:25', 1);
INSERT INTO `role_permission` VALUES (164, 2, 100, '2021-09-27 13:40:48', '2022-01-18 14:46:25', 1);
INSERT INTO `role_permission` VALUES (165, 4, 1, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (166, 4, 2, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (167, 4, 3, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (168, 4, 6, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (169, 4, 7, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (170, 4, 8, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (171, 4, 9, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (172, 4, 54, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (173, 4, 4, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (174, 4, 10, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (175, 4, 11, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (176, 4, 12, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (177, 4, 13, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (178, 4, 55, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (179, 4, 5, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (180, 4, 15, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (181, 4, 16, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (182, 4, 17, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (183, 4, 18, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (184, 4, 19, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (185, 4, 20, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (186, 4, 21, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (187, 4, 22, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (188, 4, 23, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (189, 4, 24, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (190, 4, 25, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (191, 4, 26, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (192, 4, 27, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (193, 4, 28, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (194, 4, 29, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (195, 4, 30, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (196, 4, 31, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (197, 4, 32, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (198, 4, 33, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (199, 4, 34, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (200, 4, 35, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (201, 4, 36, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (202, 4, 37, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (203, 4, 38, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (204, 4, 39, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (205, 4, 44, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (206, 4, 40, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (207, 4, 41, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (208, 4, 42, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (209, 4, 43, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (210, 4, 45, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (211, 4, 46, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (212, 4, 47, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (213, 4, 48, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (214, 4, 49, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (215, 4, 50, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (216, 4, 51, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (217, 4, 52, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (218, 4, 53, '2021-09-27 13:45:23', '2021-09-27 13:45:23', 0);
INSERT INTO `role_permission` VALUES (219, 3, 1, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (220, 3, 2, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (221, 3, 3, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (222, 3, 6, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (223, 3, 7, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (224, 3, 8, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (225, 3, 9, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (226, 3, 54, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (227, 3, 4, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (228, 3, 10, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (229, 3, 11, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (230, 3, 12, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (231, 3, 13, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (232, 3, 55, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (233, 3, 5, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (234, 3, 15, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (235, 3, 16, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (236, 3, 17, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (237, 3, 18, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (238, 3, 23, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (239, 3, 33, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (240, 3, 34, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (241, 3, 35, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (242, 3, 36, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (243, 3, 37, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (244, 3, 38, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (245, 3, 39, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (246, 3, 44, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (247, 3, 40, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (248, 3, 41, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (249, 3, 42, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (250, 3, 43, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (251, 3, 45, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (252, 3, 46, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (253, 3, 47, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (254, 3, 48, '2021-11-12 00:56:06', '2021-11-12 00:56:06', 0);
INSERT INTO `role_permission` VALUES (255, 2, 1, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (256, 2, 2, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (257, 2, 3, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (258, 2, 6, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (259, 2, 7, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (260, 2, 8, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (261, 2, 9, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (262, 2, 54, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (263, 2, 4, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (264, 2, 10, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (265, 2, 11, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (266, 2, 12, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (267, 2, 13, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (268, 2, 55, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (269, 2, 5, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (270, 2, 15, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (271, 2, 16, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (272, 2, 17, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (273, 2, 18, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (274, 2, 23, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (275, 2, 24, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (276, 2, 25, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (277, 2, 26, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (278, 2, 27, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (279, 2, 28, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (280, 2, 29, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (281, 2, 30, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (282, 2, 31, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (283, 2, 32, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (284, 2, 52, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (285, 2, 53, '2022-01-18 14:46:25', '2022-01-18 14:46:58', 1);
INSERT INTO `role_permission` VALUES (286, 2, 1, '2022-01-18 14:46:58', '2022-01-18 14:46:58', 0);
INSERT INTO `role_permission` VALUES (287, 2, 23, '2022-01-18 14:46:58', '2022-01-18 14:46:58', 0);
INSERT INTO `role_permission` VALUES (288, 2, 24, '2022-01-18 14:46:58', '2022-01-18 14:46:58', 0);
INSERT INTO `role_permission` VALUES (289, 2, 25, '2022-01-18 14:46:58', '2022-01-18 14:46:58', 0);
INSERT INTO `role_permission` VALUES (290, 2, 26, '2022-01-18 14:46:58', '2022-01-18 14:46:58', 0);
INSERT INTO `role_permission` VALUES (291, 2, 27, '2022-01-18 14:46:58', '2022-01-18 14:46:58', 0);
INSERT INTO `role_permission` VALUES (292, 2, 28, '2022-01-18 14:46:58', '2022-01-18 14:46:58', 0);
INSERT INTO `role_permission` VALUES (293, 2, 29, '2022-01-18 14:46:58', '2022-01-18 14:46:58', 0);
INSERT INTO `role_permission` VALUES (294, 2, 30, '2022-01-18 14:46:58', '2022-01-18 14:46:58', 0);
INSERT INTO `role_permission` VALUES (295, 2, 31, '2022-01-18 14:46:58', '2022-01-18 14:46:58', 0);
INSERT INTO `role_permission` VALUES (296, 2, 32, '2022-01-18 14:46:58', '2022-01-18 14:46:58', 0);
INSERT INTO `role_permission` VALUES (297, 1, 5, '2023-06-13 22:01:08', '2023-06-13 22:01:08', 0);
INSERT INTO `role_permission` VALUES (298, 1, 6, '2023-06-13 22:01:08', '2023-06-13 22:01:08', 0);

SET FOREIGN_KEY_CHECKS = 1;
