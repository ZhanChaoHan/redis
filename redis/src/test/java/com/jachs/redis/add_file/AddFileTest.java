package com.jachs.redis.add_file;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import org.junit.Test;

import com.jachs.redis.RedisConfiger;
import com.jachs.redis.entity.People;

import redis.clients.jedis.Jedis;

/***
 * 文件
 *  @author zhanchaohan<br>
 */
public class AddFileTest {
	Jedis jedis = new RedisConfiger().init();

	private static final String KEY="FileName";
	
	/***
	 * 上传文件二进制
	 * @throws IOException 
	 */
	@Test
	public void test1() throws Exception {
		InputStream is=new FileInputStream("E:\\Java\\THIRDPARTYLICENSEREADME.txt");
		
		byte []bs=new byte[is.available()];
		is.read(bs);
		
		jedis.set(KEY.getBytes(),bs);
		
		is.close();
	}
	/***
	 * 读取二进制到本地
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception{
		OutputStream os=new FileOutputStream("E:\\Java\\copy.txt");
		
		os.write(jedis.get(KEY.getBytes()));
		
		os.close();
	}
}
