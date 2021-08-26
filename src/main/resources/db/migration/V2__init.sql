insert into users (username, password, email)
values ('admin', '$2y$12$yr/ojWL6JQCpku.5vlcGuuIAkROTMOkIupVUzzRMqQvBqpUgn4xA2', 'bob5@gmail.com');



insert into roles (name)
values ('ROLE_PRIVATE'),
       ('ROLE_MANAGER'),
       ('ROLE_ACCOUNTANT'),
       ('ROLE_DOCTOR'),
       ('ROLE_COMMODITY'),
       ('ROLE_OWNER'),
       ('ROLE_ADMIN');

insert into users_roles (user_id, role_id)
values (1, 7);

