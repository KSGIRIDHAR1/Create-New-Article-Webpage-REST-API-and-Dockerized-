CREATE DATABASE  IF NOT EXISTS `newsarticle` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `newsarticle`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: newsarticle
-- ------------------------------------------------------
-- Server version	5.1.45-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `favourite_article`
--

DROP TABLE IF EXISTS `favourite_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `favourite_article` (
  `fa_id` int(11) NOT NULL AUTO_INCREMENT,
  `fa_us_id` int(11) DEFAULT NULL,
  `fa_ar_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`fa_id`),
  KEY `fa_us_id_fk_idx` (`fa_us_id`),
  KEY `fa_ar_id_fk_idx` (`fa_ar_id`),
  CONSTRAINT `fa_ar_id_fk` FOREIGN KEY (`fa_ar_id`) REFERENCES `article` (`ar_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fa_us_id_fk` FOREIGN KEY (`fa_us_id`) REFERENCES `user` (`us_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=147 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favourite_article`
--

LOCK TABLES `favourite_article` WRITE;
/*!40000 ALTER TABLE `favourite_article` DISABLE KEYS */;
INSERT INTO `favourite_article` VALUES (53,5,13),(137,8,6),(138,8,6),(139,8,20),(143,38,23),(146,4,22);
/*!40000 ALTER TABLE `favourite_article` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-06 16:12:51
