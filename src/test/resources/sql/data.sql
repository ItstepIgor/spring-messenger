INSERT INTO users (name, password, avatar_id, role)
VALUES ('Ivan', 1, '634921ff872b4129567ae16a', 0),
       ('Semen', 3, '634921ff872b4129567ae16a', 1),
       ('Petr', 2, '634921ff872b4129567ae16a', 1),
       ('Makar', 4, '634921ff872b4129567ae16a', 0),
       ('Miron', 123, '634921ff872b4129567ae16a', 1),
       ('Miron', 123, '634921ff872b4129567ae16a', 0);

INSERT INTO chats (chat_name)
VALUES ('Ivan-Semen');

INSERT INTO messages (data_create_message, content, chat_id, sender_user_id)
VALUES ('2022-06-15 13:05:42.489841', 'eeeeeeeettttt', 1, 1);

