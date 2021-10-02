create table employee_data(
s_no serial primary key,
first_name varchar(50),
last_name varchar(50),
name varchar(70),
employee_id varchar(70),
mobile_number bigint not null,
email_id varchar(70) not null,
role varchar(70),
dob date not null,
joined_date date not null,
password varchar(70) not null,
gender varchar(70),
active_status int not null) ;


create or replace view employee_list_view as(
select s_no, name, first_name , gender,role, employee_id, joined_date from employee_data where active_status=1 order by joined_date desc);


create table payroll_data(
basic_pay int default(0),
hra int default(0),
medical_allowance int default(0),
pf int default(0),
food_allowance int default(0),
travel_allowance int default(0), 
role varchar(50) default(0),
pf_percentage numeric(3) default(0),
salary int default(0),
ctc int default(0));


create table user_data(
username varchar(50),
password varchar(50));


insert into user_data 
(username, password)
values ('Ling12007','@Lingtan1112');

insert into payroll_data (basic_pay, hra, pf, medical_allowance, travel_allowance , food_allowance, pf_percentage, salary, ctc,role) values (0,0,0,0,0,0,0,0,0,'Technical Consultant');
insert into payroll_data (basic_pay, hra, pf, medical_allowance, travel_allowance , food_allowance, pf_percentage, salary, ctc,role) values (0,0,0,0,0,0,0,0,0,'HR');
insert into payroll_data (basic_pay, hra, pf, medical_allowance, travel_allowance , food_allowance, pf_percentage, salary, ctc,role) values (0,0,0,0,0,0,0,0,0,'Software Developer');
insert into payroll_data (basic_pay, hra, pf, medical_allowance, travel_allowance , food_allowance, pf_percentage, salary, ctc,role) values (0,0,0,0,0,0,0,0,0,'Ui-Designer');
insert into payroll_data (basic_pay, hra, pf, medical_allowance, travel_allowance , food_allowance, pf_percentage, salary, ctc,role) values (0,0,0,0,0,0,0,0,0,'PL SQL');
insert into payroll_data (basic_pay, hra, pf, medical_allowance, travel_allowance , food_allowance, pf_percentage, salary, ctc,role) values (0,0,0,0,0,0,0,0,0,'System Administration');




