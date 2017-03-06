-- seq, pat_id, title, content, regdate, read_count
DROP TABLE Article;
DROP SEQUENCE art_seq;

-- CREATE SEQUENCE art_seq
CREATE SEQUENCE art_seq
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

-- CREATE
CREATE TABLE Article (
	art_seq DECIMAL NOT NULL,
	pat_id VARCHAR2(10) NOT NULL,
	title VARCHAR2(30) NOT NULL,
	content VARCHAR2(100) NOT NULL,
	regdate VARCHAR2(30) NOT NULL,
	read_count VARCHAR2(5) NOT NULL,
	PRIMARY KEY(art_seq),
    FOREIGN KEY(pat_id) REFERENCES Patient(pat_id)
);
-- INSERT 
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'pahn',   'Hi','Hello my friends','2017-02-15 10:00:00','3');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'pkim',   'Second','MY SECOND ARTICLE','2017-02-15 12:00:00','5');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'plee',   'Third','MY THIRD ARTICLE','2017-02-16 01:00:00','7');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'pchoi',  'Forth','MY FOUTH ARTICLE','2017-02-17 02:00:00','4');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'pjeong', 'Fifth','MY FIFTH ARTICLE','2017-02-19 03:00:00','2');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'pyou',   'Hi2','Hello my friends2','2017-02-15 10:00:00','3');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'pchoi2', 'Second2','MY SECOND ARTICLE2','2017-02-15 12:00:00','5');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'plee2',  'Third2','MY THIRD ARTICLE2','2017-02-16 01:00:00','7');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'poh',    'Forth2','MY FOUTH ARTICLE2','2017-02-17 02:00:00','4');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'psong',  'Fifth2','MY FIFTH ARTICLE2','2017-02-19 03:00:00','2');

INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'pahn',   'Hi','Hello my friends','2017-02-15 10:00:00','3');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'pkim',   'Second','MY SECOND ARTICLE','2017-02-15 12:00:00','5');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'plee',   'Third','MY THIRD ARTICLE','2017-02-16 01:00:00','7');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'pchoi',  'Forth','MY FOUTH ARTICLE','2017-02-17 02:00:00','4');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'pjeong', 'Fifth','MY FIFTH ARTICLE','2017-02-19 03:00:00','2');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'pyou',   'Hi2','Hello my friends2','2017-02-15 10:00:00','3');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'pchoi2', 'Second2','MY SECOND ARTICLE2','2017-02-15 12:00:00','5');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'plee2',  'Third2','MY THIRD ARTICLE2','2017-02-16 01:00:00','7');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'poh',    'Forth2','MY FOUTH ARTICLE2','2017-02-17 02:00:00','4');
INSERT INTO Article(art_seq, pat_id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'psong',  'Fifth2','MY FIFTH ARTICLE2','2017-02-19 03:00:00','2');


-- READ ALL
SELECT * FROM Article;

SELECT t2.* FROM (SELECT ROWNUM seq,t.* FROM (SELECT * FROM Article ORDER BY art_seq DESC) t) t2 WHERE t2.seq BETWEEN 6 AND 10;

-- READ SOME
SELECT * FROM Article WHERE pat_id='babungv' OR title like '%Sec%';

-- READ ONE
SELECT * FROM Article WHERE art_seq=1;

-- UPDATE
UPDATE Article SET title='TITLE CHANGED', content='CONTENT CHANGED', regdate='NOW DATE' WHERE art_seq=1;

-- DELETE
DELETE FROM Article WHERE art_seq=1;
