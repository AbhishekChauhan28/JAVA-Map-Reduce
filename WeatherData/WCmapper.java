import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapreduce.Mapper;

public class WCmapper extends Mapper<LongWritable, Text, Text, Text>{
	public void map(LongWritable arg0, Text value, OutputCollector<Text, Text>output, Reporter arg3) throws IOException{
		String line = value.toString();
		
		String date = line.substring(6, 14);
		
		float temp_max = Float.parseFloat(line.substring(39,45).trim());
		
		float temp_min = Float.parseFloat(line.substring(47,53).trim());
		
		if(temp_max > 30.0) {
			output.collect(new Text("Hot Day " + date), new Text(String.valueOf(temp_max)));
		}
		
		if(temp_min < 10.0) {
			output.collect(new Text("Cold Day" + date), new Text(String.valueOf(temp_min)));
		}
		
		
	}

}
