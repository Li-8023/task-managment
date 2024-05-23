# 使用官方的 OpenJDK 17 作为基础镜像
FROM openjdk:17-slim

# 设置工作目录
WORKDIR /app

# 将 Maven 构建的 jar 文件复制到容器中
COPY target/task-service-0.0.1-SNAPSHOT.jar /app/app.jar

# 暴露应用端口
EXPOSE 5002

# 运行 jar 文件
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
