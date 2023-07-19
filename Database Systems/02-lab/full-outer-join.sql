-- Full Outer Join: Used to return all rows from both tables, regardless of whether or not they match. If there are rows in "Table A" that do not have matches in "Table B", or if there are rows in "Table B" that do not have matches in "Table A", those rows will be listed as well.
SELECT
    *
FROM
    EMPLOYEE
    FULL OUTER JOIN SETPROVINCE
    ON EMPLOYEE.SPVCODE = SETPROVINCE.SPVCODE