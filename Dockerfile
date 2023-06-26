FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-javaagent:/app/lib/opentelemetry-javaagent-1.27.0.jar", "-cp","app:app/lib/*","com.pnm.kube.canary.KubeApplicationVets"]