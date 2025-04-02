# **TERRAFORM MODULE CI POC**

![image](https://github.com/user-attachments/assets/542dd328-47e7-484f-9283-33bce981af1e)

| **Author** | **Created on** | **Version** | **Last updated by** | **Last Edited On** | **Level** | **Reviewer** |
|------------|--------------|-------------|----------------|---------------|-------------|-------------|
| Mohit Kumar | 30-03-2025 | Version 1 | Mohit Kumar | 30-03-2025 | Internal Reviewer | Harshit Singh|

## Table of Contents
1. [Introduction](#introduction)  
2. [Prerequisites](#prerequisites)  
3. [Why Terraform Module CI?](#why-terraform-module-ci)  
4. [Terraform CI Steps](#terraform-ci-steps)   
5. [Comparison of Terraform Code Quality Checks](#comparison-of-terraform-code-quality-checks)
6. [CI Workflow](#ci-workflow) 
7. [FAQ](#faq)  
8. [Conclusion](#conclusion)  
9. [Contact Information](#contact-information)  
10. [References](#references)  

---
## Introduction
Terraform Module CI/CD (Continuous Integration) ensures the quality, consistency, and security of infrastructure code. It automates testing and validation, reducing human errors and making infrastructure management more efficient.

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

| **Step**              | **Description** | **Command** |
|----------------------|------------------------------------------------------------------|----------------------|
| **Clean**           | Ensures a fresh start by removing any existing Terraform state, cached files, or leftover configurations. | rm -rf .terraform |
| **Clone**           | Retrieves the latest version of the Terraform module from the repository to ensure the pipeline works with updated code. | git clone <repo> |
| **Init**            | Initializes the Terraform working directory by downloading required provider plugins and setting up necessary backend configurations. | terraform init |
| **Fmt**             | Formats Terraform files for better readability and consistency. This helps maintain standardized code formatting. | terraform fmt |
| **Validate**        | Performs syntax validation and checks for logical configuration issues in Terraform files. Detects missing required attributes or misconfigured resources. | terraform validate |
| **Lint**            | Runs static code analysis to flag deprecated resources, hardcoded credentials, or best practice violations. | tflint |
| **Checkov**         | Scans Terraform code against security and compliance policies, identifying misconfigurations that might introduce vulnerabilities. | checkov -d . |
| **Cost Estimation** | Evaluates the financial impact of infrastructure changes by estimating resource costs before deployment. | infracost breakdown --path . |

---



## Comparison of Terraform Code Quality Checks

| **Step**     | **Purpose** | **Example Issue** | **Example Code** | **Fixed Code** |
|-------------|------------|------------------|------------------|---------------|
| **Fmt**      | Ensures consistent formatting by adjusting indentation, spacing, and structure. | Improperly formatted code. | ```hcl resource "aws_instance"{ami="ami-123"} ``` | ```hcl resource "aws_instance" { ami = "ami-123" } ``` |
| **Validate** | Checks for syntax errors and verifies dependencies between Terraform resources. | Missing required fields in a resource. | ```hcl resource "aws_s3_bucket" "example" {} ``` | ```hcl resource "aws_s3_bucket" "example" { bucket = "my-bucket" acl = "private" } ``` |
| **Lint**     | Detects best practice violations, such as hardcoded credentials, deprecated syntax, or insecure configurations. | Hardcoded access keys in Terraform variables. | ```hcl variable "aws_access_key" {default = "ABC123"} ``` | **Error:** Hardcoded credentials should not be used. |
| **Checkov**  | Runs security and compliance checks to identify misconfigurations. | Open security group allowing unrestricted access. | ```hcl resource "aws_security_group" "example" { ingress {cidr_blocks = ["0.0.0.0/0"]} } ``` | **Checkov fails:** Security groups should not allow unrestricted access. |

___

## CI Workflow

![image](https://github.com/user-attachments/assets/29b0ea5e-75e4-4257-9e5d-c4216e8630c7)


## **Workflow Steps** 

### 🔗 **1. Source Code Management (SCM)**

![image](https://github.com/user-attachments/assets/1db87c8b-dfdc-4941-9fa3-289558f354ff)



___

### **2. Pipeline Execution from SCM**
1. Navigate to Jenkins Dashboard → New Item.
2. Select **Pipeline** and provide a name.
3. Under **Pipeline Definition**, choose **Pipeline script from SCM**.
4. Select **Git** and provide the Repository URL.
5. Set **Branch Specifier** to */branch name.
6. In the **Script Path**, enter Jenkinsfile.
7. Click **Save** and then **Build Now**.

Below is the link for Jenkinsfile [Jenkinsfile](https://github.com/snaatak-Zero-Downtime-Crew/jenkins/blob/Mohit-SCRUM-336/CI/Terraform/Jenkinsfile)



![image](https://github.com/user-attachments/assets/b230b19d-e2eb-4087-a8a1-5f3f5f852634)


### Execution Output -

![image](https://github.com/user-attachments/assets/378ba6fe-fe0c-4519-a2d5-4ec8b16b78b8)


___


###  **3. Report Generation**
- ### **TFLint Report**: Below, you can find an image showing the TFLint report.
  
   [TfLint Report](https://github.com/snaatak-Zero-Downtime-Crew/jenkins/blob/Mohit-SCRUM-336/CI/Terraform/TFlint%20Report)

___
- ### **Checkov Report**: Below, you can find the Link showing the Checkov security report.

  [Checkov Report](https://github.com/snaatak-Zero-Downtime-Crew/jenkins/blob/Mohit-SCRUM-336/CI/Terraform/Checkov%20Report)

___
- ### **Infrastructure Cost Report**: Below, you can find the Link showing the Infra cost analysis report.

  [InfraCost Report](https://github.com/snaatak-Zero-Downtime-Crew/jenkins/blob/Mohit-SCRUM-336/CI/Terraform/Infracost%20Report)

___
## FAQ
### What is the difference between TFLint and Checkov?
TFLint focuses on best practices, formatting, and syntax issues, whereas Checkov performs security and compliance checks on infrastructure as code.

### Can I use Checkov instead of Validate?
No, terraform validate checks for syntax and logical errors, while Checkov is used for security misconfigurations.

### Why should I run terraform fmt?
Running terraform fmt ensures consistent formatting, making it easier to read and maintain the code.

### What happens if Checkov fails in CI?
If Checkov fails, it indicates potential security issues. You should fix the reported vulnerabilities before proceeding with deployment.

### How does infracost help in Terraform CI?
Infracost helps estimate cloud resource costs before deployment, aiding in budget planning and cost optimization.

## Conclusion
Terraform Module CI/CD workflow ensures infrastructure code is tested, validated, and optimized before deployment. It enforces best practices, improves security, and enhances collaboration through automation. By integrating tools like TFLint for code linting, Checkov for security checks, and Infracost for cost estimation, this approach minimizes risks and streamlines infrastructure management. The modular design of the pipeline makes it scalable, maintainable, and adaptable for future improvements.

___
## Contact Information

| **Name** | **Email Address** |
|----------|-------------------------------|
| Mohit Kumar | [mohit.kumar@mygurukulam.co](mailto:mohit.kumar@mygurukulam.co) |

---
## References

|  Link | Description |
|---------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------|
| [TFLint Documentation](https://github.com/terraform-linters/tflint) | Terraform Linter documentation. |
| [Infracost Documentation](https://www.infracost.io/docs/) | Infracost documentation for cost estimation. |
| [Terraform CI Documentation](https://developer.hashicorp.com/terraform/tutorials/automation) | HashiCorp Terraform CI/CD guide. |
