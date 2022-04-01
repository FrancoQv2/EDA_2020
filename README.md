# TP4 - Especificación Algebraica
## Quevedo, Franco


**2)** Considere el **ADT REDSOCIAL(USUARIO)** definido con las siguientes operaciones: 
 
**OPERACIONES**
 
**Sintaxis:** 
 
    REDSOCIALVACIA:  -> REDSOCIAL     
    
    REGISTRAR:  REDSOCIAL x USUARIO -> REDSOCIAL  
    
    ESVACIA:  REDSOCIAL -> BOOL     
    
    ESTA:  REDSOCIAL x USUARIO -> BOOL     
    
    ECHAR:  REDSOCIAL x USUARIO  -> REDSOCIAL      
    
    ULTIMOUSUARIO:  REDSOCIAL -> USUARIO U {indefinido}     
    
    CANTIDAD:  REDSOCIAL -> ENTERO≥0 
 
 
**Semántica:** Para todo R  REDSOCIAL, para todo u, v  USUARIO.

    ESVACIA(REDSOCIALVACIA) = TRUE     
    ESVACIA(REGISTRAR(A,u)) = FALSE       

    ESTA(REDSOCIALVACIA,u) = FALSE     
    ESTA(REGISTRAR(A,u),v) = u=v  OR ESTA(A,v)             

    ECHAR(REDSOCIALVACIA,u) = REDSOCIALVACIA     
    ECHAR(REGISTRAR(R,u), v) = Si u=v entonces ECHAR(R,v)   Sino         REGISTRAR(ECHAR(R,v),u)       
    
    ULTIMOUSUARIO(REDSOCIALVACIA) = indefinido    
    ULTIMOUSUARIO(REGISTRAR(A,u)) = u 
 
    CANTIDAD(REDSOCIALVACIA) = 0
    CANTIDAD(REGISTRAR(R,u)) = 1 + CANTIDAD(R)  


**a)** Dado el ADT REDSOCIAL agregue a  la especificación algebraica la siguiente operación:    
- esAmigoComun: recibe 2 redes sociales y un usuario, determinando si el mismo pertenece a ambas. En ese caso debe retornar true. 
 
**b)** Implemente en Java el ADT REDSOCIAL(USUARIOS) usando lista simplemente enlazada. \
   USUARIO debe identificarse con un entero. La implementación de la operación ESTA debe ser recursiva. 
 
**d)** Escriba un programa de prueba que construya objetos de la clase REDSOCIAL y aplique  todas las operaciones y la función del punto b).
