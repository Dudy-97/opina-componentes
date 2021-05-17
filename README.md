# OpinaComponentes


 # Vídeo de la aplicación funcionanado
 
 https://youtu.be/vGGxQjKbCZM

 # Descripción tematica de la web: 

Aplicación web para opinar sobre artículos y piezas de ordenadores. Los usuarios se pueden diferenciar entre invitado, usuario
y administrador. El invitado sólo tiene posibilidad de ver la web sin realizar cambios en ella. El usuario registrado tiene la posibilidad de opinar sobre
los artículos, añadir a favoritos los que le gusten, por lo que lo único que tendría
de privado serían sus datos personales y algunos datos más como amigos añadidos. El administrador tiene la posibilidad de crear y 
eliminar articulos, así como algunos moderar las opiniones de los usuarios o llegar a  bloquear temporalmente algún usuario.


# Entidades:
 
Producto --> Articulos de una categoría en concreto sobre el que se va a valorar y poner una reseña.

Categoria --> Tipos de producto, dependiendo de su descripcion. Por ejemplo: placas base, graficas, discos duros...

Usuario --> Cliente de la página que escribe opiniones sobre distintos artículos.

Opinion --> Valoracíon de los usuarios sobre los productos de la web.


# Descripción de las funcionalidades del servicio interno:

Los usuarios reciben notificaciones en algunos momentos, por ejemplo cuando:
 - Salen nuevos productos.
 - Algún administrador ha moderado alguna de sus valoraciones o ha sido baneado.

La administración de los productos de la aplicación web como dar de alta nuevos productos.


# Integrantes del grupo:

 - Ángel Fernández Sánchez (a.fernandezsa.2016@alumnos.urjc.es) GitHub: Dudy-97 
 - Víctor Joaquín Frías Torres (vjfrias@alumnos.urjc.es) GitHub: qvicfri1


(FASE 2)
# Capturas de pantalla

 ## Index.html
 
 ![image](https://user-images.githubusercontent.com/60407168/110345590-0889d100-802f-11eb-9f1e-4d0321c2a68c.png)
 ![image](https://user-images.githubusercontent.com/60407168/110358015-31fd2980-803c-11eb-9cbe-b19e4a964c36.png)


  Descripcion: Pagina principal, en ella se muestran las categorias de los productos, la posibilidad de ver los usuarios registrados y la posibilidad de iniciar sesion o registrarse.
  
  
  
  ## login.html
 
 ![image](https://user-images.githubusercontent.com/60407168/110358180-640e8b80-803c-11eb-9e2a-89a4af34feb9.png)


  Descripcion: Login del usuario, aqui accedes a tu cuenta de usuario previamente creada.
  
  
  
  ## registro.html
 
  ![image](https://user-images.githubusercontent.com/60407168/110358317-8dc7b280-803c-11eb-9295-4ab21c87fcd0.png)


  Descripcion: Registro de nuevos usuarios, en el que te puedes crear una nueva cuenta y empezar a valorar los productos.
  
  
  
  ## ver_ususarios.html
 
 ![image](https://user-images.githubusercontent.com/60407168/110358483-bfd91480-803c-11eb-8ded-fedc608d1ef6.png)


  Descripcion: Pagina donde se muestran los usuarios registrados
  
  
  
  ## ver_ususarios/{id}.html
 
 ![image](https://user-images.githubusercontent.com/60407168/110359427-c4ea9380-803d-11eb-9f5e-b0bf7e95f039.png)
 ![image](https://user-images.githubusercontent.com/60407168/110359502-d9c72700-803d-11eb-9076-bda2893e40fc.png)


  Descripcion: Pagina donde se muestra el perfil del usuario y las interacciones con los productos.
  
  
  
  ## procesadores.html
 
 ![image](https://user-images.githubusercontent.com/60407168/110359558-e9df0680-803d-11eb-88e6-0ecd8c778d50.png)


  Descripcion: Pagina de todos los productos de la categoria procesadores (hay una pagina como esta por cada categoria)
  
  
  
  ## nuevo_procesador.html
 
  ![image](https://user-images.githubusercontent.com/60407168/110359721-1b57d200-803e-11eb-9115-4573e5f11530.png)


  Descripcion: Pagina para añadir nuevos productos a cada categoria.
  
  
  ## eliminado.html
 
  ![image](https://user-images.githubusercontent.com/60407168/110359775-30ccfc00-803e-11eb-9a33-cd563b88de0e.png)


  Descripcion: Aqui se verifica la eliminacion de un producto.
  
  
  ## guardado.html
 
  ![image](https://user-images.githubusercontent.com/60407168/110359868-53f7ab80-803e-11eb-82fb-8a752d756fa7.png)


  Descripcion: Pagina que verifica que un producto se ha guardado correctamente.
  

  
  ## producto.html
 
  ![image](https://user-images.githubusercontent.com/60407168/110359627-ff543080-803d-11eb-9db4-a1a68cc46641.png)


  Descripcion: Pagina del producto seleccionado de una categoria, en este caso un procesador.
 
  
  
  
  
# Diagrama de Navegacion
   ### index.html
![image](https://user-images.githubusercontent.com/60407168/110368579-865ad600-8049-11eb-9eae-c6a061313421.png)
 Descripcion: En esta imagen se puede observar como del menu principal se puede acceder:
    -> 1 Al menu de inicio de sesión 
    -> 2 A la pagina para ver los usuarios registrados
    -> 3 A cada pagina de una categoria, donde se pueden ver los productos que tiene dentro

 
  ### ver_usuarios
 ![image](https://user-images.githubusercontent.com/60407168/110369777-26652f00-804b-11eb-95d5-eb7c25b49ccf.png)
 Descripcion: En el menu de usuarios, podemos acceder a cada usuario en especifico (1) y ver las valoraciones que éste ha publicado en cada producto (2). 
 
 
   ### procesadores.html
 ![image](https://user-images.githubusercontent.com/60407168/110371457-4e559200-804d-11eb-9fbf-2e9b4a647722.png)
Descripcion: Desde la pagina de la categoria procesadores, encontramos todos los procesadores y al elegir uno nos muestra su descripcion, precio y valoraciones (3), aqui tambien podemos añadir valoraciones y eleminirlas, asi como eliminar el producto (Nos muestra una pantalla confirmando la eliminiacion, 4). Ademas, podemos añadir productos (1) y nos aparece una ventana afirmando el exito en la operacion (2).


  ### Login.html
 ![image](https://user-images.githubusercontent.com/60407168/110372406-8dd0ae00-804e-11eb-905f-df1331375bf9.png)
Descripcion: En esta imagen se muestra el menu de login por el que se puede acceder al usuario, en cuanto se rellenan los datos y se presiona el boton de "Iniciar sesion" se accede a la transparencia (1). Por otro lado, si no se posee un usuario se puede crear uno en "Registrarse", el cual nos lleva al menu de registro (2) y cuando se rellena correctamente y presionamos "Registrarse" nos aparece una pagina confirmando el guardado.

# Modelo de datos

  ## Diagrama de clases UML
  
  ### Aplicación principal
  ![Captura](https://user-images.githubusercontent.com/78860255/117804990-bba5bf00-b258-11eb-80bb-70482d134e4a.PNG)

  ### Servicio Interno
  ![UML_ServicioInterno](https://user-images.githubusercontent.com/78860255/114735468-7cfa1300-9d45-11eb-90a1-14afe56fb449.PNG)
  
  ## Diagrama Entidad/Relación
 
  ![DiagramaER](https://user-images.githubusercontent.com/60407168/110366001-0717d300-8046-11eb-8862-33cb92f5f346.png)

# Diagrama de la infraestructura

![diagrama_balanceador](https://user-images.githubusercontent.com/78860255/117804865-94e78880-b258-11eb-85a7-1113649431f1.png)

# Instrucciones de despliegue (Windows 10)

 Para poder lanzar la aplicación es necesario tener de antemano Java y MySQL instalados en el ordenador donde se vaya a desplegar.
 
 ## JAVA
 
 Descargar e instalar JAVA 15 de la página de Oracle. Es posible que se requiera una cuenta de Oracle, el registro es gratuito.
 
 ## MySQL
 
 1. Descargar el instalador para Windows de MySQL.
 2. Durante la instalación elegir el Worckbench y el Server.
 3. Dejar el servidor con los puertos por defecto.
 4. Abrir MySQL Workbench
 5. (Opcional) Crear otra conexión con los puertos por defecto si es necesario.
 6. Abrir la conexión.
 7. Crear un nuevo esquema de nombre "opinacomponentes".
 
 My SQL ya está listo.
 
 ## Aplicación
 
 1. Abrir MySQL Workbench y la conexión que se ha configurado previamente.
 2. Abrir dos CMDs
 3. Moverse con el mandato "cd" a la carpeta donde se encuentren los archivos .jar de la aplicación.
 4. En una consola ejecutar el mandato: "java -jar {Nombre del archivo del servicio interno}.jar" y esperar a que se termine de ejecutar.
 5. En la otra consola ejecutar: "java -jar {Nombre del archivo de la aplicación}.jar" y esperar a que se termine de ejecutar.
 6. Abrir un navegador e ir a la siguiente dirección: "https://localhost:8443".
 7. (Opcional) Aceptar entrar si sale el aviso de página no segura.
 

