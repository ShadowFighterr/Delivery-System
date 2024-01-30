import java.util.Scanner;

public class ReportIssue {

    public static int idxcounter;
    static String[] issues = new String[1000000];

    ReportIssue()
    {
        issues[0] = "Undefined";
        idxcounter = 0;
    }

    public void issues_list()
    {
        if(idxcounter == 0) System.out.println("There are not any issues provided by you!\n");
        else
        {
            for(int i = 0; i < idxcounter; i++)
                    System.out.println(i+1 + ":" + issues[i]);
        }
    }
    static void add_issue(String issue)
    {
        issues[idxcounter] = issue;
        idxcounter++;
    }

    public void make_doubt()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type your issue below.");
        String issue = sc.next();
        add_issue(issue);
        System.out.println("We will analyze and work out your issue. Thank you for understanding!");
    }

}
