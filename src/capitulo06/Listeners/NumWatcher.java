package capitulo06.Listeners;


public class NumWatcher implements NumeroListener {
	
	public NumWatcher () {
		Calculadora.addListeners(this);
	}

	@Override
	public void resultadoSuma(NumeroEvent n) {
		
		
		System.out.println("Usted ha sumado o multiplicado " + n.getNumero1() + " más/por "
				+ n.getNumero2() + ", lo cual da " + n.getResultado() + ", este es superior a 1000.");
		
	}

	@Override
	public void resultadoResta(NumeroEvent n) {
		
		System.out.println("Usted ha restado " + n.getNumero1() + " menos "
				+ n.getNumero2() + ", lo cual da " + n.getResultado() + ", este es superior a 0.");
		
	}

	@Override
	public void divisionImposible(NumeroEvent n) {
		
		System.out.println("Usted ha intentado dividir " + n.getNumero1() + " entre "
				+ n.getNumero2() + ", lo cual no es posible.");
		
	}

	@Override
	public void raizImposible(NumeroEvent n) {
		
		System.out.println("Usted ha intentado sacar la raíz cuadrada de " + n.getNumero1() + ", lo cual"
				+ " es imposible, debido a que es un número negativo.");
		
	}

}
