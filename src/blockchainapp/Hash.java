
package blockchainapp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author sagamor
 
 */
class Hash {
    private MessageDigest mg;
    
    /*
    ** Получение инстанса MD
    */
    public Hash() throws NoSuchAlgorithmException{
        mg = MessageDigest.getInstance("SHA-256");
    }
    
    /*
    ** Перевод строки в массив байтов (слишком много конвертаций, нужно везде байты)
    ** возвращаем получившийся хэш
    */
    byte[] getHash(String input) {
        byte[] inputByte = input.getBytes();
        System.out.println("Computing hash...");
        return mg.digest(inputByte);
    }
    
}
