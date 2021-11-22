truncate table users CASCADE;

INSERT INTO users(username, password, fullname, email)
VALUES ('admin', '$2a$10$2ltsSSE0t1u2dIBhuqakj.L1FIYyT5VMALNRGKzVLcjfdDDdJvrWW', 'Admin', 'admin@email.com');

INSERT INTO users(username, password, fullname, email)
VALUES ('nikhil-amin', '$2a$10$MDuibRAVpIEBufO69vjWj.7DQUHqumfZAeQa5L/UMQ585pq/Tm1kK', 'Nikhil Amin', 'nikhilamin@email.com');
