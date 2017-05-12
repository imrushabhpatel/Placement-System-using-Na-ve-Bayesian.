package placementsystem;

import java.util.*;

public class PlacementSystem{
public static void main(String args[])
	{
//<=30,med,yes,fair
		int i=0,j=0,y=0,n=0,ay=0,incy=0,study=0,credy=0,an=0,incn=0,studn=0,credn=0;
		float tyes,tno;
		String id[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14",null};
		String age[]={"<=30","<=30","31-40",">40",">40",">40","31-40","<=30","<=30",">40","<=30","31-40","31-40",">40",null};
		String income[]={"high","high","high","med","low","low","low","med","low","med","med","med","high","med",null};
		String student[]={"no","no","no","no","yes","yes","yes","no","yes","yes","yes","no","yes","no",null};
		String credit[]={"fair","excellent","fair","fair","fair","excellent","excellent","fair","fair","fair","excellent","excellent","excellent","excellent",null};
		String buy[]={"no","no","yes","yes","yes","no","yes","no","yes","yes","yes","yes","yes","no",null};
		
		System.out.print("Age\tIncome\tStudent\tCredit\t\tBuy-Computer\n");
		for(i=0;i<14;i++)
			System.out.println(age[i]+"\t"+income[i]+"\t"+student[i]+"\t"+credit[i]+"\t\t"+buy[i]);

	Scanner sc=new Scanner(System.in);
	System.out.println("\nEnter the required age, income, student need, credit ranking :");
	String iage=sc.next();
	String iincome=sc.next();
	String istudent=sc.next();
	String icredit=sc.next();
	//System.out.println(iage+" "+iincome+" "+istudent+" "+icredit);
	
	for(i=0;i<=14;i++)
		{
		//for probabilities of yes'
		if(iage.equals(age[i]) && buy[i]=="yes")
			ay++;
		if(iincome.equals(income[i])&&buy[i]=="yes")
				incy++;
		if(istudent.equals(student[i])&&buy[i]=="yes")
			study++;
		if(icredit.equals(credit[i])&&buy[i]=="yes")
			credy++;

		//for probabilities of no's
		if(iage.equals(age[i])&&buy[i]=="no")
			an++;
		if(iincome.equals(income[i])&&buy[i]=="no")
				incn++;
		if(istudent.equals(student[i])&&buy[i]=="no")
			studn++;
		if(icredit.equals(credit[i])&&buy[i]=="no")
			credn++;

		//for yes' and no's
		if(buy[i]=="yes")
			y++;
		if(buy[i]=="no")
			n++;
						
		}
	tyes=((float)ay/y)*((float)incy/y)*((float)study/y)*((float)credy/y)*((float)y/14);
	tno=((float)an/n)*((float)incn/n)*((float)studn/n)*((float)credn/n)*((float)n/14);
	System.out.print("\nP(X|Yes)*P(Yes) : "+tyes+"\nP(X|No)*P(No) : "+tno);

	if(tyes>tno)
		System.out.println("\n\nTherefore, student can buy a computer");
	else System.out.println("\n\nTherefore, student can't buy a computer");
}	
}