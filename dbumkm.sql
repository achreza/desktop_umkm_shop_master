-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 03, 2021 at 04:31 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbumkm`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `minuman_mahal` (OUT `total` INT(11))  select * from minuman where harga > 10000$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `minuman_mahal1` (OUT `total` INT(11))  select count(harga) into total from minuman_mahal where harga > 10000$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `minuman_mahal2` (OUT `totaal` INT(11))  select count(harga) into totaal from minuman_mahal where harga > 10000$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `minumEs` (IN `es` VARCHAR(10))  select * from minuman where nama_minuman like  '%es%'$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `minumEs2` (IN `es` VARCHAR(10))  select * from minuman where nama_minuman like es$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `minumMur` ()  select id_minuman,nama_minuman,harga,status_minuman from minuman where harga < 10000 AND status_minuman = 'tersedia'$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `tambah_minum` (IN `id_minuman` VARCHAR(10), IN `nama_minuman` VARCHAR(50), IN `harga` INT(11), IN `status_minuman` VARCHAR(30))  insert into minuman values (id_minuman,nama_minuman,harga,status_minuman)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `tambah_minuman` (IN `id_minuman` VARCHAR(10), IN `nama_minuman` VARCHAR(50), IN `harga` INT(11), IN `status_minuman` VARCHAR(30))  insert into minuman values ('id_minuman','nama_minuman','harga','status_minuman')$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `detail_order`
--

CREATE TABLE `detail_order` (
  `id_detail_order` varchar(10) NOT NULL,
  `id_order` varchar(10) NOT NULL,
  `id_pakaian` varchar(100) NOT NULL,
  `id_kerajinan` varchar(100) NOT NULL,
  `id_kuliner` varchar(150) NOT NULL,
  `id_snack` varchar(150) NOT NULL,
  `keterangan` text NOT NULL,
  `status_detail_order` varchar(50) NOT NULL,
  `jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `kerajinan`
--

CREATE TABLE `kerajinan` (
  `id_kerajinan` varchar(150) NOT NULL,
  `nama_kerajinan` varchar(150) NOT NULL,
  `size` varchar(50) NOT NULL,
  `harga` int(11) NOT NULL,
  `status_kerajinan` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kerajinan`
--

INSERT INTO `kerajinan` (`id_kerajinan`, `nama_kerajinan`, `size`, `harga`, `status_kerajinan`) VALUES
('1', 'Batik Keong', 'M', 10000, 'tersedia');

-- --------------------------------------------------------

--
-- Table structure for table `kuliner`
--

CREATE TABLE `kuliner` (
  `id_kuliner` varchar(11) NOT NULL,
  `nama_kuliner` varchar(150) NOT NULL,
  `size` varchar(150) NOT NULL,
  `harga` int(11) NOT NULL,
  `status_kuliner` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kuliner`
--

INSERT INTO `kuliner` (`id_kuliner`, `nama_kuliner`, `size`, `harga`, `status_kuliner`) VALUES
('1', 'Nasbung', 'Biasa', 5000, 'tersedia');

-- --------------------------------------------------------

--
-- Table structure for table `level`
--

CREATE TABLE `level` (
  `id_level` varchar(10) NOT NULL,
  `nama_level` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `level`
--

INSERT INTO `level` (`id_level`, `nama_level`) VALUES
('1', 'Manager'),
('2', 'Kasir');

-- --------------------------------------------------------

--
-- Table structure for table `masakan`
--

CREATE TABLE `masakan` (
  `id_masakan` varchar(10) NOT NULL,
  `nama_masakan` varchar(50) DEFAULT NULL,
  `harga` int(11) DEFAULT NULL,
  `status_masakan` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `masakan`
--

INSERT INTO `masakan` (`id_masakan`, `nama_masakan`, `harga`, `status_masakan`) VALUES
('msk1', 'soto ayami', 12000, 'tersedia'),
('msk10', 'bakmie kuah', 17000, 'tersedia'),
('msk2', 'soto daging', 15000, 'tersedia'),
('msk20', 'laptop', 20000, 'tersedia'),
('msk3', 'pecel', 10000, 'tersedia'),
('msk4', 'rawon', 15000, 'tersedia'),
('msk5', 'gule', 25000, 'tersedia'),
('msk6', 'nasi campur', 17000, 'tersedia'),
('msk7', 'coba', 17000, 'tersedia'),
('msk8', 'nasi goreng spesial', 25000, 'tidak tersedia');

-- --------------------------------------------------------

--
-- Table structure for table `minuman`
--

CREATE TABLE `minuman` (
  `id_minuman` varchar(10) NOT NULL,
  `nama_minuman` varchar(50) DEFAULT NULL,
  `harga` int(11) DEFAULT NULL,
  `status_minuman` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `minuman`
--

INSERT INTO `minuman` (`id_minuman`, `nama_minuman`, `harga`, `status_minuman`) VALUES
('mm90', 'grape', 1000, 'tersedia'),
('mn1', 'air mineral', 3000, 'tersedia'),
('mn10', 'Es Kopi Susu', 10000, 'tidak tersedia'),
('mn11', 'Es Oyen', 15000, 'tersedia'),
('mn2', 'Teh Hangat', 3500, 'tersedia'),
('mn3', 'Jeruk Panas', 5000, 'tersedia'),
('mn4', 'Es Teh', 4000, 'tersedia'),
('mn5', 'Es Jeruki', 6000, 'tersedia'),
('mn6', 'Kopi Hangat', 3000, 'tersedia'),
('mn9', 'Es Campur', 15000, 'tidak tersedia');

-- --------------------------------------------------------

--
-- Table structure for table `orderan`
--

CREATE TABLE `orderan` (
  `id_order` varchar(10) NOT NULL,
  `no_meja` int(11) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `id_user` varchar(10) DEFAULT NULL,
  `keterangan` text DEFAULT NULL,
  `status_order` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pakaian`
--

CREATE TABLE `pakaian` (
  `id_pakaian` varchar(150) NOT NULL,
  `nama_pakaian` varchar(150) NOT NULL,
  `size` varchar(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `status_pakaian` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pakaian`
--

INSERT INTO `pakaian` (`id_pakaian`, `nama_pakaian`, `size`, `harga`, `status_pakaian`) VALUES
('1', 'Baju jajal', 'L', 10000, 'tersedia');

-- --------------------------------------------------------

--
-- Table structure for table `snack`
--

CREATE TABLE `snack` (
  `id_snack` varchar(11) NOT NULL,
  `nama_snack` varchar(150) NOT NULL,
  `size` varchar(110) NOT NULL,
  `harga` int(11) NOT NULL,
  `status_snack` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `snack`
--

INSERT INTO `snack` (`id_snack`, `nama_snack`, `size`, `harga`, `status_snack`) VALUES
('1', 'citos', 'besar nemen', 200, 'tersedia');

-- --------------------------------------------------------

--
-- Stand-in structure for view `tampildatamasakan`
-- (See below for the actual view)
--
CREATE TABLE `tampildatamasakan` (
`id_masakan` varchar(10)
,`nama_masakan` varchar(50)
,`harga` int(11)
,`status_masakan` varchar(50)
);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` varchar(10) NOT NULL,
  `id_user` varchar(10) DEFAULT NULL,
  `id_order` varchar(10) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `total_bayar` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` varchar(10) NOT NULL,
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `nama_user` varchar(100) DEFAULT NULL,
  `id_level` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `nama_user`, `id_level`) VALUES
('1', 'reza', 'reza', 'reza ', '1'),
('4', 'suhu', 'suhu', 'suhu', '2');

-- --------------------------------------------------------

--
-- Structure for view `tampildatamasakan`
--
DROP TABLE IF EXISTS `tampildatamasakan`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `tampildatamasakan`  AS SELECT `masakan`.`id_masakan` AS `id_masakan`, `masakan`.`nama_masakan` AS `nama_masakan`, `masakan`.`harga` AS `harga`, `masakan`.`status_masakan` AS `status_masakan` FROM `masakan` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `level`
--
ALTER TABLE `level`
  ADD PRIMARY KEY (`id_level`);

--
-- Indexes for table `masakan`
--
ALTER TABLE `masakan`
  ADD PRIMARY KEY (`id_masakan`);

--
-- Indexes for table `minuman`
--
ALTER TABLE `minuman`
  ADD PRIMARY KEY (`id_minuman`);

--
-- Indexes for table `orderan`
--
ALTER TABLE `orderan`
  ADD PRIMARY KEY (`id_order`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
