/*
Navicat MySQL Data Transfer

Source Server         : wc_MySQL
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : cskaoyanmall

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-10-08 20:02:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cskaoyan_mall_order
-- ----------------------------
DROP TABLE IF EXISTS `cskaoyan_mall_order`;
CREATE TABLE `cskaoyan_mall_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户表的用户ID',
  `order_sn` varchar(63) NOT NULL COMMENT '订单编号',
  `order_status` smallint(6) NOT NULL COMMENT '订单状态',
  `consignee` varchar(63) NOT NULL COMMENT '收货人名称',
  `mobile` varchar(63) NOT NULL COMMENT '收货人手机号',
  `address` varchar(127) NOT NULL COMMENT '收货具体地址',
  `message` varchar(512) NOT NULL DEFAULT '' COMMENT '用户订单留言',
  `goods_price` decimal(10,2) NOT NULL COMMENT '商品总费用',
  `freight_price` decimal(10,2) NOT NULL COMMENT '配送费用',
  `coupon_price` decimal(10,2) NOT NULL COMMENT '优惠券减免',
  `integral_price` decimal(10,2) NOT NULL COMMENT '用户积分减免',
  `groupon_price` decimal(10,2) NOT NULL COMMENT '团购优惠价减免',
  `order_price` decimal(10,2) NOT NULL COMMENT '订单费用， = goods_price + freight_price - coupon_price',
  `actual_price` decimal(10,2) NOT NULL COMMENT '实付费用， = order_price - integral_price',
  `pay_id` varchar(63) DEFAULT NULL COMMENT '微信付款编号',
  `pay_time` datetime DEFAULT NULL COMMENT '微信付款时间',
  `ship_sn` varchar(63) DEFAULT NULL COMMENT '发货编号',
  `ship_channel` varchar(63) DEFAULT NULL COMMENT '发货快递公司',
  `ship_time` datetime DEFAULT NULL COMMENT '发货开始时间',
  `confirm_time` datetime DEFAULT NULL COMMENT '用户确认收货时间',
  `comments` smallint(6) DEFAULT '0' COMMENT '待评价订单商品数量',
  `end_time` datetime DEFAULT NULL COMMENT '订单关闭时间',
  `add_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='订单表';

-- ----------------------------
-- Records of cskaoyan_mall_order
-- ----------------------------
INSERT INTO `cskaoyan_mall_order` VALUES ('1', '1', '201910082', '2', 'user', '188888888', '湖北省武汉市洪山区花山镇花山大道软件新城2期C13', '', '234.00', '10.00', '234.00', '0.00', '0.00', '224.00', '224.50', '2', '2019-10-08 15:48:17', '快递备注', null, null, null, '0', null, '2019-10-08 15:48:17', '2019-10-08 15:48:17', '0');
INSERT INTO `cskaoyan_mall_order` VALUES ('2', '1', '201910083', '2', 'user', '188888888', '湖北省武汉市洪山区花山镇花山大道软件新城2期C13', '', '36.00', '10.00', '36.00', '0.00', '0.00', '26.00', '26.50', '3', '2019-10-08 15:40:15', '快递备注', null, null, null, '0', null, '2019-10-08 15:40:15', '2019-10-08 15:40:15', '0');
INSERT INTO `cskaoyan_mall_order` VALUES ('3', '1', '201910084', '2', 'user', '188888888', '湖北省武汉市洪山区花山镇花山大道软件新城2期C13', '', '36.00', '10.00', '36.00', '0.00', '0.00', '26.00', '26.50', '4', '2019-10-08 15:49:07', '快递备注', null, null, null, '0', null, '2019-10-08 15:49:07', '2019-10-08 15:49:07', '0');
INSERT INTO `cskaoyan_mall_order` VALUES ('4', '1', '201910085', '0', 'user', '188888888', '湖北省武汉市洪山区花山镇花山大道软件新城2期C13', '', '36.00', '10.00', '36.00', '0.00', '0.00', '26.00', '26.80', '5', '2019-10-08 15:50:11', '快递备注', null, null, null, '0', null, '2019-10-08 15:50:11', '2019-10-08 15:52:07', '0');
INSERT INTO `cskaoyan_mall_order` VALUES ('5', '1', '201910086', '2', 'user', '188888888', '湖北省武汉市洪山区花山镇花山大道软件新城2期C13', '', '36.00', '10.00', '36.00', '0.00', '0.00', '46.00', '46.00', '6', '2019-10-08 16:01:32', '快递备注', null, null, null, '0', null, '2019-10-08 16:01:32', '2019-10-08 16:01:32', '0');
INSERT INTO `cskaoyan_mall_order` VALUES ('6', '1', '201910087', '1', 'user', '188888888', '湖北省武汉市洪山区花山镇花山大道软件新城2期C13', '', '24.00', '10.00', '24.00', '0.00', '0.00', '34.00', '34.00', '7', null, '快递备注', null, null, null, '0', null, '2019-10-08 16:06:06', '2019-10-08 16:06:06', '0');
INSERT INTO `cskaoyan_mall_order` VALUES ('7', '1', '201910088', '1', 'user', '188888888', '湖北省武汉市洪山区花山镇花山大道软件新城2期C13', '', '24.00', '10.00', '24.00', '0.00', '0.00', '34.00', '34.00', '8', null, '快递备注', null, null, null, '0', null, '2019-10-08 16:09:00', '2019-10-08 16:09:00', '0');
INSERT INTO `cskaoyan_mall_order` VALUES ('8', '1', '201910089', '2', 'user', '188888888', '湖北省武汉市洪山区花山镇花山大道软件新城2期C13', '', '25.80', '10.00', '25.00', '0.00', '0.00', '35.00', '35.00', '9', '2019-10-08 16:09:28', '快递备注', null, null, null, '0', null, '2019-10-08 16:09:28', '2019-10-08 16:09:28', '0');
INSERT INTO `cskaoyan_mall_order` VALUES ('9', '1', '2019100810', '3', 'user', '188888888', '湖北省武汉市洪山区花山镇花山大道软件新城2期C13', '', '103.20', '10.00', '103.00', '0.00', '0.00', '113.00', '113.00', '10', '2019-10-08 16:09:58', '快递备注', null, null, null, '0', null, '2019-10-08 16:09:58', '2019-10-08 16:09:58', '0');
INSERT INTO `cskaoyan_mall_order` VALUES ('10', '1', '2019100811', '3', 'user', '188888888', '湖北省武汉市洪山区花山镇花山大道软件新城2期C13', '', '103.20', '10.00', '103.00', '0.00', '0.00', '113.00', '113.00', '11', '2019-10-08 16:09:58', '快递备注', null, null, null, '0', null, '2019-10-08 16:09:58', '2019-10-08 16:09:58', '0');
INSERT INTO `cskaoyan_mall_order` VALUES ('11', '1', '2019100812', '4', 'user', '188888888', '湖北省武汉市洪山区花山镇花山大道软件新城2期C13', '', '103.20', '10.00', '87.72', '1.00', '2.00', '97.72', '97.72', '12', '2019-10-08 16:12:03', '快递备注', null, null, null, '0', null, '2019-10-08 16:12:03', '2019-10-08 16:12:03', '0');
INSERT INTO `cskaoyan_mall_order` VALUES ('12', '1', '2019100813', '4', 'user', '188888888', '湖北省武汉市洪山区花山镇花山大道软件新城2期C13', '', '154.80', '10.00', '154.80', '0.00', '0.00', '164.80', '164.80', '13', '2019-10-08 16:43:41', '快递备注', null, null, null, '0', null, '2019-10-08 16:43:41', '2019-10-08 16:43:41', '0');
