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
      }
    }

    stage('Test') {
      steps {
        parallel(
          'unit': {
            configFileProvider([
              configFile(fileId: 'maven-settings', variable: 'MAVEN_SETTINGS')
            ]) {
              sh 'mvn -B -s $MAVEN_SETTINGS test'
            }
          },
          'integration': {
            configFileProvider([
              configFile(fileId: 'maven-settings', variable: 'MAVEN_SETTINGS')
            ]) {
              sh 'mvn -B -s $MAVEN_SETTINGS failsafe:integration-test'
            }
          },
          'acceptance': {
            sh 'ci/deploy.sh test 8091'
            sh 'ci/checkoutAcceptanceTests.sh'
            sh 'cd ../acceptance-tests'
            configFileProvider([
              configFile(fileId: 'maven-settings', variable: 'MAVEN_SETTINGS')
            ]) {
              sh 'mvn -B -s $MAVEN_SETTINGS clean install -Dport=8091'
            }
          }
        )
      }
    }

    stage('Tag') {
      steps {
        sh 'ci/commitPomVersion.sh'
        sh 'ci/tag.sh'
      }
    }

    stage('Push artifacts') {
      steps {
        configFileProvider([
          configFile(fileId: 'maven-settings', // matches the fileId in jenkins
                     variable: 'MAVEN_SETTINGS')//assign path to this var
        ]) {
          sh 'mvn -B -s $MAVEN_SETTINGS deploy -DskipTests'
        }
      }
    }
  }
}
