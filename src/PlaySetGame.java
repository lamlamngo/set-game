import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	
    /**
     * CanvasPanel is the class upon which we actually draw.  It listens
     * for mouse events.
     */
    private class CanvasPanel extends JPanel implements MouseListener, MouseMotionListener {
        private static final long serialVersionUID = 0;

        /**
         * Constructor just needs to set up the CanvasPanel as a listener.
         */
        public CanvasPanel() {
            addMouseListener(this);
            addMouseMotionListener(this);

        }

        /**
         * Paint the whole drawing.
         * if it is in tutorial, printout the tutorial message.
         * @page the Graphics object to draw on
         */
        public void paintComponent(Graphics page) {
            super.paintComponent(page);
            myGame.display(page);
            if (inTutorial){
                page.drawString("Welcome to tutorial mode! The goal of this "
                				+ "tutorial is to demonstrate how to make a set. "
                				+ "A set consists", 7, 370);
                page.drawString(" of three cards all of which contain four elements: shape, "
                				+ "number of elements, color, and "
                				+ "shading. ", 7, 390);
                page.drawString("A valid set has either all the same or different "
                				+ "values for EACH of the individual four elements."
        						, 7, 410);
                page.drawString(" If you need help identifying a set, click 'show sets' in the upper right hand corner. "
                				 , 7, 430);
                page.drawString( "Once you are comfortable the formation of a set, test" + "your skills against the clock "
        						+ "in solitaire mode!" , 7, 450);
                				
               
            }
        }

        /**
         * When the mouse is clicked, check to see if setgame can remove card and if the game ends.
         */
        public void mouseClicked(MouseEvent event) {
            if (!inTutorial){
                int result = myGame.getCards(event.getPoint());
                if (result == 1){
                    JOptionPane.showMessageDialog(null, "You got a set!");
                    myGame.removeSelected();
                    myGame.ensureFullField();
                    repaint();
                    checkEndGame();
                }else if (result == 0){
                    JOptionPane.showMessageDialog(null, "Not a set!");
                    myGame.deSelectCards();
                }
                updateCounter();
            }
            repaint();
        }

        //we don't use these.
        public void mousePressed(MouseEvent event) { }
        public void mouseDragged(MouseEvent event)  { }
        public void mouseReleased(MouseEvent event) { }
        public void mouseEntered(MouseEvent event) { }
        public void mouseExited(MouseEvent event) { }
        public void mouseMoved(MouseEvent event) { }
    }
}
