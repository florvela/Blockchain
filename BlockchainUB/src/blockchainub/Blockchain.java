package blockchainub;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;




public class Blockchain {
    private List<Transaction> currentTransactions;
    private List<Block> chain;
    //temporal last block
    private Block lastBlock; 
    private String previousHash = null;
    
    public Blockchain() {
        //T
        newBlock(1, 100);
    }
    
    
    public Block newBlock(String previousHash, Integer proof){
    //TO-DO: Crear nuevo bloque y agregarlo a la cadena
        Integer index = this.chain.size() + 1;
        Timestamp timestamp = new Timestamp(getTimeStamp());
        
        Block block = new Block(index, timestamp, currentTransactions, proof, previousHash);
        currentTransactions = null;
        chain.add(block);
        return block;
    }
    public void newBlock(Integer proof) {
        if(previousHash == null){
            hash(chain.get(chain.size() - 1)); //arreglar con this hash
        }
            newBlock(this.previousHash, proof);
    }
   
    
    
    /*
    Crear una nueva transaccion que ira dentro del siguiente bloque minado.
    */
    public Integer newTransaction(String sender, String recipient, Integer amount){
        try {
        TransactionParameters transactionParams = new TransactionParameters(sender, recipient, amount);
        currentTransactions.add(new Transaction(transactionParams));        
            return lastBlock.getInt("index") + 1;
        } catch (JSONException ex) {
            Logger.getLogger(Blockchain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    static void hash(Block block){
        //TO-DO: Hashear bloque returnType un HASH
    }
    
    public Block lastBlock(){
        //TO-DO: Devolver el ultimo bloque en la cadena
        Block b = new Block();
        return b;
    }
    
    private long getTimeStamp() {
        return (long)(System.currentTimeMillis()*1000);
    }
}
