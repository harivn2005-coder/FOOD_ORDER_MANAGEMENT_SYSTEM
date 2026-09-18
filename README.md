# FOOD_ORDER_MANAGEMENT_SYSTEM
Food ordering management using the JAVA- JDBC and MySQL.
#  Food Order Management System

A console-based **Food Order Management System** developed using **Java, JDBC, MySQL, and Maven**. The system provides centralized management of food items, customers, and orders using a layered architecture.

---

## 📌 Problem Statement

Manual food ordering and record maintenance can be time-consuming and error-prone.

This system is designed to:

* Manage food details such as **name, category, price, and available quantity**.
* Store and retrieve **customer and order information** reliably.
* Support **CRUD (Create, Read, Update, Delete) operations**.
* Provide a simple **console-based workflow**.
* Maintain a layered structure separating database access, business logic, and user interaction.

---

## 🛠️ Technologies Used

| Technology  | Purpose                                                           |
| ----------- | ----------------------------------------------------------------- |
| **Java 21** | Core programming language and object-oriented implementation      |
| **JDBC**    | Connectivity between Java and MySQL                               |
| **MySQL**   | Relational database for storing food, customer, and order records |
| **Maven**   | Project build and dependency management                           |
| **SQL**     | Database creation, CRUD operations, searching, and relationships  |

### Architecture

```text
Controller → Service → Repository → Database
```

---

## ✨ Features

### 🍕 Food Management

* Add food with:

  * Food name
  * Category
  * Price
  * Quantity
* View available food
* Search food
* Update food details
* Delete food records

### 👤 Customer Management

* Add customers
* View customer records

### 🛒 Order Management

* Place orders
* Calculate total order amount
* View orders
* Update order status
* Delete orders

### ⚠️ Validation & Exception Handling

The system provides validation and custom exceptions for:

* Missing food records
* Missing order records
* Invalid quantities

---

## 🏗️ Project Architecture

```text
                    FoodOrderApp
                         │
                         ▼
                FoodOrderController
                         │
                         ▼
                   Service Layer
                         │
                         ▼
                 Repository Layer
                         │
                         ▼
                    DBConnection
                         │
                         ▼
                   MySQL Database
```

### Architecture Components

| Layer          | Responsibility                                   |
| -------------- | ------------------------------------------------ |
| **Model**      | Represents Food, Customer, and FoodOrder objects |
| **Controller** | Handles user input                               |
| **Service**    | Handles validation and business rules            |
| **Repository** | Handles JDBC and SQL operations                  |
| **Database**   | Stores data in MySQL tables                      |

---

## 🔄 Project Flow

```text
Application Starts
       ↓
FoodOrderApp
       ↓
User Selects Operation
       ↓
FoodOrderController
       ↓
Service Layer
       ↓
Validation & Business Rules
       ↓
Repository Implementation
       ↓
JDBC / SQL Operations
       ↓
DBConnection
       ↓
MySQL Database
       ↓
Result Returned
       ↓
Displayed to User
```

### Step-by-Step

1. The application starts from `FoodOrderApp`.
2. The user selects an operation from the menu.
3. `FoodOrderController` collects the required input.
4. The Service Layer validates the data and applies business rules.
5. Repository implementations execute JDBC/SQL operations.
6. `DBConnection` establishes communication with MySQL.
7. The result is returned through the layers and displayed to the user.

---

## 📂 Project Structure

```text
Food-Order-Management-System/
│
├── controller/
│   └── FoodOrderController
│
├── database/
│   └── DBConnection
│
├── exception/
│   ├── FoodNotFoundException
│   ├── OrderNotFoundException
│   └── InsufficientQuantityException
│
├── main/
│   └── FoodOrderApp
│
├── model/
│   ├── Food
│   ├── Customer
│   └── FoodOrder
│
├── repository/
│   ├── FoodRepository
│   ├── FoodRepositoryImpl
│   ├── CustomerRepository
│   ├── CustomerRepositoryImpl
│   ├── OrderRepository
│   └── OrderRepositoryImpl
│
├── service/
│   ├── FoodService
│   ├── FoodServiceImpl
│   ├── CustomerService
│   ├── CustomerServiceImpl
│   ├── OrderService
│   └── OrderServiceImpl
│
└── util/
    └── InputUtil
```

---

## 🚀 Future Enhancements

* 🖥️ Develop a web or desktop graphical user interface.
* 🔐 Add user login, roles, and authentication for admin, staff, and customers.
* 📦 Implement transactional stock reduction when an order is placed.
* 💳 Add payment gateway and online payment status.
* ❌ Add order cancellation.
* 🚚 Add delivery tracking and notifications.
* 📊 Generate sales reports, invoices, and dashboards.
* 🌐 Add REST APIs.
* ☁️ Deploy the application to a cloud environment.

---

## 📝 Conclusion

The **Food Order Management System** provides a structured solution for managing food, customers, and orders.

Java and JDBC provide the application logic and database connectivity, while MySQL provides reliable data persistence through related tables.

The layered architecture improves:

* Separation of concerns
* Readability
* Maintainability

The project can be further extended into a complete real-world food ordering platform.

---

## 👨‍💻 Technologies

```text
Java 21
JDBC
MySQL
Maven
SQL
Layered Architecture
```

---

⭐ **Food Order Management System — Java + JDBC + MySQL**
