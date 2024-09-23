CREATE DATABASE demosql;
USE demosql;
CREAT TABLE myTable(id int AUTO_INCREMENT, name varchar(45) NOT NULL
	, PRIMARY KEY (id) );
INSERT INTO myTable (id, name) VALUES (null, 'bob');
INSERT INTO myTable (id, name) VALUES (null, 'alice');
INSERT INTO myTable (id, name) VALUES (null, 'john');
