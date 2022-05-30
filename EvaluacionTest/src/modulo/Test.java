package modulo;


// @author alexis israel
public class Test {

    public static void main(String[] args) throws Exception {

     BuscarLibro nuevolibro=new BuscarLibro();
     Libreria librosencontrados;
     
     //enviar palabras clave para iniciar la búasqueda
        String[] buscarPalabras = {"Fundamentos","leyes"};

        
        int resultados= nuevolibro.buscar(buscarPalabras).size();
          System.out.println();
          System.out.println("Resultados que coinciden con las palabras clave : "+resultados);
          System.out.println();
          
          //se imprimen los resultados invocando al metodo getInformacion
          int auxiliar=1;
        for (int i = 0; i < resultados; i++) {
            //se implementa el metodo buscar de la interface buscar que retorna la lista de libros con palabras clave
        librosencontrados= (Libreria) nuevolibro.buscar(buscarPalabras).get(i);
     
            System.out.println(auxiliar+".-"+librosencontrados.getInformacion());
        auxiliar++;
        }
     
    }
    
}
