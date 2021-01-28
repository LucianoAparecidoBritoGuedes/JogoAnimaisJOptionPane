package application;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entities.Animal;
import entities.Player;
import entities.constraints.Messages;

public class Game {
	public static void play() {
		
		boolean control;
		
		JFrame frame = new JFrame();
		Player player1 = new Player("Computador");
		Player player2 = new Player();
		List<Animal> animalList1 = new ArrayList<>();
		List<Animal> animalList2 = new ArrayList<>();
		animalList1.add(new Animal("Tubarão", "Aquático"));
		animalList2.add(new Animal("Macaco", "Terrestre"));
	
		String playerName = JOptionPane.showInputDialog(frame, "Qual é o seu nome?", "João");
		player2.setName(playerName);
		
		JOptionPane.showMessageDialog(frame, "Olá " + player2.getName() + Messages.WELCOME, "Welcome", JOptionPane.INFORMATION_MESSAGE); 

		do {			
			JOptionPane.showMessageDialog(frame, "Pense em um animal!", Messages.TITLE, JOptionPane.INFORMATION_MESSAGE);
			int result = JOptionPane.showConfirmDialog(frame, "O Animal que você pensou é aquático?", Messages.TITLE, JOptionPane.YES_NO_OPTION);	
						
			//animal aquático?
			if(result == JOptionPane.YES_OPTION) {
				for(int i=0; i<=animalList1.size(); i++) {	
					if (i<animalList1.size()) {	
						int result1 = JOptionPane.showConfirmDialog(null, "O Animal que você pensou é um(a) " 
									+ animalList1.get(i).getName() + "?", Messages.TITLE, JOptionPane.YES_NO_OPTION);						
						if(result1 == JOptionPane.YES_OPTION) {
							JOptionPane.showMessageDialog(frame, Messages.WINNER_1);
							player1.setTotalValue(player1.getTotalValue()+1);
							break;
						} else if(result1 == JOptionPane.NO_OPTION) {
							continue;							
						} else {
							System.exit(0);
							break;
						}
					} else {
						String animal = JOptionPane.showInputDialog(frame, "Em qual animal você pensou?");
						if(animal != null || animal != "") {
							animalList1.add(new Animal(animal, Messages.HABITAT1));
						}
						JOptionPane.showMessageDialog(frame, Messages.WINNER_2, "Vencedor", JOptionPane.INFORMATION_MESSAGE);
						player2.setTotalValue(player2.getTotalValue()+1);
						break;
					}
				}
			} else if(result == JOptionPane.NO_OPTION) {
				for(int i=0; i<=animalList2.size(); i++) {	
					if (i<animalList2.size()) {	
						int result1 = JOptionPane.showConfirmDialog(null, "O Animal que você pensou é um(a) " 
									+ animalList2.get(i).getName() + "?", Messages.TITLE, JOptionPane.YES_NO_OPTION);						
						if(result1 == JOptionPane.YES_OPTION) {
							JOptionPane.showMessageDialog(frame, Messages.WINNER_1);
							player1.setTotalValue(player1.getTotalValue()+1);
							break;
						} else if(result1 == JOptionPane.NO_OPTION) {
							continue;							
						} else {
							System.exit(0);
							break;
						}
					} else {
						String animal = JOptionPane.showInputDialog(frame, "Em qual animal você pensou?");
						if(animal != null || animal != "") {
							animalList2.add(new Animal(animal, Messages.HABITAT2));
						}
						JOptionPane.showMessageDialog(frame, Messages.WINNER_2, "Vencedor", JOptionPane.INFORMATION_MESSAGE);
						player2.setTotalValue(player2.getTotalValue()+1);
						break;
					}
				}
			} else {
				System.exit(0);
			}
			
			JOptionPane.showMessageDialog(frame, "Pontuação atual:\n"
					+ player1.getName() + ": " + player1.getTotalValue() + "\n"
					+ player2.getName() + ": " + player2.getTotalValue() + "\n", 
					"Pontuação Atual", JOptionPane.INFORMATION_MESSAGE);
			
			control = proceed(frame, Messages.TITLE);
			
		} while(control);
		
		if(player1.getTotalValue() > player2.getTotalValue()) {
			Messages.finalScoreMessage(frame, player1.getName(), player1.getTotalValue());
		} else if (player1.getTotalValue() < player2.getTotalValue()) {
			Messages.finalScoreMessage(frame, player2.getName(), player2.getTotalValue());
		} else {
			Messages.finalScoreMessage(frame, null,player1.getTotalValue());
		}
		System.exit(0);
	}
	
	//metodo para obter resposta de continuidade 
	private static boolean proceed(JFrame frame, String TITLE) {
		int continuar = JOptionPane.showConfirmDialog(frame, "Deseja continuar jogando?", TITLE, JOptionPane.YES_NO_OPTION);
		if(continuar == JOptionPane.YES_OPTION) {
			return true;
		} else {
			return false;
		}
	}
}
