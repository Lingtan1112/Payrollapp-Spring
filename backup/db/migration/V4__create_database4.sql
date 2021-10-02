create or replace view employee_payslip as(
	select e.name,mobile_number,employee_id,e.role,p.basic_pay,p.basic_pay*12 
	as annual_basic_pay,hra,hra*12 as annual_hra,pf ,pf*12 as annual_pf,medical_allowance, 
	medical_allowance*12 as annual_medical_allowance,food_allowance, 
	food_allowance*12 as annual_food_allowance,travel_allowance, 
	travel_allowance*12 as annual_travel_allowance ,
	salary, salary*12 as annual_salary ,
	ctc, ctc*12 as annual_ctc from employee_data e, 
	payroll_data p where (e.role = p.role));

