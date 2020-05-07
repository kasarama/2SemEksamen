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
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `customerID` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`customerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items` (
  `itemDetailID` int NOT NULL AUTO_INCREMENT,
  `actualSize` int DEFAULT NULL,
  `variationID` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `cost` int DEFAULT NULL,
  `price` int DEFAULT NULL,
  `orderID` int NOT NULL,
  PRIMARY KEY (`itemDetailID`),
  KEY `fk_items_orders_idx` (`orderID`),
  KEY `fk_items_variants_idx` (`variationID`),
  CONSTRAINT `fk_items_orders` FOREIGN KEY (`orderID`) REFERENCES `orders` (`orderID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_items_variants` FOREIGN KEY (`variationID`) REFERENCES `variations` (`variationID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materials`
--

DROP TABLE IF EXISTS `materials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materials` (
  `materialID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `width` int DEFAULT NULL,
  `thickness` int DEFAULT NULL,
  `unit` varchar(45) DEFAULT NULL,
  `keyword` varchar(100) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `picture` varchar(100) DEFAULT NULL,
  `spending` double DEFAULT NULL,
  PRIMARY KEY (`materialID`),
  UNIQUE KEY `materialID` (`materialID`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materials`
--

LOCK TABLES `materials` WRITE;
/*!40000 ALTER TABLE `materials` DISABLE KEYS */;
INSERT INTO `materials` VALUES (1,'25x200 mm. trykimp. Brædt',360,NULL,'stk','Understernbrædder360','Konstruktion',NULL,NULL,NULL),(2,'25x200 mm. trykimp. Brædt',540,NULL,'stk','Understernbrædder540','Konstruktion',NULL,NULL,NULL),(3,'25x125 mm. trykimp. Brædt',360,NULL,'stk','Oversternbrædder360','Konstruktion',NULL,NULL,NULL),(4,'25x125 mm. trykimp.	Brædt',540,NULL,'stk','Oversternbrædder540','Konstruktion',NULL,NULL,NULL),(5,'38x73 mm. Lægte ubh.',420,NULL,'stk','Lægte','Skur',NULL,NULL,NULL),(6,'45x95 mm. Reglar ubh.',270,NULL,'stk','Løsholter270','Skur',NULL,NULL,NULL),(7,'45x95 mm. Reglar ubh.',240,NULL,'stk','Løsholter240','Skur',NULL,NULL,NULL),(8,'45x195 mm. spærtræ ubh.',600,NULL,'stk','Spær','Konstruktion',NULL,NULL,NULL),(9,'45x195 mm. spærtræ ubh.',600,NULL,'stk','Rem600','Konstruktion',NULL,NULL,NULL),(10,'45x195 mm. spærtræ ubh.',480,NULL,'stk','Rem480','Konstruktion',NULL,NULL,NULL),(11,'97x97 mm. trykimp. Stolpe',300,NULL,'stk','Stolpe','Konstruktion',NULL,NULL,NULL),(12,'19x100	mm.	trykimp. Brædt',210,NULL,'stk','SkurBeklædning','Skur',NULL,NULL,NULL),(13,'19x100	mm. trykimp. Brædt',360,NULL,'stk','Vandbræt360','Konstruktion',NULL,NULL,NULL),(14,'19x100	mm.	trykimp. Brædt',540,NULL,'stk','Vandbræt540','Konstruktion',NULL,NULL,NULL),(15,'Plastmo Ecolite blåtonet',300,NULL,'stk','T300','TagFladt',NULL,NULL,NULL),(16,'Plastmo Ecolite blåtonet',600,NULL,'stk','T600','TagFladt',NULL,NULL,NULL),(17,'Plastmo JumboLite opal',300,NULL,'stk','TJumboOpal300','TagFladt',NULL,NULL,NULL),(18,'Plastmo JumboLite opal',600,NULL,'stk','TJumboOpal600','TagFladt',NULL,NULL,NULL),(19,'Plastmo JärboPro opal',300,NULL,'stk','TJarboOpal300','TagFladt',NULL,NULL,NULL),(20,'Plastmo JärboPro opal',600,NULL,'stk','TJarboOpal600','TagFladt',NULL,NULL,NULL),(21,'Plastmo Ecolite klar',300,NULL,'stk','TKlar300','TagFladt',NULL,NULL,NULL),(22,'Plastmo Ecolite klar',600,NULL,'stk','TKlar600','TagFladt',NULL,NULL,NULL),(23,'Plastmo JumboLite klar',300,NULL,'stk','TJumboKlar300','TagFladt',NULL,NULL,NULL),(24,'Plastmo JumboLite klar',600,NULL,'stk','TJumboKlar600','TagFladt',NULL,NULL,NULL),(25,'Plastmo JärboPro klar',300,NULL,'stk','TJarboKlar300','TagFladt',NULL,NULL,NULL),(26,'Plastmo JärboPro klar',600,NULL,'stk','TJarboKlar600','TagFladt',NULL,NULL,NULL),(27,'Betontagsten rød',NULL,NULL,'stk','BetontagstenRød','TagPitched',NULL,NULL,NULL),(28,'Betontagsten teglrød',NULL,NULL,'stk','BetontagstenTeglrød','TagPitched',NULL,NULL,NULL),(29,'Betontagsten brun',NULL,NULL,'stk','BetontagstenBrun','TagPitched',NULL,NULL,NULL),(30,'Betontagsten sort',NULL,NULL,'stk','BetontagstenSort','TagPitched',NULL,NULL,NULL),(31,'Eternittag B6 grå',NULL,NULL,'stk','EternittagB6Grå','TagPitched',NULL,NULL,NULL),(32,'Eternittag B6 sort',NULL,NULL,'stk','EternittagB6Sort','TagPitched',NULL,NULL,NULL),(33,'Eternittag B6 mokka(brun)',NULL,NULL,'stk','EternittagB6Mokka','TagPitched',NULL,NULL,NULL),(34,'Eternittag B6 rødbrun',NULL,NULL,'stk','EternittagB6Rødbrun','TagPitched',NULL,NULL,NULL),(35,'Eternittag B6 teglrød',NULL,NULL,'stk','EternittagB6Teglrød','TagPitched',NULL,NULL,NULL),(36,'Eternittag B7 grå',NULL,NULL,'stk','EternittagB7Grå','TagPitched',NULL,NULL,NULL),(37,'Eternittag B7 sort',NULL,NULL,'stk','EternittagB7Sort','TagPitched',NULL,NULL,NULL),(38,'Eternittag B7 mokka(brun)',NULL,NULL,'stk','EternittagB7Mokka','TagPitched',NULL,NULL,NULL),(39,'Eternittag B7 rødbrun',NULL,NULL,'stk','EternittagB7Rødbrun','TagPitched',NULL,NULL,NULL),(40,'Eternittag B7 teglrød',NULL,NULL,'stk','EternittagB7Teglrød','TagPitched',NULL,NULL,NULL),(41,'Eternittag B7 rødflammet',NULL,NULL,'stk','EternittagB7Rødflammet','TagPitched',NULL,NULL,NULL),(42,'plastmo bundskruer 200 stk',NULL,NULL,'pk.','Bundskruer','Beslag&Skruer',NULL,NULL,NULL),(43,'hulbånd 1x20 mm. 10 mtr.',NULL,NULL,'ruller','Hulbånd','Beslag&Skruer',NULL,NULL,NULL),(44,'universal 190 mm højre',NULL,NULL,'stk','UniversalbeslagHøjre','Beslag&Skruer',NULL,NULL,NULL),(45,'universal 190 mm venstre',NULL,NULL,'stk','UniversalbeslagVenstre','Beslag&Skruer',NULL,NULL,NULL),(46,'4,5x60	mm.	skruer 200 stk',NULL,NULL,'pk.','SkruerStern&Vandbræt','Beslag&Skruer',NULL,NULL,NULL),(47,'4,0x50	mm.	beslagskruer 250 stk',NULL,NULL,'pk.','Beslagskruer','Beslag&Skruer',NULL,NULL,NULL),(48,'bræddebolt	10x120 mm.',NULL,NULL,'stk','Bræddebolt','Beslag&Skruer',NULL,NULL,NULL),(49,'firkantskiver 40x40x11 mm',NULL,NULL,'stk','Firkantskiver','Beslag&Skruer',NULL,NULL,NULL),(50,'4,5x70 mm.	Skruer 400 stk',NULL,NULL,'pk.','SkruerYdreBeklædning','Beslag&Skruer',NULL,NULL,NULL),(51,'4,5x50 mm.	Skruer 300 stk',NULL,NULL,'pk.','SkruerInnerBeklædning','Beslag&Skruer',NULL,NULL,NULL),(52,'stalddørsgreb 50x75',NULL,NULL,'sæt','Lås','Beslag&Skruer',NULL,NULL,NULL),(53,'t hængsel 390 mm',NULL,NULL,'stk','Hængsel','Beslag&Skruer',NULL,NULL,NULL),(54,'vinkelbeslag 35',NULL,NULL,'stk','Vinkelbeslag','Beslag&Skruer',NULL,NULL,NULL),(55,'Plastmo tætningsprofil jumbolite',100,NULL,'stk','TætningsprofilJumbo','Tag',44.95,NULL,NULL),(56,'Plastmo tætningsprofil ecolite',100,NULL,'stk','TætningsprofilEco','Tag',44.95,NULL,NULL),(57,'t hængsel 390 mm',1,NULL,'stk','Hængsler til skurdør','overlay',189,'overlay/hinge.png',NULL),(58,'stalddørsgreb 50x75',1,NULL,'stk','Greb til skurdør','overlay',189,'overlay/stalgreb19-50mm.png',NULL),(59,'klink',NULL,NULL,NULL,'overlay','overlay',NULL,NULL,NULL),(60,'HardiePlank',NULL,NULL,NULL,'overlay','overlay',NULL,NULL,NULL),(61,'brædder',NULL,NULL,NULL,'overlay','overlay',NULL,NULL,NULL);
/*!40000 ALTER TABLE `materials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetails`
--

DROP TABLE IF EXISTS `orderdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderdetails` (
  `orderID` int NOT NULL,
  `constructionHeight` int DEFAULT NULL,
  `carportWidth` int DEFAULT NULL,
  `carportLength` int DEFAULT NULL,
  `constructionLength` int DEFAULT NULL,
  `constructionWidth` int DEFAULT NULL,
  `shedDepth` int DEFAULT NULL,
  `shedWidth` int DEFAULT NULL,
  `shedSide` varchar(45) DEFAULT NULL,
  `constructionscol` varchar(45) DEFAULT NULL,
  `overlay` varchar(45) DEFAULT NULL,
  `roofHeight` int DEFAULT NULL,
  `roofLength` int DEFAULT NULL,
  `roofWidth` int DEFAULT NULL,
  `roofDegree` int DEFAULT NULL,
  `ispitched` tinyint DEFAULT NULL,
  `tilt` int DEFAULT NULL,
  UNIQUE KEY `orderID_UNIQUE` (`orderID`),
  KEY `listID_idx` (`orderID`),
  CONSTRAINT `fk_order_details` FOREIGN KEY (`orderID`) REFERENCES `orders` (`orderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='attributes of construction';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetails`
--

LOCK TABLES `orderdetails` WRITE;
/*!40000 ALTER TABLE `orderdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `orderID` int NOT NULL AUTO_INCREMENT,
  `customerID` int NOT NULL,
  `date` date NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `salePrice` double DEFAULT NULL,
  PRIMARY KEY (`orderID`),
  KEY `customerID_idx` (`customerID`),
  CONSTRAINT `customerID` FOREIGN KEY (`customerID`) REFERENCES `customers` (`customerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='all orders that have ever been made by a customer, that it''s status changes while processing an order';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `variations`
--

DROP TABLE IF EXISTS `variations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `variations` (
  `variationID` int NOT NULL AUTO_INCREMENT,
  `materialID` int DEFAULT NULL,
  `length` int DEFAULT '0',
  `color` varchar(45) DEFAULT NULL,
  `quantity` int DEFAULT '0',
  PRIMARY KEY (`variationID`),
  KEY `fk_material_variants_idx` (`materialID`),
  CONSTRAINT `fk_material_variants` FOREIGN KEY (`materialID`) REFERENCES `materials` (`materialID`) ON DELETE RESTRICT ON UPDATE RESTRICT
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

-- Dump completed on 2020-05-07 15:08:02
