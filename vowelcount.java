import java.util.Scanner;
class abc
{
	public static void main(String[] args)
	{
		int count = 0;
		System.out.println("Enter the String");
		Scanner sc = new Scanner(System.in);
		String str=sc.nextLine();
		char ch[]=str.toCharArray();
		for(int i=0;i<ch.length;i++)
		{
			if((ch[i]=='a'||ch[i]=='e'||ch[i]=='i'||ch[i]=='o'||ch[i]=='u'))
			{
				count++;
			}
			if((ch[i]=='A'||ch[i]=='E'||ch[i]=='I'||ch[i]=='O'||ch[i]=='U'))
			{
				count++;
			}
		}
		System.out.println("The no of vowels in given String is: "+count);
	}
}