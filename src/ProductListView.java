import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ProductListView
  extends View
{
  private static final long serialVersionUID = 1L;
  private JPanel scrollPanel;
  
  public ProductListView()
  {
    setLayout(new BorderLayout(0, 0));
    
    JPanel panel = new JPanel();
    FlowLayout flowLayout = (FlowLayout)panel.getLayout();
    flowLayout.setAlignment(2);
    add(panel, "North");
    
    JButton myInfoButton = new JButton("My account");
    panel.add(myInfoButton);
    
    myInfoButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        UserDetails.display(ProductListView.this.getController());
      }
    });
    JButton cartButton = new JButton("View cart");
    
    cartButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        ProductListView.this.getController().showCartView();
      }
    });
    panel.add(cartButton);
    
    this.scrollPanel = new JPanel();
    JScrollPane scroll = new JScrollPane(this.scrollPanel);
    this.scrollPanel.setLayout(new GridLayout(0, 3, 0, 0));
    scroll.setVerticalScrollBarPolicy(22);
    scroll.setHorizontalScrollBarPolicy(31);
    
    add(scroll, "Center");
  }
  
  public void initialize()
  {
    this.scrollPanel.removeAll();
    List<Product> list = getController().getBackend().getProducts();
    for (Product p : list) {
      this.scrollPanel.add(new ProductThumbnail(getController(), p));
    }
    revalidate();
  }
}
