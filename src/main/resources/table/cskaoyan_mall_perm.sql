/*
 Navicat Premium Data Transfer

 Source Server         :  local
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : cskaoyanmall

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 05/10/2019 15:38:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cskaoyan_mall_perm
-- ----------------------------
DROP TABLE IF EXISTS `cskaoyan_mall_perm`;
CREATE TABLE `cskaoyan_mall_perm`  (
  `id` int(11) NOT NULL,
  `pid` int(11) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `label` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `api` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cskaoyan_mall_perm
-- ----------------------------
INSERT INTO `cskaoyan_mall_perm` VALUES (1, 0, '用户管理', '用户管理', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (2, 0, '推广管理', '推广管理', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (3, 0, '配置管理', '配置管理', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (4, 0, '其他', '其他', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (5, 0, '统计管理', '统计管理', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (6, 0, '系统管理', '系统管理', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (7, 0, '商场管理', '商场管理', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (8, 0, '商品管理', '商品管理', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (11, 1, '用户收藏', '用户收藏', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (12, 1, '意见反馈', '意见反馈', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (13, 1, '会员管理', '会员管理', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (14, 1, '用户足迹', '用户足迹', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (15, 1, '搜索历史', '搜索历史', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (16, 1, '收货地址', '收货地址', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (21, 2, '团购管理', '团购管理', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (22, 2, '广告管理', '广告管理', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (23, 2, '专题管理', '专题管理', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (24, 2, '优惠券管理', '优惠券管理', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (31, 3, '商场配置', '商场配置', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (32, 3, '运费管理', '运费管理', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (33, 3, '订单管理', '订单管理', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (34, 3, '小程序管理', '小程序管理', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (41, 4, '权限测试', '权限测试', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (51, 5, '用户统计', '用户统计', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (52, 5, '订单统计', '订单统计', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (53, 5, '商品统计', '商品统计', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (61, 6, '管理员管理', '管理员管理', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (62, 6, '操作日志', '操作日志', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (63, 6, '角色管理', '角色管理', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (64, 6, '对象储存', '对象储存', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (71, 7, '品牌管理', '品牌管理', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (72, 7, '订单管理', '订单管理', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (73, 7, '关键词', '关键词', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (74, 7, '类目管理', '类目管理', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (75, 7, '通用管理', '通用管理', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (81, 8, '商品管理', '商品管理', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (82, 8, '评价管理', '评价管理', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (111, 11, 'admin:collect:lis', '查询', 'GET /admin/collect/list');
INSERT INTO `cskaoyan_mall_perm` VALUES (121, 12, 'admin:feedback:list', '查询', 'GET /admin/feedback/list');
INSERT INTO `cskaoyan_mall_perm` VALUES (131, 13, 'admin:user:list', '查询', 'GET /admin/user/list');
INSERT INTO `cskaoyan_mall_perm` VALUES (141, 14, 'admin:footprint:list', '查询', 'GET /admin/footprint/list');
INSERT INTO `cskaoyan_mall_perm` VALUES (151, 15, 'admin:history:list', '查询', 'GET /admin/history/list');
INSERT INTO `cskaoyan_mall_perm` VALUES (211, 21, 'admin:groupon:read', '详情', 'GET /admin/groupon/listRecord');
INSERT INTO `cskaoyan_mall_perm` VALUES (212, 21, 'admin:groupon:update', '编辑', 'POST /admin/groupon/update');
INSERT INTO `cskaoyan_mall_perm` VALUES (213, 21, 'admin:groupon:create', '添加', 'POST /admin/groupon/create');
INSERT INTO `cskaoyan_mall_perm` VALUES (214, 21, 'admin:groupon:list', '查询', 'GET /admin/groupon/list');
INSERT INTO `cskaoyan_mall_perm` VALUES (215, 21, 'admin:groupon:delete', '删除', 'POST /admin/groupon/delete');
INSERT INTO `cskaoyan_mall_perm` VALUES (221, 22, 'admin:ad:update', '编辑', 'POST /admin/ad/update');
INSERT INTO `cskaoyan_mall_perm` VALUES (222, 22, 'admin:ad:read', '详情', 'GET /admin/ad/read');
INSERT INTO `cskaoyan_mall_perm` VALUES (223, 22, 'admin:ad:delete', '删除', 'POST /admin/ad/delete');
INSERT INTO `cskaoyan_mall_perm` VALUES (224, 22, 'admin:ad:create', '添加', 'POST /admin/ad/create');
INSERT INTO `cskaoyan_mall_perm` VALUES (225, 22, 'admin:ad:list', '查询', 'GET /admin/ad/list');
INSERT INTO `cskaoyan_mall_perm` VALUES (231, 23, 'admin:topic:update', '编辑', 'POST /admin/topic/update');
INSERT INTO `cskaoyan_mall_perm` VALUES (232, 23, 'admin:topic:read', '详情', 'GET /admin/topic/read');
INSERT INTO `cskaoyan_mall_perm` VALUES (233, 23, 'admin:topic:delete', '删除', 'POST /admin/topic/delete');
INSERT INTO `cskaoyan_mall_perm` VALUES (234, 23, 'admin:topic:create', '添加', 'POST /admin/topic/create');
INSERT INTO `cskaoyan_mall_perm` VALUES (235, 23, 'admin:topic:list', '查询', 'GET /admin/topic/list');
INSERT INTO `cskaoyan_mall_perm` VALUES (241, 24, 'admin:coupon:listuser', '查询用户', 'GET /admin/coupon/listuser');
INSERT INTO `cskaoyan_mall_perm` VALUES (242, 24, 'admin:coupon:update', '编辑', 'POST /admin/coupon/update');
INSERT INTO `cskaoyan_mall_perm` VALUES (243, 24, 'admin:coupon:read', '详情', 'GET /admin/coupon/read');
INSERT INTO `cskaoyan_mall_perm` VALUES (244, 24, 'admin:coupon:delete', '删除', 'POST /admin/coupon/delete');
INSERT INTO `cskaoyan_mall_perm` VALUES (245, 24, 'admin:coupon:create', '添加', 'POST /admin/coupon/create');
INSERT INTO `cskaoyan_mall_perm` VALUES (246, 24, 'admin:coupon:list', '查询', 'GET /admin/coupon/list');
INSERT INTO `cskaoyan_mall_perm` VALUES (311, 31, 'admin:config:mall:list', '详情', 'GET /admin/config/mall');
INSERT INTO `cskaoyan_mall_perm` VALUES (312, 31, 'admin:config:mall:updateConfigs', '编辑', 'POST /admin/config/mall');
INSERT INTO `cskaoyan_mall_perm` VALUES (321, 32, 'admin:config:express:updateConfigs', '编辑', 'POST /admin/config/express');
INSERT INTO `cskaoyan_mall_perm` VALUES (322, 32, 'admin:config:express:list', '详情', 'GET /admin/config/express');
INSERT INTO `cskaoyan_mall_perm` VALUES (331, 33, 'admin:config:order:list', '详情', 'GET /admin/config/order\"');
INSERT INTO `cskaoyan_mall_perm` VALUES (332, 33, 'admin:config:order:updateConfigs', '编辑', 'POST /admin/config/order');
INSERT INTO `cskaoyan_mall_perm` VALUES (341, 34, 'admin:config:wx:updateConfigs', '编辑', 'POST /admin/config/wx');
INSERT INTO `cskaoyan_mall_perm` VALUES (342, 34, 'admin:config:wx:list', '详情', 'GET /admin/config/wx');
INSERT INTO `cskaoyan_mall_perm` VALUES (411, 41, 'index:permission:write', '权限写', 'POST /admin/index/write');
INSERT INTO `cskaoyan_mall_perm` VALUES (412, 41, 'index:permission:read', '权限读', 'GET /admin/index/read');
INSERT INTO `cskaoyan_mall_perm` VALUES (511, 51, 'admin:stat:user', '查询', 'GET /admin/stat/user');
INSERT INTO `cskaoyan_mall_perm` VALUES (521, 52, 'admin:stat:order', '查询', 'GET /admin/stat/order');
INSERT INTO `cskaoyan_mall_perm` VALUES (531, 53, 'admin:stat:goods', '查询', 'admin:stat:goods');
INSERT INTO `cskaoyan_mall_perm` VALUES (611, 61, 'admin:admin:update', '编辑', 'POST /admin/admin/update');
INSERT INTO `cskaoyan_mall_perm` VALUES (611, NULL, NULL, '', NULL);
INSERT INTO `cskaoyan_mall_perm` VALUES (612, 61, 'admin:admin:read', '详情', 'GET /admin/admin/read');
INSERT INTO `cskaoyan_mall_perm` VALUES (613, 61, 'admin:admin:delete', '删除', 'POST /admin/admin/delete');
INSERT INTO `cskaoyan_mall_perm` VALUES (614, 61, 'admin:admin:create', '添加', 'POST /admin/admin/create');
INSERT INTO `cskaoyan_mall_perm` VALUES (615, 61, 'admin:admin:list', '查询', 'GET /admin/admin/list');
INSERT INTO `cskaoyan_mall_perm` VALUES (621, 62, 'admin:log:list', '查询', 'GET /admin/log/list');
INSERT INTO `cskaoyan_mall_perm` VALUES (631, 63, 'admin:role:permission:update', '权限变更', 'POST /admin/role/permissions');
INSERT INTO `cskaoyan_mall_perm` VALUES (632, 63, 'admin:role:update', '角色编辑', 'POST /admin/role/update');
INSERT INTO `cskaoyan_mall_perm` VALUES (633, 63, 'admin:role:read', '角色详情', 'GET /admin/role/read');
INSERT INTO `cskaoyan_mall_perm` VALUES (634, 63, 'admin:role:delete', '角色删除', 'POST /admin/role/delete');
INSERT INTO `cskaoyan_mall_perm` VALUES (635, 63, 'admin:role:permission:get', '权限详情', 'GET /admin/role/permissions');
INSERT INTO `cskaoyan_mall_perm` VALUES (636, 63, 'admin:role:create', '角色添加', 'POST /admin/role/create');
INSERT INTO `cskaoyan_mall_perm` VALUES (637, 63, 'admin:role:list', '角色查询', 'GET /admin/role/list');
INSERT INTO `cskaoyan_mall_perm` VALUES (641, 64, 'admin:storage:update', '编辑', 'POST /admin/storage/update');
INSERT INTO `cskaoyan_mall_perm` VALUES (642, 64, 'admin:storage:read', '详情', 'POST /admin/storage/read');
INSERT INTO `cskaoyan_mall_perm` VALUES (643, 64, 'admin:storage:delete', '删除', 'POST /admin/storage/delete');
INSERT INTO `cskaoyan_mall_perm` VALUES (644, 64, 'admin:storage:create', '上传', 'POST /admin/storage/create');
INSERT INTO `cskaoyan_mall_perm` VALUES (645, 64, 'admin:storage:list', '查询', 'GET /admin/storage/list');
INSERT INTO `cskaoyan_mall_perm` VALUES (711, 71, 'admin:brand:update', '编辑', 'POST /admin/brand/update');
INSERT INTO `cskaoyan_mall_perm` VALUES (712, 71, 'admin:brand:read', '详情', 'GET /admin/brand/read');
INSERT INTO `cskaoyan_mall_perm` VALUES (713, 71, 'admin:brand:create', '添加', 'POST /admin/brand/create');
INSERT INTO `cskaoyan_mall_perm` VALUES (714, 71, 'admin:brand:list', '查询', 'GET /admin/brand/list');
INSERT INTO `cskaoyan_mall_perm` VALUES (715, 71, 'admin:brand:delete', '删除', 'POST /admin/brand/delete');
INSERT INTO `cskaoyan_mall_perm` VALUES (721, 72, 'admin:order:refund', '订单退货', 'POST /admin/order/refund');
INSERT INTO `cskaoyan_mall_perm` VALUES (722, 72, 'admin:order:read', '详情', 'GET /admin/order/detail');
INSERT INTO `cskaoyan_mall_perm` VALUES (723, 72, 'admin:order:ship', '订单发货', 'POST /admin/order/ship');
INSERT INTO `cskaoyan_mall_perm` VALUES (724, 72, 'admin:order:reply', '订单商品回复', 'POST /admin/order/reply');
INSERT INTO `cskaoyan_mall_perm` VALUES (725, 72, 'admin:order:list', '查询', 'GET /admin/order/list');
INSERT INTO `cskaoyan_mall_perm` VALUES (731, 73, 'admin:keyword:update', '编辑', 'POST /admin/keyword/update');
INSERT INTO `cskaoyan_mall_perm` VALUES (732, 73, 'admin:keyword:read', '详情', 'GET /admin/keyword/read');
INSERT INTO `cskaoyan_mall_perm` VALUES (733, 73, 'admin:keyword:delete', '删除', 'POST /admin/keyword/delete');
INSERT INTO `cskaoyan_mall_perm` VALUES (734, 73, '\"admin:keyword:create', '添加', 'POST /admin/keyword/create');
INSERT INTO `cskaoyan_mall_perm` VALUES (735, 73, 'admin:keyword:list', '查询', 'GET /admin/keyword/list');
INSERT INTO `cskaoyan_mall_perm` VALUES (741, 74, 'admin:category:update', '编辑', 'POST /admin/category/update');
INSERT INTO `cskaoyan_mall_perm` VALUES (742, 74, 'admin:category:read', '详情', 'GET /admin/category/read');
INSERT INTO `cskaoyan_mall_perm` VALUES (743, 74, 'admin:category:delete', '删除', 'POST /admin/category/delete');
INSERT INTO `cskaoyan_mall_perm` VALUES (744, 74, 'admin:category:create', '添加', 'POST /admin/category/create');
INSERT INTO `cskaoyan_mall_perm` VALUES (745, 74, 'admin:category:list', '查询', 'GET /admin/category/list');
INSERT INTO `cskaoyan_mall_perm` VALUES (751, 75, 'admin:issue:update', '编辑', 'POST /admin/issue/update');
INSERT INTO `cskaoyan_mall_perm` VALUES (752, 75, 'admin:issue:delete', '删除', 'POST /admin/issue/delete');
INSERT INTO `cskaoyan_mall_perm` VALUES (753, 75, 'admin:issue:create', '添加', 'POST /admin/issue/create');
INSERT INTO `cskaoyan_mall_perm` VALUES (754, 75, 'admin:issue:list', '查询', 'GET /admin/issue/list');
INSERT INTO `cskaoyan_mall_perm` VALUES (811, 81, 'admin:goods:read', '详情', 'GET /admin/goods/detail');
INSERT INTO `cskaoyan_mall_perm` VALUES (812, 81, 'admin:goods:update', '编辑', 'POST /admin/goods/update');
INSERT INTO `cskaoyan_mall_perm` VALUES (813, 81, 'admin:goods:delete', '删除', 'POST /admin/goods/delete');
INSERT INTO `cskaoyan_mall_perm` VALUES (814, 81, 'admin:goods:create', '添加', 'POST /admin/goods/create');
INSERT INTO `cskaoyan_mall_perm` VALUES (815, 81, 'admin:goods:list', '详情', 'GET /admin/goods/list');
INSERT INTO `cskaoyan_mall_perm` VALUES (821, 82, 'admin:comment:delete', '删除', 'POST /admin/comment/delete');
INSERT INTO `cskaoyan_mall_perm` VALUES (822, 82, 'admin:comment:list', '详情', 'GET /admin/comment/list');

SET FOREIGN_KEY_CHECKS = 1;
