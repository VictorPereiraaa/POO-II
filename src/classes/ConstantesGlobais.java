package classes;

import java.awt.Color;

/**
 * Classe responsável pelo registro de constantes globais
 */

public class ConstantesGlobais {
    public static final String nomeSistema = "Jogo da Cobrinha";
    public static final int LARGURA_JOGO = 400;	
    public static final int ALTURA_JOGO = 500;
    public static final int TAMANHO_PONTO = 10;
    public static final int INI_X = 30;
    public static final int INI_Y = 30;
    public static final int SOBE = 1;	
    public static final int DESCE = 2;
    public static final int DIREITA = 3;
    public static final int ESQUERDA = 4;
    public static final int NADA = 0;
    public static final int TEMPO = 80;	//define a velocidade da cobra
    public static final Color COR_FUNDO = new Color(0,204,0);
    public static final Color COR_PONTO = new Color(204,0,0);
    public static final Color COR_COBRA = new Color(64,64,64);
}
