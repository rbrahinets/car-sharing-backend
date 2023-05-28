CREATE TABLE IF NOT EXISTS `order`
(
    `id`           INT(11)        NOT NULL AUTO_INCREMENT,
    `id_car`       INT(11)        NOT NULL UNIQUE,
    `email`        VARCHAR(100)   NOT NULL,
    `amount_price` DECIMAL(12, 2) NOT NULL,
    `rental_date`  DATETIME       NOT NULL,
    `return_date`  DATETIME       NOT NULL,
    `id_status`    INT(11)        NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`id_car`) REFERENCES `car` (`id`) ON DELETE CASCADE,
    FOREIGN KEY (`id_status`) REFERENCES `status` (`id`) ON DELETE CASCADE
);
