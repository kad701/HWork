package javacore.Exeptions;

public class NoAvailableCopiesExeption extends Exception{
    public NoAvailableCopiesExeption() {
        System.out.println("Книга имеется в каталоге но нет доступных экземляров");
    }
}
