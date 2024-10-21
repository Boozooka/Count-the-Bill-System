--changeset boozooka:1
CREATE TABLE IF NOT EXISTS wallets(
    uuid UUID PRIMARY KEY NOT NULL,
    balance BIGINT
);