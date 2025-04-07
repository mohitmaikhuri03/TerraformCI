package ci.terraform.terraformCI

def tflintScan(String terraformDir) {
    stage('Lint') {
    dir(terraformDir) {
        sh """ 
            if ! command -v tflint &> /dev/null; then
                curl -s https://raw.githubusercontent.com/terraform-linters/tflint/master/install_linux.sh | bash
            fi
            tflint --format json > tflint_report.json || true
        """
        archiveArtifacts artifacts: 'tflint_report.json', fingerprint: true
    }
}
}
