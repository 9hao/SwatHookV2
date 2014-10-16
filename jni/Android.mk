LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := SwatHookV2		
LOCAL_LDLIBS	:= -ldvm.4 -llog -landroid_runtime
LOCAL_CFLAGS	:= -DDEBUG
LOCAL_SRC_FILES := \
					hookutils.cpp \
					DalvikMethodHook.cpp \
					JavaMethodHook.cpp

include $(BUILD_SHARED_LIBRARY)
