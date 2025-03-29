package ci.terraform.terraformCI

def terraformCostEstimate(String terraformDir, String INFRACOST_API_KEY) {
    dir(terraformDir) {
        withEnv(["INFRACOST_API_KEY=${INFRACOST_API_KEY}"]) {  
            sh """
                if ! command -v infracost >/dev/null 2>&1; then
                    curl -fsSL https://raw.githubusercontent.com/infracost/infracost/master/scripts/install.sh | sh
                fi
                
                infracost breakdown --path . --format html > infracost_report.html || true
            """
        }
        archiveArtifacts artifacts: 'infracost_report.html', fingerprint: true
    }
}
