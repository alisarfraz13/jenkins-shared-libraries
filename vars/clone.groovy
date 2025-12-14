 def call(String url, String branch) {
    echo "Cloning code from ${url} on branch ${branch}"
    git(
        url: "${url}", 
        branch: "${branch}",
        credentialsId: 'github-pat'
    )
    echo "Code cloning successful!"
}
