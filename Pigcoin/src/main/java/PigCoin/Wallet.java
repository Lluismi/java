package PigCoin;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Wallet {
	
	private PublicKey address = null;
	private PrivateKey sKey = null;
	private double total_input = 0d;
	private double total_output = 0d;
	private double balance = 0d;
	private List<Transaction> inputTransactions = new ArrayList<Transaction>();
	private List<Transaction> outputTransactions = new ArrayList<Transaction>();
	
	/* Getters y Setters */
	
    public void setSK(PrivateKey sKey) {
        this.sKey = sKey;
    }

    public PrivateKey getSKey() {
        return this.sKey;
    }

    public void setAddress(PublicKey pKey) {
        this.address = pKey;
    }

    public PublicKey getAddress() {
        return this.address;
    }

    public void setTotal_Input(double total_input) {
        this.total_input = total_input;
    }

    public double getTotal_input() {
        return this.total_input;
    }

    public void setTotal_Output(double total_output) {
        this.total_output = total_output;
    }

    public double getTotal_output() {
        return this.total_output;
    }

    public double getBalance() {
		return this.balance;
    }
    
    public void setOutputTransactions(List<Transaction> outputTransactions) {
        this.outputTransactions = outputTransactions;
    }

    public List<Transaction> getOutputTransactions() {
        return this.outputTransactions;
    }

    public void setInputTransactions(List<Transaction> transactions) {
		this.inputTransactions = transactions;
	}

    public List<Transaction> getInputTransactions() {
		return this.inputTransactions;
	}
	
	/* Lógica */
	
	
	public void generateKeyPair() {
		KeyPair keys = GenSig.generateKeyPair();
		address = keys.getPublic();
		sKey = keys.getPrivate();
	}
	
	public String toString() {
		return "\n" + "Wallet = " + getAddress().hashCode() +
				"\n" + "Total input = " + total_input +
				"\n" + "Total output = " + total_output +
				"\n" + "Balance = " + balance + "\n";
				
	}
	
	public double loadInputTransactions(BlockChain bChain) {
		double inPut = 0d;
		inPut = bChain.getblockChain().stream()
				.filter(transaction -> transaction.getpKey_recipient().equals(getAddress()))
				.map(transaction -> transaction.getPigcoins())
				.reduce(inPut, (accumulator, item) -> accumulator + item);
		return inPut;
	}
	
	public double loadOutputTransactions(BlockChain bChain) {
		double inPut = 0d;
		inPut = bChain.getblockChain().stream()
				.filter(transaction -> transaction.getpKey_recipient().equals(getAddress()))
				.map(transaction -> transaction.getPigcoins())
				.reduce(inPut, (accumulator, item) -> accumulator + item);
		return inPut;
	}
	
	public void updateBalance() {
		this.balance = this.getTotal_input() - this.getTotal_output();
	}
}
