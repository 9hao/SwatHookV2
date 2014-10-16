package com.swathookv2;

import java.lang.reflect.Method;

import com.swathook.HookUtils;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private String getString(int a, String b){
		return a + "str: " + b;
	}
	
	private String getString2(String... str1){
		return str1[0] + " " + str1[1];
	}
	
	private  static String getString3(int a, String b){
		return a + "str: " + b;
	}
	
	private  String getString4(int a, String b){
		return a + "str: " + b;
	}
	

	private static String getString5(Method m){
		return m.getName();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        final Button  button = new Button(this);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				button.setText(new HookUtils().stringFromJNI());
			}
		});
        button.setText(new HookUtils().stringFromJNI());
        setContentView(button);
        
     // ԭʼ������ϵͳ���ͻ�ϲ���
     		Log.i("TTT", "before1: " + getString(0, "a"));
     		Method method;
     		try {
     			method = MainActivity.class.getDeclaredMethod("getString", int.class, String.class);
     			HookUtils.hookMethod2(method, "(ILjava/lang/String;)Ljava/lang/String;");
     		} catch (NoSuchMethodException e) {
     			e.printStackTrace();
     		}
     		Log.i("TTT", "after1: " + getString(1, "a"));
//     		
     		// �ɱ����Ͳ���
     		Log.i("TTT", "before2: " + getString2("aa", "bb"));
     		try {
     			method = MainActivity.class.getDeclaredMethod("getString2", String[].class);
     			HookUtils.hookMethod2(method, "([Ljava/lang/String;)Ljava/lang/String;");
     		} catch (NoSuchMethodException e) {
     			e.printStackTrace();
     		}
     		Log.i("TTT", "after2: " + getString2("aa", "bb"));
		
     		Log.i("TTT", "before3: " + getString3(3, "bb"));
     		try {
     			method = MainActivity.class.getDeclaredMethod("getString3", int.class, String.class);
     			HookUtils.hookMethod2(method, "(ILjava/lang/String;)Ljava/lang/String;");
     		} catch (NoSuchMethodException e) {
     			e.printStackTrace();
     		}
     		Log.i("TTT", "after3: " + getString3(3, "bb"));
     		
     		Log.i("TTT", "before4: " + getString4(0, "a"));
     		try {
     			method = MainActivity.class.getDeclaredMethod("getString4", int.class, String.class);
     			HookUtils.hookMethod(method, "(ILjava/lang/String;)Ljava/lang/String;");
     		} catch (NoSuchMethodException e) {
     			e.printStackTrace();
     		}
     		Log.i("TTT", "after4: " + getString4(0, "a"));
     		
     		
     		
     		Log.i("TTT", "before5: ");
     		try {
     			method = MainActivity.class.getDeclaredMethod("getString5",Method.class);
     			HookUtils.hookMethod(method, "(Ljava/lang/reflect/Method;)Ljava/lang/String;");
     			Log.i("TTT", "after5: " + getString5(method));
     		} catch (NoSuchMethodException e) {
     			e.printStackTrace();
     		}
	}


}
