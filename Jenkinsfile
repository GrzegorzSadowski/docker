pipeline {
    agent any
    tools {
            maven 'Maven3'  // Use the name defined in Global Tool Configuration
        }
    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                sh 'mvn clean install' // This will build the project
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'mvn test' // Run all tests
            }
        }
    }
    post {
        success {
            setBuildStatus("Build succeeded", "SUCCESS");
        }
        failure {
            setBuildStatus("Build failed", "FAILURE");
        }
      }
}