# create user with name "pdb" and login "pdb"
CREATE USER 'pdb'@'localhost' IDENTIFIED BY 'pdb';

GRANT ALL PRIVILEGES ON *.* TO 'pdb'@'localhost';

FLUSH PRIVILEGES;

# create database
CREATE DATABASE IF NOT EXISTS pdb;

#create table for users
CREATE TABLE IF NOT EXISTS `pdb`.`user`
(
    `id`         BIGINT       NOT NULL,
    `first_name` VARCHAR(255) NULL,
    `last_name`  VARCHAR(255) NULL,
    `mail`       VARCHAR(255) NULL,
    `login`      VARCHAR(255) NULL,
    `password`   VARCHAR(255) NULL,
    `status`     VARCHAR(255) NULL,
    `activation` VARCHAR(255) NULL,
    PRIMARY KEY (`id`)
);

ALTER TABLE `pdb`.`user`
    CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT,
    ADD UNIQUE INDEX `id_UNIQUE` (`id` ASC);

#create table for person
CREATE TABLE IF NOT EXISTS `pdb`.`person`
(
    `id`                 BIGINT       NOT NULL,
    `last_name`          VARCHAR(255) NULL,
    `first_name`         VARCHAR(255) NULL,
    `father_name`        VARCHAR(255) NULL,
    `fio`                VARCHAR(255) NULL,
    `birthday`           DATE         NULL,
    `education`          VARCHAR(255) NULL,
    `profession`         VARCHAR(255) NULL,
    `family_status`      VARCHAR(255) NULL,
    `gender`             VARCHAR(255) NULL,
    `city`               VARCHAR(255) NULL,
    `street`             VARCHAR(255) NULL,
    `number_house`       VARCHAR(255) NULL,
    `number_flat`        VARCHAR(255) NULL,
    `address`            VARCHAR(255) NULL,
    `telephon`           VARCHAR(255) NULL,
    `mobile`             VARCHAR(255) NULL,
    `hrost`              BOOLEAN DEFAULT FALSE,
    `hrost_date`         DATE         NULL,
    `kamuniya`           BOOLEAN DEFAULT FALSE,
    `kamuniya_date`      DATE         NULL,
    `kanfirmazyia`       BOOLEAN DEFAULT FALSE,
    `kanfirmazyia_date`  DATE         NULL,
    `suzhenstva`         BOOLEAN DEFAULT FALSE,
    `suzhenstva_date`    DATE         NULL,
    `religion_education` VARCHAR(255) NULL,
    `udzel_imshy`        VARCHAR(255) NULL,
    `spovedz`            VARCHAR(255) NULL,
    `partner_id`         BIGINT,
    `children`           VARCHAR(255) NULL,
    `other_member`       VARCHAR(255) NULL,
    `comments`           VARCHAR(255) NULL,
    `visit_years`        VARCHAR(255) NULL,
    `last_visit_year`    VARCHAR(255) NULL,
    PRIMARY KEY (`id`)
);

ALTER TABLE `pdb`.`person`
    CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT,
    ADD UNIQUE INDEX `id_UNIQUE` (`id` ASC);