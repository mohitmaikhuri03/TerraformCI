// package ci.terraform.terraformCI

// def terraformInit(String terraformDir) {
//     dir(terraformDir) {
//         sh 'terraform init'
//     }
// }
package ci.terraform.terraformCI

def terraformInit(String terraformDir) {
    stage('init') {
        dir(terraformDir) {
            sh 'terraform init'
        }
    }
}

