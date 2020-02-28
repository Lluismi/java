package PigCoin;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Wallet {
	
	private PublicKey address = null;
	private PrivateKey sKey = null;
	private double total_input = 0d;
	private double total_output = 0d;
	private double balance = 0d;
	private double inputTransactions = 0d;
	private double outputTransactions = 0d;
	
	/* Getters y Setters */
	
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
	
	/* Logica */
	
	public void generateKeyPair() {
		KeyPair keys = GenSig.generateKeyPair();
		address = keys.getPublic();
		sKey = keys.getPrivate();
	}
	
	
}
