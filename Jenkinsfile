pipeline {
    environment { 
        registry = "navjitkaur/php"  
        registryCredential = 'dockerhub'  
        dockerImage = '' 
    }
    agent any
    stages {
        stage('Static Code Analysis') { 
            steps { 
                 script {
                    try {
                        sh 'phpcs /var/lib/jenkins/workspace/Code_Sniffer/'
                    } 
                    catch (err) {
                        echo err.getMessage()
                    }
                }
            }
        }
        stage('Docker compose') {
            steps {
                sh "sudo docker-compose up -d --build"  
            }
        }
        
        stage('Jmeter Test') {
            steps {
                sh '''cd /home/ubuntu/apache-jmeter-5.4.1/bin
                sh jmeter.sh -Jjmeter.save.saveservice.output_format=xml -n -t /home/ubuntu/apache-jmeter-5.4.1/bin/demo1.jmx -l /home/ubuntu/apache-jmeter-5.4.1/bin/report.jtl '''

            }
        }
       stage('Jmeter Publish') {
            steps { 
                perfReport filterRegex: '', showTrendGraphs: true, sourceDataFiles: '/home/ubuntu/apache-jmeter-5.4.1/bin/report.jtl'
            }
       }
        
        stage('testing') {
            steps {
                dir("selenium"){
                    sh "sudo mvn test"
                }
            }
        }
        
        stage('remove dangling images') {
            steps {
                sh """
                sudo docker images -q -f dangling=true | xargs --no-run-if-empty docker rmi
                """
            }
        }
    }
}
