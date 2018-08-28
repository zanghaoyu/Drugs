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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 800,800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 784, 21);
		contentPane.add(menuBar);
		
		//管理菜单
		JMenu manage = new JMenu("\u7BA1\u7406");
		menuBar.add(manage);
		
		//管理员注册
		JMenuItem administrators = new JMenuItem("\u7BA1\u7406\u5458\u6CE8\u518C");
		manage.add(administrators);
		
		//登记
		JMenu login = new JMenu("\u767B\u8BB0");
		manage.add(login);
		
		//药品登记
		JMenuItem DrugLogin = new JMenuItem("\u836F\u54C1\u767B\u8BB0");
		DrugLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicineAdd medicineadd =new MedicineAdd();
				medicineadd.setVisible(true);
				desktopPane.add(medicineadd);
			}
		});
		login.add(DrugLogin);
		
		//供应商登记
		JMenuItem SupplierLogin = new JMenuItem("\u4F9B\u5E94\u5546\u767B\u8BB0");
		login.add(SupplierLogin);
		
		//患者登记
		JMenuItem CustomerLogin = new JMenuItem("\u60A3\u8005\u767B\u8BB0");
		login.add(CustomerLogin);
		
		//库存登记
		JMenuItem StockLogin = new JMenuItem("\u5E93\u5B58\u767B\u8BB0");
		login.add(StockLogin);
		
		//查询
		JMenu Check = new JMenu("\u67E5\u8BE2");
		menuBar.add(Check);
		
		//药品查询
		JMenuItem DrugCheck = new JMenuItem("\u836F\u54C1\u67E5\u8BE2");
		DrugCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicineCheck medicinecheck=new MedicineCheck();
				medicinecheck.setVisible(true);
				desktopPane.add(medicinecheck);
				
			}
		});
		Check.add(DrugCheck);
		
		//供应商查询
		JMenuItem SupplierCheck = new JMenuItem("\u4F9B\u5E94\u5546\u67E5\u8BE2");
		Check.add(SupplierCheck);
		
		//用户查询
		JMenuItem UserCheck = new JMenuItem("\u7528\u6237\u4FE1\u606F\u67E5\u8BE2");
		Check.add(UserCheck);
		
		//库存查询
		JMenuItem StockCheck = new JMenuItem("\u5E93\u5B58\u67E5\u8BE2");
		Check.add(StockCheck);
		
		//患者查询
		JMenuItem CustomerCheck = new JMenuItem("\u60A3\u8005\u67E5\u8BE2");
		Check.add(CustomerCheck);
		
		//购买记录查询
		JMenuItem BuyCheck = new JMenuItem("\u8D2D\u4E70\u8BB0\u5F55\u67E5\u8BE2");
		Check.add(BuyCheck);
		
		//出售
		JMenu Sell = new JMenu("\u51FA\u552E");
		menuBar.add(Sell);
		desktopPane.setBounds(0, 21, 784, 729);
		contentPane.add(desktopPane);
		
	}
}
