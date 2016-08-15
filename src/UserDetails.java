import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UserDetails extends JDialog
{
  private static final long serialVersionUID = 1L;
  private final JPanel contentPanel = new JPanel();
  private JTextField fullName;
  private JTextField phoneNumber;
  private JTextField homeAddr;
  private JTextField cardNum;
  
  public static void display(ShopController c)
  {
    UserDetails dialog = new UserDetails(c);
    dialog.setDefaultCloseOperation(2);
    dialog.setLocationRelativeTo(c.getWindow());
    dialog.setVisible(true);
  }
  
  public Customer toCustomer()
  {
    return new Customer(this.fullName.getText(), this.homeAddr.getText(), this.cardNum.getText(), this.phoneNumber.getText(),null);
  }
  
  public UserDetails(final ShopController c)
  {
    Customer user = c.getCurrentCustomerDetails();
    
    setTitle("User Information");
    setBounds(100, 100, 450, 300);
    
    getContentPane().setLayout(new BorderLayout());
    this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(this.contentPanel, "Center");
    GridBagLayout gbl_contentPanel = new GridBagLayout();
    gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
    gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
    gbl_contentPanel.columnWeights = new double[] { 0.0D, 0.0D, 1.0D, 1.0D, Double.MIN_VALUE };
    gbl_contentPanel.rowWeights = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, Double.MIN_VALUE };
    this.contentPanel.setLayout(gbl_contentPanel);
    
    JLabel lblFullName = new JLabel("Full name:");
    lblFullName.setHorizontalAlignment(2);
    GridBagConstraints gbc_lblFullName = new GridBagConstraints();
    gbc_lblFullName.insets = new Insets(0, 0, 5, 5);
    gbc_lblFullName.gridx = 1;
    gbc_lblFullName.gridy = 1;
    this.contentPanel.add(lblFullName, gbc_lblFullName);
    
    this.fullName = new JTextField();
    GridBagConstraints gbc_fullName = new GridBagConstraints();
    gbc_fullName.insets = new Insets(0, 0, 5, 5);
    gbc_fullName.fill = 2;
    gbc_fullName.gridx = 2;
    gbc_fullName.gridy = 1;
    this.contentPanel.add(this.fullName, gbc_fullName);
    this.fullName.setColumns(10);
    this.fullName.setText(user.name);
    
    JLabel lblPhoneNumber = new JLabel("Phone number:");
    GridBagConstraints gbc_lblPhoneNumber = new GridBagConstraints();
    gbc_lblPhoneNumber.anchor = 13;
    gbc_lblPhoneNumber.insets = new Insets(0, 0, 5, 5);
    gbc_lblPhoneNumber.gridx = 1;
    gbc_lblPhoneNumber.gridy = 2;
    this.contentPanel.add(lblPhoneNumber, gbc_lblPhoneNumber);
    
    this.phoneNumber = new JTextField();
    GridBagConstraints gbc_phoneNumber = new GridBagConstraints();
    gbc_phoneNumber.insets = new Insets(0, 0, 5, 5);
    gbc_phoneNumber.fill = 2;
    gbc_phoneNumber.gridx = 2;
    gbc_phoneNumber.gridy = 2;
    this.contentPanel.add(this.phoneNumber, gbc_phoneNumber);
    this.phoneNumber.setColumns(10);
    this.phoneNumber.setText(user.phoneNumber);
    
    JLabel lblHomeAddress = new JLabel("Home address:");
    lblHomeAddress.setHorizontalAlignment(2);
    GridBagConstraints gbc_lblHomeAddress = new GridBagConstraints();
    gbc_lblHomeAddress.anchor = 13;
    gbc_lblHomeAddress.insets = new Insets(0, 0, 5, 5);
    gbc_lblHomeAddress.gridx = 1;
    gbc_lblHomeAddress.gridy = 3;
    this.contentPanel.add(lblHomeAddress, gbc_lblHomeAddress);
    
    this.homeAddr = new JTextField();
    GridBagConstraints gbc_homeAddr = new GridBagConstraints();
    gbc_homeAddr.insets = new Insets(0, 0, 5, 5);
    gbc_homeAddr.fill = 2;
    gbc_homeAddr.gridx = 2;
    gbc_homeAddr.gridy = 3;
    this.contentPanel.add(this.homeAddr, gbc_homeAddr);
    this.homeAddr.setColumns(10);
    this.homeAddr.setText(user.address);
    
    JLabel lblCardNumber = new JLabel("Card number:");
    GridBagConstraints gbc_lblCardNumber = new GridBagConstraints();
    gbc_lblCardNumber.anchor = 13;
    gbc_lblCardNumber.insets = new Insets(0, 0, 0, 5);
    gbc_lblCardNumber.gridx = 1;
    gbc_lblCardNumber.gridy = 4;
    this.contentPanel.add(lblCardNumber, gbc_lblCardNumber);
    
    this.cardNum = new JTextField();
    GridBagConstraints gbc_cardNum = new GridBagConstraints();
    gbc_cardNum.insets = new Insets(0, 0, 0, 5);
    gbc_cardNum.fill = 2;
    gbc_cardNum.gridx = 2;
    gbc_cardNum.gridy = 4;
    this.contentPanel.add(this.cardNum, gbc_cardNum);
    this.cardNum.setColumns(10);
    this.cardNum.setText(user.cardNumber);
    
    JPanel buttonPane = new JPanel();
    buttonPane.setLayout(new FlowLayout(2));
    getContentPane().add(buttonPane, "South");
    
    final JDialog me = this;
    JButton okButton = new JButton("Save");
    okButton.setActionCommand("OK");
    okButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        c.updateUserDetails(UserDetails.this.toCustomer());
        me.dispose();
      }
    });
    buttonPane.add(okButton);
    getRootPane().setDefaultButton(okButton);
    
    final JDialog me1 = this;
    JButton cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        me1.dispose();
      }
    });
    cancelButton.setActionCommand("Cancel");
    buttonPane.add(cancelButton);
  }
}
