package ci.terraform.terraformCI

def terraformValidate(String terraformDir) {
    dir(terraformDir) {
        sh 'terraform validate'
    }
}
