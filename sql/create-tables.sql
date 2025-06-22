CREATE TABLE IF NOT EXISTS login (
  user_id INT NOT NULL AUTO_INCREMENT,
  email_id VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  user_type ENUM('admin','user') NOT NULL,
  PRIMARY KEY (user_id),
  UNIQUE KEY email_id (email_id)
);

CREATE TABLE IF NOT EXISTS student (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  year INT NOT NULL,
  department VARCHAR(255) NOT NULL,
  user_id INT DEFAULT NULL,
  PRIMARY KEY (id),
  KEY fk_user_id (user_id),
  CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES login (user_id) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS book (
  book_id INT NOT NULL AUTO_INCREMENT,
  book_name VARCHAR(255) NOT NULL,
  quantity INT NOT NULL,
  category VARCHAR(255) NOT NULL,
  PRIMARY KEY (book_id)
);

CREATE TABLE IF NOT EXISTS book_transactions (
  issue_id INT NOT NULL AUTO_INCREMENT,
  book_id INT NOT NULL,
  student_id INT NOT NULL,
  issue_date DATE NOT NULL,
  return_date DATE NOT NULL,
  actual_return_date DATE DEFAULT NULL,
  status ENUM('issued','overdue','returned') NOT NULL,
  PRIMARY KEY (issue_id),
  KEY fk_book (book_id),
  KEY fk_student (student_id),
  CONSTRAINT fk_book FOREIGN KEY (book_id) REFERENCES book (book_id) ON DELETE CASCADE,
  CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES student (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS defaulter (
  defaulter_id INT NOT NULL AUTO_INCREMENT,
  student_id INT NOT NULL,
  book_id INT NOT NULL,
  overdue_days INT NOT NULL,
  fine_amount DECIMAL(10,2) NOT NULL,
  fine_status ENUM('paid','unpaid') NOT NULL,
  PRIMARY KEY (defaulter_id),
  KEY student_id (student_id),
  KEY book_id (book_id),
  CONSTRAINT defaulter_fk_1 FOREIGN KEY (student_id) REFERENCES student (id),
  CONSTRAINT defaulter_fk_2 FOREIGN KEY (book_id) REFERENCES book (book_id)
);
