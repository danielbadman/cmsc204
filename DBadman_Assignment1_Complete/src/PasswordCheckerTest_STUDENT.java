
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {
	PasswordCheckerUtility util;
	ArrayList<String> goodList;
	ArrayList<String> badList;
	@Before
	public void setUp() throws Exception {
		goodList = new ArrayList<>();
		badList = new ArrayList<>();
		
		goodList.add("3ga6aNe2#1");
		goodList.add("UUuu00oo@@aa");
		goodList.add("J@cks0nAA12");
		goodList.add("Cooked34%");
		goodList.add("SmileMore7!");
		goodList.add("DrainGang*1");
		goodList.add("Snap5&");
				
		badList.add("%tP2");
		badList.add("unme#889");
		badList.add("GREENROOM3#");
		badList.add("212aaaB!B");
		badList.add("BlackRose?");
		badList.add("FuFuFu22");
	}

	@After
	public void tearDown() throws Exception {
		goodList = null;
		badList = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			assertTrue(util.isValidLength(goodList.get(0)));
		} catch (LengthException e) {
			assertFalse(true);
		} catch (Exception e) {
			assertFalse(true);
		}
		try {
			assertFalse(util.isValidLength(badList.get(0)));
		} catch (LengthException e) {
			assertTrue(true);
		} catch (Exception e) {
			assertFalse(true);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test 
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(util.hasUpperAlpha(goodList.get(1)));
		} catch (NoUpperAlphaException e) {
			assertFalse(true);
		} catch (Exception e) {
			assertFalse(true);
		}
		try {
			assertFalse(util.hasUpperAlpha(badList.get(1)));
		} catch (NoUpperAlphaException e) {
			assertTrue(true);
		} catch (Exception e) {
			assertFalse(true);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test 
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(util.hasLowerAlpha(goodList.get(2)));
		} catch (NoLowerAlphaException e) {
			assertFalse(true);
		} catch (Exception e) {
			assertFalse(true);
		}
		try {
			assertFalse(util.hasLowerAlpha(badList.get(2)));
		} catch (NoLowerAlphaException e) {
			assertTrue(true);
		} catch (Exception e) {
			assertFalse(true);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			assertFalse(util.isWeakPassword(goodList.get(0)));
		} catch (WeakPasswordException e) {
			assertFalse(true);
		} catch (Exception e) {
			assertFalse(true);
		}
		try {
			assertFalse(util.isWeakPassword(goodList.get(6)));
		} catch (WeakPasswordException e) {
			assertTrue(true);
		} catch (Exception e) {
			assertFalse(true);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertTrue(util.noSameCharInSequence(goodList.get(3)));
		} catch (InvalidSequenceException e) {
			assertFalse(true);
		} catch (Exception e) {
			assertFalse(true);
		}
		try {
			assertFalse(util.noSameCharInSequence(badList.get(3)));
		} catch (InvalidSequenceException e) {
			assertTrue(true);
		} catch (Exception e) {
			assertFalse(true);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertTrue(util.hasDigit(goodList.get(4)));
		} catch (NoDigitException e) {
			assertFalse(true);
		} catch (Exception e) {
			assertFalse(true);
		}
		try {
			assertFalse(util.hasDigit(badList.get(4)));
		} catch (NoDigitException e) {
			assertTrue(true);
		} catch (Exception e) {
			assertFalse(true);
		}
	}
	
	@Test
	public void testIsValidPasswordNoSpecialCharacterException()
	{
		try {
			assertTrue(util.hasSpecialChar(goodList.get(5)));
		} catch (NoSpecialCharacterException e) {
			assertFalse(true);
		} catch (Exception e) {
			assertFalse(true);
		}
		try {
			assertFalse(util.hasSpecialChar(badList.get(5)));
		} catch (NoSpecialCharacterException e) {
			assertTrue(true);
		} catch (Exception e) {
			assertFalse(true);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		for (String pwd : goodList) {
			try {
				assertTrue(util.isValidPassword​(pwd));
			} catch (Exception e) {
				assertFalse(e.getMessage(), true);
			}
		}
		
		
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() 
	{
		ArrayList<String> invalidList = util.getInvalidPasswords​(badList);
		String [] expected = {"%tP2 The password must be at least 6 characters long", 
		"unme#889 The password must contain at least one uppercase alphabetic character",
		"GREENROOM3# The password must contain at least one lowercase alphabetic character",
		"212aaaB!B The password cannot contain more than two of the same character in sequence",
		"BlackRose? The password must contain at least one digit", 
		"FuFuFu22 The password must contain at least one special character"};
		
		for (int i = 0; i < invalidList.size(); i++) {
			assertEquals(invalidList.get(i), expected[i]);
		}
	}
	
}
