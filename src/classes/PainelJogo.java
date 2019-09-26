package classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * Configura a tela de jogo
 */

public class PainelJogo extends JPanel {
    
	
	private static final long serialVersionUID = 1L;
	private Jogo jogo;
    
	public PainelJogo(Jogo jogo) {
        this.jogo = jogo;
        configuraPainel();
    }
	
	//retorna um objeto Jogo
    public Jogo getJogo() {
        return jogo;
    }
    
    //setando informações gráficas do painel
    private void configuraPainel() {
        this.setVisible(true);
        this.setBackground(new Color(0,153,0));
        this.setBorder(BorderFactory.createEtchedBorder());
    }

    @Override
    //pinta os elementos da tela
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        final Graphics2D auxGraphics = (Graphics2D) g;
        
        //pinta fundo
        auxGraphics.drawString("This is another test string", 100, 100);
        auxGraphics.setColor(ConstantesGlobais.COR_FUNDO);
        auxGraphics.fillRect(ConstantesGlobais.INI_X, ConstantesGlobais.INI_Y, ConstantesGlobais.LARGURA_JOGO, ConstantesGlobais.ALTURA_JOGO);
        jogo.aumentarCobrinha();
        
        //pinta ponto
        Ponto p = jogo.getPonto();
        auxGraphics.setColor(ConstantesGlobais.COR_PONTO);
        auxGraphics.fillRect(p.desenhaX(), p.desenhaY(), ConstantesGlobais.TAMANHO_PONTO, ConstantesGlobais.TAMANHO_PONTO);
        
        //pinta cobra
        jogo.movimentaCobrinha();        
        List<Ponto> pontosCobrinha = jogo.getCobrinha().getPontos();
        for(Ponto ptCobrinha : pontosCobrinha){
            auxGraphics.setColor(ConstantesGlobais.COR_COBRA);
            auxGraphics.fillRect(ptCobrinha.desenhaX(), ptCobrinha.desenhaY(), ConstantesGlobais.TAMANHO_PONTO, ConstantesGlobais.TAMANHO_PONTO);
        }
    }

}

