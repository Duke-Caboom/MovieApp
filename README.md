# **Requerimientos que no llegue a completar**
  
- La app debe de funcionar offline

    - **Propuesta de solución**
    
        - Cada respuesta (Consultas a las secciones, consulta a una película especifico, detalle de película, etc.) que se haga al API The Movie DB se almenará 
        de forma persistente en una base de datos, haciendo uso de la biblioteca Room.
    
        - Dentro de la arquitectura desarrollada se ejecuta un caso de uso para obtener los datos requeridos mediante un repositorio. El repositorio actualmente realiza 
        operaciones mediante Retrofit 2 para consumir el API The Movie DB (información que una vez procesada se estaría guardando en la BD), en caso que el usuario no tenga acceso a 
        internet se haría uso del repositorio implementado con Room, esto con la finalidad de cargar los datos más actuales que se han obtenido del API The Movie DB.
