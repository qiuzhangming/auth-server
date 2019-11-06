/*
Navicat MariaDB Data Transfer

Source Server         : localhost
Source Server Version : 100309
Source Host           : localhost:3306
Source Database       : db_auth

Target Server Type    : MariaDB
Target Server Version : 100309
File Encoding         : 65001

Date: 2019-11-06 17:38:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `authority_name` varchar(255) DEFAULT '' COMMENT '资源名称',
  `authority_describe` varchar(255) DEFAULT '' COMMENT '资源描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES ('1', 'p1', 'p1权限');
INSERT INTO `authority` VALUES ('3', 'p2', 'p2权限');
INSERT INTO `authority` VALUES ('4', 'p3', 'p3权限');

-- ----------------------------
-- Table structure for relational_user_authority
-- ----------------------------
DROP TABLE IF EXISTS `relational_user_authority`;
CREATE TABLE `relational_user_authority` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `authority_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of relational_user_authority
-- ----------------------------
INSERT INTO `relational_user_authority` VALUES ('1', '12', '1');
INSERT INTO `relational_user_authority` VALUES ('2', '12', '3');
INSERT INTO `relational_user_authority` VALUES ('3', '12', '4');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `deleted` bit(1) DEFAULT b'0' COMMENT '账号是否删除',
  `enabled` bit(1) DEFAULT b'0' COMMENT '账号是否允许',
  `fullname` varchar(255) DEFAULT '' COMMENT '用户全名',
  `mobile` varchar(255) DEFAULT '' COMMENT '手机号',
  `password` varchar(255) DEFAULT '' COMMENT '密码',
  `username` varchar(255) DEFAULT '' COMMENT '用户名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('12', '\0', '', '张三12', '10086', '$2a$10$RnUNbCPLr7dEaFsa2XNeWubgSB6wp/9BBgkq6eznDi50brrKN.ime', 'zs');
INSERT INTO `user` VALUES ('15', '\0', '', '李四', '10010', '456', 'ls');
INSERT INTO `user` VALUES ('16', '\0', '', '王五', '10000', '456', 'ww');
