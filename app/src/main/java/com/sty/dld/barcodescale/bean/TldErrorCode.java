package com.sty.dld.barcodescale.bean;

import com.mt.rt.aoapi.AOScale;

/**
 * @Author: tian
 * @UpdateDate: 2020/9/23 10:42 AM
 */
public class TldErrorCode {

    public static String getErrorMsg(int errorCode) {
        switch (errorCode) {
            case AOScale.EVT_COMM_TRANSMITION_BEGIN:
                //开始向一台电子秤写入数据
                return ""; //日志信息，非错误信息
            case AOScale.EVT_COMM_TRANSMITION_END:
                //结束向一台电子秤写入数据
                return ""; //日志信息，非错误信息
            case AOScale.EVT_COMM_WAITE_ALL_END:
                //向所有电子秤的写入均已结束
                //调用如下函数获取所有的结果
                return ""; //日志信息，非错误信息
            case AOScale.EVT_COMM_WAITE_DATA_TOOLONG:
                //待传输的数据太多，应减少后重试
                return "待传输的数据太多，应减少后重试";
            case AOScale.EVT_COMM_SCALE_REPORT_ERROR:
                //电子秤回应错误
                return "电子秤回应错误";
            case AOScale.EVT_COMM_SENDDATA_SECCESS:
                //成功向电子秤写入数据
                return "成功向电子秤写入数据";
            case AOScale.EVT_COMM_SENDDATA_EXCEPTION:
                //向电子秤吸入数据时出错（捕获到异常），可以检查日志查找错误原因
                return"向电子秤吸入数据时出错（捕获到异常），可以检查日志查找错误原因";
            case AOScale.EVT_COMM_RECVDATA_UNCOMPLETE:
                //读取到的电子秤响应数据不完整
                return "读取到的电子秤响应数据不完整";
            case AOScale.EVT_COMM_RECVDATA_UNKNOWN:
                //读取到的电子秤响应数据不可识别
                return"读取到的电子秤响应数据不可识别";
            case AOScale.EVT_COMM_RECVDATA_EXCEPTION:
                //读取电子秤响应数据时出错（捕获到异常）,可以检查日志查找错误原因
                return"读取电子秤响应数据时出错（捕获到异常）,可以检查日志查找错误原因";
            case AOScale.EVT_COMM_RECVDATA_TIMEOUT:
                //读取电子秤响应数据时超时
                return "读取电子秤响应数据时超时";
            case AOScale.EVT_SOCKET_OPEN_FAILED:
                //初始化和电子秤的连接失败
                return"初始化和电子秤的连接失败";
            case AOScale.EVT_SOCKET_CONNECT_FAILED:
                //连接电子秤失败
                return "连接电子秤失败";
            case AOScale.EVT_SOCKET_CONNECT_EXCEPTION:
                //连接到电子秤时出错（捕获到异常），可以检查日志查找错误原因
                return "连接到电子秤时出错（捕获到异常），可以检查日志查找错误原因";
            case AOScale.EVT_SOCKET_DISCONNECT_EXCEPTION:
                //断开和电子秤的连接时出错（捕获到异常），可以检查日志查找错误原因
                return "断开和电子秤的连接时出错（捕获到异常），可以检查日志查找错误原因";
            case AOScale.EVT_PARSE_JSON_EXCEPTION:
                //解析传入的JSON数据时出错，可以检查日志查找错误原因
                return "解析传入的JSON数据时出错，可以检查日志查找错误原因";
            case AOScale.EVT_GENERAL_EXCEPTION:
                //捕获到其他异常，可检查日志查找错误原因
                return "捕获到其他异常，可检查日志查找错误原因";
            case AOScale.EVT_SCALE_COUNT_IS_FULL:
                //同时传输的电子秤太多，应减少参数中的电子秤数量后重试
                return "同时传输的电子秤太多，应减少参数中的电子秤数量后重试";
            default:
                return "未知错误";
        }
    }
 }
