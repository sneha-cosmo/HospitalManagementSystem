# Hospital Management System (Java + MongoDB)

A Java console-based Hospital Management System that performs basic CRUD operations using MongoDB as the database.  
This project is built for learning purposes without using Maven or Spring Boot.

## Features
- Add Patient
- Search Patient
- Update Patient
- Delete Patient
- Add Doctor
- Book Appointment
- Menu-driven console application
- MongoDB integration

## Technologies Used
- Java (JDK 8+)
- MongoDB Community Server
- MongoDB Java Driver (JAR files)
- VS Code

## Project Structure
HospitalManagementSystem/ 
  --lib/ 
    ├── mongodb-driver-sync-4.11.1.jar 
    ├── mongodb-driver-core-4.11.1.jar 
    ├── bson-4.11.1.jar 
  --model/ 
    ├── Patient.java    
    ├── Doctor.java 
    ├── Appointment.java │ 
├── MongoDBConnection.java 
├── HospitalService.java 
├── Main.java 
└── README.md

## How to Run
1. Install and start MongoDB Community Server  
2. Add MongoDB JAR files to the `lib` folder    
3. Run `Main.java`  
4. Use the console menu to perform operations  

## Database
- Database Name: `hospitalDB`
- Collections: `patients`, `doctors`, `appointments`

The database can be viewed using MongoDB Compass or mongosh.

## Author
Sneha R
