// @Library('mera@main') _

// def CICheck = new ci.terraform.template.template()

// pipeline {
//     agent any
    
//      tools {
//         terraform 'terraform' 
//     }

//     environment {
//         AWS_ACCESS_KEY_ID     = credentials('AWS_ACCESS_KEY_ID')
//         AWS_SECRET_ACCESS_KEY = credentials('AWS_SECRET_ACCESS_KEY')
//         AWS_DEFAULT_REGION    = 'us-east-1'
//         repoUrl = 'https://github.com/mohitmaikhuri03/VAULT-TOOL.git'
//         credentialsId = 'Personal'
//         branch = 'main'
//         terraformDir = '.'
//         INFRACOST_API_KEY = credentials('INFRACOST_API_KEY')
//     }

//     stages {
//         stage('Terraform CI CHECKS') {
//             steps {
//                 script {
//                     CICheck.runpipeline(env.terraformDir, env.branch, env.repoUrl, env.credentialsId, env.INFRACOST_API_KEY)
//                 }
//             }
//         }
//     }
// }


// ------------------------------------------------------


@Library('TerraformCI@main') _

def CICheck = new ci.terraform.template.template()

pipeline {
    agent any

    tools {
        terraform 'terraform'
    }

    environment {
        AWS_ACCESS_KEY_ID     = credentials('AWS_ACCESS_KEY_ID')
        AWS_SECRET_ACCESS_KEY = credentials('AWS_SECRET_ACCESS_KEY')
        AWS_DEFAULT_REGION    = 'us-east-1'
        repoUrl = 'https://github.com/mohitmaikhuri03/VAULT-TOOL.git'
        credentialsId = 'Personal'
        branch = 'main'
        terraformDir = '.'
        INFRACOST_API_KEY = credentials('INFRACOST_API_KEY')
    }

    stages {
        stage('Clean Workspace') {
            steps {
                script {
                    def Clean = new ci.terraform.common.wsclean()
                    Clean.clean()
                }
            }
        }

        stage('Clone Repository') {
            steps {
                script {
                    def Clone = new ci.terraform.common.gitclone()
                    Clone.clone(env.branch, env.repoUrl, env.credentialsId)
                }
            }
        }

        stage('Terraform Init') {
            steps {
                script {
                    def Init = new ci.terraform.terraformCI.init()
                    Init.terraformInit(env.terraformDir)
                }
            }
        }

        stage('Terraform Format Check') {
            steps {
                script {
                    def Fmt = new ci.terraform.terraformCI.fmt()
                    Fmt.terraformFormat(env.terraformDir)
                }
            }
        }

        stage('Terraform Validate') {
            steps {
                script {
                    def Validate = new ci.terraform.terraformCI.validate()
                    Validate.terraformValidate(env.terraformDir)
                }
            }
        }

        stage('Terraform Linting') {
            steps {
                script {
                    def Lint = new ci.terraform.terraformCI.lint()
                    Lint.tflintScan(env.terraformDir)
                }
            }
        }

        stage('Checkov Security Scan') {
            steps {
                script {
                    def Checkov = new ci.terraform.terraformCI.checkov()
                    Checkov.terraformcheckov(env.terraformDir)
                }
            }
        }

        stage('Terraform Cost Estimation') {
            steps {
                script {
                    def Cost = new ci.terraform.terraformCI.cost()
                    Cost.terraformCostEstimate(env.terraformDir, env.INFRACOST_API_KEY)
                }
            }
        }
    }
}



