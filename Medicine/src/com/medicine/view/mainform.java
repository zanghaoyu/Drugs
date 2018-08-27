package com.medicine.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;

public class mainform extends JFrame {

	private JPanel contentPane;
	private final JDesktopPane desktopPane = new JDesktopPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainform frame = new mainform();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 617, 21);
		contentPane.add(menuBar);
		
		JMenu menu = new JMenu("\u836F\u54C1\u7BA1\u7406");
		menuBar.add(menu);
		
		JMenuItem addDrugs = new JMenuItem("\u6DFB\u52A0\u836F\u54C1");
		menu.add(addDrugs);
		
		JMenuItem checkDrugs = new JMenuItem("\u67E5\u8BE2\u836F\u54C1");
		menu.add(checkDrugs);
		
		JMenuItem saleDrugs = new JMenuItem("\u836F\u54C1\u9500\u552E");
		menu.add(saleDrugs);
		
		JMenu menu_1 = new JMenu("\u4F9B\u5E94\u5546\u7BA1\u7406");
		menuBar.add(menu_1);
		
		JMenuItem addSuppiler = new JMenuItem("\u6DFB\u52A0\u4F9B\u5E94\u5546");
		menu_1.add(addSuppiler);
		
		JMenuItem checkSuppiler = new JMenuItem("\u67E5\u8BE2\u4F9B\u5E94\u5546");
		menu_1.add(checkSuppiler);
		
		JMenu menu_2 = new JMenu("\u5E93\u5B58\u7BA1\u7406");
		menuBar.add(menu_2);
		
		JMenuItem addStock = new JMenuItem("\u6DFB\u52A0\u5E93\u5B58");
		menu_2.add(addStock);
		
		JMenuItem checkStorck = new JMenuItem("\u67E5\u8BE2\u5E93\u5B58");
		menu_2.add(checkStorck);
		
		JMenu menu_3 = new JMenu("\u5BA2\u6237\u7BA1\u7406");
		menuBar.add(menu_3);
		
		JMenuItem addCut = new JMenuItem("\u6DFB\u52A0\u5BA2\u6237");
		menu_3.add(addCut);
		
		JMenuItem checkCut = new JMenuItem("\u67E5\u8BE2\u5BA2\u6237");
		menu_3.add(checkCut);
		
		JMenu menu_4 = new JMenu("\u7528\u6237\u7BA1\u7406");
		menuBar.add(menu_4);
		
		JMenuItem addUser = new JMenuItem("\u6DFB\u52A0\u7528\u6237");
		menu_4.add(addUser);
		
		JMenuItem checkUser = new JMenuItem("\u67E5\u8BE2\u7528\u6237");
		menu_4.add(checkUser);
		desktopPane.setBounds(0, 21, 617, 381);
		contentPane.add(desktopPane);
		
	}
}
