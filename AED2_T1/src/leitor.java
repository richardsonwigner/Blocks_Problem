import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class leitor {
    public void leitorArquivo()  throws java.io.IOException
    {
        
        FileReader fr = null;
        BufferedReader br = null;
        String arquivo = "entrada.txt";
        String comando[];

        int inicializaBlocos;
      
        try
        {
            fr = new FileReader(arquivo);
            br = new BufferedReader(fr);
            String linha = br.readLine();
            while (linha != null)
            {
                comando = linha.split(" ");
                if(comando.length == 1)//Se o tamanho do vetor for 1 significa que é o comando de iniciliazar o vetor ou o comando quit.
                {
                    if(comando[0].equals("quit"))
                    {                        
                        escritorArquivo();                                             
                    }
                    else
                    {
                        inicializaBlocos = Integer.parseInt(comando[0]);                 
                        App.recebeNumero(inicializaBlocos);
                    }                 
                }       
                else if(comando.length == 4)//Se o tamanho do vetor for 4 significa que é os comandos de mover blocos.
                {                  
                    App.recebeComando(comando);
                }               
                linha = br.readLine();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("\"" + arquivo + "\" não existe.");
        }
        catch (IOException e)
        {
        System.out.println("Erro na leitura do arquivo.");
        }
        finally
        {
            br.close();
            fr.close();
        }
    }
    public void escritorArquivo()  throws java.io.IOException
    {     
        listaLigada listaBlocos[] = App.mundoBlocos.listaBlocos;
        File f = new File("saida.txt");
        FileWriter fw = null;
        PrintWriter arquivo = null;
        try
        {
            fw = new FileWriter(f);
            arquivo = new PrintWriter(fw);
            for(int i = 0; i< listaBlocos.length ; i++)
            {
                arquivo.println( i + " : " + listaBlocos[i]);              
            }   
            System.out.println("O Arquivo saida.txt com seu mundo de blocos feito com sucesso");      
        }
        catch (IOException e)
        {
            System.err.println("Erro ao escrever arquivo.");
        }
        finally
        {
            arquivo.close();
            fw.close();
        }
    }
  
}
