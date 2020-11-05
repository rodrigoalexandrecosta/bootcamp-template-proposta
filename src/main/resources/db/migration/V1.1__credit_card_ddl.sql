create table credit_card
(
    id          uuid primary key not null,
    card_number varchar(36)      not null,
    proposal_id uuid             not null,

    constraint fk_proposal_id foreign key (proposal_id) references proposal (id)
);