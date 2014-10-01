SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

CREATE DATABASE IF NOT EXISTS `sysauto` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `sysauto`;

CREATE TABLE IF NOT EXISTS `funcionarios` (
  `login` varchar(45) NOT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `enquadramento_funcional` varchar(45) DEFAULT NULL,
  `nivel_acesso` varchar(18) NOT NULL,
  `horas_trabalhadas` int(11) DEFAULT NULL,
  PRIMARY KEY (`login`),
  UNIQUE KEY `login` (`login`,`senha`,`nome`,`enquadramento_funcional`,`horas_trabalhadas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `produtos` (
  `idProduto` varchar(45) NOT NULL DEFAULT '',
  `nome` varchar(45) DEFAULT NULL,
  `enquadramento` varchar(45) DEFAULT NULL,
  `valor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idProduto`),
  UNIQUE KEY `idProduto` (`idProduto`,`nome`,`enquadramento`,`valor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `veiculos` (
  `placa` varchar(7) NOT NULL,
  `modelo` varchar(45) DEFAULT NULL,
  `cor` varchar(45) DEFAULT NULL,
  `ano` varchar(4) DEFAULT NULL,
  `proprietario` varchar(45) DEFAULT NULL,
  `contato_proprietario` varchar(13) DEFAULT NULL,
  `data_entrada` varchar(45) DEFAULT NULL,
  `datahora_inicio` varchar(45) DEFAULT NULL,
  `datahora_fim` varchar(45) DEFAULT NULL,
  `data_saida` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`placa`),
  UNIQUE KEY `placa` (`placa`,`modelo`,`cor`,`ano`,`proprietario`,`contato_proprietario`,`data_entrada`,`datahora_inicio`,`datahora_fim`,`data_saida`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;