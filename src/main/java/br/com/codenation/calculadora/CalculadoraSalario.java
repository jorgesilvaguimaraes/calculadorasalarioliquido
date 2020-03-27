package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-

		return Math.round(this.calculaIrrf(this.calcularInss(salarioBase)));
	}

	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {

		double desconto;
		if (salarioBase <= 1500){
			desconto = salarioBase *0.08;
			salarioBase = salarioBase -  desconto;
		}else if(salarioBase >= 1500.01 && salarioBase <= 4000 ){
			desconto = salarioBase *0.09;
			salarioBase = salarioBase -  desconto;

		}else{
			desconto = salarioBase *0.11;
			salarioBase = salarioBase -  desconto;

		}
		return salarioBase;
	}

	private double calculaIrrf(double salarioBase){
		double desconto = 0.0;

        if(salarioBase < 1039.00){
            salarioBase = 0.0;
        }else if(salarioBase < 3000){
			salarioBase = salarioBase - desconto;
		}else if(salarioBase >3000 && salarioBase <= 6000){
			desconto = salarioBase * 0.075;
			salarioBase = salarioBase - desconto;
		}else{
			desconto = salarioBase * 0.15;
			salarioBase = salarioBase - desconto;
		}
		return salarioBase;
	}

	public static void main(String[] args){
		CalculadoraSalario calculadoraSalario = new CalculadoraSalario();
		System.out.println(calculadoraSalario.calcularSalarioLiquido(1000));
	}

}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/