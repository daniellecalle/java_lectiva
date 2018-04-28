package emisora;

import java.io.File; 
import java.io.PrintStream; 
import java.util.Map; 
import javazoom.jlgui.basicplayer.*; 

public class BotonesReproducir  implements BasicPlayerListener{    

    private PrintStream out = null;//Stream para el Debbugging(println)... 
     
    public BasicPlayer player = new BasicPlayer();//Instancia de BasicPlayer     
    public BasicController control = (BasicController) player;//Controlador para player
    private long tiempo;

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }

    public long getTiempo() {
        return tiempo;
    }

    public BotonesReproducir() {//Constructor de la clase
        out = System.out;
        player.addBasicPlayerListener(this);         
    } 
    
      //Metodos sobreescritos: 

    public void opened(Object stream, Map properties) { 

        display("opened : " + properties.toString()); 
    } 

    
    public void progress(int bytesread, long microseconds, byte[] pcmdata, Map properties) { 
        tiempo = microseconds;
        display("progress : " + properties.toString()); 
    } 
   
    public void stateUpdated(BasicPlayerEvent event) { 
        display("stateUpdated : " + event.toString()); 
        
    } 

    public void setController(BasicController controller) { 
        display("setController : " + controller); 
    } 

    public void display(String msg) { 
        if (out != null) { 
            out.println(msg); 
        } 
    } 

} 
    

