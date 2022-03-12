package Elementos_visuales_interactuables;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class BotonFinalizar extends JButton {

    private ActionListener funcionalidadBotonFinalizar = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("FIN DEL PROGRAMA");
            System.exit(0);
        }
    };
    
    public BotonFinalizar() {
        super("FINALIZAR");
        this.addActionListener(funcionalidadBotonFinalizar);
    }
    
}
