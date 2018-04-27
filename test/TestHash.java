
package blockchainapp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author sagamor
 */
public class TestHash {
    private MessageDigest mg;
    
    public TestHash() throws NoSuchAlgorithmException{
        mg = MessageDigest.getInstance("SHA-1");
    }
    byte[] getHash(String input) {
        byte[] inputByte = input.getBytes();
        System.out.println("Computing hash...");
        return mg.digest(inputByte);
    }
    public static void main(String[] args) throws NoSuchAlgorithmException {
        TestHash th = new TestHash();
        byte[] sha1 = th.getHash("Input");
        for(byte sha: sha1){
            System.out.print(sha);
        }
    }
}
