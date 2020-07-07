pipeline {
    agent any 
    stages {
        stage('Clean') { 
            steps {
               bat "mvn -f AutomationPractice clean"
            }
        }
        stage('Test') { 
            steps {
                bat "mvn -f AutomationPractice test"
            }
        }

    }
}