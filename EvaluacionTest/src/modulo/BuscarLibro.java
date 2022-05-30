package modulo;
// @author alexis israel

import org.biblioteca.excepciones.LibroNoEncontradoException;
import java.util.*;
import org.biblioteca.interfaces.*;
 

public class BuscarLibro implements Buscar {
    
    @Override
    public List<Libro> buscar(String... palabrasClaves) throws Exception {
        
        List<Libro> buscarlibro=new LinkedList();
        
            List<Libro> resultados=new LinkedList<>();
            Libreria coincidir;
        
        String[] titulo1={"El","llano","en","llamas"};
        String[] titulo2={"Tipos", "penales", "en", "leyes", "federales", "y", "generales"};
        String[] titulo3={"Derecho", "Aduanero","Mexicano"};  
        String[] titulo4={"Algebra", "Baldor"};
        String[] titulo5={"Recopilacion", "de", "leyes", "mercantiles"};
        String[] titulo6={"Principios", "generales", "del", "Derecho"};
        String[] titulo7={"Nociones", "de", "Derecho", "positivo", "mexicano"};
        
        String[] des1={"Compilacion", "de" ,"cuentos" ,"escritos" ,"por", "Juan","Rulfo"};
        String[] des2={"Compilacion", "legislativa"};
        String[] des3={"Fundamentos", "y", "regulaciones", "de", "la", "actividad", "aduanera"};  
        String[] des4={"Matematicas", "elementales" ,"para", "bachillerato"};
        String[] des5={"Serie", "de" ,"leyes", "mercantiles"};
        String[] des6={"Compilacion", "de", "aforismos", "juridicos"};
        String[] des7={"Fundamentos", "de", "Derecho", "para", "estudiantes"};
        
        //creamos las instancias de la clase libreria y agregamos los objetos a la lista para simular la BD
        Libreria libro1=new Libreria(1,titulo1,des1,30);
        Libreria libro2=new Libreria(2,titulo2,des2,33);
        Libreria libro3=new Libreria(3,titulo3,des3,20);
        Libreria libro4=new Libreria(4,titulo4,des4,80);
        Libreria libro5=new Libreria(5,titulo5,des5,200);
        Libreria libro6=new Libreria(6,titulo6,des6,70);
        Libreria libro7=new Libreria(7,titulo7,des7,100);
        
        buscarlibro.add(libro1);
        buscarlibro.add(libro2);
        buscarlibro.add(libro3);
        buscarlibro.add(libro4);
        buscarlibro.add(libro5);
        buscarlibro.add(libro6);
        buscarlibro.add(libro7);
         
            //convertimos cada objeto de la lista en tipo libreria para su manipulacion y comenzamos a analizar cadena por cadena de los atributos
            //titulo y descripcion a fin de encontrar coincidencias con las palabras clave enviadas como parametros
        for (int i = 0; i < buscarlibro.size(); i++) {
            coincidir=(Libreria) buscarlibro.get(i);
            
            for (int j = 0; j < coincidir.titulo.length; j++) {
                for (int k = 0; k < palabrasClaves.length; k++) {
                    
                 if(palabrasClaves[k].equals(coincidir.titulo[j])){
                resultados.add(coincidir);  
            }
              }

            }
            
            for (int j = 0; j < coincidir.descripcion.length; j++) {
                for (int k = 0; k < palabrasClaves.length; k++) {
                    
                 if(palabrasClaves[k].equals(coincidir.descripcion[j])){
           
                resultados.add(coincidir);  
            }
              }

                   }
        }
        
        //lanzamos la excepción en caso de que no se encuentre ninguna cadena clave
        if(resultados.isEmpty()){
        throw new LibroNoEncontradoException("No se encontró ningún libro, verifique su consulta."); 
        }
        
          
       //eliminar resultados duplicados
   HashSet hashSet = new HashSet(); 
   hashSet.addAll(resultados);
   resultados.clear();
   resultados.addAll(hashSet);
   
   
       //retornamos la lista sin duplicados de objetos que coinciden con las cadenas clave
        return resultados; 
        }
    
}
