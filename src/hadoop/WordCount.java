package hadoop;
import java.io.IOException;  
import java.util.StringTokenizer;  
import org.apache.hadoop.fs.Path;  
import org.apache.hadoop.io.IntWritable;  
import org.apache.hadoop.io.Text;  
import org.apache.hadoop.mapreduce.Job;  
import org.apache.hadoop.mapreduce.Mapper;  
import org.apache.hadoop.mapreduce.Reducer;  
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;  
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCount {
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {  
        Job job = Job.getInstance();  
        job.setJobName("WordCount");  
        job.setJarByClass(WordCount.class);  
        job.setMapperClass(doMapper.class);  
        job.setReducerClass(doReducer.class);  
        job.setOutputKeyClass(Text.class);  
        job.setOutputValueClass(IntWritable.class);  
        Path in = new Path("hdfs://192.168.92.128:8020/user/badou/keys");  
        Path out = new Path("hdfs://192.168.92.128:8020/user/badou/test2");  
        FileInputFormat.addInputPath(job, in);  
        FileOutputFormat.setOutputPath(job, out);  
        System.exit(job.waitForCompletion(true) ? 0 : 1);  
    }  

}
