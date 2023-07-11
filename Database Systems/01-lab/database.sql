-- Searching All Tables in a Database
SELECT
    *
FROM
    TAB;

-- SETCOUNTRY
-- SETPROVINCE
-- SETPART
-- DEPARTMENT
-- EMPLOYEE

-- On Lab
SELECT
    EMPNO,
    FNAME,
    SEX,
    SALARY,
    WORKSTATUS,
    EMPLOYEE.DEPTCODE,
    DEPTNAME,
    SCTCODE,
    SCTTNAME,
    SPRCODE,
    SPRTNAME,
    SPVCODE,
    SPVTNAME
FROM
    EMPLOYEE
    INNER JOIN DEPARTMENT
    ON EMPLOYEE.DEPTCODE = DEPARTMENT.DEPTCODE
    INNER JOIN SETPROVINCE
    ON EMPLOYEE.SPVCODE = SETPROVINCE.SPVCODE
    INNER JOIN SETPART
    ON SETPROVINCE.SPVSPRCODE = SETPART.SPRCODE
    INNER JOIN SETCOUNTRY
    ON SETPART.SPRSCTCODE = SETCOUNTRY.SCTCODE
ORDER BY
    EMPNO ASC;