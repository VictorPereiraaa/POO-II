package classes;

import java.util.Random;

/**
 * Classe responsável pela configuração inicial do jogo
 * 
 */

public class ConfigJogo {    
    private int numPontosX;
    private int numPontosY;
    private Ponto ponto;
    private Random rand;
    
    //construtor do ConfigJogo
    public ConfigJogo() {
       rand = new Random();       
       ponto = new Ponto(ConstantesGlobais.INI_X, ConstantesGlobais.INI_Y);
       calculaTamMatriz();
    }    
    
    //calcula o tamanho da matriz proporcional as dimensões da janela e do ponto
    private void calculaTamMatriz() {
        this.numPontosX = ConstantesGlobais.LARGURA_JOGO / ConstantesGlobais.TAMANHO_PONTO;
        this.numPontosY = ConstantesGlobais.ALTURA_JOGO / ConstantesGlobais.TAMANHO_PONTO;
    }
    
    //retorna o próximo número inteiro de max
    public int sorteia(int max){
        return rand.nextInt(max);
    }

    public Ponto geraNovoPonto(){
        ponto.setX(sorteia(numPontosX));
        ponto.setY(sorteia(numPontosY));
        return ponto;
    }
    
    
} 