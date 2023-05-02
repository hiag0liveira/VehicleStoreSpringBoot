-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: upcardb
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `agendamento`
--

DROP TABLE IF EXISTS `agendamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agendamento` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_reuniao` date DEFAULT NULL,
  `id_cliente` bigint DEFAULT NULL,
  `id_horario` bigint DEFAULT NULL,
  `id_vendedor` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5nfg6jbph7b9cj8eqq75f9f9k` (`id_cliente`),
  KEY `FK2mim1se0k4utv1472s3d37akm` (`id_horario`),
  KEY `FKl0bgg5b5kclypif2920snywo3` (`id_vendedor`),
  CONSTRAINT `FK2mim1se0k4utv1472s3d37akm` FOREIGN KEY (`id_horario`) REFERENCES `horas` (`id`),
  CONSTRAINT `FK5nfg6jbph7b9cj8eqq75f9f9k` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `FKl0bgg5b5kclypif2920snywo3` FOREIGN KEY (`id_vendedor`) REFERENCES `vendedores` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agendamento`
--

LOCK TABLES `agendamento` WRITE;
/*!40000 ALTER TABLE `agendamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `agendamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carro`
--

DROP TABLE IF EXISTS `carro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carro` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ano_fabricacao` int NOT NULL,
  `cor` varchar(30) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `km_rodado` varchar(100) NOT NULL,
  `link_imagem` varchar(255) DEFAULT NULL,
  `marca` varchar(30) NOT NULL,
  `modelo` varchar(40) NOT NULL,
  `placa` varchar(255) NOT NULL,
  `preco_promocao` decimal(38,2) NOT NULL,
  `tipo_combustivel1` varchar(255) NOT NULL,
  `tipo_combustivel2` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_5uv3fisdwp2pmj1357rivswea` (`placa`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carro`
--

LOCK TABLES `carro` WRITE;
/*!40000 ALTER TABLE `carro` DISABLE KEYS */;
INSERT INTO `carro` VALUES (1,2015,'Branco ','','14000','https://www.automaxfiat.com.br/wp-content/uploads/2021/06/carros-economicos-1.jpeg','Fiat','Bom','1020AEB',10000.00,'GASOLINA_ADITIVADA','GASOLINA_COMUM'),(5,2023,'Vermelho','Bom carro','0','https://www.chevrolet.com.br/content/dam/chevrolet/mercosur/brazil/portuguese/index/cars/cars-subcontent/02-images/cruze-sport6-rs-carros.jpg?imwidth=420','Chevrolet','CRUZE SPORT6 RS','crs2164',30000.00,'GASOLINA_COMUM','ETANOL'),(6,2023,'Preto','','0','https://garagem360.com.br/wp-content/uploads/2023/03/Strada-2.jpg','Fiat','Touro','1723AEJ',25000.00,'DIESEL_ADITIVADO','GNV');
/*!40000 ALTER TABLE `carro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `telefone` varchar(255) NOT NULL,
  `tipo_cliente` varchar(255) NOT NULL,
  `endereco_id_fk` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK45yfh6c2tecmc3h1e2672l7t6` (`endereco_id_fk`),
  CONSTRAINT `FK45yfh6c2tecmc3h1e2672l7t6` FOREIGN KEY (`endereco_id_fk`) REFERENCES `endereco` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (2,'','','jonson@gmail.com','Jonson a Lenda','(22)22222-2222','PF',3),(3,'11.111.111/1111-11','','client3121@gmail.com','cliente2','(22)99187-2372','PJ',4);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `endereco` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `bairro` varchar(255) NOT NULL,
  `cep` varchar(9) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `logradouro` varchar(255) NOT NULL,
  `numero` int NOT NULL,
  `uf` varchar(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,'232132','28020-305','Campos dos Goytacazes','fundos','Rua 1',111,'RJ'),(3,'Ipiranga','28011-111','Campos dos Goytacazes','fundos','Rua 12',2222,'RJ'),(4,'centro','28100-000','campos','casa','casa',2222,'MG');
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horas`
--

DROP TABLE IF EXISTS `horas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `hora_minuto` time NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_tdc0heyq6kan0bs0f57i1ggbu` (`hora_minuto`),
  KEY `idx_hora_minuto` (`hora_minuto`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horas`
--

LOCK TABLES `horas` WRITE;
/*!40000 ALTER TABLE `horas` DISABLE KEYS */;
INSERT INTO `horas` VALUES (1,'07:00:00'),(2,'07:30:00'),(3,'08:00:00'),(4,'08:30:00'),(5,'09:00:00'),(6,'09:30:00'),(7,'10:00:00'),(8,'10:30:00'),(9,'11:00:00'),(10,'11:30:00'),(11,'13:00:00'),(12,'13:30:00'),(13,'14:00:00'),(14,'14:30:00'),(15,'15:00:00'),(16,'15:30:00'),(17,'16:00:00'),(18,'16:30:00'),(19,'17:00:00'),(20,'17:30:00');
/*!40000 ALTER TABLE `horas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfis`
--

DROP TABLE IF EXISTS `perfis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfis` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_46fwiur1v4jn08eg093a3bckv` (`descricao`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfis`
--

LOCK TABLES `perfis` WRITE;
/*!40000 ALTER TABLE `perfis` DISABLE KEYS */;
INSERT INTO `perfis` VALUES (1,'ADMIN'),(2,'VENDEDOR');
/*!40000 ALTER TABLE `perfis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ativo` tinyint(1) NOT NULL,
  `codigo_verificador` varchar(6) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_kfsp0s1tflm1cwlj8idhqsad0` (`email`),
  KEY `idx_usuario_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,1,'','admin@upcar.com.br','$2a$10$wnTMQAQjzpeILUcYxHYrBOE7ydbCgIWOJg6GTaESJBSSz/wYkv.NO'),(2,1,NULL,'hiagophd@gmail.com','$2a$10$k.7G6OdOEw8V4puSsTFw.OMjbfkCQHw1vZ1MwZ3TfFuoRIQnBCAA.'),(3,1,NULL,'hiago.o@gsuite.iff.edu.br','$2a$10$OhdFy0AOGPJhOMMhb7cXB./Myq8d5pgghiIW3jZcyEtm.ApOkoO8K');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_tem_perfis`
--

DROP TABLE IF EXISTS `usuarios_tem_perfis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios_tem_perfis` (
  `usuario_id` bigint NOT NULL,
  `perfil_id` bigint NOT NULL,
  PRIMARY KEY (`usuario_id`,`perfil_id`),
  KEY `FKewye59sxbuklud72lsswd1mn1` (`perfil_id`),
  CONSTRAINT `FKewye59sxbuklud72lsswd1mn1` FOREIGN KEY (`perfil_id`) REFERENCES `perfis` (`id`),
  CONSTRAINT `FKg6l7ittcd3wnixu65x04veyq6` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_tem_perfis`
--

LOCK TABLES `usuarios_tem_perfis` WRITE;
/*!40000 ALTER TABLE `usuarios_tem_perfis` DISABLE KEYS */;
INSERT INTO `usuarios_tem_perfis` VALUES (1,1),(2,2),(3,2);
/*!40000 ALTER TABLE `usuarios_tem_perfis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendedores`
--

DROP TABLE IF EXISTS `vendedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendedores` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cargo` varchar(50) NOT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `data_entrada` date NOT NULL,
  `nome` varchar(255) NOT NULL,
  `setor` varchar(50) NOT NULL,
  `telefone` varchar(255) NOT NULL,
  `endereco_id_fk` bigint DEFAULT NULL,
  `id_usuario` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK721xi855arqlc0dpqluymti4s` (`endereco_id_fk`),
  KEY `FKjmon615u31ld039ixwo82bkfq` (`id_usuario`),
  CONSTRAINT `FK721xi855arqlc0dpqluymti4s` FOREIGN KEY (`endereco_id_fk`) REFERENCES `endereco` (`id`),
  CONSTRAINT `FKjmon615u31ld039ixwo82bkfq` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendedores`
--

LOCK TABLES `vendedores` WRITE;
/*!40000 ALTER TABLE `vendedores` DISABLE KEYS */;
INSERT INTO `vendedores` VALUES (1,'Gerente','12191101089','2023-04-10','HIAGO DE OLIVEIRA MENDES','Vendas','22997860606',1,2);
/*!40000 ALTER TABLE `vendedores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-27 10:50:25
