CREATE TABLE student
(
    student_id SERIAL      NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50),
    year       INTEGER,
    PRIMARY KEY (student_id)
);