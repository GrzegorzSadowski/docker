pipeline {
    agent any
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
            script {
                githubNotify context: 'Jenkins', description: 'Build passed', status: 'SUCCESS'
            }
        }
        failure {
            script {
                githubNotify context: 'Jenkins', description: 'Build failed', status: 'FAILURE'
            }
        }
    }
}