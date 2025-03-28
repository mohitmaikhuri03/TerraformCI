package ci.terraform.terraformCI

def terraformcheckov(String terraformDir) {
    dir(terraformDir) {
        sh '''
            if ! command -v checkov &> /dev/null; then
                pip install --user -q --upgrade checkov
            fi
            export PATH=$HOME/.local/bin:$PATH
            checkov -d . --output json > checkov_report.json || true
        '''
        archiveArtifacts artifacts: 'checkov_report.json', fingerprint: true
    }
}
