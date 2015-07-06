package race;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class race {

	protected static final Color[] COLORS = { Color.black, Color.yellow,
			Color.blue, Color.green, Color.magenta, Color.cyan};

	public static void main(final String[] args) {

		Model model = new Model();

		final Controller controller = new Controller();

		model.addListener(controller);

		View view = new View();
		controller.setView(view);
		controller.setModel(model);

		JFrame frame = new JFrame("Race");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(250, 550));


		frame.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(final KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					controller.moveLeft();
					break;

				case KeyEvent.VK_RIGHT:
					controller.moveRight();
					break;

				default:
					break;
				}
			}

		});
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					controller.moveDown();
				}
			}
		});
		thread.setDaemon(true);
		thread.start();

		frame.add(panel);

		frame.pack();

		frame.setVisible(true);

		final Graphics2D graphics = (Graphics2D) panel.getGraphics();
		
		view.setGraphics(new Graphics() {
			
			@Override
			public void fillRect(final int x, final int y, final int width,
					final int height, final int colorIndex) {
				graphics.setColor(COLORS[colorIndex]);
				graphics.fillRect(x, y, width, height);
			}
		});
	}

}