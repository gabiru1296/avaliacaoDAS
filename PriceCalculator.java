
public class PriceCalculator {
	private final Acesso acesso;
	private int quantidadeHoras;
	private int quantidadeMinutos;
	private int valorTotal;

	public PriceCalculator(Acesso acesso, int quantidadeHoras, int quantidadeMinutos, int valorTotal) {
		this.acesso = acesso;
		this.quantidadeHoras = quantidadeHoras;
		this.quantidadeMinutos = quantidadeMinutos;
		this.valorTotal = valorTotal;
	}

	public float compute() {

		this.defineParkingTime();
		this.computePrice();

		if (quantidadeHoras >=9)
			return this.acesso.VALOR_DIARIA;
		else
			return valorTotal;
	}

	private void defineParkingTime() {
		if (this.acesso.horaSaida == this.acesso.horaEntrada) {
			quantidadeMinutos = this.acesso.minutosSaida - this.acesso.minutosEntrada;
		}
		else if (this.acesso.horaSaida > this.acesso.horaEntrada && this.acesso.minutosEntrada == this.acesso.minutosSaida) {
			quantidadeMinutos = 0;
		}
		else if (this.acesso.horaSaida > this.acesso.horaEntrada && this.acesso.minutosEntrada > this.acesso.minutosSaida) {
			quantidadeMinutos = this.acesso.minutosSaida - this.acesso.minutosEntrada;
		}
		else if (this.acesso.horaSaida > this.acesso.horaEntrada && this.acesso.minutosSaida < this.acesso.minutosEntrada){
			quantidadeHoras = this.acesso.horaSaida - this.acesso.horaEntrada - 1;
			quantidadeMinutos = this.acesso.minutosSaida + (60 - this.acesso.minutosEntrada);
		}
		else {
			quantidadeHoras = 0;
			quantidadeMinutos = 0;
		}
	}

	private void computePrice() {
		valorTotal += quantidadeHoras * this.acesso.VALOR_HORA;
		valorTotal += Math.ceil(quantidadeMinutos / 15.0) * this.acesso.VALOR_FRACAO;
	}
}
