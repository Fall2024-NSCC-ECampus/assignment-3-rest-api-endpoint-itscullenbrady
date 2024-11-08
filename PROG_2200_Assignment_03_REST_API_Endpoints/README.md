
# Courier Service Management System

## Project Description

The **Courier Service Management System** is a web application that facilitates the management of courier services, including products, orders, payments, companies, delivery details, non-delivery details, hub rates, and reviews. This system provides a RESTful API to interact with the underlying database, allowing for efficient management of courier operations.

### Features

- Create, read, update, and delete (CRUD) operations for:
    - Products
    - Orders
    - Payments
    - Companies
    - Delivery Details
    - Non-Delivery Details
    - Hub Rates
    - Reviews
- RESTful API endpoints for each entity
- Data persistence using Spring Data JPA and Hibernate

## Technologies Used

- **Java**: Programming language
- **Kotlin**: Language for writing the Spring Boot application
- **Spring Boot**: Framework for building the RESTful API
- **Spring Data JPA**: For database interactions
- **H2 Database**: In-memory database for development and testing
- **Maven**: Dependency management and build tool

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- Maven 3.6.0 or higher

### Installation

1. **Clone the Repository**

   ```bash
   git clone https://github.com/itscullenbrady/courier-service-management-system.git
   cd courier-service-management-system
   ```

2. **Build the Project**

   Use Maven to build the project:

   ```bash
   mvn clean install
   ```

3. **Run the Application**

   You can run the application using the following command:

   ```bash
   mvn spring-boot:run
   ```

   The application will start on http://localhost:8080.

### Database Configuration

The application is configured to use an H2 in-memory database for development. You can access the H2 console at http://localhost:8080/h2-console. The default JDBC URL is `jdbc:h2:mem:testdb`, and you can use `sa` as the username with no password.

## API Documentation

### Base URL

All API endpoints are prefixed with `/api`. For example, the base URL for accessing products is `http://localhost:8080/api/products`.

### Endpoints

#### Products

- **Get All Products**

  ```http
  GET /api/products
  ```

- **Create a New Product**

  ```http
  POST /api/products
  ```

  **Request Body:**

  ```json
  {
      "name": "Product Name",
      "price": 100.0
  }
  ```

- **Get Product by ID**

  ```http
  GET /api/products/{id}
  ```

- **Update Product**

  ```http
  PUT /api/products/{id}
  ```

  **Request Body:**

  ```json
  {
      "name": "Updated Product Name",
      "price": 150.0
  }
  ```

- **Delete Product**

  ```http
  DELETE /api/products/{id}
  ```

#### Orders

- **Get All Orders**

  ```http
  GET /api/orders
  ```

- **Create a New Order**

  ```http
  POST /api/orders
  ```

  **Request Body:**

  ```json
  {
      "productId": 1,
      "quantity": 2,
      "totalPrice": 200.0,
      "status": "Pending"
  }
  ```

- **Get Order by ID**

  ```http
  GET /api/orders/{id}
  ```

- **Update Order**

  ```http
  PUT /api/orders/{id}
  ```

  **Request Body:**

  ```json
  {
      "quantity": 3,
      "status": "Shipped"
  }
  ```

- **Delete Order**

  ```http
  DELETE /api/orders/{id}
  ```

#### Payments

- **Get All Payments**

  ```http
  GET /api/payments
  ```

- **Create a New Payment**

  ```http
  POST /api/payments
  ```

  **Request Body:**

  ```json
  {
      "amount": 200.0,
      "paymentMethod": "Credit Card",
      "status": "Completed"
  }
  ```

- **Get Payment by ID**

  ```http
  GET /api/payments/{id}
  ```

- **Update Payment**

  ```http
  PUT /api/payments/{id}
  ```

  **Request Body:**

  ```json
  {
      "amount": 250.0,
      "status": "Refunded"
  }
  ```

- **Delete Payment**

  ```http
  DELETE /api/payments/{id}
  ```

#### Companies

- **Get All Companies**

  ```http
  GET /api/companies
  ```

- **Create a New Company**

  ```http
  POST /api/companies
  ```

  **Request Body:**

  ```json
  {
      "name": "Company Name",
      "address": "123 Company St."
  }
  ```

- **Get Company by ID**

  ```http
  GET /api/companies/{id}
  ```

- **Update Company**

  ```http
  PUT /api/companies/{id}
  ```

  **Request Body:**

  ```json
  {
      "name": "Updated Company Name",
      "address": "456 New Address St."
  }
  ```

- **Delete Company**

  ```http
  DELETE /api/companies/{id}
  ```

## Additional Information

### Testing

Unit tests are included in the `src/test/java` directory. You can run the tests using:

```bash
mvn test
```
