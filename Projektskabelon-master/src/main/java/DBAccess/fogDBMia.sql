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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `items` (
  `itemDetailID` int(11) NOT NULL AUTO_INCREMENT,
  `actualSize` int(11) DEFAULT NULL,
  `variationID` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `orderID` int(11) NOT NULL,
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `materials` (
  `materialID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `thickness` int(11) DEFAULT NULL,
  `unit` varchar(45) DEFAULT NULL,
  `keyword` varchar(100) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `picture` varchar(100) DEFAULT NULL,
  `spending` double DEFAULT NULL,
  PRIMARY KEY (`materialID`),
  UNIQUE KEY `materialID` (`materialID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materials`
--

LOCK TABLES `materials` WRITE;
/*!40000 ALTER TABLE `materials` DISABLE KEYS */;
INSERT INTO `materials` VALUES (1,'SPÆRTRÆ UBEHANDLET',195,45,'stk',NULL,'Konstruktion',49.95,NULL,NULL),(2,'TRYKIMPRENERET BRÆDT',200,25,'stk',NULL,'Konstruktion',32.95,NULL,NULL),(3,'TRYKIMPRENERET BRÆDT',125,25,'stk','','Konstruktion',27.95,NULL,NULL),(4,'LÆGTE UBEHANDLET',73,38,'stk','','Skur',22.95,NULL,NULL),(5,'REGLAR UBEHANDLET',95,45,'stk','','Skur',24.95,NULL,NULL),(6,'TRYKIMPRENERET STOLPE',97,97,'stk','','Konstruktion',41.95,NULL,NULL),(7,'TRYKIMPRENERET BRÆDT',100,19,'stk','','Konstruktion',9.95,NULL,NULL),(8,'TRAPEZPLADE BLÅTONET',109,15,'stk','','FaldtTag',35.95,NULL,NULL),(9,'TRAPEZPLADE OPAL',106,15,'stk','','FladtTag',189.95,NULL,NULL),(10,'TRAPEZPLADE KLAR',109,15,'stk','','FladtTag',99.95,NULL,NULL),(11,'BUNDSKRUER',NULL,NULL,'pk','','FladtTag',409,NULL,NULL),(12,'HULBÅND',20,1,'rulle','','Konstruktion',209,NULL,NULL),(13,'UNIVERSALBESLAG',190,NULL,'stk','','Konstruktion',79.95,NULL,NULL),(14,'SKRUER',60,5,'pk','','Konstruktion',74.95,NULL,NULL),(15,'BESLAGSKRUER',50,4,'pk','','Konstruktion',1.7,NULL,NULL),(16,'BRÆDDEBOLT',120,10,'stk','','Konstruktion',5.5,NULL,NULL),(17,'FIRKANTSKIVER',40,11,'stk','','Konstruktion',10.11,NULL,NULL),(18,'SKRUER',70,5,'pk','','Konstruktion',129,NULL,NULL),(19,'SKRUER',50,5,'pk','','Konstruktion',99.95,NULL,NULL),(20,'STALDDØRSGREB',75,50,'stk','','Skur',59.95,NULL,NULL),(21,'HÆNGSEL',390,NULL,'stk','','Skur',49.95,NULL,NULL),(22,'VINKELBESLAG',35,NULL,'stk','','Skur',4.95,NULL,NULL),(23,'TÆTNINGSPROFIL',105,15,'stk','','FladtTag',44.95,NULL,NULL);
/*!40000 ALTER TABLE `materials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetails`
--

DROP TABLE IF EXISTS `orderdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orderdetails` (
  `orderID` int(11) NOT NULL,
  `constructionHeight` int(11) DEFAULT NULL,
  `carportWidth` int(11) DEFAULT NULL,
  `carportLength` int(11) DEFAULT NULL,
  `constructionLength` int(11) DEFAULT NULL,
  `constructionWidth` int(11) DEFAULT NULL,
  `shedDepth` int(11) DEFAULT NULL,
  `shedWidth` int(11) DEFAULT NULL,
  `shedSide` varchar(45) DEFAULT NULL,
  `constructionscol` varchar(45) DEFAULT NULL,
  `overlay` varchar(45) DEFAULT NULL,
  `roofHeight` int(11) DEFAULT NULL,
  `roofLength` int(11) DEFAULT NULL,
  `roofWidth` int(11) DEFAULT NULL,
  `roofDegree` int(11) DEFAULT NULL,
  `ispitched` tinyint(4) DEFAULT NULL,
  `tilt` int(11) DEFAULT NULL,
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orders` (
  `orderID` int(11) NOT NULL AUTO_INCREMENT,
  `customerID` int(11) NOT NULL,
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `variations` (
  `variationID` int(11) NOT NULL AUTO_INCREMENT,
  `materialID` int(11) DEFAULT NULL,
  `length` int(11) DEFAULT '0',
  `color` varchar(45) DEFAULT NULL,
  `quantity` int(11) DEFAULT '0',
  PRIMARY KEY (`variationID`),
  KEY `fk_material_variants_idx` (`materialID`),
  CONSTRAINT `fk_material_variants` FOREIGN KEY (`materialID`) REFERENCES `materials` (`materialID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='contains variations of material f.eg coulors or tekstures ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `variations`
--

LOCK TABLES `variations` WRITE;
/*!40000 ALTER TABLE `variations` DISABLE KEYS */;
INSERT INTO `variations` VALUES (1,1,300,NULL,1),(2,1,360,NULL,1),(3,1,420,NULL,1),(4,1,480,NULL,1),(5,1,540,NULL,1),(6,1,600,NULL,1),(7,1,660,NULL,1),(8,1,720,NULL,1),(9,2,300,NULL,1),(10,2,360,NULL,1),(11,2,420,NULL,1),(12,2,480,NULL,1),(13,2,540,NULL,1),(14,2,600,NULL,1),(15,3,300,NULL,1),(16,3,360,NULL,1),(17,3,420,NULL,1),(18,3,480,NULL,1),(19,3,540,NULL,1),(20,3,600,NULL,1),(21,6,240,NULL,1),(22,6,270,NULL,1),(23,6,300,NULL,1),(24,6,360,NULL,1),(25,7,180,NULL,1),(26,7,210,NULL,1),(27,7,240,NULL,1),(28,12,100,NULL,1),(29,13,0,NULL,1),(30,14,0,NULL,200),(31,15,0,NULL,50),(32,15,0,NULL,200),(33,15,0,NULL,250),(34,16,0,NULL,1),(35,17,0,NULL,1),(36,18,0,NULL,400),(37,19,0,NULL,300);
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

-- Dump completed on 2020-05-07 17:37:49
