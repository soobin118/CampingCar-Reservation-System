# CampingCar-Reservation-System

I implemented this by using Java and database. 
I implemented the database by using SQL, then I linked to JAVA and implemented GUI. 
The database includes information about camping car, company, customer, rental, repair shop, and request. The authority is divided into administrator and user.   
When I implemented this program, I thought about the errors that can occurs, and I implemented popup messages about that. For example, when user inserts data to database, the user has to fill in the all blanks. However, if the user did not fill a blank, a message which says "Empty space should not exist." appears.

### [ FUNCTION ]
* < WHOLEDATA > : It shows the whole data of the database. User only can see the data of camping car, company, and repair shop. Administrator can see the whole data of the database.
* < INSERTDATA > : You can insert data to the database by filling in the blanks. User only can insert customer data to the database. Administrator can insert the whole data to the database.
* < DELETEDATA > : You can delete data of the database. User only can delete customer data by entering the driver's license number. Administrator can delete the whole data by entering the primary key of the database.
* < EDITDATA > : You can edit data of the database. User only edit customer data of the database. Administrator can edit whole data of the database.
* < QUERY > : You can query to the database. User can see only two queries and results of the queries. Administrator can see five queries and results of the queries.
* < RESET > : Only administrator resets the data of the database.
