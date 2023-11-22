CREATE TABLE accounts (
    id SERIAL PRIMARY KEY,
    email varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    created_on TIMESTAMPTZ DEFAULT current_timestamp
)
