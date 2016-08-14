import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView
  extends View
{
  private static final long serialVersionUID = 1L;
  private JTextField username;
  private JPasswordField password;
  private JButton loginButton;
  private JButton newAccButton;
  private JPanel panel_2;
  private JPanel panel_1;
  private JLabel lblUserId;
  private JPanel panel_3;
  private JLabel lblPassword;
  private JPanel panel_4;
  private JPanel panel_5;
  private JPanel panel_6;
  private JLabel lblNewLabel;
  private Component verticalStrut;
  
  public LoginView()
  {
    GridBagLayout gridBagLayout = new GridBagLayout();
    gridBagLayout.columnWidths = new int[] { 0, 0 };
    gridBagLayout.rowHeights = new int[] { 0, 0 };
    gridBagLayout.columnWeights = new double[] { 1.0D, Double.MIN_VALUE };
    gridBagLayout.rowWeights = new double[] { 1.0D, Double.MIN_VALUE };
    setLayout(gridBagLayout);
    
    JPanel panel = new JPanel();
    GridBagConstraints gbc_panel = new GridBagConstraints();
    add(panel, gbc_panel);
    panel.setLayout(new BoxLayout(panel, 1));
    
    this.panel_5 = new JPanel();
    panel.add(this.panel_5);
    this.panel_5.setLayout(new BoxLayout(this.panel_5, 1));
    
    this.panel_6 = new JPanel();
    this.panel_5.add(this.panel_6);
    
    this.lblNewLabel = new JLabel();
    
    this.panel_6.add(this.lblNewLabel);
    
    this.panel_4 = new JPanel();
    this.panel_5.add(this.panel_4);
    this.panel_4.setLayout(new BoxLayout(this.panel_4, 1));
    
    this.verticalStrut = Box.createVerticalStrut(20);
    this.panel_4.add(this.verticalStrut);
    
    this.panel_1 = new JPanel();
    this.panel_4.add(this.panel_1);
    FlowLayout flowLayout = (FlowLayout)this.panel_1.getLayout();
    flowLayout.setVgap(0);
    flowLayout.setHgap(0);
    flowLayout.setAlignment(0);
    
    this.lblUserId = new JLabel("User ID");
    this.panel_1.add(this.lblUserId);
    
    this.username = new JTextField();
    this.panel_4.add(this.username);
    this.username.setColumns(10);
    
    this.panel_3 = new JPanel();
    this.panel_4.add(this.panel_3);
    FlowLayout flowLayout_1 = (FlowLayout)this.panel_3.getLayout();
    flowLayout_1.setVgap(0);
    flowLayout_1.setHgap(0);
    flowLayout_1.setAlignment(0);
    
    this.lblPassword = new JLabel("Password");
    this.panel_3.add(this.lblPassword);
    
    this.password = new JPasswordField();
    this.panel_4.add(this.password);
    this.password.setColumns(10);
    
    this.panel_2 = new JPanel();
    this.panel_4.add(this.panel_2);
    
    this.newAccButton = new JButton("Create an account");
    this.panel_2.add(this.newAccButton);
    this.newAccButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        LoginView.this.getController().setView(new SignupView());
      }
    });
    this.loginButton = new JButton("Login");
    this.panel_2.add(this.loginButton);
    this.loginButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e) {}
    });
    this.panel_4.setMaximumSize(new Dimension(300, 200));
  }
  
  public void initialize()
  {
    this.loginButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        LoginView.this.getController().attemptLogin(LoginView.this.username.getText(), new String(LoginView.this.password.getPassword()));
      }
    });
  }
}
