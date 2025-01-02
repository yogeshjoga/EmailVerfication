-- and so on until 200 rows

-- Dummy data for testing Apis

INSERT INTO users (id, email, phone, first_name, last_name, is_verified, state, password) VALUES
(UNHEX(REPLACE(UUID(), '-', '')), 'john.doe@example.com', '1234567890', 'John', 'Doe', 'VERIFIED', 'ACTIVE', 'password1'),
(UNHEX(REPLACE(UUID(), '-', '')), 'jane.doe@example.com', '0987654321', 'Jane', 'Doe', 'NOT_VERIFIED', 'INACTIVE', 'password2'),
(UNHEX(REPLACE(UUID(), '-', '')), 'alice.smith@example.com', '5551234567', 'Alice', 'Smith', 'VERIFIED', 'ACTIVE', 'password3'),
(UNHEX(REPLACE(UUID(), '-', '')), 'bob.jones@example.com', '4449876543', 'Bob', 'Jones', 'NOT_VERIFIED', 'INACTIVE', 'password4'),
(UNHEX(REPLACE(UUID(), '-', '')), 'charlie.brown@example.com', '3337654321', 'Charlie', 'Brown', 'VERIFIED', 'ACTIVE', 'password5'),
(UNHEX(REPLACE(UUID(), '-', '')), 'david.smith@example.com', '1111234567', 'David', 'Smith', 'NOT_VERIFIED', 'ACTIVE', 'password6'),
(UNHEX(REPLACE(UUID(), '-', '')), 'emma.jones@example.com', '2221234567', 'Emma', 'Jones', 'VERIFIED', 'INACTIVE', 'password7'),
(UNHEX(REPLACE(UUID(), '-', '')), 'liam.brown@example.com', '3331234567', 'Liam', 'Brown', 'NOT_VERIFIED', 'ACTIVE', 'password8'),
(UNHEX(REPLACE(UUID(), '-', '')), 'olivia.wilson@example.com', '4441234567', 'Olivia', 'Wilson', 'VERIFIED', 'Inactive', 'password9'),
(UNHEX(REPLACE(UUID(), '-', '')), 'noah.miller@example.com', '5551234567', 'Noah', 'Miller', 'NOT_VERIFIED', 'Active', 'password10'),
(UNHEX(REPLACE(UUID(), '-', '')), 'william.davis@example.com', '6661234567', 'William', 'Davis', 'VERIFIED', 'Inactive', 'password11'),
(UNHEX(REPLACE(UUID(), '-', '')), 'sophia.moore@example.com', '7771234567', 'Sophia', 'Moore', 'NOT_VERIFIED', 'Active', 'password12'),
(UNHEX(REPLACE(UUID(), '-', '')), 'james.taylor@example.com', '8881234567', 'James', 'Taylor', 'VERIFIED', 'Inactive', 'password13'),
(UNHEX(REPLACE(UUID(), '-', '')), 'mia.anderson@example.com', '9991234567', 'Mia', 'Anderson', 'NOT_VERIFIED', 'Active', 'password14'),
(UNHEX(REPLACE(UUID(), '-', '')), 'lucas.white@example.com', '0001234567', 'Lucas', 'White', 'VERIFIED', 'Inactive', 'password15'),
(UNHEX(REPLACE(UUID(), '-', '')), 'ava.harris@example.com', '1011234567', 'Ava', 'Harris', 'NOT_VERIFIED', 'Active', 'password16'),
(UNHEX(REPLACE(UUID(), '-', '')), 'mason.thomas@example.com', '2021234567', 'Mason', 'Thomas', 'VERIFIED', 'Inactive', 'password17'),
(UNHEX(REPLACE(UUID(), '-', '')), 'isabella.jackson@example.com', '3031234567', 'Isabella', 'Jackson', 'NOT_VERIFIED', 'Active', 'password18'),
(UNHEX(REPLACE(UUID(), '-', '')), 'ethan.lewis@example.com', '4041234567', 'Ethan', 'Lewis', 'VERIFIED', 'Inactive', 'password19'),
(UNHEX(REPLACE(UUID(), '-', '')), 'sophia.walker@example.com', '5051234567', 'Sophia', 'Walker', 'NOT_VERIFIED', 'Active', 'password20');


-- and so on until 200 rows
