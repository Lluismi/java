package Enzilium;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class TokenContract {

	private String Name = null;
	private String Symbol = null;
	private double TotalSupply = 0d;
	private Address owner = null;
	private PublicKey ownerPK = null;
	private double TokenPrice = 0d;
	private double totalTokensSold = 0d;

	private final Map<PublicKey, Double> balances = new HashMap<>();
	
	public TokenContract(Address owner){
		this.owner = owner;
		this.ownerPK = owner.getPK();
	}
	
    /** getters y setters */
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Address owner() {
		return this.owner;
	}

	public String symbol() {
		return Symbol;
	}

	public void setSymbol(String symbol) {
		Symbol = symbol;
	}

	public double totalSupply() {
		return TotalSupply;
	}

	public void setTotalSupply(int totalSupply) {
		TotalSupply = totalSupply;
	}
	
    public Double getTokenPrice() {
        return this.TokenPrice;
    }
    
	public void setTokenPrice(Double tokenPrice) {
		this.TokenPrice = tokenPrice;
	}
	
    public Map<PublicKey, Double> getBalances() {
        return this.balances;
    }
   
    @Override
    public String toString() {
        return "\n" + "name = " + getName() + "\n" + 
                      "symbol = " + symbol() + "\n" +
                      "totalSupply = " + totalSupply() + "\n" +
                      "owner PK = " + this.ownerPK.hashCode() + "\n";
    }
    
	/** Lógica */
    
    public void addOwner(PublicKey PK, Double units) {
        getBalances().putIfAbsent(PK, units);
    }
    
    public int numOwners() {
		return this.getBalances().size();
    }
    
    public double balanceOf(PublicKey owner) {
		return this.getBalances().getOrDefault(owner, 0d);
    }
    
	private void require(boolean b) throws Exception {
        if (! b) {
            throw new Exception();
        }
	}
	
    public void transfer(PublicKey publicKey, double d) {
    	try {
    		require(balanceOf(ownerPK) >= d);
    		this.getBalances().compute(ownerPK,(pk, tokens) -> tokens - d);
    		this.getBalances().put(publicKey, balanceOf(publicKey)+ d);
    	} catch (Exception e) {
    		
    	}
    }

	public void transfer(PublicKey publicKey, PublicKey publicKey2, double d) {
    	try {
    		require(balanceOf(publicKey) >= d);
    		this.getBalances().put(publicKey, balanceOf(publicKey) - d);
    		this.getBalances().put(publicKey2, balanceOf(publicKey2)+ d);
    	} catch (Exception e) {
    		
    	}
	}
	
	public void owners( ) {
		for (PublicKey pk : this.getBalances().keySet()) {
			if (!pk.equals(this.ownerPK)) {
				System.out.println("Owner: " + pk.hashCode() + ' '
									+ getBalances().get(pk) + ' '
									+ this.symbol());
			}
		}
	}
	
	public int totalTokensSold() {
		this.getBalances().forEach((pk, units) -> this.totalTokensSold += units);
		this.totalTokensSold -= balanceOf(ownerPK);
		return (int) this.totalTokensSold;
	}
	
	public void payable(PublicKey recipient, Double enziniums) {
		try {
			require(enziniums >= this.getTokenPrice());
			Double units = Math.floor(enziniums / TokenPrice);
			transfer(recipient, units);
			this.owner.transferEZI(enziniums);
		} catch (Exception e) {}
	}
}


