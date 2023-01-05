package createlicensekey;

/*
 * 
 * // Use private key to Signed License
 * 
 * */
import java.io.IOException;
import java.text.ParseException;

import com.my.bigdata.core.LicenseManagerProperties;
import com.my.bigdata.core.encryption.FilePrivateKeyDataProvider;
import com.my.bigdata.core.licensor.LicenseCreator;
import com.my.bigdata.core.licensor.LicenseCreatorProperties;
import com.my.bigdata.licensing.SampleLicenseProvider;
import com.my.bigdata.licensing.SamplePasswordProvider;


public class LicenseStartupManager
{

    public static void startup()
    {
    	// Read file from C:/tmp/security/PrivateLock.key and generate public.key
    	// Use PrivateLock.key to Signed License
        // LicenseManagerProperties.setPublicKeyDataProvider(new FilePublicKeyDataProvider("C:/tmp/security/publicLicense.key"));
        LicenseCreatorProperties.setPrivateKeyDataProvider(new FilePrivateKeyDataProvider("C:/tmp/security/PrivateLock.key"));
        LicenseCreatorProperties.setPrivateKeyPasswordProvider(new SamplePasswordProvider());
        LicenseManagerProperties.setLicenseProvider(new SampleLicenseProvider());
        LicenseCreator.getInstance();
    }
    
    
   public static void main(String [] agrs) throws ParseException{
	   startup();
	   
	   LicenseCreationService licService = new LicenseCreationService(); 
	   try 
	   {
		licService.createLicense();
		System.out.print("Public License User Key Successfully Generated. Please send to respective client."); 
		
	   } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
   }
    
}


