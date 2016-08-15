public class CartItem
{
  public Product product;
  public Float quantity;
  
  public CartItem(Product product, Float quantity)
  {
    this.product = product;
    this.quantity = quantity;
  }
  
  public void add()
  {
    add(1.0F);
  }
  
  public void add(Float quantity)
  {
    this.quantity += quantity;
  }
}
