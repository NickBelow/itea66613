import java.io.Serializable;

public class Setting implements Serializable{
  private String language;
  private String country;
  
  public Setting() {};
  public Setting(String language, String country) {
    this.language = language;
    this.country = country;
  }
  
  public String getLanguage() {
    return language;
  }
  public void setLanguage(String language) {
    this.language = language;
  }
  public String getCountry() {
    return country;
  }
  public void setCountry(String country) {
    this.country = country;
  }
}
