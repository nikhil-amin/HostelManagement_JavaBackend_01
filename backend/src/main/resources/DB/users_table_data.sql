truncate table users CASCADE;

INSERT INTO users(user_name, password, fullname, email)
VALUES ('admin', '$2a$10$s7ZTR00Tr7IZZV1GF7r7gemBWHFEw.NRMoBbCpcrtkOkgAm/ihZWi', 'Admin', 'admin@email.com');

INSERT INTO users(user_name, password, fullname, email)
VALUES ('nikhil-amin', '$2a$10$MDuibRAVpIEBufO69vjWj.7DQUHqumfZAeQa5L/UMQ585pq/Tm1kK', 'Nikhil Amin', 'nikhilamin@email.com');
