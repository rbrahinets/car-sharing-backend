CREATE TABLE IF NOT EXISTS `user`
(
    `id`         INT(11)      NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(50)  NOT NULL,
    `last_name`  VARCHAR(50)  NOT NULL,
    `email`      VARCHAR(100) NOT NULL UNIQUE,
    `id_role`    INT(1)       NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`id_role`) REFERENCES `role` (`id`) ON DELETE CASCADE
);
