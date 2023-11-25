CREATE DATABASE  IF NOT EXISTS `dealershipdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `dealershipdb`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dealershipdb
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `brand` varchar(100) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `mileage` int DEFAULT NULL,
  `engine` varchar(255) DEFAULT NULL,
  `horsepower` int DEFAULT NULL,
  `license` varchar(45) DEFAULT NULL,
  `features` text,
  `image_id` bigint DEFAULT NULL,
  `available` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (2,'Audi R8','Audi','R8',79999.99,38591,'4.2L V8',430,'YGN/5f','																																								Bullet Resistant window (Full polymer)\r\nEasy Exit Driver Seat\r\nReverse Tilt Mirror\r\nOriginal Rear Camera\r\nCruise control\r\nSteering Volume Control\r\nVSC system\r\n\r\n							\r\n							\r\n							\r\n							\r\n							',2,1),(3,'BMW M6','BMW','M6',50988,44515,' 4.4L V8',552,'BGO/9R','						Premier Grade\r\n2018 Model\r\nBlackColor	\r\n360 Camera\r\nBlind Spot\r\nLeather Seat\r\nSeat Memory',3,1),(4,'Lexus LX 570','Lexus','LX 570',91939.99,900,'5.7L V8',383,'YGN/9f','				Lexus LX570 KURO Black Edition S 2021\r\nImported as brandnew(Dubai)\r\n2021 August (Production Date)\r\nOver 900km\r\n8 Speed Auto Transmission\r\nAWD\r\n3rd Row seatings(7 seaters)\r\nHeads Up Display\r\n360 Degree Camera\r\nWireless Charger\r\nSoft Closing Doors\r\nRear View Camera\r\nNo Accident,No Damage,No Error			',4,1),(5,'Toyota Land Cruiser','Toyota','Land Cruiser',139196.99,25,'3.3L TWIN TURBO V6',228,'YGN/2S','Land Cruiser GRJ 300L (Dubai)\r\nGrade- VX (70th Anniversary)\r\nInterior Color - Pearl White\r\nExterior Color - Black\r\nMileage - 2****\r\nJBL� Premium Sound System with 14 Speakers\r\nToyota Original 12.3-inch Infotainment\r\nRear Entertainment System\r\nHead Up Display (HUD)\r\nPanoramic View Camera (360 Camera)\r\nWireless Charger\r\nCool Box\r\nVentilated & Heated Seats (All Seats)\r\nRear Cross-Traffic Alert (RCTA)\r\nToyota Safety System\r\nSunroof\r\nAmbient Lighting\r\nRound Aircon / Round Sonars\r\nAdapted Variable Suspension (AVS)\r\nCrawl Control with Turn Assist\r\nAdaptive Cruise Control\r\n7 Seaters / 3rd Row Seat Motors\r\nPower Back Door\r\n5 Drive Modes (Eco , Comfort , Normal , Sport S , Sport S+)\r\n20 inches Original Chrome Rims\r\nTriple Beam LED Headlamp with Auto High Beam\r\nPower Back Door with Kick Sensor					',5,1),(6,'Toyota Fielder','Toyota','Fielder',84799.99,3768,'4.4L V6',256,'YGN/9P','G Grade\r\nWhite Color\r\n1500cc\r\n2WD\r\n74,000 km\r\nYGN (9P)\r\nTV & Back Camera\r\nSteering Controls\r\nDigital Air-con\r\nNanoe Air Purifier\r\nRemote Key\r\nFog Lamp\r\nAlloy Wheel					',6,1),(7,'Chevrolet Camaro','Chevrolet','Camaro',14500,126094,'6.2L V8',426,'SHN/3E','TV & Back Camera\r\nSteering Controls\r\nDigital Air-con\r\nNanoe Air Purifier\r\nRemote Key\r\nFog Lamp\r\nAlloy Wheel				',7,1);
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-25 22:46:06
