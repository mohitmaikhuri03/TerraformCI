package ci.terraform.terraformCI

def terraformCostEstimate(String terraformDir, String INFRACOST_API_KEY) {
    dir(terraformDir) {
        sh """
            if ! command -v infracost &> /dev/null; then
                curl -fsSL https://raw.githubusercontent.com/infracost/infracost/master/scripts/install.sh | sh
            fi
            
            export INFRACOST_API_KEY=${INFRACOST_API_KEY}
            
            infracost breakdown --path . --format json > infracost_report.json || true
        """
        archiveArtifacts artifacts: 'infracost_report.json', fingerprint: true
    }
}
