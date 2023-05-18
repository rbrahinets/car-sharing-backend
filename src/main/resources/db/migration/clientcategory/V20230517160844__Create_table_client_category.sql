CREATE TABLE IF NOT EXISTS `client_category`
(
    `id_client`   INT(11) NOT NULL,
    `id_category` INT(11) NOT NULL,
    FOREIGN KEY (`id_client`) REFERENCES `user` (`id`) ON DELETE CASCADE,
    FOREIGN KEY (`id_category`) REFERENCES `category` (`id`) ON DELETE CASCADE
);
