import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.swing.ImageIcon;

public class Product
{
  private HashMap<String, Object> props = new HashMap();
  private HashMap<String, String> dispNames = new HashMap();
  private String name;
  private ImageIcon image = null;
  
  public Product(String name)
  {
    setName(name);
  }
  
  public void setImage(String url)
  {
    this.image = ShopController.generateIcon(url, 150, 150);
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setProperty(String id, String displayName, Object value)
  {
    this.props.put(id, value);
    this.dispNames.put(id, displayName);
  }
  
  public Object getPropertyValue(String id)
  {
    return this.props.get(id);
  }
  
  public String getPropertyDisplayName(String id)
  {
    return (String)this.dispNames.get(id);
  }
  
  public String getPropertiesAsText()
  {
    String out = "<html>";
    String key;
    for (Iterator localIterator = this.props.keySet().iterator(); localIterator.hasNext(); out = out + getPropertyDisplayName(key) + ": " + getPropertyValue(key).toString() + "<br/>") {
      key = (String)localIterator.next();
    }
    out = out + "</html>";
    return out;
  }
  
  public boolean hasProperty(String id)
  {
    return this.props.containsKey(id);
  }
  
  public ImageIcon getImage()
  {
    if (this.image == null) {
      return ShopController.NO_IMAGE_ICON;
    }
    return this.image;
  }
}
