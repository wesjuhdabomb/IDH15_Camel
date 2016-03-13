package vroon.entities;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord( separator = ";", generateHeaderColumns=true )
public class InternetAccount {
	@DataField(pos=1)
	public String username;
	@DataField(pos=2)
	public String password;
	@DataField(pos=3)
	public String firstname;
	@DataField(pos=4)
	public String lastname;
	@DataField(pos=5)
	public String roaming_domain;
	@DataField(pos=6)
	public String active;
	@DataField(pos=7)
	public String account_type;
	@DataField(pos=8)
	public String status;
	
}
