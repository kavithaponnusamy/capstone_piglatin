package capstone_piglatin;

import java.util.Scanner;

public class CapStone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr = new Scanner(System.in);
		String again, line, temp, word;
		String finalRes = "";
		do {
			finalRes = "";
			System.out.println("Enter a line to be translated: ");
			line = scnr.nextLine();
			temp = line;
			if (line.equals("")) {
				System.out.println("No value entered. Please enter the text for translating!");
			} else {
				// split the line into words..
				do {
					word = "";
					if (temp.startsWith(" ")) {
						temp = temp.substring(1);
					} else {
						temp = temp.substring(0);
					}
					if (temp.contains(" ")) {
						word = temp.substring(0, temp.indexOf(" "));
						temp = temp.substring(temp.indexOf(" "));
					} else {
						word = temp.substring(0);
						temp = "";
					}

					if (containsNumSym(word)) {
						finalRes += word;
					} else if (containsVowels(word)) {

						if (startsWithVowels(word)) {
							word += "way";
							finalRes += word;
						} else {
							for (int j = 0; j < word.length(); j++) {
								if ((word.toLowerCase().charAt(j) == 'a') || (word.toLowerCase().charAt(j) == 'e')
										|| (word.toLowerCase().charAt(j) == 'i')
										|| (word.toLowerCase().charAt(j) == 'o')
										|| (word.toLowerCase().charAt(j) == 'u')) {
									finalRes += word.substring(j, word.length()) + word.substring(0, j) + "ay";
									break;
								}
							}
						}
					} else {
						finalRes += word;
					}
					finalRes = finalRes + " ";
				} while (temp.contains(" "));
				finalRes = finalRes.substring(0, finalRes.length() - 1);// to remove the final space.
				System.out.println(finalRes);
			} // else

			System.out.println("Translate another word?(y/n): ");
			again = scnr.nextLine();
		} while (again.equalsIgnoreCase("y"));
		System.out.println("Thanks for using the Translator application!");
		scnr.close();
	}

	public static boolean containsVowels(String word) {
		if (word.toLowerCase().contains("a") || word.toLowerCase().contains("e") || word.toLowerCase().contains("i")
				|| word.toLowerCase().contains("o") || word.toLowerCase().contains("u")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean startsWithVowels(String word) {
		if (word.toLowerCase().startsWith("a") || word.toLowerCase().startsWith("e")
				|| word.toLowerCase().startsWith("i") || word.toLowerCase().startsWith("o")
				|| word.toLowerCase().startsWith("u")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean containsNumSym(String word) {
		for (int i = 0; i < word.length(); i++) {
			if ((word.charAt(i) >= 65 && word.charAt(i) <= 90) || (word.charAt(i) >= 97 && word.charAt(i) <= 122)
					|| word.charAt(i) == '.' || word.charAt(i) == ',' || word.charAt(i) == ':' || word.charAt(i) == ';'
					|| word.charAt(i) == '?' || word.charAt(i) == '(' || word.charAt(i) == ')' || word.charAt(i) == '['
					|| word.charAt(i) == ']' || word.charAt(i) == '"' || word.charAt(i) == '\'' || word.charAt(i) == '!'
					|| word.charAt(i) == '-' || word.charAt(i) == '_' || word.charAt(i) == '/') {
				continue;
			} else {
				return true;
			}
		}
		return false;
	}
}
