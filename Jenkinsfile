pipeline {
    agent any
    stages {
        stage('Git Checkout'){
            steps{
                checkout scm: [$class: 'GitSCM', userRemoteConfigs: [[credentialsId: 'github-ssh-key', url: 'https://github.com/ob0420/ordermanagement.git']]]
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test'){
            steps{
                sh 'mvn --batch-mode -Dmaven.test.failure.ignore=true test'
            }
        }
        stage('Deploy'){
            steps{
                sh 'echo Done!'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml' 
                }
            }
        }

    }
}
