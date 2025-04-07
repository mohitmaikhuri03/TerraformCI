package ci.terraform.terraformCI

def terraformCostEstimate(String terraformDir, String INFRACOST_API_KEY) {
    stage('Cost') {
    dir(terraformDir) {
        withEnv(["INFRACOST_API_KEY=${INFRACOST_API_KEY}"]) {  
            sh """
                if ! command -v infracost >/dev/null 2>&1; then
                    curl -fsSL https://raw.githubusercontent.com/infracost/infracost/master/scripts/install.sh | sh
                fi
                
                # Generate JSON cost estimate first
                infracost breakdown --path . --format json --out-file infracost.json || true
                
                # Convert JSON to HTML report
                infracost output --format html --path infracost.json --out-file infracost_report.html || true
            """
        }
        archiveArtifacts artifacts: 'infracost_report.html', fingerprint: true
    }
}
}
