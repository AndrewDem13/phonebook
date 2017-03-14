CREATE SCHEMA `phonebook` DEFAULT CHARACTER SET utf8 ;

-- Table: users
CREATE TABLE users (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  login    VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  username VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB;

-- Table: contacts
CREATE TABLE contacts (
  id          INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  owner       VARCHAR(255) NOT NULL,
  last_name   VARCHAR(255) NOT NULL,
  first_name  VARCHAR(255) NOT NULL,
  middle_name VARCHAR(255) NOT NULL,
  number_mob  VARCHAR(255) NOT NULL,
  number_home VARCHAR(255) NULL,
  address     VARCHAR(255) NULL,
  email       VARCHAR(255) NULL,

  FOREIGN KEY (owner) REFERENCES users(login),

  UNIQUE (id, owner)
)
  ENGINE = InnoDB;

-- Insert data

INSERT INTO users VALUES (1, 'user1', '$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG', 'First User');
INSERT INTO users VALUES (2, 'user2', '$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG', 'Second User');

INSERT INTO contacts VALUES (1, 'user1', 'Contact', 'First', 'User', '09827358725', NULL, 'Address', NULL);
INSERT INTO contacts VALUES (2, 'user2', 'Contact', 'Second', 'User', '09827358725', null, 'Address', 'email@mail.ru');

SELECT * FROM contacts WHERE owner = 'user1';