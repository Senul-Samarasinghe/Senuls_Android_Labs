package algonquin.cst2335.sama0087.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ChatMessage {
    @ColumnInfo(name="message")
    String message;
    @ColumnInfo(name="TimeSent")
    String timeSent;
    @ColumnInfo(name="SendOrReceive")
    boolean isSentButton;

    @PrimaryKey(autoGenerate=true)
    @ColumnInfo(name="id")
    public int id;

    public ChatMessage(String m, String t, boolean sent)
    {
        message = m;
        timeSent = t;
        isSentButton = sent;
    }

    public ChatMessage() {
        
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setTimeSent(String timeSent) {
        this.timeSent = timeSent;
    }

    public String getTimeSent() {
        return timeSent;
    }

    public boolean getIsSentButton(){
        return isSentButton;
    }
}