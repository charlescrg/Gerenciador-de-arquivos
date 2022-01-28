package aplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Produto;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Produto> list = new ArrayList<>();
		
		System.out.println("Informe o caminho do arquivo:");
		String caminho = sc.next();
		
		
		File arquivo = new File(caminho);
		String pasta = arquivo.getParent();
		boolean success = new File(pasta + "\\out").mkdir();
		String novoarquivo = pasta + "\\out\\resumo.csv";
		
		try (BufferedReader br = new BufferedReader(new FileReader(caminho))){
			String line = br.readLine();
			
			while(line != null) {
				String[] campos = line.split(",");
				String nome = campos[0];
				double valor = Double.parseDouble(campos[1]);
				int qtd = Integer.parseInt(campos[2]);
				list.add(new Produto(nome,qtd,valor));
				line = br.readLine();
			}
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(novoarquivo))){
				for (Produto item : list) {
					bw.write(item.getNome() + "," + String.format("%.2f", item.total()));
					bw.newLine();
					
				}
				System.out.println(novoarquivo + " CRIADO!");
			}
			catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
			
			
		
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();

	}

}
