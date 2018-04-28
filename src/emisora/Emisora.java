package emisora;

import javax.swing.JFileChooser;
import javazoom.jl.player.advanced.*;
import java.io.File;
import java.io.FileInputStream;

public class Emisora {
    public static void main(String[] args) {
        AdvancedPlayer  sonido;
        JFileChooser seleccionar = new JFileChooser();
        int a = seleccionar.showOpenDialog(null);
        if (a == JFileChooser.APPROVE_OPTION){
            File archivo = seleccionar.getSelectedFile();
            try{
            sonido = new AdvancedPlayer(new FileInputStream(archivo));
            sonido.play();
            }catch(Exception e){
                System.out.println("Error al instanciar");
            }
        }
    }
    
}
