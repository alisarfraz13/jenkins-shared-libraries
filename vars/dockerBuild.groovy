def call(String imageName, String tag = 'latest') {
  echo "Building Docker image: ${imageName}:${tag}
  sh "whoami"
  sh """
      set -ex 
      docker --version
      docker build -t ${imageName}:${tag}
  """
  echo "Docker build complete!"
}
