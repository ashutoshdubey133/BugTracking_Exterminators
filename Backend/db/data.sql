-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: bts_db
-- ------------------------------------------------------
-- Server version	5.7.43-log

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
-- Table structure for table `bug_tbl`
--

DROP TABLE IF EXISTS `bug_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bug_tbl` (
  `bugId` int(11) NOT NULL,
  `title` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `projectId` int(11) NOT NULL,
  `createdBy` int(11) NOT NULL,
  `openDate` date NOT NULL,
  `assignedTo` int(11) NOT NULL,
  `markedForClosingBy` int(11) NOT NULL,
  `closedBy` int(11) NOT NULL,
  `closedOn` date NOT NULL,
  `bugStatus` enum('Open','Closed') NOT NULL,
  `severityLevel` enum('Critical','Major','Minor','Trivial') NOT NULL,
  PRIMARY KEY (`bugId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bug_tbl`
--

LOCK TABLES `bug_tbl` WRITE;
/*!40000 ALTER TABLE `bug_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `bug_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `developer_tbl`
--

DROP TABLE IF EXISTS `developer_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `developer_tbl` (
  `developerId` int(11) NOT NULL,
  PRIMARY KEY (`developerId`),
  CONSTRAINT `developerId` FOREIGN KEY (`developerId`) REFERENCES `user_tbl` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `developer_tbl`
--

LOCK TABLES `developer_tbl` WRITE;
/*!40000 ALTER TABLE `developer_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `developer_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pm_tbl`
--

DROP TABLE IF EXISTS `pm_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pm_tbl` (
  `pmId` int(11) NOT NULL,
  PRIMARY KEY (`pmId`),
  CONSTRAINT `id` FOREIGN KEY (`pmId`) REFERENCES `user_tbl` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pm_tbl`
--

LOCK TABLES `pm_tbl` WRITE;
/*!40000 ALTER TABLE `pm_tbl` DISABLE KEYS */;
INSERT INTO `pm_tbl` VALUES (1);
/*!40000 ALTER TABLE `pm_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_tbl`
--

DROP TABLE IF EXISTS `project_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project_tbl` (
  `projectId` int(11) NOT NULL,
  `projectName` varchar(45) NOT NULL,
  `projectDescription` varchar(45) NOT NULL,
  `startDate` date NOT NULL,
  `teamId` int(11) NOT NULL,
  `projectStatus` enum('InProgress','Completed') NOT NULL,
  PRIMARY KEY (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_tbl`
--

LOCK TABLES `project_tbl` WRITE;
/*!40000 ALTER TABLE `project_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_tbl`
--

DROP TABLE IF EXISTS `team_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team_tbl` (
  `pmId` int(11) NOT NULL,
  `testerId` int(11) NOT NULL,
  `developerId` varchar(45) NOT NULL,
  `projectId` int(11) NOT NULL,
  PRIMARY KEY (`pmId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_tbl`
--

LOCK TABLES `team_tbl` WRITE;
/*!40000 ALTER TABLE `team_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `team_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tester_tbl`
--

DROP TABLE IF EXISTS `tester_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tester_tbl` (
  `testerId` int(11) NOT NULL,
  PRIMARY KEY (`testerId`),
  CONSTRAINT `testerId` FOREIGN KEY (`testerId`) REFERENCES `user_tbl` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tester_tbl`
--

LOCK TABLES `tester_tbl` WRITE;
/*!40000 ALTER TABLE `tester_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `tester_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_tbl`
--

DROP TABLE IF EXISTS `user_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_tbl` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_tbl`
--

LOCK TABLES `user_tbl` WRITE;
/*!40000 ALTER TABLE `user_tbl` DISABLE KEYS */;
INSERT INTO `user_tbl` VALUES (1,'Pranav','pranav@gmail.com'),(2,'Sunil','sunil@gmail.com');
/*!40000 ALTER TABLE `user_tbl` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-11 23:15:33
