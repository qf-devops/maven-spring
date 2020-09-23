pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v $HOME/.m2:/root/.m2'
        }
    }

    stages {
        stage('Build') {
            steps {
                git branch: 'vsm2', url: 'https://github.com/quickfixtech/maven-spring.git'
                sh "mvn -Dmaven.test.failure.ignore=true clean deploy -s settings.xml"               
            }

            post {
               
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}
