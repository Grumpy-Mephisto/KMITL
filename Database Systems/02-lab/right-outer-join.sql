-- Right Outer Join: Used to return all rows from the right table, and the matched rows from the left table
SELECT
    *
FROM
    EMPLOYEE
    RIGHT OUTER JOIN SETPROVINCE
    ON EMPLOYEE.SPVCODE = SETPROVINCE.SPVCODE