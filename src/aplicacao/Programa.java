package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> apuracao = new LinkedHashMap<>();
		
		System.out.print("Informe o diretório do arquivo: ");
		
		String diretorio = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(diretorio))){
			
			String linha = br.readLine();
			
			while (linha != null) {
				String[] campos = linha.split(",");
				String nome = campos[0];
				int contadorVotos = Integer.parseInt(campos[1]);
				
				if (apuracao.containsKey(nome)) {
					int votosAcumulados = apuracao.get(nome);
					apuracao.put(nome, contadorVotos + votosAcumulados);
				}
				else {
					apuracao.put(nome, contadorVotos);
				}
				
				linha = br.readLine();
			}
			
			for (String chave : apuracao.keySet()) {
				System.out.println(chave + ": " + apuracao.get(chave));
			}
			
		} 
		catch (IOException e) {
			System.out.println("Erro ao ler arquivo de entrada: " + e.getMessage());
		}
		finally {
			sc.close();
		}
	}
}
