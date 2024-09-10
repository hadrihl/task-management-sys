create table user (
	id int not null auto_increment,
	username varchar(200) not null,
	email varchar(200) not null,
	password varchar(64) not null,
	primary key (id)
);