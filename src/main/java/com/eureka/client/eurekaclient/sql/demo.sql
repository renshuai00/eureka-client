/*
Navicat MySQL Data Transfer

Source Server         : 59.208.245.176
Source Server Version : 100121
Source Host           : 59.208.245.176:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 100121
File Encoding         : 65001

Date: 2019-07-09 23:21:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_users
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `state` char(1) DEFAULT '1' COMMENT '数据状态。state=1 有效；state=0 无效。',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_users
-- ----------------------------
INSERT INTO `t_users` VALUES ('1', 'renshuai', '11', '0');
INSERT INTO `t_users` VALUES ('2', 'renshuai1', '10', '0');
INSERT INTO `t_users` VALUES ('3', 'renshuai2', '10', '0');
INSERT INTO `t_users` VALUES ('4', 'renshuai3', '22', '0');
INSERT INTO `t_users` VALUES ('28', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('29', '12', '21', '0');
INSERT INTO `t_users` VALUES ('30', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('31', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('32', '1', '2', '0');
INSERT INTO `t_users` VALUES ('33', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('34', '1', '2', '0');
INSERT INTO `t_users` VALUES ('35', '2', '2', '0');
INSERT INTO `t_users` VALUES ('36', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('37', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('38', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('39', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('40', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('41', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('42', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('43', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('44', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('45', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('46', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('47', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('48', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('49', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('50', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('51', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('52', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('53', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('54', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('55', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('56', '1', '1', '0');
INSERT INTO `t_users` VALUES ('57', '2sss', '1', '1');
INSERT INTO `t_users` VALUES ('58', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('59', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('60', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('61', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('62', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('63', 'name', '12', '1');
INSERT INTO `t_users` VALUES ('64', 'nameqq', '12', '0');
INSERT INTO `t_users` VALUES ('65', 'name1sdds', '122', '1');
INSERT INTO `t_users` VALUES ('66', 'name', '12', '0');
INSERT INTO `t_users` VALUES ('67', '11ss', '22', '1');
INSERT INTO `t_users` VALUES ('68', 'name', '12', '1');
INSERT INTO `t_users` VALUES ('69', 'name2', '12', '1');
