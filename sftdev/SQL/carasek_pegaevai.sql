-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 24, 2025 at 01:03 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `carasek_pegaevai`
--

-- --------------------------------------------------------

--
-- Table structure for table `local`
--

CREATE TABLE `local` (
  `id` int(11) NOT NULL,
  `nome` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `maquina`
--

CREATE TABLE `maquina` (
  `codigo` int(11) NOT NULL,
  `idLocal` int(11) NOT NULL,
  `dataUltimaManutencao` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `maquina_produto`
--

CREATE TABLE `maquina_produto` (
  `codigoMaquina` int(11) NOT NULL,
  `idProduto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `produto`
--

CREATE TABLE `produto` (
  `id` int(11) NOT NULL,
  `nome` varchar(25) NOT NULL,
  `idTipoProduto` int(11) NOT NULL,
  `refrigerado` tinyint(1) NOT NULL,
  `valor` decimal(4,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tipoproduto`
--

CREATE TABLE `tipoproduto` (
  `id` int(11) NOT NULL,
  `nome` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `local`
--
ALTER TABLE `local`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `maquina`
--
ALTER TABLE `maquina`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `FK_MAQUINA_IDLOCAL` (`idLocal`);

--
-- Indexes for table `maquina_produto`
--
ALTER TABLE `maquina_produto`
  ADD PRIMARY KEY (`codigoMaquina`,`idProduto`),
  ADD KEY `FK_MAQUINA_PRODUTO_IDPRODUTO` (`idProduto`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nome` (`nome`),
  ADD KEY `FK_PRODUTO_IDTIPOPRODUTO` (`idTipoProduto`);

--
-- Indexes for table `tipoproduto`
--
ALTER TABLE `tipoproduto`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nome` (`nome`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `local`
--
ALTER TABLE `local`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tipoproduto`
--
ALTER TABLE `tipoproduto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `maquina`
--
ALTER TABLE `maquina`
  ADD CONSTRAINT `FK_MAQUINA_IDLOCAL` FOREIGN KEY (`idLocal`) REFERENCES `local` (`id`);

--
-- Constraints for table `maquina_produto`
--
ALTER TABLE `maquina_produto`
  ADD CONSTRAINT `FK_MAQUINA_PRODUTO_CODIGOMAQUINA` FOREIGN KEY (`codigoMaquina`) REFERENCES `maquina` (`codigo`),
  ADD CONSTRAINT `FK_MAQUINA_PRODUTO_IDPRODUTO` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`id`);

--
-- Constraints for table `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `FK_PRODUTO_IDTIPOPRODUTO` FOREIGN KEY (`idTipoProduto`) REFERENCES `tipoproduto` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
