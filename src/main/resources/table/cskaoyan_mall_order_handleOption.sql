/*
Navicat MySQL Data Transfer

Source Server         : wc_MySQL
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : cskaoyanmall

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-10-05 17:44:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cskaoyan_mall_order_handleoption
-- ----------------------------
DROP TABLE IF EXISTS `cskaoyan_mall_order_handleoption`;
CREATE TABLE `cskaoyan_mall_order_handleoption` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `cancel` tinyint(1) NOT NULL DEFAULT '0',
  `comment` tinyint(1) NOT NULL,
  `confirm` tinyint(1) NOT NULL,
  `delete` tinyint(1) NOT NULL,
  `pay` tinyint(1) NOT NULL,
  `rebuy` tinyint(1) NOT NULL,
  `refund` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of cskaoyan_mall_order_handleoption
-- ----------------------------
INSERT INTO `cskaoyan_mall_order_handleoption` VALUES ('1', '1', '0', '0', '1', '1', '0', '0', '0');
