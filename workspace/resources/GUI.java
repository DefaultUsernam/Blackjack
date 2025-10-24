// Ulises Cantor
// Menchukov
// Period: 5
// 10/23/2025
// Computer Programming 3
// This GUI class arranges the board for the beginning of a blackjack game



package resources;

import javax.imageio.ImageIO;
import javax.swing.*;

import resources.Card.Suit;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Stack;
import java.util.concurrent.Flow;

public class GUI extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

	Blackjack game;

	public GUI(Blackjack game) {
		this.game = game;
		// Create and set up the window.
		setTitle("Blackjack");
		setSize(900, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// temporary deck of cards from 2-10 (no face cards or aces for now)
			Stack<Card> deckOCards = new Stack<Card>();
			for (int i = 2; i < 11; i++) {
				deckOCards.add(new Card(i, Card.Suit.Diamonds));
				deckOCards.add(new Card(i, Card.Suit.Hearts));
				deckOCards.add(new Card(i, Card.Suit.Spades));
				deckOCards.add(new Card(i, Card.Suit.Clubs));
			}

		// this supplies the background
		try {

			// creates the back panel with the green mat
			Image blackImg = ImageIO.read(getClass().getResource("background.jpg"));
			ImagePanel backPanel = new ImagePanel(blackImg);
			backPanel.setLayout(new BorderLayout());
			setContentPane(backPanel);

			// creates a panel with a blue border in the middle to hold the hit and stand button

			JPanel hitArea = new JPanel();
			hitArea.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLUE));
			hitArea.setOpaque(false);
			hitArea.setPreferredSize(new Dimension(300, 300));
			backPanel.add(hitArea, BorderLayout.CENTER);
			
			// buttons are added to the middle section
			JButton hit = new JButton("Hit");
			hitArea.add(hit);

			JButton stand = new JButton("Stand");
			hitArea.add(stand);

			// creates a panel with a red border on the left that will contain the dealer's cards

			JPanel dealer = new JPanel();
			dealer.setPreferredSize(new Dimension(300, 300));
			dealer.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
			dealer.setOpaque(false);
			backPanel.add(dealer, BorderLayout.WEST);

			// adds two random stacked cards to the dealer side
			JLayeredPane dealHand = drawPile(deckOCards);
			dealer.add(dealHand);

			// creates a panel with a green border on the right for the player's cards
			JPanel you = new JPanel();
			you.setPreferredSize(new Dimension(300, 300));
			you.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GREEN));
			you.setOpaque(false);
			backPanel.add(you, BorderLayout.EAST);

			// adds two random stacked cards to the player side
			JLayeredPane yoHand = drawPile(deckOCards);
			you.add(yoHand);

			this.setVisible(true);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// creates a pile of two stacked cards for now
	public JLayeredPane drawPile(Stack<Card> stackIn) {

		// creates the layered pane that will be returned
		JLayeredPane retLP = new JLayeredPane();
		retLP.setPreferredSize(new Dimension(240, 320));

		Object cards[];

		cards = stackIn.toArray();
		// picks two random card elements
		int rand1 = (int) (Math.random() * cards.length);
		int rand2 = rand1;
		while (rand2 == rand1) {
			rand2 = (int) (Math.random() * cards.length);
		}

		// adds the random cards to the layered pane, stacking the second card on top of the first 
		Card add1 = (Card) cards[rand1];
		add1.setPreferredSize(new Dimension(100, 140));
		add1.setBounds(0, 0, 100, 140);
		retLP.add(add1, JLayeredPane.DEFAULT_LAYER);
		Card add2 = (Card) cards[rand2];
		add2.setBounds(25, 25, 100, 140);
		retLP.add(add2, JLayeredPane.PALETTE_LAYER);

		retLP.setOpaque(false);
		retLP.setVisible(true);

		return retLP;

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
