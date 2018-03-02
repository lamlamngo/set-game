import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class PlaySetGame extends JFrame{
    private static final long serialVersionUID = 1L;
    private final int APPLET_WIDTH = 700, APPLET_HEIGHT = 500;
    private static final String CARDS_LEFT = "cards in deck: ";
    private static final String SET_COUNT = "Set: ";

    private SetGame myGame;     // a set game object
    private static CanvasPanel canvasPanel;
    private JPanel solitairePanel, menuPanel, titlePanel, switchPanel, tutorialPanel;       // panels of the applet
    private JLabel titleLabel;
    private CustomButton showButton;
    private CustomButton solitaireButton, tutorialButton, dealButton, addButton, quitButton,
    switchsolitaireButton, switchtutorialButton, switchQuitButton, showAllButton, readyButton; // various button of the applet
    private Container cp;
    private boolean inTutorial = false; // a boolean to suggest when we are in tutorial mode
    private long startTime;
    private int count;
    private JLabel setCount, cardCount, counter;    // JLabel to display text
    private Timer timer;                        // A timer object
    
	public PlaySetGame() {
		
	}
}
