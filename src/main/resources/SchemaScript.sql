DROP SCHEMA IF EXISTS rds_demo;
CREATE SCHEMA IF NOT EXISTS rds_demo;

CREATE TABLE IF NOT EXISTS rds_demo.app_address (
  id SERIAL PRIMARY KEY NOT NULL,
  street VARCHAR(40) NOT NULL,
  town VARCHAR(40) NOT NULL,
  county VARCHAR(40) NOT NULL,
  postcode VARCHAR(8) NOT NULL);

CREATE TABLE IF NOT EXISTS rds_demo.app_customer_image (
  id SERIAL PRIMARY KEY NOT NULL,
  s3_key VARCHAR(200) NOT NULL,
  url VARCHAR(1000) NOT NULL);

CREATE TABLE IF NOT EXISTS rds_demo.app_customer (
  id SERIAL PRIMARY KEY NOT NULL,
  first_name VARCHAR(30) NOT NULL,
  last_name VARCHAR(30) NOT NULL,
  date_of_birth DATE NOT NULL,
  customer_image_id INT NOT NULL,
  address_id INT NOT NULL,
  CONSTRAINT FK_ADDRESS_ID
    FOREIGN KEY (address_id)
    REFERENCES rds_demo.app_address (id),
  CONSTRAINT FK_CUSTOMER_IMAGE_ID
    FOREIGN KEY (customer_image_id)
    REFERENCES rds_demo.app_customer_image (id));

