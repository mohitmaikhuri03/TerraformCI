// package ci.terraform.terraformCI

// def terraformcheckov(String terraformDir) {
//     dir(terraformDir) {
//         sh '''
//             if ! command -v checkov &> /dev/null; then
//                 pip install --user -q --upgrade checkov
//             fi
//             export PATH=$HOME/.local/bin:$PATH
//             checkov -d . --output json > checkov_report.json || true
//         '''
//         archiveArtifacts artifacts: 'checkov_report.json', fingerprint: true
//     }
// }

package ci.terraform.terraformCI

def terraformcheckov(String terraformDir) {
    dir(terraformDir) {
        sh '''
            if ! command -v checkov &> /dev/null; then
                pip install --user -q --upgrade checkov
            fi
            export PATH=$HOME/.local/bin:$PATH
        
            checkov -d . --output cli | tee checkov_report.txt

            PASSED_COUNT=$(grep -oP 'Passed checks: \\K\\d+' checkov_report.txt)
            echo " Total Passed Checks: $PASSED_COUNT"
        '''
        archiveArtifacts artifacts: 'checkov_report.txt', fingerprint: true
    }
}
