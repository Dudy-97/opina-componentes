FROM nginx

COPY certs/nginx-selfsigned.crt /etc/ssl/certs/
COPY certs/nginx-selfsigned.key /etc/ssl/private/

COPY default-ssl.conf /etc/nginx/conf.d/default-ssl.conf

EXPOSE 443