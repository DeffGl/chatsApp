create table chats
(
    id        bigserial
        primary key,
    chat_name varchar(255)
        constraint uk_pqlirmemf6s83ldkf594n8m8c
            unique
);

alter table chats
    owner to postgres;

create table users
(
    id            bigserial
        primary key,
    date_of_birth date,
    name          varchar(255),
    patronymic    varchar(255),
    surname       varchar(255)
);

alter table users
    owner to postgres;

create table user_credentials
(
    id       bigserial
        primary key,
    login    varchar(255)
        constraint uk_5n8g5bpu2dkp3yys4od1t9lcg
            unique,
    password varchar(255),
    user_id  bigint
        constraint uk_thx1lw5kg5ygi8d8b90gv2ha3
            unique
        constraint fk98kxj78ausx1xo94eq4mkjm9q
            references users
);

alter table user_credentials
    owner to postgres;


create table messages
(
    id        bigserial
        primary key,
    text      varchar(4096),
    timestamp timestamp(6),
    chat_id   bigint
        constraint fk64w44ngcpqp99ptcb9werdfmb
            references chats,
    user_id   bigint
        constraint fkpsmh6clh3csorw43eaodlqvkn
            references users
);

alter table messages
    owner to postgres;



