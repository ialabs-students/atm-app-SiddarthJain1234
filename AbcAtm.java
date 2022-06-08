import java.util.Scanner;

public class AbcAtm {

	public static void deposit(int[] arr,Scanner sc) {
		System.out.println("How many notes of 2000?");
		int twoThousandCount=sc.nextInt();
		System.out.println("How many notes of 500?");
		int fiveHundredCount=sc.nextInt();
		System.out.println("How many notes of 200?");
		int twoHundredCount=sc.nextInt();
		System.out.println("How many notes of 100?");
		int hundredCount=sc.nextInt();
		
		if(twoThousandCount<0 || fiveHundredCount<0 || twoHundredCount<0 || hundredCount<0) {
			System.out.println("incorrect deposit amount");
			return;
		}
		if(twoThousandCount==0 && fiveHundredCount==0 && twoHundredCount==0 && hundredCount==0) {
			System.out.println("Deposit amount cannot be zero");
			return;
		}
		arr[0]=twoThousandCount;
		arr[1]=fiveHundredCount;
		arr[2]=twoHundredCount;
		arr[3]=hundredCount;
		
System.out.println("Balance: 2000s="+arr[0]+",500s="+arr[1]+",200s="+arr[2]+",100s="+arr[3]+", Total="+calculateToatal(arr));
		
		
		
	}
	
	private static int calculateToatal(int[] arr) {
		// TODO Auto-generated method stub
		return (arr[0]*2000)+(arr[1]*500)+(arr[2]*200)+(arr[3]*100);
	}

	public static void withdraw(int[] arr,Scanner sc) {
		int cb=calculateToatal(arr);
		System.out.println("Enter amount");
		int amt=sc.nextInt();
		
		if(amt==0 || amt<0 || amt>cb) {
			System.out.println("incorrect or insufficient funds");
			return;
		}
		int twoThousant=0,fiveHundred=0,twoHundred=0,hundred=0;
		
		if(amt/2000>0) {
			twoThousant=amt/2000;
			arr[0]-=twoThousant;
			amt-=twoThousant*2000;
		}
		if(amt/500>0) {
			fiveHundred=amt/500;
			arr[1]-=fiveHundred;
			amt-=fiveHundred*500;
			
		}
		if(amt/200>0) {
			twoHundred=amt/200;
			arr[2]-=twoHundred;
			amt-=twoHundred*200;
			
		}
		if(amt/100>0) {
			hundred=amt/100;
			arr[3]-=hundred;
			amt-=hundred*100;
		}
		
		System.out.println("Dispensed: 2000s="+twoThousant+",500s="+fiveHundred+",200s="+twoHundred+",100s="+hundred);
		
		System.out.println("Balance: 2000s="+arr[0]+",500s="+arr[1]+",200s="+arr[2]+",100s="+arr[3]+", Total="+calculateToatal(arr));

		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//array for holding the denomination 
		int[] arr=new int[4];
		int cb=0;
		Scanner sc=new Scanner(System.in);
		
			System.out.println("0.Exit \n1.Deposit Money \n2.Withdraw money ");
			int input=sc.nextInt();
			
			while(input!=0) {
			if(input==1) {
				deposit(arr,sc);
				cb=calculateToatal(arr);
			}
			else if(input==2) {
				withdraw(arr,sc);
			}
			else {
				break;
			}
			
			System.out.println("0.Exit \n1.Deposit Money \n2.Withdraw money ");
			input=sc.nextInt();
			
			}
		

	}

}
