import implementations.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        names.add("Pesho");
        names.add("Ivan");
        names.add("Andrey");
        names.add("Goshko");
        names.add(0, "Genadi");
        System.out.println();
    }
}
