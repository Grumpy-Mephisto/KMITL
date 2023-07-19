-- Left Outer Join: Used to return all rows from the left table, and the matched rows from the right table
SELECT
    *
FROM
    EMPLOYEE
    LEFT OUTER JOIN SETPROVINCE
    ON EMPLOYEE.SPVCODE = SETPROVINCE.SPVCODE