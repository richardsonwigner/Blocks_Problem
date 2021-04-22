public class Blocos 
{    
    int tamanhoLista; 
    listaLigada[] listaBlocos;  
    //Construtor Blocos
    public Blocos(){}
    public Blocos(int tamanho)
    {
        tamanhoLista = tamanho; 
        listaBlocos = new listaLigada[tamanho];        
    }
    //Coloca o bloco a para cima do bloco b retornando eventuais blocos que já estiverem sobre a e b para as suas posições originais.
    public void moveOnto(int blocoA, int blocoB) 
    {      
        realocaBloco(blocoA);
        realocaBloco(blocoB);    
        moveBlocos(blocoA, blocoB);
    }
    //Coloca o bloco a no topo do monte onde está o bloco b retornando eventuais blocos que já estiverem sobre a às suas posições originais.
    public void moveOver(int blocoA, int blocoB) 
    {              
        realocaBloco(blocoA);                
        moveBlocos(blocoA, blocoB);                                                       
    }
    //Coloca o bloco a juntamente com todos os blocos que estiverem sobre ele em cima do bloco b, retornando eventuais blocos que já estiverem sobre b as suas posições originais.
    public void pileOnto(int blocoA, int blocoB) 
    {                  
        realocaBloco(blocoB);                    
        moveBlocos(blocoA, blocoB);      
    }
    //Coloca o bloco a juntamente com todos os blocos que estiverem sobre ele sobre o monte que contém o bloco b.
    public void pileOver(int blocoA, int blocoB) 
    {          
        moveBlocos(blocoA, blocoB);              
    }        
    //Metódo remove blocos duplicados na lista de blocos que foi passada.
    public void removeBlocos(int Bloco, int celulaBloco)
    {    
        for(int i = 0; i < listaBlocos[Bloco].tamanho(); i++) // Percorre a lista de blocos
        {
            // Caso algum elemento que foi retornado pelo metódo pega for igual a variável celulaBloco, significa que existe um elemento repetido na lista,
            //assim removendo o elemento na posição que foi encontrado.
            if((Integer)listaBlocos[Bloco].pega(i) == celulaBloco)
            {
                listaBlocos[Bloco].remove(i);  
            }              
        }                          
    }                             
    
    //Metódo remove um bloco na posição que foi colocado e retorna para sua posição original.
    public void realocaBloco(int Bloco)
    {
        if(listaBlocos[Bloco].tamanho() > 1) //Caso o tamanho da lista seja maior que 1, significa que existe elementos para ser realocados.
        {     
            while(listaBlocos[Bloco].tamanho() != 1)
            {              
                int i=+1; //Conta a posição que o elemento se encontra.
                int realocarBloco = (Integer)listaBlocos[Bloco].pega(i); // Atribuí na variável o valor na posição 
                if(listaBlocos[Bloco].contem(realocarBloco))// Verifica se contém o elemento que foi atruibido na variável
                {                              
                    //Como a posição inicial do elemento no vetor sempre é seu valor, adiciona seu valor na posição do vetor e remove na posição que o elemento foi encontrado.
                    listaBlocos[realocarBloco].adicionaNoComeco(realocarBloco);   
                    listaBlocos[Bloco].remove(i);                 
                }
            }
        }
    }  

    //Move os blocos para a posição que foi passada.
    public void moveBlocos(int blocoA , int blocoB)
    {
        //Enquanto o tamanho da lista for diferente de zero roda o ciclo while pois significa que ainda existe bloco para mover.      
        while(listaBlocos[blocoA].tamanho() != 0) 
        {         
            int y = listaBlocos[blocoB].tamanho();// Atribuí na variável y o tamanho da lista, ou seja a última posição da lista                                    
            for(int i = 0; i < tamanhoLista; i++)
            {
                if(listaBlocos[blocoA].contem(i)) //Verifica se contém o elemento na lista
                {                                              
                    listaBlocos[blocoB].adiciona(y,i);//Adiciona o elemento na última posição da lista
                    removeBlocos(blocoA,i);//Remove o elemento repetido na lista                                                         
                }
            }                                                             
        }  
    }

    //Coloca uma lista ligada em cada posição do vetor.            
    public void constroiBlocos()
    {          
        for(int i = 0; i < tamanhoLista ; i++)
        {
            listaBlocos[i] = new listaLigada();
            listaBlocos[i].adicionaNoComeco(i);
        }           
    }         
    public void imprimirBlocos()
    {
        for(int i = 0; i < tamanhoLista; i++)
        {
            System.out.println(i + " : " + listaBlocos[i]);
        }
    }
}
