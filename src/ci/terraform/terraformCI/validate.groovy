package ci.terraform.terraformCI

def terraformValidate(String terraformDir) {
    stage('validate') {
    dir(terraformDir) {
        sh 'terraform validate'
    }
}
}
