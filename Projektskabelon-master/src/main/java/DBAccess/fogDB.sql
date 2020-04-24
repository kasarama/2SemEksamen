-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fogdb
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customers` (
  `customerID` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `phoneNo` int(11) DEFAULT NULL,
  `adress` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`customerID`),
  UNIQUE KEY `idcustomers_UNIQUE` (`customerID`)
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
-- Table structure for table `elements`
--

DROP TABLE IF EXISTS `elements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `elements` (
  `elementsID` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`elementsID`),
  UNIQUE KEY `elementsID_UNIQUE` (`elementsID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elements`
--

LOCK TABLES `elements` WRITE;
/*!40000 ALTER TABLE `elements` DISABLE KEYS */;
INSERT INTO `elements` VALUES (1,'Tag'),(2,'Carport'),(3,'Skur');
/*!40000 ALTER TABLE `elements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemlists`
--

DROP TABLE IF EXISTS `itemlists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `itemlists` (
  `itemlistID` int(11) NOT NULL AUTO_INCREMENT,
  `partID` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `elementID` int(11) DEFAULT NULL,
  `materialID` int(11) DEFAULT NULL,
  PRIMARY KEY (`itemlistID`),
  UNIQUE KEY `itemlistID_UNIQUE` (`itemlistID`),
  KEY `partID_idx` (`partID`),
  KEY `elementID_idx` (`elementID`),
  KEY `materialsID_idx` (`materialID`),
  CONSTRAINT `elementID` FOREIGN KEY (`elementID`) REFERENCES `elements` (`elementsID`),
  CONSTRAINT `materialsID` FOREIGN KEY (`materialID`) REFERENCES `tree` (`treeID`),
  CONSTRAINT `partID` FOREIGN KEY (`partID`) REFERENCES `parts` (`partID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemlists`
--

LOCK TABLES `itemlists` WRITE;
/*!40000 ALTER TABLE `itemlists` DISABLE KEYS */;
/*!40000 ALTER TABLE `itemlists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materials`
--

DROP TABLE IF EXISTS `materials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `materials` (
  `materialID` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `unit` varchar(45) DEFAULT NULL,
  `keyword` varchar(100) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`materialID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materials`
--

LOCK TABLES `materials` WRITE;
/*!40000 ALTER TABLE `materials` DISABLE KEYS */;
INSERT INTO `materials` VALUES (1,'25x200 mm. trykimp. Brædt',360,'stk','Understernbrædder360','Konstruktion'),(2,'25x200 mm. trykimp. Brædt',540,'stk','Understernbrædder540','Konstruktion'),(3,'25x125 mm. trykimp. Brædt',360,'stk','Oversternbrædder360','Konstruktion'),(4,'25x125 mm. trykimp.	Brædt',540,'stk','Oversternbrædder540','Konstruktion'),(5,'38x73 mm. Lægte ubh.',420,'stk','Lægte','Skur'),(6,'45x95 mm. Reglar ubh.',270,'stk','Løsholter270','Skur'),(7,'45x95 mm. Reglar ubh.',240,'stk','Løsholter240','Skur'),(8,'45x195 mm. spærtræ ubh.',600,'stk','Spær','Konstruktion'),(9,'45x195 mm. spærtræ ubh.',600,'stk','Rem600','Konstruktion'),(10,'45x195 mm. spærtræ ubh.',480,'stk','Rem480','Konstruktion'),(11,'97x97 mm. trykimp. Stolpe',300,'stk','Stolpe','Konstruktion'),(12,'19x100	mm.	trykimp. Brædt',210,'stk','SkurBeklædning','Skur'),(13,'19x100	mm. trykimp. Brædt',360,'stk','Vandbræt360','Konstruktion'),(14,'19x100	mm.	trykimp. Brædt',540,'stk','Vandbræt540','Konstruktion'),(15,'Plastmo Ecolite blåtonet',300,'stk','T300','Tag'),(16,'Plastmo Ecolite blåtonet',600,'stk','T600','Tag'),(17,'Plastmo JumboLite opal',300,'stk','TJumboOpal300','Tag'),(18,'Plastmo JumboLite opal',600,'stk','TJumboOpal600','Tag'),(19,'Plastmo JärboPro opal',300,'stk','TJarboOpal300','Tag'),(20,'Plastmo JärboPro opal',600,'stk','TJarboOpal600','Tag'),(21,'Plastmo Ecolite klar',300,'stk','TKlar300','Tag'),(22,'Plastmo Ecolite klar',600,'stk','TKlar600','Tag'),(23,'Plastmo JumboLite klar',300,'stk','TJumboKlar300','Tag'),(24,'Plastmo JumboLite klar',600,'stk','TJumboKlar600','Tag'),(25,'Plastmo JärboPro klar',300,'stk','TJarboKlar300','Tag'),(26,'Plastmo JärboPro klar',600,'stk','TJarboKlar600','Tag'),(27,'Betontagsten rød',NULL,'stk','BetontagstenRød','Tag'),(28,'Betontagsten teglrød',NULL,'stk','BetontagstenTeglrød','Tag'),(29,'Betontagsten brun',NULL,'stk','BetontagstenBrun','Tag'),(30,'Betontagsten sort',NULL,'stk','BetontagstenSort','Tag'),(31,'Eternittag B6 grå',NULL,'stk','EternittagB6Grå','Tag'),(32,'Eternittag B6 sort',NULL,'stk','EternittagB6Sort','Tag'),(33,'Eternittag B6 mokka(brun)',NULL,'stk','EternittagB6Mokka','Tag'),(34,'Eternittag B6 rødbrun',NULL,'stk','EternittagB6Rødbrun','Tag'),(35,'Eternittag B6 teglrød',NULL,'stk','EternittagB6Teglrød','Tag'),(36,'Eternittag B7 grå',NULL,'stk','EternittagB7Grå','Tag'),(37,'Eternittag B7 sort',NULL,'stk','EternittagB7Sort','Tag'),(38,'Eternittag B7 mokka(brun)',NULL,'stk','EternittagB7Mokka','Tag'),(39,'Eternittag B7 rødbrun',NULL,'stk','EternittagB7Rødbrun','Tag'),(40,'Eternittag B7 teglrød',NULL,'stk','EternittagB7Teglrød','Tag'),(41,'Eternittag B7 rødflammet',NULL,'stk','EternittagB7Rødflammet','Tag'),(42,'plastmo bundskruer 200 stk',NULL,'pk.','Bundskruer','Beslag&Skruer'),(43,'hulbånd 1x20 mm. 10 mtr.',NULL,'ruller','Hulbånd','Beslag&Skruer'),(44,'universal 190 mm højre',NULL,'stk','UniversalbeslagHøjre','Beslag&Skruer'),(45,'universal 190 mm venstre',NULL,'stk','UniversalbeslagVenstre','Beslag&Skruer'),(46,'4,5x60	mm.	skruer 200 stk',NULL,'pk.','SkruerStern&Vandbræt','Beslag&Skruer'),(47,'4,0x50	mm.	beslagskruer 250 stk',NULL,'pk.','Beslagskruer','Beslag&Skruer'),(48,'bræddebolt	10x120 mm.',NULL,'stk','Bræddebolt','Beslag&Skruer'),(49,'firkantskiver 40x40x11 mm',NULL,'stk','Firkantskiver','Beslag&Skruer'),(50,'4,5x70 mm.	Skruer 400 stk',NULL,'pk.','SkruerYdreBeklædning','Beslag&Skruer'),(51,'4,5x50 mm.	Skruer 300 stk',NULL,'pk.','SkruerInnerBeklædning','Beslag&Skruer'),(52,'stalddørsgreb 50x75',NULL,'sæt','Lås','Beslag&Skruer'),(53,'t hængsel 390 mm',NULL,'stk','Hængsel','Beslag&Skruer'),(54,'vinkelbeslag 35',NULL,'stk','Vinkelbeslag','Beslag&Skruer');
/*!40000 ALTER TABLE `materials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orders` (
  `orderID` int(11) NOT NULL,
  `itemlistID` int(11) DEFAULT NULL,
  `customerID` int(11) DEFAULT NULL,
  `nettoPrice` double DEFAULT NULL,
  `coverage` double DEFAULT NULL,
  `salesPrice` double DEFAULT NULL,
  PRIMARY KEY (`orderID`),
  KEY `itemlistID_idx` (`itemlistID`),
  CONSTRAINT `itemlistID` FOREIGN KEY (`itemlistID`) REFERENCES `itemlists` (`itemlistID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parts`
--

DROP TABLE IF EXISTS `parts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `parts` (
  `partID` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`partID`),
  UNIQUE KEY `idparts_UNIQUE` (`partID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parts`
--

LOCK TABLES `parts` WRITE;
/*!40000 ALTER TABLE `parts` DISABLE KEYS */;
INSERT INTO `parts` VALUES (1,'25x200 mm. trykimp. Brædt'),(2,'25x200	mm.	trykimp.	Brædt');
/*!40000 ALTER TABLE `parts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-23 17:04:41
