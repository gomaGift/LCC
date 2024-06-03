CREATE DATABASE  IF NOT EXISTS `lusaka_city_council` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `lusaka_city_council`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: lusaka_city_council
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `employee_bank_details`
--

DROP TABLE IF EXISTS `employee_bank_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_bank_details` (
  `employee_number` varchar(255) NOT NULL,
  `account_number` varchar(255) DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `sort_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_bank_details`
--

LOCK TABLES `employee_bank_details` WRITE;
/*!40000 ALTER TABLE `employee_bank_details` DISABLE KEYS */;
INSERT INTO `employee_bank_details` VALUES ('2020010470','93400004555','Zanaco','Unza Branch','093'),('EMP_898677','93400004554','Zanaco','Unza Branch','093');
/*!40000 ALTER TABLE `employee_bank_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_data`
--

DROP TABLE IF EXISTS `employee_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_data` (
  `id` int NOT NULL AUTO_INCREMENT,
  `employeeNumber` varchar(255) NOT NULL,
  `province` varchar(255) NOT NULL,
  `localAuthority` varchar(255) NOT NULL,
  `department` varchar(255) NOT NULL,
  `section` varchar(255) DEFAULT NULL,
  `substitutePosition` varchar(255) DEFAULT NULL,
  `dateOfFirstAppointment` date NOT NULL,
  `dateOfConfirmation` date DEFAULT NULL,
  `dateAppointedToCurrentPosition` date DEFAULT NULL,
  `actingWithAViewPosition` varchar(255) DEFAULT NULL,
  `lastAppraisalDate` date DEFAULT NULL,
  `appraisalStatus` varchar(255) DEFAULT NULL,
  `dateOfContractEnd` date DEFAULT NULL,
  `employmentType` varchar(255) DEFAULT NULL,
  `employmentStatus` varchar(255) DEFAULT NULL,
  `position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `salaryNotch` varchar(255) DEFAULT NULL,
  `thirdParties` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_data`
--

LOCK TABLES `employee_data` WRITE;
/*!40000 ALTER TABLE `employee_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_details`
--

DROP TABLE IF EXISTS `employee_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_details` (
  `employee_id` varchar(255) NOT NULL,
  `acting_withaview_position` varchar(255) DEFAULT NULL,
  `appraisal_status` varchar(255) DEFAULT NULL,
  `date_appointed_to_current_position` date DEFAULT NULL,
  `date_of_appointment` date DEFAULT NULL,
  `date_of_confirmation` date DEFAULT NULL,
  `date_of_contract_end` date DEFAULT NULL,
  `employment_status` varchar(255) DEFAULT NULL,
  `employment_type` varchar(255) DEFAULT NULL,
  `last_appraisal_date` date DEFAULT NULL,
  `local_authority` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `section` varchar(255) DEFAULT NULL,
  `substitute_position` varchar(255) DEFAULT NULL,
  `third_parties` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_details`
--

LOCK TABLES `employee_details` WRITE;
/*!40000 ALTER TABLE `employee_details` DISABLE KEYS */;
INSERT INTO `employee_details` VALUES ('123456789','kjdp','Good','2026-04-11','2026-02-11','2026-05-11','2026-02-11','lm, d','lndn','2026-04-07','bnd','Town Clerk','Luapula','lidhidh','jnddln','bjkbdjkbd'),('2020010470','','','2021-12-24','2022-12-24','2022-12-25','2022-01-27','NJ','LH','2026-04-28','Section','Director Engineering Services','Southern','','',''),('2020050490','ac','Good','2022-01-25','2021-01-28','2023-03-25','2023-12-25','status','Emp type','2023-01-25','Local Authority','Assistant Director Engineering -Development','Eastern','1','su','dkdk'),('EMP_894545','Testing','Outstanding','2024-03-22','2024-03-08','2024-03-08','2024-03-07','New Employee','Casual','2024-03-06','Lusaka','Brick Layer','Lusaka','It Section','Testing','3rd'),('EMP_898677','','Outstanding','2024-03-07','2024-03-08','2024-03-15','2024-03-08','New Employee','Casual','2024-03-22','Lusaka','Carpenter','Lusaka','It Section','Testing','Thir'),('EMP_89898','Testing','Outstanding','2024-03-09','2024-03-06','2024-03-22','2024-03-23','New Employee','Casual','2024-03-24','Lusaka','AC001','Lusaka','It Section','Testing','Testing'),('EMP_89898343','Testing','Outstanding','2024-03-20','2024-03-07','2024-03-07','2024-03-08','New Employee','Casual','2024-03-08','Lusaka','AC001','Lusaka','It Section','Testing','yu'),('EMP_89899','Testing','Outstanding','2024-03-13','2024-02-28','2024-03-13','2024-03-15','New Employee','Casual','2024-03-15','Lusaka','AC001','Central','It Section','Testing','Testing'),('GM34567','None','Outstanding','2020-01-10','2018-10-20','2019-03-15','2025-10-20','Active','Permanent','2023-09-28','Kitwe Municipal Council','Grade 6','Copperbelt','Accounts Payable','Financial Analyst','None'),('LCC0009','Testing','Outstanding','2024-03-20','2024-03-13','2024-03-20','2024-03-13','New Employee','Casual','2024-03-14','Lusaka','AC001','Lusaka','It Section','Testing','test'),('LGS009','Testing','Outstanding','2024-03-14','2024-03-13','2024-03-29','2024-03-06','New Employee','Casual','2024-03-21','Lusaka','AC001','Muchinga','It Section','Testing','yu');
/*!40000 ALTER TABLE `employee_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_insurance`
--

DROP TABLE IF EXISTS `employee_insurance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_insurance` (
  `date_end` date DEFAULT NULL,
  `date_started` date DEFAULT NULL,
  `employee_id` varchar(255) NOT NULL,
  `insurance_type` varchar(255) NOT NULL,
  PRIMARY KEY (`employee_id`,`insurance_type`),
  KEY `FKcm24b9wq4rwx2ltm7dmbowvwm` (`insurance_type`),
  CONSTRAINT `FKcm24b9wq4rwx2ltm7dmbowvwm` FOREIGN KEY (`insurance_type`) REFERENCES `insurance` (`insurance_type`),
  CONSTRAINT `FKmu85h071st9euire0m37y5wak` FOREIGN KEY (`employee_id`) REFERENCES `employee_details` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_insurance`
--

LOCK TABLES `employee_insurance` WRITE;
/*!40000 ALTER TABLE `employee_insurance` DISABLE KEYS */;
INSERT INTO `employee_insurance` VALUES (NULL,'2024-04-28','2020010470','NHIMA'),(NULL,'2024-04-28','EMP_898677','NHIMA');
/*!40000 ALTER TABLE `employee_insurance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_on_payroll`
--

DROP TABLE IF EXISTS `employee_on_payroll`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_on_payroll` (
  `employee_id` varchar(255) NOT NULL,
  `active` bit(1) NOT NULL,
  `date_end` date DEFAULT NULL,
  `date_started` date DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_on_payroll`
--

LOCK TABLES `employee_on_payroll` WRITE;
/*!40000 ALTER TABLE `employee_on_payroll` DISABLE KEYS */;
INSERT INTO `employee_on_payroll` VALUES ('2020010470',_binary '',NULL,NULL),('EMP_898677',_binary '',NULL,NULL);
/*!40000 ALTER TABLE `employee_on_payroll` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_other_deduction`
--

DROP TABLE IF EXISTS `employee_other_deduction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_other_deduction` (
  `date_end` varchar(255) DEFAULT NULL,
  `date_started` varchar(255) DEFAULT NULL,
  `employee_id` varchar(255) NOT NULL,
  `deduction_type` varchar(255) NOT NULL,
  PRIMARY KEY (`employee_id`,`deduction_type`),
  KEY `FKieeqglnekdgasde4ub08jaw5h` (`deduction_type`),
  CONSTRAINT `FKbefu2y3nqww2t56s41gsutv3j` FOREIGN KEY (`employee_id`) REFERENCES `employee_details` (`employee_id`),
  CONSTRAINT `FKd5m8n2q7bqhm15bs9n909k6xc` FOREIGN KEY (`employee_id`) REFERENCES `employee_on_payroll` (`employee_id`),
  CONSTRAINT `FKieeqglnekdgasde4ub08jaw5h` FOREIGN KEY (`deduction_type`) REFERENCES `other_deduction` (`deduction_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_other_deduction`
--

LOCK TABLES `employee_other_deduction` WRITE;
/*!40000 ALTER TABLE `employee_other_deduction` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_other_deduction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_payroll_deduction`
--

DROP TABLE IF EXISTS `employee_payroll_deduction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_payroll_deduction` (
  `deduction_date` varchar(255) NOT NULL,
  `deduction_type` varchar(255) NOT NULL,
  `employee_id` varchar(255) NOT NULL,
  `amount` double NOT NULL,
  `last_modified` date DEFAULT NULL,
  `percentage_deduction` double NOT NULL,
  PRIMARY KEY (`deduction_date`,`deduction_type`,`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_payroll_deduction`
--

LOCK TABLES `employee_payroll_deduction` WRITE;
/*!40000 ALTER TABLE `employee_payroll_deduction` DISABLE KEYS */;
INSERT INTO `employee_payroll_deduction` VALUES ('May-29-2024','LASIV','2020010470',360,'2024-05-29',3),('May-29-2024','NAPSA','EMP_898677',500,'2024-05-29',5),('May-29-2024','NHIMA','2020010470',120,'2024-05-29',1),('May-29-2024','NHIMA','EMP_898677',100,'2024-05-29',1),('May-29-2024','P.A.Y.E(INCOME TAX)','2020010470',2066,'2024-05-29',0),('May-29-2024','P.A.Y.E(INCOME TAX)','EMP_898677',1326,'2024-05-29',0);
/*!40000 ALTER TABLE `employee_payroll_deduction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_pension`
--

DROP TABLE IF EXISTS `employee_pension`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_pension` (
  `employee_id` varchar(255) NOT NULL,
  `date_end` date DEFAULT NULL,
  `date_started` date DEFAULT NULL,
  `pension` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_pension`
--

LOCK TABLES `employee_pension` WRITE;
/*!40000 ALTER TABLE `employee_pension` DISABLE KEYS */;
INSERT INTO `employee_pension` VALUES ('2020010470',NULL,NULL,'LASIV'),('EMP_898677',NULL,NULL,'NAPSA');
/*!40000 ALTER TABLE `employee_pension` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_personal_data`
--

DROP TABLE IF EXISTS `employee_personal_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_personal_data` (
  `employee_number` varchar(255) NOT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `former_file_number` varchar(255) DEFAULT NULL,
  `maiden_name` varchar(255) DEFAULT NULL,
  `marital_status` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `nrc` varchar(255) DEFAULT NULL,
  `physical_challenge` varchar(255) DEFAULT NULL,
  `postal_address` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `staff_photo` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `town_or_village` varchar(255) DEFAULT NULL,
  `social_security_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_personal_data`
--

LOCK TABLES `employee_personal_data` WRITE;
/*!40000 ALTER TABLE `employee_personal_data` DISABLE KEYS */;
INSERT INTO `employee_personal_data` VALUES ('123456789','Emily','FFN004','','Single','Grace','345678/04/04','','101 Pine St','Female','emily_photo.jpg','Johnson','Miss','City4',NULL),('2020010470','Jane','FFN002','Doe','Married','Ann','654321/02/02','','456 Elm St','Female','jane_photo.jpg','Smith','Mrs','City2',NULL),('2020010490','David','FFN003','','Single','','789012/03/03','','789 Oak St','Male','david_photo.jpg','Williams','Mr','City3',NULL),('EMP_898677','John','FFN001','','Single','Michael','123456/01/01','','123 Main St','Male','john_photo.jpg','Doe','Mr','City1',NULL),('EMP005','Michael','FFN005','','Divorced','James','901234/05/05','Blind','543 Maple St','Male','michael_photo.jpg','Brown','Mr','City5',NULL);
/*!40000 ALTER TABLE `employee_personal_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insurance`
--

DROP TABLE IF EXISTS `insurance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `insurance` (
  `insurance_type` varchar(255) NOT NULL,
  `percentage_contribution` double NOT NULL,
  `description` varchar(256) NOT NULL,
  PRIMARY KEY (`insurance_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insurance`
--

LOCK TABLES `insurance` WRITE;
/*!40000 ALTER TABLE `insurance` DISABLE KEYS */;
INSERT INTO `insurance` VALUES ('MADISON',0.5,'MADISON FUNERAL INSURANCE'),('NHIMA',1,'NHIMA MEDICAL INSURANCE');
/*!40000 ALTER TABLE `insurance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave_record`
--

DROP TABLE IF EXISTS `leave_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leave_record` (
  `id` int NOT NULL AUTO_INCREMENT,
  `employee_number` varchar(255) NOT NULL,
  `leave_type` enum('annual','vacation','local','study','unpaid','sick') DEFAULT NULL,
  `from_date` date DEFAULT NULL,
  `to_date` date DEFAULT NULL,
  `commuted` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_record`
--

LOCK TABLES `leave_record` WRITE;
/*!40000 ALTER TABLE `leave_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `leave_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave_records`
--

DROP TABLE IF EXISTS `leave_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leave_records` (
  `date_end` date NOT NULL,
  `date_start` date NOT NULL,
  `employee_id` varchar(255) NOT NULL,
  `commuted` int NOT NULL,
  `leave_type` tinyint DEFAULT NULL,
  PRIMARY KEY (`date_end`,`date_start`,`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_records`
--

LOCK TABLES `leave_records` WRITE;
/*!40000 ALTER TABLE `leave_records` DISABLE KEYS */;
/*!40000 ALTER TABLE `leave_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `other_deduction`
--

DROP TABLE IF EXISTS `other_deduction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `other_deduction` (
  `deduction_type` varchar(255) NOT NULL,
  `deduction_percentage` double NOT NULL,
  `description` varchar(256) NOT NULL,
  PRIMARY KEY (`deduction_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `other_deduction`
--

LOCK TABLES `other_deduction` WRITE;
/*!40000 ALTER TABLE `other_deduction` DISABLE KEYS */;
INSERT INTO `other_deduction` VALUES ('UNIONCONTRIBUTION',1,'UNION CONTRIBUTION');
/*!40000 ALTER TABLE `other_deduction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_as_you_earn_tax_bands`
--

DROP TABLE IF EXISTS `pay_as_you_earn_tax_bands`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pay_as_you_earn_tax_bands` (
  `band` int NOT NULL,
  `year` int NOT NULL,
  `percentage` double NOT NULL,
  `upper_bound` double NOT NULL,
  PRIMARY KEY (`band`,`year`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_as_you_earn_tax_bands`
--

LOCK TABLES `pay_as_you_earn_tax_bands` WRITE;
/*!40000 ALTER TABLE `pay_as_you_earn_tax_bands` DISABLE KEYS */;
INSERT INTO `pay_as_you_earn_tax_bands` VALUES (1,2024,0,5100),(2,2024,20,7100),(3,2024,30,9200),(4,2024,37,-99);
/*!40000 ALTER TABLE `pay_as_you_earn_tax_bands` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payee_tax_bands`
--

DROP TABLE IF EXISTS `payee_tax_bands`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payee_tax_bands` (
  `band_code` int NOT NULL,
  `year` int NOT NULL,
  `percentage` double NOT NULL,
  `upper_bound` double NOT NULL,
  `employee_number` varchar(255) NOT NULL,
  `payment_date` varchar(255) NOT NULL,
  PRIMARY KEY (`band_code`,`year`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payee_tax_bands`
--

LOCK TABLES `payee_tax_bands` WRITE;
/*!40000 ALTER TABLE `payee_tax_bands` DISABLE KEYS */;
INSERT INTO `payee_tax_bands` VALUES (1,2024,0,5100,'',''),(2,2024,20,7100,'','');
/*!40000 ALTER TABLE `payee_tax_bands` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `employee_number` varchar(255) NOT NULL,
  `payment_date` date NOT NULL,
  `amount` double NOT NULL,
  `reference` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_number`,`payment_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payroll`
--

DROP TABLE IF EXISTS `payroll`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payroll` (
  `employee_id` varchar(255) NOT NULL,
  `payment_date` varchar(255) NOT NULL,
  `basic_salary` double NOT NULL,
  `education_allowance` double NOT NULL,
  `fuel_allowance` double NOT NULL,
  `gross_pay` double NOT NULL,
  `gross_pay_year_to_date` double NOT NULL,
  `housing_allowance` double NOT NULL,
  `last_modified` date DEFAULT NULL,
  `napsa_year_to_date` double NOT NULL,
  `net_pay` double NOT NULL,
  `pension_year_to_date` double NOT NULL,
  `risk_allowance` double NOT NULL,
  `salary_arrears` double NOT NULL,
  `salary_rate` double NOT NULL,
  `tax_credit` double NOT NULL,
  `tax_due` double NOT NULL,
  `tax_paid_year_to_date` double NOT NULL,
  `taxable_gross` double NOT NULL,
  `total_deductions` double NOT NULL,
  `transport_allowance` double NOT NULL,
  PRIMARY KEY (`employee_id`,`payment_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payroll`
--

LOCK TABLES `payroll` WRITE;
/*!40000 ALTER TABLE `payroll` DISABLE KEYS */;
INSERT INTO `payroll` VALUES ('2020010470','May-29-2024',12000,0,0,12000,12000,0,'2024-05-29',0,9454,360,0,0,0,0,2066,2066,12000,2546,0),('EMP_898677','May-29-2024',10000,0,0,10000,10000,0,'2024-05-29',500,8074,0,0,0,0,0,1326,1326,10000,1926,0);
/*!40000 ALTER TABLE `payroll` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pension`
--

DROP TABLE IF EXISTS `pension`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pension` (
  `pension_type` varchar(255) NOT NULL,
  `employee_percentage` double NOT NULL,
  `employer_percentage` double NOT NULL,
  PRIMARY KEY (`pension_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pension`
--

LOCK TABLES `pension` WRITE;
/*!40000 ALTER TABLE `pension` DISABLE KEYS */;
INSERT INTO `pension` VALUES ('LASIV',3,2),('NAPSA',5,5);
/*!40000 ALTER TABLE `pension` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `positions`
--

DROP TABLE IF EXISTS `positions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `positions` (
  `position_id` int NOT NULL AUTO_INCREMENT,
  `department_id` int NOT NULL,
  `position` varchar(255) DEFAULT NULL,
  `salary_scale` varchar(255) DEFAULT NULL,
  `education_allowance` double NOT NULL,
  `fuel_allowance` double NOT NULL,
  `housing_allowance` double NOT NULL,
  `risk_allowance` double NOT NULL,
  `transport_allowance` double NOT NULL,
  PRIMARY KEY (`position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `positions`
--

LOCK TABLES `positions` WRITE;
/*!40000 ALTER TABLE `positions` DISABLE KEYS */;
INSERT INTO `positions` VALUES (1,16,'Town Clerk','LGSS01',0,0,0,0,0),(2,10,'Director Engineering Services','LGSS03',0,0,0,0,0),(3,10,'Assistant Director Engineering -Development','LGSS05',0,0,0,0,0),(4,10,'Assistant Director Engineering -Operations','LGSS05',0,0,0,0,0),(5,10,'Senior Quantity Surveyor','LGSS06',0,0,0,0,0),(6,10,'Quantity Surveyor','LGSS07',0,0,0,0,0),(7,10,'Assistant Quantity Surveyor','LGSS10',0,0,0,0,0),(8,10,'Chief Architect','LGSS06',0,0,0,0,0),(9,10,'Architect','LGSS07',0,0,0,0,0),(10,10,'Assistant Architect','LGSS10',0,0,0,0,0),(11,10,'Draughtsman','LGSS15',0,0,0,0,0),(12,10,'Buildings Manager','LGSS10',0,0,0,0,0),(13,10,'Superintendent','LGSS12',0,0,0,0,0),(14,10,'Assistant Superintendent','LGSS12',0,0,0,0,0),(15,10,'Works Supervisor','LGSS14',0,0,0,0,0),(16,10,'Plumber','LGSS15',0,0,0,0,0),(17,10,'Bricklayer','LGSS15',0,0,0,0,0),(18,10,'Carpenter','LGSS15',0,0,0,0,0),(19,10,'Painter','LGSS15',0,0,0,0,0),(20,10,'General Workers','G3',0,0,0,0,0),(21,10,'Parks and Gardens Manager','LGSS07',0,0,0,0,0),(22,10,'Superintendent','LGSS12',0,0,0,0,0),(23,10,'Assistant Superintendent','LGSS13',0,0,0,0,0),(24,10,'Parks Foreman','LGSS14',0,0,0,0,0),(25,10,'Parks Supervisor','LGSS15',0,0,0,0,0),(26,10,'Assistant Parks Foreman','LGSS17',0,0,0,0,0),(27,10,'General Worker','G1',0,0,0,0,0),(28,10,'Assistant Director Engineering Service - Operations','LGSS05',0,0,0,0,0),(29,10,'Senior Electrical Engineer','LGSS06',0,0,0,0,0),(30,10,'Electrical Engineer','LGSS06',0,0,0,0,0),(31,10,'Assistant Electrical Engineer','LGSS10',0,0,0,0,0),(32,10,'Superintendent','LGSS12',0,0,0,0,0),(33,10,'Foreman','LGSS14',0,0,0,0,0),(34,10,'Works Supervisor','LGSS14',0,0,0,0,0),(35,10,'Electrician','LGSS14',0,0,0,0,0),(36,10,'Assistant Foreman','LGSS17',0,0,0,0,0),(37,10,'Mechanical Engineer','LGSS06',0,0,0,0,0),(38,10,'Assistant Mechanical Engineer','LGSS10',0,0,0,0,0),(39,10,'Superintendent','LGSS12',0,0,0,0,0),(40,10,'Assistant Superintendent','LGSS13',0,0,0,0,0),(41,10,'Auto Electrician','LGSS14',0,0,0,0,0),(42,10,'Mechanic','LGSS14',0,0,0,0,0),(43,10,'Foreman','LGSS14',0,0,0,0,0),(44,10,'Plant Operator','LGSS14',0,0,0,0,0),(45,10,'Mechanical Handyman','LGSS18',0,0,0,0,0),(46,10,'Welder','LGSS14',0,0,0,0,0),(47,10,'Tyre mender','LGSS18',0,0,0,0,0),(48,10,'General Workers','G1',0,0,0,0,0),(49,10,'Chief Fire Officer','LGSS05',0,0,0,0,0),(50,10,'Deputy Chief Fire Officer','LGSS06',0,0,0,0,0),(51,10,'Divisional Fire Officer','LGSS09',0,0,0,0,0),(52,10,'Assistant Divisional Fire Officer','LGSS10',0,0,0,0,0),(53,10,'Station Fire Officer','LGSS11',0,0,0,0,0),(54,10,'Sub-Officer','LGSS12',0,0,0,0,0),(55,10,'Leading Fire-fighter','LGSS13',0,0,0,0,0),(56,10,'Fire Fighter','LGSS14',0,0,0,0,0),(57,10,'Fire Fighter Driver','LGSS14',0,0,0,0,0),(58,10,'General Workers','G1',0,0,0,0,0),(59,10,'Civil Engineer','LGSS06',0,0,0,0,0),(60,10,'Assistant Civil Engineer','LGSS10',0,0,0,0,0),(61,10,'Superintendent - Highway','LGSS12',0,0,0,0,0),(62,10,'Senior Engineering Assistant','LGSS13',0,0,0,0,0),(63,10,'Assistant Superintendent - Highway','LGSS13',0,0,0,0,0),(64,10,'Engineering Assistant-Roads','LGSS14',0,0,0,0,0),(65,10,'Foreman','LGSS14',0,0,0,0,0),(66,10,'General Workers','G3',0,0,0,0,0),(67,9,'Director  City Planning','LGSS03',0,0,0,0,0),(68,9,'Assistant Director - Forward Planning','LGSS05',0,0,0,0,0),(69,9,'Assistant Director – Development Control','LGSS05',0,0,0,0,0),(70,9,'Assistant Director – Local Economic Planning ( current District Planning Officer)','LGSS05',0,0,0,0,0),(71,9,'Town Planner','LGSS07',0,0,0,0,0),(72,9,'Assistant Town Planner','LGSS10',0,0,0,0,0),(73,9,'Senior Land Surveyor','LGSS07',0,0,0,0,0),(74,9,'Land Surveyors','LGSS08',0,0,0,0,0),(75,9,'Assistant Land Surveyor','LGSS10',0,0,0,0,0),(76,9,'General Workers attached to Survey Section','G3',0,0,0,0,0),(77,9,'Chief Building Inspector','LGSS06',0,0,0,0,0),(78,9,'Senior Building Inspector','LGSS07',0,0,0,0,0),(79,9,'Building Inspector','LGSS10',0,0,0,0,0),(80,9,'Socio-economic Planner','LGSS05',0,0,0,0,0),(81,9,'Environmental Planner','LGSS07',0,0,0,0,0),(82,9,'Monitoring & Evaluation Officer','LGSS07',0,0,0,0,0),(83,11,'Director of Public Health','LGSS03',0,0,0,0,0),(84,11,'Assistant Director of Public Health','LGSS05',0,0,0,0,0),(85,11,'Chief Health Inspector','LGSS06',0,0,0,0,0),(86,11,'Senior Health inspector','LGSS07',0,0,0,0,0),(87,11,'Health Inspector','LGSS08',0,0,0,0,0),(88,11,'Health promotion officer','LGSS08',0,0,0,0,0),(89,11,'Senior Health Inspection Officer','LGSS07',0,0,0,0,0),(90,11,'Senior Health Education Officer','LGSS07',0,0,0,0,0),(91,11,'Health Inspector','LGSS08',0,0,0,0,0),(92,11,'Cleansing Manager','LGSS07',0,0,0,0,0),(93,11,'Senior Environmental Health Technologist','LGSS07',0,0,0,0,0),(94,11,'Cleansing Superintendent','LGSS08',0,0,0,0,0),(95,11,'Funeral Superintendent','LGSS08',0,0,0,0,0),(96,11,'Assistant Cleansing Superintendent','LGSS09',0,0,0,0,0),(97,11,'Pest Control Superintendent','LGSS08',0,0,0,0,0),(98,11,'Assistant Pest Control Superintendent','LGSS09',0,0,0,0,0),(99,11,'Health Promotions Officer','LGSS08',0,0,0,0,0),(100,11,'Pest Control Superintendent','LGSS08',0,0,0,0,0),(101,11,'Assistant Pest Control Superintendent','LGSS09',0,0,0,0,0),(102,7,'Assistant Director- Valuation and Taxation','LGSS05',0,0,0,0,0),(103,7,'Senior Valuation Officer- Valuation and Taxation','LGSS06',0,0,0,0,0),(104,7,'Valuation Officer- Valuation and Taxation','LGSS07',0,0,0,0,0),(105,7,'Assistant Valuation Officer- Valuation and Taxation','LGSS10',0,0,0,0,0),(106,7,'Assistant Director- Real Estate management and Development','LGSS04',0,0,0,0,0),(107,7,'Senior Valuation Officer- Real Estate management and Development','LGSS06',0,0,0,0,0),(108,7,'Valuation Officer- Real Estate','LGSS13',0,0,0,0,0);
/*!40000 ALTER TABLE `positions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary_notch`
--

DROP TABLE IF EXISTS `salary_notch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salary_notch` (
  `salary_scale` varchar(255) NOT NULL,
  `basic_salary` double NOT NULL,
  `date_from` date DEFAULT NULL,
  `date_to` date DEFAULT NULL,
  `salary_notch` varchar(16) NOT NULL,
  `date_started` date DEFAULT NULL,
  PRIMARY KEY (`salary_scale`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary_notch`
--

LOCK TABLES `salary_notch` WRITE;
/*!40000 ALTER TABLE `salary_notch` DISABLE KEYS */;
INSERT INTO `salary_notch` VALUES ('LGSS03',12000,'2024-04-01',NULL,'',NULL),('LGSS15',10000,NULL,NULL,'',NULL);
/*!40000 ALTER TABLE `salary_notch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary_scales`
--

DROP TABLE IF EXISTS `salary_scales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salary_scales` (
  `salary_scale` varchar(12) NOT NULL,
  `division` varchar(128) DEFAULT NULL,
  `description` varchar(128) NOT NULL,
  PRIMARY KEY (`salary_scale`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary_scales`
--

LOCK TABLES `salary_scales` WRITE;
/*!40000 ALTER TABLE `salary_scales` DISABLE KEYS */;
INSERT INTO `salary_scales` VALUES ('G1','Division 4','Wages'),('G2','Division 4','Wages'),('G3','Division 4','Wages'),('LGSS01','Division 1','Management'),('LGSS02','Division 1','Management'),('LGSS03','Division 1','Management'),('LGSS04','Division 1','Management'),('LGSS05','Division 1','Management'),('LGSS06','Division 1','Management'),('LGSS07','Division 1','Management'),('LGSS08','Division 2','Salaries'),('LGSS09','Division 2','Salaries'),('LGSS10','Division 2','Salaries'),('LGSS11','Division 2','Salaries'),('LGSS12','Division 2','Salaries'),('LGSS13','Division 3','Salaries'),('LGSS14','Division 3','Salaries'),('LGSS15','Division 3','Salaries'),('LGSS16','Division 3','Salaries'),('LGSS17','Division 3','Salaries'),('LGSS18','Division 3','Salaries');
/*!40000 ALTER TABLE `salary_scales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `section`
--

DROP TABLE IF EXISTS `section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `section` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `department_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `core_departmentalpos_department_id_2d1865b8_fk_core_depa` (`department_id`),
  CONSTRAINT `core_departmentalpos_department_id_2d1865b8_fk_core_depa` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section`
--

LOCK TABLES `section` WRITE;
/*!40000 ALTER TABLE `section` DISABLE KEYS */;
INSERT INTO `section` VALUES (1,'IT MANAGER',15),(2,'DIRECTOR OF FINANCE',3),(3,'Council Officer',4);
/*!40000 ALTER TABLE `section` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-29 11:58:31
