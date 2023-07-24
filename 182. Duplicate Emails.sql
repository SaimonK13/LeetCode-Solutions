#Solution 1
SELECT Email
FROM
    (SELECT email AS Email, COUNT(id) AS Total
    FROM Person
    GROUP BY email) AS t2
WHERE Total > 1;

#Solution 2
SELECT Email
FROM Person
GROUP BY Email
HAVING COUNT(Email) > 1;
