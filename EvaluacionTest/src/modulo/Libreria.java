package modulo;

import org.biblioteca.interfaces.Libro;
public class Libreria implements Libro{
   protected int id;
   protected String[] titulo;
   protected String[] descripcion;
   protected int unidadesDisponibles;
    
    
    public Libreria(){}
    public Libreria(int id, String[] titulo, String[] descrip, int undis){
        this.id=id;
        this.titulo=titulo;
        this.descripcion=descrip;
        this.unidadesDisponibles=undis;
        }
    
    //implementamos el metodo getInformacion de la interface Libro a fin de que retorne la informacion de cada libro en un formato adecuado
      @Override
    public String getInformacion() {
        
        String titulolibro=""; 
        char comilla='"';
        String descripcion="",libro="";
       
         
     String unidades= Integer.toString (this.unidadesDisponibles);
                        
         String identificador=Integer.toString(id);       
        
          for(int i = 0; i < this.titulo.length; i++) {
              titulolibro+=" "+this.titulo[i];
          }
          
          for(int i = 0; i < this.descripcion.length; i++) {
              descripcion+=this.descripcion[i]+" ";
          }
        
         libro=comilla+titulolibro+ "("+descripcion+")" + " - "+unidades+" unidades disponibles"+"."+"("+identificador+")"+comilla;
           
         return libro;
    }
    
    
}

