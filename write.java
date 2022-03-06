import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class write implements Runnable{
    holder hotel_ob;
    write(holder hotel_ob)
    {
        this.hotel_ob=hotel_ob;
    }

    @Override
    public void run() {
        try {
            FileOutputStream fout=new FileOutputStream("backup");
            ObjectOutputStream oss=new ObjectOutputStream(fout);
            oss.writeObject(hotel_ob);
        }
        catch (Exception e){
            System.out.println("Error in writing "+e);
        }
    }
}
