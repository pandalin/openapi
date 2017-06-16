/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : jvv_openapi

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-03-13 22:44:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for merchant
-- ----------------------------
DROP TABLE IF EXISTS `merchant`;
CREATE TABLE `merchant` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `partner_id` varchar(20) DEFAULT NULL COMMENT '公共密钥KEY',
  `merchant_name` varchar(32) DEFAULT NULL COMMENT '商户名称',
  `security_code` varchar(64) DEFAULT NULL COMMENT '安全校验码',
  `status` varchar(16) DEFAULT 'NORMAL' COMMENT '商户状态',
  `active_time` datetime DEFAULT NULL COMMENT '生效时间',
  `effective_time` datetime DEFAULT '2999-12-31 23:59:59' COMMENT '过期时间',
  `prompt_type` varchar(64) DEFAULT 'ALERT' COMMENT '错误提示方式',
  `raw_add_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据新增时间',
  `raw_update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_partner_id` (`partner_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='商户信息';

-- ----------------------------
-- Records of merchant
-- ----------------------------
INSERT INTO `merchant` VALUES ('1', '20170315123001000001', '金窝窝自主平台-IOS', '51face7d5d52497016e7865c052ac051', 'NORMAL', '2017-03-13 17:15:56', '2999-12-31 23:59:59', 'ALERT', '2017-03-13 21:32:59', '2017-03-13 21:32:59');

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `gid` varchar(35) DEFAULT NULL COMMENT '全局统一的会话ID',
  `serial_no` varchar(20) DEFAULT '0' COMMENT '序列号',
  `service_name` varchar(64) DEFAULT NULL COMMENT '服务名称',
  `service_version` varchar(16) DEFAULT NULL COMMENT '服务版本',
  `partner_id` varchar(20) DEFAULT NULL COMMENT '商户ID',
  `status` varchar(32) DEFAULT NULL COMMENT '订单状态',
  `trade_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '交易时间',
  `merchant_order_no` varchar(64) DEFAULT NULL COMMENT '商户订单号',
  `request_params` varchar(4000) DEFAULT NULL COMMENT '请求参数',
  `result_code` varchar(32) DEFAULT NULL COMMENT '结果码',
  `result_message` varchar(255) DEFAULT NULL COMMENT '结果信息',
  `raw_add_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据新增时间',
  `raw_update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_serial_no` (`serial_no`),
  UNIQUE KEY `uk_merchant_order_no` (`merchant_order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_info
-- ----------------------------

-- ----------------------------
-- Table structure for sys_seq
-- ----------------------------
DROP TABLE IF EXISTS `sys_seq`;
CREATE TABLE `sys_seq` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '序列名称',
  `raw_add_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_seq
-- ----------------------------

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `age` int(3) DEFAULT '0' COMMENT '年龄',
  `rawAddTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据新增时间',
  `rawUpdateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
