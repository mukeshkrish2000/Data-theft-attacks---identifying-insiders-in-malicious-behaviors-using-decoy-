/*
SQLyog - Free MySQL GUI v5.13
Host - 5.0.22-community-nt : Database - filesecuritydecoy
*********************************************************************
Server version : 5.0.22-community-nt
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `filesecuritydecoy`;

USE `filesecuritydecoy`;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `storage` */

DROP TABLE IF EXISTS `storage`;

CREATE TABLE `storage` (
  `filename` varchar(300) default NULL,
  `username` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `storage` */

insert into `storage` (`filename`,`username`) values ('lib srceens.docx','selva');
insert into `storage` (`filename`,`username`) values ('lib srceensb.docx','selva');
insert into `storage` (`filename`,`username`) values ('lib srceens11.docx','selva');
insert into `storage` (`filename`,`username`) values ('lib srceensa.docx','selva');
insert into `storage` (`filename`,`username`) values ('lib srceens1.docx','selva');

/*Table structure for table `uploadlist` */

DROP TABLE IF EXISTS `uploadlist`;

CREATE TABLE `uploadlist` (
  `fileid` int(50) NOT NULL auto_increment,
  `ownername` varchar(50) default NULL,
  `filename` varchar(200) default NULL,
  `key1` varchar(100) default NULL,
  PRIMARY KEY  (`fileid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `uploadlist` */

insert into `uploadlist` (`fileid`,`ownername`,`filename`,`key1`) values (6,'selva','lib srceens.docx','14856228');

/*Table structure for table `userdetails` */

DROP TABLE IF EXISTS `userdetails`;

CREATE TABLE `userdetails` (
  `fullname` varchar(50) default NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) default NULL,
  `profession` varchar(50) default NULL,
  `mobile` varchar(50) default NULL,
  `emailid` varchar(50) default NULL,
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `userdetails` */

insert into `userdetails` (`fullname`,`username`,`password`,`profession`,`mobile`,`emailid`) values ('Selva Kumar','selva','9a31276d8k','Student','9750999918','dselvait@gmail.com');

SET SQL_MODE=@OLD_SQL_MODE;