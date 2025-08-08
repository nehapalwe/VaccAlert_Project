USE P23_child_vaccine_db;

INSERT INTO role (rname) VALUES ('Parent'), ('Hospital');

INSERT INTO user (uname, password, rid, phone_no, email) VALUES 
('geeta_user', 'geeta123', 1, '9123456700', 'geeta@example.com'),
('neha_user', 'neha123', 1, '9123456701', 'neha@example.com'),
('aditya_user', 'aditya123', 1, '9123456702', 'aditya@example.com'),
('nihal_user', 'nihal123', 1, '9123456703', 'nihal@example.com'),
('kshitij_user', 'kshitij123', 1, '9123456704', 'kshitij@example.com'),
('hospital_user1', 'hosp123', 2, '9988776600', 'hosp1@example.com');

INSERT INTO parent (paddress, adhar, fname, lname, occupation, uid) VALUES
('Pune', '111122223333', 'Geeta', 'Sharma', 'Teacher', 1),
('Mumbai', '111122223334', 'Neha', 'Patil', 'Nurse', 2),
('Nagpur', '111122223335', 'Aditya', 'Joshi', 'Engineer', 3),
('Nashik', '111122223336', 'Nihal', 'Kulkarni', 'Business', 4),
('Kolhapur', '111122223337', 'Kshitij', 'Deshmukh', 'Doctor', 5);

INSERT INTO child (cname, dob, height, weight, bgroup, gender, medical_history, pid) VALUES
('Aarav', '2020-05-15', 90.5, 13.2, 'O+', 'Male', 'Healthy', 1),
('Anaya', '2019-08-20', 95.0, 14.0, 'A+', 'Female', 'No issues', 2),
('Ishaan', '2021-01-10', 85.2, 12.5, 'B+', 'Male', 'Allergy', 3),
('Myra', '2020-12-05', 88.0, 13.0, 'AB+', 'Female', 'Healthy', 4),
('Vivaan', '2018-07-22', 100.3, 15.5, 'O-', 'Male', 'Asthma', 5);

INSERT INTO hospital (hname, regno, telno, uid) VALUES
('City Health Clinic', 'H1234', '0201234500', 6);

INSERT INTO vaccine (vname, description, agegroup) VALUES
('BCG', 'Tuberculosis vaccine', '0-1 year'),
('Polio', 'Polio drops', '0-5 years');

INSERT INTO child_vacc (cid, hid, vid, dategiven, nextduedate) VALUES
(1, 1, 1, '2024-06-01', '2025-06-01'),
(2, 1, 2, '2024-05-20', '2025-05-20'),
(3, 1, 1, '2024-06-10', '2025-06-10'),
(4, 1, 2, '2024-05-15', '2025-05-15'),
(5, 1, 1, '2024-04-25', '2025-04-25');
