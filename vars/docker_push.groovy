def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'dockerhubpass', usernameVariable: 'dockerhubuser')]) {
      sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
  }
  sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}
// def call(String Project, String ImageTag, String dockerhubuser){
    
//     withCredentials([usernamePassword(credentialsId: 'dockerhub', 
//                                       passwordVariable: 'dockerhubpass', 
//                                       usernameVariable: 'dockerhubuser')]) {
        
//         // Secure login with password-stdin
//         sh """
//             echo $dockerhubpass | docker login -u $dockerhubuser --password-stdin
//         """
//     }

//     // Push image
//     sh """
//         docker push ${dockerhubuser}/${Project}:${ImageTag}
//     """
// }

