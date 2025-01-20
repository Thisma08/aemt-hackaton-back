drop database christmas_wallet_db;

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

create table categories
(
    id bigint auto_increment primary key,
    name varchar(255) not null
);

create table purchases
(
    id bigint auto_increment primary key,
    amount decimal(10,2) not null,
    userId bigint not null,
    categoryId bigint not null,
    purchaseDate datetime not null,
    constraint FK_userId_id foreign key (id) references users (id),
    constraint FK_categoryId_id foreign key (id) references categories (id)
);

create table budgets
(
    id bigint auto_increment primary key,
    budget decimal(10,2)not null,
    monthValue bigint not null,
    yearValue bigint not null,
);
