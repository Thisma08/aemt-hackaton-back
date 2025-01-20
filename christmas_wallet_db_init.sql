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

create table purchases
(
    id bigint auto_increment primary key,
    userId bigint not null,
    amount decimal(10,2) not null,
    purchaseDate datetime not null
);

create table months
(
    id bigint auto_increment primary key,
    month varchar(9) not null
);

insert into months(month)
values
('January'),
('February'),
('March'),
('April'),
('May'),
('June'),
('July'),
('August'),
('September'),
('October'),
('November'),
('December');

create table budgets
(
    id bigint auto_increment primary key,
    budget decimal(10,2)not null,
    monthId bigint not null,
    constraint FK_monthId_id foreign key (id) references months (id)
);
