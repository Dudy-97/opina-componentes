# OpinaComponentes



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



# Modelo de datos

 (de la aplicación utilizando un diagrama de clases UML y un diagrama
Entidad/Relación que muestre cómo se persisten dichos datos en la base de datos relacional.)



