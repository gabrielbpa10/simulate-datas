package br.com.simulatedatas.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.simulatedatas.controller.ResultLines;
import br.com.simulatedatas.dao.ReaderResults;
import br.com.simulatedatas.enuns.StudantColumnName;
import br.com.simulatedatas.model.Result;

public class Tests {

	@Test
	public void readerDatas() {
		ReaderResults reader = new ReaderResults("C:\\Users\\Usuario\\eclipse-workspace\\SimulateDatas\\target\\datas\\studants-base.txt");
		reader.create_base();
		ResultLines resultLines = reader.get_result_lines();
		resultLines.print();
	}
	
	@Test
	public void containValue() {
		ReaderResults reader = new ReaderResults("C:\\Users\\Usuario\\eclipse-workspace\\SimulateDatas\\target\\datas\\studants-base.txt");
		reader.create_base();
		ResultLines resultLines = reader.get_result_lines();
		
		boolean status = resultLines.contain_value("ROBERTO SOUSA SANTOS");
		System.out.println(status);
	}
	
	@Test
	public void filterDatasForValue() {
		ReaderResults reader = new ReaderResults("C:\\Users\\Usuario\\eclipse-workspace\\SimulateDatas\\target\\datas\\studants-base.txt");
		reader.create_base();
		ResultLines resultLines = reader.get_result_lines();
		
		List<Result> list = resultLines.filter_datas_for_value("MARIA R B");
		String value = (String) list.get(0).get_hash_map().get("NAME_MOM");
		System.out.println(value);
	}
	
	@Test
	public void compareLists() {
		ReaderResults reader = new ReaderResults("C:\\Users\\Usuario\\eclipse-workspace\\SimulateDatas\\target\\datas\\studants-base.txt");
		reader.create_base();
		ResultLines resultLines = reader.get_result_lines();
		
		ReaderResults reader2 = new ReaderResults("C:\\Users\\Usuario\\eclipse-workspace\\SimulateDatas\\target\\datas\\dengue-base.txt");
		reader2.create_base();
		ResultLines resultLines2 = reader2.get_result_lines();
		
		ArrayList<Result> list = resultLines.contain_value_list(resultLines2.getResultLines(),StudantColumnName.NAME.name());
		list.forEach(System.out::println);
	}
}
