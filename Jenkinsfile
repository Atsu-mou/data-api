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

                    export JAVA_HOME="/opt/java/openjdk"

                    export PATH=$JAVA_HOME/bin:$PATH
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                    echo "JAVA_HOME = ${JAVA_HOME}"
                    which java
                '''
            }
        }

        stage ('Build') {
            steps {
                sh '''
                    export PATH=$JAVA_HOME/bin:$PATH
                    export JAVA_HOME="/opt/java/openjdk"
                    mvn test
                '''
            }
        }
    }
}