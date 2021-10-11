-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`tb_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tb_product` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `price` VARCHAR(45) NULL,
  `score` SMALLINT(10) NULL,
  `image` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `mydb`.`tb_client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tb_client` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `telephone` VARCHAR(45) NULL,
  `adress` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `mydb`.`tb_request`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tb_request` (
  `id` INT NOT NULL,
  `date_emiss` DATE NULL,
  `request_value` DECIMAL(6,2) NULL,
  `discount` DECIMAL(6,2) NULL,
  `quantity` INT NULL,
  `tb_client_id` INT NOT NULL,
  PRIMARY KEY (`id`, `tb_client_id`),
  INDEX `fk_tb_request_tb_client1_idx` (`tb_client_id` ASC),
  CONSTRAINT `fk_tb_request_tb_client1`
    FOREIGN KEY (`tb_client_id`)
    REFERENCES `mydb`.`tb_client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`tb_re_request`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tb_re_request` (
  `id` INT NOT NULL,
  `unitary_value` DECIMAL(6,2) NULL,
  `quantity` INT NULL,
  `tb_product_id` INT NOT NULL,
  `tb_request_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tb_re_request_tb_product_idx` (`tb_product_id` ASC),
  INDEX `fk_tb_re_request_tb_request1_idx` (`tb_request_id` ASC),
  CONSTRAINT `fk_tb_re_request_tb_product`
    FOREIGN KEY (`tb_product_id`)
    REFERENCES `mydb`.`tb_product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_re_request_tb_request1`
    FOREIGN KEY (`tb_request_id`)
    REFERENCES `mydb`.`tb_request` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
