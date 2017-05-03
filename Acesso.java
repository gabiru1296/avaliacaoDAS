
public class Acesso {

	public static final float VALOR_FRACAO = (float) 2.0;
	public static final float VALOR_HORA = (float) 7.0;
	public static final float VALOR_DIARIA = (float) 30.0;

	public String placa;
	public int dia, mes, ano;
	public int horaEntrada,
	           minutosEntrada;
	public int horaSaida,
			   minutosSaida;



	public Acesso() {}


	public Acesso(int dia, int mes, int ano, int horaEntrada, int minutosEntrada) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.horaEntrada = horaEntrada;
		this.minutosEntrada = minutosEntrada;
	}


	public float calcularValor() {
		final int quantidadeHoras;
		final int quantidadeMinutos;

		// Sequencia lógica de if e else, ou seja, cada variavel temporária
		// será inicializada apenas uma vez. Não mudando de valor com o tempo.
		if (horaSaida == horaEntrada) {
			quantidadeHoras = horaSaida - horaEntrada;
			quantidadeMinutos = minutosSaida - minutosEntrada;
		}
		else if (horaSaida > horaEntrada && minutosEntrada == minutosSaida) {
			quantidadeHoras = horaSaida - horaEntrada;
			quantidadeMinutos = 0;
		}
		else if (horaSaida > horaEntrada && minutosEntrada > minutosSaida) {
			quantidadeHoras = horaSaida - horaEntrada;
			quantidadeMinutos = minutosSaida - minutosEntrada;
		}
		else if (horaSaida > horaEntrada && minutosSaida < minutosEntrada){
			quantidadeHoras = horaSaida - horaEntrada - 1;
			quantidadeMinutos = minutosSaida + (60 - minutosEntrada);
		}
		else {
			quantidadeHoras = 0;
			quantidadeMinutos = 0;
		}

		// somatório não precisa aplicar Dividir variável
		float valorTotal = 0;
		valorTotal += quantidadeHoras * VALOR_HORA;
		valorTotal += Math.ceil(quantidadeMinutos / 15.0) * VALOR_FRACAO;

		if (quantidadeHoras >=9)
			return VALOR_DIARIA;
		else
			return valorTotal;
	}


	public void setHoraSaida(int horaSaida) {
		this.horaSaida = horaSaida;
	}


	public void setMinutosSaida(int minutosSaida) {
		this.minutosSaida = minutosSaida;
	}



}
