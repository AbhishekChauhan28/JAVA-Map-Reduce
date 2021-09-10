import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WCreducer extends Reducer<IntWritable, Text, IntWritable, IntWritable>{
	@SuppressWarnings("unused")
	public void reduce(IntWritable Key, Iterable<Text> values, Context context) throws IOException, InterruptedException{
		int sum = 0;
		
		for(Text x : values) {
			sum++;
		}
		
		context.write(Key, new IntWritable(sum));
		
	}
	

}
