package N201911.N20191121.iterator;

public class Test {

    public static void main(String[] args) {
        TVChanneMenu tvChanneMenu = new TVChanneMenu();
        FilmMenu filmMenu = new FilmMenu();

        MainMenu mainMenu = new MainMenu(tvChanneMenu,filmMenu);
        mainMenu.printMenu();
    }
}
