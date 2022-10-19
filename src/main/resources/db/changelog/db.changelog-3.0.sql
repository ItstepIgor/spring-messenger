--liquibase formatted sql

--changeset igor:1

ALTER TABLE users
    ADD COLUMN role VARCHAR(32) NOT NULL DEFAULT 'USER'