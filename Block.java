package Blockchain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

public class Block {
	private String Hash_Detail;
	private String model;
	private Date Timestamp;
	private String Hash_Value;
	private String PreviousHash;
	private int nonce;


	public Block(String version, Date timestamp, String Hash_Detail, int nonce) {
		this.model = version;
		this.Timestamp = timestamp;
		this.Hash_Detail = ComputeHash();
		this.nonce = nonce;
	}

	public String ComputeHash() {

		String infoToHash = "" + this.model + this.Timestamp + this.PreviousHash + this.Hash_Detail + this.nonce;
		MessageDigest digest;
		String encode = null;

		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(infoToHash.getBytes(StandardCharsets.UTF_8));
			encode = Base64.getEncoder().encodeToString(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		this.Hash_Value = encode;
		return encode;
	}

	public String getVersion() {
		return model;
	}
	public void setVersion(String version) {
		this.model = version;
	}
	public Date getTimestamp() {
		return Timestamp;
	}
	public void setTimestamp(Date timestamp) {
		Timestamp = timestamp;
	}

	public String getHash_Value() {
		return Hash_Value;
	}

	public void setHash_value(String Hash_Value) {
		this.Hash_Value = Hash_Value;
	}

	public String getPreviousHash() {
		return PreviousHash;
	}

	public void setPreviousHash(String previousHash) {
		this.PreviousHash = previousHash;
	}

	public String getHash_Detail() {
		return Hash_Detail;
	}

	public void setHash_Detail(String Hash_Detail) {
		this.Hash_Detail = Hash_Detail;
	}
	public int getNonce() {
		return nonce;
	}
	public void setNonce (int nonce) {
		this.nonce = nonce;
	}
}
