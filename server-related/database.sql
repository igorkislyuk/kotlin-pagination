CREATE TABLE `messages` (
  `id` char(36) CHARACTER SET utf8 NOT NULL,
  `text` varchar(255) NOT NULL,
  `date` datetime NOT NULL,
  `author` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `date_index` (`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8