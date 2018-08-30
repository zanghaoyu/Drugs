package com.medicine.view;

import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.medicine.dao.MedicineDao;
import com.medicine.dao.SupplierDao;
import com.medicine.dao.impl.MedicineDaoImpl;
import com.medicine.dao.impl.SupplierDaoImpl;
import com.medicine.pojo.Supplier;

import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SupplierCheck extends JInternalFrame {
	private JTextField textCheckSupplier;
	private JTextField textSid;
	private JTextField textSname;
	private JTextField textSphone;
	private JTextField textSaddress;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplierCheck frame = new SupplierCheck();
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
	public SupplierCheck() {
		setTitle("\u67E5\u8BE2\u4F9B\u5E94\u5546");
		setClosable(true);
		setBounds(100, 100, 739, 423);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 723, 394);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u4F9B\u5E94\u5546\u540D\u79F0");
		label.setBounds(167, 32, 72, 22);
		panel.add(label);
		
		textCheckSupplier = new JTextField();
		textCheckSupplier.setBounds(234, 33, 175, 21);
		panel.add(textCheckSupplier);
		textCheckSupplier.setColumns(10);
		
		//查询某个供应商
		JButton buttCheckSupplier = new JButton("\u67E5\u8BE2\u5BA2\u6237\u4FE1\u606F");
		buttCheckSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				SupplierDao supplierdao=new SupplierDaoImpl();
				String supName = textCheckSupplier.getText();
				Vector v=new Vector<>();
				v.add("供应商编号");
				v.add("供应商名称");
				v.add("供应商电话");
				v.add("供应商地址");
				if(supName != null && !("".equals(supName))){
					model.setDataVector(supplierdao.checkSupplier(supName), v);
				}else{
					model.setDataVector(supplierdao.getAllSupplier(), v);
					
				}
			}
		});
		buttCheckSupplier.setBounds(419, 27, 133, 32);
		panel.add(buttCheckSupplier);
		
		JLabel label_1 = new JLabel("\u4F9B\u5E94\u5546\u7F16\u53F7");
		label_1.setBounds(51, 262, 72, 22);
		panel.add(label_1);
		
		textSid = new JTextField();
		textSid.setEnabled(false);
		textSid.setBounds(126, 263, 90, 21);
		panel.add(textSid);
		textSid.setColumns(10);
		
		JLabel label_2 = new JLabel("\u4F9B\u5E94\u5546\u540D\u79F0");
		label_2.setBounds(254, 262, 72, 22);
		panel.add(label_2);
		
		textSname = new JTextField();
		textSname.setColumns(10);
		textSname.setBounds(336, 263, 90, 21);
		panel.add(textSname);
		
		JLabel label_3 = new JLabel("\u4F9B\u5E94\u5546\u7535\u8BDD");
		label_3.setBounds(458, 262, 72, 22);
		panel.add(label_3);
		
		textSphone = new JTextField();
		textSphone.setColumns(10);
		textSphone.setBounds(533, 263, 90, 21);
		panel.add(textSphone);
		
		JLabel label_4 = new JLabel("\u4F9B\u5E94\u5546\u5730\u5740");
		label_4.setBounds(51, 294, 72, 22);
		panel.add(label_4);
		
		textSaddress = new JTextField();
		textSaddress.setColumns(10);
		textSaddress.setBounds(126, 294, 497, 21);
		panel.add(textSaddress);
		
		//删除
		JButton buttDelSupplier = new JButton("\u5220\u9664\u5BA2\u6237\u4FE1\u606F");
		buttDelSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String str=textSid.getText();
				
				int i=JOptionPane.showConfirmDialog(null, "是否删除");
				if(i!=0){
					return ;
				}
				SupplierDao sd=new SupplierDaoImpl();
				
				Vector contentList = sd.connect(str);
				int a =	contentList.size();
				if(a!=0){
					JOptionPane.showMessageDialog(null, "有本公司的药品，无法进行删除");
					return;
				}else{
					int rows=sd.delSupplier(str);
					if(rows!=0){
						JOptionPane.showMessageDialog(null, "删除成功");
						DefaultTableModel model=(DefaultTableModel) table.getModel();
						Vector v=new Vector<>();
						v.add("供应商编号");
						v.add("供应商名称");
						v.add("供应商地址");
						v.add("供应商电话");
						
						model.setDataVector(sd.getAllSupplier(), v);
						
						textSid.setText("");
						textSname.setText("");
						textSaddress.setText("");
						textSphone.setText("");
					}
				}
			}
		});
		buttDelSupplier.setBounds(149, 335, 111, 32);
		panel.add(buttDelSupplier);
		
		//修改
		JButton buttChangeSupplier = new JButton("\u4FEE\u6539\u5BA2\u6237\u4FE1\u606F");
		buttChangeSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Supplier supplier=new Supplier();
				supplier.setSupplierid(textSid.getText());
				supplier.setSuppliername(textSname.getText());
				supplier.setPhone(textSphone.getText());
				supplier.setAddress(textSaddress.getText());
				
				SupplierDao sd=new SupplierDaoImpl();
				int rows=sd.chargeSupplier(supplier);
				
				if(rows!=0){
					JOptionPane.showMessageDialog(null, "修改成功");
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					Vector v=new Vector<>();
					v.add("供应商编号");
					v.add("供应商名称");
					v.add("供应商地址");
					v.add("供应商电话");
					
					model.setDataVector(sd.getAllSupplier(), v);
				}
			}
		});
		buttChangeSupplier.setBounds(385, 335, 111, 32);
		panel.add(buttChangeSupplier);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 69, 591, 183);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				String sSuppId=table.getValueAt(row, 0).toString();
				String sSuppName=table.getValueAt(row, 1).toString();
				String sSuppAddress=table.getValueAt(row, 2).toString();
				String sSuppPhone=table.getValueAt(row, 3).toString();
				
				textSid.setText(sSuppId);
				textSname.setText(sSuppName);
				textSaddress.setText(sSuppAddress);
				textSphone.setText(sSuppPhone);
			}
		});
		scrollPane.setViewportView(table);
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		SupplierDao supplierdao=new SupplierDaoImpl();
		
		Vector v=new Vector<>();
		v.add("供应商编号");
		v.add("供应商名称");
		v.add("供应商地址");
		v.add("供应商电话");
		
		model.setDataVector(supplierdao.getAllSupplier(), v);
		
	}

}
