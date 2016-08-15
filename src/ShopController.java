import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ShopController
{
  public static ImageIcon NO_IMAGE_ICON = generateIcon("https://placeholdit.imgix.net/~text?txtsize=23&bg=ffffff&txtclr=000000&txt=No+Image&w=200&h=200", 150, 150);
  //public static ImageIcon LOGO_ICON = new ImageIcon(ShopController.class.getResource("logo.png"));
  public static HashMap<String, ImageIcon> IMAGE_CACHE;
  
  public static ImageIcon generateIcon(String imgLoc, int width, int height)
  {
    if (IMAGE_CACHE == null) {
      IMAGE_CACHE = new HashMap<String, ImageIcon>();
    }
    if (IMAGE_CACHE.containsKey(imgLoc)) {
      return (ImageIcon)IMAGE_CACHE.get(imgLoc);
    }
    try
    {
      URL url = new URL(imgLoc);
      ImageIcon icon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(width, height, 1));
      IMAGE_CACHE.put(imgLoc, icon);
      return icon;
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return null;
  }
  
  private JFrame window = new JFrame();
  private Model backend;
  private Cart cart = new Cart();
  private String currentUserID;
  
  public ShopController(Model b)
  {
    this.backend = b;
  }
  
  public void setView(View view)
  {
    view.setController(this);
    view.initialize();
    this.window.setContentPane(view);
    this.window.revalidate();
  }
  
  public JFrame getWindow()
  {
    return this.window;
  }
  
  public Model getBackend()
  {
    return this.backend;
  }
  
  public void init()
  {
    this.window.setResizable(false);
    this.window.setTitle("Shop");
    this.window.setSize(800, 600);
    this.window.setDefaultCloseOperation(3);
    this.window.setLocationRelativeTo(null);
    this.window.setVisible(true);
    setView(new LoginView());
  }
  
  public void showPopup(String message)
  {
    JOptionPane.showMessageDialog(this.window, message);
  }
  
  public Customer getCurrentCustomerDetails()
  {
    return getBackend().getUserInfo(this.currentUserID);
  }
  
  public void signup(String username, String pass, String confPass)
  {
    if (username.length() < 3)
    {
      showPopup("Your user ID must be at least 3 chars long!");
      return;
    }
    if (pass.length() < 5)
    {
      showPopup("Your password must be at least 5 chars long!");
      return;
    }
    if (!pass.equals(confPass))
    {
      showPopup("The passwords do not match");
      return;
    }
    boolean success = getBackend().signup(username, pass);
    if (!success)
    {
      showPopup("Signup failed, that userID may already be in use!");
    }
    else
    {
      showPopup("Your account has been created, please edit your details by clicking 'My account' in the top right.");
      attemptLogin(username, pass);
    }
  }
  
  public void attemptLogin(String username, String password)
  {
    if (this.backend.login(username, password))
    {
      this.currentUserID = username;
      showProductList();
    }
    else
    {
      showPopup("Login failed! Please ensure that your user ID and password are correct.");
    }
  }
  
  public void updateUserDetails(Customer c)
  {
    if (this.currentUserID != null)
    {
      boolean success = getBackend().setUserInfo(this.currentUserID, c);
      if (!success) {
        showPopup("There was an error saving your information! Please try again later.");
      }
    }
    else
    {
      System.err.println("Can't update user info, no one is signed in!");
    }
  }
  
  public void showCheckout()
  {
    ConfirmDialog.display(this);
  }
  
  public Cart getCart()
  {
    return this.cart;
  }
  
  public void addToCart(Product p, Float quantity)
  {
    this.cart.add(p, quantity);
  }
  
  public void showCartView()
  {
    setView(new CartView());
  }
  
  public float getTotalCartPrice()
  {
    return getBackend().getPrice(this.cart);
  }
  
  public void showProductList()
  {
    setView(new ProductListView());
  }
  
  public void attemptTransaction()
  {
    Customer c = getBackend().getUserInfo(this.currentUserID);
    String prefix = "Order failed! ";
    if (c.name.trim().equals(""))
    {
      showPopup(prefix + "You have not entered your full name!");
      return;
    }
    if (c.address.trim().equals(""))
    {
      showPopup(prefix + "You have not entered your home address!");
      return;
    }
    if (c.phoneNumber.trim().equals(""))
    {
      showPopup(prefix + "You have not entered your phone number!");
      return;
    }
    if (c.cardNumber.trim().equals(""))
    {
      showPopup(prefix + "You have not entered your card number!");
      return;
    }
    boolean success = getBackend().processOrder(this.currentUserID, this.cart);
    if (!success)
    {
      showPopup("Sorry, your order could not be placed! Please ensure that all of your information is correct.");
    }
    else
    {
      showPopup("Your order has been placed successfully! Have a nice day!");
      this.cart.clear();
      showCartView();
    }
  }
}
