/**
 * board interface represents the XOBoard
 */
public interface board {

    public boolean put(int i, int j, char c);
    public String status();
    public void display();

}
