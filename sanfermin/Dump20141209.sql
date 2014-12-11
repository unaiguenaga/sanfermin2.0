CREATE DATABASE  IF NOT EXISTS `sanfermin` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sanfermin`;
-- MySQL dump 10.13  Distrib 5.5.40, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: sanfermin
-- ------------------------------------------------------
-- Server version	5.5.40-0ubuntu0.14.04.1

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
-- Table structure for table `Joalduna`
--

DROP TABLE IF EXISTS `Joalduna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Joalduna` (
  `id` int(11) NOT NULL,
  `jaiotzeData` date DEFAULT NULL,
  `pisua` float DEFAULT NULL,
  `altuera` float DEFAULT NULL,
  `kolorea` varchar(45) DEFAULT NULL,
  `fk_ganadutegia` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Joalduna_1_idx` (`fk_ganadutegia`),
  CONSTRAINT `fk_Joalduna_1` FOREIGN KEY (`fk_ganadutegia`) REFERENCES `ganadutegia` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Joalduna`
--

LOCK TABLES `Joalduna` WRITE;
/*!40000 ALTER TABLE `Joalduna` DISABLE KEYS */;
/*!40000 ALTER TABLE `Joalduna` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aldaketak`
--

DROP TABLE IF EXISTS `aldaketak`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aldaketak` (
  `fk_aldatua` int(11) NOT NULL,
  `fk_ordezkoa` int(11) NOT NULL,
  `fk_entzierroa` date NOT NULL,
  PRIMARY KEY (`fk_aldatua`,`fk_ordezkoa`,`fk_entzierroa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aldaketak`
--

LOCK TABLES `aldaketak` WRITE;
/*!40000 ALTER TABLE `aldaketak` DISABLE KEYS */;
/*!40000 ALTER TABLE `aldaketak` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `botoak`
--

DROP TABLE IF EXISTS `botoak`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `botoak` (
  `fk_emailea` int(11) NOT NULL,
  `fk_hartzailea` int(11) NOT NULL,
  `data` date NOT NULL,
  PRIMARY KEY (`fk_emailea`,`fk_hartzailea`,`data`),
  KEY `fk_botoak_2_idx` (`fk_hartzailea`),
  CONSTRAINT `fk_botoak_1` FOREIGN KEY (`fk_emailea`) REFERENCES `ganadutegia` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_botoak_2` FOREIGN KEY (`fk_hartzailea`) REFERENCES `ganadutegia` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `botoak`
--

LOCK TABLES `botoak` WRITE;
/*!40000 ALTER TABLE `botoak` DISABLE KEYS */;
/*!40000 ALTER TABLE `botoak` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entzierroa`
--

DROP TABLE IF EXISTS `entzierroa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entzierroa` (
  `id` date NOT NULL,
  `luzera` float DEFAULT NULL,
  `fk_ganadutegia` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_entzierroa_1_idx` (`fk_ganadutegia`),
  CONSTRAINT `fk_entzierroa_1` FOREIGN KEY (`fk_ganadutegia`) REFERENCES `ganadutegia` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entzierroa`
--

LOCK TABLES `entzierroa` WRITE;
/*!40000 ALTER TABLE `entzierroa` DISABLE KEYS */;
INSERT INTO `entzierroa` VALUES ('2014-07-07',10,1),('2014-07-08',10,4),('2014-07-09',10,2),('2014-07-10',10,1),('2014-07-11',10,3),('2014-07-12',10,3),('2014-07-13',10,2),('2014-07-14',10,4),('2014-12-09',10,1);
/*!40000 ALTER TABLE `entzierroa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ganadutegia`
--

DROP TABLE IF EXISTS `ganadutegia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ganadutegia` (
  `id` int(11) NOT NULL,
  `helbidea` varchar(45) DEFAULT NULL,
  `izena` varchar(45) DEFAULT NULL,
  `arduraduna` varchar(45) DEFAULT NULL,
  `tlf` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ganadutegia`
--

LOCK TABLES `ganadutegia` WRITE;
/*!40000 ALTER TABLE `ganadutegia` DISABLE KEYS */;
INSERT INTO `ganadutegia` VALUES (1,'MMMM','Iruña','Joseba',999777222),(2,'MMMM','Zezena','Anton',999777222),(3,'MMMM','Lolo','Pepe',999777222),(4,'MMMM','Pepito','Jose',999777222);
/*!40000 ALTER TABLE `ganadutegia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jaiak`
--

DROP TABLE IF EXISTS `jaiak`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jaiak` (
  `data` date NOT NULL,
  `fk_joalduna` int(11) NOT NULL,
  PRIMARY KEY (`data`,`fk_joalduna`),
  KEY `fk_jaiak_1_idx` (`fk_joalduna`),
  CONSTRAINT `fk_jaiak_1` FOREIGN KEY (`fk_joalduna`) REFERENCES `Joalduna` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jaiak`
--

LOCK TABLES `jaiak` WRITE;
/*!40000 ALTER TABLE `jaiak` DISABLE KEYS */;
/*!40000 ALTER TABLE `jaiak` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tratamendua`
--

DROP TABLE IF EXISTS `tratamendua`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tratamendua` (
  `data` date NOT NULL,
  `botika` varchar(45) NOT NULL,
  `dosia` float DEFAULT NULL,
  `fk_zezena` int(11) NOT NULL,
  PRIMARY KEY (`data`,`botika`,`fk_zezena`),
  KEY `fk_tratamendua_1_idx` (`fk_zezena`),
  CONSTRAINT `fk_tratamendua_1` FOREIGN KEY (`fk_zezena`) REFERENCES `zezena` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tratamendua`
--

LOCK TABLES `tratamendua` WRITE;
/*!40000 ALTER TABLE `tratamendua` DISABLE KEYS */;
/*!40000 ALTER TABLE `tratamendua` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zezena`
--

DROP TABLE IF EXISTS `zezena`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zezena` (
  `id` int(11) NOT NULL,
  `jaiotzeData` date DEFAULT NULL,
  `pisua` float DEFAULT NULL,
  `altuera` float DEFAULT NULL,
  `adarrenLuzera` varchar(45) DEFAULT NULL,
  `fk_ganadutegia` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_zezena_1_idx` (`fk_ganadutegia`),
  CONSTRAINT `fk_zezena_1` FOREIGN KEY (`fk_ganadutegia`) REFERENCES `ganadutegia` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zezena`
--

LOCK TABLES `zezena` WRITE;
/*!40000 ALTER TABLE `zezena` DISABLE KEYS */;
/*!40000 ALTER TABLE `zezena` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zezenaEntzierroa`
--

DROP TABLE IF EXISTS `zezenaEntzierroa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zezenaEntzierroa` (
  `parteHartu` enum('bai','ez') DEFAULT NULL,
  `denbora` time DEFAULT NULL,
  `fk_zezena` int(11) NOT NULL,
  `fk_entzierroa` date NOT NULL,
  PRIMARY KEY (`fk_zezena`,`fk_entzierroa`),
  KEY `fk_zezenaEntzierroa_2_idx` (`fk_entzierroa`),
  CONSTRAINT `fk_zezenaEntzierroa_1` FOREIGN KEY (`fk_zezena`) REFERENCES `zezena` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_zezenaEntzierroa_2` FOREIGN KEY (`fk_entzierroa`) REFERENCES `entzierroa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zezenaEntzierroa`
--

LOCK TABLES `zezenaEntzierroa` WRITE;
/*!40000 ALTER TABLE `zezenaEntzierroa` DISABLE KEYS */;
/*!40000 ALTER TABLE `zezenaEntzierroa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-09 15:06:56
