
public class Box {
    String data;
    String dataHolder;//test
    Box next;
    Box previous;
    Boolean current;
    Encounter fight = new Encounter();

    public Box(String data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public boolean hasNext() {
        if(next == null) {
            return false;
        }
        else {
            return true;
        }
        
    }
    public boolean hasPrevious() {
        if(previous == null) {
            return false;
        }
        else {
            return true;
        }
    }
    
}
