create table users
(
    id         bigserial primary key,
    username   varchar(50) not null unique,
    password   varchar(80) not null,
    email      varchar(50) unique,
    status     varchar(10) not null default 'ACTIVE'
        check (status in ('ACTIVE', 'BLOCKED', 'DELETED')),
    created_at timestamp            default current_timestamp,
    updated_at timestamp            default current_timestamp
);

create table roles
(
    id         bigserial primary key,
    name       varchar(50) not null unique,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

CREATE TABLE users_roles
(
    user_id bigint not null references users (id),
    role_id bigint not null references roles (id),
    primary key (user_id, role_id)
);
create table goods
(
    id          bigserial primary key,
    vendor_code integer        not null unique,
    title       varchar(255)   not null,
    price       numeric(10, 2) not null,
    url_preview varchar(255),
    url_full    varchar(255),
    description varchar,
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);
create table category
(
    id            bigserial primary key,
    category_name varchar(50) not null unique
);

CREATE TABLE goods_category
(
    goods_id    bigint not null references goods (id),
    category_id bigint not null references category (id),
    primary key (goods_id, category_id)
);
create table contacts
(
    id              bigserial primary key,
    FIO             varchar(255) not null unique,
    position        varchar(50),
    primary_phone   integer      not null unique,
    mobile_phone    integer,
    work_phone      integer,
    primary_email   varchar(255) not null,
    secondary_email varchar(255),
    created_at      timestamp default current_timestamp,
    updated_at      timestamp default current_timestamp
);
create table producers
(
    id          bigserial primary key,
    id_contact  bigint  not null references contacts (id),
    designation varchar(255) unique,
    INN         integer not null unique,
    description varchar(255),
    web_site    varchar(255),
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);
create table good_producer
(
    goods_id    bigint not null references goods (id),
    producer_id bigint not null references producers (id),
    primary key (goods_id, producer_id)
);



