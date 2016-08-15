public class Customer
{
  public String name;
  public String address;
  public String cardNumber;
  public String phoneNumber;
  public Boolean Premium;
  
  public Customer(String name, String address, String cardNumber, String phoneNumber, Boolean Premium)
  {
    this.name = name;
    this.address = address;
    this.cardNumber = cardNumber;
    this.phoneNumber = phoneNumber;
    this.Premium = false;
  }
}