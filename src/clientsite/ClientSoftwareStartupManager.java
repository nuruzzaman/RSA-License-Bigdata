package clientsite;

import com.my.bigdata.core.LicenseManager;
import com.my.bigdata.core.LicenseManagerProperties;
import com.my.bigdata.core.encryption.FilePublicKeyDataProvider;
import com.my.bigdata.licensing.SampleLicenseProvider;
import com.my.bigdata.licensing.SamplePasswordProvider;

/*
 * 
 * License Utilization
 * Verifying, validating and using licenses is nearly as simple as creating them;
 * just a few more properties to set to create the LicenseManager singleton instance, and a few more interfaces to implement.
 * 
 * https://java.nicholaswilliams.net/forums/viewtopic.php?f=2&t=531
 */
public class ClientSoftwareStartupManager
{
	
    public static void startup()
    {    	
    	LicenseManagerProperties.setPublicKeyDataProvider(new FilePublicKeyDataProvider("C:/Tmp/security/Public.key"));
        LicenseManagerProperties.setPublicKeyPasswordProvider(new SamplePasswordProvider());
        LicenseManagerProperties.setLicenseProvider(new SampleLicenseProvider());
        
        // Optional; set only if you are using a different password to encrypt licenses than your public key
        //LicenseManagerProperties.setLicensePasswordProvider(new LicensePasswordProvider());
        
        // Optional; set only if you wish to validate licenses
        //LicenseManagerProperties.setLicenseValidator(new LicenseValidator());
        
        // Optional; defaults to 0, which translates to a 10-second (minimum) cache time
        LicenseManagerProperties.setCacheTimeInMinutes(0);
        
        LicenseManager.getInstance();    
        
    }
    

    public static void main(String [] args)
    {
    	startup();
    	
    	LicenseUsageService licservice = new LicenseUsageService(); 
    	licservice.useLicense(); 
    	
        System.out.print("Completed.");

    }
    
    
}

