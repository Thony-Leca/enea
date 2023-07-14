#Se especifica la imagen base a partir de la cual se construirá la nueva imagen
FROM adoptopenjdk:11-jdk-hotspot

#Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

#Copia los archivos JAR desde el directorio al contenedor
COPY target/ms-alumno-0.0.1.jar .

#Especifica los puertos en los que la aplicación en el contenedor que estará escuchando
EXPOSE 8080

#Define el comando que se ejecutará cuando se inicie un contenedor basado en la imagen
CMD [ "java", "-jar", "ms-alumno-0.0.1.jar"]

