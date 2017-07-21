env.mvnHome = '/home/vagrant/tools/maven'
node('mslave') {
   //def mvnHome
   
   stage('Preparation') { // for display purposes
      
      git 'https://github.com/jglick/simple-maven-project-with-tests.git'
        
      //mvnHome = $M3
   }
   stage('Build') {
      
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' clean install"
      } else {
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      }
   }
   stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archive 'target/*.jar'
   }
}
