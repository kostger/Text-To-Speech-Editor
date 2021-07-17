package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Document;

class SaveDocumentTest {
	
	Document test = new Document();
	private String testPath;
	private String contentSaved;
	private String contentOpened;
	
	@Test
	void test() {
		String path = System.getProperty("user.dir").toString();
		String word_test_string = "This is a test file.\n\n";
		String excel_test_string = "This\tis\ta\ttest\tfile.\t";
		
		testPath = path + "\\tests\\test7.docx";
		test.setPar(testPath, "None");
		test.setMyTextArea(word_test_string);
		test.save();
		contentSaved = test.getContent();
		test.open();
		contentOpened = test.getContent();
		if(!contentOpened.equals(contentSaved)) {
			fail("Failed saving Word with Default encoding");
		}
		
		testPath = path + "\\tests\\test8.xlsx";
		test.setPar(testPath, "None");
		test.setMyTextArea(excel_test_string);
		test.save();
		contentSaved = test.getContent();
		test.open();
		contentOpened = test.getContent();
		if(!contentOpened.equals(contentSaved)) {
			fail("Failed saving Excel with Default encoding");
		}
		
		testPath = path + "\\tests\\test9.docx";
		test.setPar(testPath, "Atbash");
		test.setMyTextArea(word_test_string);
		test.save();
		contentSaved = test.getContent();
		test.open();
		contentOpened = test.getContent();
		if(!contentOpened.equals(contentSaved)) {
			fail("Failed saving Word with Atbash encoding");
		}
		
		testPath = path + "\\tests\\test10.xlsx";
		test.setPar(testPath, "Atbash");
		test.setMyTextArea(excel_test_string);
		test.save();
		contentSaved = test.getContent();
		test.open();
		contentOpened = test.getContent();
		if(!contentOpened.equals(contentSaved)) {
			fail("Failed saving Excel with Atbash encoding");
		}
		
		testPath = path + "\\tests\\test11.docx";
		test.setPar(testPath, "Rot-13");
		test.setMyTextArea(word_test_string);
		test.save();
		contentSaved = test.getContent();
		test.open();
		contentOpened = test.getContent();
		if(!contentOpened.equals(contentSaved)) {
			fail("Failed saving Word with Rot-13 encoding");
		}
		
		testPath = path + "\\tests\\test12.xlsx";
		test.setPar(testPath, "Rot-13");
		test.setMyTextArea(excel_test_string);
		test.save();
		contentSaved = test.getContent();
		test.open();
		contentOpened = test.getContent();
		if(!contentOpened.equals(contentSaved)) {
			fail("Failed saving Excel with Rot-13 encoding");
		}
	}
}

