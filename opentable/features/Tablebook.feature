@Capgemini
Feature: Other options in Open Table

Background:
Given user click on desired restaurant
When user has to login to open table

@navya
Scenario: verifying details of the hotel
Then google map of the hotel should be displayed
And address should be displayed
And parking details should be displayed
And payment options should be displayed
When user click on view more
Then website link should be displayed
And contact number should be displayed

Scenario Outline: Booking a table with invalid phone number
When user enters party size
And selects date
When selects the time 
And clicks on find a table
When selecting time
And enters invalid phone number <phno>
And selects check boxes
When clicks on complete reservation					
Then enter valid phone number to be displayed

Examples:
 					|   phno        |
 					|   564321      |
 					
 
Scenario Outline: Booking a table with valid phone number
When user enters party size
And selects date
When selects the time 
And clicks on find a table
When selecting time
And enters valid phone number <phonenum>
And selects check boxes
When clicks on complete reservation				
Then confirmation message should be displayed
Examples:
 					|   phonenum         |
 					|   5643217890       |




