import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WCreducer extends Reducer<Text, Text, Text, IntWritable>{
	private final IntWritable max_salary = new IntWritable();
	private final Text record = new Text();
	
	public void reduce(Text Key, Iterable<Text>values, Context context) throws IOException, InterruptedException{
		int max = 0;
		
		for(Text val : values) {
			String rec = val.toString();
			StringTokenizer str = new StringTokenizer(val.toString());
			
			str.nextToken();
			str.nextToken();
			str.nextToken();
			
			int salary = Integer.parseInt(str.nextToken());
			
			if(salary > max) {
				max = salary;
			    record.set(rec);
			}
		}
		max_salary.set(max);
		context.write(record, max_salary);
	}

}
