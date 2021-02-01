pipeline {
    agent {
        docker {
            image 'maven:3.6.3-jdk-15'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'java -version'
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                script {
                        // configure registry
                        docker.withRegistry('https://082272919318.dkr.ecr.eu-west-3.amazonaws.com', 'ecr:eu-west-3:aws.dieter.jordens') {
                        def myImage = docker.build('dj-website-backend')
                        myImage.push('latest')
                    }
                }
            }
        }
    }
}
