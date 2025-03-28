package ci.terraform.terraformCI

def terraformFormat(String terraformDir) {
    dir(terraformDir) {
        sh 'terraform fmt '
    }
}
