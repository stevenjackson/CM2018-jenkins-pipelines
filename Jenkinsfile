pipeline {
  agent any
  tools {
    jdk 'JDK'
    maven 'M3'
  }
  stages {
    stage('Build') {
      steps {
        sh 'ci/updateGitForPush.sh'
        configFileProvider([
          configFile(fileId: 'maven-settings', // matches the fileId in jenkins
                     variable: 'MAVEN_SETTINGS')//assign path to this var
        ]) {
          sh 'ci/incrementPomVersion.sh $MAVEN_SETTINGS'
          sh 'mvn -B -s $MAVEN_SETTINGS clean package -DskipTests'
        }
        archiveArtifacts artifacts: '**/target/*.jar'
      }
    }

    stage('Tag') {
      steps {
        sh 'ci/commitPomVersion.sh'
        sh 'ci/tag.sh'
      }
    }
  }
}
