package CI.Terraform.TerraformCI

def terraformFormat(String terraformDir) {
    dir(terraformDir) {
        sh 'terraform fmt '
    }
}
