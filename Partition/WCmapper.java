import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WCmapper extends Mapper<Object, Text, Text, Text>{
	Text gender = new Text();
	
	public void map(Object Key, Text value, Context context) throws IOException, InterruptedException{
		StringTokenizer str = new StringTokenizer(value.toString());
		
		str.nextToken();
		str.nextToken();
		String gen = str.nextToken();
		gender.set(gen);
		context.write(gender, value);
		
	}

}
