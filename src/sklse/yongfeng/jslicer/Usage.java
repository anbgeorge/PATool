package sklse.yongfeng.jslicer;

import java.util.List;

public class Usage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**STEP 1. java -javaagent:assembly/tracer.jar=tracefile:test.trace -jar evaluation/dacapo-2006-10-MR2.jar*/
		/**STEP 1. java -javaagent:... -cp bin/classes:resources my.package.ClassName*/
		/**STEP 1. java -javaagent:... org.junit.runner.JUnitCore <test class name>*/
		
		sliceMethod();
//		sliceTestCase();
		
	}
	
	public static void sliceMethod(){
		/**STEP 1. generating trace*/
//		CmdRunner cmd1 = new CmdRunner("java -javaagent:libs/tracer.jar=tracefile:hello.trace -cp bin/ sklse.yongfeng.jslicer.Hello");
//		
//		/**STEP 2. slicing program*/
//		CmdRunner cmd2 = new CmdRunner("java -Xmx2g -jar libs/slicer.jar -p hello.trace sklse.yongfeng.jslicer.Hello.MaximumDivisor:30:*");
////		System.out.println(cmd2.getResults("Hello"));
//		showList(cmd2.getResults("Hello"));
		
		Jslicer js = new Jslicer("sklse.yongfeng.jslicer.Hello","MaximumDivisor",30);
		showList(js.getMethodResults("sklse.yongfeng.jslicer.Hello"));
	}
	
	public static void sliceTestCase(){
		/**STEP 1. generating trace*/
		CmdRunner cmd1 = new CmdRunner("java -javaagent:libs/tracer.jar=tracefile:test.trace -cp bin:libs/hamcrest-all-1.3.jar:libs/junit-4.12.jar: org.junit.runner.JUnitCore sklse.yongfeng.juint.CalculatorTest");
		
		/**STEP 2. slicing program*/
		CmdRunner cmd2 = new CmdRunner("java -Xmx2g -jar libs/slicer.jar -p test.trace sklse.yongfeng.juint.CalculatorTest.testDivide3:78:*");
		System.out.println(cmd2.getResults("CalculatorTest"));
	}
	
	public static void showList(List<?> ls){
		for(Object ols:ls){
			System.out.println(ols.toString());
		}
	}

}
