import java.util.StringTokenizer;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class WCpartitioner extends Partitioner<Text, Text>{
	public int getPartition(Text Key, Text value, int numReduceTasks) {
		StringTokenizer str = new StringTokenizer(value.toString());
		
		str.nextToken();
		int age = Integer.parseInt(str.nextToken());
		
		if(age < 20) {
			return 0;
		}
		else {
			if(age > 20 && age < 50) {
				return 1 % numReduceTasks;
			}
			else {
				return 2 % numReduceTasks;
			}
		}
	}

}
