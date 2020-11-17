package assignment2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;

public class UserView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserView frame = new UserView();
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
	public UserView() {
		setResizable(false);
		setTitle("User View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 418, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrUserId = new JTextArea();
		txtrUserId.setText("User ID");
		txtrUserId.setBounds(10, 11, 100, 22);
		contentPane.add(txtrUserId);
		
		JButton btnFollowUser = new JButton("Follow User");
		btnFollowUser.setBounds(120, 12, 89, 23);
		contentPane.add(btnFollowUser);
		
		JList list_Following = new JList();
		list_Following.setToolTipText("Following");
		list_Following.setBounds(10, 44, 199, 86);
		contentPane.add(list_Following);
		
		JTextArea txtrTweetMessage = new JTextArea();
		txtrTweetMessage.setText("Tweet Message");
		txtrTweetMessage.setBounds(10, 154, 199, 66);
		contentPane.add(txtrTweetMessage);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 141, 199, 2);
		contentPane.add(separator);
		
		JButton btnPostTweet = new JButton("Post Tweet");
		btnPostTweet.setBounds(10, 231, 199, 23);
		contentPane.add(btnPostTweet);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(219, 11, 1, 242);
		contentPane.add(separator_1);
		
		JList list_NewsFeed = new JList();
		list_NewsFeed.setBounds(230, 43, 170, 210);
		contentPane.add(list_NewsFeed);
		
		JLabel lblNewsFeed = new JLabel("News Feed");
		lblNewsFeed.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewsFeed.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewsFeed.setBounds(230, 16, 170, 14);
		contentPane.add(lblNewsFeed);
	}
}
