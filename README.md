# Photographer-Booking-App

Project Title: Photographer Booking Application

📸 Photographer Booking Application Overview:

The Photographer Booking Application is a full-stack platform that connects photographers with clients. It lets clients browse photographers, check availability, book services, and manage bookings. Photographers can showcase their portfolios, manage schedules, and view booking details. This application is built with Java, Spring Boot, React, and MySQL, using JWT for secure authentication.


🛠️ Technology Stack

Backend:

- Java with Spring Boot
- Authentication & Authorization: JSON Web Token (JWT)
- Database: MySQL
- Build Tool: Maven

Frontend:

- React.js
- State Management: Redux/Context API
- Styling: CSS/SCSS, Material-UI or TailwindCSS

Tools:

- Version Control: Git/GitHub
- API Testing: Postman
- Database Tool: MySQL Workbench
- Deployment: AWS/Heroku (optional)


✨✨ Features:

For Clients:

User Registration and Login (JWT-based secure authentication)
Explore Photographers: Search by location, style, and availability.
Booking System: Real-time availability check and email confirmations.
Dashboard: Manage bookings, and view invoices and receipts.

For Photographers:

Profile Management: Upload portfolios, set availability, and pricing.
Booking Management: Accept or decline bookings and view schedules.
Analytics Dashboard: Insights into earnings, completed bookings, and reviews.

Admin Features:

User Management: Manage client and photographer accounts.
Review Moderation: Monitor and remove inappropriate reviews.
Content Management: Update homepage banners, promotions, and blog content.

🗂️ Modules:

1. Authentication & Authorization
Role-based access: Client, Photographer, Admin.
JWT token-based authentication for secure sessions.

2. API Development
RESTful APIs for CRUD operations:
User registration/login.
Photographer portfolio management.
Booking creation and updates.

3. Database Integration
Schema design for entities like Users, Photographers, Bookings, and Reviews.
MySQL for persistent storage and optimized queries.

4. Frontend Development
Responsive and reusable React components.
REST API integration with Axios/Fetch.

5. Payment Gateway
Secure payment integration with Stripe/PayPal.

6. Notifications
Email notifications for booking confirmations and reminders.


📋 Database Schema

CREATE TABLE Users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(255),
    role ENUM('CLIENT', 'PHOTOGRAPHER', 'ADMIN'),
    location VARCHAR(100)
);

CREATE TABLE Photographers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    portfolio_url TEXT,
    availability JSON,
    pricing_details JSON,
    FOREIGN KEY (user_id) REFERENCES Users(id)
);

CREATE TABLE Bookings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    client_id INT,
    photographer_id INT,
    booking_date DATE,
    total_amount DECIMAL(10, 2),
    status ENUM('PENDING', 'CONFIRMED', 'COMPLETED', 'CANCELLED'),
    FOREIGN KEY (client_id) REFERENCES Users(id),
    FOREIGN KEY (photographer_id) REFERENCES Photographers(id)
);

CREATE TABLE Reviews (
    id INT AUTO_INCREMENT PRIMARY KEY,
    client_id INT,
    photographer_id INT,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    feedback TEXT,
    FOREIGN KEY (client_id) REFERENCES Users(id),
    FOREIGN KEY (photographer_id) REFERENCES Photographers(id)
);


🚀 Project Workflow:

1. Planning & Design
Design database schema.
Create wireframes for the frontend.
Define API endpoints.

2. Backend Development
Develop RESTful APIs with Spring Boot.
Implement JWT-based authentication.

3. Frontend Development
Build React components with a responsive design.
Connect APIs with Axios.

4. Integration
Integrate backend and frontend services.
Test end-to-end workflows.

5. Testing
Unit testing with JUnit (backend).
Manual and automated testing (frontend).

6. Deployment
Deploy backend on AWS/Heroku.
Host frontend on Vercel/Netlify.

🌟 Features in Development:

Mobile App: Using React Native for Android and iOS.
AI Recommendation: Suggest photographers based on user preferences.
Chat Integration: Real-time communication between clients and photographers.
Subscription Model: Premium features for photographers.

🤝 Contributing
Contributions are welcome! Please fork the repository and submit a pull request with enhancements or fixes.

📧 Contact
For questions or feedback, feel free to contact:
Email: aayush98.ak@gmail.com

Happy coding! 💻🎉
Best Regards,
quirkyCoder!!
