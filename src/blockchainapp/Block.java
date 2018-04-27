
package blockchainapp;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;



public class Block {
    /*
    ** Объявление переменных блока
    **
    */
    private long date;
    private int index;
    private String[] data;
    private byte[] PreviousBlockHash;
    private byte[] hash;
    private Hash utilHash;
    
    /*
    ** Конструктор. В конструктор передаем индекс нового блока, массив данных и массив байтов, представляющих хэш предыдущего блока
    ** 
    */
    public Block(int _index, String[] _data, byte[] PreviousBlockHash) throws NoSuchAlgorithmException{
        index = _index;
        utilHash = new Hash();
        data = _data;
        date = new Date().getTime();
        this.PreviousBlockHash = PreviousBlockHash;
        // Вызов функции расчета нового хэша
        setHash();
    }

    public byte[] getHash() {
        return hash;
    }
    
    /*Пока что какая-то дичь
    public String getHashToString() throws UnsupportedEncodingException {
        StringBuffer sb = new StringBuffer();
        String hashToString = null;
        for(byte hash: hash){
            hashToString = new String(hash, "UTF-8");
        }
        
        return new String(hash, "UTF-8");
    }     
     */
    
    /*
    ** Получение индекса текущего блока
    */
    public int getIndexOfBlock() {
        return indexOfBlock;
    }
    
    /*
    ** Переводим в строку текущее время, хэш предыдущего блока(неправильная реализация, сейчас попадает значение по hashCode), массив данных
    ** Далее вызываем расчет хэша у класса Hash, в который передаем сконкатенированную строку.
    */
    private void setHash() {
        StringBuffer header = new StringBuffer("Дата: " + Long.toString(date) + " PreviousBlockHash: " + PreviousBlockHash.toString() + " Данные: ");
        
        System.out.println("header до for: " + header);
        for(int i = 0; i < data.length; i++){
            header.append(data[i]);
        }
        System.out.println("header: " + header);
        
        hash = utilHash.getHash(header.substring(0));
        System.out.println("Новый хэш: ");
        for(byte hash: hash){
            System.out.print(hash);
        }
        System.out.println(" ");
    }
}
