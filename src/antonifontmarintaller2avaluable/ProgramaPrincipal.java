package antonifontmarintaller2avaluable;

import Elementos_visuales_interactuables.BotonAbrirLibreria;
import Elementos_visuales_interactuables.BotonAnterior;
import Elementos_visuales_interactuables.BotonFinalizar;
import Elementos_visuales_interactuables.BotonSiguiente;
import Elementos_visuales_interactuables.Icono;
import LibreriaImagenes.Libreria;
import LibreriaImagenes.LibreriaIn;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProgramaPrincipal extends JFrame{

    //CONSTANTES
    private static final Dimension TAMAÑO_VENTANA = new Dimension(727,550);
    private static final int NUM_FILAS = 7;
    private static final int NUM_COLUMNAS = 4;
    private static final int NUM_TOTAL_ICONOS = NUM_FILAS*NUM_COLUMNAS;
    private static final Dimension TAMAÑO_IMAGEN_PRINCIPAL = new Dimension(450,450);
    public static final String RUTA_LOGO_TALLER = "IMAGENES/logoTaller.jpg";
    public static final String RUTA_IMAGEN_VACIA = "IMAGENES/imagenVacia.jpg";
    //OBJETO VENTANA
    private static ProgramaPrincipal tallerEvaluable;
    //DATOS
    private static int iconoActual;
    private static int numIconosValidos = 0;
    //BOTONES
    private static BotonAbrirLibreria botonAbrirLibreria;
    private static BotonAnterior botonAnterior;
    private static BotonSiguiente botonSiguiente;
    private static BotonFinalizar botonFinalizar;
    //PANELES
    private static JPanel panelIconos;
    private static JPanel panelImagen;
    private static JPanel panelOpciones; 
    private static JPanel panelBotones;
    //TEXT FIELDS
    private static JTextField areaTexto;
    //ICONOS
    private static Icono iconos[];
    //IMAGEN PRINCIPAL
    private static JLabel imagenPrincipal;
    
   
    public static void main(String[] args) {
        try{
        tallerEvaluable = new ProgramaPrincipal();
        tallerEvaluable.initComponents();
        tallerEvaluable.setVisible(true);
        }catch(Exception e){
            System.out.println("Ha ocurrido un error inesperado: " + e.getLocalizedMessage());
        }
    }
    
    public ProgramaPrincipal(){
        this.setLayout(new BorderLayout()); 
        this.setSize(TAMAÑO_VENTANA);
        this.setResizable(false);
    }
    
    private void initComponents(){
        //Inicializamos los componentes
            //Inicializamos los botones
                    botonAbrirLibreria = new BotonAbrirLibreria();
                    botonAnterior = new BotonAnterior();
                    botonSiguiente = new BotonSiguiente();
                    botonFinalizar = new BotonFinalizar();
            //Inicializamos las area de texto
                //Area de texto
                    areaTexto = new JTextField("SELECCIONA LIBRER�?A IM�?GENES");
                    areaTexto.setEditable(false);
            //Inicializamos los iconos
                //Iconos
                    iconos = new Icono[NUM_TOTAL_ICONOS];
                    for(int i = 0;i<NUM_TOTAL_ICONOS;i++){
                        iconos[i] = new Icono(i);
                    }
            //Inicializamos la imagen principal
                //Imagen principal
                    imagenPrincipal = new JLabel();
                    imagenPrincipal.setPreferredSize(TAMAÑO_IMAGEN_PRINCIPAL);
                    imagenPrincipal.setIcon(new ImageIcon(RUTA_LOGO_TALLER));
        //Inicializamos los paneles
            //Panel botones
                //Lo creamos
                    panelBotones = new JPanel();
                    panelBotones.setLayout(new FlowLayout());
                //Le añadimos todos los botones
                    panelBotones.add(botonAbrirLibreria);
                    panelBotones.add(botonAnterior);
                    panelBotones.add(botonSiguiente);
                    panelBotones.add(botonFinalizar);
            //Panel Opciones
                //Lo creamos
                    panelOpciones = new JPanel();
                    panelOpciones.setLayout(new BorderLayout());
                    panelOpciones.setBackground(new Color(0,0,255)); //Prueba borrar
                //Le añadimos el panel con los botones en la parte de arriba
                    panelOpciones.add(panelBotones,BorderLayout.NORTH);
                //Le añadimos el area de texto en la parte de abajo
                    panelOpciones.add(areaTexto,BorderLayout.SOUTH);
            //Panel iconos
                //Lo creamos
                    panelIconos = new JPanel();
                    panelIconos.setLayout(new GridLayout(7,4));
                    panelIconos.setPreferredSize(new Dimension(260,450));
                //Le añadimos los iconos
                    for(int i = 0;i<NUM_TOTAL_ICONOS;i++){
                        panelIconos.add(iconos[i]);
                    }
            //Panel imagen
                //Lo creamos
                    panelImagen = new JPanel();
                    panelImagen.add(imagenPrincipal);
                    
        tallerEvaluable.getContentPane().add(panelIconos,BorderLayout.WEST);
        tallerEvaluable.getContentPane().add(panelImagen,BorderLayout.CENTER);
        tallerEvaluable.getContentPane().add(panelOpciones,BorderLayout.SOUTH); 
    }
    
    public static void abrirLibreria(){
            setTextoAreaTexto("SELECCIONA LIBRER�?A DE IM�?GENES"); 
        
            LibreriaIn conexionLibreria = new LibreriaIn(botonAbrirLibreria);
            Libreria libreriaActual = conexionLibreria.getLibreria();
            
            if(!libreriaActual.equals(Libreria.libreriaVacia)){
                int contador = 0;
                while (libreriaActual.quedanImagenesDentroDelDirectorio()) {
                    Image imagen = libreriaActual.getSiguienteImagen();
                    iconos[contador].setNuevaImagen(imagen);
                    if (imagen.equals(Libreria.imagenVacia) == false) {
                        contador++;
                    }
                }
                //Si no hay suficientes imagenes para llenar la galeria
                if (libreriaActual.getNumImagenes() <= NUM_TOTAL_ICONOS) {
                    //Entonces no hay suficientes imagenes para llenar la galeria
                    numIconosValidos = contador;
                    //Entonces rellenamos con la imagen en blanco lo que queda
                    for (int i = numIconosValidos; i < NUM_TOTAL_ICONOS; i++) {
                        iconos[i].setImagenVacia();
                    }
                }

                //Deseleccionamos el borde que estaba con la libreria avanzarIconoanterior
                iconos[iconoActual].setBordeEstandar();
                //Seleccionamos el primer icono por defecto
                try{
                    actualizarIconoSeleccionado(0);
                    actualizarImagenPrincipal();
                }catch(Exception e){
                    System.out.println("No se ha podido actualiar el icono actual");    
                }
                //Ponemos el texto correspondiente
                setTextoAreaTexto("SELECCIONA EL ICONO A VISUALIZAR CON EL RATÓN O CON LOS BOTONES < Y >");
            
            }else{
                //Si entra dentro de este try catch probablemente ha pulsado el boton cancelar
                //por ello getLibreria ha devuelto null
                setTextoAreaTexto("SELECCIONA EL ICONO A VISUALIZAR CON EL RATÓN O CON LOS BOTONES < Y >");
            }
            
        
    }
    
    public static void avanzarSiguienteIcono(){
        try{
            int supuestoIconoSiguiente;
            //Calculamos el icono avanzarSiguienteIcono
            if(iconoActual + 1  >= NUM_TOTAL_ICONOS){
                supuestoIconoSiguiente = 0;
            }else{
                supuestoIconoSiguiente = iconoActual+1;
                if(!isIconoValido(supuestoIconoSiguiente)){
                    supuestoIconoSiguiente = 0;
                }
            }
            //Averiguamos si el iconoSiguiente calculado es valido y actuamos segun lo sea o no
            if(isIconoValido(supuestoIconoSiguiente)){
                actualizarIconoSeleccionado(supuestoIconoSiguiente);
                actualizarImagenPrincipal();
            }else{
                    mensajeIconoNoValido();
            }
        }catch(Exception e){
            System.out.println("No se ha podido mostrar el mensaje de icono no valido");
        }
    }
    
    public static void avanzarIconoanterior(){
        try{
            int supuestoIconoAnterior;
            //Calculamos el iconoAnterior
            if(iconoActual -1 <0){
                supuestoIconoAnterior = numIconosValidos-1;
            }else{
                supuestoIconoAnterior = iconoActual-1;
            }
            //Averiguamos si el iconoAnterior calculado es valido y actuamos segun lo sea o no
            if(isIconoValido(supuestoIconoAnterior)){
                actualizarIconoSeleccionado(supuestoIconoAnterior);
                actualizarImagenPrincipal();
            }else{
                try{
                    mensajeIconoNoValido();
                }catch(Exception e){
                    System.out.println("No se ha podido mostrar el mensaje de icono no valido");
                }
            }
        }
        catch(Exception e){
            System.out.println("No se ha podido ir al icono anterior" + e.getLocalizedMessage());    
        }
    }
    
    public static void actualizarIconoSeleccionado(int ico) throws Exception{
        //Deseleccionamos el icono avanzarIconoanterior
        iconos[iconoActual].setBordeEstandar();
        //Seleccionamos el nuevo icono
        iconos[ico].setBordeSeleccionar();
        //Actualizamos el iconoActual 
        iconoActual = ico;     
    }

    public static void actualizarImagenPrincipal() throws Exception{
        imagenPrincipal.setIcon(new ImageIcon(iconos[iconoActual].getImagenTamañoGrande()));
    }
    
    public static boolean isIconoValido(int ico){
        return (ico < numIconosValidos);
    }
    
    public static void mensajeIconoNoValido(){
        try{
            setTextoAreaTexto("ICONO SELECCIONADO NO REPRESENTA IMAGEN <<SELECCIONA OTRO ICONO");
            Toolkit.getDefaultToolkit().beep();
        }catch (Exception ex) {
            System.out.println("No se ha podido mostrar el mensaje no valido");;
        }
    }
    
    public static void setTextoAreaTexto(String s){
        try{
            areaTexto.setText(s);
        }catch(Exception e){
            System.out.println("No se ha podido actualizar el texto del area de texto");
        }
    }
}
  