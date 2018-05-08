FROM nginx:1.13

COPY ./dist /usr/share/nginx/html

COPY ./nginx-custom.conf /etc/nginx/conf.d/default.conf
EXPOSE 80

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar","--imageServer=http://34.223.223.31:8090/images/"]
