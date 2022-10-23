import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Secretary implements Observer {
    private final General general;
    public String log;

    public Secretary(General general){
        this.general = general;
        log = general.getLog();
    }

    @Override
    public void update(){
        try {
            log = general.getLog();
            BufferedWriter file = new BufferedWriter(new FileWriter("logs.txt", true));
            file.append(log);
            file.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}