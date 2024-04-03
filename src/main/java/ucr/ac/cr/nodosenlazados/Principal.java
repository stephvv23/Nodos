/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.nodosenlazados;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Principal
{
	NodosEnlazados nodosEnlazados;
	
	public Principal(){
		nodosEnlazados=new NodosEnlazados();
		menu();
	}
	public void menu()
	{
		
		/**		
			1. Agregar un elemento al inicio de la lista.
			2. Agregar un elemento al final de la lista.
			3. Agregar un elemento después de.
			4. Agregar un elemento antes de.
			5. Imprimir los elementos de la lista.
			6. Eliminar un nodo de la lista. 
		 **/
		 
		
		int opcion=0, dato=0, valorABuscar=0;
		do
		{
			opcion = Integer.parseInt(JOptionPane.showInputDialog("Escoja una opcion:\n1. Agregar un elemento al inicio de la lista. \n"+ 
			"2. Agregar un elemento al final de la lista. \n"+
			"3. Agregar un elemento despues  \n"+
			"4. Agregar un elemento antes \n"+
			"5. Imprimir los elementos de la lista. \n"+
			"6. Eliminar un nodo de la lista.\n"+
			"7. Para salir" ));
			
			switch(opcion)
			{
				case 1: //Agregar al inicio
					dato = Integer.parseInt(JOptionPane.showInputDialog("Digite el valor a almacenar al inicio"));
					nodosEnlazados.agregarInicio(dato);
				break;				
				case 2: //Agregar al final
					dato = Integer.parseInt(JOptionPane.showInputDialog("Digite el valor a almacenar al final"));
					nodosEnlazados.agregarFinal(dato);
				break;				
				case 3://Despues de
					valorABuscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el valor a buscar", 
                "Insertar DESPUES de..", JOptionPane.QUESTION_MESSAGE));
					dato = Integer.parseInt(JOptionPane.showInputDialog("Digite el valor a almacenar despues de ..."));
					nodosEnlazados.insertarDespues(valorABuscar, dato);			
				break;				
				case 4://Antes de
				
				valorABuscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el valor a buscar", 
                "Insertar ANTES de..", JOptionPane.QUESTION_MESSAGE));
					dato = Integer.parseInt(JOptionPane.showInputDialog("Digite el valor a almacenar antes de... "));
					nodosEnlazados.insertarAntes(valorABuscar,dato);
				break;
				case 5://Imprimir
					JTextArea textArea = new JTextArea(20, 25);
					textArea.setText(nodosEnlazados.imprimir());
					textArea.setEditable(false);			  
					
					JScrollPane scrollPane = new JScrollPane(textArea);					
					JOptionPane.showMessageDialog(null, scrollPane,"Reporte",JOptionPane.INFORMATION_MESSAGE);      
					
				break;
				case 6://Elimiar
				valorABuscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el valor a eliminar", 
                "ELIMINAR", JOptionPane.QUESTION_MESSAGE));
					nodosEnlazados.eliminar(valorABuscar);
				break;
				case 7://Salir
					System.exit(0);
				break;
				
				default:
					JOptionPane.showMessageDialog(null, "Numero incorrecto");
			}//Fin switch
		}while(opcion !=7);
				
	}//Fin del main
	public static void main(String arg[])
	{
		Principal principal = new Principal();
                principal.menu();
	}//Fin del main
}//Fin clase OperaNodo
