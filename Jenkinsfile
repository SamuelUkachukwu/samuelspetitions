pipeline {
    agent any

    environment {
            APP_NAME = "samuelspetitions"
        }

    stages {
        stage('Get Code'){
            steps{
            echo 'pulled source codes from GitHub'
            }
        }
        stage('Build'){
            steps{
                echo "Cleaning and compiling ${APP_NAME} project..."
                sh 'mvn clean compile'
             }
        }
        stage('Test'){
            steps{
                echo 'Running unit tests...'
                sh 'mvn test'
            }
        }
        stage('Package'){
            steps{
                echo 'Packaging the project as WAR...'
                sh 'mvn package'
            }
        }
        stage('Approve Deploy') {
            steps {
                input message: 'Do you want to deploy?', ok: 'Deploy'
            }
        }
        stage('Deploy'){
            steps{
                echo "Starting deployment..."
                sh "sudo cp target/${APP_NAME}.war /var/lib/tomcat9/webapps/"
                echo 'Deployment done!'
            }
        }
    }
    post {
            success {
                echo 'Pipeline successful!'
        }
            failure {
                echo 'Pipeline failed!'
        }
    }
}