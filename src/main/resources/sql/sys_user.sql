/*
 Navicat MySQL Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : artwork

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 02/04/2020 09:51:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `userName` varchar(100) DEFAULT NULL COMMENT '登录名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `status` varchar(10) DEFAULT '0',
  `delFlag` varchar(10) DEFAULT NULL,
  `userType` varchar(255) DEFAULT NULL,
  `createBy` varchar(100) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateBy` varchar(100) DEFAULT NULL,
  `addressCode` varchar(255) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `addressDetail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `SYS_USER_LOGIN_NAME` (`userName`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (1, 'admin', 'c4ca4238a0b923820dcc509a6f75849b', '管理员', '0', '1', '1', '1', '2020-03-16 11:49:37', '1', '河南省/信阳市/新县', '2020-03-16 11:49:41', '老家11');
INSERT INTO `sys_user` VALUES (2, 'fuwushang001', '1', '服务商001', '0', '0', '2', NULL, '2020-03-16 12:51:47', NULL, NULL, '2020-03-16 12:51:47', NULL);
INSERT INTO `sys_user` VALUES (3, 'fuwushang002', '1', '服务商002', '0', '1', '2', NULL, '2020-03-16 13:04:29', NULL, NULL, '2020-03-16 13:04:29', NULL);
INSERT INTO `sys_user` VALUES (4, 'dls001', '1', '代理商001', '0', '1', '3', NULL, '2020-03-16 13:05:08', NULL, NULL, '2020-03-16 13:05:08', NULL);
INSERT INTO `sys_user` VALUES (5, 'fws001', '1', '服务商001', '1', '1', '2', NULL, '2020-03-16 13:05:37', NULL, NULL, '2020-03-25 03:12:17', NULL);
INSERT INTO `sys_user` VALUES (6, 'fws002', '1', '服务商002', '1', '1', '2', NULL, '2020-03-16 13:06:32', NULL, NULL, '2020-03-16 13:06:32', NULL);
INSERT INTO `sys_user` VALUES (7, 'dls002', '1', '代理商002', '0', '1', '3', NULL, '2020-03-16 13:07:10', NULL, NULL, '2020-03-16 13:07:10', NULL);
INSERT INTO `sys_user` VALUES (9, 'fws003', '1', '服务商003', '1', '1', '2', NULL, '2020-03-27 02:00:39', NULL, NULL, '2020-03-27 02:00:51', NULL);
INSERT INTO `sys_user` VALUES (21, 'ceshi1', 'c4ca4238a0b923820dcc509a6f75849b', '1', '0', NULL, '', NULL, NULL, NULL, NULL, NULL, '6667');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
