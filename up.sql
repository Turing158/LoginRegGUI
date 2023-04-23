create table up
(
    user     varchar(20) not null comment '用户名'
        primary key,
    password varchar(20) null comment '密码'
)
    comment '用户信息';

INSERT INTO lr.up (user, password) VALUES ('', '');
INSERT INTO lr.up (user, password) VALUES ('admin', '123456');
INSERT INTO lr.up (user, password) VALUES ('asd', 'asd');
INSERT INTO lr.up (user, password) VALUES ('qq', '123456');
