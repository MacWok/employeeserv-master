

DROP TABLE IF EXISTS address;

CREATE TABLE address (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  line1 VARCHAR(500) NOT NULL,
  line2 VARCHAR(500) ,
  city  VARCHAR(255) NOT NULL,
  state VARCHAR(255) NOT NULL,
  country  VARCHAR(255) NOT NULL,
  zip_code INT NOT NULL
);

DROP TABLE IF EXISTS employee;


CREATE TABLE employee (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  dob DATE NOT NULL,
  address INT NOT NULL,
  FOREIGN KEY (address) REFERENCES address(id),
  CONSTRAINT uniq_employee UNIQUE(first_name,last_name,dob)
);

