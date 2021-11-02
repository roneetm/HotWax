--1) List all the columns of the Salespeople table.
select * from salespeople;
--2) List all customers with a rating of 100.
select * from customers where RATING > 100;
--3) Find the largest order taken by each salesperson on each date.
--4) Arrange the Order table by descending customer number.
select * from orders order by CNUM desc;
--5) Find which salespeople currently have orders in the order table.
--6) List names of all customers matched with the salespeople serving them.
--7) Find the names and numbers of all salespeople who have more than one customer.
SELECT SNAME, COMM FROM salespeople Where COMM > 2;
--8) Count the orders of each of the salespeople and output the results in descending order.
--9) List the customer table if and only if one or more of the customers in the Customer table are located in SanJose.
--10) Match salespeople to customers according to what city they live in.
--11) Find all the customers in SanJose who have a rating above 200.
select * from customers where CITY = 'SanJose' and rating > 200;
--12) List the names and commissions of all salespeople in London.
--13) List all the orders of Salesperson Motika from the orders table.
--14) Find all customers who booked orders on October 3.
--15) Give the sums of the amounts from the Orders table, grouped by date, eliminating all those dates where the SUM was not at least 2000 above the maximum Amount.
--16) Select all orders that had amounts that were greater than at least one of the orders from October 6.
select * from orders where AMT > (Select MIN(AMT) from Orders where ODATE = '1990-04-10');
--17) Write a query that uses the EXISTS operator to extract all salespeople who have customers with a rating of 300. 18) Find all customers whose cnum is 1000 above the snum of Serres.
--19) Give the salespeople’s commissions as percentages instead of decimal numbers.
--20) Find the largest order taken by each salesperson on each date, eliminating those Maximum orders, which are less than 3000. 21) List all the largest orders for October 3, for each salesperson.
--22) Find all customers located in cities where Serres has customers.
--23) Select all customers with a rating above 200.
select * from CUSTOMERS where RATING > 200;
--24) Count the number of salespeople currently having orders in the orders table.
--25) Write a query that produces all customers serviced by salespeople with a commission above 12%. Output the customer’s name, salesperson’s name and the salesperson’s rate of commission.
--26) Find salespeople who have multiple customers.
--27) Find salespeople with customers located in their own cities.
--28) Find all salespeople whose name starts with ‘P’ and fourth character is ‘I’.
--29) Write a query that uses a subquery to obtain all orders for the customer named ‘Cisneros’. Assume you do not know his customer number. 30) Find the largest orders for Serres and Rifkin.
--31) Sort the salespeople table in the following order: snum, sname, commission, city.
--32) Select all customers whose names fall in between ‘A’ and ‘G’ alphabetical range.
SELECT * FROM orders where ODATE = '1990-03-10';
--33) Select all the possible combinations of customers you can assign.
--34) Select all orders that are greater than the average for October 4.
--35) Write a select command using correlated subquery that selects the names and numbers of all customers with ratings equal to the maximum for their city.
--36) Write a query that totals the orders for each day and places the results in descending order.
--37) Write a select command that produces the rating followed by the name of each customer in SanJose.
--38) Find all orders with amounts smaller than any amount for a customer in SanJose.
--39) Find all orders with above average amounts for their customers.
--40) Write a query that selects the highest rating in each city.
--41) Write a query that calculates the amount of the salesperson’s commission on each order by a customer with a rating above 100.00. 42) Count the customers with ratings above SanJose’s average.
--43) Find all salespeople that are located in either Barcelona or London.
select * from salespeople where CITY in ('Barcelona', 'London');
--44) Find all salespeople with only one customer.
--45) Write a query that joins the Customer table to itself to find all pairs or customers served by a single salesperson. 46) Write a query that will give you all orders for more than $1000.00.
--47) Write a query that lists each order number followed by the name of the customer who made that order.
--48) Write a query that selects all the customers whose ratings are equal to or greater than ANY(in the SQL sense) of ‘Serres’. 49) Write two queries that will produce all orders taken on October 3 or October 4.
--50) Find only those customers whose ratings are higher than every customer in Rome.
select * from customers where Rating > (select RATING from customers where CITY = 'Rome');