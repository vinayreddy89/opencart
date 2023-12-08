package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Hashtable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

public class TestDataProviders {

	// read jsondata
	public static Object[][] getTestData(File jsonfilepath, String testCaseName) {
		Gson gson = new GsonBuilder().create();
		JsonObject job = null;
		try {
			job = gson.fromJson(new FileReader(jsonfilepath), JsonObject.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		JsonElement cate = job.getAsJsonArray(testCaseName);
		int trows = job.getAsJsonArray(testCaseName).size();
		System.out.println("Row 1: " + job.getAsJsonArray(testCaseName).get(0));
		System.out.println("Total Rows: " + trows);

		Hashtable<String, String> table = null;
		int index = 0;
		Object data[][] = new Object[trows][1];

		System.out.println(
				"============================================================================================================================");
		table = new Hashtable<String, String>();
		for (int rowNum = 0; rowNum < trows; rowNum++) {
			JsonElement rowdata = job.getAsJsonArray(testCaseName).get(rowNum);
			String values = rowdata.toString().substring(1, rowdata.toString().length() - 1);
			String[] splitvalues = values.split("\",");
			int tcols = splitvalues.length;
			System.out.println("Total Columns: " + splitvalues.length);
			table = new Hashtable<String, String>();
			for (int c = 0; c < splitvalues.length; c++) {
				if (c < splitvalues.length - 1) {
					table.put(splitvalues[c].split("\":")[0].substring(1, splitvalues[c].split("\":")[0].length()),
							splitvalues[c].split("\":")[1].substring(1, splitvalues[c].split("\":")[1].length()));
					// System.out.println(splitvalues[c].split(":")[0].substring(1,
					// splitvalues[c].split(":")[0].length()-1)+"=="+splitvalues[c].split(":")[1].substring(1,
					// splitvalues[c].split(":")[1].length()));
					System.out.println(splitvalues[c].split("\":")[0].substring(1,
							splitvalues[c].split("\":")[0].length()) + "=="
							+ splitvalues[c].split("\":")[1].substring(1, splitvalues[c].split("\":")[1].length()));
				} else {
					table.put(splitvalues[c].split("\":")[0].substring(1, splitvalues[c].split("\":")[0].length()),
							splitvalues[c].split("\":")[1].substring(1, splitvalues[c].split("\":")[1].length() - 1));
					System.out.println(splitvalues[c].split("\":")[0].substring(1,
							splitvalues[c].split("\":")[0].length()) + "=="
							+ splitvalues[c].split("\":")[1].substring(1, splitvalues[c].split("\":")[1].length() - 1));
				}
			}
			System.out.println("Row Data: " + table);
			data[index][0] = table;
			index++;
			System.out.println();
		}
		System.out.println(
				"===========================================================================================================================");
		return data;
	}
}
