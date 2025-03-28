package ci.terraform.terraformCI

def checkovScan(String terraformDir) {
    dir(terraformDir) {
        sh '''
            pip install -q --upgrade checkov
            checkov -d . --output json > checkov_report.json || true
        '''
        archiveArtifacts artifacts: 'checkov_report.json', fingerprint: true
    }
}
