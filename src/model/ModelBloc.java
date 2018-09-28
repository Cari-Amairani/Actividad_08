
/**
 *
 * @author Carina Amairani Díaz Ramírez
 */
package model;



public class ModelBloc {
    
    private String path = " "; 

    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    
        
    //Guarda el contenido 
    private String message = ""; 

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    
    
    private String leer;
    private String guardar;
    private String menu;

    public String getLeer() {
        return leer;
    }

    public void setLeer(String leer) {
        this.leer = leer;
    }

    public String getGuardar() {
        return guardar;
    }

    public void setGuardar(String guardar) {
        this.guardar = guardar;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
    
    
   
   
    
}
