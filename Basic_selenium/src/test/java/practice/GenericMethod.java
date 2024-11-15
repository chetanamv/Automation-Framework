package practice;

public class GenericMethod {

	public static void main(String[] args) {
		
		
		 int sum = add(3,5);
		 System.out.println(sum);
		 int sum1 = add(2,3,4);
System.out.println(sum1);
	}
public static int add(int a,int b)
{
	int c=a+b;
	return c;
	

	
}

public static int add(int a,int b,int s)
{
	int c=a+b+s;
	return c;
	

	
}
}
