import java.io.Serializable;

public class Doubleroom extends Singleroom implements Serializable {
    String name2 ;
    String contact2 ;
    String gender2 ;
    Doubleroom(){
        this.name2="";
        this.name="";

    }
    Doubleroom (String name,String contact ,String gender ,String name2,String contact2,String gender2)
    {
        this.name=name;
        this.name2=name2;
        this.contact=contact;
        this.contact2=contact2;
        this.gender=gender;
        this.gender2=gender2;

    }
}
