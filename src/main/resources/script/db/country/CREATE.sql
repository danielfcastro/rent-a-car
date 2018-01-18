/*
SQLyog Community v12.11 (64 bit)
MySQL - 5.5.3-m3-log : Database - daniel
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`daniel` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `daniel`;

/*Table structure for table `Address` */

DROP TABLE IF EXISTS `Address`;

CREATE TABLE `Address` (
  `id` char(36) NOT NULL,
  `city` varchar(45) NOT NULL,
  `complement` varchar(45) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `streetName` varchar(45) NOT NULL,
  `typeSite` varchar(45) NOT NULL,
  `zipcode` varchar(45) NOT NULL,
  `addressType` int(11) DEFAULT NULL,
  `countryId` int(11) NOT NULL,
  `customerId` int(11) DEFAULT NULL,
  `employeeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6j2wwux740a54388a3ipr1tpa` (`addressType`),
  KEY `FK_cgtdfi1ttljssrtd27xxa3no7` (`countryId`),
  KEY `FK_jo2vndqkr3qi82fxymui4b7of` (`customerId`),
  KEY `FK_862jiegfcc1wry00m36ulqfbl` (`employeeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `Address` */

/*Table structure for table `AddressType` */

DROP TABLE IF EXISTS `AddressType`;

CREATE TABLE `AddressType` (
  `id` char(36) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `AddressType` */

/*Table structure for table `Agency` */

DROP TABLE IF EXISTS `Agency`;

CREATE TABLE `Agency` (
  `id` char(36) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `Agency` */

/*Table structure for table `Branch` */

DROP TABLE IF EXISTS `Branch`;

CREATE TABLE `Branch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `agencyId` char(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ltp2t64oaf7vvo9tyxqa6sy57` (`agencyId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `Branch` */

/*Table structure for table `BrandType` */

DROP TABLE IF EXISTS `BrandType`;

CREATE TABLE `BrandType` (
  `id` char(36) NOT NULL,
  `brand` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `BrandType` */

/*Table structure for table `City` */

DROP TABLE IF EXISTS `City`;

CREATE TABLE `City` (
  `id` char(36) NOT NULL,
  `countryId` char(36) DEFAULT NULL,
  `latitude` decimal(10,8) DEFAULT NULL,
  `longitude` decimal(10,8) DEFAULT NULL,
  `name` varchar(120) NOT NULL,
  `zipCode` int(11) DEFAULT NULL,
  `stateId` char(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tr4eopukpxbiked4okmvk3txd` (`stateId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `City` */

/*Table structure for table `CityGeoLoc` */

DROP TABLE IF EXISTS `CityGeoLoc`;

CREATE TABLE `CityGeoLoc` (
  `id` char(36) NOT NULL,
  `zipCode` int(11) NOT NULL,
  `county` varchar(50) DEFAULT NULL,
  `latitude` decimal(10,8) NOT NULL,
  `longitude` decimal(10,8) NOT NULL,
  PRIMARY KEY (`id`,`zipCode`),
  UNIQUE KEY `UK_oxfepl8yjyg5pmoeqm9f0scsh` (`id`),
  UNIQUE KEY `UK_mhraqo3ycah8cyvcyumlepg5q` (`zipCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `CityGeoLoc` */

/*Table structure for table `Country` */

DROP TABLE IF EXISTS `Country`;

CREATE TABLE `Country` (
  `id` char(36) NOT NULL,
  `iso` varchar(2) NOT NULL,
  `iso3` varchar(3) DEFAULT NULL,
  `name` varchar(80) NOT NULL,
  `nicename` varchar(80) NOT NULL,
  `numcode` smallint(6) DEFAULT NULL,
  `phonecode` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `Country` */

/*Table structure for table `Customer` */

DROP TABLE IF EXISTS `Customer`;

CREATE TABLE `Customer` (
  `id` char(36) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `identificationDocument` varchar(45) DEFAULT NULL,
  `identiicationType` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) NOT NULL,
  `middleName` varchar(45) DEFAULT NULL,
  `passportNumber` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `Customer` */

/*Table structure for table `Employee` */

DROP TABLE IF EXISTS `Employee`;

CREATE TABLE `Employee` (
  `id` char(36) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `flagManager` bit(1) NOT NULL,
  `identificationDocument` varchar(45) NOT NULL,
  `identificationtYPE` varchar(45) NOT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `middleName` varchar(45) DEFAULT NULL,
  `managerId` char(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_o7j4fbxohco6cmqjm7dnc5bb5` (`managerId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `Employee` */

/*Table structure for table `FuelType` */

DROP TABLE IF EXISTS `FuelType`;

CREATE TABLE `FuelType` (
  `id` char(36) NOT NULL,
  `fuel` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `FuelType` */

/*Table structure for table `ModelType` */

DROP TABLE IF EXISTS `ModelType`;

CREATE TABLE `ModelType` (
  `id` char(36) DEFAULT NULL,
  `model` varchar(135) DEFAULT NULL,
  `idBrand` char(36) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `ModelType` */

/*Table structure for table `Rent` */

DROP TABLE IF EXISTS `Rent`;

CREATE TABLE `Rent` (
  `id` char(36) NOT NULL,
  `dailyRentFee` int(11) NOT NULL,
  `downPayment` int(11) NOT NULL,
  `fuelCharge` int(11) NOT NULL,
  `plateNumber` varchar(30) NOT NULL,
  `refund` int(11) NOT NULL,
  `rentDate` date NOT NULL,
  `returnDate` date NOT NULL,
  `totalPaid` int(11) NOT NULL,
  `totalRentDays` int(11) NOT NULL,
  `customerId` char(36) NOT NULL,
  `employeeId` char(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_nbh1mwuod1r7ufvy4lbjm3c93` (`customerId`),
  KEY `FK_87qv8ufw8brfm5qciy2mkgedy` (`employeeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `Rent` */

/*Table structure for table `Reservation` */

DROP TABLE IF EXISTS `Reservation`;

CREATE TABLE `Reservation` (
  `id` char(36) NOT NULL,
  `pickupDate` date NOT NULL,
  `plateNumber` varchar(30) NOT NULL,
  `reservationDate` date NOT NULL,
  `returnDate` date NOT NULL,
  `agencyId` char(36) DEFAULT NULL,
  `customerId` char(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_f3qu3by6l2lrdwkwegi3hnf04` (`agencyId`),
  KEY `FK_g9tfkv5rsmec1tg32ak2iwuui` (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `Reservation` */

/*Table structure for table `SiteType` */

DROP TABLE IF EXISTS `SiteType`;

CREATE TABLE `SiteType` (
  `id` char(36) NOT NULL,
  `abbreviation` varchar(8) NOT NULL,
  `site` varchar(45) NOT NULL,
  `countryId` char(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_qq9g5kx123gsdvjqt332d5cl` (`countryId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `SiteType` */

/*Table structure for table `State` */

DROP TABLE IF EXISTS `State`;

CREATE TABLE `State` (
  `id` char(36) NOT NULL,
  `fu` varchar(2) NOT NULL,
  `name` varchar(45) NOT NULL,
  `countryId` char(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pv8ji4rpgtqjdssa92btgio9o` (`countryId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `State` */

/*Table structure for table `Telephone` */

DROP TABLE IF EXISTS `Telephone`;

CREATE TABLE `Telephone` (
  `id` char(36) NOT NULL,
  `telephoneNumber` decimal(10,0) DEFAULT NULL,
  `customerId` char(36) DEFAULT NULL,
  `employeeId` char(36) DEFAULT NULL,
  `idTelephoneType` char(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_disfepbjdadg23eplo21e1us6` (`customerId`),
  KEY `FK_eoxuvkxbdfsqlhidut5bdso08` (`employeeId`),
  KEY `FK_ln8v43lby46rsr7ag753d6ic7` (`idTelephoneType`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `Telephone` */

/*Table structure for table `TelephoneType` */

DROP TABLE IF EXISTS `TelephoneType`;

CREATE TABLE `TelephoneType` (
  `id` char(36) NOT NULL,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `TelephoneType` */

/*Table structure for table `Vehicle` */

DROP TABLE IF EXISTS `Vehicle`;

CREATE TABLE `Vehicle` (
  `id` char(36) NOT NULL,
  `conditionId` char(36) NOT NULL,
  `dailyPrice` int(11) NOT NULL,
  `luggageSpaceVolume` int(11) DEFAULT NULL,
  `plateNumber` varchar(30) NOT NULL,
  `seatQuantity` int(11) NOT NULL,
  `branchId` char(36) DEFAULT NULL,
  `brandId` char(36) NOT NULL,
  `fuelId` char(36) NOT NULL,
  `modelId` char(36) NOT NULL,
  `vehicleTypeId` char(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_r0des9jmomtcs2434dht4jkdt` (`branchId`),
  KEY `FK_ayt2oes6qbspbpc599wf8tynk` (`brandId`),
  KEY `FK_cgpaw8tekowggh8mtt7b2b404` (`fuelId`),
  KEY `FK_25puu11t664hflkpfp4gnd6mj` (`modelId`),
  KEY `FK_gc0cgtv01hvomdl8hvtysedbm` (`vehicleTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `Vehicle` */

/*Table structure for table `VehicleAccessories` */

DROP TABLE IF EXISTS `VehicleAccessories`;

CREATE TABLE `VehicleAccessories` (
  `id` char(36) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `VehicleAccessories` */

/*Table structure for table `VehicleCategory` */

DROP TABLE IF EXISTS `VehicleCategory`;

CREATE TABLE `VehicleCategory` (
  `id` char(36) NOT NULL,
  `averageLuggageQuantity` int(11) DEFAULT NULL,
  `name` varchar(45) NOT NULL,
  `seatNumbers` int(11) DEFAULT NULL,
  `idVehicleType` char(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_67w10l6bd85kguktj77nsco81` (`idVehicleType`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `VehicleCategory` */

/*Table structure for table `VehicleType` */

DROP TABLE IF EXISTS `VehicleType`;

CREATE TABLE `VehicleType` (
  `id` char(36) NOT NULL,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `VehicleType` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
