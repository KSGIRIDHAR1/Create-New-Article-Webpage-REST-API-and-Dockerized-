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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `us_id` int(11) NOT NULL AUTO_INCREMENT,
  `us_name` varchar(80) DEFAULT NULL,
  `us_email` varchar(85) DEFAULT NULL,
  `us_password` varchar(255) DEFAULT NULL,
  `us_status` varchar(45) DEFAULT NULL,
  `us_ur_id` int(11) DEFAULT NULL,
  `us_la_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`us_id`),
  KEY `us_ur_id_fk_idx` (`us_ur_id`),
  KEY `us_la_id_fk_idx` (`us_la_id`),
  CONSTRAINT `us_la_id_fk` FOREIGN KEY (`us_la_id`) REFERENCES `language` (`la_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `us_ur_id_fk` FOREIGN KEY (`us_ur_id`) REFERENCES `user_role` (`ur_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'sz','admin@gmail.com','123456','1',1,1),(4,'Aasd','abc@gmail.com','1111111','1',2,3),(5,'sdfds','sdfs@gmail.com','sdfs','1',2,3),(8,'asd','asd@yahoo.com','asd','0',2,2),(16,'Giridhar','giridhar@email.com','giridhar','0',2,1),(17,'Giridhar','giridhar@email.com','giridhar','0',2,1),(18,'Vishal','vishal@gm.com','password','0',2,1),(19,'Giridhar','giridhar@email.com','giridhar','0',2,1),(20,'asdas','xzc@gmail.com','aaaaaa','0',2,3),(21,'Giridhar','giridhar@gmail.com','giridhar','0',2,4),(22,'Vishal','vishal@gm.com','password','0',2,1),(23,'Giridhar','giridhar1@gmail.com','giridhar','0',2,1),(24,'Giridhar','giridhar@email.com','giridhar','0',2,1),(25,'Giridhar','giridhar@gmail.com','giridhar','0',2,1),(26,'Giridhar','giridhar@email.com','giridhar','0',2,1),(27,'Giridhar','giridhar@gmail.com','giridhar','0',2,1),(28,'Giridhar','giridhar@email.com','giridhar','0',2,1),(29,'Giridhar','giridhar@gmail.com','giridhar','0',2,1),(30,'Giridhar','giridhar@email.com','giridhar','0',2,1),(31,'Giridhar','giridhar@gmail.com','giridhar','0',2,1),(32,'Giridhar','giridhar@email.com','giridhar','0',2,1),(33,'Giridhar','giridhar@gmail.com','giridhar','0',2,1),(34,'Giridhar','giridhar@email.com','giridhar','0',2,1),(35,'Giridhar','giridhar@gmail.com','giridhar','0',2,1),(36,'Giridhar','giridhar@email.com','giridhar','0',2,1),(37,'Giridhar','giridhar@gmail.com','giridhar','0',2,1),(38,'giridhar132','giri@gmail.com','56789012','0',2,1),(39,'abcd','abcd@gmail.com','abcdef','0',2,2),(40,'qqqq','qqq@gmail.com','1111111','0',2,1),(41,'rrr','rrr@gmail.com','rrrrrr','0',2,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-06 16:12:52
