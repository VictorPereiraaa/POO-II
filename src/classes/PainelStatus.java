package classes;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe responsável por adicionar a caixa de titulo na janela principal
 */

public class PainelStatus extends JPanel{
   
	private static final long serialVersionUID = 1L;
	private JLabel labelStatus;
    private String titulo;
    
    //construtor de PainelStatus
    public PainelStatus() {
        titulo = ConstantesGlobais.nomeSistema;
        configuraPainel();
    }

    //adiciona elementos na janela
    private void configuraPainel() {
        this.labelStatus = new JLabel(this.titulo);
        
        //adicionando label no painel
        this.add(labelStatus,BorderLayout.NORTH);
        
        // setando informações graficas do painel
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
    }
    
}
