package src;

import src.Conections.getData;

public class App {
    public static void main(String[] args) {
        System.out.println("TEsteeeee");
        getData teste = new getData();
        System.out.println(teste.checkUsername("Carlos"));
        System.out.println(teste.checkPassword(teste.getIdUsername("Carlos"), "verdade"));
    }
}
