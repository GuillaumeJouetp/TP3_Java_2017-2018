import java.util.Scanner;
public class TP3 
{

	public static void main(String[] args) 
	{   
		/*Fonctions relatives a un tableau dimension 1*/
		System.out.println("Vous allez créer un tableau, ");
		int [] tableau = Tableau1D(5);
		
		System.out.println("Votre tableau est le suivant : ");
		Affichage1D(tableau);
		System.out.println("");
		System.out.println("");
	
		System.out.println("La moyenne de votre tableau est " + Moyenne(tableau));
		
		ElementMoyenne (tableau);
		System.out.println("");
		
		System.out.println ("Votre tableau partitionné en fonction de la moyenne est le suivant :");
		Affichage1D(Partition(tableau));
		System.out.println("");
		
		System.out.println ("Votre tableau triée est le suivant :");
		Affichage1D(tri(tableau));
		System.out.println("");
		
		System.out.println("");
		System.out.println("Solution exhaustive : La premiere occurence est placée rang " + occurence(6,tableau)); // Si la fonction renvoie -1, le nombre demandé n'appartient pas au tableau
		System.out.println("");
		
		System.out.println("");
		System.out.println("Solution dichotomique : La premiere occurence est placée rang " + dichotomie(6,tableau)); // Si la fonction renvoie -1, le nombre demandé n'appartient pas au tableau
		System.out.println("");
	
		
		
		/*Fonctions relative a une matrice de dimension 2*/
		
		System.out.println("Vous allez maintenant créer une matrice, ");
		int [][] matrice = Tableau2D(3,4);
		System.out.println("Votre matrice est la suivante : ");
		Affichage2D(matrice);
		
		
	
	}

	public static int [] Tableau1D(int taille) //Fonction qui crée un tableau a une dimension de taille : taille 
	{
		int size = taille;
		int [] tab1D = new int[size];        // les valeurs du tableau sont initialement 0
		Scanner scan = new Scanner(System.in);
		int k;
		int s;
		for (k=0; k<tab1D.length; k++)
		{
			s = k+1;
			System.out.println("Entrez la valeur de la case " + s + " de votre tableau" );
			int valeur = scan.nextInt();
			tab1D[k] = valeur ;
		}
		return tab1D;
	}
	
	public static void Affichage1D (int [] tab) // Fonction qui affiche un tableau à une dimension
	{	
		for (int k=0; k<tab.length; k++)
		{
			System.out.print(tab[k]+" ");
		}
	}
	
	public static int [][] Tableau2D(int n, int p) // Fonction qui crée une matrice de n lignes et p colonnes
	{
		int [][] tab2D = new int [n][p];        // les valeurs du tableau sont initialement 0
		Scanner scan = new Scanner(System.in);
		int k;
		int i;
		for (k=0; k<tab2D.length; k++)
		{
			int l = k+1;
			for (i=0; i<tab2D[k].length; i++)
			{
				int c = i+1 ;
				System.out.println("Indiquez la valeur de la ligne " + l + " et de la colonne "	+ c + " de votre matrice");
				int valeur = scan.nextInt();
				tab2D[k][i] = valeur ;
			}
	
		
		}
		return tab2D;
	}
	
	public static void Affichage2D (int [][] tab) // Fonctino qui affichage une matrice de n lignes et p colonnes
	{	
		int k;
		int i;
		for (k=0; k<tab.length; k++)
		{
			System.out.println("");
			for (i=0; i<tab[k].length; i++)
			{
				System.out.print(tab[k][i]+" ");
			}
		}
	}
	
	public static int Moyenne (int [] tab) // Fonction qui renvoie la moyenne entière des valeurs d'un tableau de dimension 1
	{	float Somme = 0;
		int p = tab.length; 
		for (int k=0; k<p; k++)
		{
			Somme = Somme + tab[k];
		}
		int Moyenne = (int) (Somme/p);	
		return Moyenne ;
	}
	
	public static void ElementMoyenne (int [] tab) //Fonction qui affiche le rang de la moyenne si elle existe dans le tableau
	{
		int p = tab.length; 
		int Moy = Moyenne(tab);
		boolean Power = false;
		for (int k=0; k<p; k++)
		{
			if (tab[k] == Moy)
			{
				System.out.println("");
				System.out.println("La moyenne fait partie de votre tableau et est placée au rang " + k);
				Power = true;
				break;
			}
		}
		if (Power == false)
		{
			System.out.println("Aucune valeur n'est égale a la moyenne dans votre tableau");
		}
		
	}
	
	public static int[] Partition (int [] tab) // Fonction qui retourne un tableau partitionné en fonction de sa moyenne
	{ 
		int p = tab.length;
		int [] partition = new int [p];
		int Moy = Moyenne(tab);
		int i= 0;
		for(int k=0; k<p ;k++)
		{
			if (tab[k]<Moy)
			{
				partition[i]= tab[k];
				i++;
			}
		}
		for(int j=0; j<p ;j++)
		{
			if (tab[j]>=Moy)
			{
				partition[i]= tab[j];
				i++;
			}
		}
		return partition;
	}
	
	public static void mode (int [] tab) // Ne fonctionne pas
	{
		int p = tab.length;
		int dic [][] = new int [p][2];
		for(int k=0; k<p ;k++)
		{
			for(int i=0;i<=p;i++)
			{
				if (dic[i][0]== tab[k])
				{
					dic[i][1]= dic[i][2] + 1;
				}
				else
				{
					dic[i][0] = tab[k]; 
					dic[i][1] = 1;
				}
			}	
			
		}
		Affichage2D (dic);
	}
	
	public static int[] tri (int [] tab) // fonction qui retourne un tableau triée
	{
		int p = tab.length;
		for (int i=0;i<p;i++)
		{	for(int k=0; k<p-1 ;k++)
			{
				if(tab[k]>tab[k+1])
				{
				int temp = tab[k];
				tab[k]=tab[k+1];
				tab[k+1] = temp;
				}	
			}			
		}
		return tab;
	}
	
	public static int occurence (int v,int[] t) //fonction qui renvoie l'indice de la première occurence de v dans le tableau t.
	{
		int p = t.length;
		for (int i=0;i<p;i++)
		{
			if(t[i] == v)
			{
				return i;
			}
		}
		return -1;
	}

	public static int dichotomie (int n,int[] T) //Fonction qui renvoie le rang de n, si n est présent dans le tableau TRIEE (de maniere dichotomique)
	{
		tri (T);
		int gauche = 0;
		int droite = T.length-1;	
		while (T[gauche]<=T[droite])
		{
			int milieu = (gauche + droite)/2;
			if (T[milieu]==n)
			{
				return milieu;
			}
			
			else if (T[milieu]<n)
			{
				gauche = milieu + 1;
			}
			
			else
			{
				droite = milieu - 1;
			}
		}
		return -1;

	}
}

// 1 2 3 4 5 6 7 8 9 
