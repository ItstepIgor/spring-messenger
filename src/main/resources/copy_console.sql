CREATE DATABASE messenger;

select * from messages;

CREATE TABLE messages
(
    id  INT8 GENERATED BY DEFAULT AS IDENTITY,
    data_create_message TIMESTAMP WITHOUT TIME ZONE DEFAULT (NOW() AT TIME ZONE '-03:00') NOT NULL,
    content VARCHAR(255) NOT NULL,
    chat_id INT8 NOT NULL ,
    sender_user_id INT8 NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE users
(
    id  INT8 GENERATED BY DEFAULT AS IDENTITY,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE chats
(
    id  INT8 GENERATED BY DEFAULT AS IDENTITY,
    chat_name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE chats_users
(
    chat_id INT8 NOT NULL,
    user_id INT8 NOT NULL,
    PRIMARY KEY (chat_id, user_id)
);

ALTER TABLE IF EXISTS messages ADD CONSTRAINT FK_messages_users FOREIGN KEY (sender_user_id) REFERENCES users;

ALTER TABLE IF EXISTS chats_users ADD CONSTRAINT FK_chats_users_users FOREIGN KEY (user_id) REFERENCES users;

ALTER TABLE IF EXISTS chats_users ADD CONSTRAINT FK_chats_users_chats FOREIGN KEY (chat_id) REFERENCES chats;