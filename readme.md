Prerequisites :

    Java 8, Maven

Clone the project from the following git:

    https://github.com/sathishk2connect/TransactionAnalyser

To Run the junit tests :

    mvn clean test

To Run the java class:

    mvn exec:java -Dexec.mainClass="com.transactionanalyser.executor.TransactionAnalyser" -Dexec.args="'<file_path>' '<from_date>' '<to_date>' '<merchant>'"




