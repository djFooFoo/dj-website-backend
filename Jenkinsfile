pipeline {
    stages {
        stage('Install') {
            agent {
                docker {
                    image 'maven:latest'
                    args '-v /root/.m2:/root/.m2'
                }
            }
            steps {
                sh 'java -version'
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Test') {
            agent {
                docker {
                    image 'maven:latest'
                    args '-v /root/.m2:/root/.m2'
                }
            }
            steps {
                sh 'BUILD_ID=dontKillMe nohup mvn spring-boot:run &'
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
