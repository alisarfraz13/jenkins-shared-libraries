def call(String imageName, String imageTag, String dockerHubUser) {
    echo "=========================================="
    echo "Building Docker Image"
    echo "Image Name: ${imageName}"
    echo "Tag: ${imageTag}"
    echo "DockerHub User: ${dockerHubUser}"
    echo "=========================================="
    
    sh "whoami"
    sh """
        set -ex
        docker --version
        docker build -t ${dockerHubUser}/${imageName}:${imageTag} .
    """
    
    echo "✅ Docker build complete: ${dockerHubUser}/${imageName}:${imageTag}"
}
