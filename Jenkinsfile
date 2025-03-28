@Library('mera@main') _

def CICheck = new CI.Terraform.Template.check()

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
    }

    stages {
        stage('Terraform CI CHECKS') {
            steps {
                script {
                    CICheck.runpipeline(env.terraformDir, env.branch, env.repoUrl, env.credentialsId)
                }
            }
        }
    }
}
