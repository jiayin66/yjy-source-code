package com.yjy.aop;

import java.lang.reflect.Proxy;

public class SqlSession {
	public static <T> T getSession(Class clas) {
		return (T) Proxy.newProxyInstance(clas.getClassLoader(), new Class[] {clas}, new MyInvoke(clas));
	}
}
