package createlicensekey;

import java.io.*;
import java.security.KeyPair;

import com.my.bigdata.core.encryption.RSAKeyPairGenerator;
import com.my.bigdata.core.exception.AlgorithmNotSupportedException;
import com.my.bigdata.core.exception.InappropriateKeyException;
import com.my.bigdata.core.exception.InappropriateKeySpecificationException;
import com.my.bigdata.core.exception.RSA2048NotSupportedException;


/*
 * 
 * Key Generation: Method-1
 * 
 * Since the License Manager uses public/private key security to protect licenses, you must first generate a public/private key pair. 
 * There are several ways to do this. The first way is to use the Command Line Interface (see the documentation). 
 */


public class PrivatePublicKeyGenerator {
    public static void main(String[] arguments) {
        RSAKeyPairGenerator generator = new RSAKeyPairGenerator();
        
        KeyPair keyPair;
        try {
        	//Get public and private key value 
            keyPair = generator.generateKeyPair();
            
        } catch(RSA2048NotSupportedException e) { return; }
        
        try {
        	
       	 // 1. keyPair 		: The key pair to save to the files specified
    	 // 2. private.key 	: privateOutputFileName The name of the file to save the encrypted private key to
    	 // 3. public.key	: publicOutputFileName The name of the file to save the encrypted public key to
    	 // 4. key password	: The password to encrypt the private key with
            generator.saveKeyPairToFiles(keyPair, "PrivateLock.key", "Public.key", "My$W93a5an&8!gDa%9@2020".toCharArray());
            
            //If you want to encrypt the public and private keys with different passwords (recommended), you can do that, too:
            //generator.saveKeyPairToFiles(keyPair, "private.key", "public.key", "private password".toCharArray(), "public password".toCharArray());
            
            System.out.println("Generated Private and Public Key. "); 
            
        } catch(IOException | AlgorithmNotSupportedException | InappropriateKeyException | InappropriateKeySpecificationException e)
            { return; }
    }
}
