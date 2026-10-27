
public class python {

    public static void main(String[] args) {
        // a few things tried out :O
        List lst = new List();
        List lst2 = new List();

        lst.append(2323);
        lst.append("434ads");

        lst2.append(232);

        lst.append(lst2.to2dimlist());
        lst.append(true);
        System.out.print(lst+""+lst2);
    }
}
