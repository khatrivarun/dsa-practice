import java.util.Stack;

public class ImplementUNDOREDO {
    private StringBuilder text;
    private Stack<String> history;

    public ImplementUNDOREDO() {
        this.text = new StringBuilder();
        this.history = new Stack<>();
    }
    
    public void append(char x) {
        text.append(x);
        history.clear();
    }

    public void undo() {
        if (!text.isEmpty()) {
            String last = text.substring(text.length() - 1, text.length());
            text.deleteCharAt(text.length() - 1);
            history.push(last);
        }
    }

    public void redo() {
         if (!history.isEmpty()) this.text.append(history.pop());
    }

    public String read() {
         return this.text.toString();
    }
}
