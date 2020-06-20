CREATE TABLE `t_dept`
(
    `id`          bigint(20)  NOT NULL AUTO_INCREMENT,
    `name`        varchar(32) NOT NULL,
    `org_id`      bigint(20)  NOT NULL,
    `create_time` datetime    NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
