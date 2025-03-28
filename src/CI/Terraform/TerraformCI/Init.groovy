package CI.Terraform.TerraformCI

def terraformInit(String terraformDir) {
    dir(terraformDir) {
        sh 'terraform init'
    }
}
