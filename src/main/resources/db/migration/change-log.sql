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

--changeset misba7:admin
INSERT INTO users (firstname, lastname, birthday, country, email, password, roles)
VALUES ('Abdeddaim', 'Mansar', '2001-06-026 00:00:00', 'MA', 'a.mansar@nuitee.com', '$2y$10$.FD8GY378pf58t.mm9JnKuViqjZdT2dVSog0dFziKQsuEROP4f7p.', ARRAY['ADMIN'::user_role]);

--changeset misba7:follower
create table if not exists user_follower(
    id BIGSERIAL PRIMARY KEY,
    follower_id BIGSERIAL NOT NULL,
    followee_id BIGSERIAL NOT NULL
);

alter table user_follower add constraint follower_user_fk foreign key(follower_id) references users(userID);
alter table user_follower add constraint followee_user_fk foreign key(followee_id) references users(userID);