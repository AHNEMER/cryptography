import java.io.*;

import java.util.*;

public class cryptography {

	

	public static String encryption(String word, String key, ArrayList<Character> chr) {

		int dec;
		String enc_word = "";
		for (int k = 0, a = 0; k < word.length(); k++, a++) {
			if (a == key.length()) {
				a = 0;
			}

			char ch = word.charAt(k);
			char ch2 = key.charAt(a);
			if (!chr.contains(ch)) {
				enc_word += ch;
				a--;
			} else {
				int IndexOfLetterInWord = chr.indexOf(ch);
				int IndexOfletterInKey = chr.indexOf(ch2);
				dec = (IndexOfLetterInWord + IndexOfletterInKey) % 67;
				ch = chr.get(dec);
				enc_word += ch;
			}

		}
		return enc_word;
	}
	
	public static String decryption(String word, String dec_key, ArrayList<Character> chr) {
		int dec;

		String dec_word = "";

		for (int k = 0, a = 0; k < word.length(); k++, a++) {
			if (a == dec_key.length()) {
				a = 0;
			}
			char ch = word.charAt(k);
			char ch2 = dec_key.charAt(a);

			if (!chr.contains(ch)) {
				dec_word += ch;
				a--;
			} else {
				int IndexOfLetterInWord = chr.indexOf(ch);
				int IndexOfletterInKey = chr.indexOf(ch2);
				dec = (IndexOfLetterInWord + IndexOfletterInKey) % 67;
				ch = chr.get(dec);
				dec_word += ch;
			}
		}

		return dec_word;
	}
	
	

	public static void main(String[] args) throws IOException {
		Character[] arr = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
				'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
				'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7',
				'8', '9', ',', '.', '?', '!', ' ' };
		ArrayList<Character> chr = new ArrayList<>(Arrays.asList(arr));
		File input = new File("input.txt");
		File output = new File("output.dec");
		File outputAfterDec = new File("outputAfterDec.txt");
		Scanner read = new Scanner(input);
		Scanner read2 = new Scanner(output);
		Scanner kb = new Scanner(System.in);
		PrintWriter pwriter = new PrintWriter(output);
		PrintWriter pwriter2 = new PrintWriter(outputAfterDec);
		String key = read.nextLine();
		String word = "";
		String enc_word = "";
		while (read.hasNext()) {
			word = String.format("%s%s%n", word, read.nextLine());

		}

		enc_word = encryption(word, key, chr);

		pwriter.print(enc_word);
		read.close();
		pwriter.close();

		System.out.println("Enter the encryption key: ");
		String enc_key = kb.nextLine();
		String dec_key = "";
		for (int i = 0; i < enc_key.length(); i++) {
			char ch = enc_key.charAt(i);
			int IndexOfLetter = chr.indexOf(ch);
			int dec = (67 - IndexOfLetter) % 67;
			ch = chr.get(dec);
			dec_key += ch;
		}

		String word2 = "";
		String dec_word = "";
		while (read2.hasNextLine()) {
			word2 = String.format("%s%s%n", word2, read2.nextLine());
		}
		
		dec_word = decryption(word2, dec_key, chr);
		pwriter2.println("Decryption key: "+dec_key);
		pwriter2.println(dec_word);
		read2.close();
		pwriter2.close();

	}

}
