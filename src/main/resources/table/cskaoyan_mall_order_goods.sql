/*
Navicat MySQL Data Transfer

Source Server         : wc_MySQL
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : cskaoyanmall

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-10-08 20:02:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cskaoyan_mall_order_goods
-- ----------------------------
DROP TABLE IF EXISTS `cskaoyan_mall_order_goods`;
CREATE TABLE `cskaoyan_mall_order_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL DEFAULT '0' COMMENT '订单表的订单ID',
  `goods_id` int(11) NOT NULL DEFAULT '0' COMMENT '商品表的商品ID',
  `goods_name` varchar(127) NOT NULL DEFAULT '' COMMENT '商品名称',
  `goods_sn` varchar(63) NOT NULL DEFAULT '' COMMENT '商品编号',
  `product_id` int(11) NOT NULL DEFAULT '0' COMMENT '商品货品表的货品ID',
  `number` smallint(5) NOT NULL DEFAULT '0' COMMENT '商品货品的购买数量',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '商品货品的售价',
  `specifications` varchar(1023) NOT NULL COMMENT '商品货品的规格列表',
  `pic_url` varchar(255) NOT NULL DEFAULT '' COMMENT '商品货品图片或者商品图片',
  `comment` int(11) DEFAULT '0' COMMENT '订单商品评论，如果是-1，则超期不能评价；如果是0，则可以评价；如果其他值，则是comment表里面的评论ID。',
  `add_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `order_id` (`order_id`) USING BTREE,
  KEY `goods_id` (`goods_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='订单商品表';

-- ----------------------------
-- Records of cskaoyan_mall_order_goods
-- ----------------------------
INSERT INTO `cskaoyan_mall_order_goods` VALUES ('45', '1', '1127024', '女式无痕真丝内裤', '1127024', '178', '2', '39.00', '[\"标准\"]', '[\"http://yanxuan.nosdn.127.net/0a70f12a712e90d7d93beec4f686fe8e.png\"]', '0', '2019-10-08 15:28:38', '2019-10-08 15:28:38', '0');
INSERT INTO `cskaoyan_mall_order_goods` VALUES ('46', '1', '1127025', '女式蝶边真丝内裤', '1127025', '179', '3', '39.00', '[\"标准\"]', '[\"http://yanxuan.nosdn.127.net/b2fe79c872a8a7f647264b5e51bcc802.png\"]', '0', '2019-10-08 15:28:38', '2019-10-08 15:28:38', '0');
INSERT INTO `cskaoyan_mall_order_goods` VALUES ('47', '1', '1155015', '绿豆糕 80克（4枚入）', '1155015', '242', '1', '12.90', '[\"标准\"]', '[\"http://yanxuan.nosdn.127.net/66b9f1638c0517d179262f14ed1345f9.png\"]', '0', '2019-10-08 15:28:38', '2019-10-08 15:28:38', '0');
INSERT INTO `cskaoyan_mall_order_goods` VALUES ('48', '2', '1155015', '绿豆糕 80克（4枚入）', '1155015', '242', '3', '12.90', '[\"标准\"]', '[\"http://yanxuan.nosdn.127.net/66b9f1638c0517d179262f14ed1345f9.png\"]', '0', '2019-10-08 15:40:15', '2019-10-08 15:40:15', '0');
INSERT INTO `cskaoyan_mall_order_goods` VALUES ('49', '3', '1155015', '绿豆糕 80克（4枚入）', '1155015', '242', '3', '12.90', '[\"标准\"]', '[\"http://yanxuan.nosdn.127.net/66b9f1638c0517d179262f14ed1345f9.png\"]', '0', '2019-10-08 15:49:07', '2019-10-08 15:49:07', '0');
INSERT INTO `cskaoyan_mall_order_goods` VALUES ('50', '4', '1155015', '绿豆糕 80克（4枚入）', '1155015', '242', '3', '12.90', '[\"标准\"]', '[\"http://yanxuan.nosdn.127.net/66b9f1638c0517d179262f14ed1345f9.png\"]', '0', '2019-10-08 15:50:11', '2019-10-08 15:50:11', '0');
INSERT INTO `cskaoyan_mall_order_goods` VALUES ('51', '5', '1155015', '绿豆糕 80克（4枚入）', '1155015', '242', '3', '12.90', '[\"标准\"]', '[\"http://yanxuan.nosdn.127.net/66b9f1638c0517d179262f14ed1345f9.png\"]', '0', '2019-10-08 16:01:32', '2019-10-08 16:01:32', '0');
INSERT INTO `cskaoyan_mall_order_goods` VALUES ('52', '6', '1155015', '绿豆糕 80克（4枚入）', '1155015', '242', '2', '12.90', '[\"标准\"]', '[\"http://yanxuan.nosdn.127.net/66b9f1638c0517d179262f14ed1345f9.png\"]', '0', '2019-10-08 16:06:06', '2019-10-08 16:06:06', '0');
INSERT INTO `cskaoyan_mall_order_goods` VALUES ('53', '7', '1155015', '绿豆糕 80克（4枚入）', '1155015', '242', '2', '12.90', '[\"标准\"]', '[\"http://yanxuan.nosdn.127.net/66b9f1638c0517d179262f14ed1345f9.png\"]', '0', '2019-10-08 16:09:00', '2019-10-08 16:09:00', '0');
INSERT INTO `cskaoyan_mall_order_goods` VALUES ('54', '8', '1155015', '绿豆糕 80克（4枚入）', '1155015', '242', '2', '12.90', '[\"标准\"]', '[\"http://yanxuan.nosdn.127.net/66b9f1638c0517d179262f14ed1345f9.png\"]', '0', '2019-10-08 16:09:27', '2019-10-08 16:09:27', '0');
INSERT INTO `cskaoyan_mall_order_goods` VALUES ('55', '9', '1155015', '绿豆糕 80克（4枚入）', '1155015', '242', '8', '12.90', '[\"标准\"]', '[\"http://yanxuan.nosdn.127.net/66b9f1638c0517d179262f14ed1345f9.png\"]', '0', '2019-10-08 16:09:58', '2019-10-08 16:09:58', '0');
INSERT INTO `cskaoyan_mall_order_goods` VALUES ('56', '10', '1155015', '绿豆糕 80克（4枚入）', '1155015', '242', '8', '12.90', '[\"标准\"]', '[\"http://yanxuan.nosdn.127.net/66b9f1638c0517d179262f14ed1345f9.png\"]', '0', '2019-10-08 16:09:58', '2019-10-08 16:09:58', '0');
INSERT INTO `cskaoyan_mall_order_goods` VALUES ('57', '11', '1155015', '绿豆糕 80克（4枚入）', '1155015', '242', '8', '12.90', '[\"标准\"]', '[\"http://yanxuan.nosdn.127.net/66b9f1638c0517d179262f14ed1345f9.png\"]', '0', '2019-10-08 16:12:03', '2019-10-08 16:12:03', '0');
INSERT INTO `cskaoyan_mall_order_goods` VALUES ('58', '12', '1155015', '绿豆糕 80克（4枚入）', '1155015', '242', '12', '12.90', '[\"标准\"]', '[\"http://yanxuan.nosdn.127.net/66b9f1638c0517d179262f14ed1345f9.png\"]', '0', '2019-10-08 16:43:41', '2019-10-08 16:43:41', '0');
