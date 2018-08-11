package blockchainub;


class TransactionParameters {
    private String sender;
    private String recipient;
    private Integer amount;
    
    public TransactionParameters(String sender, String recipient, Integer amount){
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
    }
    
    public String getSender() {
        return sender;
    }
    
    public String getRecipient() {
        return recipient;
    }
    
    public Integer getAmount() {
        return amount;
    }
    
    public void setSender(String sender) {
        this.sender = sender;
    }
    
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
