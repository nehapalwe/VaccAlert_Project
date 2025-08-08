-- P23_createdb.sql
CREATE DATABASE IF NOT EXISTS P23_child_vaccine_db;
USE P23_child_vaccine_db;

-- Table: Role
CREATE TABLE roles (
    role_id INT PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(50) UNIQUE NOT NULL
);

-- Table: User
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    contact_no VARCHAR(15) NOT NULL,
    role_id INT,
    status TINYINT DEFAULT 0,
    
    
    FOREIGN KEY (role_id) REFERENCES roles(role_id)
);

-- Table: Parent
CREATE TABLE parents (
    parent_id INT PRIMARY KEY AUTO_INCREMENT,
    aadhar_number VARCHAR(20) UNIQUE NOT NULL,
    address TEXT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50),
    occupation VARCHAR(100) NOT NULL,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- Table: Hospital
CREATE TABLE hospital (
    hospital_id INT PRIMARY KEY AUTO_INCREMENT,
    hospital_name VARCHAR(50) NOT NULL,
    registration_number VARCHAR(50) UNIQUE NOT NULL,
    user_id INT,
    address TEXT,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- Table: Child
CREATE TABLE child (
    child_id INT PRIMARY KEY AUTO_INCREMENT,
    parent_id INT,
    child_name VARCHAR(50) NOT NULL,
    dob DATE NOT NULL,
    gender VARCHAR(20) NOT NULL,
    blood_group VARCHAR(3) NOT NULL,
    weight DECIMAL(4,2) NOT NULL,
    height DECIMAL(5,2) NOT NULL,
    medical_history VARCHAR(200) NOT NULL,
    FOREIGN KEY (parent_id) REFERENCES parents(parent_id)
);

-- Table: Vaccine
CREATE TABLE vaccines (
    vaccine_id INT PRIMARY KEY AUTO_INCREMENT,
    vaccine_name VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    age_group VARCHAR(50) NOT NULL
);

-- Table: child_vaccination_record 
CREATE TABLE child_vaccination_record (
    child_vaccine_id INT PRIMARY KEY AUTO_INCREMENT,
    child_id INT,
    hospital_id INT,
    vaccine_id INT,
    dategiven DATE NOT NULL,
    nextduedate DATE NOT NULL,
    FOREIGN KEY (child_id) REFERENCES child(child_id),
    FOREIGN KEY (hospital_id) REFERENCES hospital(hospital_id),
    FOREIGN KEY (vaccine_id) REFERENCES vaccines(vaccine_id)
);
-- Table: Admin 
CREATE TABLE admin (
    admin_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);



