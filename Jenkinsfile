pipeline {
  agent any
  tools {
    jdk 'JDK'
    maven 'M3'
  }
  stages {
    stage('Build') {
      steps {
        configFileProvider([
          configFile(fileId: 'maven-settings', // matches the fileId in jenkins
                     variable: 'MAVEN_SETTINGS')//assign path to this var
        ]) {
          sh 'mvn -B -s $MAVEN_SETTINGS clean package -Dskiptests'
        }
        archiveArtifacts artifacts: '**/target/*.jar'
      }
    }
  }
}
