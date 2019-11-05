/*
 Navicat Premium Data Transfer

 Source Server         : mysql1_mater
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : test2

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 04/11/2019 11:39:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(3) NULL DEFAULT NULL,
  `sex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `del_flag` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否删除：1是，0否',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '武大郎', 56, '1', '2019-11-04 09:50:40', '0');
INSERT INTO `sys_user` VALUES (2, '宋江', 60, '1', '2019-11-04 09:50:56', '0');
INSERT INTO `sys_user` VALUES (3, '武松', 50, '1', '2019-11-04 09:51:10', '0');
INSERT INTO `sys_user` VALUES (4, '阎婆惜', 30, '0', '2019-11-04 09:51:28', '0');
INSERT INTO `sys_user` VALUES (5, '西门庆', 30, '1', '2019-11-04 09:51:46', '0');
INSERT INTO `sys_user` VALUES (6, '林冲', 50, '1', '2019-11-04 11:25:33', '0');
INSERT INTO `sys_user` VALUES (7, '孙二娘', 30, '0', '2019-11-04 11:25:33', '0');
INSERT INTO `sys_user` VALUES (8, '孙二娘', 33333, '0', '2019-11-04 11:25:33', '0');
INSERT INTO `sys_user` VALUES (9, '孙二娘', 123456, '0', '2019-11-04 11:25:33', '0');
INSERT INTO `sys_user` VALUES (10, '孙二娘', 123456, '0', '2019-11-04 11:25:33', '0');
INSERT INTO `sys_user` VALUES (11, '123', 45, '0', '2019-11-04 11:25:33', '0');

SET FOREIGN_KEY_CHECKS = 1;
