/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : jingrui-manager

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2018-06-06 13:52:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for module
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `modelName` varchar(255) NOT NULL COMMENT '模块名',
  `createdBy` bigint(20) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  `updatedBy` bigint(20) DEFAULT NULL,
  `updatedTime` datetime DEFAULT NULL,
  `deletedBy` bigint(20) DEFAULT NULL,
  `deletedTime` datetime DEFAULT NULL,
  `isDeleted` tinyint(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '是否删除，默认是0表示未删除，1表示被删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of module
-- ----------------------------
INSERT INTO `module` VALUES ('1', '大事记', '1', '2018-06-01 15:19:36', null, null, null, null, '0');
INSERT INTO `module` VALUES ('2', '价目', '1', '2018-06-01 15:19:39', null, null, null, null, '0');

-- ----------------------------
-- Table structure for module_item
-- ----------------------------
DROP TABLE IF EXISTS `module_item`;
CREATE TABLE `module_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `module_id` bigint(20) NOT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `content_type` int(255) DEFAULT '2' COMMENT '详情类型，1，表示文字，2表示图片',
  `thum_url` varchar(255) DEFAULT '' COMMENT '缩略图',
  `background_url` varchar(255) DEFAULT '' COMMENT 'background',
  `detail_url` varchar(255) DEFAULT NULL COMMENT '详情图',
  `detail_desc` longtext COMMENT '详情描述',
  `status` int(11) DEFAULT '1' COMMENT '1:上线，2：下线',
  `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  `module_order` int(11) unsigned DEFAULT '0' COMMENT '排序',
  `created_by` bigint(20) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `deleted_by` bigint(20) DEFAULT NULL,
  `deleted_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `PK_moduleItemId` (`module_id`),
  CONSTRAINT `PK_moduleItemId` FOREIGN KEY (`module_id`) REFERENCES `module` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of module_item
-- ----------------------------
INSERT INTO `module_item` VALUES ('1', '2', '1', '2', 'suo.png', 'bei.png', 'xiang.png', 'jjsjsjsjsj', '1', '1', '1', '1', '2018-06-01 15:47:21', '1', '2018-06-01 16:47:47', null, null);
INSERT INTO `module_item` VALUES ('2', '2', '测试第一条修改', '2', '缩略图11.png', '背景图.png', '详情图.png', null, '1', '0', '1', '1', '2018-06-01 15:47:21', null, null, null, null);
INSERT INTO `module_item` VALUES ('3', '1', '测试111', '1', 'http://publichealth-zjx.oss-cn-shanghai.aliyuncs.com/1528187931059.V0001.png', '', null, null, '1', '0', '0', null, null, null, null, null, null);
INSERT INTO `module_item` VALUES ('4', '1', '测试111', '1', 'http://publichealth-zjx.oss-cn-shanghai.aliyuncs.com/1528188251091.V0001.png', 'http://publichealth-zjx.oss-cn-shanghai.aliyuncs.com/1528188245841.V0001.png', 'http://publichealth-zjx.oss-cn-shanghai.aliyuncs.com/1528188252159.V0001.txt', null, '1', '0', '0', null, null, null, null, null, null);
INSERT INTO `module_item` VALUES ('5', '1', '哦啦啦', '1', 'http://publichealth-zjx.oss-cn-shanghai.aliyuncs.com/1528257622515.V0001.png', 'http://publichealth-zjx.oss-cn-shanghai.aliyuncs.com/1528188248786.V0001.png', 'http://publichealth-zjx.oss-cn-shanghai.aliyuncs.com/1528188246591.V0001.txt', null, '1', '0', '1', null, null, null, null, null, null);
INSERT INTO `module_item` VALUES ('6', '1', '1测测测测', '1', 'http://publichealth-zjx.oss-cn-shanghai.aliyuncs.com/1528256834886.V0001.png', '', null, null, '1', '0', '1', null, null, null, null, null, null);
INSERT INTO `module_item` VALUES ('7', '1', '哦呵呵', '1', 'http://publichealth-zjx.oss-cn-shanghai.aliyuncs.com/1528257561732.V0001.png', '', null, null, '2', '0', '100', null, null, null, null, null, null);
