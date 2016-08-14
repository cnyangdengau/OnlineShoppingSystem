public class CartItem
{
  public Product product;
  public float quantity;
  
  public CartItem(Product product, float quantity)
  {
    this.product = product;
    this.quantity = quantity;
  }
  
  public void add()
  {
    add(1.0F);
  }
  
  public void add(float quantity)
  {
    this.quantity += quantity;
  }
}
