# **TERRAFORM MODULE CI POC**

![image](https://github.com/user-attachments/assets/542dd328-47e7-484f-9283-33bce981af1e)

| **Author** | **Created on** | **Version** | **Last updated by** | **Last Edited On** | **Level** | **Reviewer** |
|------------|--------------|-------------|----------------|---------------|-------------|-------------|
| Mohit Kumar | 30-03-2025 | Version 1 | Mohit Kumar | 30-03-2025 | Internal Reviewer | |

## Table of Contents
1. [Introduction](#introduction)  
2. [Prerequisites](#prerequisites)  
3. [Why Terraform Module CI?](#why-terraform-module-ci)  
4. [Terraform CI Steps](#terraform-ci-steps)  
5. [CI Workflow](#ci-workflow)  
6. [Contact Information](#contact-information)  
7. [References](#references)  

---
## Introduction
Terraform Module CI (Continuous Integration) ensures the quality, consistency, and security of infrastructure code. It automates testing and validation, reducing human errors and making infrastructure management more efficient.

## Prerequisites

| **Requirement** | **Description** |
|----------------|----------------|
| Terraform | Terraform must be installed on the system. |
| Jenkins | Jenkins should be set up and configured for pipeline execution. |

## Why Terraform Module CI?
✅ Automates infrastructure validation and testing.  
✅ Ensures code consistency and best practices.  
✅ Reduces risks of misconfiguration.  
✅ Provides cost estimation before applying changes.  
✅ Enhances collaboration in infrastructure development.  

## Terraform CI Steps

| **Step**              | **Description** |
|----------------------|------------------------------------------------------------------|
| **🧹 Clean**           | Removes any existing Terraform state or cache files to start with a clean slate. |
| **📂 Clone**           | Fetches the latest version of the Terraform module from the repository. |
| **⚙️ Init**            | Initializes the Terraform working directory, downloading necessary provider plugins and modules. |
| **📝 Fmt**             | Formats Terraform code to maintain consistency and readability. |
| **✅ Validate**        | Checks the syntax and structure of Terraform configuration files to catch errors before applying them. |
| **🔍 Lint**            | Runs static analysis tools to detect potential issues in the Terraform code. |
| **🔒 Checkov**         | Performs additional verification steps such as compliance and security checks. |
| **💰 Cost Estimation** | Calculates the cost impact of proposed infrastructure changes before applying them. |

---
## CI Workflow

### 🔗 **1. Source Code Management (SCM)**

![image](https://github.com/user-attachments/assets/32ebb930-98d9-483d-a19b-a3df7c9509da)

### 🚀 **2. Pipeline Job Execution**

#### **Shared Library Configuration in Jenkins**
1. Navigate to Jenkins Dashboard → Manage Jenkins → Configure System.
2. Scroll down to Global Pipeline Libraries.
3. Add a new library.
4. Click Save.

![image](https://github.com/user-attachments/assets/3e5c2110-ebf1-4f6b-a0e6-0aa438fa3ddb)

![image](https://github.com/user-attachments/assets/64e65673-810c-4328-b806-f3633233b251)



#### **Pipeline Execution from SCM**
1. Navigate to Jenkins Dashboard → New Item.
2. Select **Pipeline** and provide a name.
3. Under **Pipeline Definition**, choose **Pipeline script from SCM**.
4. Select **Git** and provide the Repository URL.
5. Set **Branch Specifier** to `*/main`.
6. In the **Script Path**, enter `Jenkinsfile`.
7. Click **Save** and then **Build Now**.

![image](https://github.com/user-attachments/assets/e9596831-6bfd-4f7b-a82e-fa9e25770d91)


#### **Jenkinsfile Reference from Git**

![image](https://github.com/user-attachments/assets/075f93a5-10fe-4ac5-89ec-fb8e7f31ddad)


#### **Execution Output:-**

![image](https://github.com/user-attachments/assets/e8c6bcf5-8808-4ed6-bf44-ebb709ad2c96)

![image](https://github.com/user-attachments/assets/760ce84f-567f-4fb8-9837-992ac2fcae70)





### 📊 **3. Report Generation**
- ### **TFLint Report**: Below, you can find an image showing the TFLint report.
- 
   [TfLint Report](https://github.com/mohitmaikhuri03/TerraformCI/blob/main/tflint%20report)


- ### **Checkov Report**: Below, you can find the Link showing the Checkov security report.

  [Checkov Report](https://github.com/mohitmaikhuri03/TerraformCI/blob/main/checkov%20report)

- ### **Infrastructure Cost Report**: Below, you can find the Link showing the Infra cost analysis report.

  [InfraCost Report](https://github.com/mohitmaikhuri03/TerraformCI/blob/main/Infracost%20Report)

### 📦 **4. Shared Library Structure**
The shared library organizes reusable scripts into logical categories:
- **common/**: General-purpose scripts like `gitclone.groovy`, `wsclean.groovy`.
- **template/**: Boilerplate scripts like `check.groovy`.
- **terraformCI/**: Terraform-specific CI scripts like `checkov.groovy`, `fmt.groovy`, `validate.groovy`, etc.

 **GitHub link for the shared library:** [Shared Library](https://github.com/mohitmaikhuri03/TerraformCI.git)

---
## ✅ Benefits of This Workflow
✔️ **Modularity:** The shared library organizes reusable scripts into logical categories, making it easy to maintain.  
✔️ **Reusability:** Functions can be reused across multiple pipelines, reducing duplication.  
✔️ **Automation:** Jenkins automates repetitive tasks like linting, validation, and testing.  
✔️ **Scalability:** New CI tasks can be added easily by creating additional Groovy scripts.  

---
## Contact Information

| **Name** | **Email Address** |
|----------|-------------------------------|
| Mohit Kumar | [📧 mohit.kumar@mygurukulam.co](mailto:mohit.kumar@mygurukulam.co) |

---
## References

| 🌐 Link | 📖 Description |
|---------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------|
| [TFLint Documentation](https://github.com/terraform-linters/tflint) | Terraform Linter documentation. |
| [Infracost Documentation](https://www.infracost.io/docs/) | Infracost documentation for cost estimation. |
| [Terraform CI Documentation](https://developer.hashicorp.com/terraform/tutorials/automation) | HashiCorp Terraform CI/CD guide. |

