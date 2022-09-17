SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

DROP SCHEMA IF EXISTS `hellobank` ;

-- -----------------------------------------------------
-- Schema hellobank
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hellobank` DEFAULT CHARACTER SET utf8 ;
USE `hellobank` ;

-- -----------------------------------------------------
-- Table `hellobank`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hellobank`.`cliente` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `registro_geral` VARCHAR(15) NOT NULL,
  `data_nascimento` VARCHAR(11) NOT NULL,
  `telefone` VARCHAR(255) NULL,
  `estado` VARCHAR(2) NULL,
  `cidade` VARCHAR(255) NULL,
  `cep` VARCHAR(10) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) VISIBLE,
  UNIQUE INDEX `registro_geral_UNIQUE` (`registro_geral` ASC) VISIBLE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `hellobank`.`conta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hellobank`.`conta` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `num_conta` INT(8) NOT NULL,
  `saldo` DOUBLE NOT NULL,
  `id_cliente` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_conta_cliente_idx` (`id_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_conta_cliente`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `hellobank`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `hellobank`.`transacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hellobank`.`transacao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `valor` FLOAT NULL,
  `data` TIMESTAMP NULL,
  `tipo` VARCHAR(255) NULL,
  `descricao` VARCHAR(255) NULL,
  `id_destinatario` BIGINT NULL,
  `id_remetente` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_destinatario_idx` (`id_destinatario` ASC) VISIBLE,
  INDEX `id_remetente_idx` (`id_remetente` ASC) VISIBLE,
  CONSTRAINT `id_destinatario`
    FOREIGN KEY (`id_destinatario`)
    REFERENCES `hellobank`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_remetente`
    FOREIGN KEY (`id_remetente`)
    REFERENCES `hellobank`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;