-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 01, 2015 at 11:25 PM
-- Server version: 5.5.43-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `final_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE IF NOT EXISTS `book` (
  `book_ISBN` varchar(13) NOT NULL,
  `course_ID` varchar(5) NOT NULL DEFAULT '',
  `section_ID` varchar(5) NOT NULL DEFAULT '',
  `author_ID` varchar(5) DEFAULT NULL,
  `publisher_ID` varchar(5) DEFAULT NULL,
  `book_title` varchar(25) DEFAULT NULL,
  `book_edition` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`book_ISBN`,`course_ID`,`section_ID`),
  KEY `section_ID` (`section_ID`,`course_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`book_ISBN`, `course_ID`, `section_ID`, `author_ID`, `publisher_ID`, `book_title`, `book_edition`) VALUES
('1556738637213', '5', '2', '95495', '360', 'book 17', 1),
('2147547936882', '9', '3', '16627', '651', 'book 6', 1),
('2604031748611', '9', '2', '83491', '853', 'book 5', 1),
('2684066420955', '5', '3', '84989', '579', 'book 18', 1),
('2684TEST20955', '5', '3', '2345', '321', 'book TEST', 6),
('3046083119026', '4', '2', '28386', '675', 'book 20', 10),
('3937891737226', '10', '2', '21076', '221', 'book 2', 2),
('4266657508345', '5', '1', '93803', '995', 'book 16', 5),
('4371795125991', '9', '1', '65275', '473', 'book 4', 5),
('4442795005347', '8', '2', '49697', '332', 'book 8', 2),
('5723670840219', '6', '4', '34026', '133', 'book 14', 6),
('5854407542185', '6', '5', '20603', '696', 'book 15', 11),
('6748330614543', '10', '3', '63284', '742', 'book 3', 7),
('6766315936511', '7', '1', '48312', '316', 'book 9', 13),
('7341035798118', '6', '2', '50421', '292', 'book 12', 5),
('7752683195482', '4', '1', '28764', '259', 'book 19', 12),
('8127151217721', '6', '1', '19932', '534', 'book 11', 15),
('8260153682719', '10', '1', '56429', '863', 'book 1', 11),
('8696378898905', '8', '1', '17029', '814', 'book 7', 3),
('9609080375613', '7', '2', '15291', '487', 'book 10', 7),
('9813307803281', '6', '3', '30450', '481', 'book 13', 6),
('TESTBOOKX', '1', '1', '2345', '3415', 'TESTBOOKX', 1);

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE IF NOT EXISTS `course` (
  `course_ID` varchar(5) NOT NULL,
  `course_name` varchar(25) NOT NULL,
  PRIMARY KEY (`course_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`course_ID`, `course_name`) VALUES
('1', 'soft dev 1'),
('10', 'boob ogling'),
('11', 'un water weave'),
('2', 'soft dev 2'),
('3', 'adv data dev'),
('4', 'comp 1'),
('5', 'comp 2'),
('6', 'am lit 1'),
('7', 'am lit 2'),
('8', 'brit lit 1'),
('9', 'brit lit 2');

-- --------------------------------------------------------

--
-- Table structure for table `instructor`
--

CREATE TABLE IF NOT EXISTS `instructor` (
  `instructor_ID` varchar(10) NOT NULL,
  `instructor_PW` varchar(15) NOT NULL,
  `instructor_name` varchar(15) NOT NULL,
  `instructor_admin` char(1) DEFAULT NULL,
  PRIMARY KEY (`instructor_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `instructor`
--

INSERT INTO `instructor` (`instructor_ID`, `instructor_PW`, `instructor_name`, `instructor_admin`) VALUES
('1', 'boobs', 'ben franklin', '1'),
('10', 'boobs', 'french stewart', '0'),
('2', 'boobs', 'dirk diggler', '1'),
('3', 'boobs', 'jon west', '1'),
('4', 'boobs', 'chris novaselic', '1'),
('5', 'boobs', 'dave grohl', '1'),
('6', 'boobs', 'pablo picasso', '0'),
('7', 'boobs', 'bryan pittard', '0'),
('8', 'boobs', 'susan smith', '0'),
('9', 'boobs', 'betty crocker', '0');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE IF NOT EXISTS `order` (
  `order_ID` int(11) NOT NULL AUTO_INCREMENT,
  `course_ID` varchar(13) NOT NULL,
  `section_ID` varchar(13) NOT NULL,
  `order_enroll` int(11) NOT NULL,
  `order_approve_date` varchar(15) DEFAULT NULL,
  `order_submit_date` varchar(15) DEFAULT NULL,
  `order_required` tinyint(4) DEFAULT NULL,
  `order_reccomended` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`order_ID`),
  UNIQUE KEY `order_ID` (`order_ID`),
  KEY `section_ID` (`section_ID`,`course_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`order_ID`, `course_ID`, `section_ID`, `order_enroll`, `order_approve_date`, `order_submit_date`, `order_required`, `order_reccomended`) VALUES
(1, '10', '1', 43, '05/20/2009', '05/21/2009', 1, 1),
(2, '10', '2', 24, '07/14/2006', '07/21/2006', 1, 1),
(3, '10', '3', 13, '08/05/2015', '08/10/2015', 0, 1),
(4, '4', '1', 75, '04/05/2015', '04/20/2015', 0, 1),
(6, '5', '2', 32, 'TEST', 'TEST', 1, 0),
(8, '5', '3', 16, 'TESTDATA', 'TESTDATA', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `section`
--

CREATE TABLE IF NOT EXISTS `section` (
  `course_ID` varchar(5) NOT NULL,
  `section_ID` varchar(5) NOT NULL,
  `instructor_ID` varchar(10) NOT NULL,
  PRIMARY KEY (`section_ID`,`course_ID`),
  KEY `course_ID` (`course_ID`),
  KEY `instructor_ID` (`instructor_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `section`
--

INSERT INTO `section` (`course_ID`, `section_ID`, `instructor_ID`) VALUES
('4', '1', '1'),
('6', '3', '1'),
('9', '3', '1'),
('1', '4', '1'),
('1', '1', '10'),
('10', '2', '10'),
('8', '1', '2'),
('5', '2', '2'),
('6', '2', '2'),
('5', '1', '3'),
('8', '2', '3'),
('6', '4', '3'),
('6', '1', '4'),
('7', '1', '4'),
('5', '3', '4'),
('4', '2', '5'),
('7', '2', '5'),
('1', '3', '5'),
('6', '5', '5'),
('9', '2', '6'),
('9', '1', '7'),
('1', '2', '8'),
('10', '3', '8'),
('10', '1', '9'),
('1', '5', '9');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `book_ibfk_1` FOREIGN KEY (`section_ID`, `course_ID`) REFERENCES `section` (`section_ID`, `course_ID`);

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `order_ibfk_1` FOREIGN KEY (`section_ID`, `course_ID`) REFERENCES `section` (`section_ID`, `course_ID`);

--
-- Constraints for table `section`
--
ALTER TABLE `section`
  ADD CONSTRAINT `section_ibfk_1` FOREIGN KEY (`course_ID`) REFERENCES `course` (`course_ID`),
  ADD CONSTRAINT `section_ibfk_2` FOREIGN KEY (`instructor_ID`) REFERENCES `instructor` (`instructor_ID`),
  ADD CONSTRAINT `section_ibfk_3` FOREIGN KEY (`section_ID`) REFERENCES `book` (`section_ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
