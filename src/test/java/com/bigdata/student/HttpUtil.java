package com.bigdata.student;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpUtil {


    //get请求
    public static String doGet(String url){


        try {
            HttpClient client = new DefaultHttpClient();

            //发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
            //请求发送成功,并且获得响应
            if(response.getStatusLine().getStatusCode()==HttpStatus.SC_OK){

                //读取返回的json字符串数据
                String strResult = EntityUtils.toString(response.getEntity());
                return strResult;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    //post请求
    public static String doPost(String url,Map params){

        BufferedReader br=null;
        try {
            //定义HttpClient对象
            HttpClient client=new DefaultHttpClient();

            //实例方法
            HttpPost request = new HttpPost();
            request.setURI(new URI(url));

            //设置参数
            List<NameValuePair> nvps = new ArrayList<>();
            for(Iterator iter =params.keySet().iterator();iter.hasNext();){
                String name =(String) iter.next();
                String value= String.valueOf(params.get(name));
                nvps.add(new BasicNameValuePair(name,value));

            }
            request.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));



            //请求服务器
            HttpResponse response = client.execute(request);
            //获得请求后服务器返回的代码
            int code =response.getStatusLine().getStatusCode();

            if(code==HttpStatus.SC_OK){

                //200就是上面的HttpStatus.SC_OK

                //获得输入流
                br = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "utf-8"));

                //创建字符串缓冲区
                StringBuffer sb = new StringBuffer("");
                String line=null;
                String NL =System.getProperty("line.separartor");

                while ((line=br.readLine())!=null){
                    sb.append(line+NL);
                }
                br.close();
                return sb.toString();

            }else{
                System.out.println("状态码"+code);
                return  null;
            }


        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return  null;

    }












}




