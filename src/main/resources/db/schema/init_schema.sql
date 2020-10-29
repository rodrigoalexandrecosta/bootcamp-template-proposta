create user proposal with password 'proposal';

\c postgres;
create schema proposalapi_service;
alter user proposal set search_path = 'proposalapi_service, public';

grant usage, create on schema proposalapi_service to proposal;
grant all on all tables in schema proposalapi_service to proposal;
grant all privileges on all tables in schema proposalapi_service to proposal;
grant all privileges on all sequences in schema proposalapi_service to proposal;
grant execute on all functions in schema proposalapi_service to proposal;