package ad_2_1_4_filefusion;

import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Iván zambrana Naranjo
 */
public class AD_2_1_4_FileFusion {


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("--FUSIÓN DE FICHEROS--");
            //Pide primer fichero
            System.out.println("Inserte ruta del primer fichero: ");
            String rutaA = sc.next();
            File inFileA = new File(rutaA);
            //Pide segundo fichero
            System.out.println("Inserte ruta del segundo fichero: ");
            String rutaB = sc.next();
            File inFileB = new File(rutaB);
            
            //Comprobamos que ambos ficheros existan
            if(inFileA.exists() && inFileB.exists())
            {
                //Pide fichero destino
                System.out.println("Inserte ruta para crear el fichero resultante");
                String rutaC = sc.next();
                File outFile = new File(rutaC);
                if(outFile.createNewFile())
                {
                    //Creamos dos bufferedReaders
                    BufferedReader brA = new BufferedReader(new FileReader(inFileA));
                    String textoA = brA.readLine();
                    BufferedReader brB = new BufferedReader(new FileReader(inFileB));
                    String textoB = brB.readLine();
                    //Creamos el bufferedWriter
                    BufferedWriter bW = new BufferedWriter(new FileWriter(outFile));
                    
                    //Bucle de funcionamineto
                    while(textoA != null || textoB != null)
                    {
                        if(textoA != null)
                        {
                            bW.write(textoA + "\n");
                        }
                        if(textoB != null)
                        {
                            bW.write(textoB + "\n");
                        }
                        textoA = brA.readLine();
                        textoB = brB.readLine();
                    }
                    bW.flush();
                    
                    System.out.println("Fichero creado con éxito.");
                }
                else
                {
                    System.out.println("El fichero resultante ya existe.");
                }
            }
            else
            {
                System.out.println("-ERROR- Alguno de los ficheros especificados no existe.");
            }
        } catch (Exception e)
        {
            
        }
    }
    
}
