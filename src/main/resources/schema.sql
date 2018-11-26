drop table User if exists;
drop table Car if exists;
drop table repair_case if exists;
drop table  historyItem if exists;

create table if not exists User (
    ID int PRIMARY KEY AUTO_INCREMENT,
    SURNAME varchar(40),
    NAME varchar(40),
    ROLE varchar(40),
    CREATED_DATE date,
    LINK_GOOGLE varchar(40),
    LOGIN varchar(40),
    PASSWORD varchar(40)
);

create table if not exists car(
    id int PRIMARY KEY AUTO_INCREMENT,
    owner_id int,
    make varchar(30),
    car_number varchar(40),
    model varchar(40),
    color varchar(30),
    year int,
    vin varchar(40),
    FOREIGN KEY (owner_id) REFERENCES user(id)
);

create table if not exists repair_case (
    ID int PRIMARY KEY AUTO_INCREMENT,
    case_id int,
    car_id int,
    user_id int,
    name varchar(40),
    description varchar(256),
    start_date date,
    end_date date,
    case_status varchar(40),
    FOREIGN KEY (car_id) REFERENCES car(ID),
    FOREIGN KEY (user_id) REFERENCES user(ID),
    FOREIGN KEY (case_id) REFERENCES repair_case(ID)
);

create table if not exists historyItem (
    ID int PRIMARY KEY AUTO_INCREMENT,
    case_id int,
    status varchar(40),
    changeDate date,
    FOREIGN KEY (case_id) REFERENCES repair_case(ID)
);


