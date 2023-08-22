SELECT
    E.FNAME,
    E.LNAME
FROM
    EMPLOYEE E
WHERE
    E.WORKSTATUS = 'W'
    AND E.SALARY < (
        SELECT
            AVG(S.SALARY)
        FROM
            EMPLOYEE S
        WHERE
            S.WORKSTATUS = 'W'
            AND S.DEPTCODE = E.DEPTCODE
        GROUP BY
            S.DEPTCODE
    )