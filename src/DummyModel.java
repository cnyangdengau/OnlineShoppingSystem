import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DummyModel
  implements Model
{
  ArrayList<Product> productList = new ArrayList<Product>();
  HashMap<String, String> passwords = new HashMap<String, String>();
  HashMap<String, Customer> details = new HashMap<String, Customer>();
  
  public DummyModel()
  {
    this.passwords.put("admin", "admin");
    this.details.put("admin", new Customer("john", "900 dandenong rd", "123", "456"));
    for (int i = 0; i < 3; i++)
    {
      Product birb = new Product("Item #" + i);
      birb.setProperty("price", "Price ($)", Float.valueOf(100.0F));
      this.productList.add(birb);
    }
  }
  
  public List<Product> getProducts()
  {
    return this.productList;
  }
  
  public boolean login(String username, String password)
  {
    if (this.passwords.containsKey(username)) {
      return ((String)this.passwords.get(username)).equals(password);
    }
    return false;
  }
  
  public boolean signup(String username, String password)
  {
    if (this.passwords.containsKey(username)) {
      return false;
    }
    this.passwords.put(username, password);
    this.details.put(username, new Customer(username, "", "", ""));
    return true;
  }
  
  public Customer getUserInfo(String username)
  {
    return (Customer)this.details.get(username);
  }
  
  public boolean setUserInfo(String username, Customer info)
  {
    this.details.put(username, info);
    return true;
  }
  
  public float getPrice(Cart cart)
  {
    float total = 0.0F;
    for (CartItem item : cart.getList()) {
      if (item.product.hasProperty("price")) {
        total += ((Float)item.product.getPropertyValue("price")).floatValue() * item.quantity;
      }
    }
    return total;
  }
  
  public boolean processOrder(String currentUserID, Cart cart)
  {
    return true;
  }
}
