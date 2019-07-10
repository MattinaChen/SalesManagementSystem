drop database context;
CREATE DATABASE context;
use `context`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `company_id` int(11) NULL DEFAULT NULL,#营销部id
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

select * from company;
delete from company where id = 5;
-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES (1, '北京分公司', NULL);
INSERT INTO `company` VALUES (2, '上海分公司', NULL);
INSERT INTO `company` VALUES (3, '营业部one', 1);
INSERT INTO `company` VALUES (4, '营业部tow', 2);

-- ----------------------------
-- Table structure for compper
-- ----------------------------
#关系记录表
DROP TABLE IF EXISTS `compper`;
CREATE TABLE `compper`  (
  `company_id` int(11) NULL DEFAULT NULL,
  `personnel_id` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of compper
-- ----------------------------
INSERT INTO `compper` VALUES (3, 1);
INSERT INTO `compper` VALUES (4, 2);

-- ----------------------------
-- Table structure for personnel
-- ----------------------------
DROP TABLE IF EXISTS `personnel`;
CREATE TABLE `personnel`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `timeup` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of personnel
-- ----------------------------
INSERT INTO `personnel` VALUES (1, '张扬', '2019-01-01 00:00:00');
INSERT INTO `personnel` VALUES (2, '陈生', '2019-01-03 00:00:00');
INSERT INTO `personnel` VALUES (3, 'test', '2019-01-03 00:00:00');
INSERT INTO `personnel` VALUES (5, 'test2', '2019-01-03 00:00:00');



update `personnel` set name='test' where id=3;

SET FOREIGN_KEY_CHECKS = 1;

#-----------------select 语句
select * from company;
select * from compper;
select * from personnel,compper where  personnel.id=compper.personnel_id;


#------------delete语句
delete from company;
delete from compper where compper.company_id='3' and personnel_id='0';
delete from compper where compper.company_id='4' and personnel_id='0';
delete from personnel where id='5';


select a.name 姓名, c.name 营业部, d.name 分公司,a.timeup 创建时间
from personnel a left join compper b on a.id = b.personnel_id 
    left join company c on b.company_id = c.id 
    left join company d on c.company_id = d.id
where a.name like'%张%';


select a.name 姓名, c.name 营业部, d.name 分公司,a.timeup 创建时间
from personnel a left join compper b on a.id = b.personnel_id 
    left join company c on b.company_id = c.id 
    left join company d on c.company_id = d.id
where b.company_id =3;



#删除从第三行到第47行的数据
select * from personnel;
 delete from personnel where id in (5,10);
 
 
 #--------------------
show status like '%lock%';
show status like 'Table%';
SELECT * FROM INFORMATION_SCHEMA.INNODB_LOCKS;









