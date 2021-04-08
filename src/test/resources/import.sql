INSERT INTO bank (id) VALUES (1);
INSERT INTO bankaccount (id, serialnumber, bank_id) VALUES (1, 'AAB', 1);
INSERT INTO bankdepartment (id, name) VALUES (1, 'A'), (2, 'B'), (3, 'C');
INSERT INTO bank_bankdepartment (bank_id, departments_id) VALUES (1, 1), (1, 2), (1, 3);