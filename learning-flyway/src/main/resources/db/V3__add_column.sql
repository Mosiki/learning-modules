alter table t_user
    add type tinyint default 0 not null comment '分类' after password;