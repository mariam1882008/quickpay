import java.util.Scanner;
public class quickpay1{
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        LogIn();
        int choice;
        do {
            System.out.println("Welcome to QUICK PAY ");
            System.out.println("1. User");
            System.out.println("2. Admin");
            System.out.println("3. Exit");
            System.out.print("Choose:Enter a Number ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    userMenu();
                    break;
                case 2:
                    adminMenu();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice");
                    return;
            }

        } while (choice != 3);
    }





    static void userMenu() {
        int choice;
        do {
            System.out.println("\n===== USER MENU =====");
            System.out.println("1. Show Balance");
            System.out.println("2. Transfer Money");
            System.out.println("3. Transaction History");
            System.out.println("4. Add Favourite");
            System.out.println("5. Remove Favourite");
            System.out.println("6. Show Favourites");
            System.out.println("7. Search Recipient");
            System.out.println("8. View Profile");
            System.out.println("9. Update Profile");
            System.out.println("10. logout");
            System.out.print("Choose: Enter a number ");

            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Show Balance");

                    showBalance();
                    break;
                case 2:
                    System.out.println("Transfer Money");
                    TransferMoney();
                    break;
                case 3:
                    System.out.println("Transaction History");
                    showTransactionHistoryuser();
                    break;
                case 4:
                    System.out.println("Add Favourite");
                    AddFavourite();

                    break;
                case 5:
                    System.out.println("Remove Favourite");
                     RemoveFavourite();
                    break;
                case 6:
                    System.out.println("Show Favourites");
                    Showfavourites();
                    break;

                case 7:
                    System.out.println("7. Search Recipient");
                    //دى الحاجة الوحيدة اللى مش عاملين لها ميثود منفصلة بس جوةميثود التحويلات
                    TransferMoney();
                   break;

                case 8:
                    System.out.println("8. View Profile");
                    ViewUserDetails(FileUsers);
                    break;
                case 9:
                    System.out.println("9. Update Profile");
                    update(FileUsers);
                    break;
                case 10:
                    System.out.println("Returning to main menu");
                    //هنا مش عارفة استدعى ايه*********************
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 10);
    }

    static void adminMenu() {
        int choice;
        do {
            System.out.println("======== ADMIN MENU ========");
            System.out.println("1. System Statistics");
            System.out.println("2. Search for User");
            System.out.println("3. View All Users");
            System.out.println("4. Update User");
            System.out.println("5. View All Transactions");
            System.out.println("6. Show Blocked Accounts");
            System.out.println("7. Show Active  Accounts");
            System.out.println("8. View User Detalis");
            System.out.println("9. loug out");
            System.out.print("Choose: Enter a number ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("System Statistics");
                    ShowStatistics(FileUsers);
                    break;
                case 2:
                    System.out.println("Search for User");

                    break;
                case 3:
                    System.out.println("View All Users");
                    ViewAllUsers();
                    break;
                case 4:
                    System.out.println("Update User");
                    update(FileUsers);
                    break;
                case 5:
                    System.out.println("View All Transactions");
                    showTransactionHistory();
                    break;
                case 6:
                    System.out.println("Blocked Accounts");
                    BlockAccount(FileUsers);
                    break;
                case 7:
                    System.out.println("Active Accounts");
                    UnBlockAccount(FileUsers);
                    break;
                case 8:
                    System.out.println("View User Detalis");
                    ViewUserDetails(FileUsers);
                case 9:
                    System.out.println("Returning to main menu");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 9);
        // File Users
    }

    static String[][] FileUsers = {
            {" mariam", "1", "01012345671", "mariam@gmail.com", "Active" , "1234"},
            {"kholoud", "2", "01012345672", "kholoud@gmail.com", "Active","5678"},
            {"ahmed", "3", "01012345673", "ahmed@gmail.com","Blocked","91011"},
            {"yassin", "4", "01012345674", "yassin@gmail.com","Blocked","1213"}};
//***************************
     static int userCount=4;
public static void signUp() {
    Scanner input = new Scanner(System.in);
    System.out.println("--------- Sign Up ---------");
    System.out.println("Enter name:");
    String name = input.nextLine();

    System.out.println("Enter ID:");
    String id = input.nextLine();

    System.out.println("Enter phone number:");
    String phone = input.nextLine();

    System.out.println("Enter email:");
    String email = input.nextLine();

    System.out.println("Enter password");
    String password = input.nextLine();

    // بتشيك على عدم تكرار الإيميل
    for (int i = 0; i < userCount; i++) {
        if (FileUsers[i][3].equals(email)) {
            System.out.println("Error: Email already exists!");
            return;
        }
    }

    // لو الإيميل مش موجود، بنضيف المستخدم الجديد مع الباقي في FileUsers array
    if (userCount < FileUsers.length) {
        FileUsers[userCount][0] = name;
        FileUsers[userCount][1] = id;
        FileUsers[userCount][2] = phone;
        FileUsers[userCount][3] = email;
        FileUsers[userCount][4] = "Active";
        FileUsers[userCount][5] = password;
        balance[userCount] = 500.0; // تم تعديلها لقوس مربع

        userCount++;
        System.out.println("Sign up successful! You can now log in.");

    } else {
        System.out.println("Users list is full!");
    }
}










//**************************************
static boolean[][]favourites=new boolean[4][4];

    static void AddFavourite() {
        System.out.print("Enter your ID: ");
        int userID=input.nextInt();
        System.out.print("Enter favourite ID: ");
        int favID=input.nextInt();
        if(userID<1||userID>4|| favID<1||favID>4){
            System.out.println("Invalid ID");
        }else if(userID==favID){
            System.out.println("You cannot add yourself");
        }else if(FileUsers[favID-1][4].equals("Blocked")){
            System.out.println("This account is blocked");
        }else if(FileUsers[userID-1][4].equals("Blocked")){
            System.out.println("Your account is blocked");
        }else if(favourites[userID-1][favID-1]){
            System.out.println("Already in favourites");
        }else{
            favourites[userID-1][favID-1]=true;
            System.out.println("Add successfully");
        }
    }
    static void RemoveFavourite() {
        System.out.print("Enter your ID: ");
        int userID=input.nextInt();
        System.out.print("Enter removed ID: ");
        int removeID=input.nextInt();
        if(userID<1||userID>4||removeID <1||removeID>4){
            System.out.println("Invalid ID");
        }else if(userID==removeID){
            System.out.println("You cannot remove yourself");
        }else if(FileUsers[removeID-1][4].equals("Blocked")){
            System.out.println("This account is blocked");
        }else if(FileUsers[userID-1][4].equals("Blocked")){
            System.out.println("Your account is blocked");
        }else if(!favourites[userID-1][removeID-1]){
            System.out.println("Not in favourites ");
        } else{
            favourites[userID-1][removeID-1]=false;
            System.out.println("Removed successfully");
        }
    }
    static void ViewAllUsers(){
        for(int i=0;i<FileUsers.length;i++){
            System.out.println("User"+(i+1));
            for(int j=0;j<FileUsers[i].length;j++){
                System.out.print(FileUsers[i][j]+" ");
            }System.out.println();
        }
    }
    static void Showfavourites(){
        System.out.println("Enter your ID: ");
        int userID=input.nextInt();
        if(userID<1||userID>4){
            System.out.println("Invalid ID");
            return;
        }
        boolean Found=false;
        for(int j=0;j<FileUsers.length;j++){
            if(favourites[userID-1][j]){
                System.out.println(FileUsers[j][0]);
                Found=true;
            }
        }if(!Found){
            System.out.println("Not Favourites yet");
        }
    }




        static double[] balance = {1000, 700, 500, 300};

        static int[] transactionID = new int[100];
        static String[] sender = new String[100];
        static String[] receiver = new String[100];
        static double[] amount = new double[100];
        static String[] status = new String[100];
        static int transactionCount = 0;
        static int successfulCount = 0;
        static int failedCount = 0;

        // مثلا دا الإيميل بتاع الشخص اللي عامل دخول حالياً في التطبيق وعايز يعرف ال balance بتاعه
        static String loggedInUser = "kholoud@gmail.com";

        public static void RecordTransaction(int id, String from, String to, double money, String result) {
            if (transactionCount < transactionID.length) {
                transactionID[transactionCount] = id;
                sender[transactionCount] = from;
                receiver[transactionCount] = to;
                amount[transactionCount] = money;
                status[transactionCount] = result;
                System.out.println("----------Record Transaction-----------");
                System.out.println("id: " + transactionID[transactionCount]);
                System.out.println("from: " + sender[transactionCount]);
                System.out.println("to: " + receiver[transactionCount]);
                System.out.println("money: " + amount[transactionCount]);
                System.out.println("result: " + status[transactionCount]);
                System.out.println("successfulCount: " + successfulCount);
                System.out.println("failedCount: " + failedCount);
                transactionCount++;
            } else {
                System.out.println("Transaction history is full!");
            }
        }
        public static  void SearchRecipient(){
            Scanner inout = new Scanner(System.in);
            boolean found=false;
           System.out.println("*********Search Recipient********");
            System.out.println("Enter recipient ID OR email ");
            String keyword = input.nextLine();
            for(int i=0 ; i<FileUsers.length ;i++){
                if(FileUsers[i][1].equalsIgnoreCase(keyword) || FileUsers[i][3].equalsIgnoreCase(keyword)){
                 found = true;
                    System.out.println(" -------The Recipient is found-------");
                    System.out.println(" * Recipient information :");
                    System.out.println("Name : " +FileUsers[i][0]);
                    System.out.println("ID :"    +FileUsers[i][1]);
                    System.out.println("Phone number : " + FileUsers[i][2]);
                    System.out.println("Email : " + FileUsers[i][3]);
                    System.out.println("Status : " +FileUsers[i][4]);
                    System.out.println("Password : " +FileUsers[i][5]);
                    break;
                }
            }
            if(!found){
                System.out.println("OOPS!!! NO recipient found ");

            }


        }


        // ال method دي بتحول الفلوس من اللي باعت ل اللي هيستلم بشرط انه يحقق شويه حاجات
        public static void TransferMoney() {
            System.out.println("enter sender email");
            sender[transactionCount] = input.next();
            //حطيتهم ف array عشان يبقى كل حاجه بتخص التحويل في نفس ال index
            System.out.println("enter receiver email");
            receiver[transactionCount] = input.next();


            boolean senderFound = false;
            for (String[] fileUser : FileUsers) {
                if (fileUser[3].equals(sender[transactionCount])) {
                    senderFound = true;
                    break;
                }
            }

            if (senderFound) {
                System.out.println("Sender email is registered");
            } else {
                System.out.println("Sender email is not registered");
            }

            boolean receiverFound = false;
            for (int i = 0; i < FileUsers.length; i++) {
                if (FileUsers[i][3].equals(receiver[transactionCount])) {
                    receiverFound = true;
                    break;
                }
            }
            if (receiverFound) {
                System.out.println("Receiver email is registered");
            } else {
                System.out.println("Receiver email is not registered");
            }

            //شروط التحويل
            if (!senderFound || !receiverFound) {
                System.out.println("Invalid email");
                failedCount++;
                return;
            }
            if (sender[transactionCount].equals(receiver[transactionCount])) {
                System.out.println("Cannot transfer to yourself");
                failedCount++;
                return;
            }
            System.out.println("Enter amount:");
            amount[transactionCount] = input.nextDouble();


            if (amount[transactionCount] <= 0) {
                System.out.println("Invalid amount");
                failedCount++;
                return;
            }
            boolean active = false;
            boolean enoughBalance = false;
//  Check  sender
            for (int i = 0; i < FileUsers.length; i++) {
                if (FileUsers[i][3].equals(sender[transactionCount])) {
                    if (FileUsers[i][4].equals("Active")) {
                        active = true;
                        if (amount[transactionCount] <= balance[i]) {
                            enoughBalance = true;
                        }
                    }
                }
            }
            if (!active) {
                System.out.println("Account is blocked");
                failedCount++;
                return;
            }
            if (!enoughBalance) {
                System.out.println("Insufficient balance");
                failedCount++;
                return;
            }
            // Check receiver status
            boolean receiverActive = true;
            for (int i = 0; i < FileUsers.length; i++) {
                if (FileUsers[i][3].equals(receiver[transactionCount])) {
                    if (FileUsers[i][4].equals("Blocked")) {
                        receiverActive = false;
                    }
                }
            }

            if (!receiverActive) {
                System.out.println("Receiver account is blocked");
                failedCount++;
                return;
            }

// بنقلل الفلوس من ال sender
            for (int i = 0; i < FileUsers.length; i++) {
                if (FileUsers[i][3].equals(sender[transactionCount])) {
                    balance[i] = balance[i] - amount[transactionCount];
                    System.out.println("balance sender now" + balance[i]);
                }
            }
// بنزودهم هنا
            for (int i = 0; i < FileUsers.length; i++) {
                if (FileUsers[i][3].equals(receiver[transactionCount])) {
                    balance[i] = balance[i] + amount[transactionCount];
                    System.out.println("balance receiver now" + balance[i]);
                }
            }
            System.out.println("Transfer successful!");
            successfulCount++;
            //بستدعي الميثود دي عشان تسجل العمليه
            RecordTransaction(transactionCount + 1, sender[transactionCount], receiver[transactionCount], amount[transactionCount], "Successful");
        }


        // method  بتعرض كل العمليات القديمه تخص الادمن
        public static void showTransactionHistory() {
            System.out.println("--------- All Transactions History ---------");
            if (transactionCount == 0) {
                System.out.println("No transactions found.");
                return;
            }

            for (int i = 0; i < transactionCount; i++) {
                System.out.println("Transaction ID: " + transactionID[i]);
                System.out.println("From: " + sender[i]);
                System.out.println("To: " + receiver[i]);
                System.out.println("Amount: " + amount[i]);
                System.out.println("Status: " + status[i]);
                System.out.println("----------------------------------");
            }
        }


        //بتعرض رصيد ال user اللي مسجل log in حاليا
        public static void showBalance() {
            System.out.println("--------- Your Balance ---------");
            for (int i = 0; i < FileUsers.length; i++) {
                // loggedInUser هو متغير فيه إيميل الشخص اللي عامل دخول حالياً
                if (FileUsers[i][3].equals(loggedInUser)) {
                    System.out.println("Current Balance: " + balance[i]);
                    return;
                }
            }
        }
//****************
public static void search_user (String[]emails, String[]user_names,int[] Ids, String[] phone_numbers, Scanner
        input){
    System.out.println("please enter the email you want to search for.");
    String email_search = input.next();
    boolean search_by_user = false;
    int s = 0;
    for (int i = 0; i < emails.length; i++) {

        if (email_search.equals(emails[i])) {
            search_by_user = true;
            s = i;
        }
    }
    if (search_by_user == true) {
        System.out.println("Account found\n↓Account Details↓");
        System.out.println("email: " + emails[s]);
        System.out.println("user: " + user_names[s]);
        System.out.println("id: " + Ids[s]);
        System.out.println("phone number: " + phone_numbers[s]);
        System.out.println("Balance and password are only visible to admin.");
    } else System.out.println("account does not exist");
}
//************
public static void account_details_user (String[]emails, String[]passwords, String[]phone_numbers, String[]
        user_names, Scanner input){
    System.out.println("please enter your email.");
    String user_email = input.next();
    boolean search_by_user = false;
    int id = 0, i = 0;

    for (i = 0; i < emails.length; i++) {
        if (user_email.equals(emails[i])) {
            search_by_user = true;
            id = i;
        }
    }

    if (search_by_user == true) {
        System.out.println("enter your password.");
        String password_user_details = input.next();
        if (passwords[id].equals(password_user_details)) {
            System.out.println("email:" + emails[id]);
            System.out.println("password:" + passwords[id]);
            System.out.println("user:" + user_names[id]);
            System.out.println("balance:");
            System.out.println("phone number:" + phone_numbers[id]);
        } else
            do {
                System.out.println("password does not match, please try again.");
                password_user_details = input.next();
            } while (!password_user_details.equals(passwords[id]));
        System.out.println("email:" + emails[id]);
        System.out.println("password:" + passwords[id]);
        System.out.println("user:" + user_names[id]);
        System.out.println("balance:");
        System.out.println("phone number:" + phone_numbers[id]);
    }
}






    //******************
        //الميثود دي بتعرض كل العمليات اللي تخص اليوزر
        public static void showTransactionHistoryuser() {
            System.out.println("--------- Your Transaction History ---------");
            boolean found = false;

            for (int i = 0; i < transactionCount; i++) {
                // بنشيك لو اليوزر الحالي هو sender أو receiver في العملية دي
                if (sender[i].equals(loggedInUser) || receiver[i].equals(loggedInUser)) {
                    System.out.println("Transaction ID: " + transactionID[i]);
                    System.out.println("From: " + sender[i]);
                    System.out.println("To: " + receiver[i]);
                    System.out.println("Amount: " + amount[i]);
                    System.out.println("Status: " + status[i]);
                    System.out.println("----------------------------------");
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No transactions found for your account.");
            }
        }


        public static void ViewUserDetails(String[][] FileUsers) {//انا بدات من هنا اكمل على شغل احمد
            System.out.println("Enter your ID");
            String ID = input.nextLine();
            boolean searchid = false;
            for (int i = 0; i < FileUsers.length; i++) {
                if (FileUsers[i][1].equals(ID)) {
                    System.out.println("-------User Details -------");
                    System.out.println("name :" + FileUsers[i][0]);
                    System.out.println("ID :" + FileUsers[i][1]);
                    System.out.println("phone number :" + FileUsers[i][2]);
                    System.out.println("Email :" + FileUsers[i][3]);
                    searchid = true;
                }
            }
            if (searchid == false)
                System.out.println("This ID not found");

        }

        public static void BlockAccount(String[][] FileUsers) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter ID to block ");//هنا عشان الadmin يحول اى اكونت و يخليه Blocked
            String ID = input.nextLine();
            int blocked =0;
            boolean found = false;
            for(int m = 0;m<FileUsers.length;m++){
                if(FileUsers[m][1].equals(ID)){
                    found=true;
                    FileUsers[m][4]="Blocked" ;

                }
            }
            if(!found){
                    System.out.println("OPPS!!! we can't find this ID");
                    return;
            }
            for (int i = 0; i < FileUsers.length; i++) {//هنا احنا عايزين نعرض عدد الحسابات اللى اتعملها بلوك
                if (FileUsers[i][4].equals("Blocked")) {
                    System.out.println(FileUsers[i][0] + " is a blocked account");
                    blocked++;
                }
            }

            System.out.println("Total Blocked account : " + blocked);


        }

        public static void UnBlockAccount(String[][] FileUsers) {
            Scanner input = new Scanner(System.in);
            System.out.println(" **Enter ID to active** ");//هنا عشان الadmin يحول اى اكونت و يخليه active
            String ID = input.nextLine();
            int active = 0;
            boolean found = false;
            for(int m = 0;m<FileUsers.length;m++) {
                if (FileUsers[m][1].equals(ID)) {
                    found = true;
                    FileUsers[m][4] = "Active";

                }
            }
            if(!found){
                System.out.println("OPPS!!! we can't find this ID");
                return;
            }
            for (int i = 0; i < FileUsers.length; i++) {//هنا عشان نطبع عدد الاكونتات الاكتيف
                if (FileUsers[i][4].equals("Active")) {
                    System.out.println(FileUsers[i][0] + " is an Active  account");
                    active++;
                }
            }
            System.out.println("Total active account : " + active);
        }

        public static void ShowStatistics(String[][] FileUsers) {
            int totalusers = FileUsers.length;
            int activeusers = 0;
            int blockedusers = 0;
            for (int i = 0; i < FileUsers.length; i++) {
                if (FileUsers[i][4].equals("Active")) {
                    activeusers++;
                } else {
                    blockedusers++;
                }
            }

            System.out.println("=========System Statistics========");
            System.out.println("Total Users : " + totalusers);
            System.out.println("Active Users : " + activeusers);
            System.out.println("Blocked Accounts : " + blockedusers);
            //add transictions
            //successful transictions
            //failed transictions
            //total successfui amount
            System.out.println("Total successful trasictions are : " + successfulCount);
            System.out.println("Total failed transictionds are : " + failedCount);
            System.out.println("Total Transictions are : "+ transactionCount);
            System.out.println("Total  amount transfered is :  " + amount);
        }

        public static void LogIn() {//هنا مش لازم نعمل الاراى ك  input
            Scanner input = new Scanner(System.in);
            System.out.println("Enter your Email or ID ");
            String login = input.nextLine();
            for (int i = 0; i < FileUsers.length; i++) {
                if (FileUsers[i][1].equals(login) || FileUsers[i][3].equals(login)) {
                    if (FileUsers[i][4].equals("Blocked")) {
                        System.out.println(" !!!ERROR :You can't log in , your account is blocked , PLEASE contact the admin");
                        break;
                    }else {
                        System.out.println("Enter your password");
                        String password = input.nextLine();
                        if (FileUsers[i][5].equals(password)) {
                            System.out.println("SUCCESSFUL LOG IN >_<" + "WELCOME : " + FileUsers[i][0]);
                            userMenu();//  بعد نجاح التسجيل هنوجه ال user لل userMenu
                            break;
                        } else {
                            System.out.println(" OOPS !! incorrect password");//هنخلى ال user يرجع يكتب ال password تانى
                            break;
                        }
                    }
            }
            }
        }

        public static void update(String[][] FileUsers) {//دى ميثود الابديت
            Scanner input = new Scanner(System.in);
            System.out.println("Enter ID to update :");
            int inputID = input.nextInt();
            if (inputID < 1) {
                System.out.println("ERROR !! you entered a negative ID");
                System.out.println("choose a number : \n 1.Admin \n 2.User");
                int num = input.nextInt();//ده عشان اللى بيعمل ابديت يختار هو ايه
                if (num != 1 && num != 2) {
                    System.out.println("!!!!!ERROR!!!!");
                    return;
                } else if (num == 1) {
                    adminMenu();
                } else {
                    userMenu();
                }
            }
            boolean found = false;
            for (int i = 0; i < FileUsers.length; i++) {//دى for loop  بتعمل بحث عن ال id
                if (FileUsers[i][1].equals(String.valueOf(inputID))) {//هنا حولت القيمة ل  string  عشان نعرف نقارن
                    found = true;
                    System.out.println("choose a number : What do  you want to update : 1.Name \n 2.password \n 3.email \n 4.Phone Number");
                    int number = input.nextInt();
                    if (number < 1 || number > 4) {
                        System.out.println("!!!!!ERROR!!!!!!");
                        return;
                    } else {
                        input.nextLine();
                        int choice;
                        switch (number) {
                            case 1:
                                System.out.println("Enter your updated name");
                                String name = input.nextLine();
                                for (int j = 0; j < FileUsers.length; j++) {
                                    if (j != i && FileUsers[j][0].equals(name)) {// فائدة الجزء الاول من ال  if  ان لو الشخص دخل نفس معلوماته ميعملش ايرور
                                        System.out.println("You entereted a repeated name");
                                        return;
                                    }
                                }
                                FileUsers[i][0] = name;
                                System.out.println("Name abdated successfuly \n your new name is : " + name);
                                break;
                            case 2:
                                System.out.println("Enter your updated password :");
                                String password = input.nextLine();
                                for (int n = 0; n < FileUsers.length; n++) {
                                    if (n != i && FileUsers[n][5].equals(password)) {// فائدة الجزء الاول من ال  if  ان لو الشخص دخل نفس معلوماته ميعملش ايرور لان  i بتعبر عن الصف للشخص اللى بيعمل update
                                        System.out.println("You entereted a repeated password");
                                        return;
                                    }
                                }
                                FileUsers[i][5] = password;
                                System.out.println("password abdated successfuly \n your new passsword is : " + password);
                                break;
                            case 3:
                                System.out.println("Enter ypur new Email");
                                String email = input.nextLine();
                                for (int m = 0; m < FileUsers.length; m++) {
                                    if (m != i && FileUsers[m][3].equals(email)) {// فائدة الجزء الاول من ال  if  ان لو الشخص دخل نفس معلوماته ميعملش ايرور
                                        System.out.println("You entereted a repeated email");
                                        return;
                                    }
                                }
                                FileUsers[i][3] = email;
                                System.out.println("Email abdated successfuly \\n your new email is : " + email);
                                break;
                            case 4:
                                System.out.println("Enter your phone number ");
                                String phone = input.nextLine();
                                for (int t = 0; t < FileUsers.length; t++) {
                                    if (t != i && FileUsers[t][2].equals(phone)) {// فائدة الجزء الاول من ال  if  ان لو الشخص دخل نفس معلوماته ميعملش ايرور
                                        System.out.println("You entereted a repeated phone number");
                                        return;
                                    }
                                }
                                FileUsers[i][2] = phone;
                                System.out.println(" phone number abdated successfuly \n your new  phone number is : " + phone);
                                break;
                        }
                        break; // اول ما يدخل البيانات نطلع بره اللوب
                    }
                }
                if (!found)
                    System.out.println("!!! This ID not found");

            }

        }



}