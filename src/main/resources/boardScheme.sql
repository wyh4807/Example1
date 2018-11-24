CREATE TABLE board (
	board_IDX INT AUTO_INCREMENT,
	board_DLT BOOLEAN DEFAULT 0,
	board_PWD VARCHAR(30) NOT NULL,
	board_TITLE VARCHAR(30) NOT NULL,
	board_CONTENT CLOB NOT NULL,
	PRIMARY KEY (board_IDX)
);


INSERT INTO board(board_PWD, board_TITLE, board_CONTENT) VALUES('1234', '첫 글 입니다.', '안녕하세요1');
INSERT INTO board(board_PWD, board_TITLE, board_CONTENT) VALUES('1234', '두번째 글 입니다.', '안녕하세요2');
INSERT INTO board(board_PWD, board_TITLE, board_CONTENT) VALUES('1234', '세번쨰 글 입니다.', '안녕하세요3');
INSERT INTO board(board_PWD, board_TITLE, board_CONTENT) VALUES('1234', '네번째 글 입니다.', '안녕하세요4');
