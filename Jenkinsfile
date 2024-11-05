pipeline {
    agent any

    tools {
        maven 'M3' // Ensure the Maven version 'M3' is configured in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                script {
                    try {
                        // Run Maven build
                        sh 'mvn clean install'
                        // Notify GitHub of success
                        githubNotify context: 'Build', status: 'SUCCESS', description: 'Build succeeded'
                    } catch (e) {
                        // Notify GitHub of failure
                        githubNotify context: 'Build', status: 'FAILURE', description: 'Build failed'
                        throw e // re-throw exception to mark pipeline as failed
                    }
                }
            }
        }
    }
}