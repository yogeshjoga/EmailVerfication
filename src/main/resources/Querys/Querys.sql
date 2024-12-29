SET SQL_SAFE_UPDATES = 0;
SET SQL_SAFE_UPDATES = 1;
DELETE FROM otps;
Select * from otps;

SELECT email, COUNT(*) as cnt FROM otps GROUP BY email HAVING cnt > 1;
DELETE u1 FROM otps u1 INNER JOIN otps u2 WHERE u1.email = u2.email;
create database email;