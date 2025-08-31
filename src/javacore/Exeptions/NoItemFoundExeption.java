package javacore.Exeptions;

public class NoItemFoundExeption extends Exception{
    public NoItemFoundExeption() {
        System.out.println("Таких книг нет в каталоге");
    }
}
