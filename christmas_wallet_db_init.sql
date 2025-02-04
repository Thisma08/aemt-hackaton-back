drop database christmas_wallet_db;

create database christmas_wallet_db;

use christmas_wallet_db;

create table users
(
    id bigint auto_increment primary key,
    username varchar(255) not null,
    password varchar(255) not null,
    constraint UK_username unique (username)
);

create table categories
(
    id bigint auto_increment primary key,
    name varchar(255) not null
);

create table budgets
(
    id bigint auto_increment primary key,
    budget decimal(10,2)not null,
    month bigint not null,
    year bigint not null
);

create table purchases
(
    id bigint auto_increment primary key,
    amount decimal(10,2) not null,
    purchaseDate datetime not null,
    userId bigint not null,
    categoryId bigint not null,
    budgetId bigint not null,
    constraint FK_userId foreign key (userId) references users (id),
    constraint FK_categoryId foreign key (categoryId) references categories (id),
    constraint FK_budgetId foreign key (budgetId) references budgets (id)
);

create index idx_purchase_user on purchases (userId);
create index idx_purchase_category on purchases (categoryId);
create index idx_purchase_date on purchases (purchaseDate);

select * from budgets;
