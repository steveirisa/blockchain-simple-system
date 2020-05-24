package Blockchain;
import java.util.ArrayList;
import java.util.List;

public class Blockchain {

private List<Block> chain;
	
	public Blockchain() {
		chain = new ArrayList<Block>();
		chain.add(generateGenesis());
	}
	
	private Block generateGenesis() {
		Block genesis = new Block("Money Transfer", new java.util.Date(), "<transactions>",0);
		genesis.setPreviousHash(null);
		genesis.ComputeHash();
		return genesis;
	}
	
	public void add_Block(Block blk) {
		Block new_Block = blk;
		new_Block.setPreviousHash(chain.get(chain.size()-1).getHash_Value());
		new_Block.ComputeHash();
		this.chain.add(new_Block);
	}
	public void addminingblock(Block blk, int difficulty) {
		if (difficulty == 0) {
			this.add_Block(blk);
			return;
		}
		// create string of leading zeroes as per difficulty
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < difficulty; i++) {
			sb.append("0");
		}
		String leadingZeroes = sb.toString();
		System.out.println("leadingZeroes: " + leadingZeroes);
		
		blk.setPreviousHash(getLatestBlock().getHash_Value());
		blk.setHash_value(blk.ComputeHash());
		
		while (blk.getHash_Value().substring(0, difficulty) != leadingZeroes) {
			blk.setNonce(blk.getNonce() + 1);
			blk.setHash_value(blk.ComputeHash());
			System.out.println("Current BLock's Hash:" + blk.getHash_Value());
		}
		System.out.println("Block MIned:" + blk.getHash_Value());
		chain.add(blk);
	}
	
	public void display_Chain() {
		
		for(int i=0; i<chain.size(); i++) {
			System.out.println("Block: " + i);
			System.out.println("Model: " + chain.get(i).getVersion());
			System.out.println("Timestamp: " + chain.get(i).getTimestamp());
			System.out.println("PreviousHash: " + chain.get(i).getPreviousHash());
			System.out.println("Hash: " + chain.get(i).getHash_Value());
			System.out.println();
		}
		
	}
	
	public Block getLatestBlock() {
		return this.chain.get(chain.size()-1);
	}
	
	public void isValid() {
		
		for(int i=chain.size()-1; i>0; i--) {
			if(   !(chain.get(i).getHash_Value().equals(chain.get(i).ComputeHash()))   ) {
				System.out.println("Chain is not valid");
				return;
			}
			
			if(  !(chain.get(i).getPreviousHash().equals(chain.get(i-1).ComputeHash()))  ) {
				System.out.println("Chain is not valid");
				return;
			}
		}
		
		System.out.println("Chain is valid.");
		
	}
	
	
}
