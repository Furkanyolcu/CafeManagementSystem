## <div align="center">Technologies Used</div>

<div align="center">
  <img src="https://img.shields.io/badge/JavaFX-007396?style=for-the-badge&logo=java&logoColor=white" width="150"/>
  <img src="https://github.com/user-attachments/assets/ecb85d4b-cc71-44e4-97b4-24ff22ce43e6" width="100"/>
  <img src="https://github.com/user-attachments/assets/023e8297-745b-4ecb-9821-df7e89f5e7c8" width="100"/>
</div>

---

## Database Creation Script

Below are the SQL scripts to create the database and necessary tables for the Café Management System:

```sql
CREATE DATABASE CAFE;
GO

USE CAFE;
GO

CREATE TABLE dbo.customer (
    id INT IDENTITY(1,1) PRIMARY KEY,
    customer_id NVARCHAR(100),
    prod_name NVARCHAR(100),
    type NVARCHAR(100),
    quantity INT,
    price INT,
    date DATE,
    em_username NVARCHAR(100)
);

CREATE TABLE dbo.employee (
    id NVARCHAR(100) PRIMARY KEY,
    username NVARCHAR(100),
    password NVARCHAR(100),
    question NVARCHAR(100),
    answer NVARCHAR(100),
    date NVARCHAR(100)
);

CREATE TABLE dbo.product (
    id INT IDENTITY(1,1) PRIMARY KEY,
    prod_id NVARCHAR(100),
    prod_name NVARCHAR(100),
    stock INT,
    price INT,
    status NVARCHAR(100),
    image NVARCHAR(500),
    date DATE,
    type NVARCHAR(100)
);

CREATE TABLE dbo.receipt (
    id NCHAR(10) PRIMARY KEY,
    customer_id NCHAR(10),
    total FLOAT,
    date NCHAR(10),
    em_username NVARCHAR(100)
);
``` 
## Screenshots

Below are some screenshots of the Cafe Management System interface:

<div align="center">
    <img src="https://github.com/user-attachments/assets/7241f0c2-0d5c-4a51-b944-27dc6a5c551a" alt="Screenshot 1" width="600"/>
    <p>Screenshot 1: Welcome Page</p>
</div>

<div align="center">
    <img src="https://github.com/user-attachments/assets/21a84015-2d54-42db-8ebc-8571bfa2bb36" alt="Screenshot 2" width="600"/>
    <p>Screenshot 2: Login Page</p>
</div>

<div align="center">
    <img src="https://github.com/user-attachments/assets/ec46d0cb-8d57-4bc8-b740-3ee762ae2ec7" alt="Screenshot 3" width="600"/>
    <p>Screenshot 3: Sales Page</p>
</div>

<div align="center">
    <img src="https://github.com/user-attachments/assets/8edc1957-f76a-4381-bb60-6d8d1c6da1d8" alt="Screenshot 4" width="600"/>
    <p>Screenshot 4: Product Management</p>
</div>

<div align="center">
    <img src="https://github.com/user-attachments/assets/5065fbb5-06fc-409e-b65b-f93e6ec104c8" alt="Screenshot 5" width="600"/>
    <p>Screenshot 5: Analytics Dashboard</p>
</div>

<div align="center">
    <img src="https://github.com/user-attachments/assets/9467b618-e5ab-42ac-a7cf-73d4d688c2a5" alt="Screenshot 6" width="600"/>
    <p>Screenshot 6: Sales Reports</p>
</div>


























