CREATE DATABASE IF NOT EXISTS MyApp;

CREATE TABLE IF NOT EXISTS MyApp.pets  (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20),
    gender VARCHAR(20),
    age INT,
    animal VARCHAR(20)
);
