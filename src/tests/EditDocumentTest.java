package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Document;

class EditDocumentTest {

	Document test = new Document();
	private String path;
	private String test_string;
	private String content;
	
	@Test
	void test() {
		
		path = System.getProperty("user.dir").toString() + "\\tests\\test1.docx";
		test_string = "This is a test file.\n\n //(edited)";
		
		test.setPar(path,"None");
		test.open();
		test.setEditable();
		test.setEditedContent();
		content = test.getEditedContent();
		if(!content.equals(test_string)) {
			fail("Failure.");
		}
		
	}

	
}
