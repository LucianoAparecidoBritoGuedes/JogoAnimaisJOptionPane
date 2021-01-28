package entities.constraints;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public final class Messages {
	public static final String WELCOME = " seja bem-vindo(a)!\nEste é um jogo de adivinhação de animais.\n\nBoa sorte!";
	public static final String TITLE = "Jogo de Adivinhação de Animais";
	public static final String WINNER_1 = "Eu venci!";
	public static final String WINNER_2 = "Parabéns, você venceu!";
	public static final String HABITAT1 = "Aquático";
	public static final String HABITAT2 = "Terrestre";
	
	//metodo para informar o placar final do jogo
	public static void finalScoreMessage(JFrame frame, String player, int score) {
		if (player != null) {
			if(player != "Computador") {
				JOptionPane.showMessageDialog(frame, "Parabéns "
						+ player + "! Você é o vencedor desta partida com " + score + " pontos.\n",
						"Pontuação Final", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(frame, "Que pena! Dessa vez quem levou a melhor foi o "
						+ player + " com " + score + " pontos.\n"
						+ "Vamos continuar? Talvez na próxima você ganhe!",
						"Pontuação Final", JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(frame, "Dessa vez, ninguém levou a melhor! Ambos ficamos com "
					+ score + " pontos.\n"
					+ "Podemos jogar novamente em outro momento!",
					"Empate", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
