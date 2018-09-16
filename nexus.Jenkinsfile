node('maven-agents') {
   def mvnHome = '/usr/share/maven'
   stage('Preparation') { // for display purposes
      git branch: '${branch}', url: 'https://github.com/quickfixtech/maven-spring.git'       
      
   }
   stage('Build') {
      // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Pspring-deploy -Dmaven.test.failure.ignore clean deploy"
      } else {
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      }
   }
   stage('sonar') {
      sh "'${mvnHome}/bin/mvn' sonar:sonar"
   }
   
   stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archiveArtifacts 'target/*.jar'
   }
}
