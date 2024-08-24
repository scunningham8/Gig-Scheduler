# Gig Scheduler

### Database Requirements

1.  Gigs have:
    -   a name (less than or equal to 100 chars),
    -   a start date/time,
    -   a description (less than or equal to 1,000 chars),
    -   a ticket cost,
    -   a link to an external site (e.g., Ticketmaster) to buy tickets (optional) (less than or equal to 100 chars),
    -   and a generic notes field, that will handle any other misc. details (e.g., "Get $1 off ticket price at the door when you bring a canned food item for the food bank.") (less than or equal to 500 chars).
3.  A gig may have any number (0 or more) of associated Bands. Associated Bands are either "headliners" or not headliners (a boolean distinction between the two is sufficient). A headliner is the primary band (usually the biggest band and the last to play) playing at a gig. Sometimes a gig has multiple headliners, but usually it's just one.
4.  A band has:
    \- a unique name (less than or equal to 50 chars),
    \- a hometown (less than or equal to 50 chars),
    \- a website URL (optional) (less than or equal to 500 chars),
    \- and the URL to an image with a picture of that band (optional) (less than or equal to 500 chars).
5.  The optional fields are not always required (they can be null), but are rarely empty.
6.  Appropriate foreign keys are used.

### Scheduling System

1. The scheduling system runs in the command line.
2. The user is be able to choose between a help menu, adding a new Gig, viewing the entire schedule, and quitting the application.
3. If the user chooses to add a new gig, they are prompted to enter all of the required information about the new gig.
4. If a Band with the name given by the user already exists in the database, the user is not prompted for the information.
5. If the user chooses to view the entire schedule, the system asks for a start date and an end date .
6. All results on the "entire schedule" appear in chronological order
7. If there are two Gigs which start at the same time, the ordering of the two Gigs does not matter.
8. Headliner bands are always be listed before any other bands.
9. Requests for input include examples of what the user should type.
10. The system utilizes a local MySQL server, the Java programming language, and JDBC.
11. The database includes foreign keys between the appropriate tables.

-   **OOP Structure**
    -   uses encapsulation & inheritance
    -   functionality belongs to appropriate classes
-   **Database Design**
    -   tables use correct data types
    -   tables utilize primary/foreign key constraints
    -   relationships modeled appropriately
-   **Meets spec**
    -   SQL dump file included, named appropriately, and includes the required seeding elements.
    -   EER diagram included and named appropriately.
    -   Gig/Band info is formatted according to spec when outputted, and the user is prompted for a start/end date for filtering gigs by date.
    -   Functionality for prompting the user to add new bands is completed according to spec.
    -   Accessors include the ability to view all gigs, and includes the ability to filter these gigs between two dates/times.
    -   Accessors include the ability to add a new gig and associated bands to the database.
    -   USER_MANUAL file included, named appropriately, and helpful.
    -   System includes helpful help menu and the ability to exit.
    -   Gig/Band info is formatted according to spec when outputted, and the user is prompted for a start/end date for filtering gigs by date.
    -   Functionality for prompting the user to add new gigs and new bands is completed according to spec.
-   **Code structure**
    -   No code copied many times within a method, many times in a class, etc.
    -   Code is structured in an easy-to-read way
-   **Testing**
    -   Effective use of mocking
    -   All tests run and pass
    -   All assert statements have a unique "message" passed to them
-   **Software engineering principles**
    -   No linter errors
    -   Well-chosen variable and method names
-   **Data Structures**
    -   use of built-in data structures is appropriate for needs of system
    -   custom data structures are functionally sound
-   **Database Integration**
    -   accessors are well-formed according to best practices discussed in class
    -   SQL queries are well-formed and correct
