-- P23_createdb.sql
CREATE DATABASE IF NOT EXISTS P23_child_vaccine_db;
USE P23_child_vaccine_db;

-- Table: Role
CREATE TABLE role (
    rid INT PRIMARY KEY AUTO_INCREMENT,
    rname VARCHAR(50) NOT NULL
);

-- Table: User
CREATE TABLE user (
    uid INT PRIMARY KEY AUTO_INCREMENT,
    uname VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    rid INT,
    phone_no VARCHAR(15),
    email VARCHAR(100),
    FOREIGN KEY (rid) REFERENCES role(rid)
);

-- Table: Parent
CREATE TABLE parent (
    pid INT PRIMARY KEY AUTO_INCREMENT,
    paddress VARCHAR(255),
    adhar VARCHAR(20),
    fname VARCHAR(100),
    lname VARCHAR(100),
    occupation VARCHAR(100),
    uid INT,
    FOREIGN KEY (uid) REFERENCES user(uid)
);

-- Table: Child
CREATE TABLE child (
    cid INT PRIMARY KEY AUTO_INCREMENT,
    cname VARCHAR(100),
    dob DATE,
    height FLOAT,
    weight FLOAT,
    bgroup VARCHAR(5),
    gender VARCHAR(10),
    medical_history TEXT,
    pid INT,
    FOREIGN KEY (pid) REFERENCES parent(pid)
);

-- Table: Hospital
CREATE TABLE hospital (
    hid INT PRIMARY KEY AUTO_INCREMENT,
    hname VARCHAR(100),
    regno VARCHAR(50),
    telno VARCHAR(15),
    uid INT,
    FOREIGN KEY (uid) REFERENCES user(uid)
);

-- Table: Vaccine
CREATE TABLE vaccine (
    vid INT PRIMARY KEY AUTO_INCREMENT,
    vname VARCHAR(100),
    description TEXT,
    agegroup VARCHAR(50)
);

-- Table: child_vacc
CREATE TABLE child_vacc (
    cv_id INT PRIMARY KEY AUTO_INCREMENT,
    cid INT,
    hid INT,
    vid INT,
    dategiven DATE,
    nextduedate DATE,
    FOREIGN KEY (cid) REFERENCES child(cid),
    FOREIGN KEY (hid) REFERENCES hospital(hid),
    FOREIGN KEY (vid) REFERENCES vaccine(vid)
);
