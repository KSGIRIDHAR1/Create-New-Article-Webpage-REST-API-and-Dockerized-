-- MySQL Script generated by MySQL Workbench
-- Wed Jan 30 11:39:43 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema newsarticle
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `newsarticle` ;

-- -----------------------------------------------------
-- Schema newsarticle
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `newsarticle` DEFAULT CHARACTER SET utf8 ;
USE `newsarticle` ;

-- -----------------------------------------------------
-- Table `newsarticle`.`user_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `newsarticle`.`user_role` ;

CREATE TABLE IF NOT EXISTS `newsarticle`.`user_role` (
  `ur_id` INT NOT NULL,
  `ur_name` VARCHAR(45) NULL,
  PRIMARY KEY (`ur_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `newsarticle`.`language`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `newsarticle`.`language` ;

CREATE TABLE IF NOT EXISTS `newsarticle`.`language` (
  `la_id` INT NOT NULL,
  `la_name` VARCHAR(45) NULL,
  PRIMARY KEY (`la_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `newsarticle`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `newsarticle`.`user` ;

CREATE TABLE IF NOT EXISTS `newsarticle`.`user` (
  `us_id` INT NOT NULL,
  `us_name` VARCHAR(80) NULL,
  `us_email` VARCHAR(85) NULL,
  `us_password` VARCHAR(255) NULL,
  `us_status` VARCHAR(45) NULL,
  `us_ur_id` INT NULL,
  `us_la_id` INT NULL,
  PRIMARY KEY (`us_id`),
  INDEX `us_ur_id_fk_idx` (`us_ur_id` ASC),
  INDEX `us_la_id_fk_idx` (`us_la_id` ASC),
  CONSTRAINT `us_ur_id_fk`
    FOREIGN KEY (`us_ur_id`)
    REFERENCES `newsarticle`.`user_role` (`ur_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `us_la_id_fk`
    FOREIGN KEY (`us_la_id`)
    REFERENCES `newsarticle`.`language` (`la_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `newsarticle`.`article`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `newsarticle`.`article` ;

CREATE TABLE IF NOT EXISTS `newsarticle`.`article` (
  `ar_id` INT NOT NULL,
  `ar_author` VARCHAR(80) NULL,
  `ar_title` VARCHAR(255) NULL,
  `ar_description` VARCHAR(255) NULL,
  `ar_url` VARCHAR(255) NULL,
  `ar_urlToImage` VARCHAR(255) NULL,
  `ar_content` VARCHAR(255) NULL,
  `ar_source` VARCHAR(255) NULL,
  PRIMARY KEY (`ar_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `newsarticle`.`favourite_aricle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `newsarticle`.`favourite_aricle` ;

CREATE TABLE IF NOT EXISTS `newsarticle`.`favourite_aricle` (
  `fa_id` INT NOT NULL,
  `fa_us_id` INT NULL,
  `fa_ar_id` INT NULL,
  PRIMARY KEY (`fa_id`),
  INDEX `fa_us_id_fk_idx` (`fa_us_id` ASC),
  INDEX `fa_ar_id_fk_idx` (`fa_ar_id` ASC),
  CONSTRAINT `fa_us_id_fk`
    FOREIGN KEY (`fa_us_id`)
    REFERENCES `newsarticle`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fa_ar_id_fk`
    FOREIGN KEY (`fa_ar_id`)
    REFERENCES `newsarticle`.`article` (`ar_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
