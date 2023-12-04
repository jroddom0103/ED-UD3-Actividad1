/*
 * Para cambiar este encabezado de licencia, elige License Headers en Project Properties.
 * Para cambiar este archivo de plantilla, elige Tools | Templates
 * y abre la plantilla en el editor.
 */
package Actividad_01_UD3_ED;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Clase que muestra información de archivo de texto.
 * @author jroddom0103
 * @version 3.0
 */
public class Actividad_01_UD3_ED 
{
    //Almacenador de búfers.
    private static byte[] búfer = new byte[1000];
    //Nombre del archivo.
    private static String nombreArchivo = "fichero.dat";
    //Corriente de entrada.
    private static FileInputStream corrienteEntrada = null;
    //Búfer de entrada.
    private static BufferedInputStream búferEntrada = null;

    /**
     * Inicializa el archivo
     * @throws FileNotFoundException 
     */
    public static void inicializateFiles() throws FileNotFoundException
    {
        corrienteEntrada = new FileInputStream(nombreArchivo);
        búferEntrada = new BufferedInputStream(corrienteEntrada);
    }
    
    /**
     * Muestra el archivo de texto
     * @return Muestra el total de lecturas
     * @throws IOException 
     */
    public static int showFileText() throws IOException
    {
        int total = 0;
        int nLecturas = 0;
        while((nRead = corrienteEntrada.read(búfer)) != -1) 
        {
            System.out.println(new String(búfer));
            total += nLecturas;
        }
        
        return total;
    }
    
    /**
     * Método principal de la clase
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        try 
        {
            inicializateFiles();
            
            int total = showFileText();           

            System.out.println("\nLeídos " + total + " bytes");
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if( búferEntrada != null && corrienteEntrada != null )
                {
                    corrienteEntrada.close();
                    búferEntrada.close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }
    
}
