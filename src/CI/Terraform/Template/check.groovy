package CI.Terraform.Template

import CI.Terraform.Common.*
import CI.Terraform.TerraformCI.*

def runpipeline(String terraformDir, String branch, String repoUrl, String credentialsId = null)
{
  
  Clean = new wsclean()
  Clone = new gitclone()
  init = new TerraformInit()
  fmt = new TerraformFmt()
  validate = new Terrafromvalidate()

  Clean.clean()
  Clone.clone(branch, repoUrl, credentialsId)
  init.terraformInit(terraformDir)
  fmt.terraformFormat(terraformDir)
  validate.terraformValidate(terraformDir)
  
}
  
  
