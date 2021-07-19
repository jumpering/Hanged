public class ConsoleHanged extends Hanged{
    
    @Override
    protected View createView() {
        return new ConsoleView();
    }

    public static void main(String[] args) {
        new ConsoleHanged().play();
    }
}
