package ci.terraform.terraformCI

def terraformFormat(String terraformDir) {
    stage ('fmt') {
    dir(terraformDir) {
        sh 'terraform fmt '
    }
    }
}
