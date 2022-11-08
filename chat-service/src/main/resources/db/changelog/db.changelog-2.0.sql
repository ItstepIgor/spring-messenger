--liquibase formatted sql

--changeset igor:1
ALTER TABLE IF EXISTS messages
    ADD CONSTRAINT FK_messages_users FOREIGN KEY (sender_user_id) REFERENCES users;

ALTER TABLE IF EXISTS chats_users
    ADD CONSTRAINT FK_chats_users_users FOREIGN KEY (user_id) REFERENCES users;

ALTER TABLE IF EXISTS chats_users
    ADD CONSTRAINT FK_chats_users_chats FOREIGN KEY (chat_id) REFERENCES chats;