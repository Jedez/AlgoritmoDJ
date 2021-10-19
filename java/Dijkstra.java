import java.io.*;
import java.util.*;
class Dijkstra{
   int Array1[] = new int[10];
   int Array2[][] = new int[10][10];
 
 public static void main(String args[])
 {
	int nodo=0,or,i,j;
	int op;
	cls();
	System.out.println("\t******Algoritmo Dijkstra******\n");
		  Scanner in = new Scanner(System.in);
		  System.out.printf("Introduce el numero de nodos:");
			nodo = in.nextInt();
			op = nodo*nodo;
		  cls();
		  Dijkstra d = new Dijkstra();
		  System.out.printf("Ingrese valores de la matriz \n\n Tamano de la matriz "+op+":\n");
				for(i=1;i<=nodo;i++){
				  for(j=1;j<=nodo;j++)
				  {
					d.Array2[i][j]=in.nextInt();
					if(d.Array2[i][j]==0)
					  d.Array2[i][j]=999;
				  }
				}
				  cls();
				  System.out.println("\t\tValores ingresados ");
				  for(i=1;i<=nodo;i++){
					  System.out.println();
				  for(j=1;j<=nodo;j++)
				  {
					 System.out.printf("\t"+d.Array2[i][j]) ;
				  }
				  }
				  System.out.printf("\n\n");
		  System.out.printf("Ingrese el vertice de origen :");
		  or=in.nextInt();
		  cls();
		  d.calc(nodo,or);
		  System.out.println("El camino mas corto:\t"+or+"\n");
				for(i=1;i<nodo;i++)
				  if(i!=or)
		  System.out.println("vertice  :"+or+"\t destino :"+i+"\t Costo minimo es :"+d.Array1[i]+"\t");
  
 } 	
	public void calc(int num1,int num2){
  int bandera[] = new int[num1+1];
  int i,a=1,k,c,min;
  
  for(i=1;i<num1;i++)
  {  
      bandera[i]=0; 
      this.Array1[i]=this.Array2[num2][i]; 
  }
  c=2;
  while(c<=num1)
  {
   min=99;
   for(k=1;k<num1;k++)
   { 
          if(this.Array1[k]<min || bandera[k]!=1)
       {
        min=this.Array1[i];
        a=k;
       }
      } 
            bandera[a]=1;
      c++;
      for(k=1;k<num1;k++){
       if(this.Array1[a]+this.Array2[a][k] <  this.Array1[k] || bandera[k]!=1 )
       this.Array1[k]=this.Array1[a]+this.Array2[a][k];
   }   
  } 
  
 }
	
	
	public static void cls(){
    try {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    } catch (IOException | InterruptedException ex) {}
	}//cls 
	
}