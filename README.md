# Manage Cinema

Manage Cinema is a comprehensive system designed to manage all cinemas within a network. It allows customers to view movie listings and book tickets online. The system also provides an admin role to manage staff, staff shifts, movies, movie slots, and more. Additionally, staff can perform tasks such as booking tickets for customers and guests.

### Demo: https://youtu.be/6QzB8HLWT0c

## Features

### Customer Features
- **View Movie Listings**: Customers can browse all movies showing in the cinema.
- **Online Ticket Booking**: Customers can book tickets for their desired movies online.

### Staff Features
- **Book Tickets for Customers**: Staff can assist customers by booking tickets on their behalf.
- **Manage Guest Bookings**: Staff can book tickets for walk-in guests.

### Admin Features
- **Manage Staff**: Add, update, and delete staff details.
- **Manage Staff Shifts**: Schedule and manage staff shifts.
- **Manage Movies**: Add, update, and delete movie information.
- **Manage Movie Slots**: Schedule and manage movie showtimes.

## Technologies Used

- **Backend**: Java Servlet
- **Frontend**: HTML, JavaScript, CSS
- **Database**: MySQL

## Installation

To install and run the Manage Cinema project locally, follow these steps:

1. **Clone the repository**
   ```sh
   git clone https://github.com/your-username/manage-cinema.git
2. **Clone the repository**
    ```sh
    cd manage-cinema
3.  **Set up the database**
 * Install MySQL if it's not already installed.
* Create a database named manage_cinema.
* Run the SQL script provided in the database directory to set up the tables.

4.  **Set up environment variables**
* Create a .env file in the root directory and add the following environment variables
    ```
    LOCALHOST=http://localhost:8080
    DB_URL=jdbc:mysql://localhost:3306/project_cinema_update
    DB_USERNAME=root
    DB_PASSWORD=your_database_password

    # Google
    GOOGLE_CLIENT_ID=your_google_client_id
    GOOGLE_CLIENT_SECRET=your_google_client_secret

    # Mail
    EMAIL=your_email
    PASSWORD=your_email_password

    # File poster images
    URL_UPLOAD_IMAGE=/path/to/your/project/assets/images/posterImages

    # Paypal
    CLIENT_ID=your_paypal_client_id
    CLIENT_SECRET=your_paypal_client_secret
5.  **Deploy the application**
* Compile the Java Servlet code and deploy it to a servlet container like Apache Tomcat.
* Place the compiled .war file in the webapps directory of your Tomcat server.
6.  **Start the Tomcat server**
* Start the server and navigate to http://localhost:8080/manage-cinema to access the application.




