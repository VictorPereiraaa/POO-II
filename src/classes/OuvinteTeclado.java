package classes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Classe que registra os comandos do teclado
 * 
 */

public class OuvinteTeclado implements KeyListener{
    private PainelJogo referencia;
    
    //construtor da classe
    OuvinteTeclado(PainelJogo referencia) {
        this.referencia = referencia;
    }
    
    @Override
    //tecla apertada
    public void keyTyped(KeyEvent e) {
    }

    @Override
    //configura as setas do teclado para mover a cobra
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_RIGHT){
            referencia.getJogo().getCobrinha().setMovimento(ConstantesGlobais.DIREITA);
        }
        if (event.getKeyCode() == KeyEvent.VK_LEFT){
            referencia.getJogo().getCobrinha().setMovimento(ConstantesGlobais.ESQUERDA);
        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN){
            referencia.getJogo().getCobrinha().setMovimento(ConstantesGlobais.DESCE);
        }
        if (event.getKeyCode() == KeyEvent.VK_UP){
            referencia.getJogo().getCobrinha().setMovimento(ConstantesGlobais.SOBE);
        }
    }

    @Override
    //tecla soltada
    public void keyReleased(KeyEvent e) {
    }
    
}
