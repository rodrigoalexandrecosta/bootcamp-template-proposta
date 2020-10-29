create table proposal
(
    id              uuid primary key not null,
    social_identity varchar(255)     not null,
    email           varchar(255)     not null,
    name            varchar(255)     not null,
    address         varchar(1000)    not null,
    salary          numeric(9, 2)    not null,

    constraint uk_email_unique unique (email)
);