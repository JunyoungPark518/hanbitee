CREATE TABLE Member (
	id VARCHAR2(10) NOT NULL,
	ssn VARCHAR2(10) NOT NULL,
	name VARCHAR2(10) NOT NULL,
	password VARCHAR2(10)NOT NULL, 
	profileImg VARCHAR2(20) NOT NULL, 
	phone VARCHAR2(13) NOT NULL,
	email VARCHAR2(20) NOT NULL,
	rank VARCHAR2(2) NOT NULL,
	PRIMARY KEY(id)
);
INSERT INTO Member(id, ssn, name, password, profileImg, phone, email, rank) 
VALUES ('babungv', '900518-1', '박준용', '1', 'default', '010-2206-8900', 'babungv@gmail.com', 'C');

SELECT * FROM Member;