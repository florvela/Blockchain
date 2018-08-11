/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchainub;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author hp
 */
class Block extends JSONObject {
    private Integer index;
    private Integer proof;
    private String previousHash;
    public Block (Integer index, Timestamp timestamp, List<Transaction> transactions, Integer proof, String previousHash){
        createBlock(index,timestamp, transactions, proof, previousHash);
    }

    Block() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private JSONObject createBlock(Integer index, Timestamp timestamp, List<Transaction> transactions, Integer proof, String previousHash){
        JSONObject block = new JSONObject();
        try {
            block.put("index", index);
            block.put("timestamp", timestamp);
            block.put("transactions", transactions);
        } catch (JSONException ex) {
            Logger.getLogger(Block.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return block;
    }
}
