CREATE TABLE app_user (
    id SERIAL NOT NULL PRIMARY KEY,
    password text NOT NULL,
    email text NOT NULL,
    name text NOT NULL,
    is_deleted boolean NOT NULL DEFAULT FALSE,
    created_at timestamp NOT NULL,
    updated_at timestamp NOT NULL,
    deleted_at timestamp NULL
);

INSERT INTO app_user (password, email, name, is_deleted, created_at, updated_at, deleted_at) VALUES
    ('******', 'user1@email.com', 'user 1', false, '2024-08-31 00:00:00','2024-08-31 00:00:00', null),
    ('******', 'user2@email.com', 'user 2', false, '2024-08-31 00:00:00','2024-08-31 00:00:00', null),
    ('******', 'user3@email.com', 'user 3', true, '2024-08-16 00:00:00','2024-08-31 00:00:00', '2024-08-31 06:32:00');

CREATE TABLE product(
    id SERIAL NOT NULL PRIMARY KEY,
    name text NOT NULL,
    price numeric(13, 2) NOT NULL,
    description text NOT NULL,
    is_deleted boolean NOT NULL DEFAULT FALSE,
    created_at timestamp NOT NULL,
    updated_at timestamp NOT NULL,
    deleted_at timestamp NULL
);

INSERT INTO product (name, price, description, is_deleted, created_at, updated_at, deleted_at) VALUES
    ('mouse', 40.00, 'computer mouse', false, '2024-08-31 00:00:00', '2024-08-31 00:00:00', null),
    ('keyboard', 40.00, 'keyboard with QWERTY format', false, '2024-08-31 00:00:00', '2024-08-31 00:00:00', null),
    ('webcam', 40.00, 'webcam with 1080 pixels quality', true, '2024-08-31 00:00:00', '2024-08-31 00:00:00', '2024-08-31 06:32:00');