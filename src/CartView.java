import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

public class CartView extends View
{
  private static final long serialVersionUID = 1L;
  private JPanel scrollPanel;
  private JButton btnClear;
  private JButton btnCheckout;
  private JLabel lblNetTotal;
  
  public CartView()
  {
    setLayout(new BorderLayout(0, 0));
    
    JPanel panel = new JPanel();
    panel.setBorder(new EmptyBorder(5, 5, 5, 5));
    add(panel, "North");
    
    JButton btnBack = new JButton("Back to products");
    btnBack.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        CartView.this.getController().showProductList();
      }
    });
    panel.setLayout(new BoxLayout(panel, 0));
    panel.add(btnBack);
    
    this.btnClear = new JButton("Remove all from cart");
    panel.add(this.btnClear);
    
    Component horizontalGlue = Box.createHorizontalGlue();
    panel.add(horizontalGlue);
    
    JLabel lblTotal = new JLabel("Total:");
    panel.add(lblTotal);
    
    this.lblNetTotal = new JLabel();
    panel.add(this.lblNetTotal);
    
    this.btnCheckout = new JButton("Checkout");
    panel.add(this.btnCheckout);
    
    this.scrollPanel = new JPanel();
    JScrollPane scroll = new JScrollPane(this.scrollPanel);
    this.scrollPanel.setLayout(new BoxLayout(this.scrollPanel, 1));
    
    scroll.setVerticalScrollBarPolicy(22);
    scroll.setHorizontalScrollBarPolicy(31);
    
    add(scroll, "Center");
  }
  
  public void initialize()
  {
    this.scrollPanel.removeAll();
    for (final CartItem item : getController().getCart().getList())
    {
      JPanel itemPanel = new JPanel();
      itemPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
      itemPanel.setAlignmentX(0.0F);
      itemPanel.setLayout(new BoxLayout(itemPanel, 1));
      JPanel titlePanel = new JPanel();
      itemPanel.add(titlePanel);
      titlePanel.setLayout(new BoxLayout(titlePanel, 0));
      JLabel lblNewLabel_3 = new JLabel(item.product.getName());
      lblNewLabel_3.setFont(new Font("Lucida Grande", 0, 20));
      titlePanel.add(lblNewLabel_3);
      Component horizontalGlue_1 = Box.createHorizontalGlue();
      titlePanel.add(horizontalGlue_1);
      JPanel propertiesPanel = new JPanel();
      itemPanel.add(propertiesPanel);
      propertiesPanel.setLayout(new BoxLayout(propertiesPanel, 0));
      JPanel quantityPanel = new JPanel();
      propertiesPanel.add(quantityPanel);
      quantityPanel.setLayout(new BoxLayout(quantityPanel, 0));
      JLabel lblQuantuty = new JLabel("Quantity: ");
      quantityPanel.add(lblQuantuty);
      JLabel lblNewLabel_1 = new JLabel(item.quantity + "");
      quantityPanel.add(lblNewLabel_1);
      JLabel spacer_1 = new JLabel("          ");
      quantityPanel.add(spacer_1);
      JLabel lblNewLabel = new JLabel("Price ($):   ");
      quantityPanel.add(lblNewLabel);
      
      Cart thisItemInACart = new Cart();
      thisItemInACart.add(item);
      JLabel lblNewLabel_2 = new JLabel("$" + getController().getBackend().getPrice(thisItemInACart));
      
      quantityPanel.add(lblNewLabel_2);
      JLabel label = new JLabel("          ");
      quantityPanel.add(label);
      
      JButton btnRemove = new JButton("Remove");
      btnRemove.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          CartView.this.getController().getCart().remove(item);
          CartView.this.getController().showCartView();
        }
      });
      propertiesPanel.add(btnRemove);
      
      Component horizontalGlue = Box.createHorizontalGlue();
      propertiesPanel.add(horizontalGlue);
      JSeparator separator = new JSeparator();
      itemPanel.add(separator);
      this.scrollPanel.add(itemPanel);
    }
    this.btnClear.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        CartView.this.getController().getCart().setItems(new ArrayList());
        CartView.this.getController().showCartView();
      }
    });
    this.btnCheckout.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        CartView.this.getController().showCheckout();
      }
    });
    this.lblNetTotal.setText("$" + getController().getTotalCartPrice());
    
    Component verticalGlue = Box.createVerticalGlue();
    this.scrollPanel.add(verticalGlue);
  }
}
