package unt.eda.EspecifAlgebraica;

/**
 *  Trabajo Práctico N° 4
 *  Especificación Algebraica
 *  Implementación RedSocial
 * @author Franco Quevedo
 */
public class Test {
    public static void testEsVacia(RedSocial redSocial){
        boolean test = redSocial.esVacia();
        System.out.println("esVacia = " + test);
    }
    
    public static void testCantidad(RedSocial redSocial){
        int test = redSocial.cantidad();
        System.out.println("cantidad = " + test);
    }
    
    public static void testEstaUsuario(RedSocial redSocial){
        Usuario usuario1 = new Usuario("Juan","Perez");
        Usuario usuario2 = new Usuario("Susana","Gimenez");
        
        boolean test1 = redSocial.estaUsuario(usuario1);
        boolean test2 = redSocial.estaUsuario(usuario2);
        
        System.out.println("estaUsuario " + usuario1 + ":\t\t" + test1);
        System.out.println("estaUsuario " + usuario2 + ":\t" + test2);
        System.out.println();
    }
    
    public static void testEcharUsuario(RedSocial redSocial){
        Usuario usuario1 = new Usuario("Juan","Perez");
        Usuario usuario2 = new Usuario("Stephen","Hawking");
        
        try{
            RedSocial rS1 = redSocial.echarUsuario(usuario1);
            RedSocial rS2 = redSocial.echarUsuario(usuario2);
            
            rS1.mostrarUsuarios();
            rS2.mostrarUsuarios();
            System.out.println();
        }catch(NullPointerException e){
            System.out.println("El usuario no se encuentra en la lista.\n");
        }
    }
    
    public static void testEsAmigoComun(RedSocial redSocial1, RedSocial redSocial2){
        Usuario usuario1 = new Usuario("Juan","Perez");
        Usuario usuario2 = new Usuario("Diego","Maradona");
        
        boolean test1 = RedSocial.esAmigoComun(redSocial1, redSocial2, usuario1);
        boolean test2 = RedSocial.esAmigoComun(redSocial1, redSocial2, usuario2);
        
        System.out.println("esAmigoComun '" + usuario1 + "':\t\t" + test1);
        System.out.println("esAmigoComun '" + usuario2 + "':\t\t" + test2);
    }
}
