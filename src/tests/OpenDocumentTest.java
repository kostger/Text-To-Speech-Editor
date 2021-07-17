package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Document;

class OpenDocumentTest {
	
	Document test = new Document();
	private String testPath;
	private String content;
	
	@Test
	void test() {
		String path = System.getProperty("user.dir").toString();
		String word_test_string = "This is a test file.\n\n";
		String excel_test_string = "This\tis\ta\ttest\tfile.\t";
		
		testPath = path + "\\tests\\test1.docx";
		test.setPar(testPath,"None");
		test.open();
		content = test.getContent();
		if(!content.equals(word_test_string)) {
			fail("Failed opening Word with Default encoding");	
		}
		
		testPath = path + "\\tests\\test2.xlsx";
		test.setPar(testPath,"None");
		test.open();
		content = test.getContent();
		if(!content.equals(excel_test_string)) {
			fail("Failed opening Excel with Default encoding");	
		}
		
		
		testPath = path + "\\tests\\test3.docx";
		test.setPar(testPath,"Atbash");
		test.open();
		content = test.getContent();
		if(!content.equals(word_test_string)) {
			fail("Failed opening Word with Atbash encoding");	
		}
		
		testPath = path + "\\tests\\test4.xlsx";
		test.setPar(testPath,"Atbash");
		test.open();
		content = test.getContent();
		if(!content.equals(excel_test_string)) {
			fail("Failed opening Excel with Atbash encoding");	
		}
		
		testPath = path + "\\tests\\test5.docx";
		test.setPar(testPath,"Rot-13");
		test.open();
		content = test.getContent();
		if(!content.equals(word_test_string)) {
			fail("Failed opening Word with Rot-13 encoding");	
		}
		
		testPath = path + "\\tests\\test6.xlsx";
		test.setPar(testPath,"Rot-13");
		test.open();
		content = test.getContent();
		if(!content.equals(excel_test_string)) {
			fail("Failed opening Excel with Default encoding");	
		}
		
	}
}
