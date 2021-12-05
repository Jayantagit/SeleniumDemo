pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                 bat 'clean install -DskipTests=true'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                git 'https://github.com/Jayantagit/SeleniumDemo.git'
                 bat 'clean install'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}