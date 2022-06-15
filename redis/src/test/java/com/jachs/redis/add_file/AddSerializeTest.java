package com.jachs.redis.add_file;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import org.junit.Test;

import com.jachs.redis.RedisConfiger;
import com.jachs.redis.entity.People;

import redis.clients.jedis.Jedis;

/***
 * 对象序列化
 *  @author zhanchaohan<br>
 */
public class AddSerializeTest {
	Jedis jedis = new RedisConfiger().init();

	private static final String KEY="SerialName";
	
	/***
	 * 序列化
	 * @throws IOException 
	 */
	@Test
	public void test1() throws Exception {
		People peo=new People();
		
		peo.setName("kkkk");
		peo.setAge(30);
		
		
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		
		ObjectOutput os=new ObjectOutputStream(baos);
		os.writeObject(peo);
		
		jedis.set(KEY.getBytes(), baos.toByteArray());
	}
	/***
	 * 反序列化
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception{
		ByteArrayInputStream bais=new ByteArrayInputStream(jedis.get(KEY.getBytes()));
		
		ObjectInput is=new ObjectInputStream(bais);
		
		People peo=(People) is.readObject();
		
		System.out.println(peo.getName()+"\t"+peo.getAge());
	}
}
