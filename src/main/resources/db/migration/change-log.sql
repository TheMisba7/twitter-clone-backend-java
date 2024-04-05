--liquibase formatted sql

--changeset misba7:initialization
CREATE TYPE user_role AS ENUM ('ADMIN', 'USER');

create table if not exists users(
    userID BIGSERIAL PRIMARY KEY,
    firstname varchar(100) not null,
    lastname varchar(100) not null,
    birthday timestamp not null,
    country varchar(10) not null,
    email varchar(100) not null unique,
    password varchar(255) not null,
    roles user_role ARRAY not null
);

create table if not exists tweets(
    tweetID BIGSERIAL PRIMARY KEY,
    tweetText varchar (300),
    tweetedAt timestamp not null,
    updatedAt timestamp not null,
    tweetedBy BIGSERIAL not null
);

alter table tweets add constraint tweet_user_fk foreign key(tweetedBY) references users(userID);