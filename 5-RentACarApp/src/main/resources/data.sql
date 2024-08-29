INSERT INTO cities (name) VALUES ('Istanbul'), ('Ankara'), ('Izmir');

INSERT INTO companies (name, city_id) VALUES ('Company A', 1), ('Company B', 2);

INSERT INTO cars (company_id, type, daily_price, availability_start, availability_end, extra_services)
VALUES (1, 'Sedan', 100.00, '2024-01-01', '2024-12-31', 'GPS, Insurance'),
       (2, 'SUV', 150.00, '2024-03-01', '2024-09-30', 'Insurance');

INSERT INTO users (username, password, email) VALUES ('user1', 'password1', 'user1@example.com');

INSERT INTO reservations (user_id, car_id, start_date, end_date) VALUES (1, 1, '2024-05-01', '2024-05-07');
