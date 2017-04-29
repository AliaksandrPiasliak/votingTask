-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema votingDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema votingDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `votingDB` DEFAULT CHARACTER SET utf8 ;
USE `votingDB` ;

-- -----------------------------------------------------
-- Table `votingDB`.`voting`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votingDB`.`voting` (
  `id` LONG NOT NULL AUTO_INCREMENT,
  `voting_topic` VARCHAR(100) NOT NULL,
  `voting_link` VARCHAR(100),
  `voting_status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_voting`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `votingDB`.`options`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votingDB`.`options` (
  `id` LONG NOT NULL AUTO_INCREMENT,
  `id_voting` LONG NOT NULL,
  `option_text` VARCHAR(45) NOT NULL,
  `option_sum` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_option`),
  CONSTRAINT `option_voting`
    FOREIGN KEY (`id_voting`)
    REFERENCES `votingDB`.`voting` (`id_voting`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `option_voting_idx` ON `votingDB`.`options` (`id_voting` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;