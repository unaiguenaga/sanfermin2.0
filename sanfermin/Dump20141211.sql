CREATE DATABASE  IF NOT EXISTS `TELETXE` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `TELETXE`;
-- MySQL dump 10.13  Distrib 5.5.40, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: TELETXE
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
-- Table structure for table `Bezero`
--

DROP TABLE IF EXISTS `Bezero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Bezero` (
  `nan` int(11) NOT NULL,
  `izena` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`nan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Bezero`
--

LOCK TABLES `Bezero` WRITE;
/*!40000 ALTER TABLE `Bezero` DISABLE KEYS */;
INSERT INTO `Bezero` VALUES (17,'ainhoa','457536'),(32,'xenki','9869869'),(67,'mikel','5463'),(87,'ander','36346'),(98,'ieltzu','43764523'),(543,'jorge','21312'),(32145,'leire','45756436'),(73657,'unai','64848');
/*!40000 ALTER TABLE `Bezero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Eraikina`
--

DROP TABLE IF EXISTS `Eraikina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Eraikina` (
  `zenb` int(11) NOT NULL,
  `egoera` enum('bisitan','alokatuta','eskaintzan') DEFAULT NULL,
  `arazoak` enum('bai','ez') DEFAULT NULL,
  `data` date DEFAULT NULL,
  `bezeroNan` int(11) DEFAULT NULL,
  PRIMARY KEY (`zenb`),
  KEY `fk_Eraikina_1_idx` (`bezeroNan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Eraikina`
--

LOCK TABLES `Eraikina` WRITE;
/*!40000 ALTER TABLE `Eraikina` DISABLE KEYS */;
INSERT INTO `Eraikina` VALUES (10,'alokatuta','ez','2014-10-09',67),(18,'bisitan','ez','2014-10-09',32),(43,'eskaintzan','bai','2014-10-09',17),(54,'alokatuta','ez','2014-10-09',67),(58,'eskaintzan','bai','2014-10-09',17),(81,'eskaintzan','ez','2014-10-09',32),(83,'bisitan','ez','2014-10-09',67),(176,'alokatuta','ez','2014-10-09',67);
/*!40000 ALTER TABLE `Eraikina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `OrdainagiriLerro`
--

DROP TABLE IF EXISTS `OrdainagiriLerro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `OrdainagiriLerro` (
  `OrdainagiriZenb` int(11) NOT NULL,
  `EraikinZenb` int(11) NOT NULL,
  PRIMARY KEY (`OrdainagiriZenb`,`EraikinZenb`),
  KEY `fk_OrdainagiriLerro_1_idx` (`EraikinZenb`),
  CONSTRAINT `fk_OrdainagiriLerro_1` FOREIGN KEY (`EraikinZenb`) REFERENCES `Eraikina` (`zenb`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_OrdainagiriLerro_2` FOREIGN KEY (`OrdainagiriZenb`) REFERENCES `Ordainagiria` (`zenb`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OrdainagiriLerro`
--

LOCK TABLES `OrdainagiriLerro` WRITE;
/*!40000 ALTER TABLE `OrdainagiriLerro` DISABLE KEYS */;
INSERT INTO `OrdainagiriLerro` VALUES (354,10),(18,18),(6545,18),(15,43),(12,54),(45,58),(4,81),(987654,81),(21,83),(5454,83),(67,176);
/*!40000 ALTER TABLE `OrdainagiriLerro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Ordainagiria`
--

DROP TABLE IF EXISTS `Ordainagiria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Ordainagiria` (
  `zenb` int(11) NOT NULL,
  `data` date DEFAULT NULL,
  `ordainduta` enum('bai','ez') DEFAULT NULL,
  `guztiaBezBarne` float DEFAULT NULL,
  `bezeroNan` int(11) DEFAULT NULL,
  PRIMARY KEY (`zenb`),
  KEY `fk_Ordainagiria_1_idx` (`bezeroNan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ordainagiria`
--

LOCK TABLES `Ordainagiria` WRITE;
/*!40000 ALTER TABLE `Ordainagiria` DISABLE KEYS */;
INSERT INTO `Ordainagiria` VALUES (4,'2014-11-29','ez',48434400,98),(12,'2014-11-27','ez',36485300,17),(15,'2014-11-27','ez',9869350000,17),(18,'2014-11-27','ez',87593500000,17),(21,'2014-11-27','ez',347686000,17),(45,'2014-11-28','ez',4875.32,98),(67,'2014-11-28','ez',48754700000,32),(354,'2014-11-28','ez',48435.4,98),(5454,'2014-11-21','bai',9324230000,32145),(6545,'2014-11-25','bai',4832440,32145),(987654,'2014-11-29','ez',92332500,98);
/*!40000 ALTER TABLE `Ordainagiria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bisita`
--

DROP TABLE IF EXISTS `bisita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bisita` (
  `zenb` int(11) NOT NULL,
  `dataOrdua` datetime DEFAULT NULL,
  `API` int(11) DEFAULT NULL,
  `bezeroNan` int(11) DEFAULT NULL,
  `eraikinZenb` int(11) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  PRIMARY KEY (`zenb`),
  KEY `fk_bisita_1_idx` (`bezeroNan`),
  KEY `fk2_idx` (`eraikinZenb`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bisita`
--

LOCK TABLES `bisita` WRITE;
/*!40000 ALTER TABLE `bisita` DISABLE KEYS */;
INSERT INTO `bisita` VALUES (32,'2012-08-13 17:45:03',32532,73657,83,64848),(65,'2014-10-13 20:45:03',23525,73657,43,64848),(576,'2012-08-13 20:45:03',2353,87,43,36346),(2353,'2014-08-13 13:45:03',576,98,43,43764523),(3252,'2014-12-01 18:09:56',452957,98,43,36346),(9643,'2014-02-13 18:45:03',77548,87,18,36346),(46864,'2014-02-13 17:45:03',5647341,32,83,9869869),(56437,'2014-10-13 17:45:03',254222,32145,83,45756436),(73437,'2014-12-01 18:09:55',6534,17,18,457536),(75383,'2014-10-13 17:45:03',329741,32,43,9869869),(76475,'2014-12-01 18:09:55',4352,17,43,457536),(87654,'2012-08-14 17:45:03',7329741,32,18,9869869),(234567,'2014-04-13 17:45:03',41,32,43,9869869),(452957,'2012-08-13 09:45:03',3252,98,43,43764523),(856086,'2012-08-13 17:45:03',58463934,98,83,43764523),(58463934,'2012-08-13 12:45:03',856086,87,83,36346);
/*!40000 ALTER TABLE `bisita` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-11 20:13:30
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
INSERT INTO `entzierroa` VALUES ('2014-07-07',10,1),('2014-07-08',10,4),('2014-07-09',10,2),('2014-07-10',10,1),('2014-07-11',10,3),('2014-07-12',10,3),('2014-07-13',10,2),('2014-07-14',10,4);
/*!40000 ALTER TABLE `entzierroa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `erabiltzailea`
--

DROP TABLE IF EXISTS `erabiltzailea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `erabiltzailea` (
  `iderabiltzailea` varchar(20) NOT NULL,
  `pasahitza` varchar(45) DEFAULT NULL,
  `administratzailea` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iderabiltzailea`),
  UNIQUE KEY `iderabiltzailea_UNIQUE` (`iderabiltzailea`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `erabiltzailea`
--

LOCK TABLES `erabiltzailea` WRITE;
/*!40000 ALTER TABLE `erabiltzailea` DISABLE KEYS */;
INSERT INTO `erabiltzailea` VALUES ('ander','ander','ez'),('leire','leire','bai'),('unai','unai','ez'),('xenki','xenki','bai');
/*!40000 ALTER TABLE `erabiltzailea` ENABLE KEYS */;
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
INSERT INTO `ganadutegia` VALUES (1,'MMMM','Iruña','Joseba',999777222),(2,'MMMM','Zezena','Anton',999777222),(3,'MMMM','Lolo','Pepe',999777222),(4,'MMMM','Pepito','Jose',999777222),(5,'Erriberri','Julia','Mikel',333666777),(6,'hhh','tete','gorka',998993662),(7,'adad','dede','hoho',543762983),(8,'haha','gogo','saf',64523416),(9,'yy','yy','yy',9),(10,'rfjfkhg','fjhf','hjfghg',3753753),(14,'agfrg','adga','aga',7097564),(45,'ajdlks','Unai','akdsj',1234),(53,'xcvbn','LEIRE','dzxcvbn',11111111),(423,'garg','agdfga','agra',45145),(2342,'ddd','ddddd','ddd',1),(4513,'aargarg','aaaaaaaaaaaa','agrga',51345),(7777,'t','t','t',9),(9999,'y','y','u',7),(1234567,'sdfghjk','asdfghj','sdfghjkl',123456),(666666666,'agdfarg','bbbbbbbbbb','gargar',55);
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

-- Dump completed on 2014-12-11 20:13:30
