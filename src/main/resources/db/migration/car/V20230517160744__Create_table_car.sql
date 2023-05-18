CREATE TABLE IF NOT EXISTS `car`
(
    `id`          INT(11)       NOT NULL AUTO_INCREMENT,
    `brand`       VARCHAR(50)   NOT NULL,
    `model`       VARCHAR(50)   NOT NULL,
    `year`        YEAR          NOT NULL,
    `price`       DECIMAL(6, 2) NOT NULL,
    `id_category` INT(11)       NOT NULL,
    `plate`       VARCHAR(10)   NOT NULL,
    `available`   TINYINT(1)    NOT NULL,
    `image`       LONGBLOB,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`id_category`) REFERENCES `category` (`id`) ON DELETE CASCADE
);
