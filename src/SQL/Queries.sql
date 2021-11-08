--1) List all the columns of the Salespeople table.
select * from salespeople;
+------+---------+-----------+------+
| SNUM | SNAME   | CITY      | COMM |
+------+---------+-----------+------+
| 1001 | Peel    | London    | 12   |
| 1002 | Serres  | Sanjose   | 13   |
| 1003 | AxelRod | New York  | 10   |
| 1004 | Motika  | London    | 11   |
| 1007 | Rifkin  | Barcelona | 15   |
| 1008 | Fran    | London    | 25   |
+------+---------+-----------+------+

--2) List all customers with a rating of 100.
select * from customers where RATING > 100;
+------+----------+---------+--------+------+
| CNUM | CNAME    | CITY    | RATING | SNUM |
+------+----------+---------+--------+------+
| 2002 | Giovanni | Rome    |    200 | 1003 |
| 2003 | Liu      | SanJose |    200 | 1002 |
| 2004 | Grass    | Berlin  |    300 | 1002 |
| 2006 | Cisneros | SanJose |    300 | 1007 |
+------+----------+---------+--------+------+

--3) Find the largest order taken by each salesperson on each date.
--4) Arrange the Order table by descending customer number.
select * from orders order by CNUM desc;
+------+---------+------------+------+------+
| ONUM | AMT     | ODATE      | CNUM | SNUM |
+------+---------+------------+------+------+
| 3001 |   18.69 | 1990-03-10 | 2008 | 1007 |
| 3006 | 1098.16 | 1990-03-10 | 2008 | 1007 |
| 3002 |  1900.1 | 1990-03-10 | 2007 | 1004 |
| 3008 |    4732 | 1090-05-10 | 2006 | 1001 |
| 3011 | 9891.88 | 1990-05-10 | 2006 | 1001 |
| 3007 |   75.75 | 1990-04-10 | 2004 | 1002 |
| 3010 | 1309.95 | 1990-05-10 | 2004 | 1002 |
| 3005 | 5160.45 | 1990-03-10 | 2003 | 1002 |
| 3009 | 1713.23 | 1990-04-10 | 2002 | 1003 |
| 3003 |  767.19 | 1990-03-10 | 2001 | 1001 |
+------+---------+------------+------+------+

--5) Find which salespeople currently have orders in the order table.
select distinct(SNAME) from salespeople, orders where salespeople.SNUM = orders.SNUM;
+---------+
| SNAME   |
+---------+
| Rifkin  |
| Motika  |
| Peel    |
| Serres  |
| AxelRod |
+---------+

--6) List names of all customers matched with the salespeople serving them.
--7) Find the names and numbers of all salespeople who have more than one customer.
select SNAME, COMM from salespeople where COMM > 2;
+---------+------+
| SNAME   | COMM |
+---------+------+
| Peel    | 12   |
| Serres  | 13   |
| AxelRod | 10   |
| Motika  | 11   |
| Rifkin  | 15   |
| Fran    | 25   |
+---------+------+

--8) Count the orders of each of the salespeople and output the results in descending order.
Select orders.SNUM, salespeople.SNAME, COUNT(orders.SNUM) as TOTAL_COUNT from orders, salespeople where orders.SNUM = salespeople.SNUM Group By orders.SNUM  Order by TOTAL_COUNT DESC;
+------+---------+-------+
| SNUM | SNAME   | COUNT |
+------+---------+-------+
| 1001 | Peel    |     3 |
| 1002 | Serres  |     3 |
| 1007 | Rifkin  |     2 |
| 1003 | AxelRod |     1 |
| 1004 | Motika  |     1 |
+------+---------+-------+

--9) List the customer table if and only if one or more of the customers in the Customer table are located in SanJose.
--10) Match salespeople to customers according to what city they live in.
Select salespeople.sname, customers.cname, customers.city from salespeople, customers where salespeople.CITY = Customers.CITY;
+--------+----------+---------+
| sname  | cname    | city    |
+--------+----------+---------+
| Peel   | Hoffman  | London  |
| Motika | Hoffman  | London  |
| Fran   | Hoffman  | London  |
| Serres | Liu      | SanJose |
| Peel   | Clemens  | London  |
| Motika | Clemens  | London  |
| Fran   | Clemens  | London  |
| Serres | Cisneros | SanJose |
+--------+----------+---------+

--11) Find all the customers in SanJose who have a rating above 200.
select * from customers where CITY = 'SanJose' and rating > 200;
+------+----------+---------+--------+------+
| CNUM | CNAME    | CITY    | RATING | SNUM |
+------+----------+---------+--------+------+
| 2006 | Cisneros | SanJose |    300 | 1007 |
+------+----------+---------+--------+------+

--12) List the names and commissions of all salespeople in London.
select salespeople.sname, salespeople.comm from salespeople;
+---------+------+
| sname   | comm |
+---------+------+
| Peel    | 12   |
| Serres  | 13   |
| AxelRod | 10   |
| Motika  | 11   |
| Rifkin  | 15   |
| Fran    | 25   |
+---------+------+

--13) List all the orders of Salesperson Motika from the orders table.
select * from orders, salespeople where salespeople.sname = 'Motika';
+------+---------+------------+------+------+------+--------+--------+------+
| ONUM | AMT     | ODATE      | CNUM | SNUM | SNUM | SNAME  | CITY   | COMM |
+------+---------+------------+------+------+------+--------+--------+------+
| 3001 |   18.69 | 1990-03-10 | 2008 | 1007 | 1004 | Motika | London | 11   |
| 3002 |  1900.1 | 1990-03-10 | 2007 | 1004 | 1004 | Motika | London | 11   |
| 3003 |  767.19 | 1990-03-10 | 2001 | 1001 | 1004 | Motika | London | 11   |
| 3005 | 5160.45 | 1990-03-10 | 2003 | 1002 | 1004 | Motika | London | 11   |
| 3006 | 1098.16 | 1990-03-10 | 2008 | 1007 | 1004 | Motika | London | 11   |
| 3007 |   75.75 | 1990-04-10 | 2004 | 1002 | 1004 | Motika | London | 11   |
| 3008 |    4732 | 1090-05-10 | 2006 | 1001 | 1004 | Motika | London | 11   |
| 3009 | 1713.23 | 1990-04-10 | 2002 | 1003 | 1004 | Motika | London | 11   |
| 3010 | 1309.95 | 1990-05-10 | 2004 | 1002 | 1004 | Motika | London | 11   |
| 3011 | 9891.88 | 1990-05-10 | 2006 | 1001 | 1004 | Motika | London | 11   |
+------+---------+------------+------+------+------+--------+--------+------+

--14) Find all customers who booked orders on October 3.
select cname from customers, orders where customers.cnum = orders.cnum AND ODATE = '1990-03-10';
+---------+
| cname   |
+---------+
| Pereira |
| Hoffman |
| Liu     |
+---------+

--15) Give the sums of the amounts from the Orders table, grouped by date, eliminating all those dates where the SUM was not at least 2000 above the maximum Amount.
--16) Select all orders that had amounts that were greater than at least one of the orders from October 6.
select * from orders where AMT > (select min(AMT) from Orders where ODATE = '1990-04-10');
+------+---------+------------+------+------+
| ONUM | AMT     | ODATE      | CNUM | SNUM |
+------+---------+------------+------+------+
| 3002 |  1900.1 | 1990-03-10 | 2007 | 1004 |
| 3003 |  767.19 | 1990-03-10 | 2001 | 1001 |
| 3005 | 5160.45 | 1990-03-10 | 2003 | 1002 |
| 3006 | 1098.16 | 1990-03-10 | 2008 | 1007 |
| 3008 |    4732 | 1090-05-10 | 2006 | 1001 |
| 3009 | 1713.23 | 1990-04-10 | 2002 | 1003 |
| 3010 | 1309.95 | 1990-05-10 | 2004 | 1002 |
| 3011 | 9891.88 | 1990-05-10 | 2006 | 1001 |
+------+---------+------------+------+------+

--17) Write a query that uses the EXISTS operator to extract all salespeople who have customers with a rating of 300.
--18) Find all customers whose cnum is 1000 above the snum of Serres.
--19) Give the salespeople’s commissions as percentages instead of decimal numbers.
--20) Find the largest order taken by each salesperson on each date, eliminating those Maximum orders, which are less than 3000.
--21) List all the largest orders for October 3, for each salesperson.
--22) Find all customers located in cities where Serres has customers.

--23) Select all customers with a rating above 200.
select * from CUSTOMERS where RATING > 200;
+------+----------+---------+--------+------+
| CNUM | CNAME    | CITY    | RATING | SNUM |
+------+----------+---------+--------+------+
| 2004 | Grass    | Berlin  |    300 | 1002 |
| 2006 | Cisneros | SanJose |    300 | 1007 |
+------+----------+---------+--------+------+

--24) Count the number of salespeople currently having orders in the orders table.
SELECT COUNT(Distinct(orders.SNUM)) as totalCount FROM salespeople, orders where salespeople.snum = orders.snum;
+------------+
| totalCount |
+------------+
|          5 |
+------------+
--25) Write a query that produces all customers serviced by salespeople with a commission above 12%. Output the customer’s name, salesperson’s name and the salesperson’s rate of commission.
--26) Find salespeople who have multiple customers.
--27) Find salespeople with customers located in their own cities.
--28) Find all salespeople whose name starts with ‘P’ and fourth character is ‘I’.
--29) Write a query that uses a subquery to obtain all orders for the customer named ‘Cisneros’. Assume you do not know his customer number.
--30) Find the largest orders for Serres and Rifkin.
--31) Sort the salespeople table in the following order: snum, sname, commission, city.
--32) Select all customers whose names fall in between ‘A’ and ‘G’ alphabetical range.
select * from customers WHERE cname >= 'A' AND cname <='H';
+------+----------+---------+--------+------+
| CNUM | CNAME    | CITY    | RATING | SNUM |
+------+----------+---------+--------+------+
| 2002 | Giovanni | Rome    |    200 | 1003 |
| 2004 | Grass    | Berlin  |    300 | 1002 |
| 2005 | Clemens  | London  |    100 | 1001 |
| 2006 | Cisneros | SanJose |    300 | 1007 |
+------+----------+---------+--------+------+

--33) Select all the possible combinations of customers you can assign.
--34) Select all orders that are greater than the average for October 4.
--35) Write a select command using correlated subquery that selects the names and numbers of all customers with ratings equal to the maximum for their city.
--36) Write a query that totals the orders for each day and places the results in descending order.
--37) Write a select command that produces the rating followed by the name of each customer in SanJose.
--38) Find all orders with amounts smaller than any amount for a customer in SanJose.
--39) Find all orders with above average amounts for their customers.
--40) Write a query that selects the highest rating in each city.
--41) Write a query that calculates the amount of the salesperson’s commission on each order by a customer with a rating above 100.00.
--42) Count the customers with ratings above SanJose’s average.
--43) Find all salespeople that are located in either Barcelona or London.
select * from salespeople where CITY in ('Barcelona', 'London');
+------+--------+-----------+------+
| SNUM | SNAME  | CITY      | COMM |
+------+--------+-----------+------+
| 1001 | Peel   | London    | 12   |
| 1004 | Motika | London    | 11   |
| 1007 | Rifkin | Barcelona | 15   |
| 1008 | Fran   | London    | 25   |
+------+--------+-----------+------+

--44) Find all salespeople with only one customer.
--45) Write a query that joins the Customer table to itself to find all pairs or customers served by a single salesperson.
--46) Write a query that will give you all orders for more than $1000.00.
--47) Write a query that lists each order number followed by the name of the customer who made that order.
--48) Write a query that selects all the customers whose ratings are equal to or greater than ANY(in the SQL sense) of ‘Serres’.
--49) Write two queries that will produce all orders taken on October 3 or October 4.
--50) Find only those customers whose ratings are higher than every customer in Rome.
select * from customers where Rating > (select RATING from customers where CITY = 'Rome');
--51) Write a query on the Customers table whose output will exclude all customers with a rating<= 100.00, unless they are located in Rome.
--52) Find all rows from the customer’s table for which the salesperson number is 1001.
--53) Find the total amount in orders for each salesperson where their total of amounts are greater than the amount of the largest order in the table.
--54) Write a query that selects all orders save those with zeroes or NULL in the amount file.
--55) Produce all combinations of salespeople and customer names such that the former precedes the latter alphabetically, and the latter has a rating of less than 200.
--56) Find all salespeople name and commission.
--57) Write a query that produces the names and cities of all customers with the same rating as Hoffman. Write the query using Hoffman’s cnum rather than his rating, so that it would still be usable if his rating is changed.
--58) Find all salespeople for whom there are customers that follow them in alphabetical order.
--59) Write a query that produces the names and ratings of all customers who have average orders.
--60) Find the SUM of all Amounts from the orders table.
--61) Write a SELECT command that produces the order number, amount, and the date from rows in the order table.
--62) Count the number of non NULL rating fields in the Customers table (including repeats).
--63) Write a query that gives the names of both the salesperson and the customer for each order after the order number.
--64) List the commissions of all salespeople servicing customers in London.
--65) Write a query using ANY or ALL that will find all salespeople who have no customers located in their city.
--66) Write a query using the EXISTS operator that selects all salespeople with customers located in their cities who are not assigned to them.
--67) Write a query that selects all customers serviced by Peel or Motika. (Hint: The snum field relates the 2 tables to one another.)
--68) Count the number of salespeople registering orders for each day. (If a salesperson has more than one order on a given day, he or she should be counted only once.)
--69) Find all orders attributed to salespeople who live in London.
--70) Find all orders by customers not located in the same cities as their salespeople.
--71) Find all salespeople who have customers with more than one current order.
--72) Write a query that extracts from the customer’s table every customer assigned to a salesperson, who is currently having at least one another customer(besides the customer being selected) with orders in the Orders Table.
--73) Write a query on the customer’s table that will find the highest rating in each city. Put the output in this form: for the city (city), the highest rating is (rating).
--74) Write a query that will produce the snum values of all salespeople with orders, having amt greater than 1000 in the Orders Table(without repeats).
--75) Write a query that lists customers in a descending order of rating. Output the rating field first, followed by the customer’s names and numbers.
--76) Find the average commission for salespeople in London.
--77) Find all orders credited to the same salesperson who services Hoffman.(cnum 2001).
--78) Find all salespeople whose commission is in between 0.10 and 0.12(both inclusive).
--79) Write a query that will give you the names and cities of all salespeople in London with a commission above 0.10.
--80) Write a query that selects each customer’s smallest order.
--81) Write a query that selects the first customer in alphabetical order whose name begins with ‘G’.
--82) Write a query that counts the number of different non NULL city values in the customers table.
--83) Find the average amount from the Orders Table.
--84) Find all customers who are not located in SanJose and whose rating is above 200.
--85) Give a simpler way to write this query.SELECT snum, sname, city, comm FROM salespeople WHERE (comm > + 0.12 OR comm < 0.14);
--86) Which salespersons attend to customers not in the city they have been assigned to?
--87) Which salespeople get commission greater than 0.11 are serving customers rated less than 250?
--88) Which salespeople have been assigned to the same city but get different commission percentages?
--89) Which salesperson has earned the maximum commission?
--90) Does the customer who has placed the maximum number of orders have the maximum rating?
--91) List all customers in descending order of customer rating.
--92) On which days has Hoffman placed orders?
--93) Which salesmen have no orders between 10/03/1990 and 10/05/1990?

--94) How many salespersons have succeeded in getting orders?
--95) How many customers have placed orders?
--96) On which date has each salesman booked an order of maximum value?
--97) Who is the most successful salesperson?
--98) Which customers have the same rating?
--99) Find all orders greater than the average for October 4th.
SELECT * FROM roneet.orders where AMT > (select AVG(AMT) from orders where ODATE = '1990-04-10');
+------+---------+------------+------+------+
| ONUM | AMT     | ODATE      | CNUM | SNUM |
+------+---------+------------+------+------+
| 3002 |  1900.1 | 1990-03-10 | 2007 | 1004 |
| 3005 | 5160.45 | 1990-03-10 | 2003 | 1002 |
| 3006 | 1098.16 | 1990-03-10 | 2008 | 1007 |
| 3008 |    4732 | 1090-05-10 | 2006 | 1001 |
| 3009 | 1713.23 | 1990-04-10 | 2002 | 1003 |
| 3010 | 1309.95 | 1990-05-10 | 2004 | 1002 |
| 3011 | 9891.88 | 1990-05-10 | 2006 | 1001 |
+------+---------+------------+------+------+

--100) List all customers with ratings above Grass’s average.
--101) Which customers have above average orders?
--102) Select the total amount in orders for each salesperson for which the total is greater than the amount of the largest order in the table. 103) Give names and numbers of all salespersons that have more than one customer?
--104) Select all salespeople by name and number who have customers in their city whom they don’t service.
--105) Does the total amount in orders by customer in Rome and London, exceed the commission paid to salesperson in London, and New York by more than 5 times?
--106) Which are the date, order number, amt and city for each salesperson (by name) for the maximum order he has obtained?
--107) Which salesperson is having lowest commission?