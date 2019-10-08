/*
Navicat MySQL Data Transfer

Source Server         : wc_MySQL
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : cskaoyanmall

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-10-08 20:02:27
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
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of cskaoyan_mall_order_handleoption
-- ----------------------------
INSERT INTO `cskaoyan_mall_order_handleoption` VALUES ('18', '1', '1', '0', '0', '0', '0', '0', '0');
INSERT INTO `cskaoyan_mall_order_handleoption` VALUES ('19', '2', '1', '0', '0', '0', '0', '0', '0');
INSERT INTO `cskaoyan_mall_order_handleoption` VALUES ('20', '3', '1', '0', '0', '0', '0', '0', '0');
INSERT INTO `cskaoyan_mall_order_handleoption` VALUES ('21', '4', '0', '0', '0', '1', '0', '0', '0');
INSERT INTO `cskaoyan_mall_order_handleoption` VALUES ('22', '5', '1', '0', '0', '0', '0', '0', '0');
INSERT INTO `cskaoyan_mall_order_handleoption` VALUES ('23', '6', '1', '0', '0', '0', '1', '0', '0');
INSERT INTO `cskaoyan_mall_order_handleoption` VALUES ('24', '7', '1', '0', '0', '0', '1', '0', '0');
INSERT INTO `cskaoyan_mall_order_handleoption` VALUES ('25', '8', '1', '0', '0', '0', '0', '0', '0');
INSERT INTO `cskaoyan_mall_order_handleoption` VALUES ('26', '9', '0', '0', '1', '0', '0', '0', '1');
INSERT INTO `cskaoyan_mall_order_handleoption` VALUES ('27', '10', '0', '0', '1', '0', '0', '0', '1');
INSERT INTO `cskaoyan_mall_order_handleoption` VALUES ('28', '11', '0', '1', '0', '1', '0', '1', '0');
INSERT INTO `cskaoyan_mall_order_handleoption` VALUES ('29', '12', '0', '1', '0', '1', '0', '1', '0');
