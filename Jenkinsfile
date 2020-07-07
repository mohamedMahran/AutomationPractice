pipeline {
  agent any
  stages {
    stage('Execute Selenium Tests from Github Repo Using Jenkins 2.0 Pipeline') {
      steps {
        echo 'Execute Tests'
        echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
        echo "Jenkins Workspace ${env.WORKSPACE}"
        bat "mvn -f clean"
        bat "mvn -f test "
      }
    } 
  }
}