package hadoop;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.Reducer;

public class doReducer extends Reducer<Text, IntWritable, Text, IntWritable>{  
    //参数同Map一样，依次表示是输入键类型，输入值类型，输出键类型，输出值类型  
    private IntWritable result = new IntWritable();  
            @Override  
            protected void reduce(Text key, Iterable<IntWritable> values, Context context)  
        throws IOException, InterruptedException {  
        int sum = 0;  
        for (IntWritable value : values) {  
        sum += value.get();  
        }  
        //for循环遍历，将得到的values值累加  
        result.set(sum);  
        context.write(key, result);  
        }  
        } 
