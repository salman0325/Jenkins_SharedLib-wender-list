// def call(String SonarQubeAPI, String Projectname, String ProjectKey){
//   withSonarQubeEnv("${SonarQubeAPI}"){
//       sh "$SONAR_HOME/bin/sonar-scanner -Dsonar.projectName=${Projectname} -Dsonar.projectKey=${ProjectKey} -X"
//   }
// }
def call(String SonarQubeAPI, String Projectname, String ProjectKey) {
    withSonarQubeEnv("${SonarQubeAPI}") {
        sh 'echo "SONAR_SCANNER_HOME = $SONAR_SCANNER_HOME"'
        sh "${env.SONAR_SCANNER_HOME}/bin/sonar-scanner -Dsonar.projectName=${Projectname} -Dsonar.projectKey=${ProjectKey} -X"
    }
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

