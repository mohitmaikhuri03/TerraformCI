package ci.terraform.terraformCI

def tflintScan(String terraformDir) {
    dir(terraformDir) {
        sh """ 
            curl -s https://raw.githubusercontent.com/terraform-linters/tflint/master/install_linux.sh | bash
            tflint --format html > tflint_report.html || true
        """
        archiveArtifacts artifacts: 'tflint_report.html', fingerprint: true
    }
}
