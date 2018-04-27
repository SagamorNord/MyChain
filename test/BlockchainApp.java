
package blockchainapp;

import java.security.NoSuchAlgorithmException;

public class BlockchainTest {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Blockchain bc = new Blockchain("Sagamor's first blockchain");
        String[] firstData = {"First block", " empty data"};
        System.out.println("Первый блок...");
        bc.addBlock(firstData);
        String[] secondData = {"Second block", " empty data"};
        bc.addBlock(secondData);
        String[] thirdData = {"Third block", " empty data"};
        bc.addBlock(thirdData);
        System.out.println(bc.blocks.size());
    }
    
}
