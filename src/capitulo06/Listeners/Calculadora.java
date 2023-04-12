package capitulo06.Listeners;

import java.util.ArrayList;
import java.util.List;

import capitulo04.bloque04.Utils;

public class Calculadora {

	private static List<NumeroListener> listeners = new ArrayList<NumeroListener>();

	public static void addListeners(NumeroListener n) {

		listeners.add(n);

	}

	public static void removeListeners(NumeroListener n) {

		listeners.remove(n);

	}
	
	/**
	 * 
	 * @param divis
	 * @param divid
	 */

	private static void procesarDividendo(float divis, float divid) {

		NumeroEvent numE = new NumeroEvent();

		numE.setNumero1(divis);
		numE.setNumero2(divid);

		if (divid == 0) {
			fireDivisionImposible(numE);
		} else {
			System.out.println(divis / divid);
		}

	}
	/**
	 * 
	 * @param sum1
	 * @param sum2
	 * @param resultado
	 */

	private static void procesarSuma(float sum1, float sum2, float resultado) {
		
		NumeroEvent numE = new NumeroEvent();

		numE.setNumero1(sum1);
		numE.setNumero2(sum2);
		numE.setResultado(resultado);

		if (resultado > 1000) {
			fireResultadoSuma(numE);
		} else {
			System.out.println(resultado);
		}

	}
	/**
	 * 
	 * @param rest1
	 * @param rest2
	 * @param resultado
	 */
	
	private static void procesarResta(float rest1, float rest2, float resultado) {
		
		NumeroEvent numE = new NumeroEvent();

		numE.setNumero1(rest1);
		numE.setNumero2(rest2);
		numE.setResultado(resultado);
		
		if (resultado < 0) {
			fireResultadoResta(numE);
		}
		else {
			System.out.println(resultado);
		}
		
	}
	
	/**
	 * 
	 * @param num1
	 */
	

	private static void procesarRaiz(float num1) {
		
		NumeroEvent numE = new NumeroEvent();

		numE.setNumero1(num1);
		
		if (num1 < 0) {
			fireResultadoRaiz(numE);
		}
		else {
			System.out.println(Math.sqrt(num1));
		}
		

	}
	
	/**
	 * 
	 * @param e
	 */

	private static void fireResultadoRaiz(NumeroEvent e) {
		for (NumeroListener n : listeners) {
			n.raizImposible(e);
		}	
		
	}
	/**
	 * 
	 * @param e
	 */

	private static void fireResultadoResta(NumeroEvent e) {
		for (NumeroListener n : listeners) {
			n.resultadoResta(e);
		}		
	}
	
	/**
	 * 
	 * @param e
	 */

	private static void fireResultadoSuma(NumeroEvent e) {
		for (NumeroListener n : listeners) {
			n.resultadoSuma(e);
		}

	}
	
	/**
	 * 
	 * @param e
	 */

	private static void fireDivisionImposible(NumeroEvent e) {

		for (NumeroListener n : listeners) {
			n.divisionImposible(e);
		}

	}

	public static void main(String[] args) {

		NumWatcher numE = new NumWatcher();
		int opcion = Utils.obtenerEnteroPorJOptionPaneConDescripcion("0.-Salir" + "\n1.-Suma" + "\n2.-Resta"
				+ "\n3.-Multiplicación" + "\n4.-División" + "\n5.-Raíz cuadrada" + "\nIntroduzca una opción.");
		float numero1, numero2, resultado;

		switch (opcion) {

		case 0:
			System.exit(0);
			break;

		case 1:
			numero1 = Utils.obtenerFloatPorJOptionPaneConDescripcion("Introduzca el primer número a sumar");
			numero2 = Utils.obtenerFloatPorJOptionPaneConDescripcion("Introduzca el segundo número a sumar");
			procesarSuma(numero1, numero2, numero1 + numero2);
			break;
		case 2:
			numero1 = Utils.obtenerFloatPorJOptionPaneConDescripcion("Introduzca el primer número a restar");
			numero2 = Utils.obtenerFloatPorJOptionPaneConDescripcion("Introduzca el segundo número a restar");
			procesarResta(numero1, numero2, numero1 - numero2);
			break;
		case 3:
			numero1 = Utils.obtenerFloatPorJOptionPaneConDescripcion("Introduzca el primer número a multiplicar");
			numero2 = Utils.obtenerFloatPorJOptionPaneConDescripcion("Introduzca el segundo número a multiplicar");
			procesarSuma(numero1, numero2, numero1 * numero2);
			break;
		case 4:
			numero1 = Utils.obtenerFloatPorJOptionPaneConDescripcion("Introduzca el primer número a dividir");
			numero2 = Utils.obtenerFloatPorJOptionPaneConDescripcion("Introduzca el segundo número a dividir");
			procesarDividendo(numero1, numero2);
			break;
		case 5:
			numero1 = Utils.obtenerFloatPorJOptionPaneConDescripcion(
					"Introduzca a qué número quieres hacerle la raíz cuadrada");
			procesarRaiz(numero1);
			break;
		}

	}


	

}
