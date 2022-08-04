package br.com.projectFinal;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nomeArq = "\\Users\\bezer\\OneDrive\\Desktop\\arq.txt";
		String linha = "";
		BufferedReader arquivo = null;
		
		try {
			arquivo = new BufferedReader(new FileReader(nomeArq));
			while(arquivo.ready()) {
				linha = arquivo.readLine();
				System.out.println(linha);
			}
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());	
		} catch (IOException e){
			System.out.println(e.getMessage());
		} finally {
			try {
				arquivo.close();
			}catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
		File f = new File(nomeArq);
		try {
			FileOutputStream fos = new FileOutputStream(f);
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			String novaLinha = "\n";
			System.out.println("Digite um texto ($ para sair)");
			String texto = bf.readLine();
			while(!texto.equals("$")) {
				fos.write(texto.getBytes());
				fos.write(novaLinha.getBytes());
				texto = bf.readLine();
			}
			fos.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList lista = new ArrayList<Object>();
	}
	
}
