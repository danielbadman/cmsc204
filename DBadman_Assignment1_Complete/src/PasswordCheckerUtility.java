import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility{
	private static final int MIN_LENGTH = 6;
	private static final int STRONG_LENGTH = 9;
	
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException{
		if (!password.equals(passwordConfirm)) {
			throw new UnmatchedException();
		}
	}
	
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		if (password.equals(passwordConfirm)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isValidLength(String password) throws LengthException {
		if (password.length() < MIN_LENGTH) {
			throw new LengthException();
		}
		return true;
	}
	
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		boolean result = false;
		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
				result = true;
			}
		}
		if (result) {
			return true;
		} else {
			throw new NoUpperAlphaException();
		}
	}
	
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		boolean result = false;
		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
				result = true;
			}
		}
		if (result) {
			return true;
		} else {
			throw new NoLowerAlphaException();
		}
		
	}
	
	public static boolean hasDigit(String password) throws NoDigitException {
		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
				return true;
			}
		}
		throw new NoDigitException();
		
	}
	
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		if (matcher.matches()) {
			throw new NoSpecialCharacterException();
		}
		return true;
	}
	
	public static boolean noSameCharInSequence(String password) throws InvalidSequenceException {
		for (int i = 0; i < password.length() - 2; i++) {
			char c = password.charAt(i);
			if (c == password.charAt(i + 1) && c == password.charAt(i + 2)) {
				throw new InvalidSequenceException();
			}
		}
		return true;
	}
	
	public static boolean isValidPassword​(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {

			if (isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasDigit(password) && hasSpecialChar(password) && noSameCharInSequence(password)) {
				return true;
			} else {
				return false;
			}
	}
	
	public static boolean hasBetweenSixAndNineChars(String password) {
		if (password.length() >= MIN_LENGTH && password.length() <= STRONG_LENGTH) {
			return true;
		} else {
			return false;
		}
	}
	
	@SuppressWarnings("finally")
	public static boolean isWeakPassword(String password) throws WeakPasswordException {
		try {
			isValidLength(password);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			return false;
		} finally {
			if (hasBetweenSixAndNineChars(password)) {
				throw new WeakPasswordException();
			} else {
				return false;
			}
		}
	}
	
	public static ArrayList<String> getInvalidPasswords​(ArrayList<String> passwords) {
		ArrayList<String> invalidPasswords = new ArrayList<>();
		for (int i = 0; i < passwords.size(); i++) {
			try {
				isValidPassword​(passwords.get(i));
			} catch (LengthException e) {
				invalidPasswords.add(passwords.get(i) + " " + e.getMessage());
			} catch (NoUpperAlphaException e) {
				invalidPasswords.add(passwords.get(i) + " " + e.getMessage());
			} catch (NoLowerAlphaException e) {
				invalidPasswords.add(passwords.get(i) + " " + e.getMessage());
			} catch (NoDigitException e) {
				invalidPasswords.add(passwords.get(i) + " " + e.getMessage());
			} catch (NoSpecialCharacterException e) {
				invalidPasswords.add(passwords.get(i) + " " + e.getMessage());
			} catch (InvalidSequenceException e) {
				invalidPasswords.add(passwords.get(i) + " " + e.getMessage());
			}
		}
		return invalidPasswords;
	}
}
