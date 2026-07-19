pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK26'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
            dir('emprestapi'){
                bat 'mvn clean package'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t springboot-app .'
            }
        }

        stage('Stop Old Container') {
            steps {
                bat 'docker stop springboot-container || exit 0'
                bat 'docker rm springboot-container || exit 0'
            }
        }

        stage('Run Container') {
            steps {
                bat 'docker run -d -p 8080:8080 --name springboot-container springboot-app'
            }
        }
    }
}