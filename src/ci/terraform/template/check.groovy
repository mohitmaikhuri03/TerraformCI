package ci.terraform.template

import ci.terraform.common.*
import ci.terraform.terraformCI.*

def runpipeline(String terraformDir, String branch, String repoUrl, String credentialsId = null, String INFRACOST_API_KEY)
{
   
   // making the instnace of the class in short object to call it as method
   Clean = new wsclean()
   Clone = new gitclone()
   Init = new init()
   Fmt = new fmt()
   Validate = new validate()
   Lint = new lint()
   Checkov = new checkov()
   Cost = new cost()

   // calling the method 
  Clean.clean()
  Clone.clone(branch, repoUrl, credentialsId)
  Init.terraformInit(terraformDir)
  Fmt.terraformFormat(terraformDir)
  Validate.terraformValidate(terraformDir)
  Lint.tflintScan(terraformDir)
  Checkov.terraformcheckov(terraformDir)
  Cost.terraformCostEstimate(terraformDir, INFRACOST_API_KEY)
  
}
  
  
