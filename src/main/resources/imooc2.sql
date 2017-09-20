/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50716
Source Host           : 127.0.0.1:3306
Source Database       : imooc2

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-09-20 16:38:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `depa_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '部门ID 主键',
  `depa_name` varchar(50) NOT NULL COMMENT '部门名称',
  `depa_no` int(8) NOT NULL COMMENT '部门编号',
  `is_del` int(8) DEFAULT '0' COMMENT '是否删除',
  `depa_status` int(8) NOT NULL COMMENT '状态 0生效 1禁用',
  PRIMARY KEY (`depa_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('1', '测试部门', '10009', '0', '0');

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(100) NOT NULL,
  `title` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_message
-- ----------------------------
INSERT INTO `t_message` VALUES ('1', '中国新闻1', '新闻1');
INSERT INTO `t_message` VALUES ('2', '中国新闻2', '新闻2');
INSERT INTO `t_message` VALUES ('3', '中国新闻3', '新闻3');
