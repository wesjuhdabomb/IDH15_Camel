package vroon.entities;



import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord( separator = ";" ,skipFirstLine= true,generateHeaderColumns=true)
public class RoamingUser {
	@DataField(pos = 1, position=25)
	public String username;
	@DataField(pos = 2, position=24)
	public String password;
	@DataField(pos = 3, position=23)
	public String firstname;
	@DataField(pos = 4, position=22)
	public String lastname;
	@DataField(pos = 5, position=21)
	public String vessel;
	@DataField(pos = 6, position=20)
	public String email;
	@DataField(pos = 7, position=19)
	public String phone;
	@DataField(pos = 8, position=18)
	public String address;
	@DataField(pos = 9, position=17)
	public String embark;
	@DataField(pos = 10, position=16)
	public Boolean active;
	@DataField(pos = 11, position=15)
	public String credit;
	@DataField(pos = 12, position=14)
	public String freefield1;
	@DataField(pos = 13, position=13)
	public String mail_usage_amt;
	@DataField(pos = 14, position=12)
	public String mail_usage_byte;
	@DataField(pos = 15, position=11)
	public String mail_sent;
	@DataField(pos = 16, position=10)
	public String mail_recv;
	@DataField(pos = 17, position=9)
	public String web_usage_amt;
	@DataField(pos = 18, position=8)
	public String web_usage_byte;
	@DataField(pos = 19, position=7)
	public String account_type;
	@DataField(pos = 20, position=6)
	public String last_refill;
	@DataField(pos = 21, position=5)
	public String status;
	@DataField(pos = 22, position=4)
	public String created;
	@DataField(pos = 23, position=3)
	public String updated;
	@DataField(pos = 24, position=2)
	public String idt_accountno;
	@DataField(pos = 25, position=1)
	public String idt_pin;
	
	public void setName(String value){
		username =value;
	}
}
