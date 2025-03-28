package CI.Terraform.TerraformCI

def terraformValidate(String terraformDir) {
    dir(terraformDir) {
        sh 'terraform validate'
    }
}
