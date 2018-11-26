INSERT INTO User(id, surname, name, role, created_date, link_google, login, password) VALUES(1, 'Ivanov', 'Ivan', 'CUSTOMER', '2018-11-25', 'http://link', 'testuser', '123');
INSERT INTO User(id, surname, name, role, created_date, link_google, login, password) VALUES(2, 'Petrov', 'Petr', 'CUSTOMER', '2018-11-25', 'http://link', 'testuser1', '123');

INSERT INTO Car(id, owner_id, make, car_number, model, color, year, vin)
VALUES(1, 1, 'BMW', '3355 EB-3', 'X5', 'black', 2017, 'jk45j323');

INSERT INTo repair_case(id, case_id, car_id, user_id, name, description, start_date, end_date, case_status)
VALUES(1, null, 1, 1, 'Main problem', 'Problem with accumulator', '2018-11-26', null, 'STARTED');

