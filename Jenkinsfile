pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                 bat 'mvn clean install -DskipTests=true'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                 bat 'mvn clean test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}