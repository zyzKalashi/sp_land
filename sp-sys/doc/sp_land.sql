/*
 Navicat Premium Data Transfer

 Source Server         : zyz
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : sp_land

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 01/01/2019 23:59:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for area_info
-- ----------------------------
DROP TABLE IF EXISTS `area_info`;
CREATE TABLE `area_info` (
  `pkid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`pkid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for deal_around
-- ----------------------------
DROP TABLE IF EXISTS `deal_around`;
CREATE TABLE `deal_around` (
  `pkid` int(11) NOT NULL AUTO_INCREMENT,
  `deal_info_id` int(11) DEFAULT NULL,
  `area_name` varchar(64) DEFAULT NULL,
  `area` double(11,0) DEFAULT NULL,
  `east` varchar(64) DEFAULT NULL,
  `south` varchar(64) DEFAULT NULL,
  `west` year(4) DEFAULT NULL,
  `north` varchar(64) DEFAULT NULL,
  `showPreice` double(11,0) DEFAULT NULL,
  `payWay` varchar(32) DEFAULT NULL,
  `payLimit` varchar(32) DEFAULT NULL,
  `otherPay` varchar(32) DEFAULT NULL,
  `shouldHave` varchar(32) DEFAULT NULL,
  `overdue` varchar(32) DEFAULT NULL,
  `supplement` varchar(32) DEFAULT NULL,
  `idCardPic` varchar(32) DEFAULT NULL,
  `rightPic` varchar(32) DEFAULT NULL,
  `dealPic` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`pkid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deal_around
-- ----------------------------
BEGIN;
INSERT INTO `deal_around` VALUES (1, 7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `deal_around` VALUES (2, 8, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `deal_around` VALUES (3, 9, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for deal_info
-- ----------------------------
DROP TABLE IF EXISTS `deal_info`;
CREATE TABLE `deal_info` (
  `pkid` int(11) NOT NULL AUTO_INCREMENT,
  `deal_status` int(2) NOT NULL DEFAULT '0',
  `deal_name` varchar(32) DEFAULT NULL COMMENT '项目名称',
  `deal_num` varchar(32) DEFAULT NULL COMMENT '项目编号',
  `deal_address` varchar(256) DEFAULT NULL,
  `output` varchar(256) DEFAULT NULL,
  `right_kind` int(2) DEFAULT NULL,
  `warrant_num` varchar(32) DEFAULT NULL,
  `area_num` double(11,0) DEFAULT NULL,
  `person_name` varchar(32) DEFAULT NULL,
  `other_right_flag` int(2) DEFAULT '0',
  `other_right_name` varchar(32) DEFAULT NULL,
  `other_right_context` varchar(1024) DEFAULT NULL,
  `famer_num` int(11) DEFAULT NULL,
  `old_rent_date` varchar(32) DEFAULT NULL,
  `land_level` varchar(32) DEFAULT NULL,
  `up_things` varchar(512) DEFAULT NULL,
  `traffic` varchar(512) DEFAULT NULL,
  `again_flag` int(2) DEFAULT '0',
  `rent_use` varchar(512) DEFAULT NULL,
  `agree_flag` int(11) DEFAULT '0',
  `old_output` varchar(0) DEFAULT NULL,
  `hope_output` varchar(0) DEFAULT NULL,
  `giveup_right_flag` int(11) DEFAULT '0',
  `assess_org` varchar(0) DEFAULT NULL,
  `assess_date` varchar(0) DEFAULT NULL,
  `assess_value` double(11,0) DEFAULT '0',
  `output_way` varchar(0) DEFAULT NULL,
  `hope_output_date` varchar(0) DEFAULT NULL,
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `create_user` int(11) DEFAULT NULL COMMENT '创建人',
  `update_date` date DEFAULT NULL COMMENT '更新日期',
  `update_user` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`pkid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deal_info
-- ----------------------------
BEGIN;
INSERT INTO `deal_info` VALUES (1, 0, NULL, 'TX-2018-12-31 22:27:41-100100', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, 0, NULL, NULL, 0, NULL, NULL, '2018-12-31', 5, '2018-12-31', 5);
INSERT INTO `deal_info` VALUES (2, 0, NULL, 'TX-2018-12-31 22:34:27-100100', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, 0, NULL, NULL, 0, NULL, NULL, '2018-12-31', 5, '2018-12-31', 5);
INSERT INTO `deal_info` VALUES (3, 0, NULL, 'TX-2018-12-31 22:43:30-100100', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, 0, NULL, NULL, 0, NULL, NULL, '2018-12-31', 5, '2018-12-31', 5);
INSERT INTO `deal_info` VALUES (4, 0, NULL, 'TX-2018-12-31 22:44:21-100100', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, 0, NULL, NULL, 0, NULL, NULL, '2018-12-31', 5, '2018-12-31', 5);
INSERT INTO `deal_info` VALUES (5, 0, NULL, 'TX-2018-12-31 22:46:17-100100', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, 0, NULL, NULL, 0, NULL, NULL, '2018-12-31', 5, '2018-12-31', 5);
INSERT INTO `deal_info` VALUES (6, 0, NULL, 'TX-2018-12-31 22:51:13-100100', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, 0, NULL, NULL, 0, NULL, NULL, '2018-12-31', 5, '2018-12-31', 5);
INSERT INTO `deal_info` VALUES (7, 0, NULL, 'TX-2018-12-31 22:52:56-100100', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, 0, NULL, NULL, 0, NULL, NULL, '2018-12-31', 5, '2018-12-31', 5);
INSERT INTO `deal_info` VALUES (8, 0, NULL, 'TX-2018-12-31 22:54:00-100100', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, 0, NULL, NULL, 0, NULL, NULL, '2018-12-31', 5, '2018-12-31', 5);
INSERT INTO `deal_info` VALUES (9, 0, NULL, 'TX-2018-12-31 22:54:37-100100', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL, 0, NULL, NULL, 0, NULL, NULL, '2018-12-31', 5, '2018-12-31', 5);
COMMIT;

-- ----------------------------
-- Table structure for deal_person
-- ----------------------------
DROP TABLE IF EXISTS `deal_person`;
CREATE TABLE `deal_person` (
  `pkid` int(11) NOT NULL AUTO_INCREMENT,
  `deal_info_id` int(11) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `sex` int(2) DEFAULT '0',
  `mobile` varchar(11) DEFAULT NULL,
  `address` varchar(256) DEFAULT NULL,
  `info_Kind` int(2) DEFAULT NULL,
  PRIMARY KEY (`pkid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deal_person
-- ----------------------------
BEGIN;
INSERT INTO `deal_person` VALUES (1, 7, NULL, 0, NULL, NULL, NULL);
INSERT INTO `deal_person` VALUES (2, 8, NULL, 0, NULL, NULL, NULL);
INSERT INTO `deal_person` VALUES (3, 9, NULL, 0, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `perms` varchar(255) DEFAULT NULL COMMENT '权限',
  `type` int(255) DEFAULT NULL COMMENT '菜单级别;1,2,3',
  `order_num` int(11) DEFAULT NULL,
  `icon_name` varchar(255) DEFAULT NULL COMMENT '样式',
  `date` datetime DEFAULT NULL,
  `classStr` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
BEGIN;
INSERT INTO `menu` VALUES (1, 0, 'URL管理', 'javascript:;', NULL, 1, 1, 'am-icon-user  sidebar-nav-link-logo', NULL, 'sidebar-nav-sub-title urls');
INSERT INTO `menu` VALUES (2, 1, '导入列表', '/urls/urls_import_list', NULL, 2, 2, 'am-icon-user  sidebar-nav-link-logo', NULL, 'sidebar-nav-sub-title urls_import_list');
INSERT INTO `menu` VALUES (3, 1, '导出列表', '/urls/urls_export_list', NULL, 2, 3, 'am-icon-user  sidebar-nav-link-logo', NULL, 'sidebar-nav-sub-title urls_export_list');
INSERT INTO `menu` VALUES (4, 1, 'URL组管理', '/urls/urls_group_list', NULL, 2, 4, 'am-icon-user  sidebar-nav-link-logo', NULL, 'sidebar-nav-sub-title urls_group_list');
INSERT INTO `menu` VALUES (5, 0, '行业管理', '/trade/trade_list', NULL, 1, 2, 'am-icon-user  sidebar-nav-link-logo', NULL, 'sidebar-nav-sub-title usersmanager');
INSERT INTO `menu` VALUES (7, 1, 'URL列表', '/urls/urls_list', NULL, 2, 1, 'am-icon-user  sidebar-nav-link-logo', NULL, 'sidebar-nav-sub-title urls_list');
INSERT INTO `menu` VALUES (8, 1, 'URL列表', '/urls/urls_list', NULL, 2, 1, 'am-icon-user  sidebar-nav-link-logo', NULL, 'sidebar-nav-sub-title urls_list');
INSERT INTO `menu` VALUES (10, 1, 'URL命中次数列表', '/urls/urls_count_list', NULL, 2, 5, 'am-icon-user  sidebar-nav-link-logo', NULL, 'sidebar-nav-sub-title urls_list');
COMMIT;

-- ----------------------------
-- Table structure for notice_info
-- ----------------------------
DROP TABLE IF EXISTS `notice_info`;
CREATE TABLE `notice_info` (
  `pkid` int(11) NOT NULL,
  `notice_status` int(2) NOT NULL DEFAULT '0',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `create_user` int(11) DEFAULT NULL COMMENT '创建人',
  `update_date` date DEFAULT NULL COMMENT '更新日期',
  `update_user` int(11) DEFAULT NULL COMMENT '更新人',
  `title` varchar(64) DEFAULT NULL,
  `company_name` varchar(64) DEFAULT NULL,
  `notice_kind` int(2) DEFAULT NULL,
  `notice_text` text,
  PRIMARY KEY (`pkid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_key` varchar(45) DEFAULT NULL COMMENT '角色key',
  `role_name` varchar(45) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES (1, 'superAdmin', '超级管理员');
INSERT INTO `role` VALUES (2, 'areaAdmin', '区域管理员');
INSERT INTO `role` VALUES (3, 'townAdmin', '乡镇管理员');
INSERT INTO `role` VALUES (4, 'common', '普通用户');
COMMIT;

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `pkid` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pkid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `pkid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(45) DEFAULT NULL COMMENT '用户名',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `password` varchar(45) DEFAULT NULL COMMENT '密码',
  `user_status` int(11) NOT NULL DEFAULT '3' COMMENT '用户状态，0:正常，1:禁用，2:删除，3：待审核，4：拒绝',
  `role_id` int(11) NOT NULL DEFAULT '4' COMMENT '用户角色',
  `mobile` char(11) DEFAULT NULL COMMENT '手机',
  `tel` varchar(32) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `sex` int(2) DEFAULT NULL,
  `birthday_year` int(4) DEFAULT NULL,
  `birthday_month` int(2) DEFAULT NULL,
  `birthday_day` int(2) DEFAULT NULL,
  `marry_flag` int(2) DEFAULT NULL,
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `create_user` int(11) DEFAULT NULL COMMENT '创建人',
  `update_date` date DEFAULT NULL COMMENT '更新日期',
  `update_user` int(11) DEFAULT NULL COMMENT '更新人',
  `id_card_pic` varchar(32) DEFAULT NULL,
  `id_card_pic_back` varchar(32) DEFAULT NULL,
  `user_pic` varchar(32) DEFAULT NULL,
  `address` varchar(1024) DEFAULT NULL,
  `postcode` varchar(32) DEFAULT NULL,
  `company` varchar(128) DEFAULT NULL,
  `position` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`pkid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES (1, 'superadmin', 'superadmin', 'e10adc3949ba59abbe56e057f20f883e', 1, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `users` VALUES (2, 'zyz1', NULL, '111', 0, 4, NULL, NULL, NULL, 0, NULL, NULL, NULL, 0, '2018-12-31', NULL, '2018-12-31', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `users` VALUES (3, 'qwe', NULL, '111', 0, 4, NULL, NULL, NULL, 0, NULL, NULL, NULL, 0, '2018-12-31', NULL, '2018-12-31', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `users` VALUES (4, 'zyz2', NULL, 'b59c67bf196a4758191e42f76670ceba', 0, 4, NULL, NULL, NULL, 0, NULL, NULL, NULL, 0, '2018-12-31', NULL, '2018-12-31', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `users` VALUES (5, 'zyz', NULL, '698d51a19d8a121ce581499d7b701668', 0, 4, 'asd', 'asd', NULL, 1, 1918, 9, 7, 1, '2018-12-31', NULL, '2018-12-31', NULL, NULL, NULL, NULL, 'asd', 'as', 'asd', 'asd');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
