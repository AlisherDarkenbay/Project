import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class MessageData implements Serializable {
    private String name;
    private String message;
    private Date date;
    private ArrayList<String> names;

    public MessageData(String name, String message, Date date) {
        this.name = name;
        this.message = message;
        this.date = date;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return name+": "+message+" date: "+date.toString();
    }
}
