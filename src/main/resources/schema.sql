drop table User if exists;
drop table repairCase if exists;
drop table  historyItem if exists;

create table if not exists User (
    ID int PRIMARY KEY AUTO_INCREMENT,
    SURNAME varchar(40),
    NAME varchar(40),
    ROLE varchar(40)
);

create table if not exists repairCase (
    ID int PRIMARY KEY AUTO_INCREMENT,
    name varchar(40),
    description varchar(256),
    startDate date,
    endDate date
);

create table if not exists historyItem (
    ID int PRIMARY KEY AUTO_INCREMENT,
    caseID int,
    status varchar(40),
    changeDate date,
    FOREIGN KEY (caseID) REFERENCES repairCase(ID)
);


