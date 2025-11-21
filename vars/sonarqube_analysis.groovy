// def call(String SonarQubeAPI, String Projectname, String ProjectKey){
//   withSonarQubeEnv("${SonarQubeAPI}"){
//       sh "$SONAR_HOME/bin/sonar-scanner -Dsonar.projectName=${Projectname} -Dsonar.projectKey=${ProjectKey} -X"
//   }
// }

withSonarQubeEnv('sonarqube1-token') {
    // Use the scanner installed in Jenkins
    def scannerHome = tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
    sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectName=complet-ci -Dsonar.projectKey=ci-project"
}





// def call(String SonarQubeAPI, String ProjectName, String ProjectKey) {

//     withSonarQubeEnv("${SonarQubeAPI}") {

//         // Locate Jenkins-installed SonarScanner tool
//         def scannerHome = tool 'SonarScanner'

//         sh """
//             ${scannerHome}/bin/sonar-scanner \
//               -Dsonar.projectKey=${ProjectKey} \
//               -Dsonar.projectName=${ProjectName} \
//               -Dsonar.sources=. \
//               -Dsonar.host.url=${SONAR_HOST_URL} \
//               -Dsonar.login=${SONAR_AUTH_TOKEN}
//         """
//     }
// }

