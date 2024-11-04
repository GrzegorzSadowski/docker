pipeline {
    agent any

    environment {
        // Define environment variables if needed
        MAVEN_HOME = '/usr/share/maven' // Adjust if necessary
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the source code from the Git repository
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Run Maven build
                script {
                    def mvnHome = tool name: 'Maven 3.x', type: 'maven'
                    withEnv(["MAVEN_HOME=${mvnHome}"]) {
                        sh "'${MAVEN_HOME}/bin/mvn' clean package"
                    }
                }
            }
        }

        stage('Code Analysis') {
            parallel {
                stage('Checkstyle') {
                    steps {
                        // Run Checkstyle
                        sh "'${MAVEN_HOME}/bin/mvn' checkstyle:check"
                    }
                }
                stage('SpotBugs') {
                    steps {
                        // Run SpotBugs
                        sh "'${MAVEN_HOME}/bin/mvn' spotbugs:check"
                    }
                }
                stage('Dependency Check') {
                    steps {
                        // Run Dependency Check
                        sh "'${MAVEN_HOME}/bin/mvn' dependency-check:check"
                    }
                }
            }
        }
    }

    post {
        always {
            // Cleanup or notify actions can be added here
            echo 'Pipeline finished.'
        }

        failure {
            // Actions to take if the pipeline fails
            echo 'Build failed. Check the logs for errors.'
        }
    }
}
