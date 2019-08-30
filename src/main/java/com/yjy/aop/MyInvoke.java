package com.yjy.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.InvokeHandler;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;

import com.yjy.annotation.ExParam;
import com.yjy.annotation.ExSelect;

public class MyInvoke implements InvocationHandler {
	private Object object;
	
	 MyInvoke(Object object) {
		this.object=object;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("开始执行动态代理");
		ExSelect exSelect = method.getDeclaredAnnotation(ExSelect.class);
		if(exSelect==null) {
			return null;
		}
		String value = exSelect.value();
		Parameter[] parameters = method.getParameters();
		Map<String,String> paramMap=new HashMap<String,String>();
		for(int i=0;i<parameters.length;i++) {
			ExParam exParam = parameters[i].getAnnotation(ExParam.class);
			if(exParam==null) {
				continue;
			}
			paramMap.put(exParam.value(), (String)args[i]);
		}
		System.out.println("待执行的sql为："+value+" 参数为paramMap："+paramMap);
		
		return null;
	}


}
