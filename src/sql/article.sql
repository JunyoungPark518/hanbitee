-- seq, id, title, content, regdate, read_count
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
	id VARCHAR2(10) NOT NULL,
	title VARCHAR2(30) NOT NULL,
	content VARCHAR2(1000) NOT NULL,
	regdate VARCHAR2(30) NOT NULL,
	read_count VARCHAR2(5) NOT NULL,
	PRIMARY KEY(art_seq)
);
-- INSERT 
INSERT INTO Article(art_seq, id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'babungv','Hi','Hello my friends','2017-02-15 10:00:00','3');
INSERT INTO Article(art_seq, id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'babungv','Second','MY SECOND ARTICLE','2017-02-15 12:00:00','5');
INSERT INTO Article(art_seq, id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'babungv','Third','MY THIRD ARTICLE','2017-02-16 01:00:00','7');
INSERT INTO Article(art_seq, id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'babungv','Forth','MY FOUTH ARTICLE','2017-02-17 02:00:00','4');
INSERT INTO Article(art_seq, id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'babungv','Fifth','MY FIFTH ARTICLE','2017-02-19 03:00:00','2');
INSERT INTO Article(art_seq, id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'admin','Hi2','Hello my friends2','2017-02-15 10:00:00','3');
INSERT INTO Article(art_seq, id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'kkk','Second2','MY SECOND ARTICLE2','2017-02-15 12:00:00','5');
INSERT INTO Article(art_seq, id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'pjy','Third2','MY THIRD ARTICLE2','2017-02-16 01:00:00','7');
INSERT INTO Article(art_seq, id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'yhs','Forth2','MY FOUTH ARTICLE2','2017-02-17 02:00:00','4');
INSERT INTO Article(art_seq, id, title, content, regdate, read_count) VALUES (art_seq.nextval, 'byj','Fifth2','MY FIFTH ARTICLE2','2017-02-19 03:00:00','2');

-- READ ALL
SELECT * FROM Article;

-- READ SOME
SELECT * FROM Article WHERE id='babungv' OR title like '%Sec%';

-- READ ONE
SELECT * FROM Article WHERE art_seq=1;

-- UPDATE
UPDATE Article SET title='TITLE CHANGED', content='CONTENT CHANGED', regdate='NOW DATE' WHERE art_seq=1;

-- DELETE
DELETE FROM Article WHERE art_seq=1;
