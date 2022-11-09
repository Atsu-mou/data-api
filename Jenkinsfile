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
                    export PATH="/opt/java/openjdk/bin/:$PATH"
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                    echo "JAVA_HOME = ${JAVA_HOME}"
                    which java
                '''
            }
        }

        stage ('Build') {
            steps {
                sh 'mvn test'
            }
        }
    }
}