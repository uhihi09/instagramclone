# Build stage
FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /app

# pom.xml과 소스 복사
COPY pom.xml .
COPY src ./src

# 빌드
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# JAR 파일 복사
COPY --from=build /app/target/*.jar app.jar

# 환경변수
ENV PORT=8080

# 실행
EXPOSE ${PORT}
ENTRYPOINT ["sh", "-c", "java -Dserver.port=${PORT} -jar app.jar"]