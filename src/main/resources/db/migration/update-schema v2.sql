CREATE TABLE otps
(
    id    BINARY(16)   NOT NULL,
    email VARCHAR(255) NULL,
    phone VARCHAR(255) NULL,
    otp   VARCHAR(255) NULL,
    CONSTRAINT pk_otps PRIMARY KEY (id)
);

CREATE TABLE users
(
    id          BINARY(16)   NOT NULL,
    email       VARCHAR(255) NULL,
    phone       VARCHAR(255) NULL,
    first_name  VARCHAR(255) NULL,
    last_name   VARCHAR(255) NULL,
    password    VARCHAR(255) NULL,
    state       VARCHAR(255) NULL,
    is_verified VARCHAR(255) NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);