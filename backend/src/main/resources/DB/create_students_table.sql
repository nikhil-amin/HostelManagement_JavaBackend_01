DROP TABLE IF EXISTS students CASCADE;
CREATE TABLE students
(
    student_id SERIAL PRIMARY KEY,
    student_name varchar(255) NOT NULL ,
    student_usn varchar(255) UNIQUE NOT NULL,
    student_phone varchar(255) NOT NULL,
    student_email varchar(255) NOT NULL,
    room_id INT NOT NULL,
    mess_facility_opted varchar(100) NOT NULL,
    FOREIGN KEY (room_id) REFERENCES rooms (room_id)
);