import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WCmapper extends Mapper<LongWritable, Text, IntWritable, Text>{
	private static IntWritable count;
	private Text word = new Text();
	
	public void map(LongWritable Key, Text value, Context context) throws IOException, InterruptedException {
		String line = value.toString();
		StringTokenizer tokenizer = new StringTokenizer(line);
		
		while(tokenizer.hasMoreTokens()) {
			String thish = tokenizer.nextToken();
			count = new IntWritable(thish.length());
			word.set(thish);
			
			context.write(count,word);
		}
	}

}
