--liquibase formatted sql

--changeset igor:1
ALTER TABLE IF EXISTS messages
    ADD CONSTRAINT FK_messages_chats FOREIGN KEY (chat_id) REFERENCES chats;

ALTER TABLE IF EXISTS chats_users_chats
    ADD CONSTRAINT FK_chats_users_chats FOREIGN KEY (chat_id) REFERENCES chats;