# Phonebook

Stack:
- Maven
- MySQL DB
- Spring
- Hibernate
- JSP
- Tomcat
- JUnit

Author: Andrey Demyanenko

## Main functionality
- DB (MySQL) with 2 tables for Users and Contacts
- Registration / Login for Users
- CRUD operations for Contacts
- Only authorized User has access to Contacts
- Every User has access only to his own list of Contacts
- Contact search by first name, last name and phone number

### Additional
- User: login (3+ chars), password (5+ chars), username (5+ chars)
- Contact: last name(4+ chars), middle name (4+ chars), first name (4+ chars), mobile number (valid for Ukraine); optional fields: additional number, address, email (standard validation)

