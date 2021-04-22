
public class App 
{
    static Blocos mundoBlocos;
    public static void main(String[] args) throws Exception 
    {               
        leitor meuLeitor = new leitor();   
             
        meuLeitor.leitorArquivo();                      
    }

    //Recebe os comandos e os realiza
    public static void recebeComando(String comando[])
    {
        int blocoA = Integer.parseInt(comando[1]);
        int blocoB = Integer.parseInt(comando[3]);
        if(comando[0].contains("move"))
        {          
            if(comando[2].contains("over"))
            {               
                mundoBlocos.moveOver(blocoA, blocoB);
            }
            else if (comando[2].contains("onto"))
            {
                mundoBlocos.moveOnto(blocoA, blocoB);
            }
        }
        else if(comando[0].contains("pile"))
        {          
            if(comando[2].contains("over"))
            {               
                mundoBlocos.pileOver(blocoA, blocoB);
            }
            else if (comando[2].contains("onto"))
            {
                mundoBlocos.pileOnto(blocoA, blocoB);
            }
        }
    }

    //Recebe a número de bloco e inicializa o vetor de lista ligada de blocos
    public static void recebeNumero(int comando)
    {       
        mundoBlocos = new Blocos(comando); 
        mundoBlocos.constroiBlocos();     
    }
}

