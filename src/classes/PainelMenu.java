package classes;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Configura e adiciona o painel de informações do jogo
 */

public class PainelMenu extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel lableRecorde;
	private JLabel labelContador;
	private JPanel painelInfo;
	private Jogo jogo;

	//construtor de PainelMenu
	public PainelMenu(Jogo jogo) {
		this.jogo = jogo;
		configuraPainel();
	}

	//inicia e adiciona os elementos do painel
	private void configuraPainel() {
		painelInfo = new JPanel();
		painelInfo.setBackground(this.getBackground());

		lableRecorde = new JLabel();
		lableRecorde.setBackground(Color.BLACK);
		lableRecorde.setForeground(Color.green);

		labelContador = new JLabel();
		labelContador.setBackground(Color.BLACK);
		labelContador.setForeground(Color.green);

		painelInfo.add(lableRecorde);
		painelInfo.add(labelContador);

		this.add(painelInfo, BorderLayout.NORTH);
		this.setBackground(Color.RED);
		this.setBorder(BorderFactory.createEtchedBorder());

	}

	//atualiza o valor do recorde e da pontuação com base no tamanho da cobra
	public void atualizaLabel() {
		lableRecorde.setText(String.valueOf(jogo.getRecorde() - 7)); //atualiza o recorde 
		labelContador.setText(String.valueOf(jogo.getCobrinha().tamCobrinha() - 7)); //atualiza a pontuação
	}

}