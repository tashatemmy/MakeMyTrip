pipeline {
    agent any

    environment {
        // Secure your credentials via Jenkins > Credentials (preferred)
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
                sh 'mvn test -Dsurefire.suiteXmlFiles=testng.xml'
            }
        }

        stage('Run BrowserStack Desktop Tests') {
            steps {
                echo '📱 Running cross-platform tests on BrowserStack...'
                sh 'mvn test -Dsurefire.suiteXmlFiles=testng-browserstack-desktop.xml'
            }
        }
        
        stage('Run BrowserStack Mobile Tests') {
            steps {
                echo '📱 Running cross-platform tests on BrowserStack...'
                sh 'mvn test -Dsurefire.suiteXmlFiles=testng-browserstack-desktop.xml'
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
