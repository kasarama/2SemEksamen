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
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`elementsID`),
  UNIQUE KEY `elementsID_UNIQUE` (`elementsID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elements`
--

LOCK TABLES `elements` WRITE;
/*!40000 ALTER TABLE `elements` DISABLE KEYS */;
INSERT INTO `elements` VALUES (1,'Tag'),(2,'Garage'),(3,'Skur');
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
  PRIMARY KEY (`materialID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materials`
--

LOCK TABLES `materials` WRITE;
/*!40000 ALTER TABLE `materials` DISABLE KEYS */;
INSERT INTO `materials` VALUES (1,'25x200 mm. trykimp. Brædt',360,'pcs','Understernbrædder360'),(2,'25x200 mm. trykimp. Brædt',540,'pcs','Understernbrædder540'),(3,'25x125 mm. trykimp. Brædt',360,'pcs','Oversternbrædder360'),(4,'25x125 mm. trykimp.	Brædt',540,'pcs','Oversternbrædder540'),(5,'38x73 mm. Lægte ubh.',420,'pcs','Lægte'),(6,'45x95 mm. Reglar ubh.',270,'pcs','Løsholter270'),(7,'45x95 mm. Reglar ubh.',240,'pcs','Løsholter240'),(8,'45x195 mm. spærtræ ubh.',600,'pcs','Rem/Spær'),(9,'45x195 mm. spærtræ ubh.',480,'pcs','Rem'),(10,'97x97 mm. trykimp. Stolpe',300,'pcs','Stolpe'),(11,'19x100	mm.	trykimp. Brædt',210,'pcs','SkurBeklædning'),(12,'19x100	mm. trykimp. Brædt',360,'pcs','Vandbræt360'),(13,'19x100	mm.	trykimp. Brædt',540,'pcs','Vandbræt540'),(14,'Plastmo Ecolite blåtonet',600,'pcs','T600'),(15,'Plastmo Ecolite blåtonet',360,'pcs','T300'),(16,'plastmo bundskruer',200,'pcs','Bundskruer'),(17,'hulbånd 1x20 mm',10,'rulle','Hulbånd'),(18,'universal 190 mm højre',NULL,'pcs','UniversalbeslagHøjre'),(19,'universal 190 mm venstre',NULL,'pcs','UniversalbeslagVenstre'),(20,'4,5x60	mm.	skruer',200,'pcs','SkruerStern&Vandbræt'),(21,'4,0x50	mm.	beslagskruer',250,'pcs','Beslagskruer'),(22,'bræddebolt	10x120 mm.',NULL,'pcs','Bræddebolt'),(23,'firkantskiver 40x40x11 mm',NULL,'pcs','Firkantskiver'),(24,'4,5x70 mm.	Skruer',400,'pk.','SkruerYdreBeklædning'),(25,'4,5x50 mm.	Skruer',300,'pk.','SkruerInnerBeklædning'),(26,'stalddørsgreb 50x75',NULL,'set','Lås'),(27,'t hængsel 390 mm',NULL,'pcs','Hængsel'),(28,'vinkelbeslag 35',NULL,'pcs','Vinkelbeslag');
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

-- Dump completed on 2020-04-22 14:41:57
