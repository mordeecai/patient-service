INSERT INTO patient (first_name, last_name, contact_number, active) VALUES ('Peter','One','22334455', true);
INSERT INTO patient (first_name, last_name, contact_number, active) VALUES ('Peter','Two','33445566', true);
INSERT INTO patient (first_name, last_name, contact_number, active) VALUES ('Peter','Three','44556677', true);
INSERT INTO patient (first_name, last_name, contact_number, active) VALUES ('Peter','Four','55667788', true);
INSERT INTO patient (first_name, last_name, contact_number, active) VALUES ('Peter','Five','66778899', true);
INSERT INTO patient (first_name, last_name, contact_number, active) VALUES ('Peter','Six','77889900', true);

INSERT INTO patient (first_name, last_name, contact_number, active) VALUES ('James','One','33334455', true);
INSERT INTO patient (first_name, last_name, contact_number, active) VALUES ('James','Two','33444466', true);
INSERT INTO patient (first_name, last_name, contact_number, active) VALUES ('James','Three','55556677', true);
INSERT INTO patient (first_name, last_name, contact_number, active) VALUES ('James','Four','11667788', true);
INSERT INTO patient (first_name, last_name, contact_number, active) VALUES ('James','Five','22778899', true);
INSERT INTO patient (first_name, last_name, contact_number, active) VALUES ('James','Six','88889900', true);

INSERT INTO address (address1, address2, city, country, postal_code) VALUES ('BLK 123','Bishan Street 11', 'NA', 'SG', '123456');
INSERT INTO address (address1, address2, city, country, postal_code) VALUES ('BLK 456','Yishun Street 11', 'NA', 'SG', '654321');
INSERT INTO address (address1, address2, city, country, postal_code) VALUES ('BLK 789','Kallang Ave 11', 'NA', 'SG', '567890');
INSERT INTO address (address1, address2, city, country, postal_code) VALUES ('BLK 101','Woodlands Ave 73', 'NA', 'SG', '098765');
INSERT INTO address (address1, address2, city, country, postal_code) VALUES ('BLK 111','Toa Payoh Street 1', 'NA', 'SG', '132435');
INSERT INTO address (address1, address2, city, country, postal_code) VALUES ('BLK 21','Serangoon', 'NA', 'SG', '132435');

INSERT INTO patient_address (patient_id, address_id) VALUES (1, 1);
INSERT INTO patient_address (patient_id, address_id) VALUES (2, 1);
INSERT INTO patient_address (patient_id, address_id) VALUES (3, 2);
INSERT INTO patient_address (patient_id, address_id) VALUES (4, 3);
INSERT INTO patient_address (patient_id, address_id) VALUES (5, 4);
INSERT INTO patient_address (patient_id, address_id) VALUES (6, 5);
INSERT INTO patient_address (patient_id, address_id) VALUES (7, 1);
INSERT INTO patient_address (patient_id, address_id) VALUES (8, 2);
INSERT INTO patient_address (patient_id, address_id) VALUES (9, 3);
INSERT INTO patient_address (patient_id, address_id) VALUES (10, 4);
INSERT INTO patient_address (patient_id, address_id) VALUES (11, 5);
INSERT INTO patient_address (patient_id, address_id) VALUES (12, 6);


SELECT p.first_name, p.last_name, a.address1, a.address2, a.country
FROM patient p, address a, patient_address pa
WHERE p.id=pa.patient_id
AND a.id=pa.address_id
ORDER BY p.first_name, p.last_name;