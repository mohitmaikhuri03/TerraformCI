package ci.terraform.terraformCI

def terraformInit(String terraformDir) {
    dir(terraformDir) {
        sh 'terraform init'
    }
}
