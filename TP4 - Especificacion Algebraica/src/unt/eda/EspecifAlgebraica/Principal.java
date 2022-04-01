package unt.eda.EspecifAlgebraica;

/**
 *  Trabajo Práctico N° 4
 *  Especificación Algebraica
 *  Implementación RedSocial
 * @author Franco Quevedo
 */
public class Principal {
    public static void main(String[] args){
    
        RedSocial redSocial1 = new RedSocial();
        RedSocial redSocial2 = new RedSocial();
        RedSocial redSocial3 = new RedSocial();

        redSocial1.registrarFinal(new Usuario("Juan","Perez"));
        redSocial1.registrarFinal(new Usuario("Lucio","Scola"));
        redSocial1.registrarFinal(new Usuario("Diego","Maradona"));
        redSocial1.registrarFinal(new Usuario("Lionel","Messi"));
        redSocial1.registrarFinal(new Usuario("Luciana","Aimar"));
        
        redSocial2.registrarFinal(new Usuario("Maria","Sharapova"));
        redSocial2.registrarFinal(new Usuario("Martin","Palermo"));
        redSocial2.registrarFinal(new Usuario("Juan","Perez"));
        redSocial2.registrarFinal(new Usuario("Juan Roman","Riquelme"));
        redSocial2.registrarFinal(new Usuario("Agustin","Pichot"));
        redSocial2.registrarFinal(new Usuario("Matias","Kremer"));
        redSocial2.registrarFinal(new Usuario("Nicolas","Sanchez"));

        redSocial1.mostrarUsuarios();
        redSocial2.mostrarUsuarios();
        redSocial3.mostrarUsuarios();
        System.out.println();
        
        
        Usuario user = new Usuario("Juan","Perez");
        System.out.println(redSocial1.posicionUsuario(user));
        System.out.println(redSocial2.posicionUsuario(user));

        
        System.out.println("\n---Test esVacia()");
        Test.testEsVacia(redSocial1);
        Test.testEsVacia(redSocial2);
        Test.testEsVacia(redSocial3);
        
        System.out.println("\n---Test cantidad()");
        Test.testCantidad(redSocial1);
        Test.testCantidad(redSocial2);
        Test.testCantidad(redSocial3);
        
        System.out.println("\n---Test estaUsuario()");
        Test.testEstaUsuario(redSocial1);
        Test.testEstaUsuario(redSocial2);
        Test.testEstaUsuario(redSocial3);
        
        System.out.println("\n---Test esAmigoComun()");
        Test.testEsAmigoComun(redSocial1,redSocial2);
        
        System.out.println("\n---Test echarUsuario()");
        Test.testEcharUsuario(redSocial1);
        Test.testEcharUsuario(redSocial2);
        Test.testEcharUsuario(redSocial3);
        
        System.out.println("\n---Test esAmigoComun()");
        Test.testEsAmigoComun(redSocial1,redSocial2);
    }
}


