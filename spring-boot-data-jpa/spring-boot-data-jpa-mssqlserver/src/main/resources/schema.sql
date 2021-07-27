CREATE TABLE student
(
    student_id INTEGER     NOT NULL IDENTITY PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50),
    year       INTEGER
);