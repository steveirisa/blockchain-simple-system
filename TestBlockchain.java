package Blockchain;

public class TestBlockchain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Blockchain CovidCoin = new Blockchain();
		
		Block dollars = new Block("Money Transfer", new java.util.Date(), "<Currency Exchange>", 0);
		Block yuans = new Block("Money Transfer", new java.util.Date(), "<Currency Exchange>", 0);
		Block euros = new Block("Money Transfer", new java.util.Date(), "<Currency Exchange>", 0);
		Block pounds = new Block("Money Transfer", new java.util.Date(), "Currency Exchange>", 0);
		
		CovidCoin.add_Block(dollars);
		CovidCoin.add_Block(yuans);
		CovidCoin.add_Block(euros);
		CovidCoin.add_Block(pounds);
		
		//CovidCoin.getLatestBlock().setHash_value("ABCDEFG");
		
		Blockchain Mined = new Blockchain();
		Mined.addminingblock(new Block("Money Transfer", new java.util.Date(), "transactions",0), 1);
		CovidCoin.display_Chain();
		
		CovidCoin.isValid();

	}
	


}
