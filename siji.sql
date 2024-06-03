-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: siji
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `device`
--

DROP TABLE IF EXISTS `device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `device` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `user_id` int DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `device_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device`
--

LOCK TABLES `device` WRITE;
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
INSERT INTO `device` VALUES (3,'computer',2,2),(4,'mouse',2,1),(6,'phone',3,1),(7,'mouse',3,1),(8,'phone',4,1),(9,'computer',4,1),(11,'computer',7,1),(12,'computer',6,1),(13,'computer',8,1),(14,'computer',1,1),(15,'phone',7,1);
/*!40000 ALTER TABLE `device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fault`
--

DROP TABLE IF EXISTS `fault`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fault` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `device_id` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `device_id` (`device_id`),
  CONSTRAINT `fault_ibfk_1` FOREIGN KEY (`device_id`) REFERENCES `device` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fault`
--

LOCK TABLES `fault` WRITE;
/*!40000 ALTER TABLE `fault` DISABLE KEYS */;
INSERT INTO `fault` VALUES (3,'broken',4,'2024-06-03 14:28:49',1),(4,'broken',8,'2024-05-28 20:52:04',1),(5,'broken',9,'2024-05-28 20:51:08',1),(9,'borken',11,'2024-05-29 13:44:04',1),(10,'borken',15,'2024-05-29 13:48:01',1),(11,NULL,4,'2024-06-03 14:37:13',1),(12,NULL,4,'2024-06-03 14:37:41',1),(13,NULL,4,'2024-06-03 14:37:43',1),(14,NULL,4,'2024-06-03 14:37:44',1);
/*!40000 ALTER TABLE `fault` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `level` int DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'donk','Spirit','0754','Yeki',1,'cfa0860e83a4c3a763a7e62d825349f7','eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MTgxMDg0NzEsImlkIjowLCJwYXNzd29yZE1kNSI6ImNmYTA4NjBlODNhNGMzYTc2M2E3ZTYyZDgyNTM0OWY3In0.NwV9p0-SK9Zv8w2TsIuc29Zd3nBFRrvqVrvs3IcG65M'),(2,'Niko','G2','119','Serbia',2,'48a52207c776c04f3419db9ab6a2cbd1','eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MTg1OTk4MTAsImlkIjowLCJwYXNzd29yZE1kNSI6IjQ4YTUyMjA3Yzc3NmMwNGYzNDE5ZGI5YWI2YTJjYmQxIn0.M06fbqFV15OAJjL8Lb4WDaMlxjhPWQ_5aekiQOiadeQ'),(3,'ropz','Faze-clan','110','German',2,'48a52207c776c04f3419db9ab6a2cbd1','eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MTg1OTk4NzgsImlkIjowLCJwYXNzd29yZE1kNSI6IjQ4YTUyMjA3Yzc3NmMwNGYzNDE5ZGI5YWI2YTJjYmQxIn0.y_a7W4VyoRjCJyBR9DAS_vql-XKy7YIC11h59ztiXi4'),(4,'Zywoo','Vitality','12306','Paris',2,'48a52207c776c04f3419db9ab6a2cbd1','eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MTg1OTk5MjIsImlkIjowLCJwYXNzd29yZE1kNSI6IjQ4YTUyMjA3Yzc3NmMwNGYzNDE5ZGI5YWI2YTJjYmQxIn0.Rc9SljoC_flrlEY23imq1673dL5_DGNmylsCXRMnWqU'),(6,'simple','Natus-Vincere','96226','Keiv',1,'e10adc3949ba59abbe56e057f20f883e','eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MTg2MDQ1OTIsImlkIjowLCJwYXNzd29yZE1kNSI6ImUxMGFkYzM5NDliYTU5YWJiZTU2ZTA1N2YyMGY4ODNlIn0.qlJVLHbbdQ38JMwft7xUQqy9yH1UHVhyD3einXPIwAA'),(7,'jame','Virtus-Pro','10086','Moscow',1,'48a52207c776c04f3419db9ab6a2cbd1','eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MTg2ODQwNjQsImlkIjowLCJwYXNzd29yZE1kNSI6IjQ4YTUyMjA3Yzc3NmMwNGYzNDE5ZGI5YWI2YTJjYmQxIn0.wjanxeTY0yHFgIc5d1HtEH5E6RU4Ytlh9hv6mgjMIWA'),(8,'fame','Virtus-Pro','886','ST',1,'48a52207c776c04f3419db9ab6a2cbd1','eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MTg2ODQwNzQsImlkIjowLCJwYXNzd29yZE1kNSI6IjQ4YTUyMjA3Yzc3NmMwNGYzNDE5ZGI5YWI2YTJjYmQxIn0.TnkraKY0YQdExrt9cHYY8SpPGDkGBf-nq4Dw9lPlrLs'),(9,'mendor1',NULL,NULL,NULL,NULL,'48a52207c776c04f3419db9ab6a2cbd1','eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MTg2OTQ0OTYsImlkIjowLCJwYXNzd29yZE1kNSI6IjQ4YTUyMjA3Yzc3NmMwNGYzNDE5ZGI5YWI2YTJjYmQxIn0.5COlxCPO1TCCP0vylYcICiHUJuJwXkuxOVfHsrIAgmQ'),(10,'mendor2',NULL,NULL,NULL,NULL,'48a52207c776c04f3419db9ab6a2cbd1','eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MTg2OTQ1MDEsImlkIjowLCJwYXNzd29yZE1kNSI6IjQ4YTUyMjA3Yzc3NmMwNGYzNDE5ZGI5YWI2YTJjYmQxIn0.lkv5FgqKe6UaTKlmKxeryukk16dyMEVjzvqZdb1HZWg'),(11,'0',NULL,NULL,NULL,NULL,'c4ca4238a0b923820dcc509a6f75849b','eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MTg4NDkyNTgsImlkIjowLCJwYXNzd29yZE1kNSI6ImM0Y2E0MjM4YTBiOTIzODIwZGNjNTA5YTZmNzU4NDliIn0.AGGuZRNAlM6o26Bf3AdQTSHMO9kJNMAv4nyVoOlpexc'),(13,'x',NULL,NULL,NULL,NULL,'38684612f0c6bb6dfa16da92f4a6878f','eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MTg4NDkzNzgsImlkIjowLCJwYXNzd29yZE1kNSI6IjM4Njg0NjEyZjBjNmJiNmRmYTE2ZGE5MmY0YTY4NzhmIn0.Wytpw0pkkmXSLJxMk7fjD9wIiyLfdjYpn5wVuyaej_M'),(17,'admin',NULL,NULL,NULL,NULL,'e10adc3949ba59abbe56e057f20f883e','eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MTkxMTI2NjIsImlkIjowLCJwYXNzd29yZE1kNSI6ImUxMGFkYzM5NDliYTU5YWJiZTU2ZTA1N2YyMGY4ODNlIn0.O6nPqYchS8uC3Fx8_zz7eMFU8Q_lCMqxpiNg2zAOC5A'),(19,'1','1717407748879hina.jpg',NULL,NULL,0,'c4ca4238a0b923820dcc509a6f75849b','eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MTkxMzI3NzMsImlkIjowLCJwYXNzd29yZE1kNSI6ImM0Y2E0MjM4YTBiOTIzODIwZGNjNTA5YTZmNzU4NDliIn0.iGlGRbD_NbwvzgiadMTgKBXBWHE0B6NgWgpoeXUdo5U');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_order`
--

DROP TABLE IF EXISTS `work_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `maintenance_person_id` int DEFAULT NULL,
  `maintenance_time` datetime DEFAULT NULL,
  `fault_id` int DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `maintenance_person_id` (`maintenance_person_id`),
  KEY `fault_id` (`fault_id`),
  CONSTRAINT `work_order_ibfk_1` FOREIGN KEY (`maintenance_person_id`) REFERENCES `user` (`id`),
  CONSTRAINT `work_order_ibfk_2` FOREIGN KEY (`fault_id`) REFERENCES `fault` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_order`
--

LOCK TABLES `work_order` WRITE;
/*!40000 ALTER TABLE `work_order` DISABLE KEYS */;
INSERT INTO `work_order` VALUES (1,1,'2024-06-03 15:56:17',10,2),(2,10,'2024-05-29 15:15:32',3,1),(3,10,'2024-05-29 15:29:52',4,1),(4,9,'2024-05-29 15:15:53',5,1),(6,9,'2024-05-29 15:20:29',9,1);
/*!40000 ALTER TABLE `work_order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-03 19:25:45
