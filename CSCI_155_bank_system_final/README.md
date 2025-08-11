# Bank Management System

## Overview
A simple, object-oriented Java application simulating a bank system with three account types: Checking, Gold, and Regular.  
The system allows bank operators to create accounts, perform deposits/withdrawals, apply monthly updates, and view bank statistics.  
Data is persisted between runs using Java Serialization.

---

## Features
- **Account Types**:
  - **CheckingAccount**: No interest, two free transactions/month, $3 fee thereafter (fee may reduce balance below 0). 
  - **GoldAccount**: 5% monthly interest, unlimited withdrawals (overdraft allowed).
  - **RegularAccount**: 6% monthly interest, $10 monthly fee (fee may reduce balance below 0).
- **Core Operations**:
  1. Create a Checking account
  2. Create a Gold account
  3. Create a Regular account
  4. Deposit to an account
  5. Withdraw from an account
  6. Display specific account information
  7. Remove an account
  8. Apply end-of-month updates (interest & fees)
  9. Display bank statistics (total balance, average balance, zero balance accounts, largest account)
  10. **List all accounts** — shows account number, balance, and owner name (sorted by account number)
  11. Exit (saves data to file)

---

## Class Overview
### `Customer`
- Holds customer ID and name.
- Provides getters and a setter with validation.
- Implements `toString()` to return a formatted customer description.

### `Account` (abstract)
- Common fields: account number, balance, and `Customer` reference.
- Provides deposit and match account number methods.
- Abstract `applyMonthlyUpdate()` method for subclass-specific behavior.
- Implements `Serializable` for persistence.

### `CheckingAccount`
- Extends `Account`.
- Overrides `deposit()` and `withdraw()` to count transactions.
- Withdrawals limited to available balance (no overdrafts).
- Applies transaction fees beyond the free limit during monthly update, which can reduce balance below zero.

### `GoldAccount`
- Extends `Account`.
- Allows overdrafts.
- Applies interest only if balance is positive.

### `RegularAccount`
- Extends `Account`.
- Withdrawals limited to available balance (no overdrafts).
- Applies interest only if balance is positive.
- Always applies monthly maintenance fee, which can reduce balance below zero.

### `Bank`
- Manages a list of accounts.
- Provides methods to create, remove, deposit, withdraw, display, and apply updates.
- Computes bank statistics using Java Streams.
- Saves and loads data using object serialization.

### `BankSystem`
- Command-line interface for interacting with the `Bank`.
- Provides menu-driven operations.
- Validates user input and handles errors gracefully.
- Persists data between runs.

---

## Persistence
The system uses **Java Serialization** to save and load the entire `Bank` object to/from a file.  
Each class that participates in serialization implements `Serializable` and declares a `serialVersionUID`.  
This ID ensures compatibility when loading previously saved objects, even if the class changes between versions.

---

## Assumptions
- Account numbers and customer IDs are not enforced to be unique.
- A customer may own multiple accounts of the same type.
- **CheckingAccount** and **RegularAccount** are allowed negative balances whenever fees from monthly updates causes a balance to drop below zero. 

---

## Known Issues
- None currently known.

---

## Challenges
- Writing code that was intuitive for the user, but also structured so the code was easy to maintain and extend.
- Understanding and implementing object relationships to follow OOP best practices.
- Using Git/GitHub and integrating version control with the Eclipse IDE.

---

## Author
**Red Team**  
Version 1.0 — August 2025
