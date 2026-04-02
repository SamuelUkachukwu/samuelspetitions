pipeline {
    agent any

    stages {
        stage('Get Code'){
            steps{
            echo 'pulled codes from github'
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