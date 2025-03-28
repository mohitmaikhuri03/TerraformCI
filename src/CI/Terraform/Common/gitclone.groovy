package CI.Terraform.Common
def clone(String branch, String url, String credentialsId = null) {
    if (credentialsId) {
        git branch: branch, url: url, credentialsId: credentialsId
    } else {
        git branch: branch, url: url
    }
}
