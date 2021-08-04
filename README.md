# Salary calculator
For this exercise we'll build a simple program that will help us with some calculations. We'll rely on overloading methods to implement the requirements efficiently.

## Requirements
Build a program that helps with the salary calculation for our employees. The employees of our company have different bonus models, depending on the work they do.
* Sales representatives get a bonus of 10% of their total sales, if their sales exceed 10 000 € in a given month. Otherwise, they get no bonus.
* Engineers get a bonus based on the sales of their designs. For each unit (that they designed) sold, they get 20 €. If the sales in a month exceed 100 units, they get an additional 10 € for each unit.
* Assembly line workers get a bonus of 25 cent for each assembled part if they reach a threshold. Part-time workers must assemble 300 parts to reach the threshold, while full-time employees mus reach 700 parst.

Write the 3 different versions of the calculateBonus() method by using parameter overloading.

Tip: Use a Switch-statement for the initial input to find the employee's classification. 