-- Inner Join: used to select rows from multiple tables based on a matching column in one or more tables.
SELECT
    *
FROM
    EMPLOYEE
    INNER JOIN SETPROVINCE
    ON EMPLOYEE.SPVCODE = SETPROVINCE.SPVCODE