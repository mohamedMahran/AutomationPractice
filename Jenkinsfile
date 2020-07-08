pipeline {
  agent any
  stages {
    
    	stage('Clean Project') 
    	{
      		steps 
      		{
        		echo 'Clean Tests'
        		echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
        		echo "Jenkins Workspace ${env.WORKSPACE}"
        		bat "mvn -f pom.xml clean"
        	}
    	}
    
   		stage('Execute Tests') 
    		{
    		
      		steps 
      			{
      			echo 'Execute Tests'
        		bat "mvn -f pom.xml test "
      			}
    		}
    	stage ('Archive target folder')
   		 {
    		steps
    		{
        
       		// Archive the built artifacts
  			archive '/target/*.jar'
  			}
		 }
		stage('Publish Extent Report')
		{
			steps
			{
  			
 	 		publishHTML (target: 
 	 			[
      		 	allowMissing: false,
      	 	 	alwaysLinkToLastBuild: false,
     	 	 	keepAll: true,
     	 	 	reportDir: 'TestReport',
     	 	 	reportFiles: 'Test-Automaton-Report.html',
      	 	 	reportName: "HTML Report"
    			])
    		}    		
    	}
    	stage('Generate testNG report')
    	{
    	steps
    		{
    	publishHTML(target:
    			[
    			allowMissing: true, 
    			alwaysLinkToLastBuild: false, 
    			keepAll: true, 
    			reportDir: 'target/surefire-reports', 
    			reportFiles: 'emailable-report.html', 
    			reportName: 'Code Coverage', 
    			reportTitles: ''
    			])
    		}
    	}
    	
    	stage ('sending email')
    		{
    			steps {
    			notify('Started')
    			}
    		}
    	   	 
	 }
  }
    	   def notify(status)
    	   {
    	   emailext
    	   		(
    	   to: "mohamedmahran72@gmail.com"
    	   subject:  "${status}:Job '${env.JOB_NAME}' [$ {env.Build_Number]'",
    	   body: """<p>${status}:Job '${env.JOB_NAME}' [$ {env.Build_Number]':</p>
    	   <p> Check console output at <a herf ='${env.BUILD_URL}'>'${env.JOB_NAME}' [$ {env.Build_Number] </a></p>""",
    	   		)
    	   }