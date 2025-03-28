package ci.terraform.terraformCI

def tflintScan(String terraformDir) {
    dir(terraformDir) {
        sh "tflint --format json > tflint_report.json || true"

        archiveArtifacts artifacts: 'tflint_report.json', fingerprint: true
    }
}
