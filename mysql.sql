CREATE TABLE `userlogin`.`service` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `timestamp` DATETIME NULL,
  `service_type` VARCHAR(45) NULL,
  `owner` VARCHAR(45) NULL,
  `room` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);


insert into service ( service_type, owner, room) values ('cleaning', '', 301);
insert into service ( service_type, owner, room) values ('cleanning','', '401');
insert into service ( service_type, owner, room) values ('cleanning','', '501');
insert into service ( service_type, owner, room) values ('cleanning','', '601');
insert into service ( service_type, owner, room) values ('cleanning','', '402');


select * from service;

