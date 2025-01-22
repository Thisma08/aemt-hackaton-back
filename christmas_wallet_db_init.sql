drop database christmas_wallet_db;

create database christmas_wallet_db;

use christmas_wallet_db;

create table users
(
    id       bigint auto_increment primary key,
    username varchar(255) not null,
    password varchar(255) not null,
    constraint UK_username unique (username)
);

create table categories
(
    id   bigint auto_increment primary key,
    name varchar(255) not null,
    constraint UK_name unique (name)
);

create table budgets
(
    id     bigint auto_increment primary key,
    budget decimal(10, 2) not null,
    month  bigint         not null,
    year   bigint         not null,
    userId bigint         not null,
    CONSTRAINT unique_month_year UNIQUE (month, year, userId),
    constraint FK_userId foreign key (userId) references users (id)
);

create table purchases
(
    id           bigint auto_increment primary key,
    amount       decimal(10, 2) not null,
    purchaseDate datetime       not null,
    categoryId   bigint         not null,
    budgetId     bigint         not null,
    constraint FK_categoryId foreign key (categoryId) references categories (id),
    constraint FK_budgetId foreign key (budgetId) references budgets (id)
);

create index idx_budget_user on budgets (userId);
create index idx_purchase_category on purchases (categoryId);
create index idx_purchase_date on purchases (purchaseDate);

INSERT INTO users (username, password)
VALUES ('user1', 'password123'),
       ('user2', 'securepass'),
       ('user3', 'strongpassword');
INSERT INTO categories (name)
VALUES ('Alimentation'),
       ('Vetements'),
       ('Electronique'),
       ('Cadeaux');
INSERT INTO budgets (budget, month, year, userId)
VALUES (1000.00, 12, 2023, 1),
       (1200.00, 1, 2024, 2),
       (1500.00, 2, 2024, 2),
       (150000.00, 2, 2025, 3);
INSERT INTO purchases (amount, purchaseDate, categoryId, budgetId)
VALUES (50.00, '2023-12-15 10:30:00', 1, 1),
       (150.00, '2023-12-20 14:45:00', 2, 1),
       (200.00, '2024-01-05 09:15:00', 3, 2);

select *
from budgets
         inner join purchases p on budgets.id = p.budgetId;
drop database christmas_wallet_db;

create database christmas_wallet_db;

use christmas_wallet_db;

create table users
(
    id       bigint auto_increment primary key,
    username varchar(255) not null,
    password varchar(255) not null,
    constraint UK_username unique (username)
);

create table categories
(
    id   bigint auto_increment primary key,
    name varchar(255) not null,
    constraint UK_name unique (name)
);

create table budgets
(
    id     bigint auto_increment primary key,
    budget decimal(10, 2) not null,
    month  bigint         not null,
    year   bigint         not null,
    userId bigint         not null,
    constraint FK_userId foreign key (userId) references users (id),
    CONSTRAINT unique_month_year UNIQUE (month, year, userId)
);

create table purchases
(
    id           bigint auto_increment primary key,
    amount       decimal(10, 2) not null,
    purchaseDate datetime       not null,
    categoryId   bigint         not null,
    budgetId     bigint         not null,
    constraint FK_categoryId foreign key (categoryId) references categories (id),
    constraint FK_budgetId foreign key (budgetId) references budgets (id)
);

create index idx_budgets_user on budgets (userId);
create index idx_purchase_category on purchases (categoryId);
create index idx_purchase_date on purchases (purchaseDate);

INSERT INTO users (username, password)
VALUES ('user1', 'password123'),
       ('user2', 'securepass'),
       ('user3', 'strongpassword');
INSERT INTO categories (name)
VALUES ('Alimentation'),
       ('Vetements'),
       ('Electronique'),
       ('Cadeaux');
INSERT INTO budgets (budget, month, year, userId)
VALUES (1000.00, 12, 2023, 1),
       (1200.00, 1, 2024, 1),
       (1500.00, 2, 2024, 2),
       (150000.00, 2, 2025, 3);
INSERT INTO purchases (amount, purchaseDate, categoryId, budgetId)
VALUES (50.00, '2023-12-15 10:30:00', 1, 1),
       (150.00, '2023-12-20 14:45:00', 2, 1),
       (200.00, '2024-01-05 09:15:00', 3, 2);

select *
from budgets
         inner join purchases p on budgets.id = p.budgetId;