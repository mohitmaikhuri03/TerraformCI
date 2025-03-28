package ci.terraform.common
def clone(String branch, String repoUrl, String credentialsId = null) {
    if (credentialsId) {
        git branch: branch, url: repoUrl, credentialsId: credentialsId
    } else {
        git branch: branch, url: repoUrl
    }
}
