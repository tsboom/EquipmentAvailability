# Equipment Availability

A Java Jersey API that displays tech items available for rent at UMD Libraries. 

The equipment data comes from the HTML of this Perl web application:  [Laptops web application](http://catalog.umd.edu/cgi-bin/laptops)

### To install:

1. git clone the repository

2. cd into the repository

3. `mvn compile`

4. `mvn package`

5. `mvn install`

6. To run in Terminal:  `mvn exec:java`

   Or, run in a Java IDE. 

### Functionality

In a web browser, visit the following URLs to see the various API resources

- See all equipment for rent: 
  - <http://localhost:8080/myapp/equipment/all>
- See the equipment for rent by a particular sublibrary: 
  - <http://localhost:8080/myapp/equipment/sublib/CPMCK> 
- See a particular item by sysnumber: 
  - <http://localhost:8080/myapp/equipment/sysnum/004178549> 
- See all of the checked out items in the order of soonest due: 
  - <http://localhost:8080/myapp/equipment/checkedout> 