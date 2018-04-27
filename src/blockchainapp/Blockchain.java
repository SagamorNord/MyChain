
package blockchainapp;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;


public class Blockchain {
    List<Block> blocks;
    String name;
    
    /*
    ** Конструктор, в котором создаем и добавляем генезис-блок
    */
    public Blockchain(String name) throws NoSuchAlgorithmException{
        this.name = name;
        blocks = new ArrayList<>();
        blocks.add(genesisBlock());
    }

    private Block genesisBlock() throws NoSuchAlgorithmException {
        String[] data = {"Genesis Block ", "First Block"};
        byte[] genesisHash = new byte[1];
        return new Block(0, data, genesisHash);
    }
    
    /*
    ** Сначала получаем индекс последнего блока
    ** Создаем новый блок
    ** Добавляем новый блок в ArrayList, представляющий собой блокчейн
    */
    public void addBlock(String[] data) throws NoSuchAlgorithmException{
        System.out.println("------------------");
        System.out.println("Add block № " + (blocks.size())+ "...");
        Block previousBlock = blocks.get(blocks.size() - 1);
        Block newBlock = new Block(blocks.size(), data, previousBlock.getHash());
        blocks.add(newBlock);
        System.out.println("++++++++++++++++++++++++++");
        System.out.println("The Block № " + newBlock.getIndexOfBlock() + " is added; Hash of block: " + newBlock.getHash());
    }
}
