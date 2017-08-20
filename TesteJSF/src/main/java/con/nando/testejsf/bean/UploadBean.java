package con.nando.testejsf.bean;

import java.io.IOException;
import java.util.Scanner;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

@Named(value="uploadBean")
@RequestScoped
public class UploadBean {
	
	private Long id;
	private String descricao;

	private Part arquivo;
	
	
	@SuppressWarnings({ "unused", "resource" })
	public void importa() {
		String conteudo = "";
        try {
            conteudo = new Scanner(arquivo.getInputStream()).useDelimiter("\\A").next();
            String nome = arquivo.getSubmittedFileName();
            String tipo = arquivo.getContentType();
            long tamanho = arquivo.getSize();
            System.out.println("===============  Printing Result... ==============");
            System.out.println("Nome: "+nome+ "\nTipo: "+tipo+"\nTamanho: "+tamanho);
            System.out.println("======================== END =====================");
        } catch (IOException e) {
            System.out.println("Erro no carregamento do arquivo.");
        }
    }

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Part getArquivo() {
		return arquivo;
	}
	public void setArquivo(Part arquivo) {
		this.arquivo = arquivo;
	}
	
	
}
