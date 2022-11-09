--liquibase formatted sql

--changeset igor:1
ALTER TABLE IF EXISTS messages
    ADD CONSTRAINT FK_messages_chats FOREIGN KEY (chat_id) REFERENCES chats;