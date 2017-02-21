DROP TABLE Charts;
DROP TABLE Treatments;
DROP TABLE Patients;
DROP TABLE Nurses;
DROP TABLE Doctors;
select * from tab;
-- docID, docPass, majorTreat, docName, docGen, docPhone, docEmail, docPosition
CREATE TABLE Doctors(
    docID VARCHAR2(6),
    docPass VARCHAR2(25) NOT NULL, 
    majorTreat VARCHAR2(25) NOT NULL,
    docName VARCHAR2(20) NOT NULL,
    docGen char(1) NOT NULL,
    docPhone VARCHAR2(15),
    docEmail VARCHAR2(50) NOT NULL,
    docPosition VARCHAR2(20) NOT NULL,
    PRIMARY KEY(docId)
);

-- nurID, nurPass, majorJob, nurName, nurGen, nurPhone, nurEmail, nurPosition
CREATE TABLE Nurses(
    nurId VARCHAR2(6),
    nurPass VARCHAR2(25) NOT NULL,
    majorJob VARCHAR2(25) NOT NULL,
    nurName VARCHAR2(20) NOT NULL,
    nurGen char(1) NOT NULL,
    nurPhone VARCHAR2(15),
    nurEmail VARCHAR2(50),
    nurPosition VARCHAR2(20) NOT NULL,
    PRIMARY KEY(nurId)
);

-- patID, nurID, docID, patPass, patName, patGen, patJumin, patAddr, patPhone, patEmail, patJob
CREATE TABLE Patients(
    patId VARCHAR2(6),
    nurId VARCHAR2(6) NOT NULL,
    docId VARCHAR2(6) NOT NULL,
    patPass VARCHAR2(20) NOT NULL,
    patName VARCHAR2(20) NOT NULL,
    patGen char(1) NOT NULL,
    patJumin VARCHAR2(14) NOT NULL,
    patAddr VARCHAR2(100) NOT NULL,
    patPhone VARCHAR2(15),
    patEmail VARCHAR2(50),
    patJob VARCHAR2(20) NOT NULL,
    PRIMARY KEY(patId),
    FOREIGN KEY(nurId) REFERENCES Nurses(nurId),
    FOREIGN KEY(docId) REFERENCES Doctors(docId)
);

-- treatId, patId, docId, treatContents, treatDate
CREATE TABLE Treatments(
    treatId VARCHAR2(9),
    patId VARCHAR2(6) NOT NULL,
    docId VARCHAR2(6) NOT NULL,
    treatContents VARCHAR2(1000) NOT NULL,
    treatDate DATE NOT NULL,
    PRIMARY KEY(treatId),
    FOREIGN KEY(patId) REFERENCES Patients(patId),
    FOREIGN KEY(docId) REFERENCES Doctors(docId)
);

-- chartID, treatID, docID, nurID, patID, chartContent
CREATE TABLE Charts(
    chartId VARCHAR2(20),
    treatId VARCHAR2(9) NOT NULL,
    docId VARCHAR2(6) NOT NULL,
    patId VARCHAR2(6) NOT NULL,
    nurId VARCHAR2(6) NOT NULL,
    chartContents varchar2(1000) NOT NULL,
    PRIMARY KEY(chartId),
    FOREIGN KEY(treatId) REFERENCES Treatments(treatId),
    FOREIGN KEY(docId) REFERENCES Doctors(docId),
    FOREIGN KEY(patId) REFERENCES Patients(patId),
    FOREIGN KEY(nurId) REFERENCES Nurses(nurId)
);

-- dummy 입력 부분
-- docID, docPass, majorTreat, docName, docGen, docPhone, docEmail, docPosition
SELECT * FROM Doctors;
INSERT INTO Doctors VALUES ('980312', '1', '소아과', '이태정', 'M', '010-333-1340', 'ltj@hanbh.com', '과장');
INSERT INTO Doctors VALUES ('000601', '1', '내과', '안성기', 'M', '011-222-0987', 'ask@hanbh.com', '과장');
INSERT INTO Doctors VALUES ('001208', '1', '외과', '김민종', 'M', '010-333-8743', 'kmj@hanbh.com', '과장');
INSERT INTO Doctors VALUES ('020403', '1', '피부과', '이태서', 'M', '019-777-3764', 'lts@hanbh.com', '과장');
INSERT INTO Doctors VALUES ('050900', '1', '소아과', '김연아', 'F', '010-555-3746', 'kya@hanbh.com', '전문의');
INSERT INTO Doctors VALUES ('050101', '1', '내과', '차태현', 'M', '011-222-7643', 'cth@hanbh.com', '전문의');
INSERT INTO Doctors VALUES ('062019', '1', '소아과', '전지현', 'F', '010-999-1265', 'jjh@hanbh.com', '전문의');
INSERT INTO Doctors VALUES ('070576', '1', '피부과', '홍길동', 'M', '016-333-7263', 'hgd@hanbh.com', '전문의');
INSERT INTO Doctors VALUES ('080543', '1', '방사선과', '유재석', 'M', '010-222-1263', 'yjs@hanbh.com', '과장');
INSERT INTO Doctors VALUES ('091001', '1', '외과', '김병만', 'M', '010-555-3542', 'kbm@hanbh.com', '전문의');

-- nurID, nurPass, majorJob, nurName, nurGen, nurPhone, nurEmail, nurPosition
SELECT * FROM  Nurses;
delete from nurses where nur_id = 91001;
INSERT INTO Nurses VALUES ('050302', '1', '소아과', '김은영', 'F', '010-555-8751', 'key@hanbh.com', '수간호사');
INSERT INTO Nurses VALUES ('050021', '1', '내과', '윤성애', 'F', '016-333-8745', 'ysa@hanbh.com', '수간호사');
INSERT INTO Nurses VALUES ('040089', '1', '피부과', '신지원', 'M', '010-666-7646', 'sjw@hanbh.com', '주임');
INSERT INTO Nurses VALUES ('070605', '1', '방사선과', '유정화', 'F', '010-333-4588', 'yjh@hanbh.com', '주임');
INSERT INTO Nurses VALUES ('070804', '1', '내과', '라하나', 'F', '010-222-1340', 'nhn@hanbh.com', '주임');
INSERT INTO Nurses VALUES ('071018', '1', '소아과', '김화경', 'F', '019-888-4116', 'khk@hanbh.com', '주임');
INSERT INTO Nurses VALUES ('100356', '1', '소아과', '이선용', 'M', '010-777-1234', 'lsy@hanbh.com', '간호사');
INSERT INTO Nurses VALUES ('104145', '1', '외과', '김현', 'M', '010-999-8520', 'kh@hanbh.com', '간호사');
INSERT INTO Nurses VALUES ('120309', '1', '피부과', '박성완', 'M', '010-777-4996', 'psw@hanbh.com', '간호사');
INSERT INTO Nurses VALUES ('130211', '1', '외과', '이서연', 'F', '010-222-3214', 'lsy2@hanbh.com', '간호사');

-- patID, nurID, docID, patPass, patName, patGen, patJumin, patAddr, patPhone, patEmail, patJob
SELECT * FROM Patients;
INSERT INTO Patients VALUES ('2345', '050302', '980312', '1', '안상건', 'M', '232345', '서울', '010-555-7845', 'ask@ab.com', '회사원');
INSERT INTO Patients VALUES ('3545', '040089', '020403', '1', '김성룡', 'M', '543545', '서울', '010-333-7812', 'ksr@bb.com', '자영업');
INSERT INTO Patients VALUES ('3424', '070605', '080543', '1', '이종진', 'M', '433424', '부산', '019-888-4859', 'ljj@ab.com', '회사원');
INSERT INTO Patients VALUES ('7675', '100356', '050900', '1', '최광석', 'M', '677675', '당진', '010-222-4847', 'cks@cc.com', '회사원');
INSERT INTO Patients VALUES ('4533', '070804', '000601', '1', '정한경', 'M', '744533', '강릉', '010-777-9630', 'jhk@ab.com', '교수');
INSERT INTO Patients VALUES ('5546', '120309', '070576', '1', '유원현', 'M', '765546', '대구', '016-777-0214', 'ywh@cc.com', '자영업');
INSERT INTO Patients VALUES ('4543', '070804', '050101', '1', '최재정', 'M', '454543', '부산', '010-555-4187', 'cjj@bb.com', '회사원');
INSERT INTO Patients VALUES ('9768', '130211', '091001', '1', '이진희', 'F', '119768', '서울', '010-888-3675', 'ljh@ab.com', '교수');
INSERT INTO Patients VALUES ('4234', '130211', '091001', '1', '오나미', 'F', '234234', '속초', '010-999-6541', 'onm@cc.com', '학생');
INSERT INTO Patients VALUES ('7643', '071018', '062019', '1', '송성묵', 'M', '987643', '서울', '010-222-5874', 'ssm@bb.com', '학생');

-- treatId, patId, docId, treatContents, treatDate
SELECT * FROM Treatments;
INSERT INTO Treatments VALUES ('130516023', '2345', '980312', '감기, 몸살', '2013-05-16');
INSERT INTO Treatments VALUES ('130628100', '3545', '020403', '피부 트러블 치료', '2013-06-28');
INSERT INTO Treatments VALUES ('131205056', '3424', '080543', '목 디스크로 MRI 촬영', '2013-12-05');
INSERT INTO Treatments VALUES ('131218024', '7675', '050900', '중이염', '2013-12-18');
INSERT INTO Treatments VALUES ('131224012', '4533', '000601', '장염', '2013-12-24');
INSERT INTO Treatments VALUES ('140103001', '5546', '070576', '여드름 치료', '2014-01-03');
INSERT INTO Treatments VALUES ('140109026', '4543', '050101', '위염', '2014-01-09');
INSERT INTO Treatments VALUES ('140226102', '9768', '091001', '화상치료', '2014-02-26');
INSERT INTO Treatments VALUES ('140303003', '4234', '091001', '교통사고 외상치료', '2014-03-03');
INSERT INTO Treatments VALUES ('140308087', '7643', '062019', '장염', '2014-03-08');

-- chartID, treatID, docID, nurID, patID, chartContent
SELECT * FROM Charts;
INSERT INTO Charts VALUES ('p_130516023', '130516023', '980312', '2345', '050302', '감기 주사 및 약 처방' );
INSERT INTO Charts VALUES ('d_130628100', '130628100', '020403', '3545', '040089', '피부 감염 방지 주사' );
INSERT INTO Charts VALUES ('r_131205056', '131205056', '080543', '3424', '070605', '주사 처방' );
INSERT INTO Charts VALUES ('p_131218024', '131218024', '050900', '7675', '100356', '귓속청소 및 약 처방' );
INSERT INTO Charts VALUES ('i_131224012', '131224012', '000601', '4533', '070804', '장염 입원치료' );
INSERT INTO Charts VALUES ('d_140103001', '140103001', '070576', '5546', '120309', '여드림 치료약 처방' );
INSERT INTO Charts VALUES ('i_140109026', '140109026', '050101', '4543', '070804', '위내시경' );
INSERT INTO Charts VALUES ('s_140226102', '140226102', '091001', '9768', '130211', '화상 크림약 처방' );
INSERT INTO Charts VALUES ('s_140303003', '140303003', '091001', '4234', '130211', '입원치료' );
INSERT INTO Charts VALUES ('p_140308087', '140308087', '062019', '7643', '071018', '장염 입원치료' );
                                                              
UPDATE Member SET password='3', name='parkjy' WHERE id='admin';