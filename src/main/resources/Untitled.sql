DROP DATABASE labyrinth_db;

CREATE   DATABASE IF NOT EXISTS labyrinth_db;

USE labyrinth_db;

CREATE TABLE IF NOT EXISTS labyrinth (
	id INT AUTO_INCREMENT NOT NULL,
	create_date DATE NOT NULL,
    delete_date DATE,
    labyrinth_name VARCHAR(255),
    route_color VARCHAR(6),
    wall_color VARCHAR(6),
    x INT NOT NULL,
    y INT NOT NULL,
    map VARCHAR(1024),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS robot (
	id INT AUTO_INCREMENT NOT NULL,
    create_date DATE NOT NULL,
    delete_date DATE,
    robot_name VARCHAR(255) NOT NULL,
    color VARCHAR(6),
    x INT NOT NULL,
    y INT NOT NULL,
    labirynth_id INT,
	PRIMARY KEY(id),

	FOREIGN KEY(labirynth_id)
	REFERENCES labirynth(id)
);