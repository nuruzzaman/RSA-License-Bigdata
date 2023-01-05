package clientsite;

import java.util.Date;

import com.my.bigdata.core.License;
import com.my.bigdata.core.License.Feature;
import com.my.bigdata.core.LicenseManager;
import com.my.bigdata.core.exception.ExpiredLicenseException;
import com.my.bigdata.core.exception.InvalidLicenseException;
import com.my.bigdata.core.immutable.ImmutableLinkedHashSet;


public class LicenseUsageService
{
	
    public void useLicense() throws ExpiredLicenseException
    {    	
        LicenseManager manager = LicenseManager.getInstance();
        
        License license = manager.getLicense("C:/tmp/security/PublicLicenseForUser.lic");
        try {
            manager.validateLicense(license);
            
        } catch(InvalidLicenseException e) { return; }
        
        String macAddress = license.getSubject(); 
        int seats = license.getNumberOfLicenses();
        String holder = license.getHolder();
        long issued = license.getIssueDate();
        Date issueDate = new Date(issued);
        String issuer = license.getIssuer();
        String key = license.getProductKey();
        long expDate = license.getGoodBeforeDate(); 
        ImmutableLinkedHashSet<Feature> ilhs = license.getFeatures();
        Feature feature = ilhs.get(0);
        String featureName = feature.getName();
        
        System.out.println("License Holder: " + holder + "\n" +
                         "Issuer: " + issuer + "\n" +
                         "Product Key: " + key + "\n" +
                         "Number of License: " + seats + "\n" +
                         "Issue Date: " + issueDate.toString() + "\n" +
                         "Expired Date: " + expDate + "\n" +
                         "MAC Address: " + macAddress + "\n" +
                         "Feature Name: " + featureName + "\n"); 
              
        //boolean bool;
        //try {
        //     bool = manager.hasLicenseForAllFeatures("client2", "feature1", "feature2");
        //} catch(Exception e) { e.printStackTrace(); bool = false; }
        
        
    }
    

}

