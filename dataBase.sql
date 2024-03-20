-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 05, 2024 at 03:57 PM
-- Server version: 8.0.31
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlytaikhoan`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(255) NOT NULL,
  `description` text,
  `isDelete` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`Id`, `categoryName`, `description`, `isDelete`) VALUES
(1, 'Laptop', 'Cấu hình cao', 0),
(3, 'Điện thoại', 'Xaiomi', 0),
(4, 'Bàn Là', 'Xaiomi', 1),
(5, 'bàn ủi', 'cực khỏe', 1),
(6, 'Xà phòng', 'cực khỏe', 1),
(7, 'PC', 'PC cấu hình cao', 0),
(8, 'Ipad', 'Apple', 0),
(9, 'Màn hình', 'QUá là đẳng cấp', 1),
(10, 'bàn phím cơ', 'hiện đại', 0),
(11, 'Bàn Phím Vip', 'xịn nhất vịnh nam bộ', 1),
(12, 'Binh ngu', 'Đẹp trai', 1),
(13, 'Bàn Phím Vip', 'xịn nhất vịnh nam bộ', 0),
(14, 'Bàn Phím Vip', 'xịn nhất vịnh nam bộ', 1);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customerName` varchar(255) NOT NULL,
  `address` text,
  `email` varchar(255) DEFAULT NULL,
  `phoneNumber` varchar(20) DEFAULT NULL,
  `isDelete` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `customerName`, `address`, `email`, `phoneNumber`, `isDelete`) VALUES
(1, 'Sú Thế Luân111', 'Bình Phước', 'luansu112312@gmail.com', '0123121111', 0),
(2, 'Diệp Thái Bình', 'Khánh Hòa', 'binhdiep@gmail.com', '0378603032', 0),
(3, 'Diệp Thái Bình3', 'Khánh Hòa', 'binhdiep15963@gmail.com', '0378603032', 1),
(4, 'Sú Thế Luân', 'Bình Phước', 'luansu1123@gmail.com', '0123121111', 0);

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `userId` int DEFAULT NULL,
  `customerId` int DEFAULT NULL,
  `totalAmount` double DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `isDelete` tinyint(1) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `userId` (`userId`),
  KEY `customerId` (`customerId`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`Id`, `userId`, `customerId`, `totalAmount`, `status`, `isDelete`, `date`) VALUES
(1, 1, 1, 15000000, 'Yes', 0, '2023-12-30'),
(2, 0, 2, 25000000, 'Ok', 0, '2024-01-02'),
(3, 0, 1, 27200000, 'Ok', 0, '2024-01-02'),
(4, 0, 4, 23000000, 'Ok', 0, '2024-01-02'),
(5, 0, 4, 35000000, 'Ok', 0, '2024-01-02'),
(6, 0, 2, 25000000, 'Ok', 0, '2024-01-03'),
(7, 0, 0, 0, 'Ok', 0, '2024-01-04');

-- --------------------------------------------------------

--
-- Table structure for table `orderdetail`
--

DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE IF NOT EXISTS `orderdetail` (
  `productId` int DEFAULT NULL,
  `orderId` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  UNIQUE KEY `uc_orderdetail` (`productId`,`orderId`),
  KEY `fk_order` (`orderId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `orderdetail`
--

INSERT INTO `orderdetail` (`productId`, `orderId`, `quantity`) VALUES
(8, 4, 1),
(5, 6, 1),
(3, 6, 1),
(5, 0, 2),
(1, 2, 1),
(3, 2, 1),
(5, 3, 1),
(9, 3, 1),
(1, 3, 1),
(3, 5, 1),
(8, 5, 1),
(8, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `productName` varchar(255) NOT NULL,
  `description` text,
  `price` double DEFAULT NULL,
  `stockQuantity` int DEFAULT NULL,
  `categoryId` int DEFAULT NULL,
  `isDelete` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `categoryId` (`categoryId`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `productName`, `description`, `price`, `stockQuantity`, `categoryId`, `isDelete`) VALUES
(1, 'Nitro 5', 'Intel Core I5', 13000000, 30, 1, 0),
(3, 'Note 8', 'đIỆN THOẠI SIÊU XỊN', 12000000, 20, 3, 0),
(4, 'text1', 'des Text1', 10000000, 20, 3, 1),
(5, 'Ipad Mini 12', 'Apple', 13000000, 100, 8, 0),
(6, 'Bàn phím EKD112', 'EDra', 1500000, 100, 10, 0),
(7, 'text4', 'des Text4', 14000000, 100, 3, 1),
(8, 'text100', 'des Text100', 23000000, 300, 1, 0),
(9, 'Bàn phím EKD123', 'E_Dra', 1200000, 100, 3, 0);

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
CREATE TABLE IF NOT EXISTS `taikhoan` (
  `id` int NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `path` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `per` int NOT NULL,
  `isDelete` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`id`, `username`, `password`, `path`, `per`, `isDelete`) VALUES
(1, 'binh', 'binh123', 'c:', 0, 0),
(0, '123123', '12312', '12312', 2, 0),
(2, 'luan', 'luan', NULL, 0, 0),
(3, 'Hoa', 'hoa123', NULL, 1, 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
