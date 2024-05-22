FROM amazoncorretto:17.0.11
LABEL authors="pnrao"
ADD target/spring-boot-k8s-minikube-0.0.1-SNAPSHOT.jar spring-boot-k8s-minikube-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring-boot-k8s-minikube-0.0.1-SNAPSHOT.jar"]