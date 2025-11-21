// def call(String SonarQubeAPI, String Projectname, String ProjectKey){
//   withSonarQubeEnv("${SonarQubeAPI}"){
//       sh "$SONAR_HOME/bin/sonar-scanner -Dsonar.projectName=${Projectname} -Dsonar.projectKey=${ProjectKey} -X"
//   }
// }
// vars/sonarqube_analysis.groovy
def call(String sonarServerName, String projectKey, String projectName) {
    // Inject SonarQube environment
    withSonarQubeEnv(sonarServerName) {
        // Use the SonarScanner installed in Jenkins (tool name = 'Sonar')
        def scannerHome = tool 'Sonar'
        sh """
            ${scannerHome}/bin/sonar-scanner \
            -Dsonar.projectKey=${projectKey} \
            -Dsonar.projectName=${projectName} \
            -Dsonar.sources=. \
            -Dsonar.host.url=${SONAR_HOST_URL} \
            -Dsonar.login=${SONAR_AUTH_TOKEN}
        """
    }
}






