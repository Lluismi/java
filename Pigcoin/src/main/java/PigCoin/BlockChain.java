package PigCoin;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BlockChain {

	private List<Transaction> blockChain = new ArrayList<Transaction>();
	
	/* Constructor */ 
	
	public BlockChain() {}
	
	/* Getter */
	
	List<Transaction> getblockChain() {
		return this.blockChain;
	}
	
	/* Lógica */
	
	public void addOrigin(Transaction transaction) {
		blockChain.add(transaction);
	}

	public void summarize() {
		for (Transaction transaction : blockChain) {
			System.out.println(transaction);
		}
	}
	
	public void summarize(int position) {
		System.out.println(blockChain.get(position).toString());
	}
	
    public List<Transaction> loadInputTransactions(PublicKey address) {  
        List<Transaction> inputTransactions = getblockChain().stream()
            .filter(transaction -> transaction.getpKey_recipient().equals(address))
            .collect(Collectors.toCollection(ArrayList<Transaction>::new));
        return inputTransactions;
    }
}
