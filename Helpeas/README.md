# HelpeasApp - A tool to learn 
 The Leitner Method, a proven system for efficient learning through spaced repetition, seamlessly integrated into the HelpeasApp to help users master concepts with minimal effort and maximum retention.

 **Helpeas** is an application developed in JavaFX to make the learning process easier. 

## Prerequisites

Before executing this app, make sure the following elements are downloaded : 
- **Java Development Kit (JDK) 17 or above : you can dowload it from here [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- **Apache Maven**: you can download it from here  [maven.apache.org](https://maven.apache.org/download.cgi)

## Dowloading Dependencies 

After cloning the project, it is essential to download every dependency required with maven.
Open a terminal and run the following command:
```bash 
mvn install
```
## Executing the HelpeasApp

Once all dependencies are downloaded, the app can be opened with the following command :
```bash
mvn clean javafx:run
```
## Project Structure
Here is an overview of the directory structure of the project:

Helpeas/\
├── src/            #Contains the source files of the project\
│   ├── main/\
│   │   ├── java/           #Include the Java programm\
│   │   │   └── app/helpeas/\
│   │   └── resources/          #Include the resources\
├── target/        \
├── pom.xml         #Configuration of Maven file\
└── README.md           #This file

## Author 
Sanâ CHATTALI, L3 MPCI

## Acknowledgements
- François Brucker for surpervising this project and his precious advices
- Valentin Emiya for taking the time to dive into my work and provide feedback. 