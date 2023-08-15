SELECT
    E.FNAME,
    E.LNAME
FROM
    EMPLOYEE E
WHERE
    E.WORKSTATUS = 'W'
    AND E.SALARY < (
        SELECT
            AVG(E.SALARY)
        FROM
            EMPLOYEE S
        WHERE
            E.WORKSTATUS = 'W'
            AND S.DEPTCODE = E.DEPTCODE
        GROUP BY
            S.DEPTCODE
    )