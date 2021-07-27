DROP TABLE IF EXISTS enrolment;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS course;

CREATE TABLE student
(
    id         INTEGER PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name  VARCHAR(50),
    year       INTEGER
);

CREATE TABLE course
(
    id   INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE enrolment
(
    id         INTEGER PRIMARY KEY AUTO_INCREMENT,
    student_id INTEGER,
    course_id  INTEGER,
    UNIQUE (student_id, course_id),
    FOREIGN KEY (student_id) REFERENCES student (id),
    FOREIGN KEY (course_id) REFERENCES course (id)
);