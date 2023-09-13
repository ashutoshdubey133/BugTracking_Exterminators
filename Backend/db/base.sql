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
  PRIMARY KEY (`bugId`),
  KEY `projectId_idx` (`projectId`),
  KEY `createdBy_idx` (`createdBy`),
  KEY `assignedTo_idx` (`assignedTo`),
  KEY `markedForClosingBy_idx` (`markedForClosingBy`),
  KEY `closedBy_idx` (`closedBy`),
  CONSTRAINT `assignedTo` FOREIGN KEY (`assignedTo`) REFERENCES `developer_tbl` (`developerId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `closedBy` FOREIGN KEY (`closedBy`) REFERENCES `pm_tbl` (`pmId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `createdBy` FOREIGN KEY (`createdBy`) REFERENCES `tester_tbl` (`testerId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `markedForClosingBy` FOREIGN KEY (`markedForClosingBy`) REFERENCES `developer_tbl` (`developerId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `projectIdFk` FOREIGN KEY (`projectId`) REFERENCES `project_tbl` (`projectId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bug_tbl`
--

LOCK TABLES `bug_tbl` WRITE;
/*!40000 ALTER TABLE `bug_tbl` DISABLE KEYS */;
INSERT INTO `bug_tbl` VALUES (501,'Bug1','Bug',1001,4,'2023-09-07',7,8,2,'2023-05-03','Open','Critical');
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
  `teamId` int(11) NOT NULL,
  PRIMARY KEY (`developerId`),
  KEY `teamId_idx` (`teamId`),
  CONSTRAINT `developerId` FOREIGN KEY (`developerId`) REFERENCES `user_tbl` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `teamIdFkDev` FOREIGN KEY (`teamId`) REFERENCES `team_tbl` (`teamId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `developer_tbl`
--

LOCK TABLES `developer_tbl` WRITE;
/*!40000 ALTER TABLE `developer_tbl` DISABLE KEYS */;
INSERT INTO `developer_tbl` VALUES (7,101),(9,101),(8,102);
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
INSERT INTO `pm_tbl` VALUES (1),(2),(3);
/*!40000 ALTER TABLE `pm_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project-pm_tbl`
--

DROP TABLE IF EXISTS `project-pm_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project-pm_tbl` (
  `projectId` int(11) NOT NULL,
  `pmId` int(11) NOT NULL,
  PRIMARY KEY (`projectId`),
  KEY `projectId_idx` (`projectId`),
  KEY `pmId` (`pmId`),
  CONSTRAINT `pmId` FOREIGN KEY (`pmId`) REFERENCES `pm_tbl` (`pmId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `projectId` FOREIGN KEY (`projectId`) REFERENCES `project_tbl` (`projectId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project-pm_tbl`
--

LOCK TABLES `project-pm_tbl` WRITE;
/*!40000 ALTER TABLE `project-pm_tbl` DISABLE KEYS */;
INSERT INTO `project-pm_tbl` VALUES (1001,1),(1002,1);
/*!40000 ALTER TABLE `project-pm_tbl` ENABLE KEYS */;
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
  `projectStatus` enum('InProgress','Completed') NOT NULL,
  PRIMARY KEY (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_tbl`
--

LOCK TABLES `project_tbl` WRITE;
/*!40000 ALTER TABLE `project_tbl` DISABLE KEYS */;
INSERT INTO `project_tbl` VALUES (1001,'project1','first','2023-09-08','InProgress'),(1002,'project2','second','2023-07-11','Completed'),(1003,'project3','third','2020-09-08','InProgress');
/*!40000 ALTER TABLE `project_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team-developer_tbl`
--

DROP TABLE IF EXISTS `team-developer_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team-developer_tbl` (
  `teamId` int(11) NOT NULL,
  `developerId` int(11) NOT NULL,
  PRIMARY KEY (`developerId`),
  KEY `teamId_idx` (`teamId`),
  KEY `developerId_idx` (`developerId`),
  CONSTRAINT `devloperId` FOREIGN KEY (`developerId`) REFERENCES `developer_tbl` (`developerId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `teamId` FOREIGN KEY (`teamId`) REFERENCES `team_tbl` (`teamId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team-developer_tbl`
--

LOCK TABLES `team-developer_tbl` WRITE;
/*!40000 ALTER TABLE `team-developer_tbl` DISABLE KEYS */;
INSERT INTO `team-developer_tbl` VALUES (101,7),(101,9),(102,8);
/*!40000 ALTER TABLE `team-developer_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_tbl`
--

DROP TABLE IF EXISTS `team_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team_tbl` (
  `teamId` int(11) NOT NULL,
  `pmId` int(11) NOT NULL,
  `testerId` int(11) NOT NULL,
  `projectId` int(11) DEFAULT NULL,
  PRIMARY KEY (`teamId`),
  UNIQUE KEY `projectId_UNIQUE` (`projectId`),
  KEY `projectIdFkTeam_idx` (`projectId`),
  CONSTRAINT `projectIdFkTeam` FOREIGN KEY (`projectId`) REFERENCES `project_tbl` (`projectId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_tbl`
--

LOCK TABLES `team_tbl` WRITE;
/*!40000 ALTER TABLE `team_tbl` DISABLE KEYS */;
INSERT INTO `team_tbl` VALUES (101,1,5,1001),(102,2,6,1002),(103,3,7,1003);
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
INSERT INTO `tester_tbl` VALUES (4),(5),(6);
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
INSERT INTO `user_tbl` VALUES (1,'Pranav','pranav@gmail.com'),(2,'Sunil','sunil@gmail.com'),(3,'Mohit','mohit@gmail.com'),(4,'Pritesh','pritesh@gmail.com'),(5,'Yogesh','yogesh@gmail.com'),(6,'Ram','ram@gmail.com'),(7,'Gita','gita@gmail.com'),(8,'Prachi','prachi@gmail.com'),(9,'Shivani','shivani@gmail.com');
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

-- Dump completed on 2023-09-14  0:22:55
