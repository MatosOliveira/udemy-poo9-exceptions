/**
 * 
 */
package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

/**
 * @author Matos
 *
 */
public class AccountProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
		System.out.println("Digite os dados da conta: ");
		
		System.out.print("Numero: ");
		int num = sc.nextInt();
		
		System.out.print("Titular: ");
		sc.nextLine();
		String titular = sc.nextLine();
		
		System.out.print("Saldo inicial: ");
		double saldo = sc.nextDouble();
		
		System.out.print("Limite: ");
		double limite = sc.nextDouble();
		
		Account conta = new Account(num, titular, saldo, limite);
		
		System.out.println("\nDigite o valor a ser sacado: ");
		double valorSaque = sc.nextDouble();
		conta.withdraw(valorSaque);
		System.out.println("Novo saldo: " + conta.getBalance());
		
		} catch (DomainException e) {
			System.out.println("Erro: " + e.getMessage());
			
		} catch (RuntimeException e) {
			System.out.println("Erro inesperado.");
		}
		
		sc.close();

	}

}
