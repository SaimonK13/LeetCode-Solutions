/*
  Name: Customers Who Never Order (LeetCode Problem #183)
*/ 

SELECT name AS Customers
FROM Customers
LEFT JOIN Orders
ON Customers.Id = Orders.customerId
WHERE Orders.id IS NULL;
