drop table csc505.userlogin;

CREATE TABLE csc505.userlogin (
  username    varchar(15) not null, 
  password    varchar(15) not null,
  role    varchar(15) not null,
  primary key (username, password)  
);

INSERT INTO csc505.userlogin VALUES ('CSC507', 'Spring2019','Employer');
INSERT INTO csc505.userlogin VALUES ('empuser1', 'Spring2019','Employer');
INSERT INTO csc505.userlogin VALUES ('empuser2', 'Spring2019','Employer');
INSERT INTO csc505.userlogin VALUES ('custuser1', 'Spring2019','Customer');
INSERT INTO csc505.userlogin VALUES ('custuser2', 'Spring2019','Customer');
INSERT INTO csc505.userlogin VALUES ('manager1', 'Spring2019','Manager');
INSERT INTO csc505.userlogin VALUES ('manager2', 'Spring2019','Manager');

select * from csc505.userlogin;