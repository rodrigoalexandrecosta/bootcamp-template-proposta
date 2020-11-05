create table biometry
(
    id             uuid primary key not null,
    biometry_data  text             not null,
    created_at     timestamptz      not null,
    credit_card_id uuid             not null,

    constraint fk_credit_card_id foreign key (credit_card_id) references credit_card (id)
);