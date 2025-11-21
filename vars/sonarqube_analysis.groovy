// def call(String SonarQubeAPI, String Projectname, String ProjectKey){
//   withSonarQubeEnv("${SonarQubeAPI}"){
//       sh "$SONAR_HOME/bin/sonar-scanner -Dsonar.projectName=${Projectname} -Dsonar.projectKey=${ProjectKey} -X"
//   }
// }

def call(String projectName, String projectKey) {
    // Make sure the SonarScanner tool is configured in Jenkins
    def scannerHome = tool name: 'Sonar', type: 'hudson.plugins.sonar.SonarRunnerInstallation'

    // Inject the SonarQube environment variables using the token
    withSonarQubeEnv('Sonar') {
        sh """
            ${scannerHome}/bin/sonar-scanner \
            -Dsonar.projectName=${ci-project} \
            -Dsonar.projectKey=${project-ci} \
            -Dsonar.sources=. \
            -X
        """
    }
}






