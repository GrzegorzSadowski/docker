pipeline {
    agent any

    triggers {
        // Trigger this pipeline for each Pull Request (GitHub webhook needs to be set up)
        pollSCM('* * * * *') // Alternatively, use GitHub webhook for triggering on PR
    }

    environment {
        MAVEN_HOME = tool 'Maven'  // Assumes Maven is installed in Jenkins and set as "Maven" tool
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                script {
                    withMaven(maven: 'Maven') {  // Use configured Maven installation in Jenkins
                        sh 'mvn clean test'
                    }
                }
            }
        }

        stage('Code Quality Checks') {
            steps {
                script {
                    withMaven(maven: 'Maven') {
                        // Run Checkstyle, SpotBugs, Dependency Check, or other checks here
                        sh 'mvn checkstyle:check spotbugs:check'
                    }
                }
            }
        }
    }

    post {
        always {
            // Archive artifacts, for example, test reports
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
            junit 'target/surefire-reports/*.xml'
        }

        failure {
            // Notify if the build fails (optional)
            echo 'Build failed!'
        }
    }
}