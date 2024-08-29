CREATE TABLE cities (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE companies (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(100) NOT NULL,
                           city_id INT REFERENCES cities(id)
);

CREATE TABLE cars (
                      id SERIAL PRIMARY KEY,
                      company_id INT REFERENCES companies(id),
                      type VARCHAR(50) NOT NULL,
                      daily_price DECIMAL(10, 2) NOT NULL,
                      availability_start DATE NOT NULL,
                      availability_end DATE NOT NULL,
                      extra_services TEXT
);

CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(50) UNIQUE NOT NULL,
                       password VARCHAR(100) NOT NULL,
                       email VARCHAR(100)
);

CREATE TABLE reservations (
                              id SERIAL PRIMARY KEY,
                              user_id INT REFERENCES users(id),
                              car_id INT REFERENCES cars(id),
                              start_date DATE NOT NULL,
                              end_date DATE NOT NULL
);
