# Usa una imagen base de Java
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el .jar al contenedor (ruta relativa a donde haces docker build)
COPY target/musicaMvc-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto 8080 dentro del contenedor
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
