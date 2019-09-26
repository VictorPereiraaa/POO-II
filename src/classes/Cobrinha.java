package classes;

import java.util.List;
import java.util.ArrayList;

/**
 * Classe responsável pela geração e a movimentação da cobrinha
 * 
 */

public class Cobrinha {

    private List<Ponto> listaPontos;
    private int movimento;
    private int movimentoAnterior;

    //construtor da cobra
    public Cobrinha() {
        listaPontos = new ArrayList<Ponto>();
        inicia();
    }

    //retorn a direção da cobra
    public int getMovimento() {
        return movimento;
    }

    public void setMovimento(int movimento) {
        this.movimento = movimento;
    }

    public List<Ponto> getPontos() {
        return listaPontos;
    }

    //faz a cobra subir
    public void sobe() {
        if (movimentoAnterior == ConstantesGlobais.DESCE) {
            desce();
            return;
        }
        Ponto cabeca = listaPontos.get(listaPontos.size() - 1);
        Ponto novaCabeca = new Ponto(cabeca.getX(), cabeca.getY() - 1);
        listaPontos.remove(0);
        listaPontos.add(novaCabeca);
        movimentoAnterior = ConstantesGlobais.SOBE;

    }

    //faz a cobra descer
    public void desce() {
        if (movimentoAnterior == ConstantesGlobais.SOBE) { //verifica se a cobra esta subindo, se a cobra estiver subindo, 
            sobe();										   // não é possível realizar a descida
            return;
        }
        Ponto cabeca = listaPontos.get(listaPontos.size() - 1);
        Ponto novaCabeca = new Ponto(cabeca.getX(), cabeca.getY() + 1);
        listaPontos.remove(0);
        listaPontos.add(novaCabeca);
        movimentoAnterior = ConstantesGlobais.DESCE;
    }

    //faz a cobra virar para esquerda
    public void esquerda() {
        if (movimentoAnterior == ConstantesGlobais.DIREITA) { //verifica se a cobra virou pra direita
            direita();
            return;
        }
        Ponto cabeca = listaPontos.get(listaPontos.size() - 1);
        Ponto novaCabeca = new Ponto(cabeca.getX() - 1, cabeca.getY());
        listaPontos.remove(0);
        listaPontos.add(novaCabeca);
        movimentoAnterior = ConstantesGlobais.ESQUERDA;

    }

    //faz a cobra virar para direita
    public void direita() {
        if (movimentoAnterior == ConstantesGlobais.ESQUERDA) {	//verifica se a cobra virou pra esquerda
            esquerda();
            return;
        }
        Ponto cabeca = listaPontos.get(listaPontos.size() - 1);
        Ponto novaCabeca = new Ponto(cabeca.getX() + 1, cabeca.getY());
        listaPontos.remove(0);
        listaPontos.add(novaCabeca);
        movimentoAnterior = ConstantesGlobais.DIREITA;
    }

    //seleciona qual o movimento da cobra baseado no valor de movimento
    public void executaMovimento() {
        switch (this.movimento) {
            case ConstantesGlobais.DIREITA:
                direita();
                break;
            case ConstantesGlobais.ESQUERDA:
                esquerda();
                break;
            case ConstantesGlobais.SOBE:
                sobe();
                break;
            case ConstantesGlobais.DESCE:
                desce();
                break;
            default:
        }
    }

    //adiciona um novo ponto
    public void adicionaPonto(Ponto p) {
        listaPontos.add(p);
    }
    
    //retorna o ponto da cabeça
    public Ponto getCabeca() {
        return this.listaPontos.get(this.listaPontos.size() - 1);
    }

    
    public Boolean pontoInLista(Ponto ponto) {
        for (Ponto p : listaPontos.subList(0, listaPontos.size() - 2)) {//pegando até o penultimo elemento
            if (p.equals(ponto)) {
                return true;
            }
        }
        return false;
    }
    
    public Boolean verificaChoque() {
        Ponto cabeca = getCabeca();
        return pontoInLista(cabeca);
    }
    
    //gera os primeiros pontos da cobra na matriz
    public void inicia() {   
        Ponto p = new Ponto(10, 10);
        listaPontos.add(p);
        p = new Ponto(11, 10);
        listaPontos.add(p);
        p = new Ponto(12, 10);
        listaPontos.add(p);
        p = new Ponto(13, 10);
        listaPontos.add(p);
        p = new Ponto(14, 10);
        listaPontos.add(p);
        p = new Ponto(15, 10);
        listaPontos.add(p);
        p = new Ponto(16, 10);
        listaPontos.add(p);
        movimento = ConstantesGlobais.NADA;
        movimentoAnterior = ConstantesGlobais.NADA;
    }
    
    //retorna o tamanho da cobra
    public int tamCobrinha(){  
        return listaPontos.size();
    }
}
