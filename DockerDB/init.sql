create database if not exists logisticsSystem;

use logisticsSystem;

CREATE TABLE `logisticsSystem`.`locations`
(
    `id_location` INT           NOT NULL AUTO_INCREMENT,
    `truck`       INT           NOT NULL,
    `latitude`    decimal(8, 6) NOT NULL,
    `longitude`   decimal(8, 6) NOT NULL,
    PRIMARY KEY (`id_location`)
);
INSERT INTO `logisticsSystem`.`locations` (`id_location`, `truck`, `latitude`, `longitude`)
VALUES ('1', '1', '43.784689', '43.883947'),
       ('2', '2', '42.485945', '42.837549'),
       ('3', '3', '41.348374', '41.374932'),
       ('4', '4', '45.754289', '46.743578'),
       ('5', '5', '67.847594', '33.578359'),
       ('6', '6', '44.657894', '47.894878'),
       ('7', '7', '35.487532', '32.458994'),
       ('8', '8', '33.577356', '37.237894'),
       ('9', '9', '34.574824', '56.893208'),
       ('10', '10', '36.482387', '48.167845');

CREATE TABLE `logisticsSystem`.`consumer_locations`
(
    `id_location_consumer` INT           NOT NULL AUTO_INCREMENT,
    `truck_consumer`       INT           NOT NULL,
    `latitude_consumer`    DECIMAL(8, 6) NOT NULL,
    `longitude_consumer`   DECIMAL(8, 6) NOT NULL,
    PRIMARY KEY (`id_location_consumer`)
);