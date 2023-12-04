/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividad_01_UD3_ED;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author ana
 */
public class Actividad_01_UD3_ED 
{
    private static byte[] búfer = new byte[1000];
    private static String nombreArchivo = "fichero.dat";
    private static FileInputStream corrienteEntrada = null;
    private static BufferedInputStream búferEntrada = null;

    public static void inicializateFiles() throws FileNotFoundException
    {
        corrienteEntrada = new FileInputStream(nombreArchivo);
        búferEntrada = new BufferedInputStream(corrienteEntrada);
    }
    
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
