package md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TestMd5Hex {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println(makeLine("user1", "user1"));
		System.out.println(makeLine("user2", "user2"));
		System.out.println(makeLine("user3", "user3"));
	}

	private static String makeLine(String userid, String password) throws NoSuchAlgorithmException {
		return userid + "=" + hexMd5(userid + ":ApplicationRealm:" + password);
	}
	
	private static String hexMd5(String s) throws NoSuchAlgorithmException {
		return bytesToHex(bytesToMd5(s.getBytes()));
	}
	
	private static byte[] bytesToMd5 (byte[] b) throws NoSuchAlgorithmException {
		return MessageDigest.getInstance("MD5").digest(b);
	}
	
	private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
        	sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
