DROP TABLE IF EXISTS userModel;

CREATE TABLE userModel (
email VARCHAR(50) PRIMARY KEY NOT NULL,
password VARCHAR(50) NOT NULL,
mobile VARCHAR(50) NOT NULL,
address VARCHAR(50) NOT NULL,
token VARCHAR(50) NULL
);

INSERT INTO userModel (email, password, mobile, address)
VALUES ("jackrackham@gmail.com", "jackrackam22", "98585858", "Germany");

SELECT * FROM userModel;
