package classes;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * Classe responsável pela inicialização e configuração da janela principal
 * 
 */

public class JanelaPrincipal extends JFrame implements ActionListener,Runnable{
	
	private static final long serialVersionUID = 1L;
	private PainelMenu painelMenu;
    private PainelJogo painelJogo;
    private PainelStatus painelStatus;
    private Boolean rodando;
    private OuvinteTeclado ouvinteTeclado;
    private Jogo jogo;
    private Cobrinha cobrinha;
    
    //construtor da JanelaPrincipal
    public JanelaPrincipal() throws HeadlessException {
        super(ConstantesGlobais.nomeSistema);    
        this.rodando = false;
    }
    
    //gera a janela
    public void inicia() {
        this.setVisible(true);
        
        this.cobrinha = new Cobrinha();
        this.jogo = new Jogo(cobrinha);
        
        configuraJanela();
        iniciaEAddComponents();
        this.rodando = true;
        Thread serverDispatcher = new Thread(this);
        serverDispatcher.start();
    }

    
    private void configuraJanela() {
        // tamanho da janela relativo ao tamanho da tela do usuario
        this.setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.5),
                (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.45));
        
        // centraliza a janela 
        this.setLocationRelativeTo(null);
        
        //fecha a janela ao clicar no icone de fechar
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setLayout(new BorderLayout(5, 5));
        this.setIconeJanela();
    }

    private void setIconeJanela() {
        //implementar 
    }

    //cria os componentes da janela
    private void iniciaEAddComponents() {
        this.painelStatus = new PainelStatus();
        this.painelJogo = new PainelJogo(this.jogo);
        this.painelMenu = new PainelMenu(this.jogo);

        this.add(painelStatus, BorderLayout.SOUTH);
        this.add(painelMenu, BorderLayout.WEST);
        this.add(painelJogo, BorderLayout.CENTER);
        
        this.ouvinteTeclado = new OuvinteTeclado(this.painelJogo);
        this.addKeyListener(ouvinteTeclado);
    }

    @Override
    //roda o janela
    public void run(){
        while (this.rodando){
            painelJogo.repaint();
            painelMenu.atualizaLabel();
            try{
                Thread.sleep(ConstantesGlobais.TEMPO);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
