# servlet-cab-order-management-system
## Table of Contents
* Introduction
* Features
* Technologies Used
* Getting Started
* Installation
* Usage
* Contributing
* Contact
* Code Structure
* Functionality
* Database Schema (POJO Classes)

## Introduction
## 🚀 Project Overview
The servlet-cab-order-management-system is a Java-based web application built using Servlet and JSP technologies. It simulates real-world operations such as user registration, ride booking, driver management, payment processing, and driver rating functionalities. This project serves as a hands-on approach to understanding full-stack Java development while applying core concepts like JDBC, MVC, and OOP design principles.

## Features
## ✨ Key Features
* 👤 User & Driver Registration
* Register and manage both customer and driver accounts seamlessly.

* 🚕 Ride Booking
* Book rides by selecting pickup and drop locations, calculate fare, and assign drivers automatically.

* 💳 Payment Processing
* Securely process ride payments and manage payment history.

* ⭐ Ratings & Reviews
* Rate drivers post-ride with rating and optional feedback.

* 🗃️ CRUD Operations
* Perform Create, Read, Update, and Delete operations on all modules.

* 📈 Admin Dashboard
* Monitor rides, payments, users, and driver activity.

* Technologies Used
* 🛠️ Stack
* Java – Core language for backend logic

* JSP/Servlet (Jakarta EE) – For handling web requests and building the user interface

* JDBC – For database operations

* MySQL – Relational database to store system data

* HTML5/CSS3 – Frontend structure and styling

* JavaScript – Basic client-side interactivity

* Apache Tomcat – Servlet container

* Maven – Build and dependency management

* Git – Version control

## Getting Started
## 💡 Installation and Setup
### Prerequisites
* Java JDK 21+

* Apache Tomcat 10+

* ySQL 8+

* Maven 3.8+

* IDE (Eclipse/IntelliJ)

* Git (optional)

## Setup MySQL Database

CREATE DATABASE cab_management;
USE cab_management;

## Configure Your MySQL Connection

jdbc.url=jdbc:mysql://localhost:3306/cab_management
jdbc.username=root
jdbc.password=your_password
jdbc.driver=com.mysql.cj.jdbc.Driver

## Compile and Run the Application

locate Main.java in your IDE.

Run the file to launch the application.

## Build the project
    mvn clean install

## Deploy to Tomcat Server
Place the .war file in the webapps folder and start the server.

## Start Tomcat
Start the Tomcat server and access the application at
http://localhost:8080/user-controller.

## Usage
* User Registration & Login

* Book a Ride

* Assign Driver & View Ride Details

* Make a Payment

* Rate a Driver

* Admin Access to Monitor Activities

## Contributing
Contributions are welcome! Open an issue or submit a pull request. For major changes, please open a discussion first.

## Functionality
User

Driver

Ride

Payment

Rating

## 🔧 Core Modules
User Management
Register, update, delete users.

Driver Management
Add drivers, update availability, assign to rides.

Ride Management
Book rides, view ride history, update ride status.

Payment Management
Pay for rides, view transaction history.

Ratings & Reviews
Submit and view driver ratings.

## Database Schema (POJO Classes)
   Entity	  Attributes

   User	     user_id, name, email, phone
   Driver	 driver_id, name, email, phone, cab_details, availability
   Ride	     ride_id, user_id, driver_id, pickup_location, dropoff_location, fare, status
   Payment	 payment_id, ride_id, user_id, amount, payment_method, status
   Rating	  rating_id, ride_id, user_id, driver_id, rating, review
License
This project is licensed under the MIT License – see the LICENSE file for details.