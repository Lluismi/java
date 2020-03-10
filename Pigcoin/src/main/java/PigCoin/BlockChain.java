package PigCoin;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BlockChain {

	private List<Transaction> blockChain = new ArrayList<Transaction>();
	
	/* Constructor */ 
	
	public BlockChain() {};
	
	/* Getter */
	
	List<Transaction> getblockChain() {
		return this.blockChain;
	}
	
	/* L�gica */
	
	public void addOrigin(Transaction transaction) {
		this.getblockChain().add(transaction);
	}

	public void summarize() {
		for (Transaction transaction : blockChain) {
			System.out.println(transaction.toString());
		}
	}
	
	public void summarize(int position) {
		System.out.println(getblockChain().get(position).toString());
	}
	
    public List<Transaction> loadInputTransactions(PublicKey address) {  
        List<Transaction> inputTransactions = getblockChain().stream()
            .filter(transaction -> transaction.getpKey_recipient().equals(address))
            .collect(Collectors.toCollection(ArrayList<Transaction>::new));
        
        return inputTransactions;
    }
    
    public List<Transaction> loadOutputTransactions(PublicKey address) {
    	List<Transaction> outputTransactions = getblockChain().stream()
    			.filter(transaction -> transaction.getpKey_sender().equals(address))
    			.collect(Collectors.toCollection(ArrayList<Transaction>::new));
    	
    	return outputTransactions;
    }
    
    public double[] loadWallet(PublicKey address) {
    	
        double pigCoinsIn = 0d;
        double pigCoinsOut = 0d;

        for (Transaction transaction : getblockChain()) {

            if (address.equals(transaction.getpKey_recipient())) {
                pigCoinsIn = pigCoinsIn + transaction.getPigcoins();
            }
            if (address.equals(transaction.getpKey_sender())) {
                pigCoinsOut = pigCoinsOut + transaction.getPigcoins();
            }
        }
        double[] pigCoinsInOut = {pigCoinsIn, pigCoinsOut};
        return pigCoinsInOut; 
    }
    
    public boolean isSignatureValid(PublicKey address, String message, byte[] signedTransaction) {
        return GenSig.verify(address, message, signedTransaction);
    }
    
    /* Sirve para obtener el hash previo de la transaccion anterior */
    
    private String getprevhash(String hash){
        for (Transaction transaction : getblockChain()){
            if(transaction.getHash() == hash){
                return transaction.getPrev_hash();
            }
        }
        return null;
    }
    
    /* Sirve para crear una transacción,
     * hacemos un bucle que recorra el hash del valor de las monedas cosumidas,
     * hacemos una nueva transacciones y cogemos el blockchain para agregarle la nueva transacción
     *  */
    
    public void createTransaction(PublicKey pKey_sender, PublicKey pKey_recipient, Map<String, Double> consumedCoins, String message, byte[] signedTransaction) {
    	
    	for (String hash : consumedCoins.keySet()) {
    		Transaction transaction = new Transaction(hash, getprevhash(hash), pKey_sender, pKey_recipient, consumedCoins.get(hash), message);
    		getblockChain().add(transaction);
    	}
    }
   
}
