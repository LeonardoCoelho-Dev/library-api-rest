create table users(

    id bigint not null auto_increment,
    username varchar(100) not null,
    password varchar(255) not null,
    role varchar(20) not null,

    primary key(id),
    unique key uk_users_username (username)

);
