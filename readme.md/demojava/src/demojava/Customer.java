package demojava;

public class Customer {
	private int id;
	  private String cname;
	  private String mobile;
	  private String mail;
	  private int itemspurchased;
	  public Customer(int id,String cname,String cmobile,String mail,int itemspurchased) {
	    this.id=id;
	    this.cname = cname;
	    this.mobile = cmobile;
	    this.mail=mail;
	    this.itemspurchased=itemspurchased;
	  }
	  public int getId() {
	    return id;
	  }
	  public String getName() {
	    return cname;
	  }
	  public String getMobile() {
	    return mobile;
	  }
	  public String getMail() {
		  return mail;
	  }
	 public int getItemspurchased() {
		 return itemspurchased;
	 }
}
