public class Fibonacci{
	public static void main(String[] args){
		int i=1;
		while(fibonacciOf(i)<=200){
			System.out.println(fibonacciOf(i));
			i++;
		}
	}
	public static int fibonacciOf(int n){
		if(n==1 || n==2){
			return 1;
		}else{
			return fibonacciOf(n-1)+fibonacciOf(n-2);
		}
	}
}