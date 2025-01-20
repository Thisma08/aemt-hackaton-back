create database christmas_wallet_db;

use christmas_wallet_db;

create table users
(
    id bigint auto_increment primary key,
    username varchar(255) not null,
    email varchar(255) not null,
    password varchar(255) not null,
    constraint UK_email unique (email),
    constraint UK_username unique (username)
);

create table purchases
(
    id bigint auto_increment primary key,
    amount decimal(10,2) not null,
    purchaseDate datetime not null
);

create table roles
(
    id bigint auto_increment primary key,
    name varchar(255) not null
);

create table users_roles
(
    userId bigint not null,
    roleId bigint not null,
    primary key (userId, roleId),
    constraint FK_userId_id foreign key (userId) references users (id),
    constraint FK_roleId_id foreign key (roleId) references roles (id)
);