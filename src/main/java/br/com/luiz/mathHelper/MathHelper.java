package br.com.luiz.mathHelper;

public class MathHelper {

	public static Double convertToDouble(String numberStr) {
		if (numberStr == null ) return 0D;
		
		String number = numberStr.replaceAll(",", ".");
		if (isNumeric(number)) return Double.parseDouble(number);
		
		return 0D;
	}

	public static final boolean isNumeric(String numberStr) {
		if (numberStr == null ) return false;
		String number = numberStr.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	public static final boolean isZero(String numberStr) {
		if (numberStr.equals("0")) {
			return true;
		} else {
			return false;
		}
	}
}
