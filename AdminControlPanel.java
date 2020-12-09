package assignment2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

/**************************************************************************************************************************************************
 * Java-based Mini Twitter with GUI using Java Swing. Pure desktop program, without web or mobile components. 
 * 
 * Basic functions of the system...
 * [] There is a centralized admin control panel to create "users" and "user groups"
 * [] A "user" has...
 *      [] unique ID
 *      [] list of user IDs that are following this "user" (followers).
 *      [] list of user IDs being followed by this "user" (followings).
 *      [] news feed list containing a list of Twitter messages.
 * [] a "user group" has...
 *      [] unique ID, which can be used to group users.
 *      [] a "user group" can contain any number of users. 
 *      [] the same "user" can only be included in one group. (no duplicate user twice added to one group?)
 *      [] can contain other "user group" within the "user group".
 *      [] There is always a root group called "Root", to include everything.
 * [] Users can choose to follow other users (not user groups) by providing the target user ID. (Unfollow is not required)
 * [] Users can also post a short Tweet message (String).
 *      [] Followers can see the Tweet in their news feed lists.
 *      [] the user can also see their own Tweet
 * [] A few analysis features are needed in the admin control panel...
 *      [] output the total number of users.
 *      [] output the total number of groups.
 *      [] output the total number of Tweets in all the users' news feed.
 *      [] output the percentage of positive Tweet messages in all the users' news feed. (message that contain "good", "great", "excellent", etc)
 **************************************************************************************************************************************************/

public class AdminControlPanel extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminControlPanel frame = new AdminControlPanel();
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
	public AdminControlPanel() {
		setResizable(false);
		setTitle("Admin Control Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 351);
		getContentPane().setLayout(null);
		
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("MiniTwitter") {
				{
					
				}
			}
		));
		tree.setBounds(10, 11, 147, 296);
		getContentPane().add(tree);
		
		JTextArea txtAreaUserID = new JTextArea();
		txtAreaUserID.setBounds(224, 11, 133, 22);
		getContentPane().add(txtAreaUserID);
		
		JTextArea txtrConsole = new JTextArea();
		txtrConsole.setLineWrap(true);
		txtrConsole.setBackground(Color.DARK_GRAY);
		txtrConsole.setForeground(Color.WHITE);
		txtrConsole.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrConsole.setText("Console...");
		txtrConsole.setEditable(false);
		txtrConsole.setBounds(167, 111, 330, 90);
		getContentPane().add(txtrConsole);
		
		JButton btnAddUser = new JButton("Add User");
		//Add User to jTree at selected Node
		//Does not allow adding to users
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultMutableTreeNode selected = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
				if(!selected.getAllowsChildren()) {
					txtrConsole.setText("Cannot Add to User, only to UserGroups or to Root 'MiniTwitter'...");
				}
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(txtAreaUserID.getText());
				newNode.setAllowsChildren(false);
				selected.add(newNode);
				DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
				model.reload();
			}
		});
		btnAddUser.setBounds(367, 12, 130, 23);
		getContentPane().add(btnAddUser);
		
		JTextArea txtAreaGroupID = new JTextArea();
		txtAreaGroupID.setBounds(224, 44, 133, 22);
		getContentPane().add(txtAreaGroupID);
		
		JButton btnAddGroup = new JButton("Add Group");
		//Add Group to JTree at selected Node
		//Does not allow adding to users
		btnAddGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultMutableTreeNode selected = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
				if(!selected.getAllowsChildren()) {
					txtrConsole.setText("Cannot Add to User, only to UserGroups...");
				}
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(txtAreaGroupID.getText());
				selected.add(newNode);
				DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
				model.reload();
			}
		});
		btnAddGroup.setBounds(367, 45, 130, 23);
		getContentPane().add(btnAddGroup);
		
		JButton btnOpenUserView = new JButton("Open User View");
		//Open User View
		//Bugged at the moment in that if you close user view it closes everything?
		btnOpenUserView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserView newUserView = new UserView();
				newUserView.setVisible(true);
			}
		});
		btnOpenUserView.setBounds(167, 77, 330, 23);
		getContentPane().add(btnOpenUserView);
		
		JButton btnShowUserTotal = new JButton("Show User Total");
		//Show User Total
		btnShowUserTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnShowUserTotal.setBounds(167, 212, 160, 25);
		getContentPane().add(btnShowUserTotal);
		
		JButton btnShowGroupTotal = new JButton("Show Group Total");
		//SHow Group Total
		btnShowGroupTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnShowGroupTotal.setBounds(337, 212, 160, 25);
		getContentPane().add(btnShowGroupTotal);
		
		JButton btnShowMessagesTotal = new JButton("Show Messages Total");
		//Show total messages
		btnShowMessagesTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnShowMessagesTotal.setBounds(167, 248, 160, 25);
		getContentPane().add(btnShowMessagesTotal);
		
		JButton btnShowPositivePercentage = new JButton("Show Positive Percentage");
		//Show positive message percentage
		btnShowPositivePercentage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnShowPositivePercentage.setBounds(337, 248, 160, 25);
		getContentPane().add(btnShowPositivePercentage);
		
		JLabel lblUserId = new JLabel("User ID: ");
		lblUserId.setBounds(167, 11, 47, 22);
		getContentPane().add(lblUserId);
		
		JLabel lblGroupId = new JLabel("Group ID:");
		lblGroupId.setBounds(167, 44, 47, 22);
		getContentPane().add(lblGroupId);
		
		JButton btnVerifyIds = new JButton("Verify IDs");
		//Verify no duplicate IDs are present in Tree
		btnVerifyIds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnVerifyIds.setBounds(167, 284, 160, 23);
		getContentPane().add(btnVerifyIds);
		
		JButton btnFindLastUpdated = new JButton("Find Last Updated User");
		btnFindLastUpdated.setBounds(336, 284, 158, 23);
		getContentPane().add(btnFindLastUpdated);
	}
}