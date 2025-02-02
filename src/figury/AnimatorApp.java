package figury;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class AnimatorApp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final AnimatorApp frame = new AnimatorApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param //delay
	 */
	public AnimatorApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int ww = 450, wh = 300;
		setBounds((screen.width-ww)/2, (screen.height-wh)/2, ww, wh);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		AnimPanel kanwa = new AnimPanel();
		kanwa.setBounds(10, 10, ww-28, wh-27-50);
		contentPane.add(kanwa);

		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				kanwa.initialize();
			}
		});

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addFig();
			}
		});
		btnAdd.setBounds(10, wh-27-30, 80, 23);
		contentPane.add(btnAdd);
		//kanwa.delay= kanwa.delay;


		JButton btnUp = new JButton("Speed!");
		btnUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(kanwa.delay>10){
					kanwa.delay=kanwa.delay-20;
				}
			}
		});
		btnUp.setBounds(100,wh-27-30,80,23);
		contentPane.add(btnUp);

		JButton btnDown = new JButton("Slow!");
		btnDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(kanwa.delay<130){
					kanwa.delay=kanwa.delay+20;
				}
			}
		});
		btnDown.setBounds(180,wh-27-30,80,23);
		contentPane.add(btnDown);
		
		JButton btnAnimate = new JButton("Animate");
		btnAnimate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.animate();
			}
		});
		btnAnimate.setBounds(100, wh-30-27, 80, 23);
		contentPane.add(btnAnimate);

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int w= contentPane.getWidth();
				int h= contentPane.getHeight();
				btnAdd.setBounds(10,h-30,80,23);
				btnAnimate.setBounds(w-100,h-30,80,23);
				btnUp.setBounds(100,h-30,80,23);
				btnDown.setBounds(180,h-30,80,23);
			}
		});

	}

}
