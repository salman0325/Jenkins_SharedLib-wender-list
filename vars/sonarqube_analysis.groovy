def call(String SonarQubeAPI, String Projectname, String ProjectKey){
  withSonarQubeEnv("${SonarQubeAPI}"){
      sh "$SONAR_HOME/bin/sonar-scanner -Dsonar.projectName=${Projectname} -Dsonar.projectKey=${ProjectKey} -X"
  }
}

// def call(String projectName, String projectKey) {
//     // Make sure the SonarScanner tool is configured in Jenkins
//     def scannerHome = tool name: 'sonarqube1-token', type: 'hudson.plugins.sonar.SonarRunnerInstallation'

//     // Inject the SonarQube environment variables using the token
//     withSonarQubeEnv('sonarqube1-token') {
//         sh """
//             ${scannerHome}/bin/sonar-scanner \
//             -Dsonar.projectName=${projectName} \
//             -Dsonar.projectKey=${projectKey} \
//             -Dsonar.sources=. \
//             -X
//         """
//     }
// }






