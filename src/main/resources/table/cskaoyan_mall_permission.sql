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

 Date: 05/10/2019 15:38:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cskaoyan_mall_permission
-- ----------------------------
DROP TABLE IF EXISTS `cskaoyan_mall_permission`;
CREATE TABLE `cskaoyan_mall_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色ID',
  `permission` varchar(63) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限',
  `add_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 301 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cskaoyan_mall_permission
-- ----------------------------
INSERT INTO `cskaoyan_mall_permission` VALUES (1, 1, '*', '2019-01-01 00:00:00', '2019-01-01 00:00:00', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (35, 1, 'admin:order:list', '2019-10-04 20:02:11', '2019-10-04 20:02:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (37, 1, 'admin:admin:update', '2019-10-04 20:02:36', '2019-10-04 20:02:36', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (38, 1, 'admin:topic:read', '2019-10-04 20:02:54', '2019-10-04 20:02:54', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (39, 1, 'admin:coupon:delete', '2019-10-04 20:03:24', '2019-10-04 20:03:24', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (40, 1, 'admin:admin:delete', '2019-10-04 20:03:39', '2019-10-04 20:03:39', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (41, 1, 'admin:user:list', '2019-10-04 20:03:47', '2019-10-04 20:03:47', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (42, 1, 'admin:goods:update', '2019-10-04 20:03:57', '2019-10-04 20:03:57', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (43, 1, 'admin:role:permission:get', '2019-10-04 20:04:06', '2019-10-04 20:04:06', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (44, 1, 'admin:brand:update', '2019-10-04 20:04:15', '2019-10-04 20:04:15', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (45, 1, 'admin:category:create', '2019-10-04 20:04:25', '2019-10-04 20:04:25', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (46, 1, 'admin:ad:create', '2019-10-04 20:04:34', '2019-10-04 20:04:34', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (47, 1, 'admin:stat:order', '2019-10-04 20:04:42', '2019-10-04 20:04:42', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (48, 1, 'admin:coupon:list', '2019-10-04 20:04:49', '2019-10-04 20:04:49', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (49, 1, 'admin:config:wx:updateConfigs', '2019-10-04 20:04:59', '2019-10-04 20:04:59', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (50, 1, 'admin:topic:list', '2019-10-04 20:05:08', '2019-10-04 20:05:08', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (51, 1, 'admin:order:refund', '2019-10-04 20:05:17', '2019-10-04 20:05:17', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (52, 1, 'admin:order:read', '2019-10-04 20:05:25', '2019-10-04 20:05:25', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (53, 1, 'admin:topic:delete', '2019-10-04 20:05:33', '2019-10-04 20:05:33', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (54, 1, 'admin:brand:list', '2019-10-04 20:05:39', '2019-10-04 20:05:39', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (55, 1, 'admin:brand:delete', '2019-10-04 20:05:46', '2019-10-04 20:05:46', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (56, 1, 'admin:coupon:update', '2019-10-04 20:05:54', '2019-10-04 20:05:54', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (57, 1, 'admin:brand:read', '2019-10-04 20:06:01', '2019-10-04 20:06:01', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (58, 1, 'admin:config:wx:list', '2019-10-04 20:06:10', '2019-10-04 20:06:10', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (59, 1, 'admin:collect:list', '2019-10-04 20:06:19', '2019-10-04 20:06:19', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (60, 1, 'admin:storage:list', '2019-10-04 20:06:32', '2019-10-04 20:06:32', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (61, 1, 'admin:coupon:listuser', '2019-10-04 20:06:39', '2019-10-04 20:06:39', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (62, 1, 'admin:groupon:read', '2019-10-04 20:06:47', '2019-10-04 20:06:47', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (63, 1, 'admin:admin:read', '2019-10-04 20:06:54', '2019-10-04 20:06:54', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (64, 1, 'admin:order:ship', '2019-10-04 20:07:04', '2019-10-04 20:07:04', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (65, 1, 'admin:storage:read', '2019-10-04 20:07:12', '2019-10-04 20:07:12', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (66, 1, 'admin:keyword:update', '2019-10-04 20:07:19', '2019-10-04 20:07:19', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (67, 1, 'admin:comment:delete', '2019-10-04 20:07:28', '2019-10-04 20:07:28', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (68, 1, 'admin:groupon:create', '2019-10-04 20:07:35', '2019-10-04 20:07:35', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (69, 1, 'admin:comment:list', '2019-10-04 20:07:42', '2019-10-04 20:07:42', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (70, 1, 'admin:keyword:list', '2019-10-04 20:07:51', '2019-10-04 20:07:51', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (71, 1, 'admin:keyword:create', '2019-10-04 20:08:00', '2019-10-04 20:08:00', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (72, 1, 'admin:admin:list', '2019-10-04 20:08:07', '2019-10-04 20:08:07', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (73, 1, 'admin:category:delete', '2019-10-04 20:08:14', '2019-10-04 20:08:14', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (74, 1, 'admin:history:list', '2019-10-04 20:08:21', '2019-10-04 20:08:21', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (75, 1, 'admin:role:delete', '2019-10-04 20:08:30', '2019-10-04 20:08:30', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (76, 1, 'admin:storage:delete', '2019-10-04 20:08:38', '2019-10-04 20:08:38', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (77, 1, 'admin:order:reply', '2019-10-04 20:08:45', '2019-10-04 20:08:45', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (78, 1, 'admin:keyword:read', '2019-10-04 20:08:53', '2019-10-04 20:08:53', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (79, 1, 'admin:ad:delete', '2019-10-04 20:09:00', '2019-10-04 20:09:00', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (80, 1, 'admin:goods:delete', '2019-10-04 20:09:07', '2019-10-04 20:09:07', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (81, 1, 'admin:issue:update', '2019-10-04 20:09:15', '2019-10-04 20:09:15', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (82, 1, 'admin:topic:create', '2019-10-04 20:09:23', '2019-10-04 20:09:23', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (83, 1, 'admin:address:list', '2019-10-04 20:09:32', '2019-10-04 20:09:32', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (84, 1, 'admin:category:read', '2019-10-04 20:09:38', '2019-10-04 20:09:38', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (85, 1, 'admin:category:update', '2019-10-04 20:09:45', '2019-10-04 20:09:45', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (86, 1, 'admin:config:express:updateConfigs', '2019-10-04 20:09:53', '2019-10-04 20:09:53', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (87, 1, 'admin:storage:create', '2019-10-04 20:10:00', '2019-10-04 20:10:00', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (88, 1, 'admin:brand:create', '2019-10-04 20:10:07', '2019-10-04 20:10:07', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (89, 1, 'admin:config:express:list', '2019-10-04 20:10:13', '2019-10-04 20:10:13', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (90, 1, 'admin:issue:delete', '2019-10-04 20:10:20', '2019-10-04 20:10:20', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (91, 1, 'admin:goods:create', '2019-10-04 20:10:28', '2019-10-04 20:10:28', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (92, 1, 'admin:ad:list', '2019-10-04 20:10:35', '2019-10-04 20:10:35', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (93, 1, 'admin:groupon:list', '2019-10-04 20:10:42', '2019-10-04 20:10:42', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (94, 1, 'admin:role:permission:update', '2019-10-04 20:10:50', '2019-10-04 20:10:50', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (95, 1, 'admin:admin:create', '2019-10-04 20:11:00', '2019-10-04 20:11:00', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (96, 1, 'admin:groupon:update', '2019-10-04 20:11:09', '2019-10-04 20:11:09', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (97, 1, 'index:permission:write', '2019-10-04 20:11:17', '2019-10-04 20:11:17', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (98, 1, 'admin:footprint:list', '2019-10-04 20:11:44', '2019-10-04 20:11:44', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (99, 1, 'admin:groupon:delete', '2019-10-04 20:11:51', '2019-10-04 20:11:51', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (100, 1, 'admin:ad:read', '2019-10-04 20:11:58', '2019-10-04 20:11:58', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (101, 1, 'admin:config:order:list', '2019-10-04 20:12:05', '2019-10-04 20:12:05', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (164, 3, 'admin:groupon:read', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (165, 3, 'admin:groupon:update', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (166, 3, 'admin:groupon:create', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (167, 3, 'admin:groupon:list', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (168, 3, 'admin:groupon:delete', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (169, 3, 'admin:ad:update', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (170, 3, 'admin:ad:read', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (171, 3, 'admin:ad:delete', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (172, 3, 'admin:ad:create', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (173, 3, 'admin:ad:list', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (174, 3, 'admin:topic:update', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (175, 3, 'admin:topic:read', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (176, 3, 'admin:topic:delete', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (177, 3, 'admin:topic:create', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (178, 3, 'admin:topic:list', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (179, 3, 'admin:coupon:update', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (180, 3, 'admin:coupon:read', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (181, 3, 'admin:coupon:delete', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (182, 3, 'admin:coupon:create', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (183, 3, 'admin:coupon:list', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (184, 3, 'admin:config:mall:list', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (185, 3, 'admin:config:mall:updateConfigs', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (186, 3, 'admin:config:express:updateConfigs', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (187, 3, 'admin:config:express:list', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (188, 3, 'admin:config:order:list', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (189, 3, 'admin:config:order:updateConfigs', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (190, 3, 'admin:config:wx:updateConfigs', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (191, 3, 'admin:config:wx:list', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (192, 3, 'index:permission:write', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (193, 3, 'index:permission:read', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (194, 3, 'admin:admin:update', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (195, 3, 'admin:admin:read', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (196, 3, 'admin:admin:delete', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (197, 3, 'admin:admin:create', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (198, 3, 'admin:admin:list', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (199, 3, 'admin:log:list', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (200, 3, 'admin:role:permission:update', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (201, 3, 'admin:role:update', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (202, 3, 'admin:role:read', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (203, 3, 'admin:role:delete', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (204, 3, 'admin:role:permission:get', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (205, 3, 'admin:role:create', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (206, 3, 'admin:role:list', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (207, 3, 'admin:storage:update', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (208, 3, 'admin:storage:read', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (209, 3, 'admin:storage:delete', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (210, 3, 'admin:storage:create', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (211, 3, 'admin:storage:list', '2019-10-04 22:26:11', '2019-10-04 22:26:11', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (212, 5, 'admin:stat:user', '2019-10-04 22:26:19', '2019-10-04 22:26:19', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (213, 5, 'admin:stat:order', '2019-10-04 22:26:19', '2019-10-04 22:26:19', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (214, 5, 'admin:stat:goods', '2019-10-04 22:26:19', '2019-10-04 22:26:19', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (215, 5, 'admin:admin:update', '2019-10-04 22:26:19', '2019-10-04 22:26:19', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (216, 5, 'admin:admin:read', '2019-10-04 22:26:19', '2019-10-04 22:26:19', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (217, 5, 'admin:admin:delete', '2019-10-04 22:26:19', '2019-10-04 22:26:19', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (218, 5, 'admin:admin:create', '2019-10-04 22:26:19', '2019-10-04 22:26:19', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (219, 5, 'admin:admin:list', '2019-10-04 22:26:19', '2019-10-04 22:26:19', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (220, 5, 'admin:log:list', '2019-10-04 22:26:19', '2019-10-04 22:26:19', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (221, 5, 'admin:role:permission:update', '2019-10-04 22:26:19', '2019-10-04 22:26:19', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (222, 5, 'admin:role:update', '2019-10-04 22:26:19', '2019-10-04 22:26:19', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (223, 5, 'admin:role:read', '2019-10-04 22:26:19', '2019-10-04 22:26:19', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (224, 5, 'admin:role:delete', '2019-10-04 22:26:19', '2019-10-04 22:26:19', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (225, 5, 'admin:role:permission:get', '2019-10-04 22:26:19', '2019-10-04 22:26:19', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (226, 5, 'admin:role:create', '2019-10-04 22:26:19', '2019-10-04 22:26:19', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (227, 5, 'admin:role:list', '2019-10-04 22:26:19', '2019-10-04 22:26:19', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (228, 5, 'admin:storage:update', '2019-10-04 22:26:19', '2019-10-04 22:26:19', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (229, 5, 'admin:storage:read', '2019-10-04 22:26:19', '2019-10-04 22:26:19', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (230, 5, 'admin:storage:delete', '2019-10-04 22:26:19', '2019-10-04 22:26:19', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (231, 5, 'admin:storage:create', '2019-10-04 22:26:19', '2019-10-04 22:26:19', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (232, 5, 'admin:storage:list', '2019-10-04 22:26:19', '2019-10-04 22:26:19', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (263, 2, 'admin:config:mall:list', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (264, 2, 'admin:config:mall:updateConfigs', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (265, 2, 'admin:config:express:updateConfigs', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (266, 2, 'admin:config:express:list', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (267, 2, 'admin:config:order:list', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (268, 2, 'admin:config:order:updateConfigs', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (269, 2, 'admin:config:wx:updateConfigs', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (270, 2, 'admin:config:wx:list', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (271, 2, 'admin:stat:user', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (272, 2, 'admin:stat:order', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (273, 2, 'admin:stat:goods', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (274, 2, 'admin:admin:update', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (275, 2, 'admin:admin:read', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (276, 2, 'admin:admin:delete', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (277, 2, 'admin:admin:create', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (278, 2, 'admin:admin:list', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (279, 2, 'admin:log:list', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (280, 2, 'admin:role:permission:update', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (281, 2, 'admin:role:update', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (282, 2, 'admin:role:read', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (283, 2, 'admin:role:delete', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (284, 2, 'admin:role:permission:get', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (285, 2, 'admin:role:create', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (286, 2, 'admin:role:list', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (287, 2, 'admin:storage:update', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (288, 2, 'admin:storage:read', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (289, 2, 'admin:storage:delete', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (290, 2, 'admin:storage:create', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (291, 2, 'admin:storage:list', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (292, 2, 'admin:brand:update', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (293, 2, 'admin:brand:create', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (294, 2, 'admin:brand:list', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (295, 2, 'admin:brand:delete', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (296, 2, 'admin:category:update', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (297, 2, 'admin:category:read', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (298, 2, 'admin:category:delete', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (299, 2, 'admin:category:create', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (300, 2, 'admin:category:list', '2019-10-05 09:43:41', '2019-10-05 09:43:41', 0);

SET FOREIGN_KEY_CHECKS = 1;
