package Enzilium;

import java.security.KeyPair;

import java.security.PrivateKey;
import java.security.PublicKey;

public class Address {
		
	private PublicKey PK = null;
	private PrivateKey SK = null;
	private double balance = 0d;
	private final String symbol = "EZI";

	public PublicKey getPK() {
		return PK;
	}

	public void setPK(PublicKey pK) {
		PK = pK;
	}

	public PrivateKey getSK() {
		return SK;
	}

	public void setSK(PrivateKey sK) {
		SK = sK;
	}

	public void generateKeyPair() {
		KeyPair keys = GenSig.generateKeyPair();
		PK = keys.getPublic();
		SK = keys.getPrivate();	
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "\n" + "PK = " + getPK().hashCode() + "\n" + 
                "Balance = " + getBalance() + " " 
                + this.symbol + "\n";
	}

	public void transferEZI(double enziniums) {
		this.balance += enziniums;
	}
	
	public void send(TokenContract ricknillos, double enziniums) {
		if (enziniums <= this.balance) {
			ricknillos.payable(getPK(), enziniums);
			this.balance -= enziniums;
		}
	}
}