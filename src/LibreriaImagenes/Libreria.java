package LibreriaImagenes;

import antonifontmarintaller2avaluable.ProgramaPrincipal;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;

public class Libreria {
    //CONSTANTES
    public static final String[] extensionesValidas = {".gif",".png",".jpg"};
    public static final Image imagenVacia = new ImageIcon(ProgramaPrincipal.RUTA_IMAGEN_VACIA).getImage();
    public static final Libreria libreriaVacia = new Libreria();
    //VARIABLES
    private final File directorio;
    private int numArchivosValidos = 0;
    private int numArchivosLeidos = 0;
    private String nombreArchivos[];
    
    
    public Libreria(){
        this.directorio = new File("");
    }
    
    
    public Libreria(File carpeta) {
        this.directorio = carpeta;
        nombreArchivos = carpeta.list();
        for(int i = 0;i<nombreArchivos.length;i++){
            if(tieneExtensionValida(nombreArchivos[i])){
                numArchivosValidos++;
            }
        }
    }

    private boolean tieneExtensionValida(String nombreArchivo) {
        for(int i = 0;i<extensionesValidas.length;i++){
            if(nombreArchivo.contains(extensionesValidas[i])){
                //Si el nombreArchivo contiene una extension valida
                return true; //el archivo tiene extension valida
            }
        }
        //Si el archivo no ha contenido ninguna extension de la lista entonces no tiene extension valida
        return false; 
    }
    
    public Image getSiguienteImagen(){
        String nombreArchivo = nombreArchivos[numArchivosLeidos];
        if(tieneExtensionValida(nombreArchivo)){
            String ruta = directorio.getPath() + File.separatorChar + nombreArchivo;
            ImageIcon img =  new ImageIcon(ruta);
            numArchivosLeidos++;
            return img.getImage();
        }else{
            return imagenVacia;
        }
    }
    
    public boolean quedanImagenesDentroDelDirectorio(){
        return (numArchivosLeidos != numArchivosValidos);
    }
    
    public int getNumImagenes(){
        return numArchivosValidos;
    }
    
    
    
    
}
