package uk.ac.mmu.advproglab11;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class HygieneRatingUI {
	
	public static void main(String[] args) {
		
	for(int i=0;i<10;i++) {
		
		final int ii = i;
		new Thread(new Runnable() {
			public void run() {
				System.out.println("I am thread number " + ii);
			}
		}).start();
	
	
			
	JFrame s = new JFrame ("Hygiene Rating");
	
	JTextField t1 = new JTextField("SW1A 1");
	JButton b1 = new JButton ("Search");
	JTextArea a1 = new JTextArea();
	
	JPanel HygieneRatingUIPanel = new JPanel();

	JPanel topPanel = new JPanel();
	
	b1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			a1.setText("");
			a1.append(HygieneServiceClient.retrieveRatings(t1.getText()));
			
			HygieneRatingUIPanel.invalidate();
			HygieneRatingUIPanel.repaint();
		}
	});
	
	
	Container c = s.getContentPane();

	c.setLayout(new BorderLayout());
	topPanel.setLayout (new FlowLayout ()) ;
	HygieneRatingUIPanel.setLayout(new FlowLayout());
	
	a1.setPreferredSize(new Dimension(400,300));
	
	topPanel.add(t1);
	topPanel.add(b1);
	
	HygieneRatingUIPanel.add(a1);




	c.add (topPanel,BorderLayout.NORTH) ;

	c.add (HygieneRatingUIPanel,BorderLayout.CENTER) ;
	
	s.pack();
	s.setVisible(true);

	}
}
	

}
