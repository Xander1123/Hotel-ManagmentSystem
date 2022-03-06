import java.util.Scanner;

public class Hotel {
    static holder hotel_ob = new holder();
    static Scanner sc = new Scanner(System.in);
    private static int rn;

    static void CustDetails(int i, int rn) {
        String name, contact, gender;
        String name2 = null, contact2 = null;
        String gender2 = "";
        System.out.println("\nEnter customer name : ");
        name = sc.next();
        System.out.println("Enter contact number : ");
        contact = sc.next();
        System.out.println("Enter gender : ");
        gender = sc.next();

        if (i < 3) {
            System.out.println("Enter second customer :  ");
            name2 = sc.next();
            System.out.println("Enter contact number :");
            contact2 = sc.next();
            System.out.println("Enter gender : ");
            gender2 = sc.next();

        }
        switch (i) {
            case 1:
                hotel_ob.luxury_doubleroom[rn] = new Doubleroom(name, contact, gender, name2, contact2, gender2);
                break;
            case 2:
                hotel_ob.deluxe_doubleroom[rn] = new Doubleroom(name, contact, gender, name2, contact2, gender2);
                break;
            case 3:
                hotel_ob.luxury_singleroom[rn] = new Singleroom(name, contact, gender);
                break;
            case 4:
                hotel_ob.deluxe_singleroom[rn] = new Singleroom(name, contact, gender);
        }

    }

    static void bookroom(int i) {
        int j;
        int rn;
        System.out.println("\nChoose room number for : ");
        switch (i) {
            case 1:
                for (j = 0; j < hotel_ob.luxury_doubleroom.length; j++) {
                    if (hotel_ob.luxury_doubleroom[j] == null) {
                        System.out.println(j + 1 + ",");
                    }
                }
                System.out.println("\nEnter room number");
                try {
                    rn = sc.nextInt();
                    rn--;
                    if (hotel_ob.luxury_doubleroom[rn] != null)
                        throw new NotAviable();
                    CustDetails(i, rn);
                } catch (Exception e) {
                    System.out.println("Invalid Option");
                    return;
                }
                break;

            case 2:
                for (j = 0; j < hotel_ob.deluxe_doubleroom.length; j++) {
                    if (hotel_ob.deluxe_doubleroom[j] == null) {
                        System.out.println(j + 11 + ",");
                    }
                }
                System.out.println("\nEnter room number :");

                try {
                    rn = sc.nextInt();
                    rn = rn - 11;
                    if (hotel_ob.deluxe_doubleroom[rn] != null)
                        throw new NotAviable();
                    CustDetails(i, rn);
                } catch (Exception e) {
                    System.out.println("Invalid Option");
                    return;

                }
                break;
            case 3:
                for (j=0;j<hotel_ob.luxury_singleroom.length;j++){
                    if (hotel_ob.luxury_singleroom[j]==null){
                        System.out.println(j+31+",");
                    }
                }
                System.out.println("\nEnter room number : ");
                try{
                    rn=sc.nextInt();
                    rn=rn-31;
                    if (hotel_ob.luxury_singleroom[rn]!=null)
                        throw new NotAviable();
                }
                catch (Exception e){
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 4:
                for (j=0;j<hotel_ob.deluxe_singleroom.length;j++){
                    if (hotel_ob.deluxe_singleroom[j]==null){
                        System.out.println(j+41+",");
                    }
                }
                System.out.println("\nEnter room number : ");
                try {
                    rn=sc.nextInt();
                    rn=rn-41;
                    if (hotel_ob.deluxe_singleroom[rn]!=null)
                        throw new NotAviable();
                    CustDetails(i,rn);
                }
                catch (Exception e){
                    System.out.println("Invalid Option ...");
                    return;
                }
                break;
            default:
                System.out.println("Enter valid Option");
                break;
        }
               System.out.println("Room Booked");

    }
    static void features(int i)
    {
        switch (i){
            case 1:
                System.out.println("Number of double beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:4000");
                break;
            case 2:
                System.out.println("Number of double beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:3000");
             break;
            case 3 :
                System.out.println("Number of single beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:2000");
              break;
            case 4:
                System.out.println("Number of single beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:1000");
            default:
                System.out.println("Enter valid option");
                break;
        }
    }
    static void avialability(int i)
    {
        int j , count=0;
        switch (i){
            case 1:
                for (j=0;j<10;j++){
                    if (hotel_ob.luxury_doubleroom[j]==null)
                        count++;
                }
                break;
            case 2:
                for (j=0;j<hotel_ob.deluxe_doubleroom.length;j++){
                    if (hotel_ob.deluxe_doubleroom[j]==null)
                        count++;
                }
                break;
            case 3:
                for (j=0;j<hotel_ob.luxury_singleroom.length;j++)
                {
                    if (hotel_ob.luxury_singleroom[j]==null)
                        count++;
                }
                break;
            case 4:
                for (j=0;j<hotel_ob.deluxe_singleroom.length;j++){
                    if (hotel_ob.deluxe_singleroom[j]==null)
                        count++;
                }
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
        System.out.println("Number of room aviable : "+count);
    }
    static void bill(int rn,int rtype)
    {
        double amount=0;
        String list[]={"Sandwich","Pasta","Noodles","Coke"};
        System.out.println("\n*******");
        System.out.println("  Bill:-");
        System.out.println("********");
        switch (rtype)
        {
            case 1:
                amount+=4000;
                System.out.println("\nRoom Charge  - "+4000);
                System.out.println("\n===========");
                System.out.println("Food Charges:- ");
                System.out.println("=========");
                System.out.println("Item Quantity Price  ");
                System.out.println("---------------");
                for (Food obb:hotel_ob.luxury_doubleroom[rn].food){
                    amount+= obb.price;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price);
                }
                break;
            case 2:
                amount+=3000;
                System.out.println("\nRoom Charge  - "+3000);
                System.out.println("\n===========");
                System.out.println("Food Charges:- ");
                System.out.println("=========");
                System.out.println("Item Quantity Price  ");
                System.out.println("---------------");
                for (Food obb:hotel_ob.luxury_singleroom[rn].food)
                {
                    amount+= obb.price;
                    String format="%-10s%-10s%-10s%n";
                    System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price);

                }
                break;
            case 3:
                amount+=2000;
                System.out.println("\nRoom Charge  - "+2000);
                System.out.println("\n===========");
                System.out.println("Food Charges:- ");
                System.out.println("=========");
                System.out.println("Item Quantity Price  ");
                System.out.println("---------------");
                for (Food obb:hotel_ob.deluxe_doubleroom[rn].food){
                    amount+=obb.price;
                    String format="%-10s%-10s%-10s%n";
                    System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price);

                }
                break;
            case 4:
                amount+=1000;
                System.out.println("\nRoom Charge  - "+1000);
                System.out.println("\n===========");
                System.out.println("Food Charges:- ");
                System.out.println("=========");
                System.out.println("Item Quantity Price  ");
                System.out.println("---------------");
                for (Food obb:hotel_ob.deluxe_singleroom[rn].food){
                    amount+= obb.price;
                    String format="%-10s%-10s%-10s%n";
                    System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price);
                }
                break;
            default:
                System.out.println("Not valid");
        }
        System.out.println("\nTotam Amount -"+amount);
    }
    static void deallocate(int rn,int rtype){
        int j;
        char w;
        switch (rtype){
            case 1:
                if (hotel_ob.luxury_doubleroom[rn]!=null)
                    System.out.println("Room used by"+hotel_ob.luxury_doubleroom[rn].name);
                else
                {
                    System.out.println("Empty Already");
                    return;
                }
                System.out.println("Do you want to checkout ?(y\n)");
                w=sc.next().charAt(0);
                if (w=='y'|| w=='Y'){
                    bill(rn,rtype);
                    hotel_ob.luxury_doubleroom[rn]=null;
                    System.out.println("Dealloacated succesfuly ");
                }
                break;
            case 2:
                if (hotel_ob.deluxe_doubleroom[rn]!=null)
                    System.out.println("Room used by"+hotel_ob.deluxe_doubleroom[rn].name);
                else {
                    System.out.println("Empty Already ");
                    return;
                }
                System.out.println("Do you want check out ? (y\n)");
                w=sc.next().charAt(0);
                if (w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    hotel_ob.deluxe_doubleroom[rn]=null;
                    System.out.println("Dealloacted succesfully");
                }
                break;
            case 3:
                if (hotel_ob.luxury_singleroom[rn]!=null)
                    System.out.println("Room used by"+hotel_ob.luxury_singleroom[rn].name);
                else {
                    System.out.println("Empty Already ");
                    return;
                }
                System.out.println("Do you want check out ? (y\n)");
                w=sc.next().charAt(0);
                if (w=='y'|| w=='Y'){
                    bill(rn,rtype);
                    hotel_ob.luxury_singleroom[rn]=null;
                    System.out.println("Dealloacted succesfully ");
                }
                break;
            case 4:
                if (hotel_ob.deluxe_singleroom[rn]!=null)
                    System.out.println("Room used by"+hotel_ob.deluxe_singleroom[rn].name);
                else {
                    System.out.println("Empty Already");
                    return;
                }
                System.out.println("Do you want check out ? (y\n)");
                w=sc.next().charAt(0);
                if (w=='y'||w=='Y'){
                    bill(rn,rtype);
                    hotel_ob.deluxe_singleroom[rn]=null;
                    System.out.println("Dealloacated succesfully ");

                }
                break;
            default:
                System.out.println("\nEnter valid option");
                break;
        }
    }
    static void order(int rn , int rtype)
    {
        int i,q;
        char wish;
        try {
            System.out.println("\n==========\n   Menu:  \n==========\n\n1.Sandwich\tRs.50\n2.Pasta\t\tRs.60\n3.Noodles\tRs.70\n4.Coke\t\tRs.30\n");
        do {
            i=sc.nextInt();
            System.out.println("Quanity- ");
            q=sc.nextInt();
            switch (rtype){
                case 1: hotel_ob.luxury_doubleroom[rn].food.add(new Food(i,q));
                break;
                case 2:
                    hotel_ob.deluxe_doubleroom[rn].food.add(new Food(i,q));
                    break;
                case 3: hotel_ob.luxury_singleroom[rn].food.add(new Food(i,q));
                break;
                case 4:
                    hotel_ob.deluxe_singleroom[rn].food.add(new Food(i,q));
                    break;
            }
            System.out.println("Do you want to order anything else ?(y\n)");
            wish=sc.next().charAt(0);
        }while (wish=='y'||wish=='Y');
        }
        catch (NullPointerException e){
            System.out.println("\nRoom not booked");
        }
        catch (Exception e){
            System.out.println("Cannot be done ");
        }
    }
}