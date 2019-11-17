/*
 Navicat Premium Data Transfer

 Source Server         : mysql8.0
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : foodie

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 17/11/2019 22:59:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address_city
-- ----------------------------
DROP TABLE IF EXISTS `address_city`;
CREATE TABLE `address_city`  (
  `city_id` int(12) NOT NULL COMMENT '城市id',
  `province` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '省份',
  `city` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '城市',
  PRIMARY KEY (`city_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for address_street
-- ----------------------------
DROP TABLE IF EXISTS `address_street`;
CREATE TABLE `address_street`  (
  `street_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '街道id',
  PRIMARY KEY (`street_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `article_id` int(12) NOT NULL COMMENT '文章的状态',
  `article_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章标题',
  ` article_text` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章正文',
  `author` int(12) NOT NULL COMMENT '作者（外键）',
  `create_time` datetime(0) NOT NULL COMMENT '创作时间',
  `tagging` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标注',
  `article_place` int(12) NULL DEFAULT NULL COMMENT '地点（外键）',
  `state` int(1) NULL DEFAULT NULL COMMENT '文章的状态（0，未审核；1，审核通过；2，审核未通过）',
  PRIMARY KEY (`article_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article_picture
-- ----------------------------
DROP TABLE IF EXISTS `article_picture`;
CREATE TABLE `article_picture`  (
  `article_picture_id` int(12) NOT NULL COMMENT '文章图片联合表id',
  `article_id` int(12) NOT NULL COMMENT '文章id',
  `picture_id` int(12) NOT NULL COMMENT '图片id',
  PRIMARY KEY (`article_picture_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article_type
-- ----------------------------
DROP TABLE IF EXISTS `article_type`;
CREATE TABLE `article_type`  (
  `type_id` int(12) NOT NULL COMMENT '文章类型id',
  `type1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '大类',
  `type2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '小类',
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for audit_article
-- ----------------------------
DROP TABLE IF EXISTS `audit_article`;
CREATE TABLE `audit_article`  (
  `audit_article_id` int(12) NOT NULL COMMENT '审核id',
  `article_id` int(12) NOT NULL COMMENT '文章id（外键）',
  `audit_text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '审核内容',
  `user_id` int(12) NOT NULL COMMENT '审核人（外键）',
  `audit_time` datetime(0) NOT NULL COMMENT '审核时间',
  PRIMARY KEY (`audit_article_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for audit_user
-- ----------------------------
DROP TABLE IF EXISTS `audit_user`;
CREATE TABLE `audit_user`  (
  `audit_user_id` int(12) NOT NULL COMMENT '审核id',
  `audited_user_id` int(12) NOT NULL COMMENT '被审核人id（外键）',
  `audit_text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '审核内容',
  `user_id` int(12) NOT NULL COMMENT '审核人（外键）',
  `audit_time` datetime(0) NOT NULL COMMENT '审核时间',
  PRIMARY KEY (`audit_user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(12) NOT NULL COMMENT '评论id',
  `article_id` int(12) NOT NULL COMMENT '文章id（外键）',
  `user_id` int(12) NOT NULL COMMENT '评论者（外键）',
  `comment_text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论内容',
  `comment_time` datetime(0) NOT NULL COMMENT '评论时间',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow`  (
  `follow_id` int(12) NOT NULL COMMENT '关注id',
  `article_id` int(12) NOT NULL COMMENT '关注文章id（外键）',
  `user_id` int(12) NOT NULL COMMENT '关注用户id（外键）',
  `follow_time` datetime(0) NOT NULL COMMENT '关注时间',
  PRIMARY KEY (`follow_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for like
-- ----------------------------
DROP TABLE IF EXISTS `like`;
CREATE TABLE `like`  (
  `like_id` int(12) NOT NULL COMMENT '点赞id',
  `article_id` int(12) NOT NULL COMMENT '点赞文章id（外键）',
  `user_id` int(12) NOT NULL COMMENT '点赞用户id（外键）',
  `like_time` datetime(0) NOT NULL COMMENT '点赞时间',
  PRIMARY KEY (`like_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture`  (
  `img_id` int(12) NOT NULL COMMENT '图片id',
  `img_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片路径',
  `img_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片名',
  `img_user` int(12) NULL DEFAULT NULL COMMENT '上传者',
  PRIMARY KEY (`img_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(12) NOT NULL COMMENT '用户id',
  `user_name` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `sex` int(1) NOT NULL COMMENT '性别（0，女；1，男；2，保密）',
  `user_city` int(12) NULL DEFAULT NULL COMMENT '城市（外键）',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `profile_picture` int(12) NULL DEFAULT NULL COMMENT '头像（图像，连接的是图片地址）',
  `user_power` int(2) NOT NULL COMMENT '用户类别（0，管理员；1，用户）',
  `user_profile` varchar(900) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户个人简介',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
