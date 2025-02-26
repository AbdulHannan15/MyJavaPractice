import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

public class Todo_App {
    //use for terminal input operation.
    private Scanner scanner = new Scanner(System.in);

    //use to store,create,delete or update data of user.
    private Vector<Todo_datatype> todo=new Vector<>(50);

    //this is a constructor which auto print these lines whenever class object instantiate
    public Todo_App() {
        System.out.println("************************************************");
        System.out.println("************** Welcome to Note++ ***************");
        System.out.println("************************************************");
    }

    //This function provide what type of functionalities this app can provide
    public void app_1stPage() {
        System.out.println("press 1, Add new note.");
        System.out.println("press 2, Search Note.");
        System.out.println("press 3, View All note");
        System.out.println("press 4, Exit.");
    }

    //newNote return an object of todo_Datatype which we can add in our vector
    public Todo_datatype newNote() {
        Todo_datatype t=new Todo_datatype();
        String title, data = "";
        int year, day, month;
        System.out.println("Enter Title : ");
        title = scanner.nextLine();
        t.setTitle(title);
        System.out.println("Enter Data : ");
        t.setDataManual(data);
//        String tempData;
//        do {
//            System.out.println("Press '-000' to end writing.");
//            tempData = scanner.next();
//            data = data.concat(tempData);
//        } while (!Objects.equals(tempData, "-000"));
        System.out.println("Enter year :");
        year = scanner.nextInt();
        System.out.println("Enter month : ");
        month = scanner.nextInt();
        System.out.println("Enter date : ");
        day = scanner.nextInt();
        return t;
    }

    //this function use to sow all available list that user save in vector

    public void viewAll() {
        int i = 1;
        for (Todo_datatype t : todo) {
            System.out.println(i + ".\n" + t);
            i++;
        }
        System.out.println(todo.get(3));
    }

    //this function search a specific data on stored at given date provided by user.
    public void searchByTime(){
        System.out.println("Enter year : ");
        int year=scanner.nextInt();
        System.out.println("Enter month :");
        int month=scanner.nextInt();
        System.out.println("Enter day : ");
        int day=scanner.nextInt();
        for(int i=0;i< todo.size();i++) {
            if (todo.get(i).getDate().getYear() == year) {
                if (todo.get(i).getDate().getMonth() == month) {
                    if (todo.get(i).getDate().getDay() == day) {
                        System.out.println((i + 1) + ". " + todo.get(i));
                    }
                }
            }
        }
    }

       // this function print all possible data you have stored in same month.
       // if you didn't store any data than it show "you have not stored anything in current month
    public void searchAllInMonth(){
            System.out.println("Enter year : ");
            int year=scanner.nextInt();
            System.out.println("Enter month :");
            int month=scanner.nextInt();
            boolean checker=true;
            for(int i=0;i< todo.size()-1;i++) {
                if (todo.get(i).getDate().getYear() == year)
                    if (todo.get(i).getDate().getMonth() == month) {
                        System.out.println((i + 1) + ". " + todo.get(i));
                        checker=false;
                    }
            }
            if (checker){
                 System.out.println("In  "+month+" month ,You have not saved anything");
            }
        }

    // this function print all possible data you have stored in same year.
    // if you didn't store any data than it show "you have not stored anything in current month
    public void searchAllInYear(){
        System.out.println("Enter year : ");
        int year=scanner.nextInt();
        for(int i=0;i< todo.size()-1;i++) {
            if (todo.get(i).getDate().getYear() == year) {
                    System.out.println((i + 1) + ". " + todo.get(i));
            }else System.out.println("In "+year+" ,You have not saved anything");
        }
    }

    //this function ask for a string . when you provide a string than it will search that
    // if all letters(irrespective of case) are same than it print that data (if data is more than 1 times
    // it's still going to be print all data with same title.) else if not match any title of data than
    // it show entered data does not found.
    public void searchByTitle(String title) {
        boolean checker=true;
            for (int i = 0; i < todo.size(); i++) {
                if (todo.get(i).getTitle().toLowerCase().charAt(0) == title.toLowerCase().charAt(0)) {
                    if (title.length() <= todo.get(i).getTitle().length()) {
                        for (int j = 1; j < title.length(); j++) {
                            if (!(title.toLowerCase().charAt(j) == todo.get(i).getTitle().toLowerCase().charAt(j))) {
                                return;
                            }
                            if (j == title.length() - 1)
                                System.out.println((i + 1) + " ." + todo);
                            checker=false;
                        }
                    }
                }
            }
            if (checker){
                System.out.println("Enter title is not found.");
            }
        }

        //this is a function loads data from my file todoApp.txt.
        // this function could be dynamic but all files are not arrange
        // in same format .this may lead to a lot of exceptions.

    public void loadData(){
        try  {
            Scanner reader = new Scanner(new FileReader("D:\\todoApp.txt"));
           int i=0;
           while (i< todo.size()) {
               todo.add(new Todo_datatype());
               i++;
           }
           i=0;
            while (reader.hasNextLine()){
                todo.get(i).setTitle(reader.nextLine());
                todo.get(i).setDate(Integer.parseInt(reader.next()),Integer.parseInt(reader.next()),Integer.parseInt(reader.next()));
                //to skip line
                reader.nextLine();
               boolean t=true;
               int j=0;
                while (t) {
                    if (reader.next().equals("...")) t=false;
                    else todo.get(i).setDataFile(reader.next());
                    j++;
                }
                i++;
                System.out.println(j);
            }
        } catch (FileNotFoundException e) {
            System.out.println( "File not found.");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //I create this function only to check that my project works perfectly on data.
    //this function create bot type of data and then store in vector which can later used
    //by project to check normal functionality of its features.
    public void dataCreator(){
        for (int i=0;i<90;i++){
           if (i%2==0)System.out.println(i+"Hannan "+(i%30)+" "+(i%12)+" "+(1990+i)+"  jasncjk cjsdcnj cwehbwe cjsjcnn jsacnJN ncanc " +
                    "kcjascnjac" +
                    "" +
                    "ajcnlajc" +
                    "ancjknc jndsasjsnc dnclanue cjebvsdl bvcajdn ...");
           else {
               System.out.println(i+"Adnan "+(i%30)+" "+(i%12)+" "+(2001+i)+"  jasncjk cjsdcnj cwehbwe cjsjcnn jsacnJN ncanc " +
                       "kcjascnjac" +
                       "ajcnlajc" +
                       "ancjknc jndsasjsnc dnclanue cjebvsdl bvcajdn" +
                       " ...");
           }
        }
    }

}