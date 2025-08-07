pipeline {
    agent any

    environment {
        BROWSERSTACK_USERNAME = 'temiodey_QnwJWA'
        BROWSERSTACK_ACCESS_KEY = 'uFS2paa7xTSUzM7fq2A5'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git url: 'https://github.com/tashatemmy/MakeMyTrip.git', branch: 'main'
            }
        }

        stage('Verify Maven Setup') {
            steps {
                echo 'Checking Maven version...'
                sh 'mvn -v'
            }
        }

        stage('Build Project') {
            steps {
                echo 'Building Maven project (no tests)...'
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Run Local Tests') {
            steps {
                echo '🖥️ Running local automation tests...'
                sh 'mvn test -Dsurefire.suiteXmlFiles=testng-local.xml'
            }
        }
    }

    post {
        always {
            echo '✅ Pipeline finished running.'
        }
        success {
            echo '🎉 All tests passed!'
        }
        failure {
            echo '⚠️ Some tests failed. Check test reports.'
        }
    }
}
