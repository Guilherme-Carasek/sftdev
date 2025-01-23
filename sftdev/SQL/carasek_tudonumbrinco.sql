-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 23, 2025 at 05:27 PM
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
-- Database: `carasek_tudonumbrinco`
--

-- --------------------------------------------------------

--
-- Table structure for table `maquina`
--

CREATE TABLE `maquina` (
  `numero` int(11) NOT NULL,
  `idTipo` int(11) NOT NULL,
  `dataUltimaManutencao` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `servico`
--

CREATE TABLE `servico` (
  `codFatura` int(11) NOT NULL,
  `numeroMaquina` int(11) NOT NULL,
  `duracao` time NOT NULL,
  `valor` decimal(5,2) NOT NULL,
  `nifCliente` varchar(9) DEFAULT NULL,
  `dataHora` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tipomaquina`
--

CREATE TABLE `tipomaquina` (
  `id` int(11) NOT NULL,
  `nome` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `maquina`
--
ALTER TABLE `maquina`
  ADD PRIMARY KEY (`numero`),
  ADD KEY `FK_MAQUINA_IDTIPO` (`idTipo`);

--
-- Indexes for table `servico`
--
ALTER TABLE `servico`
  ADD PRIMARY KEY (`codFatura`),
  ADD KEY `FK_SERVICO_NUMMAQUINA` (`numeroMaquina`);

--
-- Indexes for table `tipomaquina`
--
ALTER TABLE `tipomaquina`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `maquina`
--
ALTER TABLE `maquina`
  MODIFY `numero` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `servico`
--
ALTER TABLE `servico`
  MODIFY `codFatura` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tipomaquina`
--
ALTER TABLE `tipomaquina`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `maquina`
--
ALTER TABLE `maquina`
  ADD CONSTRAINT `FK_MAQUINA_IDTIPO` FOREIGN KEY (`idTipo`) REFERENCES `tipomaquina` (`id`);

--
-- Constraints for table `servico`
--
ALTER TABLE `servico`
  ADD CONSTRAINT `FK_SERVICO_NUMMAQUINA` FOREIGN KEY (`numeroMaquina`) REFERENCES `maquina` (`numero`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
