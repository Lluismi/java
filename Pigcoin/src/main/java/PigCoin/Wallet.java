package PigCoin;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Wallet {
	
	private PublicKey address = null;
	private PrivateKey sKey = null;
	private double total_input = 0d;
	private double total_output = 0d;
	private double balance = 0d;
	private List<Transaction> inputTransactions = null;
	private List<Transaction> outputTransactions = null;
	
    /* Constructor */

    public Wallet() {};
    
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
	
	/* L�gica */
	
	
	public void generateKeyPair() {
		KeyPair keys = GenSig.generateKeyPair();
		address = keys.getPublic();
		sKey = keys.getPrivate();
	}
	
	@Override
	public String toString() {
		return "\n" + "Wallet = " + getAddress().hashCode() +
				"\n" + "Total input = " + getTotal_input() +
				"\n" + "Total output = " + getTotal_output() +
				"\n" + "Balance = " + getBalance() + "\n";	
	}
	
	public void loadInputTransactions(BlockChain bChain) {
        setInputTransactions(bChain.loadInputTransactions(getAddress()));
	}
	
	public void loadOutputTransactions(BlockChain bChain) {
        setOutputTransactions(bChain.loadOutputTransactions(getAddress()));
	}
	
	public void updateBalance() {
		this.balance = this.getTotal_input() - this.getTotal_output();
	}
	
	public void loadCoins(BlockChain bChain) {
		double[] inOut = {0d, 0d};
		inOut = bChain.loadWallet(getAddress());
		setTotal_Input(inOut[0]);
		setTotal_Output(inOut[1]);
        updateBalance();
	}

    public Map<String, Double> collectCoins(double pigcoins) {
        
    	
        Map<String, Double> collectedCoins = new LinkedHashMap<>();

        if (getInputTransactions() == null) {
            return null;
        }

        if (pigcoins > getBalance()) {
            return null;
        }

        Double achievedCoins = 0d;
        
        /* Declaramos una variable local
         * si no es igual a null entra en el for
         * recorriendo las transacciones del output
         * añadiendo las monedas consumidas a la variable HashSet
         * luego entra en otro for donde comprueba las transacciones Input
         * si contiene monedas continua, si el usuario tiene los pigcoins
         * suficientes se envian al destinatario 
         * */
        
        Set<String> consumedCoins = new HashSet<>();
        if (getOutputTransactions() != null) {
            for (Transaction transaction : getOutputTransactions()) {
                consumedCoins.add(transaction.getPrev_hash());
            }   
        }             

        for (Transaction transaction : getInputTransactions()) {

            if (consumedCoins.contains(transaction.getHash())) {
                continue;
            }

            if (transaction.getPigcoins() == pigcoins) {
                collectedCoins.put(transaction.getHash(), transaction.getPigcoins());
                consumedCoins.add(transaction.getHash());
                break;
                
            /* Si el usuario no tiene una transacciones con los pigcoins que pide
             * busca un inputtransactions  mayor que lo que pide y envia 2 transacciones
             * una con lo que le envias al otro usuario
             * y otra con lo que te queda a ti
             * */
                
            } else if (transaction.getPigcoins() > pigcoins) {
                collectedCoins.put(transaction.getHash(), pigcoins);
                collectedCoins.put("CA_" + transaction.getHash(), transaction.getPigcoins() - pigcoins);
                consumedCoins.add(transaction.getHash());
                break;
                
            /* Este else es para que el usuario no pueda utilizar 2 veces la misma transacción
             * y el blockchain lo bloqueará 
             * */ 
            } else {
                collectedCoins.put(transaction.getHash(), transaction.getPigcoins());
                achievedCoins = transaction.getPigcoins();
                pigcoins = pigcoins - achievedCoins;
                consumedCoins.add(transaction.getHash());
            }

        }
        return collectedCoins;
    }

    public byte[] signTransaction(String message) {
        return GenSig.sign(getSKey(), message);
    }
 
}
