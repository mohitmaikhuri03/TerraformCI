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
5. [CI/CD Workflow](#cicd-workflow)  
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
## CI/CD Workflow

```mermaid
digraph {
    A[🔗 SCM - e.g., Git] -> B[🛠 Jenkins Server]
    B -> C{🚀 Pipeline Job}
    C -> D[📜 Jenkinsfile]
    D -> E[📦 Shared Library]
    E -> F{📁 src Directory}
    F -> G{📁 ci Directory}
    G -> H{📁 terraform Directory}
    H -> J{📁 common}
    H -> K{📁 template}
    H -> L{📁 terraformCI}
    J -> M[📜 gitclone.groovy]
    J -> N[📜 wsclean.groovy]
    K -> O[📜 template.groovy]
    L -> P[🔒 checkov.groovy]
    L -> Q[💰 cost.groovy]
    L -> R[📝 fmt.groovy]
    L -> S[⚙️ init.groovy]
    L -> T[🔍 lint.groovy]
    L -> U[✅ validate.groovy]
}
```

## Workflow Explanation

### 🔗 **1. Source Code Management (SCM)**

![SCM Image](https://github.com/user-attachments/assets/0685e9d1-66e2-4487-9c78-052544b86f51)

### 🚀 **2. Pipeline Job Execution**

#### **Shared Library Configuration in Jenkins**
1. Navigate to Jenkins Dashboard → Manage Jenkins → Configure System.
2. Scroll down to Global Pipeline Libraries.
3. Add a new library.
4. Click Save.

![Library Image](https://github.com/user-attachments/assets/fd276d30-feec-4d28-b053-df20dca24f2a)
![Library Image 2](https://github.com/user-attachments/assets/4a5518b8-f498-4255-b978-c456d3678d39)

#### **Pipeline Execution from SCM**
1. Navigate to Jenkins Dashboard → New Item.
2. Select **Pipeline** and provide a name.
3. Under **Pipeline Definition**, choose **Pipeline script from SCM**.
4. Select **Git** and provide the Repository URL.
5. Set **Branch Specifier** to `*/main`.
6. In the **Script Path**, enter `Jenkinsfile`.
7. Click **Save** and then **Build Now**.

#### **Jenkinsfile Reference from Git**
[Insert Jenkinsfile Link Here]

#### **Execution Output**

### 📊 **3. Report Generation**
- **TFLint Report**: Below, you can find an image showing the TFLint report.
- **Checkov Report**: Below, you can find an image showing the Checkov security report.
- **Infrastructure Cost Report**: Below, you can find an image showing the Infra cost analysis report.

### 📦 **4. Shared Library Structure**
The shared library organizes reusable scripts into logical categories:
- **common/**: General-purpose scripts like `gitclone.groovy`, `wsclean.groovy`.
- **template/**: Boilerplate scripts like `check.groovy`.
- **terraformCI/**: Terraform-specific CI scripts like `checkov.groovy`, `fmt.groovy`, `validate.groovy`, etc.

GitHub link for the shared library: [Insert GitHub Link Here]

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

