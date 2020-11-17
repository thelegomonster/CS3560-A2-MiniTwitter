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
		setBounds(100, 100, 520, 312);
		getContentPane().setLayout(null);
		
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("MiniTwitter") {
				{
					DefaultMutableTreeNode node_1;
					add(new DefaultMutableTreeNode("Andrew"));
					add(new DefaultMutableTreeNode("Blue"));
					node_1 = new DefaultMutableTreeNode("Dog Lovers");
						node_1.add(new DefaultMutableTreeNode("Phil"));
						node_1.add(new DefaultMutableTreeNode("Bob"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Food");
						node_1.add(new DefaultMutableTreeNode("Spaghetti"));
						node_1.add(new DefaultMutableTreeNode("Cilantro"));
						node_1.add(new DefaultMutableTreeNode("Ravioli"));
					add(node_1);
					add(new DefaultMutableTreeNode("Harrison"));
					add(new DefaultMutableTreeNode("Kyle"));
				}
			}
		));
		tree.setBounds(10, 11, 147, 262);
		getContentPane().add(tree);
		
		JTextArea txtAreaUserID = new JTextArea();
		txtAreaUserID.setText("User ID");
		txtAreaUserID.setBounds(167, 11, 160, 22);
		getContentPane().add(txtAreaUserID);
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.setBounds(337, 12, 160, 23);
		getContentPane().add(btnAddUser);
		
		JTextArea txtAreaGroupID = new JTextArea();
		txtAreaGroupID.setText("Group ID");
		txtAreaGroupID.setBounds(167, 44, 160, 22);
		getContentPane().add(txtAreaGroupID);
		
		JButton btnAddGroup = new JButton("Add Group");
		btnAddGroup.setBounds(337, 45, 160, 23);
		getContentPane().add(btnAddGroup);
		
		JButton btnOpenUserView = new JButton("Open User View");
		btnOpenUserView.setBounds(167, 77, 330, 23);
		getContentPane().add(btnOpenUserView);
		
		JTextArea txtrConsole = new JTextArea();
		txtrConsole.setBackground(Color.DARK_GRAY);
		txtrConsole.setForeground(Color.WHITE);
		txtrConsole.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrConsole.setText("Console...");
		txtrConsole.setEditable(false);
		txtrConsole.setBounds(167, 111, 330, 90);
		getContentPane().add(txtrConsole);
		
		JButton btnShowUserTotal = new JButton("Show User Total");
		btnShowUserTotal.setBounds(167, 212, 160, 25);
		getContentPane().add(btnShowUserTotal);
		
		JButton btnShowGroupTotal = new JButton("Show Group Total");
		btnShowGroupTotal.setBounds(337, 212, 160, 25);
		getContentPane().add(btnShowGroupTotal);
		
		JButton btnShowMessagesTotal = new JButton("Show Messages Total");
		btnShowMessagesTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnShowMessagesTotal.setBounds(167, 248, 160, 25);
		getContentPane().add(btnShowMessagesTotal);
		
		JButton btnShowPositivePercentage = new JButton("Show Positive Percentage");
		btnShowPositivePercentage.setBounds(337, 248, 160, 25);
		getContentPane().add(btnShowPositivePercentage);
	}
}