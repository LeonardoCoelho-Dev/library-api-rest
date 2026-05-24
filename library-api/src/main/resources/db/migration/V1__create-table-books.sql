create table books(

    id bigint not null auto_increment,
    title varchar(100) not null,
    volume varchar(100),
    genre varchar (100) not null,
    published_year int  not null,
    description varchar (3000) not null,
    author_name varchar(100) not null,
    author_age int not null,
    author_birth_year int not null,
    publisher_name varchar (100) not null,
    publisher_country varchar (100) not null,
    publisher_foundation_year int not null,



    primary key(id)

);