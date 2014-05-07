package gui;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;

import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.util.Arrays;

import javax.swing.JButton;

import model.*;
import database.SymptomsDatabase;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;

import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Toolkit;

public class MainForm {

	private JFrame frmRabbitmdRabbit;
	private SymptomsDatabase database;
	private JList listEars;
	private JList listEyes;
	private JList listSkin;
	private JList listTeeth;
	private JList listBody;
	private JList listNose;
	private JList listExcretion;
	private JList listBehavior;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						SymptomsDatabase database = new SymptomsDatabase();
						MainForm window = new MainForm(database);
						window.frmRabbitmdRabbit.setVisible(true);
					} catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(null,"Database file not found.");
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			});

	}

	/**
	 * Create the application.
	 */
	public MainForm(SymptomsDatabase db) {
		this.database =db;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRabbitmdRabbit = new JFrame();
		frmRabbitmdRabbit.setIconImage(Toolkit.getDefaultToolkit().getImage(MainForm.class.getResource("/resources/1399450936_easterBunnyRSSEGG.png")));
		frmRabbitmdRabbit.setTitle("RabbitMD -- Rabbit Disease Diagnosis");
		frmRabbitmdRabbit.setBounds(100, 100, 1200, 750);
		frmRabbitmdRabbit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Symptoms", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel label = new JLabel("Select one or more symptoms from the different categories.");
		GroupLayout groupLayout = new GroupLayout(frmRabbitmdRabbit.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1154, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1154, Short.MAX_VALUE))
					.addGap(20))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(781, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(7))
		);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EmptyBorder(0, 0, 0, 0), "Ears", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EmptyBorder(0, 0, 0, 0), "Eyes", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 267, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 251, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		listEyes = new JList();
		scrollPane_1.setViewportView(listEyes);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new EmptyBorder(0, 0, 0, 0), "Body", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 267, Short.MAX_VALUE)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 251, Short.MAX_VALUE)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		listBody = new JList();
		scrollPane_2.setViewportView(listBody);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new EmptyBorder(0, 0, 0, 0), "Behavior", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 267, Short.MAX_VALUE)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 251, Short.MAX_VALUE)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		listBehavior = new JList();
		scrollPane_3.setViewportView(listBehavior);
		panel_5.setLayout(gl_panel_5);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(new EmptyBorder(0, 0, 0, 0), "Teeth", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane_5 = new JScrollPane();
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGap(0, 267, Short.MAX_VALUE)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_5, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGap(0, 251, Short.MAX_VALUE)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addComponent(scrollPane_5, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		listTeeth = new JList();
		scrollPane_5.setViewportView(listTeeth);
		panel_7.setLayout(gl_panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(new EmptyBorder(0, 0, 0, 0), "Nose", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane_6 = new JScrollPane();
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGap(0, 267, Short.MAX_VALUE)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_6, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGap(0, 251, Short.MAX_VALUE)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addComponent(scrollPane_6, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		listNose = new JList();
		scrollPane_6.setViewportView(listNose);
		panel_8.setLayout(gl_panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(new EmptyBorder(0, 0, 0, 0), "Excretion", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane_7 = new JScrollPane();
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGap(0, 267, Short.MAX_VALUE)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_7, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_9.setVerticalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGap(0, 251, Short.MAX_VALUE)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addComponent(scrollPane_7, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		listExcretion = new JList();
		scrollPane_7.setViewportView(listExcretion);
		panel_9.setLayout(gl_panel_9);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		listEars = new JList();
		scrollPane.setViewportView(listEars);
		panel_2.setLayout(gl_panel_2);
		
		JButton btnDiagnose = new JButton("Diagnose!");
		btnDiagnose.addActionListener(new DiagnoseBtnActionListener(this));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmRabbitmdRabbit.dispose();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(289)
					.addComponent(btnDiagnose, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
					.addGap(328))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDiagnose, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
					.addGap(22))
		);
		panel_1.setLayout(gl_panel_1);
		frmRabbitmdRabbit.getContentPane().setLayout(groupLayout);
		
		listEars.setListData(database.getEars().toArray());
		listBehavior.setListData(database.getBehavior().toArray());
		listBody.setListData(database.getBody().toArray());
		listExcretion.setListData(database.getExcrete().toArray());
		listEyes.setListData(database.getEyes().toArray());
		listNose.setListData(database.getNose().toArray());
		listTeeth.setListData(database.getTeeth().toArray());
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		panel.add(panel_2);
		panel.add(panel_3);
		panel.add(panel_4);
		panel.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(new EmptyBorder(0, 0, 0, 0), "Skin", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane_4 = new JScrollPane();
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGap(0, 267, Short.MAX_VALUE)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGap(0, 251, Short.MAX_VALUE)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		listSkin = new JList();
		scrollPane_4.setViewportView(listSkin);
		panel_6.setLayout(gl_panel_6);
		listSkin.setListData(database.getSkin().toArray());
		panel.add(panel_6);
		panel.add(panel_7);
		panel.add(panel_8);
		panel.add(panel_9);
	}

	public SymptomsDatabase getDatabase() {
		return database;
	}

	public void setDatabase(SymptomsDatabase database) {
		this.database = database;
	}
	public JList getListEars() {
		return listEars;
	}
	public JList getListEyes() {
		return listEyes;
	}
	public JList getListSkin() {
		return listSkin;
	}
	public JList getListTeeth() {
		return listTeeth;
	}
	public JList getListBody() {
		return listBody;
	}
	public JList getListNose() {
		return listNose;
	}
	public JList getListExcretion() {
		return listExcretion;
	}
	public JList getListBehavior() {
		return listBehavior;
	}
}
