import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WCmapper extends Mapper<LongWritable, Text, Text, Text>{
	Text k = new Text();
	
	Text v = new Text();
	
	public void map(LongWritable Key, Text value, Context context) throws IOException, InterruptedException{
		String line = value.toString();
		StringTokenizer tokenizer = new StringTokenizer(line, " ");
		
		while(tokenizer.hasMoreTokens()) {
			
			String jiten = tokenizer.nextToken();
			k.set(jiten);
			
			String jiten1 = tokenizer.nextToken();
			v.set(jiten1);
			
			context.write(k, v);
		}									
	}

}
