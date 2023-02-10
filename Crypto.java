/**
* This class defines the methods that should be completed as a result
* of the Cryptography project.  Note that all method headers must appear
* exactly as they are shown You may choose to add additional methods.
* 
* Note: You should call lettersOnly at the beginning of every method.
*
* @author Bethany Houser
* @author Gabriela Moffat
* @version 1.0
*/
public class Crypto
{
/**
* Returns a String object that is a copy of cipher with all characters
* that are not letters removed.  (These include spaces and special
* characters.)  All letters should be converted to uppercase letters
* null inputs should return an empty String.
*
* @param  plain  the original message
* @return        the copy of plain with all of the spaces removed
*/
	public static String lettersOnly(String plain)
	{ 
		if (plain == null || plain.equals(""))
		{
			return "";
		}
			
		String str = plain.replaceAll(" ", "").toUpperCase();	
		String spec = ",./?;:'\"[{]}-_=+)(\\|*&" + "^%$#@!`~<>0123456789";
		String letters = "";
			
		for (int i = 0; i < str.length(); i++)
		{
			if (!(spec.contains(str.substring(i, i + 1))))
			{
				letters += str.substring(i, i + 1);
			}
		}
			
		return letters;
			
	} 


	/**
	 * Returns a String object that is a copy of plain with a space
	 * placed after every n characters.  All original spaces are removed.
	 * null inputs should return an empty String.
	 * 
	 * An example of a call to this method is spaceEveryNChars("CAT", 2)
	 * 		this would result in "CA T"
	 * 
	 * @param  plain  the original message
	 * @param  n      the number of characters before a space appears
	 * @return        the copy of plain with a space every n characters
	 */
	public static String spaceEveryNChars(String plain, int n)
	{ 
		String str = lettersOnly(plain);
		if (str == null || str.equals(""))
		{
			return "";
		}
		
		String every = "";
		for (int i = 0; i < str.length(); i++)
		{
			if (i % n == 0 && i > 0)
			{
				every += " ";
				every += str.substring(i, i + 1);
			}
			else 
			{
				every += str.substring(i, i + 1);
			}
		}
		
		return every;
	} 


	/**
	 * Returns a String object that has written plain backwards.
	 * 
	 * @param  plain  the original message
	 * @return        the message written backwards
	 */
	public static String backwards(String plain)
	{
		String str = lettersOnly(plain);
		String b = "";
			
		for (int i = str.length() - 1; i >= 0; i--)
		{
			b += str.substring(i, i + 1);
		}
			
		return b;
	} 

		
	/**
	 * Returns a String with each character shifted by 3.
	 * 
	 * @param  plain  the original message
	 * @return        the message with each character shifted by 3
	 */
	public static String caesarShift(String plain)
	{ 
		String str = lettersOnly(plain);
		String [] alpha = { "A", "B", "C", "D", "E", "F", "G", "H", "I", 
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", 
			"V", "W", "X", "Y", "Z" };
		String caesar = "";
		    
		for (int i = 0; i < str.length(); i++) 
		{
			for (int k = 0; k < alpha.length; k++)
			{
				int ix = 0;
				if (str.substring(i, i + 1).equals(alpha[k]))
				{
					ix = (k + 3) % 26;
					caesar += alpha[ix];
				}
			}
		}
		    
		return caesar;
	}

		
	/**
	 * Returns a String with each character shifted by n.
	 * 
	 * @param  plain  the original message
	 * @param  shift  the number of characters to shift each char in plain
	 * @return        the message with each character shifted by shift
	 */
	public static String caesarShift(String plain, int shift)
	{
		String str = lettersOnly(plain);
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String caesar = "";
		    
		for (int i = 0; i < str.length(); i++) 
		{
			int ix = (alpha.indexOf(str.charAt(i)) + shift) % 26;
			caesar += alpha.charAt(ix);
		}
		    
		return caesar;
	}


	/**
	 * Returns a String with each character shifted by 13.
	 * 
	 * @param  plain  the original message
	 * @return        the message with each character shifted by 13
	 */
	public static String rot13(String plain)
	{
		String str = lettersOnly(plain);
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String caesar = "";
		    
		for (int i = 0; i < str.length(); i++) 
		{
			int pos = alpha.indexOf(str.charAt(i));
			caesar += alpha.charAt((13 + pos) % 26);
		}
		    
		return caesar;
	}

	/**
	 * Returns a String whose letters have been substituted using the alphabet
	 * provided by the 26 letter key.
	 * 
	 * @param  plain  the original message
	 * @param  key    the substitution alphabet
	 * @return        the message with each character replaced using the  
	 *                substitution alphabet
	 */
	public static String substitution(String plain, String key)
	{
		String str = lettersOnly(plain);
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String result = "";
			
		for (int i = 0; i < str.length(); i++)
		{
			int ix = alpha.indexOf(str.charAt(i));
			result += key.charAt(ix);
		}
			
		return result;
	}
		

	/**
	 * Returns a randomly generated key of length n.  Each character of the
	 * String is generated by a random calculation.
	 * 
	 * @param  n  the length of the key to be created
	 * @return    the random key
	 */
	public static String randomKey(int n)
	{
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char rand = alpha.charAt((int)(Math.random() * 26));
		String key = "";
			
		for (int i = 0; i < n; i++)
		{
			key += rand;					
		}
			
		return key;
	}


	/**
	 * Returns a message encrypted using a one time pad.  Each character of
	 * the message should be added to the corresponding character in the key to 
	 * produce the cipher.  If the key length does not match the message
	 * length, the String “Cannot be encrypted” is returned.
	 * 
	 * @param  message the original message
	 * @param  key     the String that will be used to encrypt this message
	 * @return         the encrypted message
	 */
	public static String oneTimePadEncrypt(String message, String key)
	{
		String str = lettersOnly(message);
		String sk = lettersOnly(key);
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String encrypt = "";
			
		if (str.length() != sk.length())
		{
			return "Cannot be encrypted";
		}
		for (int i = 0; i < str.length(); ++i)
		{
			int ix = alpha.indexOf(str.charAt(i)) + alpha.indexOf(sk.charAt(i));
			if (ix > 25)
			{
				ix = ix - alpha.length();
			}
			encrypt += alpha.charAt(ix);
		}
			
		return encrypt;			
	}


	/**
	 * Returns the decrypted message given the cipher and key.  Each character 
	 * of the key should be subtracted from the corresponding character in the 
	 * cipher to produce the message.  If the key length does not match the
	 * length of the cipher, the String “Cannot be decrypted” is returned.
	 *
	 * @param  cipher the encrypted message
	 * @param  key    the String that will be used to decrypt this message
	 * @return        the decrypted message
	 */
	public static String oneTimePadDecrypt(String cipher, String key)
	{
		String str = lettersOnly(cipher);
		String sk = lettersOnly(key);
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String decrypt = "";
			
		if (str.length() != sk.length())
		{
			return "Cannot be decrypted";
		}
		for (int i = 0; i < str.length(); ++i)
		{
			int ix = alpha.indexOf(str.charAt(i)) - alpha.indexOf(sk.charAt(i));
			if (ix < 0)
			{
				ix = alpha.length() + ix;
			}
			decrypt += alpha.charAt(ix);
		}
			
		return decrypt;		
	}
		
		
	/**
	 * Returns a 26 element array with a count of how many times each character
	 * in the cipher occurs.  The first slot of the array corresponds to ‘A’ and
	 * the last corresponds to ‘Z’.
	 * 
	 * @param  cipher the original message
	 * @return        the array with a count of each character
	 */
	public static int[] characterAnalysis(String cipher)
	{
		String str = lettersOnly(cipher);
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int [] counter = new int [26];
			
		for (int i = 0; i < alpha.length(); ++i)
		{
			for (int k = 0; k < str.length(); ++k)
			{
				if (alpha.charAt(i) == str.charAt(k))
				{
					counter[i]++;
				}
			}
		}
			
		return counter;	
	}
		
		/**
		 * CHALLENGE TASK:
		 * Returns a String whose letters have been substituted using 
		 * the Vigenere cipher.
		 * @param   plain  the original message
		 * @param   key    the key that will be used to encrypt the message
		 * @return         the encrypted message
		 * Use the following method header:
		 * public static String vigenere(String plain, String key)
		 * 
		 * Note: This has been commented out for those who do not want  
		 * to complete this challenge task.
		 */
		

}