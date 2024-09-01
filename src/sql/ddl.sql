create database demo;

use demo;

create table user (
    id int unsigned primary key auto_increment comment  'id',
    username varchar(255) comment '用户名',
    password varchar(255) comment '密码',
    nickname varchar(255) comment '昵称',
    email varchar(255) comment '邮箱',
    avatar varchar(255) comment '头像',
    create_time datetime comment '创建时间',
    update_time datetime comment '更新时间'
) comment '用户表';

create table category (
    id int unsigned primary key auto_increment comment  'id',
    category_name varchar(255) comment '分类名称',
    category_alias varchar(255) comment '分类别名',
    create_user int unsigned comment '创建用户',
    create_time datetime comment '创建时间',
    update_time datetime comment '更新时间'
) comment '分类表';

create table article (
    id int unsigned primary key auto_increment comment  'id',
    title varchar(255) comment '标题',
    content varchar(10000) comment '内容',
    cover_img varchar(255) comment '封面图',
    status int unsigned comment '状态 0.草稿 1.已发布',
    category_id int unsigned comment '分类id',
    create_user int unsigned comment '创建用户',
    create_time datetime comment '创建时间',
    update_time datetime comment '更新时间'
) comment '文章表';