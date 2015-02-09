-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema app
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema app
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `app` DEFAULT CHARACTER SET utf8 ;
USE `app` ;

-- -----------------------------------------------------
-- Table `app`.`costumer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `app`.`costumer` ;

CREATE TABLE IF NOT EXISTS `app`.`costumer` (
  `ID_CST` INT(11) NOT NULL,
  `NAME_CST` VARCHAR(45) NULL DEFAULT NULL,
  `AGE_CST` INT(11) NULL DEFAULT NULL,
  `ADDRESS_CST` VARCHAR(45) NULL DEFAULT NULL,
  `TEL_CST` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_CST`),
  UNIQUE INDEX `ID_CST_UNIQUE` (`ID_CST` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `app`.`product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `app`.`product` ;

CREATE TABLE IF NOT EXISTS `app`.`product` (
  `ID_PRD` INT(11) NOT NULL,
  `NAME_PRD` VARCHAR(45) NULL DEFAULT NULL,
  `PRICE_PRD` FLOAT NULL DEFAULT NULL,
  `STOCK` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_PRD`),
  UNIQUE INDEX `ID_PRD_UNIQUE` (`ID_PRD` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `app`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `app`.`users` ;

CREATE TABLE IF NOT EXISTS `app`.`users` (
  `ID` INT(11) NOT NULL,
  `NAME` VARCHAR(45) NULL DEFAULT NULL,
  `LOGIN` VARCHAR(10) NULL DEFAULT NULL,
  `PASSWORD` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `app`.`sell`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `app`.`sell` ;

CREATE TABLE IF NOT EXISTS `app`.`sell` (
  `ID_SELL` INT(11) NOT NULL,
  `DATEOFSALE` DATE NULL DEFAULT NULL,
  `TOTAL` FLOAT NULL DEFAULT NULL,
  `ID_USER` INT(11) NOT NULL,
  PRIMARY KEY (`ID_SELL`),
  UNIQUE INDEX `ID_SELL_UNIQUE` (`ID_SELL` ASC),
  INDEX `fk_sell_users_idx` (`ID_USER` ASC),
  CONSTRAINT `fk_sell_users`
    FOREIGN KEY (`ID_USER`)
    REFERENCES `app`.`users` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `app`.`sellitem`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `app`.`sellitem` ;

CREATE TABLE IF NOT EXISTS `app`.`sellitem` (
  `ID_SELLITEM` INT(11) NOT NULL,
  `QNT_SELLITEM` INT(11) NULL DEFAULT NULL,
  `ID_PRODUCT` INT(11) NOT NULL,
  `ID_SELL` INT(11) NOT NULL,
  PRIMARY KEY (`ID_SELLITEM`),
  UNIQUE INDEX `ID_SELLITEM_UNIQUE` (`ID_SELLITEM` ASC),
  INDEX `fk_sellitem_product1_idx` (`ID_PRODUCT` ASC),
  INDEX `fk_sellitem_sell1_idx` (`ID_SELL` ASC),
  CONSTRAINT `fk_sellitem_product1`
    FOREIGN KEY (`ID_PRODUCT`)
    REFERENCES `app`.`product` (`ID_PRD`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sellitem_sell1`
    FOREIGN KEY (`ID_SELL`)
    REFERENCES `app`.`sell` (`ID_SELL`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
