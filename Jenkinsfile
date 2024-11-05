pipeline {
    agent any

    tools {
        maven 'M3'  // Ensure Maven is configured in Jenkins
    }

    environment {
        GITHUB_TOKEN = credentials('github-token') // GitHub token for authentication
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
                    def commitSHA = sh(script: 'git rev-parse HEAD', returnStdout: true).trim()
                    try {
                        // Set PR status to "Pending"
                        githubPRStatusPublisher context: 'Jenkins Build', status: 'PENDING', message: 'Build in progress'

                        // Perform Maven build
                        sh 'mvn clean install'

                        // If build succeeds, set PR status to "Success"
                        githubPRStatusPublisher context: 'Jenkins Build', status: 'SUCCESS', message: 'Build passed'

                    } catch (e) {
                        // If build fails, set PR status to "Failure"
                        githubPRStatusPublisher context: 'Jenkins Build', status: 'FAILURE', message: 'Build failed'
                        throw e
                    }
                }
            }
        }