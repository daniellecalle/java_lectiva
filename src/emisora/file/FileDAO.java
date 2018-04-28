/*
    Clase definida para la construcción de dónde y cómo se almacenará
    los datos que le proporcionará EditarGuardar.java
*/

package emisora.file;

import java.util.Calendar;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileDAO {

    String ruta = "src/archivos//usuarios.txt";

    public EditarGuardar buscarRegistro(String correo, String pass) {

        File file = new File(ruta);
        EditarGuardar result = null;
        Scanner sc;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Scanner delimitar = new Scanner(line);
                delimitar.useDelimiter("\\s*,\\s*");
                EditarGuardar edita = new EditarGuardar();
                edita.setNombre(delimitar.next());
                edita.setNombre2(delimitar.next());
                edita.setApellido(delimitar.next());
                edita.setApellido2(delimitar.next());
                edita.setTipoDocu(delimitar.next());
                edita.setDocumento(delimitar.next());
                edita.setPass(delimitar.next());
                edita.setCorreo(delimitar.next());
                edita.setFecha(delimitar.next());
                if (edita.getCorreo().equals(correo) && edita.getPass().equals(pass)) {
                    result = edita;
                }
            }
            sc.close();
        } catch (FileNotFoundException edita) {
            edita.printStackTrace();
        }
        return result;
    }

    public boolean guardar(EditarGuardar datos) {
        FileWriter flwriter = null;
        boolean result = false;
        try {

            File file = new File(ruta);

            flwriter = new FileWriter(ruta, true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            bfwriter.write(datos.getNombre() + "," + datos.getNombre2() + "," + datos.getApellido() + "," + datos.getApellido2()+","+datos.getTipoDocu()
                    + "," + datos.getDocumento() + "," + datos.getPass() + "," + datos.getCorreo() + "," + datos.getFecha()+ "\n");

            bfwriter.close();
            result = true;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
