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
import javax.swing.JTextField;

public class SignupView
  extends View
{
  private static final long serialVersionUID = 1L;
  private JTextField userID;
  private JTextField pwd;
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
  private JPanel panel_7;
  private JLabel lblConfirmPassword;
  private JTextField pwdConfirm;
  private JButton btnNewButton;
  
  public SignupView()
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
    this.panel_6.setLayout(new BoxLayout(this.panel_6, 0));
    
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
    
    this.lblUserId = new JLabel("Choose a user ID");
    this.panel_1.add(this.lblUserId);
    
    this.userID = new JTextField();
    this.panel_4.add(this.userID);
    this.userID.setColumns(10);
    
    this.panel_3 = new JPanel();
    this.panel_4.add(this.panel_3);
    FlowLayout flowLayout_1 = (FlowLayout)this.panel_3.getLayout();
    flowLayout_1.setVgap(0);
    flowLayout_1.setHgap(0);
    flowLayout_1.setAlignment(0);
    
    this.lblPassword = new JLabel("Choose a password");
    this.panel_3.add(this.lblPassword);
    
    this.pwd = new JTextField();
    this.panel_4.add(this.pwd);
    this.pwd.setColumns(10);
    
    this.panel_7 = new JPanel();
    FlowLayout flowLayout_2 = (FlowLayout)this.panel_7.getLayout();
    flowLayout_2.setAlignment(0);
    this.panel_4.add(this.panel_7);
    
    this.lblConfirmPassword = new JLabel("Conform your password");
    this.lblConfirmPassword.setHorizontalAlignment(2);
    this.panel_7.add(this.lblConfirmPassword);
    
    this.pwdConfirm = new JTextField();
    this.pwdConfirm.setColumns(10);
    this.panel_4.add(this.pwdConfirm);
    
    this.panel_2 = new JPanel();
    this.panel_4.add(this.panel_2);
    
    this.newAccButton = new JButton("Create my account");
    this.newAccButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        SignupView.this.getController().signup(SignupView.this.userID.getText(), SignupView.this.pwd.getText(), SignupView.this.pwdConfirm.getText());
      }
    });
    this.btnNewButton = new JButton("Back to login");
    this.btnNewButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        SignupView.this.getController().setView(new LoginView());
      }
    });
    this.panel_2.add(this.btnNewButton);
    this.panel_2.add(this.newAccButton);
    
    this.panel_4.setMaximumSize(new Dimension(300, 200));
  }
  
  public void initialize() {}
}
