package java_application;
//time complexity for this algorithm is O(n+26)=O(n) where n is the length of the input string.
//space complexity is O(26) to store the boolean values in an array.
public class find_alphabets {
	boolean arr[]=new boolean[26];
	boolean flag=true;
	int j;
	public void check_string(String s) {
		s=s.toLowerCase();
		if(s.length()<26) {
			System.out.println("Input String does not contain all the alphabets!");
			return;
		}
		//iterating through string to check whether all the alphabets exist or not by storing in boolean array
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)>='a' && s.charAt(i)<='z') {
				j=s.charAt(i)-'a';
			}
			arr[j]=true;
		}
		//check the values of boolean array to set flag value.
		for(int i=0;i<26;i++) {
			if(!arr[i]) {
				flag=false;
			}
		}
		if(flag==true) {
			System.out.println("Contain all the alphabets");
		}
		else {
			System.out.println("Input String does not contain all the alphabets");
		}
	}

	public static void main(String[] args) {
		find_alphabets alpha=new find_alphabets();
		alpha.check_string("Abcdefghijklmnopqrstuvwxyz");

	}

}
