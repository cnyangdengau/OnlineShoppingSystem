import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ProductThumbnail
  extends JPanel
{
  private static final long serialVersionUID = 1L;
  
  public ProductThumbnail(final ShopController c, final Product p)
  {
    setBorder(new EmptyBorder(10, 10, 10, 10));
    setLayout(new BoxLayout(this, 1));
    
    JPanel panel = new JPanel();
    add(panel);
    panel.setLayout(new BoxLayout(panel, 0));
    
    JLabel title = new JLabel(p.getName());
    panel.add(title);
    title.setFont(new Font("Lucida Grande", 0, 20));
    title.setHorizontalAlignment(0);
    
    JPanel panel_2 = new JPanel();
    panel_2.setBorder(new EmptyBorder(10, 10, 10, 10));
    add(panel_2);
    panel_2.setLayout(new BoxLayout(panel_2, 0));
    
    JLabel imgLabel = new JLabel();
    imgLabel.setIcon(p.getImage());
    panel_2.add(imgLabel);
    
    JPanel panel_1 = new JPanel();
    add(panel_1);
    panel_1.setLayout(new BoxLayout(panel_1, 0));
    
    JButton view = new JButton("View");
    panel_1.add(view);
    
    JButton addOne = new JButton("Add 1 to cart");
    panel_1.add(addOne);
    
    addOne.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        c.addToCart(p, 1.0F);
      }
    });
    view.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        ProductDetails.display(c, p);
      }
    });
  }
}
