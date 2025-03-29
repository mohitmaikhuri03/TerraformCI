# Terraform CI Pipeline

## Table of Contents
1. [Introduction](#introduction)  
2. [Why Terraform CI?](#why-terraform-ci)  
3. [Terraform CI Pipeline Steps](#terraform-ci-pipeline-steps)  
   - [Clean](#clean-details)  
   - [Clone](#clone-details)  
   - [Init](#init-details)  
   - [Fmt](#fmt-details)  
   - [Validate](#validate-details)  
   - [Lint](#lint-details)  
   - [Check](#check-details)  
   - [Cost Estimation](#cost-estimation-details)  
4. [Project Structure](#project-structure)  

---

## Introduction
Terraform CI is an automated pipeline to validate, lint, and check Terraform code before applying infrastructure changes.

## Why Terraform CI?
Using a CI pipeline for Terraform ensures that code is formatted, validated, and reviewed before deployment, reducing errors and improving team collaboration.

## Terraform CI Pipeline Steps

### <a name="clean-details"></a>Clean
<details>
<summary>Details</summary>
The `clean` step ensures that any previous Terraform state files, logs, or temporary files are removed before running the pipeline.
</details>

### <a name="clone-details"></a>Clone
<details>
<summary>Details</summary>
The `clone` step fetches the latest Terraform code from the repository.
</details>

### <a name="init-details"></a>Init
<details>
<summary>Details</summary>
The `init` step initializes Terraform by downloading necessary provider plugins and setting up the backend.
</details>

### <a name="fmt-details"></a>Fmt
<details>
<summary>Details</summary>
The `fmt` step checks and formats Terraform code to maintain consistency.
</details>

### <a name="validate-details"></a>Validate
<details>
<summary>Details</summary>
The `validate` step ensures that the Terraform configuration is syntactically correct.
</details>

### <a name="lint-details"></a>Lint
<details>
<summary>Details</summary>
The `lint` step runs static analysis tools to catch potential issues in Terraform code.
</details>

### <a name="check-details"></a>Check
<details>
<summary>Details</summary>
The `check` step performs a dry run (`terraform plan`) to detect potential issues before applying changes.
</details>

### <a name="cost-estimation-details"></a>Cost Estimation
<details>
<summary>Details</summary>
The `cost estimation` step estimates the cost of infrastructure changes before applying them.
</details>

## Project Structure
```
project-root/
│── terraform/
│   ├── main.tf
│   ├── variables.tf
│   ├── outputs.tf
│   ├── backend.tf
│── ci-pipeline/
│   ├── clean.sh
│   ├── clone.sh
│   ├── init.sh
│   ├── fmt.sh
│   ├── validate.sh
│   ├── lint.sh
│   ├── check.sh
│   ├── cost-estimation.sh
│── README.md
```

This README provides an overview of the Terraform CI pipeline and its steps.
