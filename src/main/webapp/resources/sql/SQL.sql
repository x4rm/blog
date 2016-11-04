-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.7.11-log - MySQL Community Server (GPL)
-- ОС Сервера:                   Win32
-- HeidiSQL Версия:              9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры базы данных blog
CREATE DATABASE IF NOT EXISTS `blog` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `blog`;


-- Дамп структуры для таблица blog.message
CREATE TABLE IF NOT EXISTS `message` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) NOT NULL,
  `TEXT` varchar(250) DEFAULT NULL,
  `DATE` date DEFAULT NULL,
  `TIME` time DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK__user` (`USER_ID`),
  CONSTRAINT `FK__user` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы blog.message: ~6 rows (приблизительно)
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` (`ID`, `USER_ID`, `TEXT`, `DATE`, `TIME`) VALUES
	(1, 1, 'Nullam quis risus eget urna mollis ornare vel eu leo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', '2016-04-06', '15:07:44'),
	(2, 1, 'Nullam quis risus eget urna mollis ornare vel eu leo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', '2016-04-06', '15:08:54'),
	(3, 1, 'Nullam quis risus eget urna mollis ornare vel eu leo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', '2016-04-06', '15:10:02'),
	(4, 2, 'Nullam quis risus eget urna mollis ornare vel eu leo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', '2016-04-06', '15:10:40'),
	(5, 3, 'Nullam quis risus eget urna mollis ornare vel eu leo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', '2016-04-06', '15:10:54'),
	(6, 3, 'Nullam quis risus eget urna mollis ornare vel eu leo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', '2016-04-06', '15:11:11');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;


-- Дамп структуры для таблица blog.user
CREATE TABLE IF NOT EXISTS `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LOGIN` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  `NAME` varchar(50) DEFAULT NULL,
  `AGE` int(11) unsigned DEFAULT NULL,
  `GENDER` int(10) unsigned DEFAULT NULL,
  `CITY` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы blog.user: ~3 rows (приблизительно)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`ID`, `LOGIN`, `PASSWORD`, `NAME`, `AGE`, `GENDER`, `CITY`) VALUES
	(1, 'lilith', '123', 'Lilith Dworph', 27, 0, 'New York'),
	(2, 'rel', '123', 'Re-l Mayer', 19, 0, 'Montana'),
	(3, 'vinc', '123', 'Vincent Law', 28, 1, 'Atlanta');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
