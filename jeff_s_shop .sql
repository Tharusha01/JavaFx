-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 05, 2019 at 11:23 AM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jeff's_shop`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_name` varchar(50) NOT NULL,
  `admin_email` varchar(100) NOT NULL,
  `admin_password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_name`, `admin_email`, `admin_password`) VALUES
('0', 'admin@jfs.com', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `email_enquirers`
--

CREATE TABLE `email_enquirers` (
  `user_email` varchar(60) NOT NULL,
  `message` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `email_enquirers`
--

INSERT INTO `email_enquirers` (`user_email`, `message`) VALUES
('tharusha26@gmail.com', 'transaction error.');

-- --------------------------------------------------------

--
-- Table structure for table `staff_registration`
--

CREATE TABLE `staff_registration` (
  `staff_id` int(5) NOT NULL,
  `staff_name` varchar(50) NOT NULL,
  `staff_email` varchar(100) NOT NULL,
  `staff_password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff_registration`
--

INSERT INTO `staff_registration` (`staff_id`, `staff_name`, `staff_email`, `staff_password`) VALUES
(3, 'staff', 'staff@jfs.com', 'staff'),
(4, 'staff1', 'staff1@jfs.com', 'staffstaff');

-- --------------------------------------------------------

--
-- Table structure for table `subscribe_newsletters`
--

CREATE TABLE `subscribe_newsletters` (
  `user_email` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `date` date NOT NULL,
  `customer_mail` varchar(60) NOT NULL,
  `product_details` varchar(1000) NOT NULL,
  `total_price` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`date`, `customer_mail`, `product_details`, `total_price`) VALUES
('2018-08-04', 'tharushaishan26@gmail.com', '\n	FH			  Fish Hooks			  #1			5		 5			 25$\n	FL			  Fishing Line			  300m		300		 6			 1800$\n	RO			  Fishing Rod			  2m			80		 4			 320$', 2145),
('2018-08-04', 'tharushaishan26@gmail.com', '\n	FH			  Fish Hooks			  #1			5		 6			 30$\n	FL			  Fishing Line			  300m		300		 4			 1200$\n	FR			  Fishing Reel			  2m			300		 3			 300$', 1530),
('2018-08-05', 'tharushaishan26@gmail.com', '\n	FH			  Fish Hooks			  #3			15		 6			 90$\n	FL			  Fishing Line			  300m		300		 4			 1200$\n	FR			  Fishing Reel			  2m			300		 8			 800$', 2090),
('2018-08-05', 'tharushaishan26@gmail.com', '\n	FH			  Fish Hooks			  #1			5		 6			 30$\n	FL			  Fishing Line			  300m		300		 7			 2100$\n	FR			  Fishing Reel			  3m			300		 6			 900$', 3030),
('2018-08-05', 'tharushaishan26@gmail.com', '\n	FH			  Fish Hooks			  #3			15		 6			 90$', 90),
('2018-08-05', 'tharushaishan26@gmail.com', '\n	FH			  Fish Hooks			  #1			5		 6			 30$', 30),
('2018-08-05', 'tharushaishan26@gmail.com', '\n	FH			  Fish Hooks			  #1			5		 16			 80$\n	FR			  Fishing Reel			  1m			100		 8			 400$', 480),
('2018-08-05', 'tharushaishan26@gmail.com', '\n	FH			  Fish Hooks			  #1			5		 6			 30$\n	FL			  Fishing Line			  300m		300		 6			 1800$', 1830);

-- --------------------------------------------------------

--
-- Table structure for table `user_registration`
--

CREATE TABLE `user_registration` (
  `user_name` varchar(60) NOT NULL,
  `user_email` varchar(100) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `user_address` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_registration`
--

INSERT INTO `user_registration` (`user_name`, `user_email`, `user_password`, `user_address`) VALUES
('', 'tha', '123', ''),
('tharusha', 'tharusha@gmail.com', 'nishtharusha', 'asd'),
('tharusha', 'tharushaishan26@gmail.com', 'nishtharusha', '829, kottawa, pannipitiya');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `email_enquirers`
--
ALTER TABLE `email_enquirers`
  ADD PRIMARY KEY (`user_email`);

--
-- Indexes for table `staff_registration`
--
ALTER TABLE `staff_registration`
  ADD PRIMARY KEY (`staff_id`);

--
-- Indexes for table `user_registration`
--
ALTER TABLE `user_registration`
  ADD PRIMARY KEY (`user_email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `staff_registration`
--
ALTER TABLE `staff_registration`
  MODIFY `staff_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
