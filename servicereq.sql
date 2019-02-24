drop table csc505.servicereq;

CREATE TABLE csc505.servicereq (
  roomservice    varchar(25) not null, 
  servicetime    varchar(25) not null,
  roomnumber     varchar(25) not null,
  yname			 varchar(25) not null,
  primary key (username, password)  
);

select * from csc505.servicereq;