-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cupcakes
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cupcakes
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cupcakes` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `cupcakes` ;

-- -----------------------------------------------------
-- Table `cupcakes`.`Bottom`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcakes`.`Bottom` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` DOUBLE NOT NULL,
  `active` BIT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cupcakes`.`Top`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcakes`.`Top` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` DOUBLE NOT NULL,
  `active` BIT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cupcakes`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcakes`.`User` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(20) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `balance` DOUBLE NOT NULL,
  `role` ENUM('admin', 'customer') DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cupcakes`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcakes`.`order` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `date` DATETIME NOT NULL,
  `User_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_order_User1_idx` (`User_id` ASC),
  CONSTRAINT `fk_order_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `cupcakes`.`User` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cupcakes`.`odetails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcakes`.`odetails` (
  `order_id` INT(11) NOT NULL,
  `Top_id` INT(11) NOT NULL,
  `Bottom_id` INT(11) NOT NULL,
  `price` DOUBLE NOT NULL,
  `qty` INT(11) NOT NULL,
  PRIMARY KEY (`order_id`, `Top_id`, `Bottom_id`),
  INDEX `fk_odetails_Top1_idx` (`Top_id` ASC),
  INDEX `fk_odetails_Bottom1_idx` (`Bottom_id` ASC),
  INDEX `fk_odetails_order1_idx` (`order_id` ASC),
  CONSTRAINT `fk_odetails_Bottom1`
    FOREIGN KEY (`Bottom_id`)
    REFERENCES `cupcakes`.`Bottom` (`id`),
  CONSTRAINT `fk_odetails_Top1`
    FOREIGN KEY (`Top_id`)
    REFERENCES `cupcakes`.`Top` (`id`),
  CONSTRAINT `fk_odetails_order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `cupcakes`.`order` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
