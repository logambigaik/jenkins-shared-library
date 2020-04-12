def call(String project, String hubUser) {
    dockerImage = docker.build registry + ":$BUILD_NUMBER"
    withCredentials([usernamePassword(
            credentialsId: "docker",
            usernameVariable: "USER",
            passwordVariable: "PASS"
    )]) {
        sh "docker login -u '$USER' -p '$PASS'"
    }
    docker.withRegistry( '', docker ) {
         dockerImage.push("$BUILD_NUMBER")
         dockerImage.push("latest")
    }
}
