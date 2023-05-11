/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-04-12 13:33:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
CREATE TABLE Student (
     id int NOT null GENERATED ALWAYS AS IDENTITY,
     age int NOT null,
     name VARCHAR(255),
     PRIMARY KEY (id)
);
