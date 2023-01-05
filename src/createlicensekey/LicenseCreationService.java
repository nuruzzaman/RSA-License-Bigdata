package createlicensekey;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import com.my.bigdata.core.License;
import com.my.bigdata.core.licensor.LicenseCreator;


public class LicenseCreationService
{
	
    public void createLicense() throws IOException, ParseException
    {
    	SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
    	String dateInString = "31-12-2015 11:59:59";
    	Date date = sdf.parse(dateInString);    	
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	//System.out.println("Calender - Time in milliseconds : " + calendar.getTimeInMillis());
    	
    	Long expirationDate = calendar.getTimeInMillis();
    	Long feature2ExpDate = expirationDate;
        License license = new License.Builder().
                withProductKey("5565-1039-AF89-GGX7-TN31-14AL").
                withSubject("B0-10-41-ED-4E-D5").
                withHolder("Mr. Nazmi").
                withNumberOfLicenses(1).
                withIssuer("Bigdata Enterprise").
                withGoodBeforeDate(expirationDate).
                withFeature("SMART ADMIN").
                withFeature("FEATURE2", feature2ExpDate).	
                build();
        
        byte[] licenseData = LicenseCreator.getInstance().signAndSerializeLicense(license, "My$W93a5an&8!gDa%9@2020".toCharArray());

       // signAndSerializeLicense returns a SignedLicense that has been Java serialized. 
       // Now WRITE these bytes out to a file using whichever method you prefer.
     File file = new File("C:/tmp/security/PublicLicenseForUser.lic");
     FileUtils.writeByteArrayToFile(file, licenseData);     

    }

}


