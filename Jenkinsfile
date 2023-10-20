pipeline {
    agent any
    tools {
        // Utilisation de l'outil Maven
        maven 'Maven'
        dockerTool 'Docker'
    }
    stages {

        stage("test"){
            steps {
                script {
                    echo "testing the app ..."
                }
            }
        }

        stage("build jar") {
            steps {
                script {
                    echo "building the app ..."
                    sh 'mvn package'
                }
            }
        }

        stage("build image") {
            steps {
                script {
                    echo "building the docker image ..."
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'docker build -t pihix/test-app:1.2 .'
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh 'docker push pihix/test-app:1.2'
                    }
                }
            }
        }

        stage("deploy image") {
            steps {
                script {
                    echo "deploy the image ..."
                    def dockerCmd = "docker run -p 8080:8080 -d pihix/test-app:1.2"
                    //On doit se connecter à dockerhub dans le serveur
                    sshagent(['ec2-dev-server']) {
                        sh "ssh -o StrictHostKeyChecking=no ubuntu@13.39.82.122 ${dockerCmd}"
                }
            }
        }
    }   
}
    }
