SELECT
    *
FROM
    EMPLOYEE
    INNER JOIN DEPARTMENT
    ON EMPLOYEE.DEPTCODE = DEPARTMENT.DEPTCODE
    INNER JOIN SETPROVINCE
    ON EMPLOYEE.SPVCODE = SETPROVINCE.SPVCODE
    INNER JOIN SETPART
    ON SETPROVINCE.SPVSPRCODE = SETPART.SPRCODE