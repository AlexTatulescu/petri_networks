package ace.ucv.main;

import ace.ucv.reader_writer_problem.ReadWrite;

public class RunReadWrite {

	public static void main(String[] args) {

		ReadWrite readWrite = new ReadWrite();

		readWrite.execute("startReading");
		readWrite.execute("endReading");
		readWrite.execute("startWriting");
		readWrite.execute("endWriting");
	}

}
