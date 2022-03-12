package Elementos_visuales_interactuables;

import antonifontmarintaller2avaluable.ProgramaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class BotonSiguiente extends JButton {

    private ActionListener funcionalidadBotonSiguiente = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            ProgramaPrincipal.avanzarSiguienteIcono();
        }

    };

    public BotonSiguiente() {
        super(">");
        this.addActionListener(funcionalidadBotonSiguiente);
    }
    
}
