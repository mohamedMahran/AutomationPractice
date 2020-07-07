pipeline {
    agent any 
    stages {
        stage('Clean') { 
            steps {
               bat "mvn -f openmrs clean"
            }
        }
        stage('Test') { 
            steps {
                bat "mvn -f openmrs test"
            }
        }
        stage('Deploy') { 
            steps {
                // 
            }
        }
    }
}