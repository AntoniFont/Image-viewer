package Elementos_visuales_interactuables;

import antonifontmarintaller2avaluable.ProgramaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class BotonAbrirLibreria extends JButton{
    
    private ActionListener funcionalidadBotonAbrirLibreria = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ProgramaPrincipal.abrirLibreria();
        }
    };
    
    public BotonAbrirLibreria(){
        super("ABRIR LIBRERIA IMAGENES");
        this.addActionListener(funcionalidadBotonAbrirLibreria);
    }
    
}
