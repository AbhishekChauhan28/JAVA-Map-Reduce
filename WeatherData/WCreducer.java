import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapreduce.Reducer;

public class WCreducer extends Reducer<Text, Text, Text, Text>{
	public void reduce(Text Key, Iterator<Text>values, OutputCollector<Text, Text>output, Reporter arg3) throws IOException {
		
		String temperature = values.next().toString();
		
		output.collect(Key, new Text(temperature));
	}

}
