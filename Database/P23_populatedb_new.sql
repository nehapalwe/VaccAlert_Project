USE P23_child_vaccine_db;

INSERT INTO roles (role_name) VALUES ('Admin'), ('Hospital'),('Parent');

INSERT INTO users (name, password, role_id, contact_no, email,status) VALUES 
('geeta_user', 'geeta123', 1, '9123456700', 'geeta@example.com',0),
('neha_user', 'neha123', 1, '9123456701', 'neha@example.com',0),
('aditya_user', 'aditya123', 1, '9123456702', 'aditya@example.com',0),
('nihal_user', 'nihal123', 1, '9123456703', 'nihal@example.com',0),
('kshitij_user', 'kshitij123', 1, '9123456704', 'kshitij@example.com',0),
('hospital_user1', 'hosp123', 2, '9988776600', 'hosp1@example.com',0);

INSERT INTO parents (aadhar_number,address,first_name, last_name, occupation, user_id) VALUES
('111122223333','Pune', 'Geeta', 'Sharma', 'Teacher', 1),
( '111122223334','Mumbai', 'Neha', 'Patil', 'Nurse', 2),
( '111122223335','Nagpur', 'Aditya', 'Joshi', 'Engineer', 3),
( '111122223336','Nashik', 'Nihal', 'Kulkarni', 'Business', 4),
( '111122223337','Kolhapur', 'Kshitij', 'Deshmukh', 'Doctor', 5);

INSERT INTO child (parent_id,child_name, dob, height, weight, blood_group, gender, medical_history) VALUES
(1,'Aarav', '2020-05-15', 90.5, 13.2, 'O+', 'Male', 'Healthy'),
(2,'Anaya', '2019-08-20', 95.0, 14.0, 'A+', 'Female', 'No issues'),
(3,'Ishaan', '2021-01-10', 85.2, 12.5, 'B+', 'Male', 'Allergy'),
(4,'Myra', '2020-12-05', 88.0, 13.0, 'AB+', 'Female', 'Healthy'),
(5,'Vivaan', '2018-07-22', 100.3, 15.5, 'O-', 'Male', 'Asthma');

INSERT INTO hospital (hospital_name, registration_number,user_id,address) VALUES
('City Health Clinic', 'H1234',6,'Pune');

INSERT INTO vaccines (vaccine_name, description, age_group) VALUES
('BCG', 'Tuberculosis vaccine', '0-1 year'),
('Polio', 'Polio drops', '0-5 years');

INSERT INTO child_vaccination_record (child_id, hospital_id, vaccine_id, dategiven, nextduedate) VALUES
(1, 1, 1, '2024-06-01', '2025-06-01'),
(2, 1, 2, '2024-05-20', '2025-05-20'),
(3, 1, 1, '2024-06-10', '2025-06-10'),
(4, 1, 2, '2024-05-15', '2025-05-15'),
(5, 1, 1, '2024-04-25', '2025-04-25');
