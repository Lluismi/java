package PigCoin;

import java.util.ArrayList;
import java.util.List;

public class BlockChain {

	private List<Transaction> blockChain = new ArrayList<Transaction>();
	
	/* Constructor */ 
	
	public BlockChain() {}
	
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
}
