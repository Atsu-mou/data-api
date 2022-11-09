pipeline {
    agent any
    tools {
        maven '3.8.6'
        jdk 'jdk8'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Build') {
            steps {
                sh '''
                maven clean compile
                maven test
                '''
            }
        }
    }
}