import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

public class ProductDetails
  extends JDialog
{
  private static final long serialVersionUID = 1L;
  private final JPanel contentPanel = new JPanel();
  JSpinner spinner;
  
  public static void display(ShopController c, Product p)
  {
    ProductDetails dialog = new ProductDetails(c, p);
    dialog.setDefaultCloseOperation(2);
    dialog.setLocationRelativeTo(c.getWindow());
    dialog.setVisible(true);
  }
  
  public ProductDetails(final ShopController c, final Product p)
  {
    setBounds(100, 100, 450, 300);
    getContentPane().setLayout(new BorderLayout());
    this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(this.contentPanel, "North");
    this.contentPanel.setLayout(new BoxLayout(this.contentPanel, 0));
    
    JPanel panel = new JPanel();
    panel.setBorder(new EmptyBorder(10, 10, 10, 10));
    this.contentPanel.add(panel);
    panel.setLayout(new BoxLayout(panel, 0));
    
    JLabel lblNewLabel_3 = new JLabel();
    lblNewLabel_3.setIcon(p.getImage());
    panel.add(lblNewLabel_3);
    
    JPanel panel1 = new JPanel();
    this.contentPanel.add(panel1);
    panel1.setLayout(new BoxLayout(panel1, 1));
    
    JPanel panel_1 = new JPanel();
    panel1.add(panel_1);
    panel_1.setBorder(null);
    FlowLayout fl_panel_1 = (FlowLayout)panel_1.getLayout();
    fl_panel_1.setAlignment(0);
    
    JLabel lblNewLabel_1 = new JLabel(p.getName());
    panel_1.add(lblNewLabel_1);
    lblNewLabel_1.setHorizontalAlignment(2);
    lblNewLabel_1.setFont(new Font("Lucida Grande", 0, 20));
    
    JPanel panel_11 = new JPanel();
    panel1.add(panel_11);
    FlowLayout fl_panel_11 = (FlowLayout)panel_11.getLayout();
    fl_panel_11.setAlignment(0);
    panel_11.setBorder(new EmptyBorder(10, 10, 10, 10));
    
    JLabel lblNewLabel_2 = new JLabel(p.getPropertiesAsText());
    panel_11.add(lblNewLabel_2);
    
    JPanel buttonPane = new JPanel();
    buttonPane.setLayout(new FlowLayout(2));
    getContentPane().add(buttonPane, "South");
    
    JLabel lblNewLabel = new JLabel("Quantity:");
    buttonPane.add(lblNewLabel);
    
    this.spinner = new JSpinner();
    this.spinner.setModel(new SpinnerNumberModel(1, 0, 100000, 1));
    this.spinner.setPreferredSize(new Dimension(100, 30));
    buttonPane.add(this.spinner);
    
    final JDialog me = this;
    JButton okButton = new JButton("Add to cart");
    okButton.setActionCommand("OK");
    buttonPane.add(okButton);
    okButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        c.addToCart(p, Float.parseFloat(ProductDetails.this.spinner.getValue() + ""));
        me.dispose();
      }
    });
    getRootPane().setDefaultButton(okButton);
    
    final JDialog me1 = this;
    JButton cancelButton = new JButton("Cancel");
    cancelButton.setActionCommand("Cancel");
    cancelButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        me1.dispose();
      }
    });
    buttonPane.add(cancelButton);
  }
}
