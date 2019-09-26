package classes;

import java.util.Random;

/**
 * 
 * Classe responsável por gerar e verificar os movimentos da cobra 
 * 
 */

public class Jogo {    
    private int numPontosX;
    private int numPontosY;
    private int recorde;
    private Ponto ponto;
    private Random rand;
    private Cobrinha cobrinha;
   
    //construtor do Jogo
    public Jogo(Cobrinha cobrinha) {
       this.recorde = 0;
       this.rand = new Random();       
       this.ponto = new Ponto(ConstantesGlobais.INI_X, ConstantesGlobais.INI_Y);
       this.cobrinha = cobrinha;
       calculaTamMatriz();
       atualizaRecorde();
    }    

    private void calculaTamMatriz() {
        this.numPontosX = ConstantesGlobais.LARGURA_JOGO / ConstantesGlobais.TAMANHO_PONTO;
        this.numPontosY = ConstantesGlobais.ALTURA_JOGO / ConstantesGlobais.TAMANHO_PONTO;
    }
   
    //gera a maça em um ponto aleatório
    public int sorteia(int max){
        return rand.nextInt(max);
    }

    public Ponto geraNovoPonto(){
        int x = sorteia(numPontosX);
        int y = sorteia(numPontosY);
        ponto = new Ponto(x, y);
        return ponto;
    }

    public Ponto getPonto() {
        return ponto;
    }
    
    //adiciona um ponto extra na cobra
    public void aumentarCobrinha(){
        if(!validaCobrinhaCresceu()){
            return;
        }
        cobrinha.adicionaPonto(ponto);
        atualizaRecorde();
        geraNovoPonto();
    }

    private boolean validaCobrinhaCresceu() {
        return this.ponto.equals(this.cobrinha.getCabeca());
    }
    
    public void validaCobrinhaMorreu(){
        if(cobrinha.verificaChoque() || verificaDentroCaixa() ){
           morreu(); 
        }
    }

    private Boolean verificaDentroCaixa() {
        Ponto cabeca = cobrinha.getCabeca();
        return cabeca.getX() >= numPontosX || cabeca.getY() >= numPontosY 
                || cabeca.getX() < 0 || cabeca.getY() < 0;
    }

    //reinicia a cobra para a posição inicial
    private void morreu() {
        this.cobrinha.getPontos().clear();
        this.cobrinha.inicia();
        geraNovoPonto();
    }

    void movimentaCobrinha() {
        cobrinha.executaMovimento();
        validaCobrinhaMorreu();
    }

    //retorna um objeto cobrinha
    public Cobrinha getCobrinha() {
        return cobrinha;
    }

    //retorna o recorde
    public int getRecorde() {
        return recorde;
    }
    
    //atualiza o recorde se o tamanho da cobra for maior que o recorde
    public void atualizaRecorde(){
        if (this.recorde < this.cobrinha.tamCobrinha()){
            this.recorde = this.cobrinha.tamCobrinha();
        } 
    }

} 

