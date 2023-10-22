INSERT INTO users (date_of_birth, name, patronymic, surname) VALUES ('2000-04-19', 'Владимир', 'Владимирович', 'Владимиров');
INSERT INTO users (date_of_birth, name, patronymic, surname) VALUES ('2001-05-11', 'Александр', 'Александрович', 'Александров');
INSERT INTO users (date_of_birth, name, patronymic, surname) VALUES ('2005-01-15', 'Дмитрий', 'Дмитриевич', 'Дмитриев');
INSERT INTO users (date_of_birth, name, patronymic, surname) VALUES ('2001-11-22', 'Денис', 'Денисович', 'Денисов');
INSERT INTO users (date_of_birth, name, patronymic, surname) VALUES ('2000-05-11', 'Евгений', 'Евгеньевич', 'Евгеньев');

INSERT INTO user_credentials (login, password, user_id) VALUES ('vladimir', '$2y$10$2b4h3UeFbHkdU8rcjeWTdOx4DVbdDvZjcDIq.BB4gUCD755K59lq.', 1); --пароль у всех 1234
INSERT INTO user_credentials (login, password, user_id) VALUES ('aleksandr', '$2y$10$2b4h3UeFbHkdU8rcjeWTdOx4DVbdDvZjcDIq.BB4gUCD755K59lq.', 2);
INSERT INTO user_credentials (login, password, user_id) VALUES ('dmitrii', '$2y$10$2b4h3UeFbHkdU8rcjeWTdOx4DVbdDvZjcDIq.BB4gUCD755K59lq.', 3);
INSERT INTO user_credentials (login, password, user_id) VALUES ('denis', '$2y$10$2b4h3UeFbHkdU8rcjeWTdOx4DVbdDvZjcDIq.BB4gUCD755K59lq.', 4);
INSERT INTO user_credentials (login, password, user_id) VALUES ('evgenii', '$2y$10$2b4h3UeFbHkdU8rcjeWTdOx4DVbdDvZjcDIq.BB4gUCD755K59lq.', 5);

INSERT INTO chats (chat_name) VALUES ('Work');
INSERT INTO chats (chat_name) VALUES ('Sport');
INSERT INTO chats (chat_name) VALUES ('Meeting');


INSERT INTO messages (text, timestamp, chat_id, user_id) VALUES ('hello', now(), 1, 1);
INSERT INTO messages (text, timestamp, chat_id, user_id) VALUES ('hello my friend', now(), 1, 5);



