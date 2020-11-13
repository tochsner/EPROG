import java.util.LinkedList;

public class Teilfolgen {

	public static void main(String[] args) {
		String s = "apple";
		int n = 2;

		LinkedList<String> result = teilfolgen(s, n);

		System.out.println(result.size());
	}

	/*
	 * teilfolgen(String s, int n) = teilfolgen(String s[1:], n) + (s[0] &
	 * teilfolgen(String s[1:], int n-1))
	 * 
	 * teilfolgen(s, 1) = {s}
	 * teilfolgen("", n) = {}
	 */
	static LinkedList<String> teilfolgen(String s, int n) {
		if (n == 1) {
			LinkedList<String> result = new LinkedList<>();
			for (int i = 0; i < s.length(); i++) {
				result.add("" + s.charAt(i));
			}
			return result;
		}
		if (s.length() == 0) {
			return new LinkedList<>();
		}		

		LinkedList<String> result = new LinkedList<>();		
		
		result.addAll(teilfolgen(s.substring(1), n));

		LinkedList<String> partialResult = teilfolgen(s.substring(1), n - 1);
		for (int i = 0; i < partialResult.size(); i++) {
			String teilfolge = s.charAt(0) + partialResult.get(i);
			result.add(teilfolge);
		}

		return result;
	}

}
