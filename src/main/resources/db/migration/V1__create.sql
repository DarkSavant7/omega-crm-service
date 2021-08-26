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

