package br.com.fsferreira.math;

public class BaseCalculator {
	public Double sum(Double numberOne, Double numberTwo) {
		return numberOne + numberTwo;
	}

	public Double sub(Double numberOne, Double numberTwo) {
		return numberOne - numberTwo;
	}

	public Double times(Double numberOne, Double numberTwo) {
		return numberOne * numberTwo;
	}

	public Double by(Double numberOne, Double numberTwo) {
		return numberOne / numberTwo;
	}

	public Double mean(Double numberOne, Double numberTwo) {
		return (numberOne + numberTwo) / 2;
	}

	public Double sqrt(Double number) {
		return Math.sqrt(number);
	}
}
