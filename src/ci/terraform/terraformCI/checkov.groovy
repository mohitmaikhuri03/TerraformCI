package ci.terraform.terraformCI

def terraformcheckov(String terraformDir) {
    dir(terraformDir) {
        sh '''
            sudo pip install -q --upgrade checkov
            checkov -d . --output json > checkov_report.json || true
        '''
        archiveArtifacts artifacts: 'checkov_report.json', fingerprint: true
    }
}
