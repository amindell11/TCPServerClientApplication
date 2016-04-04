/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;

import net.Config;
import net.ConnectionUtil;

/**
 *
 * @author ari
 */
public class ServerSelect extends ComponentPanel {

	/**
	 * Creates new form ServerSelect
	 */
	public ServerSelect(ApplicationManager frame) {
		super(frame);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	protected void initComponents() {

		jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jList1 = new javax.swing.JList<>();
		jButton1 = new javax.swing.JButton();

		jRadioButtonMenuItem1.setSelected(true);
		jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		jLabel1.setText("Server Select");
		ArrayList<String> strings = new ArrayList<>();
		new Thread(new Runnable() {

			@Override
			public void run() {
				HashMap<String, String> openServers = ConnectionUtil.getOpenServers(Config.PORT);
				strings.addAll(openServers.values());
				frame.repaint();
			}

		}).start();
		jList1.setModel(new javax.swing.AbstractListModel<String>() {

			public int getSize() {
				return strings.size();
			}

			public String getElementAt(int i) {
				return strings.get(i);
			}
		});
		jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jList1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		DefaultListCellRenderer renderer = (DefaultListCellRenderer) jList1.getCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
		jScrollPane1.setViewportView(jList1);

		jButton1.setText("Select");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(121, 121, 121)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jScrollPane1).addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addContainerGap(122, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(18, 18, 18)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18).addComponent(jButton1).addContainerGap(71, Short.MAX_VALUE)));
	}

	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JList<String> jList1;
	private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
	private javax.swing.JScrollPane jScrollPane1;
	// End of variables declaration
}
