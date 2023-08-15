SELECT
    E.FNAME,
    E.LNAME,
    E.SALARY
FROM
    EMPLOYEE E
WHERE
    E.WORKSTATUS = 'W'
    AND E.SALARY = (
        SELECT
            MAX(SALARY)
        FROM
            EMPLOYEE
        WHERE
            SALARY < (
                SELECT
                    MAX(SALARY)
                FROM
                    EMPLOYEE
            )
    )
ORDER BY
    E.SALARY DESC;