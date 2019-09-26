package classes;

import classes.JanelaPrincipal;
import java.awt.HeadlessException;

/**
 * Classe que cont�m a main respons�vel por iniciar o programa
 */

public class Jogo_da_cobrinha {
	
    public static void main(String[] args) {
        try{			//inicia o programa se n�o, termina por uma Exception
           JanelaPrincipal programa = new JanelaPrincipal();
           programa.inicia();
        } catch (HeadlessException excecao){
            impMsgErroETermina("Programa terminado por uma HeadlessException no método main()",excecao);   //termina por uma HeadlessException
        } catch (Exception excecao){
            impMsgErroETermina("Programa terminado por uma Generic Exception no método main()",excecao);	//termina por uma GenericException
        }
    }
    
    //imprime mensagem de erro e termina o programa
    private static void impMsgErroETermina(String mensagem, Exception ocorrencia ){
        System.out.println();
        System.out.println(mensagem);        
        System.out.print("Texto da exceção \t" + ocorrencia.getMessage());
        ocorrencia.printStackTrace();
        
        System.exit(1);
    }
    
}