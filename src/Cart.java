import java.util.ArrayList;
import java.util.List;

public class Cart
{
  private ArrayList<CartItem> items = new ArrayList();
  
  public void add(Product p, float quantity)
  {
    for (CartItem ci : this.items) {
      if (ci.product.equals(p))
      {
        ci.quantity += quantity;
        return;
      }
    }
    add(new CartItem(p, quantity));
  }
  
  public void add(CartItem item)
  {
    this.items.add(item);
  }
  
  public List<CartItem> getList()
  {
    return this.items;
  }
  
  public void clear()
  {
    this.items.clear();
  }
  
  public void setItems(ArrayList<CartItem> items)
  {
    this.items = items;
  }
  
  public void remove(CartItem item)
  {
    this.items.remove(item);
  }
}
