package self.practice;

public class KMPPractice {

	public static void main(String[] args) {
		
		String text = "ABABDABACDABABCABAB";
		String pattern = "ABAB";
		
		int n = text.length();
		int m = pattern.length();
		
		int lps[] = new int[m];
		constructLps(lps, m, pattern);
		
		//System.out.println(lps);
		
		int i = 0; int j = 0;
		while(i<n){
			if(text.charAt(i) == pattern.charAt(j)){
				i++;
				j++;
			}
			if(j == m){
				System.out.println("Found pattern at :" + (i-j));
				j = lps[j-1];
			}
			if(i<n && text.charAt(i) != pattern.charAt(j)){
				if(j!=0){
					j = lps[j-1];
				}else{
					i++;
				}
			}
			
		}
		
	}

	private static void constructLps(int[] lps, int m, String pattern) {
		int len = 0;
		lps[0] = 0;
		int i=1;
		
		while(i<m){
			if(pattern.charAt(len) == pattern.charAt(i)){
				len++;
				lps[i] = len;
				i++;
			}
			else{
				if(len!=0){
					len = lps[len-1];
				}else{
					lps[i] = len;
					i++;
				}
				
			}
			
		}
	}
	
}
