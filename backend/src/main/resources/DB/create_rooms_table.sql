DROP TABLE IF EXISTS rooms CASCADE;
CREATE TABLE rooms
(
    room_id SERIAL PRIMARY KEY,
    room_number INT UNIQUE NOT NULL ,
    room_type varchar(100) NOT NULL,
    total_number_of_beds INT NOT NULL,
    occupied_number_of_beds INT NOT NULL,
    room_price INT NOT NULL,
    room_description varchar(255) NOT NULL
);