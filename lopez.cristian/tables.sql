CREATE TABLE `BLOG_USUARIO` (
  `login` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  PRIMARY KEY (`login`)
) ENGINE=InnoDB;

CREATE TABLE `BLOG` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `BLOG_BLOG_USUARIO_FK` (`author`),
  CONSTRAINT `BLOG_BLOG_USUARIO_FK` FOREIGN KEY (`author`) REFERENCES `BLOG_USUARIO` (`login`)
) ENGINE=InnoDB;

CREATE TABLE `BLOG_COMMENT` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(100) NOT NULL,
  `blog_id` int(11) NOT NULL,
  `content` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `BLOG_COMMENT_BLOG_FK` (`blog_id`),
  KEY `BLOG_COMMENT_BLOG_USUARIO_FK` (`author`),
  CONSTRAINT `BLOG_COMMENT_BLOG_FK` FOREIGN KEY (`blog_id`) REFERENCES `BLOG` (`id`),
  CONSTRAINT `BLOG_COMMENT_BLOG_USUARIO_FK` FOREIGN KEY (`author`) REFERENCES `BLOG_USUARIO` (`login`)
) ENGINE=InnoDB;