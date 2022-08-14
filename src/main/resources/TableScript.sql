drop database if exists task_db;
create database task_db;

use task_db;

create table task(
    task_id int auto_increment,
    task_name varchar(20),
    task_date date,
    constraint ps_task_id_pk primary key (task_id)
);

commit;
