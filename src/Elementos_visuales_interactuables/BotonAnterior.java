package Elementos_visuales_interactuables;

import antonifontmarintaller2avaluable.ProgramaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class BotonAnterior extends JButton {
    
    private ActionListener funcionalidadBotonAnterior = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ProgramaPrincipal.avanzarIconoanterior();
        }
    };
    
    public BotonAnterior(){
        super("<");
        this.addActionListener(funcionalidadBotonAnterior);
    }
    
}
