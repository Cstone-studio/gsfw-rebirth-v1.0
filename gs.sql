/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80034 (8.0.34)
 Source Host           : localhost:3306
 Source Schema         : gs

 Target Server Type    : MySQL
 Target Server Version : 80034 (8.0.34)
 File Encoding         : 65001

 Date: 24/03/2024 19:09:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hospital
-- ----------------------------
DROP TABLE IF EXISTS `hospital`;
CREATE TABLE `hospital`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `create_user` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `deleted` bit(1) NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  `update_user` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK6t8w2b6ev7lgub3tygdgshv3j`(`user_id` ASC) USING BTREE,
  CONSTRAINT `FK6t8w2b6ev7lgub3tygdgshv3j` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hospital
-- ----------------------------
INSERT INTO `hospital` VALUES (1, 20, '上海某医院', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `email` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '账号',
  `password` varchar(60) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `user_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '昵称',
  `mobile` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '电话号',
  `role` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `token` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '登录token',
  `deleted` bit(1) NULL DEFAULT NULL COMMENT '删除标记：0-未删除，1-已删除',
  `create_time` datetime NULL DEFAULT NULL,
  `create_user` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `update_user` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'xiaoming669@qq.com', 'e10adc3949ba59abbe56e057f20f883e', 'admin', '15909812111', NULL, 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTcxMTIwNDc2MiwiaWF0IjoxNzExMTg2NzYyfQ.PQm9qBR0gO0quAdPuAcwlQ9juuhG_WmO74YSxfHlo4h-M4G0LVoCRFtgcL6-gSze_3eFYVTrp_RIVCQldbArmA', b'0', '2024-03-13 22:46:33', 'admin', '2024-03-23 17:39:23', 'admin');
INSERT INTO `user` VALUES (3, 'liumei456@qq.com', 'e10adc3949ba59abbe56e057f20f883e', 'William Davis', '13456902367', NULL, NULL, b'1', '2024-03-13 22:46:33', 'admin', '2024-03-17 11:50:38', 'admin');
INSERT INTO `user` VALUES (4, 'sample7788@163.com', 'e10adc3949ba59abbe56e057f20f883e', 'Sophia Martinez', '15980723472', NULL, NULL, b'0', '2024-03-13 22:46:33', 'admin', '2024-03-13 22:46:33', 'admin');
INSERT INTO `user` VALUES (5, 'WSX9966@163.com', 'e10adc3949ba59abbe56e057f20f883e', 'James Anderson', '13678234125', NULL, NULL, b'1', '2024-03-13 22:46:33', 'admin', '2024-03-17 11:52:18', 'admin');
INSERT INTO `user` VALUES (6, 'demo1234@163.com', 'e10adc3949ba59abbe56e057f20f883e', 'Isabella Thompson', '13842156432', NULL, NULL, b'1', '2024-03-13 22:46:33', 'admin', '2024-03-17 11:58:40', 'admin');
INSERT INTO `user` VALUES (7, 'hello_world@yahoo.com', 'e10adc3949ba59abbe56e057f20f883e', 'Benjamin Wilson', '13890756432', NULL, NULL, b'0', '2024-03-13 22:46:33', 'admin', '2024-03-13 22:46:33', 'admin');
INSERT INTO `user` VALUES (8, 'testemail123@yahoo.com', 'e10adc3949ba59abbe56e057f20f883e', 'Ava Garcia', '13456345609', NULL, NULL, b'0', '2024-03-13 22:46:33', 'admin', '2024-03-13 22:46:33', 'admin');
INSERT INTO `user` VALUES (9, 'example4567@yahoo.com', 'e10adc3949ba59abbe56e057f20f883e', 'Daniel Brown', '13800993214', NULL, NULL, b'0', '2024-03-13 22:46:33', 'admin', '2024-03-13 22:46:33', 'admin');
INSERT INTO `user` VALUES (10, 'myemail@yahoo.com', 'e10adc3949ba59abbe56e057f20f883e', 'Mia Taylor', '13422113654', NULL, NULL, b'0', '2024-03-13 22:46:33', 'admin', '2024-03-13 22:46:33', 'admin');
INSERT INTO `user` VALUES (11, 'user12@yahoo.com', 'e10adc3949ba59abbe56e057f20f883e', 'John Smith', '13890321166', NULL, NULL, b'0', '2024-03-13 22:46:33', 'admin', '2024-03-13 22:46:33', 'admin');
INSERT INTO `user` VALUES (12, 'sampleemail@126.com', 'e10adc3949ba59abbe56e057f20f883e', 'Emily Johnson', '15900887623', NULL, NULL, b'0', '2024-03-13 22:46:33', 'admin', '2024-03-13 22:46:33', 'admin');
INSERT INTO `user` VALUES (13, 'hello1234@126.com', 'e10adc3949ba59abbe56e057f20f883e', 'Michael Davis', '15944325422', NULL, NULL, b'0', '2024-03-13 22:46:33', 'admin', '2024-03-13 22:46:33', 'admin');
INSERT INTO `user` VALUES (14, 'emailtest@126.com', 'e10adc3949ba59abbe56e057f20f883e', 'Sarah Wilson', '13800443211', NULL, NULL, b'0', '2024-03-13 22:46:33', 'admin', '2024-03-13 22:46:33', 'admin');
INSERT INTO `user` VALUES (15, 'us7890@qq.net', 'e10adc3949ba59abbe56e057f20f883e', 'David Brown', '13899445413', NULL, NULL, b'0', '2024-03-13 22:46:33', 'admin', '2024-03-13 22:46:33', 'admin');
INSERT INTO `user` VALUES (16, 'exampleemail@163.net', 'e10adc3949ba59abbe56e057f20f883e', 'Jennifer Taylor', '13899005127', NULL, NULL, b'0', '2024-03-13 22:46:33', 'admin', '2024-03-13 22:46:33', 'admin');
INSERT INTO `user` VALUES (17, 'songxue2017@126.net', 'e10adc3949ba59abbe56e057f20f883e', 'Christopher Anderson', '13467523480', NULL, NULL, b'0', '2024-03-13 22:46:33', 'admin', '2024-03-13 22:46:33', 'admin');
INSERT INTO `user` VALUES (18, 'myemailaddress@yahoo.com', 'e10adc3949ba59abbe56e057f20f883e', 'Jessica Martinez', '13485325789', NULL, NULL, b'0', '2024-03-13 22:46:33', 'admin', '2024-03-13 22:46:33', 'admin');
INSERT INTO `user` VALUES (19, 'jinying2019@yahoo.com', 'e10adc3949ba59abbe56e057f20f883e', 'Matthew Thompson', '13873458210', NULL, NULL, b'0', '2024-03-13 22:46:33', 'admin', '2024-03-13 22:46:33', 'admin');
INSERT INTO `user` VALUES (20, 'emailtest123@qq.com', 'e10adc3949ba59abbe56e057f20f883e', 'Amanda Garcia', '13890312567', NULL, NULL, b'0', '2024-03-13 22:46:33', 'admin', '2024-03-13 22:46:33', 'admin');
INSERT INTO `user` VALUES (48, 'asdawd@1234.com', 'string', 'string222', '13890312569', NULL, NULL, b'1', NULL, 'admin', '2024-03-22 21:38:00', 'admin');

SET FOREIGN_KEY_CHECKS = 1;
