package ci.terraform.common
def clone(String branch, String repoUrl, String credentialsId = null) {
    if (credentialsId) {
        git branch: branch, url: url, credentialsId: credentialsId
    } else {
        git branch: branch, url: url
    }
}
