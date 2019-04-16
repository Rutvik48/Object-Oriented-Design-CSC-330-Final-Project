package GroupProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;

public class GUI {

	public JFrame frame;
	public JLayeredPane layeredPane;
	public JPanel loginPage;
	public JPanel homePage;
	public JPanel gameModes;
	public JPanel categories;
	public JPanel questionPage;
	public JPanel lastPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void SwitchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 736, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 715, 410);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		homePage = new JPanel();
		layeredPane.add(homePage, "name_621564096548225");
		
		JButton gameStartBtn = new JButton("Click Here To Start!");
		gameStartBtn.setBounds(15, 270, 677, 77);
		
		gameStartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SwitchPanels(loginPage);
			}
		});
		
		JLabel welcomeLbl = new JLabel("Welcome to the Trivia Game");
		welcomeLbl.setBounds(15, 62, 677, 139);
		welcomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLbl.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 28));
		homePage.setLayout(null);
		homePage.add(gameStartBtn);
		homePage.add(welcomeLbl);
		
		loginPage = new JPanel();
		layeredPane.add(loginPage, "name_621564106331261");
		loginPage.setLayout(null);
		
		JLabel loginOptionslbl = new JLabel("Select login if you have have user ID alredy, select Create ID otherwise.");
		loginOptionslbl.setHorizontalAlignment(SwingConstants.CENTER);
		loginOptionslbl.setBounds(15, 311, 677, 20);
		loginPage.add(loginOptionslbl);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchPanels(gameModes);
			}
		});
		loginBtn.setBounds(291, 39, 115, 29);
		loginPage.add(loginBtn);
		
		JButton createIDbtn = new JButton("Create ID");
		createIDbtn.setBounds(291, 103, 115, 29);
		loginPage.add(createIDbtn);
		
		gameModes = new JPanel();
		layeredPane.add(gameModes, "name_621564117979256");
		gameModes.setLayout(null);
		
		JLabel lblUserWillSelect = new JLabel("USER WILL SELECT HOW HOW THEY WANT TO PLAY THE GAME");
		lblUserWillSelect.setBounds(15, 311, 677, 20);
		lblUserWillSelect.setHorizontalAlignment(SwingConstants.CENTER);
		gameModes.add(lblUserWillSelect);
		
		JButton btnRandomQuestions = new JButton("Random Questions");
		btnRandomQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchPanels(questionPage);
			}
		});
		btnRandomQuestions.setBounds(270, 58, 173, 29);
		gameModes.add(btnRandomQuestions);
		
		JButton btnSelectCategory = new JButton("Select Category");
		btnSelectCategory.setBounds(270, 129, 173, 29);
		gameModes.add(btnSelectCategory);
		
		categories = new JPanel();
		layeredPane.add(categories, "name_621631229203528");
		categories.setLayout(null);
		
		JButton btnArt = new JButton("Art");
		btnArt.setBounds(0, 0, 257, 29);
		categories.add(btnArt);
		
		JLabel lblArtWillBe = new JLabel("ART WILL BE SELECTED");
		lblArtWillBe.setBounds(317, 4, 175, 20);
		categories.add(lblArtWillBe);
		
		JButton btnEntertainment = new JButton("Entertainment");
		btnEntertainment.setBounds(0, 34, 257, 29);
		categories.add(btnEntertainment);
		
		JButton btnNewButton = new JButton("General Knowledge");
		btnNewButton.setBounds(88, 68, 169, 29);
		categories.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Computer Science");
		btnNewButton_1.setBounds(49, 102, 159, 29);
		categories.add(btnNewButton_1);
		
		JLabel lblCategoriesHere = new JLabel(" CATEGORIES HERE");
		lblCategoriesHere.setBounds(55, 178, 146, 20);
		lblCategoriesHere.setHorizontalAlignment(SwingConstants.CENTER);
		categories.add(lblCategoriesHere);
		
		JLabel lblThereWillBe = new JLabel("THERE WILL BE MORE");
		lblThereWillBe.setBounds(0, 136, 257, 62);
		lblThereWillBe.setHorizontalAlignment(SwingConstants.CENTER);
		categories.add(lblThereWillBe);
		
		JLabel lblUserWillSelect_1 = new JLabel("USER WILL SELECT ONE OF THE LISTED CATEGORY ");
		lblUserWillSelect_1.setBounds(0, 238, 677, 20);
		lblUserWillSelect_1.setHorizontalAlignment(SwingConstants.CENTER);
		categories.add(lblUserWillSelect_1);
		
		questionPage = new JPanel();
		layeredPane.add(questionPage, "name_621564126469066");
		questionPage.setLayout(null);
		
		JLabel lblCategoryArt = new JLabel("Category: ART");
		lblCategoryArt.setFont(new Font("Kristen ITC", Font.ITALIC, 18));
		lblCategoryArt.setBounds(15, 16, 224, 39);
		questionPage.add(lblCategoryArt);
		
		JLabel lblWhoIsCredited = new JLabel("Who is credited as the designer of the many statues which decorated the Parthenon?");
		lblWhoIsCredited.setBounds(25, 71, 667, 61);
		questionPage.add(lblWhoIsCredited);
		
		JButton btnHesiod = new JButton("Hesiod");
		btnHesiod.setBounds(15, 148, 115, 29);
		questionPage.add(btnHesiod);
		
		JButton btnPraxiteles = new JButton("Praxiteles");
		btnPraxiteles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchPanels(lastPage);
			}
		});
		btnPraxiteles.setBounds(15, 193, 115, 29);
		questionPage.add(btnPraxiteles);
		
		JButton btnPhidias = new JButton("Phidias");
		btnPhidias.setBounds(152, 148, 115, 29);
		questionPage.add(btnPhidias);
		
		JButton btnScopas = new JButton("Scopas");
		btnScopas.setBounds(152, 193, 115, 29);
		questionPage.add(btnScopas);
		
		JLabel lblSlectOneOf = new JLabel("USER CAN SELECT ONE OF FOUR ANSWER. RIGHT ANSWER:  Praxiteles");
		lblSlectOneOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlectOneOf.setBounds(25, 311, 667, 20);
		questionPage.add(lblSlectOneOf);
		
		lastPage = new JPanel();
		layeredPane.add(lastPage, "name_623940784186118");
		lastPage.setLayout(null);
		
		JLabel lblRightAnswer = new JLabel("Right Answer!!");
		lblRightAnswer.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblRightAnswer.setBounds(37, 38, 259, 63);
		lastPage.add(lblRightAnswer);
		
		JLabel lblCurrentPoints = new JLabel("Current Points: ##");
		lblCurrentPoints.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCurrentPoints.setBounds(37, 117, 259, 63);
		lastPage.add(lblCurrentPoints);
		
		JButton btnBackToHome = new JButton("Back To Home Page");
		btnBackToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchPanels(homePage);
			}
		});
		btnBackToHome.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnBackToHome.setBounds(155, 269, 398, 90);
		lastPage.add(btnBackToHome);
	}
}
