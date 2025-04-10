CREATE TABLE drivers (
    driver_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15) NOT NULL,
    cab_number VARCHAR(20) NOT NULL,
    cab_type VARCHAR(50),
    cab_model VARCHAR(50)
);