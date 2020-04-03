def call(String project, String hubUser) {
    sh "docker rmi ${hubUser}/${project}:${env.BUILD_NUMBER}"
}
