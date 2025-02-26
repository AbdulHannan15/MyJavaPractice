import java.util.Objects;
import java.util.Scanner;

public class Todo_datatype {
    private Scanner scanner=new Scanner(System.in);
    private Date date;
    private String title;
    private String data;
    public Todo_datatype(){
        date=new Date();
        data="";
        title="";
    }
    public Todo_datatype(String title,String data,int day,int month,int year){
        this.date=new Date(month,day,year);
        this.data=data;
        this.title=title;
    }

    public void setDataManual(String data) {
        String tempData="";
        do {
            data=data.concat(tempData);
            if (!tempData.equals("..."))data=data.concat(" ");
            System.out.println("For ending entering data press '...' ");
            tempData=scanner.next();
        }while (!Objects.equals(tempData, "..."));
        this.data = data;
    }
    public void setDataFile(String data){
        this.data.concat(data);
    }
    public String getData() {
        return data;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getTitle() {
        return title;
    }
    public void setDate(int day,int month,int year) {
        this.date = new Date(month,day,year);
    }
    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Title : "+title+"\n"+
                "Data : "+data+"\n"+
                "Stored time : "+date+"\n";
    }
}
