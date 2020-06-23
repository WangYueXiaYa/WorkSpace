public class Fibonacci{
	public static void main(String[] args){
		int i=1;
		while(of(i)<=200){
			System.out.println(of(i));
			i++;
		}
	}
	public static int of(int n){
		if(n==1 || n==2){
			return 1;
		}else{
			return of(n-1)+ of(n-2);
		}
	}
}