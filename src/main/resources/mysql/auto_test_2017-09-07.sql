# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.19)
# Database: auto_test
# Generation Time: 2017-09-07 03:08:17 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table expected_testing_output
# ------------------------------------------------------------

DROP TABLE IF EXISTS `expected_testing_output`;

CREATE TABLE `expected_testing_output` (
  `expected_output_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `testing_id` int(11) DEFAULT NULL,
  `output_key` varchar(11) DEFAULT NULL,
  `output_value` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`expected_output_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `expected_testing_output` WRITE;
/*!40000 ALTER TABLE `expected_testing_output` DISABLE KEYS */;

INSERT INTO `expected_testing_output` (`expected_output_id`, `testing_id`, `output_key`, `output_value`)
VALUES
	(11,16,'code','0'),
	(12,17,'code','0'),
	(13,18,'code','0'),
	(14,19,'code','0'),
	(15,20,'',''),
	(16,21,'code','0'),
	(17,22,'code','0'),
	(18,23,'code','1');

/*!40000 ALTER TABLE `expected_testing_output` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table regist_template
# ------------------------------------------------------------

DROP TABLE IF EXISTS `regist_template`;

CREATE TABLE `regist_template` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(1024) DEFAULT NULL,
  `password` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `regist_template` WRITE;
/*!40000 ALTER TABLE `regist_template` DISABLE KEYS */;

INSERT INTO `regist_template` (`id`, `username`, `password`)
VALUES
	(1,'abcd','abcd'),
	(2,'1234','1234');

/*!40000 ALTER TABLE `regist_template` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table test
# ------------------------------------------------------------

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `name` varchar(24) DEFAULT NULL,
  `excuted` tinyint(1) DEFAULT '-1',
  `excute_time` datetime DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `is_excute_now` tinyint(1) NOT NULL,
  `url` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;

INSERT INTO `test` (`id`, `user_id`, `name`, `excuted`, `excute_time`, `create_time`, `is_excute_now`, `url`)
VALUES
	(1,2,'?',0,NULL,'2017-09-03 17:05:47',1,''),
	(2,2,'谁',-1,NULL,'2017-09-03 17:10:57',1,NULL),
	(3,2,'测试',0,NULL,'2017-09-03 17:13:25',1,''),
	(4,2,'asdf',1,'2017-09-07 10:55:55','2017-09-06 21:44:49',1,'http://127.0.0.1:8091'),
	(5,2,'ceshi',1,'2017-09-07 10:48:25','2017-09-07 10:43:47',1,'http://127.0.0.1:8091');

/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table testing
# ------------------------------------------------------------

DROP TABLE IF EXISTS `testing`;

CREATE TABLE `testing` (
  `testing_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `test_id` int(11) DEFAULT NULL,
  `url` varchar(1024) DEFAULT NULL,
  `testing_name` varchar(1024) DEFAULT NULL,
  `result` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`testing_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `testing` WRITE;
/*!40000 ALTER TABLE `testing` DISABLE KEYS */;

INSERT INTO `testing` (`testing_id`, `test_id`, `url`, `testing_name`, `result`)
VALUES
	(1,26,'j','j',NULL),
	(2,26,'j','j',NULL),
	(3,26,'j','j',NULL),
	(4,26,'j','j',NULL),
	(5,26,'a','a',NULL),
	(16,28,'/ceshi/login','ceshi',0),
	(17,29,'ceshi/login','ceshi',NULL),
	(18,29,'ceshi/login','ceshi',NULL),
	(19,30,'/ceshi/login','asdf',1),
	(21,5,'/ceshi/login','denglu1',1),
	(22,4,'/ceshi/login','1',1),
	(23,4,'/ceshi/login','2',1);

/*!40000 ALTER TABLE `testing` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table testing_input
# ------------------------------------------------------------

DROP TABLE IF EXISTS `testing_input`;

CREATE TABLE `testing_input` (
  `input_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `testing_id` int(11) DEFAULT NULL,
  `input_key` varchar(11) DEFAULT NULL,
  `input_value` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`input_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `testing_input` WRITE;
/*!40000 ALTER TABLE `testing_input` DISABLE KEYS */;

INSERT INTO `testing_input` (`input_id`, `testing_id`, `input_key`, `input_value`)
VALUES
	(16,16,'username','cbh'),
	(17,16,'password','cbh'),
	(18,17,'username','cbh'),
	(19,17,'password','cbh'),
	(20,18,'username','cbh'),
	(21,18,'password','cbh'),
	(22,19,'username','cbh'),
	(23,19,'password','cbh'),
	(24,20,'',''),
	(25,21,'username','cbh'),
	(26,21,'password','cbh'),
	(27,22,'username','cbh'),
	(28,22,'password','cbh'),
	(29,23,'username','cbh'),
	(30,23,'password','adsf');

/*!40000 ALTER TABLE `testing_input` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table testing_output
# ------------------------------------------------------------

DROP TABLE IF EXISTS `testing_output`;

CREATE TABLE `testing_output` (
  `output_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `testing_id` int(11) DEFAULT NULL,
  `output_key` varchar(24) DEFAULT NULL,
  `output_value` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`output_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `testing_output` WRITE;
/*!40000 ALTER TABLE `testing_output` DISABLE KEYS */;

INSERT INTO `testing_output` (`output_id`, `testing_id`, `output_key`, `output_value`)
VALUES
	(25,19,'code','0'),
	(26,21,'code','0'),
	(27,22,'code','0'),
	(28,22,'code','0'),
	(29,23,'code','1'),
	(30,23,'code','1');

/*!40000 ALTER TABLE `testing_output` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(24) DEFAULT NULL,
  `password` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` (`id`, `username`, `password`)
VALUES
	(1,'111','111'),
	(2,'1','1');

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
