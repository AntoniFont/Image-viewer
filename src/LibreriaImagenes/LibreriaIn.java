package LibreriaImagenes;

import java.io.File;
import javax.swing.JComponent;
import javax.swing.JFileChooser;

public class LibreriaIn {
    
    private JFileChooser seleccionador;
    private JComponent componente;
    
    public LibreriaIn(JComponent componente){
        //Que se abra automaticamente en el directorio de imagenes
        seleccionador = new JFileChooser("IMAGENES"); 
        //Que solo te permita seleccionar carpetas
        seleccionador.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //El componente al que se une el fileChooser
        this.componente = componente;
    }
    
    public Libreria getLibreria(){
        int valor = seleccionador.showOpenDialog(componente);
        if(valor == JFileChooser.APPROVE_OPTION){
            File carpeta = seleccionador.getSelectedFile();
            return new Libreria(carpeta);
        }
        return null; //Devuelvo una libreria vacia
    }
    
    
}
