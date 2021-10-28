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
--8) Count the orders of each of the salespeople and output the results in descending order.
--9) List the customer table if and only if one or more of the customers in the Customer table are located in SanJose.
--10) Match salespeople to customers according to what city they live in.
--11) Find all the customers in SanJose who have a rating above 200.
select * from customers where CITY = 'SanJose' and rating > 200;
--12) List the names and commissions of all salespeople in London.
--13) List all the orders of Salesperson Motika from the orders table.
--14) Find all customers who booked orders on October 3.