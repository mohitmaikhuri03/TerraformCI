package CI.Terraform.Template

import CI.Terraform.Common.*
import CI.Terraform.TerraformCI.*

def runpipeline(String terraformDir, String branch, String repoUrl, String credentialsId = null)
{
  
  

  def clean = new wsclean()
  def clone = new gitclone()
  def init = new TerraformInit()
  def fmt = new Terraformfmt()
  def validate = new TerraformValidate()

  Clean.clean()
  Clone.clone(branch, repoUrl, credentialsId)
  init.terraformInit(terraformDir)
  fmt.terraformFormat(terraformDir)
  validate.terraformValidate(terraformDir)
  
}
  
  
