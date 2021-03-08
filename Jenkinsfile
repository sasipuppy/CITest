pipeline {
      environment {
          PATH = "C:\\WINDOWS\\SYSTEM32;C:\\Program Files\\Java\\jdk1.8.0_231\\bin"
      }
      agent {
          node { label "cicd" }
      }
      tools {
          maven 'M2_HOME'
      }
      options {
            timestamps ()
      }
      stages {
          
          stage ('Clone code') {
		
             steps {
                    git url: 'https://github.com/sasipuppy/SpringBootCITest.git'
                   }
          }
          stage ('Build') {
		
             steps {
                    
                    bat 'mvn clean install'
              }
              post {
                  always {
                      junit 'target/surefire-reports/**/*.xml'
                  }
              }
          
        }
      }
}
