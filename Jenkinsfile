pipeline {

    agent any

    environment {
        IMAGE = "gowthammuralidharan/userregistration:v1"
    }

    stages {

        stage('Clone') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t %IMAGE% .'
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'gowthammuralidharan',
                    usernameVariable: 'USER',
                    passwordVariable: 'PASS'
                )]) {

                    bat 'docker login -u %USER% -p %PASS%'
                    bat 'docker push %IMAGE%'
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                bat '''
                docker stop user-app
                docker rm user-app
                exit /b 0
                '''
                bat 'docker run -d -p 4040:4040 --name user-app %IMAGE%'
            }
        }
    }
}