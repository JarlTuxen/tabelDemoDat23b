# Murach kapitel 18
CREATE USER bookstoreuser@localhost IDENTIFIED BY 'Dat23B';
GRANT SELECT, INSERT, DELETE, UPDATE
    ON bookstore.*
    TO bookstoreuser@localhost;
SHOW GRANTS FOR bookstoreuser@localhost