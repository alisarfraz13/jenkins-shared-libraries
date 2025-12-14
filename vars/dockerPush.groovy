def call(String imageName, String imageTag, String dockerHubUser) {
    echo "=========================================="
    echo "Pushing Docker Image to DockerHub"
    echo "Image: ${dockerHubUser}/${imageName}:${imageTag}"
    echo "=========================================="
    
    withCredentials([usernamePassword(
        credentialsId: 'dockerhubcred',
        passwordVariable: 'dockerHubPass',
        usernameVariable: 'dockerHubUser'
    )]) {
        sh 'echo $dockerHubPass | docker login -u $dockerHubUser --password-stdin'
        sh "docker push ${dockerHubUser}/${imageName}:${imageTag}"
    }
    
    echo "✅ Image pushed successfully to DockerHub!"
}
