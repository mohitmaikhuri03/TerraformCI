package ci.terraform.template

import ci.terraform.common.*
import ci.terraform.terraformCI.*

def runpipeline(String terraformDir, String branch, String repoUrl, String credentialsId = null)
{
   Clean = new wsclean()
   Clone = new gitclone()
   Init = new init()
   Fmt = new fmt()
   Validate = new validate()
   Lint = new lint()

  Clean.clean()
  Clone.clone(branch, repoUrl, credentialsId)
  Init.terraformInit(terraformDir)
  Fmt.terraformFormat(terraformDir)
  Validate.terraformValidate(terraformDir)
  Lint.tflintScan(terraformDir)
  
}
  
  
