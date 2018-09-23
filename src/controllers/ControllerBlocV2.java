/**
 *
 * @author Carina Amairani Díaz Ramírez
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.ModelBloc;
import view.ViewBloc;


public class ControllerBlocV2 implements ActionListener{
    
    private  ModelBloc modelBloc; //llamar la clase modelo que contiene las variables
    private  ViewBloc viewBloc; //llama a la vista
    JFileChooser seleccionar=new JFileChooser();
    File archivo;
    FileOutputStream salida;
    
    public ControllerBlocV2(ModelBloc modelBloc, ViewBloc viewBloc){
        this.modelBloc = modelBloc;
        this.viewBloc = viewBloc;
        
        this.viewBloc.jMI_Leer.addActionListener(this);
        this.viewBloc.jMI_Guardar.addActionListener(this);
         initView();
    }
    
    public void iniciar_vista(){
        viewBloc.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == viewBloc.jMI_Leer){
            jMI_Leer_action_performed();
        }
        if(e.getSource() == viewBloc.jMI_Guardar) {
            jMI_Guardar_action_performed();
        }
    }
File a;
    private void jMI_Leer_action_performed() {
        
    JFileChooser fileChooser = new JFileChooser(); //Creamos el objeto JFileChooser
    int seleccion = fileChooser.showOpenDialog(null); //Abrimos la ventana, guardamos la opcion seleccionada por el usuario
    if(seleccion==JFileChooser.APPROVE_OPTION) //evalua si el usuario a precionado el boton aceptar para poder abrir el fichero
    {
        FileReader b= null;
        try{
            a=fileChooser.getSelectedFile(); //Seleccionamos el fichero
            viewBloc.jTA_BlocNotas.setText(a.getAbsolutePath()); //Ecribe la ruta del fichero seleccionado en el campo de texto
            System.out.println(a); 
            JOptionPane.showMessageDialog(null, "Nombre del archivo: "+a.getName());//Muestra una ventana de dialogo mostrando el nombre del archivo seleccionado
            b=new FileReader(a); //lee el contenido del fichero
            viewBloc.jTA_BlocNotas.read(b, ""); //muestra el contenido del fichero en el jtextarea en la parte de la vista 
        } catch (Exception ex){
            Logger.getLogger(ControllerBlocV2.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                b.close();
            }catch(IOException ex){
                Logger.getLogger(ControllerBlocV2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }
              
 }

    private void jMI_Guardar_action_performed() {
        JFileChooser fileChooser = new JFileChooser(); //Se crea el objeto FileChooser
        int seleccion= fileChooser.showSaveDialog(viewBloc.jTA_BlocNotas);//Se abre la ventaa, guardamos la opcion seleccionada
        if(seleccion==JFileChooser.APPROVE_OPTION){ //Se evalua si el usuario preciona el boton aceptar
            File fichero=fileChooser.getSelectedFile();//Seleccionamos el fichero
            try(FileWriter fileWriter = new FileWriter(fichero)){
                fileWriter.write(viewBloc.jTA_BlocNotas.getText());//Escribir el texto en el fichero
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        
     
        
    }

    public void initView() {
        viewBloc.setLocationRelativeTo(null);
        viewBloc.jTA_BlocNotas.setText(modelBloc.getMenu());
        viewBloc.setVisible(true);    }

    private String Guardar(File archivo, String Documento) {
         String mensaje=null;
         String documento="";
          try{
              salida=new FileOutputStream(archivo);
              byte[] bytxt=documento.getBytes();
              salida.write(bytxt);
              mensaje="Archivo guardado";
          } catch(Exception e){
              return mensaje;
       }
        return null;
    }
}
