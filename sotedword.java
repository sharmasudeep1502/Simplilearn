class abc
{
public static void main(String... args)
{
String s=new String("India China Rusia Austrailia);
String str[]=s.split(" ",0);
for(int i=0;i<str.length;i++)
{
for(int j=0;j<str[i].length;j++)
{
System.out.println(str[i][j]);
}
}
}
}