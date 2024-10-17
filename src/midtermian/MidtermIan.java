package midtermian;

import java.util.Scanner;

public class MidtermIan {
 
        public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String response;
        
        do{
            System.out.println("-------------------------");
            System.out.println("PAYMENT APPLICATION");
            System.out.println("-------------------------");
            System.out.println("1. ADD PAYMENT");
            System.out.println("2. VIEW PAYMENT");
            System.out.println("3. UPDATE PAYMENT");
            System.out.println("4. DELETE PAYMENT");
            System.out.println("5. EXIT ");
            
            System.out.println("Enter Action: ");
            int action  = sc.nextInt();
             MidtermIan sample = new MidtermIan();
            switch(action){
                case 1:
                    sample.addRecord();
                    break;
                case 2:
                    sample.viewPayment();
                    break;
                case 3:
                    sample.viewPayment();
                    sample.updatePayment();
                    sample.viewPayment();
                    break;
                case 4:
                    sample.viewPayment();
                    sample.deletePayment();
                    sample.viewPayment();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;                   
            }
            
            System.out.println("Do You want to continue? (yes/no): ");
            response = sc.next();
        }while(response.equalsIgnoreCase("yes"));
       
    }
    public void addRecord(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Amount:");
        int pamt = sc.nextInt ();
        System.out.print("Pay Date: ");
        String pdate = sc.next();
        System.out.print("Pay Method: ");
        String pmeth = sc.next();
        System.out.print("Status: ");
        String pstat = sc.next();
        
        String sql = "INSERT INTO payment( p_amt, p_date, p_method, p_status ) VALUES (?, ?, ?, ?)";

        conf.addRecord(sql, pamt, pdate, pmeth, pstat);

        
    }
     public void viewPayment() {
        String qry = "SELECT * FROM payment";
        String[] hdrs = {"ID", "Amount", "PayDate", "Method", "Status"};
        String[] clmns = {"p_id", "p_amt", "p_date", "p_method", "p_status"};

        config conf = new config();
        conf.viewRecords(qry, hdrs, clmns);
    }
     public void updatePayment(){
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter id to update: ");
         int id = sc.nextInt();
         
         System.out.println("New  Amount: ");
         int npamt = sc.nextInt();
         System.out.println("New  Pay Date: ");
         String npdate = sc.next();
         System.out.println("New Pay Method: ");
         String npmeth = sc.next();
         System.out.println("New Status: ");
         String npstat = sc.next();
         
          
         String qry = "UPDATE payment SET p_amt = ?, p_date = ?, p_method = ?, p_status = ? WHERE d_id = ?";
        
         config conf = new config();
        conf.deleteRecord(qry, npamt, npdate, npmeth, npstat, id);
     }
    public void deletePayment(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id to delete:");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM payment WHERE d_id = ?";
        
        config conf = new config();
        conf.deleteRecord(qry, id);
    }
}
        
    
    

