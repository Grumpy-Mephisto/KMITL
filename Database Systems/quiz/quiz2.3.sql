SELECT
    D.DEPTCODE,
    D.DEPTNAME,
    S.SUPEREMPNO,
    S.FNAME      AS SUPERVISOR_NAME,
    E.EMPNO,
    E.FNAME      AS EMPLOYEE_NAME,
    E.SEX,
    E.SALARY
FROM
    EMPLOYEE   E
    INNER JOIN DEPARTMENT D
    ON E.DEPTCODE = D.DEPTCODE
    LEFT JOIN EMPLOYEE S
    ON E.SUPEREMPNO = S.SUPEREMPNO
WHERE
    E.WORKSTATUS = 'W'
ORDER BY
    D.DEPTCODE, E.EMPNO;