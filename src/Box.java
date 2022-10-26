
public class Box {
    private String data;
    private String dataHolder;//test
    private Box next;
    private Box previous;
    private Boolean current;
    private Encounter fight = new Encounter();

    public Box(String data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
    // GETTERS
    public String getData() {
        return data;
    }
    public String getDataHolder() {
        return dataHolder;
    }
    public Box getNext() {
        return next;
    }
    public Box getPrevious() {
        return previous;
    }
    public Boolean getCurrent() {
        return current;
    }
    public Encounter getFight() {
        return fight;
    }

    // SETTERS
    public void setData(String data) {
        this.data = data;
    }
    public void setDataHolder(String dataHolder) {
        this.dataHolder = dataHolder;
    }
    public void setNext(Box next) {
        this.next = next; 
    }
    public void setPrevious(Box previous) {
        this.previous = previous;
    }
    public void setCurrent(Boolean current) {
        this.current = current;
    }
    
}
