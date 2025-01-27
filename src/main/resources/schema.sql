DROP TABLE IF EXISTS tasks;
CREATE TABLE tasks(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
	content VARCHAR(50) NOT NULL,
    done BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);