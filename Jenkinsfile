pipeline {
    agent any
    
    tools {
        maven "MAVEN"
        jdk "JDK"
    }

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
                git 'https://github.com/Jayantagit/SeleniumDemo.git'
                 bat 'mvn clean install'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}