pipeline {
  agent any
  stages {
    stage('Execute Automation Tests from Github Using Jenkins Pipeline') {
      steps {
        echo 'Execute Tests'
        echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
        echo "Jenkins Workspace ${env.WORKSPACE}"
        bat "mvn -f pom.xml clean"
        bat "mvn -f pom.xml test "
       // Archive the built artifacts
  		archiveArtifacts (excludes: '/target/')

  		// publish html
  		// snippet generator doesn't include "target:"
  		// https://issues.jenkins-ci.org/browse/JENKINS-29711.
 	 publishHTML (target: [
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