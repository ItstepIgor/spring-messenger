--liquibase formatted sql

--changeset igor:1

INSERT INTO chats (chat_name) VALUES ('IVAN-SEMEN');

--changeset igor:2

INSERT INTO chats_users (chat_id, user_id) VALUES (1, 1);
INSERT INTO chats_users (chat_id, user_id) VALUES (1, 2);

