package placementsystem;

import java.sql.*;
import java.util.Scanner;
public class test
     {
   public static void main(String[] args)
            {
                
                int i,j = 0;
            try 
              {
                  Scanner sc = new Scanner(System.in);
              // loading thejdbc odbc driver
              Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
              // creating connection toth data base
              Connection con = DriverManager.getConnection("jdbc:odbc:placement","","");
              Statement st = con.createStatement();
              // create an execute sql command on database    
              ResultSet rs = st.executeQuery("Select * from placement order by ID");
              ResultSetMetaData rsmd = rs.getMetaData();
              // this getColumnCount reurn the number of column in the selected table
              int numberOfColumns = rsmd.getColumnCount();
              
             
              int rows = 13;
              Double ssc[] = new Double[rows];
                Double hsc[] = new Double[rows];
                Double cgpa[] = new Double[rows];
                String atkt[] = new String[rows];
                String qualifies[] = new String[rows];
              
              String temp;
              i=0;
             while (rs.next()) 
                  {
                    temp = rs.getString(2);
                    ssc[i]= Double.parseDouble(temp);
                    
                    temp = rs.getString(3);
                    hsc[i]=Double.parseDouble(temp);
                    
                    temp = rs.getString(4);
                    cgpa[i]=Double.parseDouble(temp);
                    
                    atkt[i] = rs.getString(5);
                  
                    qualifies[i]=rs.getString(6);
                    
                       i++;
                   }
             System.out.println("SSC\tHSC\tCGPA\tATKT\tQualifies");
             for(i=0;i<10;i++)
                System.out.println(ssc[i]+"\t"+hsc[i]+"\t"+cgpa[i]+"\t"+atkt[i]+"\t"+qualifies[i]);
             
            System.out.println("\n\nEnter the Student credentials w.r.t above database ");
            System.out.println("SSC marks: ");
            Double issc=sc.nextDouble();
            System.out.println("HSC marks: ");
            Double ihsc=sc.nextDouble();
            System.out.println("Aggregate CGPA: ");
            Double icgpa=sc.nextDouble();
            System.out.println("Live KT's?: ");
            String iatkt=sc.next();
            int sscY = 0,hscY = 0,cgpaY = 0,atktY = 0,y = 0,n = 0,sscN = 0,hscN = 0,cgpaN = 0,atktN = 0;
            double tyes,tno;
            
            
            
            
            
            for(i=0;i<rows;i++)
		{
		//for probabilities of yes'
		if(Double.compare(issc, ssc[i])>0 || Double.compare(issc, ssc[i])==0 )
                    if( qualifies[i].equalsIgnoreCase("yes"))
                    sscY++;
		if(Double.compare(ihsc, hsc[i])>=0 || Double.compare(ihsc, hsc[i])==0 )
                    if( qualifies[i].equalsIgnoreCase("yes"))
                        hscY++;
		if(Double.compare(icgpa, cgpa[i])>=0 || Double.compare(icgpa, cgpa[i])==0 )
                    if( qualifies[i].equalsIgnoreCase("yes"))
			cgpaY++;
		if(iatkt.equalsIgnoreCase(atkt[i]) && qualifies[i].equalsIgnoreCase("yes"))
			atktY++;

		//for probabilities of no's
		if(Double.compare(issc, ssc[i])>0 || Double.compare(issc, ssc[i])==0 )
                    if( qualifies[i].equalsIgnoreCase("no"))
                    sscN++;
		if(Double.compare(ihsc, hsc[i])>=0 || Double.compare(ihsc, hsc[i])==0 )
                    if( qualifies[i].equalsIgnoreCase("no"))
                        hscN++;
		if(Double.compare(icgpa, cgpa[i])>=0 || Double.compare(icgpa, cgpa[i])==0 )
                    if( qualifies[i].equalsIgnoreCase("no"))
			cgpaN++;
		if(iatkt.equalsIgnoreCase(atkt[i]) && qualifies[i].equalsIgnoreCase("no"))
			atktN++;

		//for yes' and no's
		if(qualifies[i].equalsIgnoreCase("yes"))
			y++;
		if(qualifies[i].equalsIgnoreCase("no"))
			n++;
						
		}
            
        //System.out.println(sscY+" "+hscY+" "+cgpaY+" "+atktY+" "+sscN+" "+hscN+" "+cgpaN+" "+atktN+" "+y+" "+n);
	tyes=((double)sscY/y)*((double)hscY/y)*((double)cgpaY/y)*((double)atktY/y)*((double)y/rows);
	tno=((double)sscN/n)*((double)hscN/n)*((double)cgpaN/n)*((double)atktN/n)*((double)n/rows);
	System.out.print("\nP(X|Yes)*P(Yes) : "+tyes+"\nP(X|No)*P(No) : "+tno);

	if(tyes>tno)
		System.out.println("\n\nTherefore, student qualifes for placement");
	else System.out.println("\n\nTherefore, student doesn't qualifes for placement");
            
            
            
            st.close();
            con.close();
               } catch (ClassNotFoundException | SQLException | NumberFormatException ex)
                         {
                      System.err.print("Exception: ");
                      System.err.println(ex.getMessage());
                         }
            
       }
}
