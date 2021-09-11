create table if not exists users
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

create table if not exists roles
(
    id         bigserial primary key,
    name       varchar(50) not null unique,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

CREATE TABLE if not exists users_roles
(
    user_id bigint not null references users (id),
    role_id bigint not null references roles (id),
    primary key (user_id, role_id)
);

create table if not exists goods
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
create table if not exists goods_category
(
    id            bigserial primary key,
    category_name varchar(50) not null unique
);

CREATE TABLE if not exists goods_category_cross
(
    goods_id    bigint not null references goods (id),
    category_id bigint not null references goods_category (id),
    primary key (goods_id, category_id)
);
create table if not exists medical_card
(
    id_card     bigserial primary key,
    description json
);
create table if not exists contacts
(
    id              bigserial primary key,
    FIO             varchar(255) not null unique,
    position        varchar(50),
    primary_phone   integer unique,
    mobile_phone    integer,
    work_phone      integer,
    primary_email   varchar(255) not null,
    secondary_email varchar(255),
    created_at      timestamp default current_timestamp,
    updated_at      timestamp default current_timestamp,
    medical         bigint references medical_card (id_card)
);
create table if not exists producers
(
    id          bigserial primary key,
    id_contact  bigint not null references contacts (id),
    designation varchar(255) unique,
    INN         bigint not null unique,
    description varchar(255),
    web_site    varchar(255),
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);
create table if not exists good_producer_cross
(
    goods_id    bigint not null references goods (id),
    producer_id bigint not null references producers (id),
    primary key (goods_id, producer_id)
);

create table if not exists discount
(
    id_discount     bigserial   not null primary key,
    discount_name   varchar(50) not null unique,
    discount_amount decimal     not null,
    created_at      timestamp default current_timestamp,
    updated_at      timestamp default current_timestamp
);

create table if not exists payment_type
(
    id_payment_type bigserial not null primary key,
    description     varchar(50),
    created_at      timestamp default current_timestamp,
    updated_at      timestamp default current_timestamp

);
create table if not exists sale_status
(
    id_sale_status bigserial not null primary key,
    status_name    varchar(50),
    created_at     timestamp default current_timestamp,
    updated_at     timestamp default current_timestamp

);
create table if not exists sales
(
    id_sale         bigserial      not null primary key,
    sale_date       timestamp,
    total_amount    numeric(10, 2) not null,
    discount_id     bigint references discount (id_discount),
    payment_type_id bigint references payment_type (id_payment_type),
    status          bigint references sale_status (id_sale_status),
    saler           bigint         not null references users (id),
    buyer           bigint         not null references contacts (id),
    created_at      timestamp default current_timestamp,
    updated_at      timestamp default current_timestamp

);
create table if not exists sales_items
(
    id_sale_detail bigserial      not null primary key,
    sale_id        bigint         not null references sales (id_sale),
    good_id        bigint         not null references goods (id),
    price          numeric(10, 2) not null,
    quantity       numeric(10, 2) not null

);
create table if not exists calculation
(
    id_calculation bigserial not null primary key,
    good_id        bigint references goods (id),
    created_at     timestamp default current_timestamp,
    updated_at     timestamp default current_timestamp
);
create table if not exists calculation_items
(
    id_calc_item bigserial      not null primary key,
    good_id      bigint         not null references goods (id),
    quantity     numeric(10, 2) not null,
    calc_id      bigint         not null references calculation (id_calculation)
);

create table if not exists status
(
    id_status bigserial    not null primary key,
    title     varchar(255) not null
);
create table if not exists work_place
(
    id_work_place bigserial    not null primary key,
    title         varchar(255) not null
);

create table if not exists service_category
(
    id_service_category bigserial    not null primary key,
    name                varchar(255) not null
);
create table if not exists services
(
    id_service  bigserial not null primary key,
    description varchar(255),
    title       varchar(255) unique,
    price       numeric(10, 2),
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);
create table if not exists service_category_service
(
    service_category bigint not null references services (id_service),
    category_service bigint not null references service_category (id_service_category),
    primary key (service_category, category_service)
);

create table if not exists jobs
(
    id_job        bigserial not null primary key,
    service_id    bigint    not null references services (id_service),
    user_id       bigint    not null references users (id),
    contact_id    bigint    not null references contacts (id),
    work_place_id bigint    not null references work_place (id_work_place),
    created_at    timestamp default current_timestamp,
    updated_at    timestamp default current_timestamp
);

create table if not exists time_slots
(
    id_time_slot bigint    not null primary key,
    started_at   timestamp not null,
    finished_at  timestamp not null,
    job_id       bigint    not null references jobs (id_job),
    status_id    bigint    not null references status (id_status),
    created_at   timestamp default current_timestamp,
    updated_at   timestamp default current_timestamp
);

create table if not exists task_status
(
    id_status   bigserial    not null primary key,
    description varchar(255) not null unique
);

create table if not exists priority
(
    id_priority bigserial    not null primary key,
    description varchar(255) not null unique
);

create table if not exists tasks
(
    id_task     bigserial    not null primary key,
    description varchar(255) not null,
    context     json,
    producer    bigint       not null references users (id),
    executor    bigint       not null references users (id),
    started_at  timestamp,
    finished_at timestamp,
    priority_id bigint references priority (id_priority),
    status_id   bigint references task_status (id_status),
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp

);

create table if not exists warehouses(
    id_warehouse bigserial not null primary key ,
    description varchar(255) not null

);

create table if not exists warehouses_goods(
    warehouse_id bigint not null references warehouses(id_warehouse),
    good_id bigint not null references goods(id),
    quantity     numeric(10, 2) not null
);




