package br.com.prova.aplication;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.google.common.io.Files;

import br.com.prova.test.RegisterGmailTests;

public class TestAplication {
	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(RegisterGmailTests.class);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

		try (FileWriter writer = new FileWriter("target/" + sdf.format(new Date()) + ".txt");
				BufferedWriter bw = new BufferedWriter(writer)) {
			bw.write("### Executados ###");
			bw.newLine();
			bw.write("Total executado: " + result.getRunCount());
			bw.newLine();
			if (result.getFailureCount() > 0) {
				bw.write("### Falhas ### ");
				bw.newLine();
				bw.write("Total de falhas: " + result.getFailureCount());
				bw.newLine();
			}
			for (Failure failure : result.getFailures()) {
				bw.write(failure.toString());
				bw.newLine();
			}
			bw.write("### Suite ###");
			bw.newLine();
			bw.write("Resultado final: " + result.wasSuccessful());

		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}

	}
}
