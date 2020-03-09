package PigCoin;

import java.security.PublicKey;

public class Transaction {
	
	private String hash = null;
	private String prev_hash = null;
	private PublicKey pKey_sender = null;
	private PublicKey pKey_recipient = null;
	private double pigcoins = 0;
	private String message = null;
	
	/* Constructores */

	public Transaction(String hash, String prev_hash, PublicKey pKey_sender, PublicKey pKey_recipient, double pigcoins, String message) {
		this.hash = hash;
		this.prev_hash = prev_hash;
		this.pKey_sender = pKey_sender;
		this.pKey_recipient = pKey_recipient;
		this.pigcoins = pigcoins;
		this.message = message;	
	}
	
	public Transaction() {}
	
	/* Getters y Setters */

	public String getHash() {
		return this.hash;
	}
	
	public void setHash(String hash) {
		this.hash = hash;
	}
	
	public String getPrev_hash() {
		return this.prev_hash;
	}
	
	public void setPrev_hash(String prev_hash) {
		this.prev_hash = prev_hash;
	}

	public PublicKey getpKey_sender() {
		return this.pKey_sender;
	}

	public void setpKey_sender(PublicKey pKey_sender) {
		this.pKey_sender = pKey_sender;
	}

	public PublicKey getpKey_recipient() {
		return this.pKey_recipient;
	}

	public void setpKey_recipient(PublicKey pKey_recipient) {
		this.pKey_recipient = pKey_recipient;
	}

	public double getPigcoins() {
		return this.pigcoins;
	}

	public void setPigcoins(double pigcoins) {
		this.pigcoins = pigcoins;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "\n" + "hash = " + this.hash +
				"\n" + "prev_hash = " + this.prev_hash +
				"\n" + "pKey_sender = " + getpKey_sender().hashCode() +
				"\n" + "pKey_recipient = " + getpKey_recipient().hashCode() + 
				"\n" + "pigcoins = " + getPigcoins() + 
				"\n" + "message = " + getMessage();
	}
}
