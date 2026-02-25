pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK21'   // <-- changed from JDK17
    }

    environment {
        JAVA_HOME = '/usr/lib/jvm/java-21-openjdk-amd64'
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project...'
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'mvn test'
            }
        }
    }

    post {
        success {
            echo '✅ Build and Tests Successful!'
        }
        failure {
            echo '❌ Build Failed!'
        }
    }
}
