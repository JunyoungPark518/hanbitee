DROP TABLE Charts;
DROP TABLE Treatments;
DROP TABLE Patients;
DROP TABLE Nurses;
DROP TABLE Doctors;

CREATE TABLE Doctors(
    doc_id DECIMAL,
    major_treat varchar2(25) NOT NULL,
    doc_name varchar2(20) NOT NULL,
    doc_gen char(1) NOT NULL,
    doc_phone varchar2(15),
    doc_email varchar(50) NOT NULL,
    doc_position varchar2(20) NOT NULL,
    PRIMARY KEY(doc_id)
);

CREATE TABLE Nurses(
    nur_id DECIMAL,
    major_job varchar2(25) NOT NULL,
    nur_name varchar2(20) NOT NULL,
    nur_gen char(1) NOT NULL,
    nur_phone varchar2(15),
    nur_email varchar2(50),
    nur_position varchar2(20) NOT NULL,
    PRIMARY KEY(nur_id)
);

CREATE TABLE Patients(
    pat_id DECIMAL,
    nur_id DECIMAL NOT NULL,
    doc_id DECIMAL NOT NULL,
    pat_name varchar2(20) NOT NULL,
    pat_gen char(1) NOT NULL,
    pat_jumin varchar2(14) NOT NULL,
    pat_addr varchar2(100) NOT NULL,
    pat_phone varchar2(15),
    pat_email varchar2(50),
    pat_job varchar2(20) NOT NULL,
    PRIMARY KEY(pat_id),
    FOREIGN KEY(nur_id) REFERENCES Nurses(nur_id),
    FOREIGN KEY(doc_id) REFERENCES Doctors(doc_id)
);

CREATE TABLE Treatments(
    treat_id DECIMAL,
    pat_id DECIMAL NOT NULL,
    doc_id DECIMAL NOT NULL,
    treat_contents varchar2(1000) NOT NULL,
    treat_date DATE NOT NULL,
    PRIMARY KEY(treat_id),
    FOREIGN KEY(pat_id) REFERENCES Patients(pat_id),
    FOREIGN KEY(doc_id) REFERENCES Doctors(doc_id)
);

CREATE TABLE Charts(
    chart_id varchar2(20),
    treat_id DECIMAL NOT NULL,
    doc_id DECIMAL NOT NULL,
    pat_id DECIMAL NOT NULL,
    nur_id DECIMAL NOT NULL,
    chart_contents varchar2(1000) NOT NULL,
    PRIMARY KEY(chart_id),
    FOREIGN KEY(treat_id) REFERENCES Treatments(treat_id),
    FOREIGN KEY(doc_id) REFERENCES Doctors(doc_id),
    FOREIGN KEY(pat_id) REFERENCES Patients(pat_id),
    FOREIGN KEY(nur_id) REFERENCES Nurses(nur_id)
);

-- dummy 입력 부분
SELECT * FROM Doctors;
INSERT INTO Doctors VALUES (980312, '소아과', '이태정', 'M', '010-333-1340', 'ltj@hanbh.com', '과장');
INSERT INTO Doctors VALUES (000601, '내과', '안성기', 'M', '011-222-0987', 'ask@hanbh.com', '과장');
INSERT INTO Doctors VALUES (001208, '외과', '김민종', 'M', '010-333-8743', 'kmj@hanbh.com', '과장');
INSERT INTO Doctors VALUES (020403, '피부과', '이태서', 'M', '019-777-3764', 'lts@hanbh.com', '과장');
INSERT INTO Doctors VALUES (050900, '소아과', '김연아', 'F', '010-555-3746', 'kya@hanbh.com', '전문의');
INSERT INTO Doctors VALUES (050101, '내과', '차태현', 'M', '011-222-7643', 'cth@hanbh.com', '전문의');
INSERT INTO Doctors VALUES (062019, '소아과', '전지현', 'F', '010-999-1265', 'jjh@hanbh.com', '전문의');
INSERT INTO Doctors VALUES (070576, '피부과', '홍길동', 'M', '016-333-7263', 'hgd@hanbh.com', '전문의');
INSERT INTO Doctors VALUES (080543, '방사선과', '유재석', 'M', '010-222-1263', 'yjs@hanbh.com', '과장');
INSERT INTO Doctors VALUES (091001, '외과', '김병만', 'M', '010-555-3542', 'kbm@hanbh.com', '전문의');

SELECT * FROM  Nurses;
delete from nurses where nur_id = 91001;
INSERT INTO Nurses VALUES (050302, '소아과', '김은영', 'F', '010-555-8751', 'key@hanbh.com', '수간호사');
INSERT INTO Nurses VALUES (050021, '내과', '윤성애', 'F', '016-333-8745', 'ysa@hanbh.com', '수간호사');
INSERT INTO Nurses VALUES (040089, '피부과', '신지원', 'M', '010-666-7646', 'sjw@hanbh.com', '주임');
INSERT INTO Nurses VALUES (070605, '방사선과', '유정화', 'F', '010-333-4588', 'yjh@hanbh.com', '주임');
INSERT INTO Nurses VALUES (070804, '내과', '라하나', 'F', '010-222-1340', 'nhn@hanbh.com', '주임');
INSERT INTO Nurses VALUES (071018, '소아과', '김화경', 'F', '019-888-4116', 'khk@hanbh.com', '주임');
INSERT INTO Nurses VALUES (100356, '소아과', '이선용', 'M', '010-777-1234', 'lsy@hanbh.com', '간호사');
INSERT INTO Nurses VALUES (104145, '외과', '김현', 'M', '010-999-8520', 'kh@hanbh.com', '간호사');
INSERT INTO Nurses VALUES (120309, '피부과', '박성완', 'M', '010-777-4996', 'psw@hanbh.com', '간호사');
INSERT INTO Nurses VALUES (130211, '외과', '이서연', 'F', '010-222-3214', 'lsy2@hanbh.com', '간호사');

SELECT * FROM Patients;
INSERT INTO Patients VALUES (2345, 050302, 980312, '안상건', 'M', 232345, '서울', '010-555-7845', 'ask@ab.com', '회사원');
INSERT INTO Patients VALUES (3545, 040089, 020403, '김성룡', 'M', 543545, '서울', '010-333-7812', 'ksr@bb.com', '자영업');
INSERT INTO Patients VALUES (3424, 070605, 080543, '이종진', 'M', 433424, '부산', '019-888-4859', 'ljj@ab.com', '회사원');
INSERT INTO Patients VALUES (7675, 100356, 050900, '최광석', 'M', 677675, '당진', '010-222-4847', 'cks@cc.com', '회사원');
INSERT INTO Patients VALUES (4533, 070804, 000601, '정한경', 'M', 744533, '강릉', '010-777-9630', 'jhk@ab.com', '교수');
INSERT INTO Patients VALUES (5546, 120309, 070576, '유원현', 'M', 765546, '대구', '016-777-0214', 'ywh@cc.com', '자영업');
INSERT INTO Patients VALUES (4543, 070804, 050101, '최재정', 'M', 454543, '부산', '010-555-4187', 'cjj@bb.com', '회사원');
INSERT INTO Patients VALUES (9768, 130211, 091001, '이진희', 'F', 119768, '서울', '010-888-3675', 'ljh@ab.com', '교수');
INSERT INTO Patients VALUES (4234, 130211, 091001, '오나미', 'F', 234234, '속초', '010-999-6541', 'onm@cc.com', '학생');
INSERT INTO Patients VALUES (7643, 071018, 062019, '송성묵', 'M', 987643, '서울', '010-222-5874', 'ssm@bb.com', '학생');

SELECT * FROM Treatments;
INSERT INTO Treatments VALUES (130516023, 2345, 980312, '감기, 몸살', '2013-05-16');
INSERT INTO Treatments VALUES (130628100, 3545, 020403, '피부 트러블 치료', '2013-06-28');
INSERT INTO Treatments VALUES (131205056, 3424, 080543, '목 디스크로 MRI 촬영', '2013-12-05');
INSERT INTO Treatments VALUES (131218024, 7675, 050900, '중이염', '2013-12-18');
INSERT INTO Treatments VALUES (131224012, 4533, 000601, '장염', '2013-12-24');
INSERT INTO Treatments VALUES (140103001, 5546, 070576, '여드름 치료', '2014-01-03');
INSERT INTO Treatments VALUES (140109026, 4543, 050101, '위염', '2014-01-09');
INSERT INTO Treatments VALUES (140226102, 9768, 091001, '화상치료', '2014-02-26');
INSERT INTO Treatments VALUES (140303003, 4234, 091001, '교통사고 외상치료', '2014-03-03');
INSERT INTO Treatments VALUES (140308087, 7643, 062019, '장염', '2014-03-08');

SELECT * FROM Charts;
INSERT INTO Charts VALUES ('p_130516023', 130516023, 980312, 2345, 050302, '감기 주사 및 약 처방' );
INSERT INTO Charts VALUES ('d_130628100', 130628100, 020403, 3545, 040089, '피부 감염 방지 주사' );
INSERT INTO Charts VALUES ('r_131205056', 131205056, 080543, 3424, 070605, '주사 처방' );
INSERT INTO Charts VALUES ('p_131218024', 131218024, 050900, 7675, 100356, '귓속청소 및 약 처방' );
INSERT INTO Charts VALUES ('i_131224012', 131224012, 000601, 4533, 070804, '장염 입원치료' );
INSERT INTO Charts VALUES ('d_140103001', 140103001, 070576, 5546, 120309, '여드림 치료약 처방' );
INSERT INTO Charts VALUES ('i_140109026', 140109026, 050101, 4543, 070804, '위내시경' );
INSERT INTO Charts VALUES ('s_140226102', 140226102, 091001, 9768, 130211, '화상 크림약 처방' );
INSERT INTO Charts VALUES ('s_140303003', 140303003, 091001, 4234, 130211, '입원치료' );
INSERT INTO Charts VALUES ('p_140308087', 140308087, 062019, 7643, 071018, '장염 입원치료' );

UPDATE Member SET password='3', name='parkjy' WHERE id='admin';