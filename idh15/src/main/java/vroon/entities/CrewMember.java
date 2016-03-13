package vroon.entities;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord( separator = ";" ,skipFirstLine= false,generateHeaderColumns=true)
public class CrewMember {
	@DataField(pos = 1)
	public String username;
	@DataField(pos = 2)
	public String firstname;
	@DataField(pos = 3)
	public String lastname;
	@DataField(pos = 4)
	public Boolean onboard;
}
