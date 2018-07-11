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
-- Table `APP`.`CUSTOMER`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `APP`.`CUSTOMER` ;

CREATE TABLE IF NOT EXISTS `APP`.`CUSTOMER` (
  `ID` INT(11) NOT NULL,
  `NAME_CST` VARCHAR(45) NULL DEFAULT NULL,
  `AGE_CST` INT(11) NULL DEFAULT NULL,
  `ADDRESS_CST` VARCHAR(45) NULL DEFAULT NULL,
  `TEL_CST` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_CST_UNIQUE` (`ID` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `APP`.`PRODUCT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `APP`.`PRODUCT` ;

CREATE TABLE IF NOT EXISTS `APP`.`PRODUCT` (
  `ID` INT(11) NOT NULL,
  `NAME_PRD` VARCHAR(45) NULL DEFAULT NULL,
  `PRICE_PRD` FLOAT NULL DEFAULT NULL,
  `STOCK` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_PRD_UNIQUE` (`ID` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `APP`.`USERS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `APP`.`USERS` ;

CREATE TABLE IF NOT EXISTS `APP`.`USERS` (
  `ID` INT(11) NOT NULL,
  `NAME` VARCHAR(45) NULL DEFAULT NULL,
  `LOGIN` VARCHAR(10) NULL DEFAULT NULL,
  `PASSWORD` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `APP`.`SELL`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `APP`.`SELL` ;

CREATE TABLE IF NOT EXISTS `APP`.`SELL` (
  `ID` INT(11) NOT NULL,
  `DATEOFSALE` DATE NULL DEFAULT NULL,
  `TOTAL` FLOAT NULL DEFAULT NULL,
  `ID_USER` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_SELL_UNIQUE` (`ID` ASC),
  INDEX `fk_sell_users_idx` (`ID_USER` ASC),
  CONSTRAINT `fk_sell_users`
    FOREIGN KEY (`ID_USER`)
    REFERENCES `APP`.`USERS` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `APP`.`SELLITEM`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `APP`.`SELLITEM` ;

CREATE TABLE IF NOT EXISTS `APP`.`SELLITEM` (
  `ID` INT(11) NOT NULL,
  `QNT_SELLITEM` INT(11) NULL DEFAULT NULL,
  `ID_PRODUCT` INT(11) NOT NULL,
  `ID_SELL` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_SELLITEM_UNIQUE` (`ID` ASC),
  INDEX `fk_sellitem_product1_idx` (`ID_PRODUCT` ASC),
  INDEX `fk_sellitem_sell1_idx` (`ID_SELL` ASC),
  CONSTRAINT `fk_sellitem_product1`
    FOREIGN KEY (`ID_PRODUCT`)
    REFERENCES `APP`.`PRODUCT` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sellitem_sell1`
    FOREIGN KEY (`ID_SELL`)
    REFERENCES `APP`.`SELL` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
