-- flyway 不会执行本脚本，需要初始化环境时手动执行

CREATE TABLE `t_user`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT,
    `username`    varchar(32)  NOT NULL,
    `password`    varchar(255) NOT NULL,
    `create_time` datetime     NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;
