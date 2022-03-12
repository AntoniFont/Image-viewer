package Elementos_visuales_interactuables;

import LibreriaImagenes.Libreria;
import antonifontmarintaller2avaluable.ProgramaPrincipal;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

public class Icono extends JButton{
    //CONSTANTES
    private static final int ANCHO_ICONO = 52;
    private static final int ALTO_ICONO = 52;
    private static final Border BORDE_ESTANDAR  = BorderFactory.createLineBorder(Color.BLACK,13);
    private static final Border BORDE_SELECCIONAR = BorderFactory.createLineBorder(Color.RED,13);
    
    private final ActionListener funcionalidadIcono = new ActionListener(){
        @Override    
        public void actionPerformed(ActionEvent  e){
            //Obtenemos el boton que has pulsado
            JButton a = ((JButton) e.getSource());
            //Extraemos el identificador que hemos puesto a todos los botones del boton que has pulsado
            String codigoBotonPulsado = a.getActionCommand();
            int iconoPulsado = Integer.parseInt(codigoBotonPulsado);
            //Hacemos lo correspondiente según si es válido o no el iconoPulsado
            if (ProgramaPrincipal.isIconoValido(iconoPulsado)) {
                ProgramaPrincipal.setTextoAreaTexto("SELECCIONA EL ICONO A VISUALIZAR CON EL RATÓN O CON LOS BOTONES < Y >");
                try {
                    ProgramaPrincipal.actualizarIconoSeleccionado(iconoPulsado);
                    ProgramaPrincipal.actualizarImagenPrincipal();
                } catch (Exception ex) {
                    System.out.println("No se ha podido actualizar el icono actual");
                }  
            } else {
                ProgramaPrincipal.mensajeIconoNoValido();
            }
        }
    }; 
    
    //VARIABLES
    private Image imagenTamañoGrande;
    
    public Icono(int num){
        this.setActionCommand("" +num); //Le doy un identificador para luego saber que icono he pulsado
        this.addActionListener(funcionalidadIcono);
        this.setBorder(BORDE_ESTANDAR);
        this.setPreferredSize(new Dimension(ANCHO_ICONO,ALTO_ICONO));
        this.setMaximumSize(new Dimension(ANCHO_ICONO,ALTO_ICONO));
        this.setMinimumSize(new Dimension(ANCHO_ICONO,ALTO_ICONO));
        this.setIcon(new ImageIcon(ProgramaPrincipal.RUTA_IMAGEN_VACIA));
    }
       
    public void setNuevaImagen(Image img){
        //Guardamos la imagen en Tamaño Original para luego acceder a ella
        this.imagenTamañoGrande = img;
        //Y ponemos en el icono la imagen con tamaño reducido
        Image imagenResize = imagenTamañoGrande.getScaledInstance(ANCHO_ICONO,ALTO_ICONO,Image.SCALE_DEFAULT);
        setIcon(new ImageIcon(imagenResize));
    }
   
    public void setImagenVacia(){
        setIcon(new ImageIcon(Libreria.imagenVacia));
    }
    
    public void setBordeEstandar(){
        setBorder(BORDE_ESTANDAR);
    }
    
    public void setBordeSeleccionar(){
        setBorder(BORDE_SELECCIONAR);
    }
        
    public Image getImagenTamañoGrande(){
       return imagenTamañoGrande;
    } 
    
    
    
    
    
}
