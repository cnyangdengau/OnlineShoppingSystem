import java.util.List;

public abstract interface Model
{
  public abstract List<Product> getProducts();
  
  public abstract boolean login(String paramString1, String paramString2);
  
  public abstract boolean signup(String paramString1, String paramString2);
  
  public abstract float getPrice(Cart paramCart);
  
  public abstract Customer getUserInfo(String paramString);
  
  public abstract boolean setUserInfo(String paramString, Customer paramCustomer);
  
  public abstract boolean processOrder(String paramString, Cart paramCart);
}
