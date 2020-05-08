CREATE DATABASE  IF NOT EXISTS `fogdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `fogdb`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fogdb
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `materials`
--

DROP TABLE IF EXISTS `materials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materials` (
  `materialID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `size` int DEFAULT NULL,
  `unit` varchar(45) DEFAULT NULL,
  `keyword` varchar(100) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `picture` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`materialID`),
  UNIQUE KEY `materialID` (`materialID`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materials`
--

LOCK TABLES `materials` WRITE;
/*!40000 ALTER TABLE `materials` DISABLE KEYS */;
INSERT INTO `materials` VALUES (1,'25x200 mm. trykimp. Brædt',360,'stk','Understernbrædder360','Konstruktion',NULL,NULL),(2,'25x200 mm. trykimp. Brædt',540,'stk','Understernbrædder540','Konstruktion',NULL,NULL),(3,'25x125 mm. trykimp. Brædt',360,'stk','Oversternbrædder360','Konstruktion',NULL,NULL),(4,'25x125 mm. trykimp.	Brædt',540,'stk','Oversternbrædder540','Konstruktion',NULL,NULL),(5,'38x73 mm. Lægte ubh.',420,'stk','Lægte','Skur',NULL,NULL),(6,'45x95 mm. Reglar ubh.',270,'stk','Løsholter270','Skur',NULL,NULL),(7,'45x95 mm. Reglar ubh.',240,'stk','Løsholter240','Skur',NULL,NULL),(8,'45x195 mm. spærtræ ubh.',600,'stk','Spær','Konstruktion',NULL,NULL),(9,'45x195 mm. spærtræ ubh.',600,'stk','Rem600','Konstruktion',NULL,NULL),(10,'45x195 mm. spærtræ ubh.',480,'stk','Rem480','Konstruktion',NULL,NULL),(11,'97x97 mm. trykimp. Stolpe',300,'stk','Stolpe','Konstruktion',NULL,NULL),(12,'19x100	mm.	trykimp. Brædt',210,'stk','SkurBeklædning','Skur',NULL,NULL),(13,'19x100	mm. trykimp. Brædt',360,'stk','Vandbræt360','Konstruktion',NULL,NULL),(14,'19x100	mm.	trykimp. Brædt',540,'stk','Vandbræt540','Konstruktion',NULL,NULL),(15,'Plastmo Ecolite blåtonet',300,'stk','T300','TagFladt',NULL,NULL),(16,'Plastmo Ecolite blåtonet',600,'stk','T600','TagFladt',NULL,NULL),(17,'Plastmo JumboLite opal',300,'stk','TJumboOpal300','TagFladt',NULL,NULL),(18,'Plastmo JumboLite opal',600,'stk','TJumboOpal600','TagFladt',NULL,NULL),(19,'Plastmo JärboPro opal',300,'stk','TJarboOpal300','TagFladt',NULL,NULL),(20,'Plastmo JärboPro opal',600,'stk','TJarboOpal600','TagFladt',NULL,NULL),(21,'Plastmo Ecolite klar',300,'stk','TKlar300','TagFladt',NULL,NULL),(22,'Plastmo Ecolite klar',600,'stk','TKlar600','TagFladt',NULL,NULL),(23,'Plastmo JumboLite klar',300,'stk','TJumboKlar300','TagFladt',NULL,NULL),(24,'Plastmo JumboLite klar',600,'stk','TJumboKlar600','TagFladt',NULL,NULL),(25,'Plastmo JärboPro klar',300,'stk','TJarboKlar300','TagFladt',NULL,NULL),(26,'Plastmo JärboPro klar',600,'stk','TJarboKlar600','TagFladt',NULL,NULL),(27,'Betontagsten rød',NULL,'stk','BetontagstenRød','TagPitched',NULL,NULL),(28,'Betontagsten teglrød',NULL,'stk','BetontagstenTeglrød','TagPitched',NULL,NULL),(29,'Betontagsten brun',NULL,'stk','BetontagstenBrun','TagPitched',NULL,NULL),(30,'Betontagsten sort',NULL,'stk','BetontagstenSort','TagPitched',NULL,NULL),(31,'Eternittag B6 grå',NULL,'stk','EternittagB6Grå','TagPitched',NULL,NULL),(32,'Eternittag B6 sort',NULL,'stk','EternittagB6Sort','TagPitched',NULL,NULL),(33,'Eternittag B6 mokka(brun)',NULL,'stk','EternittagB6Mokka','TagPitched',NULL,NULL),(34,'Eternittag B6 rødbrun',NULL,'stk','EternittagB6Rødbrun','TagPitched',NULL,NULL),(35,'Eternittag B6 teglrød',NULL,'stk','EternittagB6Teglrød','TagPitched',NULL,NULL),(36,'Eternittag B7 grå',NULL,'stk','EternittagB7Grå','TagPitched',NULL,NULL),(37,'Eternittag B7 sort',NULL,'stk','EternittagB7Sort','TagPitched',NULL,NULL),(38,'Eternittag B7 mokka(brun)',NULL,'stk','EternittagB7Mokka','TagPitched',NULL,NULL),(39,'Eternittag B7 rødbrun',NULL,'stk','EternittagB7Rødbrun','TagPitched',NULL,NULL),(40,'Eternittag B7 teglrød',NULL,'stk','EternittagB7Teglrød','TagPitched',NULL,NULL),(41,'Eternittag B7 rødflammet',NULL,'stk','EternittagB7Rødflammet','TagPitched',NULL,NULL),(42,'plastmo bundskruer 200 stk',NULL,'pk.','Bundskruer','Beslag&Skruer',NULL,NULL),(43,'hulbånd 1x20 mm. 10 mtr.',NULL,'ruller','Hulbånd','Beslag&Skruer',NULL,NULL),(44,'universal 190 mm højre',NULL,'stk','UniversalbeslagHøjre','Beslag&Skruer',NULL,NULL),(45,'universal 190 mm venstre',NULL,'stk','UniversalbeslagVenstre','Beslag&Skruer',NULL,NULL),(46,'4,5x60	mm.	skruer 200 stk',NULL,'pk.','SkruerStern&Vandbræt','Beslag&Skruer',NULL,NULL),(47,'4,0x50	mm.	beslagskruer 250 stk',NULL,'pk.','Beslagskruer','Beslag&Skruer',NULL,NULL),(48,'bræddebolt	10x120 mm.',NULL,'stk','Bræddebolt','Beslag&Skruer',NULL,NULL),(49,'firkantskiver 40x40x11 mm',NULL,'stk','Firkantskiver','Beslag&Skruer',NULL,NULL),(50,'4,5x70 mm.	Skruer 400 stk',NULL,'pk.','SkruerYdreBeklædning','Beslag&Skruer',NULL,NULL),(51,'4,5x50 mm.	Skruer 300 stk',NULL,'pk.','SkruerInnerBeklædning','Beslag&Skruer',NULL,NULL),(52,'stalddørsgreb 50x75',NULL,'sæt','Lås','Beslag&Skruer',NULL,NULL),(53,'t hængsel 390 mm',NULL,'stk','Hængsel','Beslag&Skruer',NULL,NULL),(54,'vinkelbeslag 35',NULL,'stk','Vinkelbeslag','Beslag&Skruer',NULL,NULL),(55,'Plastmo tætningsprofil jumbolite',100,'stk','TætningsprofilJumbo','Tag',44.95,NULL),(56,'Plastmo tætningsprofil ecolite',100,'stk','TætningsprofilEco','Tag',44.95,NULL),(57,'t hængsel 390 mm',1,'stk','Hængsler til skurdør','overlay',189,'overlay/hinge.png'),(58,'stalddørsgreb 50x75',1,'stk','Greb til skurdør','overlay',189,'overlay/stalgreb19-50mm.png');
/*!40000 ALTER TABLE `materials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `newmaterials`
--

DROP TABLE IF EXISTS `newmaterials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `newmaterials` (
  `name` varchar(45) NOT NULL,
  `width` int DEFAULT NULL,
  `thickness` int DEFAULT NULL,
  `unit` varchar(45) DEFAULT NULL,
  `kayword` varchar(45) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `picture` varchar(45) DEFAULT NULL,
  `spending` double DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `newmaterials`
--

LOCK TABLES `newmaterials` WRITE;
/*!40000 ALTER TABLE `newmaterials` DISABLE KEYS */;
/*!40000 ALTER TABLE `newmaterials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sizes`
--

DROP TABLE IF EXISTS `sizes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sizes` (
  `materialName` varchar(45) NOT NULL,
  `size` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='contains available sizes of some of the materials';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sizes`
--

LOCK TABLES `sizes` WRITE;
/*!40000 ALTER TABLE `sizes` DISABLE KEYS */;
/*!40000 ALTER TABLE `sizes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `variations`
--

DROP TABLE IF EXISTS `variations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `variations` (
  `materialName` varchar(45) NOT NULL,
  `variation` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`materialName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='contains variations of material f.eg coulors or tekstures ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `variations`
--

LOCK TABLES `variations` WRITE;
/*!40000 ALTER TABLE `variations` DISABLE KEYS */;
/*!40000 ALTER TABLE `variations` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-04 11:51:08
