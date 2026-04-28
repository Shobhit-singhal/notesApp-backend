# 📝 Notes & Todo App - Backend

## 🚀 Overview
This is the backend for a full-stack Notes & Todo application built using Spring Boot.  
It provides RESTful APIs for managing notes and tasks with secure JWT-based authentication and user-specific data handling.

---

## 🔥 Features

- JWT-based authentication using Spring Security
- Secure login and registration system
- Protected routes with request filtering
- CRUD operations for notes and todos
- Search notes by title
- User-specific data isolation
- Modular architecture (Controller - Service - Repository)

---

## 🛠 Tech Stack

- Java
- Spring Boot
- Spring Security
- JWT Authentication
- MySQL
- Maven

---

## 📁 Project Structure

```
src/
 ├── controller/
 ├── service/
 ├── repository/
 ├── entity/   (User, Note, Todo)
 └── config/
```

---

## 🔗 Frontend Repository

👉 https://github.com/Shobhit-singhal/NotesApp-frontEnd

---

## ⚙️ How to Run Locally

### 1. Clone the repository
```bash
git clone https://github.com/Shobhit-singhal/notesApp-backend
cd notesApp-backend
```

### 2. Configure Database

Update your `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/your_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

---

### 3. Run the application

```bash
mvn spring-boot:run
```

---

## 🔐 Authentication

- Implemented using JWT
- Spring Security handles authentication and request filtering
- All protected endpoints require a valid token

---

## 📌 API Endpoints

### 🔐 Auth
- POST `/public/register`
- POST `/public/login`

### 📝 Notes
- GET `/notes`
- POST `/notes`
- GET `/notes/{title}`
- GET `/notes/id/{id}`
- PUT `/notes/id/{id}`
- DELETE `/notes/{id}`

### ✅ Todo
- GET `/todo`
- POST `/todo`
- PUT `/todo/{id}`
- DELETE `/todo/{id}`

---

## 📈 Future Improvements

- Add pagination for notes and todos
- Add refresh token mechanism
- Deploy backend (Render / Railway)
- Improve validation and error handling

---

## 👨‍💻 Author

Shobhit Singhal