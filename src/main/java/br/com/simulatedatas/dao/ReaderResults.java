package br.com.simulatedatas.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import br.com.simulatedatas.controller.ResultLines;
import br.com.simulatedatas.model.Result;

public class ReaderResults {

	private String path;
	private ResultLines resultLines = null;
	
	public ReaderResults(String path) {
		this.path = path;
	}
	
	public void create_base() {
		FileReader fileReader = null;
		BufferedReader bufferReader = null;
		String values = "";
		
		try {
		
			fileReader = new FileReader(this.path);
			bufferReader = new BufferedReader(fileReader);
		
		} catch (FileNotFoundException e) {
			System.out.println("Caminho não encontrado.");
			e.printStackTrace();
		}
		
		
		try {
			String vectorColumns [] = bufferReader.lines().findFirst().get().split(";");
			resultLines = new ResultLines();
			resultLines.set_result_columns(vectorColumns);
			
			while((values = bufferReader.readLine()) != null) {
				String vectorLines [] = values.split(";");
				int index = 0;
				Result result = new Result();
				
				while(index < vectorColumns.length) {
					result.set_hash_map(vectorColumns[index],vectorLines[index]);
					index ++;
				}
				
				resultLines.set_result_lines(result);
			}
			
			fileReader.close();
		} catch (IOException e) {
			System.out.println("Arquivo não lido.");
			e.printStackTrace();
		}
	}
	
	public ResultLines get_result_lines(){
		return this.resultLines;
	}
}
