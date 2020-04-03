def call(String project) {
    sh "docker rmi ${project}-beta-${env.BRANCH_NAME}-${env.BUILD_NUMBER}"
}
