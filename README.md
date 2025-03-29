# **TERRAFORM MODULE CI POC**

| **Author** | **Created on** | **Version** | **Last updated by** | **Last Edited On** | **Level** | **Reviewer** |
|------------|--------------|-------------|----------------|---------------|-------------|-------------|
| Mohit Kumar | -03-2025 | Version 1 | Mohit Kumar | -02-2025 | Internal Reviewer | |

## Table of Contents
1. [Introduction](#introduction)  
2. [Why Terraform Module CI?](#why-terraform-module-ci)  

   <details>
   <summary>Terraform CI Steps</summary>

   - [Clean](#clean)  
   - [Clone](#clone)  
   - [Init](#init)  
   - [Fmt](#fmt)  
   - [Validate](#validate)  
   - [Lint](#lint)  
   - [Check](#check)  
   - [Cost Estimation](#cost-estimation)  
   
   </details>

6. [Contact Information](#contact-information)  
7. [References](#references)  

___
## Introduction
Terraform Module CI (Continuous Integration) ensures the quality, consistency, and security of infrastructure code. It automates testing and validation, reducing human errors and making infrastructure management more efficient.

## Why Terraform Module CI?
- Automates infrastructure validation and testing.
- Ensures code consistency and best practices.
- Reduces risks of misconfiguration.
- Provides cost estimation before applying changes.
- Enhances collaboration in infrastructure development.

## Terraform CI Steps
### [Clean](#clean)
Removes any existing Terraform state or cache files to start with a clean slate.

### [Clone](#clone)
Fetches the latest version of the Terraform module from the repository.

### [Init](#init)
Initializes the Terraform working directory, downloading necessary provider plugins and modules.

### [Fmt](#fmt)
Formats Terraform code to maintain consistency and readability.

### [Validate](#validate)
Checks the syntax and structure of Terraform configuration files to catch errors before applying them.

### [Lint](#lint)
Runs static analysis tools to detect potential issues in the Terraform code.

### [Check](#check)
Performs additional verification steps such as compliance and security checks.

### [Cost Estimation](#cost-estimation)
Calculates the cost impact of proposed infrastructure changes before applying them.

___
## Contact Information

| **Name** | **Email address** |
|----------|-------------------------------|
| Mohit Kumar | [mohit.kumar@mygurukulam.co](mailto:mohit.kumar@mygurukulam.co) |

___
## References

| Link | Description |
|---------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------|
| [Redis Documentation - Installation](https://dev.to/iqquee/how-to-setup-redis-on-linux-4h06) | Document format followed from this link. |
| [Introduction to Redis](https://www.geeksforgeeks.org/introduction-to-redis-server/) | This link gives the Introduction to Redis. |
