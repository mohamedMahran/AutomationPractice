pipeline {
  agent any
  stages {
    
    	stage('Clean Automation Tests') 
    	{
      		steps 
      		{
        		echo 'Clean Tests'
        		echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
        		echo "Jenkins Workspace ${env.WORKSPACE}"
        		bat "mvn -f pom.xml clean"
        	}
    	}
    
   		stage('Test Automation Tests') 
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
  			archive '/target/*.jar
  			}
		}
		stage('Publish Extent Report')
		{
			Steps
			{
  			// publish html
  			// snippet generator doesn't include "target:"
  			// https://issues.jenkins-ci.org/browse/JENKINS-29711.
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
	  } 
  }
