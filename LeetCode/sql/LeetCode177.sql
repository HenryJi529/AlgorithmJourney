CREATE FUNCTION getNthHighestSalary(N INT) RETURNS 
INT 
BEGIN 
declare
	M int;
	select N -1 into M;
	RETURN (
	    # Write your MySQL query statement below.
	    select distinct
	        salary
	    from Employee
	    order by salary desc
	    limit 1
	    offset
	        M
	);
END
