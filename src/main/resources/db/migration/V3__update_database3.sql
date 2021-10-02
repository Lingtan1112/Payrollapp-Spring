drop view employee_list_view;

create or replace view employee_list_view as(
select s_no, name, first_name , gender,role, mobile_number, employee_id, joined_date from employee_data where active_status=1 order by joined_date desc);



