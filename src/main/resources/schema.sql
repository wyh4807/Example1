create table if not exists board (board_IDX INT AUTO_INCREMENT,	board_DLT BOOLEAN DEFAULT 0, board_PWD VARCHAR(30) NOT NULL, board_TITLE VARCHAR(30) NOT NULL, board_CONTENT CLOB NOT NULL,	PRIMARY KEY(board_IDX));