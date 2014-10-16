/*
 * JavaMethodHook.h
 *
 *  Created on: 2014-9-18
 *      Author: boyliang
 */

#ifndef __JAVA_METHOD_HOOK__H__
#define __JAVA_METHOD_HOOK__H__

#include <jni.h>
#include <stddef.h>
#include <object.h>
#include <elf.h>

struct HookInfo {
	char *classDesc;
	char *methodName;
	char *methodSig;

	bool isStaticMethod;
	void *originalMethod;
	void *returnType;
	void *paramTypes;
	void *callback;
};

int java_method_hook(JNIEnv* env, HookInfo *info,jobject callback);

#endif //end of __JAVA_METHOD_HOOK__H__
