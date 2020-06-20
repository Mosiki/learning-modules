alter table t_user
    add type tinyint default 0 not null comment '分类' after password; # 本行执行失败，通过 afterMigrateError.sql 自动删除执行失败的记录
#     add status tinyint default 0 not null comment '状态' after password;  # 注释上一行，解开本行，启动项目，V4版本正常执行