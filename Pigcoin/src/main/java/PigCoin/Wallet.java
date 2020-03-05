package PigCoin;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Wallet {
	
	private PublicKey address = null;
	private PrivateKey sKey = null;
	private double total_input = 0;
	private double total_output = 0;
	private double balance = 0;
	private double inputTransactions = 0;
	private double outputTransactions = 0;
	
	/* Getters y Setters */
	
	public void generateKeyPair() {
		KeyPair keys = GenSig.generateKeyPair();
		address = keys.getPublic();
		sKey = keys.getPrivate();
	}
	
	public PublicKey getAddress() {
		return this.address;
	}
	
	public void setAddress(PublicKey address) {
		this.address = address;
	}

	public PrivateKey getsKey() {
		return sKey;
	}

	public void setSK(PrivateKey sKey) {
		this.sKey = sKey;
	}
	
	public String toString() {
		return "\n" + "Wallet = " + getAddress().hashCode() +
				"\n" + "Total input = " + total_input +
				"\n" + "Total output = " + total_output +
				"\n" + "Balance = " + balance + "\n";
				
	}

	public void loadCoins(BlockChain bChain) {
		
	}
}
