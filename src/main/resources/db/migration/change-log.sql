--liquibase formatted sql

--changeset misba7:initialization
create table if not exists users(
    id BIGSERIAL PRIMARY KEY,
    firstname varchar(100) not null,
    lastname varchar(100) not null,
    birthday timestamp not null,
    country varchar(10) not null,
    email varchar(100) not null unique,
    password varchar(255) not null
);

create table if not exists roles(
    id BIGSERIAL PRIMARY KEY,
    role_name varchar(20) not null unique
);

create table if not exists user_roles(
    user_id BIGSERIAL not null,
    role_id BIGSERIAL not null
);
alter table user_roles add constraint user_user_roles_fk foreign key(user_id) references users(id);
alter table user_roles add constraint role_user_roles_fk foreign key(role_id) references roles(id);

insert into roles(role_name) values ('ADMIN'),('USER');

create table if not exists tweets(
    tweet_id BIGSERIAL PRIMARY KEY,
    tweet_text varchar (300),
    tweeted_at timestamp not null,
    updated_at timestamp not null,
    tweeted_by BIGSERIAL not null
);

alter table tweets add constraint tweet_user_fk foreign key(tweeted_bY) references users(id);
INSERT INTO users (firstname, lastname, birthday, country, email, password)
VALUES ('Abdeddaim', 'Mansar', '2001-06-026 00:00:00', 'MA', 'a.mansar@nuitee.com', '$2y$10$.FD8GY378pf58t.mm9JnKuViqjZdT2dVSog0dFziKQsuEROP4f7p.');

INSERT INTO user_roles (user_id, role_id)
VALUES (
           (SELECT id FROM roles WHERE role_name = 'ADMIN'),
           (SELECT id FROM users WHERE email = 'a.mansar@nuitee.com')
       );

create table if not exists user_follower(
    id BIGSERIAL PRIMARY KEY,
    follower_id BIGSERIAL NOT NULL,
    followee_id BIGSERIAL NOT NULL
);

alter table user_follower add constraint follower_user_fk foreign key(follower_id) references users(id);
alter table user_follower add constraint followee_user_fk foreign key(followee_id) references users(id);