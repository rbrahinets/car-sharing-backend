CREATE TABLE IF NOT EXISTS `status`
(
    `id`   INT(11)      NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL UNIQUE,
    PRIMARY KEY (`id`)
);