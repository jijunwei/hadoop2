package hadoop;

import java.io.IOException;
import java.util.StringTokenizer;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class doMapper extends Mapper<Object, Text, Text, IntWritable>{  
    //第一个Object表示输入key的类型；第二个Text表示输入value的类型；第三个Text表示表示输出键的类型；第四个IntWritable表示输出值的类型  
    public static final IntWritable one = new IntWritable(1);  
            public static Text word = new Text();  
            @Override  
            protected void map(Object key, Text value, Context context) throws IOException, InterruptedException  //抛出异常  
            {  
                StringTokenizer tokenizer = new StringTokenizer(value.toString(),"\t");  
              //StringTokenizer是Java工具包中的一个类，用于将字符串进行拆分  
               word.set(tokenizer.nextToken());  
                     //返回当前位置到下一个分隔符之间的字符串  
                    context.write(word, one);  
                     //将word存到容器中，记一个数  
              }
 }    
